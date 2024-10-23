import gov.nasa.jpf.ListenerAdapter;
import gov.nasa.jpf.vm.*;
import gov.nasa.jpf.vm.bytecode.InvokeInstruction;
import java.util.*;

public class MemoizationListener extends ListenerAdapter {
    // Cache structure: Method signature -> (HeapState -> Result)
    private final Map<String, Map<HeapState, Object>> cache = new HashMap<>();
    
    @Override
    public void executeInstruction(VM vm, ThreadInfo currentThread, Instruction instructionToExecute) {
        if (!(instructionToExecute instanceof InvokeInstruction)) {
            return;
        }

        InvokeInstruction invoke = (InvokeInstruction) instructionToExecute;
        MethodInfo method = invoke.getInvokedMethod();

        if (!method.isStatic() || !isPrimitiveReturn(method)) {
            return;
        }

        String methodSignature = getMethodSignature(method);
        
        StackFrame frame = currentThread.getTopFrame();
        Object[] args = getMethodArguments(frame, method);
        
        HeapState heapState = captureHeapState(vm, args);
        
        Map<HeapState, Object> methodCache = cache.computeIfAbsent(methodSignature, k -> new HashMap<>());
        
        if (methodCache.containsKey(heapState)) {
            returnCachedResult(vm, currentThread, methodCache.get(heapState));
            return;
        }
        
        executeAndCache(vm, currentThread, methodSignature, heapState, methodCache);
    }
    
    private boolean isPrimitiveReturn(MethodInfo method) {
        return method.getReturnTypeCode().length() == 1;
    }
    
    private String getMethodSignature(MethodInfo method) {
        return method.getFullName() + method.getSignature();
    }
    
    private Object[] getMethodArguments(StackFrame frame, MethodInfo method) {
        int nArgs = method.getNumberOfArguments();
        Object[] args = new Object[nArgs];
        
        for (int i = 0; i < nArgs; i++) {
            args[i] = frame.getOperandAtOffset(nArgs - 1 - i);
        }
        
        return args;
    }
    
    private HeapState captureHeapState(VM vm, Object[] args) {
        HeapState state = new HeapState();
        
        for (Object arg : args) {
            if (arg instanceof ElementInfo) { // Reference type
                captureObjectGraph(vm, (ElementInfo) arg, state);
            }
        }
        
        return state;
    }
    
    private void captureObjectGraph(VM vm, ElementInfo ei, HeapState state) {
        if (ei == null || state.visited.contains(ei.getObjectRef())) {
            return;
        }
        
        state.visited.add(ei.getObjectRef());
        state.objects.add(new ObjectState(ei));
        
        for (FieldInfo fi : ei.getClassInfo().getDeclaredInstanceFields()) {
            if (fi.isReference()) {
                ElementInfo referenced = vm.getHeap().get(ei.getReferenceField(fi));
                if (referenced != null) {
                    captureObjectGraph(vm, referenced, state);
                }
            }
        }
    }
    
    private void returnCachedResult(VM vm, ThreadInfo ti, Object result) {
        StackFrame frame = ti.getTopFrame();
        frame.setOperand(0, result);
        ti.skipInstruction();
    }
    
    private void executeAndCache(VM vm, ThreadInfo ti, String methodSignature, 
                               HeapState heapState, Map<HeapState, Object> methodCache) {
        vm.addPostExecutionHook(() -> {
            StackFrame frame = ti.getTopFrame();
            Object result = frame.getOperand();
            methodCache.put(heapState, result);
        });
    }
}

class HeapState {
    Set<Integer> visited = new HashSet<>();
    Set<ObjectState> objects = new HashSet<>();
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof HeapState)) return false;
        HeapState other = (HeapState) o;
        return objects.equals(other.objects);
    }
    
    @Override
    public int hashCode() {
        return objects.hashCode();
    }
}

class ObjectState {
    private final int typeId;
    private final Map<String, Object> fields;
    
    public ObjectState(ElementInfo ei) {
        this.typeId = ei.getClassInfo().getUniqueId();
        this.fields = new HashMap<>();
        
        for (FieldInfo fi : ei.getClassInfo().getDeclaredInstanceFields()) {
            if (!fi.isReference()) { // Only capture primitive fields
                String fieldName = fi.getName();
                Object value = getPrimitiveFieldValue(ei, fi);
                fields.put(fieldName, value);
            }
        }
    }
    
    private Object getPrimitiveFieldValue(ElementInfo ei, FieldInfo fi) {
        switch (fi.getType()) {
            case "boolean": return ei.getBooleanField(fi);
            case "byte": return ei.getByteField(fi);
            case "char": return ei.getCharField(fi);
            case "short": return ei.getShortField(fi);
            case "int": return ei.getIntField(fi);
            case "long": return ei.getLongField(fi);
            case "float": return ei.getFloatField(fi);
            case "double": return ei.getDoubleField(fi);
            default: throw new IllegalStateException("Unknown primitive type: " + fi.getType());
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ObjectState)) return false;
        ObjectState other = (ObjectState) o;
        return typeId == other.typeId && fields.equals(other.fields);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(typeId, fields);
    }
}
