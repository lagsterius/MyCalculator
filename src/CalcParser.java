// Generated from C:/MyCalculator/src\Calc.g4 by ANTLR 4.6

    import java.util.Stack;
    import org.nevec.rjm.*;
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

	public CalcParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StrContext extends ParserRuleContext {
		public Stack<BigDecimal> stack = new Stack<>();
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

				            BigDecimal first = ((StrContext)getInvokingContext(0)).stack.pop();
				            BigDecimal second = ((StrContext)getInvokingContext(0)).stack.pop();

				            if ((((StrContext)_localctx).sign!=null?((StrContext)_localctx).sign.getText():null).toString().equals("+"))
				                ((StrContext)getInvokingContext(0)).stack.push(second.add(first));
				            else
				                ((StrContext)getInvokingContext(0)).stack.push(second.subtract(first));
				        
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


			            //System.out.println(" = " + ((StrContext)getInvokingContext(0)).stack.pop());
			        
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
		public TerminalNode NEWLINE() { return getToken(CalcParser.NEWLINE, 0); }
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

				            BigDecimal first = ((StrContext)getInvokingContext(0)).stack.pop();
				            BigDecimal second = ((StrContext)getInvokingContext(0)).stack.pop();

				            if ((((ParensContext)_localctx).sign!=null?((ParensContext)_localctx).sign.getText():null).toString().equals("+"))
				                ((StrContext)getInvokingContext(0)).stack.push(second.add(first));
				            else
				                ((StrContext)getInvokingContext(0)).stack.push(second.subtract(first));
				        
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(37);
				match(NEWLINE);
				}
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
			setState(40);
			pow();
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULTIPLE) | (1L << DIVISION) | (1L << MOD))) != 0)) {
				{
				{
				setState(41);
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
				setState(42);
				pow();

				            BigDecimal first = ((StrContext)getInvokingContext(0)).stack.pop();
				            BigDecimal second = ((StrContext)getInvokingContext(0)).stack.pop();

				            if ((((MultContext)_localctx).sign!=null?((MultContext)_localctx).sign.getText():null).toString().equals("*"))
				                ((StrContext)getInvokingContext(0)).stack.push(second.multiply(first));
				            else if ((((MultContext)_localctx).sign!=null?((MultContext)_localctx).sign.getText():null).toString().equals("/"))
				                ((StrContext)getInvokingContext(0)).stack.push(second.divide(first, 20, RoundingMode.HALF_UP));
				            else
				                ((StrContext)getInvokingContext(0)).stack.push(MyBigDecimalMath.mod(second, first));
				        
				}
				}
				setState(49);
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
			setState(50);
			atom();
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==POW) {
				{
				{
				setState(51);
				match(POW);
				setState(52);
				atom();

				            BigDecimal first = ((StrContext)getInvokingContext(0)).stack.pop();
				            BigDecimal second = ((StrContext)getInvokingContext(0)).stack.pop();

					        //((StrContext)getInvokingContext(0)).stack.push(BigDecimalMath.powRound(second, first.toBigInteger()).setScale(5));
					        ((StrContext)getInvokingContext(0)).stack.push(second.pow(first.intValue()));
					    
				}
				}
				setState(59);
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
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(60);
					((AtomContext)_localctx).MINUS = match(MINUS);
					}
				}

				setState(63);
				((AtomContext)_localctx).NUMBER = match(NUMBER);

					        BigDecimal value = new BigDecimal((((AtomContext)_localctx).NUMBER!=null?((AtomContext)_localctx).NUMBER.getText():null).toString());
					        if ((((AtomContext)_localctx).MINUS!=null?((AtomContext)_localctx).MINUS.getText():null) != null)
					            value = value.negate();
				            ((StrContext)getInvokingContext(0)).stack.push(value);
					    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(65);
					match(MINUS);
					}
				}

				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SQRT) {
					{
					setState(68);
					((AtomContext)_localctx).funcname = funcname();
					}
				}

				setState(71);
				match(LPAREN);
				setState(72);
				parens();
				setState(73);
				match(RPAREN);

				            if ((((AtomContext)_localctx).funcname!=null?_input.getText(((AtomContext)_localctx).funcname.start,((AtomContext)_localctx).funcname.stop):null) != null)
				                ((StrContext)getInvokingContext(0)).stack.push(BigDecimalMath.sqrt(((StrContext)getInvokingContext(0)).stack.pop()));
					    
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
			setState(78);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\20S\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\3\2\7\2\24\n\2\f\2"+
		"\16\2\27\13\2\3\2\5\2\32\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3#\n\3\f\3"+
		"\16\3&\13\3\3\3\5\3)\n\3\3\4\3\4\3\4\3\4\3\4\7\4\60\n\4\f\4\16\4\63\13"+
		"\4\3\5\3\5\3\5\3\5\3\5\7\5:\n\5\f\5\16\5=\13\5\3\6\5\6@\n\6\3\6\3\6\3"+
		"\6\5\6E\n\6\3\6\5\6H\n\6\3\6\3\6\3\6\3\6\3\6\5\6O\n\6\3\7\3\7\3\7\2\2"+
		"\b\2\4\6\b\n\f\2\4\3\2\6\7\3\2\b\nV\2\16\3\2\2\2\4\35\3\2\2\2\6*\3\2\2"+
		"\2\b\64\3\2\2\2\nN\3\2\2\2\fP\3\2\2\2\16\25\5\6\4\2\17\20\t\2\2\2\20\21"+
		"\5\6\4\2\21\22\b\2\1\2\22\24\3\2\2\2\23\17\3\2\2\2\24\27\3\2\2\2\25\23"+
		"\3\2\2\2\25\26\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\30\32\7\5\2\2\31\30"+
		"\3\2\2\2\31\32\3\2\2\2\32\33\3\2\2\2\33\34\b\2\1\2\34\3\3\2\2\2\35$\5"+
		"\6\4\2\36\37\t\2\2\2\37 \5\6\4\2 !\b\3\1\2!#\3\2\2\2\"\36\3\2\2\2#&\3"+
		"\2\2\2$\"\3\2\2\2$%\3\2\2\2%(\3\2\2\2&$\3\2\2\2\')\7\5\2\2(\'\3\2\2\2"+
		"()\3\2\2\2)\5\3\2\2\2*\61\5\b\5\2+,\t\3\2\2,-\5\b\5\2-.\b\4\1\2.\60\3"+
		"\2\2\2/+\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\7\3\2\2\2"+
		"\63\61\3\2\2\2\64;\5\n\6\2\65\66\7\13\2\2\66\67\5\n\6\2\678\b\5\1\28:"+
		"\3\2\2\29\65\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<\t\3\2\2\2=;\3\2\2"+
		"\2>@\7\7\2\2?>\3\2\2\2?@\3\2\2\2@A\3\2\2\2AB\7\3\2\2BO\b\6\1\2CE\7\7\2"+
		"\2DC\3\2\2\2DE\3\2\2\2EG\3\2\2\2FH\5\f\7\2GF\3\2\2\2GH\3\2\2\2HI\3\2\2"+
		"\2IJ\7\r\2\2JK\5\4\3\2KL\7\16\2\2LM\b\6\1\2MO\3\2\2\2N?\3\2\2\2ND\3\2"+
		"\2\2O\13\3\2\2\2PQ\7\20\2\2Q\r\3\2\2\2\f\25\31$(\61;?DGN";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}