// Generated from Calc.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalcParser}.
 */
public interface CalcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalcParser#str}.
	 * @param ctx the parse tree
	 */
	void enterStr(CalcParser.StrContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#str}.
	 * @param ctx the parse tree
	 */
	void exitStr(CalcParser.StrContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#mult}.
	 * @param ctx the parse tree
	 */
	void enterMult(CalcParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#mult}.
	 * @param ctx the parse tree
	 */
	void exitMult(CalcParser.MultContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#pow}.
	 * @param ctx the parse tree
	 */
	void enterPow(CalcParser.PowContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#pow}.
	 * @param ctx the parse tree
	 */
	void exitPow(CalcParser.PowContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(CalcParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(CalcParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#funcname}.
	 * @param ctx the parse tree
	 */
	void enterFuncname(CalcParser.FuncnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#funcname}.
	 * @param ctx the parse tree
	 */
	void exitFuncname(CalcParser.FuncnameContext ctx);
}