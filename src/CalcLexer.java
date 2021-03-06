// Generated from C:/MyCalculator/src\Calc.g4 by ANTLR 4.6

    import java.util.Stack;
    import java.math.BigDecimal;
    import java.math.RoundingMode;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalcLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUMBER=1, WS=2, NEWLINE=3, PLUS=4, MINUS=5, MULTIPLE=6, DIVISION=7, MOD=8, 
		POW=9, E=10, LPAREN=11, RPAREN=12, DOT=13, SQRT=14;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"NUMBER", "DIGIT", "WS", "NEWLINE", "PLUS", "MINUS", "MULTIPLE", "DIVISION", 
		"MOD", "POW", "E", "LPAREN", "RPAREN", "DOT", "SQRT"
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


	    BigDecimal first, second;
	    Stack<BigDecimal> stack = new Stack<>();
	    String result;


	public CalcLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Calc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\20m\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\7\2$\n\2\f\2"+
		"\16\2\'\13\2\7\2)\n\2\f\2\16\2,\13\2\3\2\5\2/\n\2\3\2\3\2\7\2\63\n\2\f"+
		"\2\16\2\66\13\2\6\28\n\2\r\2\16\29\3\2\3\2\3\2\7\2?\n\2\f\2\16\2B\13\2"+
		"\6\2D\n\2\r\2\16\2E\5\2H\n\2\3\3\3\3\3\4\6\4M\n\4\r\4\16\4N\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\2\2\21\3\3\5\2\7\4\t\5"+
		"\13\6\r\7\17\b\21\t\23\n\25\13\27\f\31\r\33\16\35\17\37\20\3\2\5\3\2\62"+
		";\5\2\13\f\17\17\"\"\4\2GGggt\2\3\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\3"+
		"*\3\2\2\2\5I\3\2\2\2\7L\3\2\2\2\tR\3\2\2\2\13T\3\2\2\2\rV\3\2\2\2\17X"+
		"\3\2\2\2\21Z\3\2\2\2\23\\\3\2\2\2\25^\3\2\2\2\27`\3\2\2\2\31b\3\2\2\2"+
		"\33d\3\2\2\2\35f\3\2\2\2\37h\3\2\2\2!%\5\5\3\2\"$\5\7\4\2#\"\3\2\2\2$"+
		"\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&)\3\2\2\2\'%\3\2\2\2(!\3\2\2\2),\3\2\2"+
		"\2*(\3\2\2\2*+\3\2\2\2+.\3\2\2\2,*\3\2\2\2-/\5\35\17\2.-\3\2\2\2./\3\2"+
		"\2\2/\67\3\2\2\2\60\64\5\5\3\2\61\63\5\7\4\2\62\61\3\2\2\2\63\66\3\2\2"+
		"\2\64\62\3\2\2\2\64\65\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\67\60\3\2\2\2"+
		"89\3\2\2\29\67\3\2\2\29:\3\2\2\2:G\3\2\2\2;C\5\27\f\2<@\5\5\3\2=?\5\7"+
		"\4\2>=\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2AD\3\2\2\2B@\3\2\2\2C<\3\2"+
		"\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2\2\2FH\3\2\2\2G;\3\2\2\2GH\3\2\2\2H\4\3"+
		"\2\2\2IJ\t\2\2\2J\6\3\2\2\2KM\t\3\2\2LK\3\2\2\2MN\3\2\2\2NL\3\2\2\2NO"+
		"\3\2\2\2OP\3\2\2\2PQ\b\4\2\2Q\b\3\2\2\2RS\7\f\2\2S\n\3\2\2\2TU\7-\2\2"+
		"U\f\3\2\2\2VW\7/\2\2W\16\3\2\2\2XY\7,\2\2Y\20\3\2\2\2Z[\7\61\2\2[\22\3"+
		"\2\2\2\\]\7\'\2\2]\24\3\2\2\2^_\7`\2\2_\26\3\2\2\2`a\t\4\2\2a\30\3\2\2"+
		"\2bc\7*\2\2c\32\3\2\2\2de\7+\2\2e\34\3\2\2\2fg\7\60\2\2g\36\3\2\2\2hi"+
		"\7u\2\2ij\7s\2\2jk\7t\2\2kl\7v\2\2l \3\2\2\2\f\2%*.\649@EGN\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}