import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import java.util.List;
import java.util.ArrayList;

public class SQLSemanticVisitor extends SQLBaseVisitor<Void> {
    private List<ColumnInfo> columns = new ArrayList<>();
    private boolean hasUnion = false;
    private List<String> errors = new ArrayList<>();

    // Helper class to store column information
    private static class ColumnInfo {
        String name;
        String type;

        ColumnInfo(String name, String type) {
            this.name = name;
            this.type = type;
        }
    }

    @Override
    public Void visitSelect_statement(SQLParser.Select_statementContext ctx) {
        // Check for UNION
        if (ctx.UNION() != null) {
            hasUnion = true;
            checkUnionCompatibility(ctx);
        }

        // Visit all select_core parts
        for (SQLParser.Select_coreContext selectCore : ctx.select_core()) {
            visit(selectCore);
        }

        return null;
    }

    @Override
    public Void visitResult_column(SQLParser.Result_columnContext ctx) {
        if (ctx.expr() != null) {
            String columnName = ctx.column_alias() != null ? ctx.column_alias().getText() : "";
            String columnType = inferExpressionType(ctx.expr());
            columns.add(new ColumnInfo(columnName, columnType));
        }
        return visitChildren(ctx);
    }

    @Override
    public Void visitExpr(SQLParser.ExprContext ctx) {
        if (ctx.function_name() != null) {
            checkAggregateFunctionCompatibility(ctx);
        }
        return visitChildren(ctx);
    }

    private void checkUnionCompatibility(SQLParser.Select_statementContext ctx) {
        List<SQLParser.Select_coreContext> selectCores = ctx.select_core();
        int columnCount = -1;
        List<String> columnTypes = new ArrayList<>();

        for (int i = 0; i < selectCores.size(); i++) {
            SQLParser.Select_coreContext selectCore = selectCores.get(i);
            List<SQLParser.Result_columnContext> resultColumns = selectCore.result_column();

            if (columnCount == -1) {
                columnCount = resultColumns.size();
                for (SQLParser.Result_columnContext resultColumn : resultColumns) {
                    columnTypes.add(inferExpressionType(resultColumn.expr()));
                }
            } else {
                if (resultColumns.size() != columnCount) {
                    errors.add("UNION incompatibility: Different number of columns in SELECT statement " + (i + 1));
                } else {
                    for (int j = 0; j < resultColumns.size(); j++) {
                        String type = inferExpressionType(resultColumns.get(j).expr());
                        if (!type.equals(columnTypes.get(j))) {
                            errors.add("UNION incompatibility: Column " + (j + 1) + " has different types in SELECT statement " + (i + 1));
                        }
                    }
                }
            }
        }
    }

    private void checkAggregateFunctionCompatibility(SQLParser.ExprContext ctx) {
        String functionName = ctx.function_name().getText().toLowerCase();
        String argType = inferExpressionType(ctx.expr(0));

        switch (functionName) {
            case "count":
                // COUNT can be used with any type
                break;
            case "sum":
            case "avg":
                if (!isNumericType(argType)) {
                    errors.add("Incompatible type for " + functionName.toUpperCase() + ": expected numeric, got " + argType);
                }
                break;
            case "max":
            case "min":
                if (!isComparableType(argType)) {
                    errors.add("Incompatible type for " + functionName.toUpperCase() + ": expected comparable type, got " + argType);
                }
                break;
            default:
                // Ignore other functions
        }
    }

    private String inferExpressionType(SQLParser.ExprContext ctx) {
        // This is a simplified type inference. In a real implementation, you'd need more sophisticated logic.
        if (ctx.literal_value() != null) {
            if (ctx.literal_value().NUMERIC_LITERAL() != null) {
                return "NUMERIC";
            } else if (ctx.literal_value().STRING_LITERAL() != null) {
                return "STRING";
            }
        } else if (ctx.column_name() != null) {
            // In a real implementation, you'd look up the column type from the schema
            return "UNKNOWN";
        }
        return "UNKNOWN";
    }

    private boolean isNumericType(String type) {
        return type.equals("NUMERIC") || type.equals("INTEGER") || type.equals("FLOAT");
    }

    private boolean isComparableType(String type) {
        return isNumericType(type) || type.equals("STRING") || type.equals("DATE");
    }

    public List<String> getErrors() {
        return errors;
    }
}