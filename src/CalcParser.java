// Generated from C:/MyCalculator/src\Calc.g4 by ANTLR 4.6

    import java.util.Stack;
    import java.math.BigDecimal;
    import java.math.RoundingMode;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalcParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUMBER=1, WS=2, NEWLINE=3, PLUS=4, MINUS=5, MULTIPLE=6, DIVISION=7, MOD=8, 
		POW=9, E=10, LPAREN=11, RPAREN=12, DOT=13, SQRT=14;
	public static final int
		RULE_str = 0, RULE_parens = 1, RULE_mult = 2, RULE_pow = 3, RULE_atom = 4, 
		RULE_funcname = 5;
	public static final String[] ruleNames = {
		"str", "parens", "mult", "pow", "atom", "funcname"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'\n'", "'+'", "'-'", "'*'", "'/'", "'%'", "'^'", null, 
		"'('", "')'", "'.'", "'sqrt'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "NUMBER", "WS", "NEWLINE", "PLUS", "MINUS", "MULTIPLE", "DIVISION", 
		"MOD", "POW", "E", "LPAREN", "RPAREN", "DOT", "SQRT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Calc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    BigDecimal first, second;
	    Stack<BigDecimal> stack = new Stack<>();
	    String result;

	public CalcParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StrContext extends ParserRuleContext {
		public Token sign;
		public List<MultContext> mult() {
			return getRuleContexts(MultContext.class);
		}
		public MultContext mult(int i) {
			return getRuleContext(MultContext.class,i);
		}
		public TerminalNode NEWLINE() { return getToken(CalcParser.NEWLINE, 0); }
		public List<TerminalNode> PLUS() { return getTokens(CalcParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(CalcParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(CalcParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(CalcParser.MINUS, i);
		}
		public StrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_str; }
	}

	public final StrContext str() throws RecognitionException {
		StrContext _localctx = new StrContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_str);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			mult();
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(13);
				((StrContext)_localctx).sign = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
					((StrContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(14);
				mult();

				            first = stack.pop();
				            second = stack.pop();

				            try {
				                if ((((StrContext)_localctx).sign!=null?((StrContext)_localctx).sign.getText():null).toString().equals("+"))
				                    stack.push(second.add(first));
				                else
				                    stack.push(second.subtract(first));
				            }
				            catch (Exception e) {
				               stack.push(BigDecimal.ZERO);
				            }
				        
				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(22);
				match(NEWLINE);
				}
			}


			            result = stack.pop().toString();
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParensContext extends ParserRuleContext {
		public Token sign;
		public List<MultContext> mult() {
			return getRuleContexts(MultContext.class);
		}
		public MultContext mult(int i) {
			return getRuleContext(MultContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(CalcParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(CalcParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(CalcParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(CalcParser.MINUS, i);
		}
		public ParensContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parens; }
	}

	public final ParensContext parens() throws RecognitionException {
		ParensContext _localctx = new ParensContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_parens);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			mult();
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(28);
				((ParensContext)_localctx).sign = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
					((ParensContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(29);
				mult();

				            first = stack.pop();
				            second = stack.pop();

				            try {
				                if ((((ParensContext)_localctx).sign!=null?((ParensContext)_localctx).sign.getText():null).toString().equals("+"))
				                    stack.push(second.add(first));
				                else
				                    stack.push(second.subtract(first));
				            }
				            catch (Exception e) {
				               stack.push(BigDecimal.ZERO);
				            }
				        
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultContext extends ParserRuleContext {
		public Token sign;
		public List<PowContext> pow() {
			return getRuleContexts(PowContext.class);
		}
		public PowContext pow(int i) {
			return getRuleContext(PowContext.class,i);
		}
		public List<TerminalNode> MULTIPLE() { return getTokens(CalcParser.MULTIPLE); }
		public TerminalNode MULTIPLE(int i) {
			return getToken(CalcParser.MULTIPLE, i);
		}
		public List<TerminalNode> DIVISION() { return getTokens(CalcParser.DIVISION); }
		public TerminalNode DIVISION(int i) {
			return getToken(CalcParser.DIVISION, i);
		}
		public List<TerminalNode> MOD() { return getTokens(CalcParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(CalcParser.MOD, i);
		}
		public MultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mult; }
	}

	public final MultContext mult() throws RecognitionException {
		MultContext _localctx = new MultContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_mult);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			pow();
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULTIPLE) | (1L << DIVISION) | (1L << MOD))) != 0)) {
				{
				{
				setState(38);
				((MultContext)_localctx).sign = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULTIPLE) | (1L << DIVISION) | (1L << MOD))) != 0)) ) {
					((MultContext)_localctx).sign = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(39);
				pow();

				            first = stack.pop();
				            second = stack.pop();

				            try {
				                if ((((MultContext)_localctx).sign!=null?((MultContext)_localctx).sign.getText():null).toString().equals("*"))
				                    stack.push(second.multiply(first));
				                else if ((((MultContext)_localctx).sign!=null?((MultContext)_localctx).sign.getText():null).toString().equals("/"))
				                    stack.push(second.divide(first, 1, RoundingMode.CEILING));
				                else
				                    stack.push(MyBigDecimalMath.mod(second, first));
				            }
				            catch (Exception e) {
				               stack.push(BigDecimal.ONE);
				            }
				        
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PowContext extends ParserRuleContext {
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public List<TerminalNode> POW() { return getTokens(CalcParser.POW); }
		public TerminalNode POW(int i) {
			return getToken(CalcParser.POW, i);
		}
		public PowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pow; }
	}

	public final PowContext pow() throws RecognitionException {
		PowContext _localctx = new PowContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pow);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			atom();
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==POW) {
				{
				{
				setState(48);
				match(POW);
				setState(49);
				atom();

				            first = stack.pop();
				            second = stack.pop();

					        try {
					            if (first.intValue() < 1000000 && first.intValue() > -1000000)
					                stack.push(second.pow(first.intValue()));
				                else
				                    stack.push(second);
				            }
				            catch (Exception e) {
				                stack.push(BigDecimal.ZERO);
				            }
					    
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public Token MINUS;
		public Token NUMBER;
		public FuncnameContext funcname;
		public TerminalNode NUMBER() { return getToken(CalcParser.NUMBER, 0); }
		public TerminalNode MINUS() { return getToken(CalcParser.MINUS, 0); }
		public TerminalNode LPAREN() { return getToken(CalcParser.LPAREN, 0); }
		public ParensContext parens() {
			return getRuleContext(ParensContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CalcParser.RPAREN, 0); }
		public FuncnameContext funcname() {
			return getRuleContext(FuncnameContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_atom);
		int _la;
		try {
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(57);
					((AtomContext)_localctx).MINUS = match(MINUS);
					}
				}

				setState(60);
				((AtomContext)_localctx).NUMBER = match(NUMBER);

					        BigDecimal value = new BigDecimal((((AtomContext)_localctx).NUMBER!=null?((AtomContext)_localctx).NUMBER.getText():null).toString().replaceAll(" ", ""));
					        if ((((AtomContext)_localctx).MINUS!=null?((AtomContext)_localctx).MINUS.getText():null) != null)
					            value = value.negate();
				            stack.push(value);
					    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(62);
					match(MINUS);
					}
				}

				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SQRT) {
					{
					setState(65);
					((AtomContext)_localctx).funcname = funcname();
					}
				}

				setState(68);
				match(LPAREN);
				setState(69);
				parens();
				setState(70);
				match(RPAREN);

				            try {
				                if ((((AtomContext)_localctx).funcname!=null?_input.getText(((AtomContext)_localctx).funcname.start,((AtomContext)_localctx).funcname.stop):null) != null)
				                    stack.push(MyBigDecimalMath.sqrt(stack.pop()));
				            }
				            catch (Exception e) {
				                stack.push(BigDecimal.ONE);
				            }
					    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncnameContext extends ParserRuleContext {
		public TerminalNode SQRT() { return getToken(CalcParser.SQRT, 0); }
		public FuncnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcname; }
	}

	public final FuncnameContext funcname() throws RecognitionException {
		FuncnameContext _localctx = new FuncnameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_funcname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(SQRT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\20P\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\2\7\2\24\n\2\f\2"+
		"\16\2\27\13\2\3\2\5\2\32\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3#\n\3\f\3"+
		"\16\3&\13\3\3\4\3\4\3\4\3\4\3\4\7\4-\n\4\f\4\16\4\60\13\4\3\5\3\5\3\5"+
		"\3\5\3\5\7\5\67\n\5\f\5\16\5:\13\5\3\6\5\6=\n\6\3\6\3\6\3\6\5\6B\n\6\3"+
		"\6\5\6E\n\6\3\6\3\6\3\6\3\6\3\6\5\6L\n\6\3\7\3\7\3\7\2\2\b\2\4\6\b\n\f"+
		"\2\4\3\2\6\7\3\2\b\nR\2\16\3\2\2\2\4\35\3\2\2\2\6\'\3\2\2\2\b\61\3\2\2"+
		"\2\nK\3\2\2\2\fM\3\2\2\2\16\25\5\6\4\2\17\20\t\2\2\2\20\21\5\6\4\2\21"+
		"\22\b\2\1\2\22\24\3\2\2\2\23\17\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2\25"+
		"\26\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\30\32\7\5\2\2\31\30\3\2\2\2\31"+
		"\32\3\2\2\2\32\33\3\2\2\2\33\34\b\2\1\2\34\3\3\2\2\2\35$\5\6\4\2\36\37"+
		"\t\2\2\2\37 \5\6\4\2 !\b\3\1\2!#\3\2\2\2\"\36\3\2\2\2#&\3\2\2\2$\"\3\2"+
		"\2\2$%\3\2\2\2%\5\3\2\2\2&$\3\2\2\2\'.\5\b\5\2()\t\3\2\2)*\5\b\5\2*+\b"+
		"\4\1\2+-\3\2\2\2,(\3\2\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\7\3\2\2\2"+
		"\60.\3\2\2\2\618\5\n\6\2\62\63\7\13\2\2\63\64\5\n\6\2\64\65\b\5\1\2\65"+
		"\67\3\2\2\2\66\62\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29\t\3\2\2\2"+
		":8\3\2\2\2;=\7\7\2\2<;\3\2\2\2<=\3\2\2\2=>\3\2\2\2>?\7\3\2\2?L\b\6\1\2"+
		"@B\7\7\2\2A@\3\2\2\2AB\3\2\2\2BD\3\2\2\2CE\5\f\7\2DC\3\2\2\2DE\3\2\2\2"+
		"EF\3\2\2\2FG\7\r\2\2GH\5\4\3\2HI\7\16\2\2IJ\b\6\1\2JL\3\2\2\2K<\3\2\2"+
		"\2KA\3\2\2\2L\13\3\2\2\2MN\7\20\2\2N\r\3\2\2\2\13\25\31$.8<ADK";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}