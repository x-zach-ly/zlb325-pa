// Generated from SQL.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SQLParser}.
 */
public interface SQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SQLParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(SQLParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(SQLParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#sql_stmt_list}.
	 * @param ctx the parse tree
	 */
	void enterSql_stmt_list(SQLParser.Sql_stmt_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#sql_stmt_list}.
	 * @param ctx the parse tree
	 */
	void exitSql_stmt_list(SQLParser.Sql_stmt_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#sql_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSql_stmt(SQLParser.Sql_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#sql_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSql_stmt(SQLParser.Sql_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#select_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSelect_stmt(SQLParser.Select_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#select_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSelect_stmt(SQLParser.Select_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#select_core}.
	 * @param ctx the parse tree
	 */
	void enterSelect_core(SQLParser.Select_coreContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#select_core}.
	 * @param ctx the parse tree
	 */
	void exitSelect_core(SQLParser.Select_coreContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#result_column}.
	 * @param ctx the parse tree
	 */
	void enterResult_column(SQLParser.Result_columnContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#result_column}.
	 * @param ctx the parse tree
	 */
	void exitResult_column(SQLParser.Result_columnContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#table_or_subquery}.
	 * @param ctx the parse tree
	 */
	void enterTable_or_subquery(SQLParser.Table_or_subqueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#table_or_subquery}.
	 * @param ctx the parse tree
	 */
	void exitTable_or_subquery(SQLParser.Table_or_subqueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(SQLParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(SQLParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#function_name}.
	 * @param ctx the parse tree
	 */
	void enterFunction_name(SQLParser.Function_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#function_name}.
	 * @param ctx the parse tree
	 */
	void exitFunction_name(SQLParser.Function_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#column_alias}.
	 * @param ctx the parse tree
	 */
	void enterColumn_alias(SQLParser.Column_aliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#column_alias}.
	 * @param ctx the parse tree
	 */
	void exitColumn_alias(SQLParser.Column_aliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#column_name}.
	 * @param ctx the parse tree
	 */
	void enterColumn_name(SQLParser.Column_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#column_name}.
	 * @param ctx the parse tree
	 */
	void exitColumn_name(SQLParser.Column_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#table_name}.
	 * @param ctx the parse tree
	 */
	void enterTable_name(SQLParser.Table_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#table_name}.
	 * @param ctx the parse tree
	 */
	void exitTable_name(SQLParser.Table_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#table_alias}.
	 * @param ctx the parse tree
	 */
	void enterTable_alias(SQLParser.Table_aliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#table_alias}.
	 * @param ctx the parse tree
	 */
	void exitTable_alias(SQLParser.Table_aliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#any_name}.
	 * @param ctx the parse tree
	 */
	void enterAny_name(SQLParser.Any_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#any_name}.
	 * @param ctx the parse tree
	 */
	void exitAny_name(SQLParser.Any_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SQLParser#keyword}.
	 * @param ctx the parse tree
	 */
	void enterKeyword(SQLParser.KeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link SQLParser#keyword}.
	 * @param ctx the parse tree
	 */
	void exitKeyword(SQLParser.KeywordContext ctx);
}