import gov.nasa.jpf.ListenerAdapter;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.VM;
import gov.nasa.jpf.vm.ThreadInfo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class CoverageListener extends ListenerAdapter {
    private final Map<String, Set<Integer>> coverage;

    public CoverageListener() {
    }

    @Override
    public void instructionExecuted(VM vm, ThreadInfo currentThread, Instruction nextInstruction, Instruction executedInstruction) {
        String className = executedInstruction.getMethodInfo().getClassName();
        int lineNumber = executedInstruction.getLineNumber();

        if (lineNumber > 0) {
            coverage.computeIfAbsent(className, k -> new TreeSet<>())
                   .add(lineNumber);
        }
    }

    @Override
    public void vmDone(VM vm) {
        generateReport();
    }

    private void generateReport() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("report.txt"))) {
            for (Map.Entry<String, Set<Integer>> entry : coverage.entrySet()) {
                String className = entry.getKey();
                Set<Integer> lines = entry.getValue();

                writer.println("Class: " + className);
                writer.println("Covered Lines:");
                for (Integer line : lines) {
                    writer.println("  " + line);
                }
                writer.println();
            }
        } catch (IOException e) {
            System.err.println("Error generating coverage report: " + e.getMessage());
        }
    }
}
