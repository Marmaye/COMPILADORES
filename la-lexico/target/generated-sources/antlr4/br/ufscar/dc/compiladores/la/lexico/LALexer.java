// Generated from br/ufscar/dc/compiladores/la/lexico/LALexer.g4 by ANTLR 4.7.2
package br.ufscar.dc.compiladores.la.lexico;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LALexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PALAVRA_CHAVE=1, IDENT=2, NUM_INT=3, NUM_REAL=4, CADEIA=5, WS=6, COMENTARIO=7, 
		OP_RELACIONAL=8, OP1=9, OP2=10, OP3=11, OP_ATRIBUICAO=12, OP_INTERVALO=13, 
		ABREPAR=14, FECHAPAR=15, ABRECOL=16, FECHACOL=17, DELIMITADOR=18, AND=19, 
		CIRCUNFLEXO=20, DESCONHECIDO=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PALAVRA_CHAVE", "IDENT", "NUM_INT", "NUM_REAL", "CADEIA", "ESC_SEQ", 
			"WS", "COMENTARIO", "OP_RELACIONAL", "OP1", "OP2", "OP3", "OP_ATRIBUICAO", 
			"OP_INTERVALO", "ABREPAR", "FECHAPAR", "ABRECOL", "FECHACOL", "DELIMITADOR", 
			"AND", "CIRCUNFLEXO", "DESCONHECIDO"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "'%'", 
			"'<-'", "'..'", "'('", "')'", "'['", "']'", null, "'&'", "'^'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PALAVRA_CHAVE", "IDENT", "NUM_INT", "NUM_REAL", "CADEIA", "WS", 
			"COMENTARIO", "OP_RELACIONAL", "OP1", "OP2", "OP3", "OP_ATRIBUICAO", 
			"OP_INTERVALO", "ABREPAR", "FECHAPAR", "ABRECOL", "FECHACOL", "DELIMITADOR", 
			"AND", "CIRCUNFLEXO", "DESCONHECIDO"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public LALexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LALexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 6:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		case 7:
			COMENTARIO_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			skip();
			break;
		}
	}
	private void COMENTARIO_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			skip();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u0182\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\u0125\n\2"+
		"\3\3\3\3\7\3\u0129\n\3\f\3\16\3\u012c\13\3\3\4\6\4\u012f\n\4\r\4\16\4"+
		"\u0130\3\5\6\5\u0134\n\5\r\5\16\5\u0135\3\5\3\5\6\5\u013a\n\5\r\5\16\5"+
		"\u013b\5\5\u013e\n\5\3\6\3\6\3\6\7\6\u0143\n\6\f\6\16\6\u0146\13\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\7\t\u0152\n\t\f\t\16\t\u0155\13\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0162\n\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\6\27\u017f\n\27\r\27"+
		"\16\27\u0180\4\u0153\u0180\2\30\3\3\5\4\7\5\t\6\13\7\r\2\17\b\21\t\23"+
		"\n\25\13\27\f\31\r\33\16\35\17\37\20!\21#\22%\23\'\24)\25+\26-\27\3\2"+
		"\13\5\2C\\aac|\6\2\62;C\\aac|\5\2\f\f$$^^\5\2\13\f\17\17\"\"\3\2\f\f\4"+
		"\2>>@@\4\2--//\4\2,,\61\61\5\2..\60\60<<\2\u01b1\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\3\u0124\3\2\2\2\5\u0126\3\2\2\2\7\u012e\3\2"+
		"\2\2\t\u0133\3\2\2\2\13\u013f\3\2\2\2\r\u0149\3\2\2\2\17\u014c\3\2\2\2"+
		"\21\u014f\3\2\2\2\23\u0161\3\2\2\2\25\u0163\3\2\2\2\27\u0165\3\2\2\2\31"+
		"\u0167\3\2\2\2\33\u0169\3\2\2\2\35\u016c\3\2\2\2\37\u016f\3\2\2\2!\u0171"+
		"\3\2\2\2#\u0173\3\2\2\2%\u0175\3\2\2\2\'\u0177\3\2\2\2)\u0179\3\2\2\2"+
		"+\u017b\3\2\2\2-\u017e\3\2\2\2/\60\7c\2\2\60\61\7n\2\2\61\62\7i\2\2\62"+
		"\63\7q\2\2\63\64\7t\2\2\64\65\7k\2\2\65\66\7v\2\2\66\67\7o\2\2\67\u0125"+
		"\7q\2\289\7h\2\29:\7k\2\2:;\7o\2\2;<\7a\2\2<=\7c\2\2=>\7n\2\2>?\7i\2\2"+
		"?@\7q\2\2@A\7t\2\2AB\7k\2\2BC\7v\2\2CD\7o\2\2D\u0125\7q\2\2EF\7f\2\2F"+
		"G\7g\2\2GH\7e\2\2HI\7n\2\2IJ\7c\2\2JK\7t\2\2K\u0125\7g\2\2LM\7e\2\2MN"+
		"\7q\2\2NO\7p\2\2OP\7u\2\2PQ\7v\2\2QR\7c\2\2RS\7p\2\2ST\7v\2\2T\u0125\7"+
		"g\2\2UV\7v\2\2VW\7k\2\2WX\7r\2\2X\u0125\7q\2\2YZ\7n\2\2Z[\7k\2\2[\\\7"+
		"v\2\2\\]\7g\2\2]^\7t\2\2^_\7c\2\2_\u0125\7n\2\2`a\7k\2\2ab\7p\2\2bc\7"+
		"v\2\2cd\7g\2\2de\7k\2\2ef\7t\2\2f\u0125\7q\2\2gh\7t\2\2hi\7g\2\2ij\7c"+
		"\2\2j\u0125\7n\2\2kl\7n\2\2lm\7q\2\2mn\7i\2\2no\7k\2\2op\7e\2\2p\u0125"+
		"\7q\2\2qr\7x\2\2rs\7g\2\2st\7t\2\2tu\7f\2\2uv\7c\2\2vw\7f\2\2wx\7g\2\2"+
		"xy\7k\2\2yz\7t\2\2z\u0125\7q\2\2{|\7h\2\2|}\7c\2\2}~\7n\2\2~\177\7u\2"+
		"\2\177\u0125\7q\2\2\u0080\u0081\7t\2\2\u0081\u0082\7g\2\2\u0082\u0083"+
		"\7i\2\2\u0083\u0084\7k\2\2\u0084\u0085\7u\2\2\u0085\u0086\7v\2\2\u0086"+
		"\u0087\7t\2\2\u0087\u0125\7q\2\2\u0088\u0089\7h\2\2\u0089\u008a\7k\2\2"+
		"\u008a\u008b\7o\2\2\u008b\u008c\7a\2\2\u008c\u008d\7t\2\2\u008d\u008e"+
		"\7g\2\2\u008e\u008f\7i\2\2\u008f\u0090\7k\2\2\u0090\u0091\7u\2\2\u0091"+
		"\u0092\7v\2\2\u0092\u0093\7t\2\2\u0093\u0125\7q\2\2\u0094\u0095\7r\2\2"+
		"\u0095\u0096\7t\2\2\u0096\u0097\7q\2\2\u0097\u0098\7e\2\2\u0098\u0099"+
		"\7g\2\2\u0099\u009a\7f\2\2\u009a\u009b\7k\2\2\u009b\u009c\7o\2\2\u009c"+
		"\u009d\7g\2\2\u009d\u009e\7p\2\2\u009e\u009f\7v\2\2\u009f\u0125\7q\2\2"+
		"\u00a0\u00a1\7h\2\2\u00a1\u00a2\7k\2\2\u00a2\u00a3\7o\2\2\u00a3\u00a4"+
		"\7a\2\2\u00a4\u00a5\7r\2\2\u00a5\u00a6\7t\2\2\u00a6\u00a7\7q\2\2\u00a7"+
		"\u00a8\7e\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa\7f\2\2\u00aa\u00ab\7k\2\2"+
		"\u00ab\u00ac\7o\2\2\u00ac\u00ad\7g\2\2\u00ad\u00ae\7p\2\2\u00ae\u00af"+
		"\7v\2\2\u00af\u0125\7q\2\2\u00b0\u00b1\7h\2\2\u00b1\u00b2\7w\2\2\u00b2"+
		"\u00b3\7p\2\2\u00b3\u00b4\7e\2\2\u00b4\u00b5\7c\2\2\u00b5\u0125\7q\2\2"+
		"\u00b6\u00b7\7h\2\2\u00b7\u00b8\7k\2\2\u00b8\u00b9\7o\2\2\u00b9\u00ba"+
		"\7a\2\2\u00ba\u00bb\7h\2\2\u00bb\u00bc\7w\2\2\u00bc\u00bd\7p\2\2\u00bd"+
		"\u00be\7e\2\2\u00be\u00bf\7c\2\2\u00bf\u0125\7q\2\2\u00c0\u00c1\7x\2\2"+
		"\u00c1\u00c2\7c\2\2\u00c2\u0125\7t\2\2\u00c3\u00c4\7n\2\2\u00c4\u00c5"+
		"\7g\2\2\u00c5\u00c6\7k\2\2\u00c6\u0125\7c\2\2\u00c7\u00c8\7g\2\2\u00c8"+
		"\u00c9\7u\2\2\u00c9\u00ca\7e\2\2\u00ca\u00cb\7t\2\2\u00cb\u00cc\7g\2\2"+
		"\u00cc\u00cd\7x\2\2\u00cd\u0125\7c\2\2\u00ce\u00cf\7u\2\2\u00cf\u0125"+
		"\7g\2\2\u00d0\u00d1\7g\2\2\u00d1\u00d2\7p\2\2\u00d2\u00d3\7v\2\2\u00d3"+
		"\u00d4\7c\2\2\u00d4\u0125\7q\2\2\u00d5\u00d6\7u\2\2\u00d6\u00d7\7g\2\2"+
		"\u00d7\u00d8\7p\2\2\u00d8\u00d9\7c\2\2\u00d9\u0125\7q\2\2\u00da\u00db"+
		"\7h\2\2\u00db\u00dc\7k\2\2\u00dc\u00dd\7o\2\2\u00dd\u00de\7a\2\2\u00de"+
		"\u00df\7u\2\2\u00df\u0125\7g\2\2\u00e0\u00e1\7e\2\2\u00e1\u00e2\7c\2\2"+
		"\u00e2\u00e3\7u\2\2\u00e3\u0125\7q\2\2\u00e4\u00e5\7u\2\2\u00e5\u00e6"+
		"\7g\2\2\u00e6\u00e7\7l\2\2\u00e7\u0125\7c\2\2\u00e8\u00e9\7h\2\2\u00e9"+
		"\u00ea\7k\2\2\u00ea\u00eb\7o\2\2\u00eb\u00ec\7a\2\2\u00ec\u00ed\7e\2\2"+
		"\u00ed\u00ee\7c\2\2\u00ee\u00ef\7u\2\2\u00ef\u0125\7q\2\2\u00f0\u00f1"+
		"\7r\2\2\u00f1\u00f2\7c\2\2\u00f2\u00f3\7t\2\2\u00f3\u0125\7c\2\2\u00f4"+
		"\u00f5\7c\2\2\u00f5\u00f6\7v\2\2\u00f6\u0125\7g\2\2\u00f7\u00f8\7h\2\2"+
		"\u00f8\u00f9\7c\2\2\u00f9\u00fa\7e\2\2\u00fa\u0125\7c\2\2\u00fb\u00fc"+
		"\7h\2\2\u00fc\u00fd\7k\2\2\u00fd\u00fe\7o\2\2\u00fe\u00ff\7a\2\2\u00ff"+
		"\u0100\7r\2\2\u0100\u0101\7c\2\2\u0101\u0102\7t\2\2\u0102\u0125\7c\2\2"+
		"\u0103\u0104\7g\2\2\u0104\u0105\7p\2\2\u0105\u0106\7s\2\2\u0106\u0107"+
		"\7w\2\2\u0107\u0108\7c\2\2\u0108\u0109\7p\2\2\u0109\u010a\7v\2\2\u010a"+
		"\u0125\7q\2\2\u010b\u010c\7h\2\2\u010c\u010d\7k\2\2\u010d\u010e\7o\2\2"+
		"\u010e\u010f\7a\2\2\u010f\u0110\7g\2\2\u0110\u0111\7p\2\2\u0111\u0112"+
		"\7s\2\2\u0112\u0113\7w\2\2\u0113\u0114\7c\2\2\u0114\u0115\7p\2\2\u0115"+
		"\u0116\7v\2\2\u0116\u0125\7q\2\2\u0117\u0118\7t\2\2\u0118\u0119\7g\2\2"+
		"\u0119\u011a\7v\2\2\u011a\u011b\7q\2\2\u011b\u011c\7t\2\2\u011c\u011d"+
		"\7p\2\2\u011d\u0125\7g\2\2\u011e\u011f\7p\2\2\u011f\u0120\7c\2\2\u0120"+
		"\u0125\7q\2\2\u0121\u0122\7q\2\2\u0122\u0125\7w\2\2\u0123\u0125\7g\2\2"+
		"\u0124/\3\2\2\2\u01248\3\2\2\2\u0124E\3\2\2\2\u0124L\3\2\2\2\u0124U\3"+
		"\2\2\2\u0124Y\3\2\2\2\u0124`\3\2\2\2\u0124g\3\2\2\2\u0124k\3\2\2\2\u0124"+
		"q\3\2\2\2\u0124{\3\2\2\2\u0124\u0080\3\2\2\2\u0124\u0088\3\2\2\2\u0124"+
		"\u0094\3\2\2\2\u0124\u00a0\3\2\2\2\u0124\u00b0\3\2\2\2\u0124\u00b6\3\2"+
		"\2\2\u0124\u00c0\3\2\2\2\u0124\u00c3\3\2\2\2\u0124\u00c7\3\2\2\2\u0124"+
		"\u00ce\3\2\2\2\u0124\u00d0\3\2\2\2\u0124\u00d5\3\2\2\2\u0124\u00da\3\2"+
		"\2\2\u0124\u00e0\3\2\2\2\u0124\u00e4\3\2\2\2\u0124\u00e8\3\2\2\2\u0124"+
		"\u00f0\3\2\2\2\u0124\u00f4\3\2\2\2\u0124\u00f7\3\2\2\2\u0124\u00fb\3\2"+
		"\2\2\u0124\u0103\3\2\2\2\u0124\u010b\3\2\2\2\u0124\u0117\3\2\2\2\u0124"+
		"\u011e\3\2\2\2\u0124\u0121\3\2\2\2\u0124\u0123\3\2\2\2\u0125\4\3\2\2\2"+
		"\u0126\u012a\t\2\2\2\u0127\u0129\t\3\2\2\u0128\u0127\3\2\2\2\u0129\u012c"+
		"\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\6\3\2\2\2\u012c"+
		"\u012a\3\2\2\2\u012d\u012f\4\62;\2\u012e\u012d\3\2\2\2\u012f\u0130\3\2"+
		"\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\b\3\2\2\2\u0132\u0134"+
		"\4\62;\2\u0133\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0133\3\2\2\2\u0135"+
		"\u0136\3\2\2\2\u0136\u013d\3\2\2\2\u0137\u0139\7\60\2\2\u0138\u013a\4"+
		"\62;\2\u0139\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u0139\3\2\2\2\u013b"+
		"\u013c\3\2\2\2\u013c\u013e\3\2\2\2\u013d\u0137\3\2\2\2\u013d\u013e\3\2"+
		"\2\2\u013e\n\3\2\2\2\u013f\u0144\7$\2\2\u0140\u0143\5\r\7\2\u0141\u0143"+
		"\n\4\2\2\u0142\u0140\3\2\2\2\u0142\u0141\3\2\2\2\u0143\u0146\3\2\2\2\u0144"+
		"\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0147\3\2\2\2\u0146\u0144\3\2"+
		"\2\2\u0147\u0148\7$\2\2\u0148\f\3\2\2\2\u0149\u014a\7^\2\2\u014a\u014b"+
		"\7$\2\2\u014b\16\3\2\2\2\u014c\u014d\t\5\2\2\u014d\u014e\b\b\2\2\u014e"+
		"\20\3\2\2\2\u014f\u0153\7}\2\2\u0150\u0152\n\6\2\2\u0151\u0150\3\2\2\2"+
		"\u0152\u0155\3\2\2\2\u0153\u0154\3\2\2\2\u0153\u0151\3\2\2\2\u0154\u0156"+
		"\3\2\2\2\u0155\u0153\3\2\2\2\u0156\u0157\7\177\2\2\u0157\u0158\b\t\3\2"+
		"\u0158\22\3\2\2\2\u0159\u0162\7?\2\2\u015a\u015b\7>\2\2\u015b\u0162\7"+
		"@\2\2\u015c\u0162\t\7\2\2\u015d\u015e\7>\2\2\u015e\u0162\7?\2\2\u015f"+
		"\u0160\7@\2\2\u0160\u0162\7?\2\2\u0161\u0159\3\2\2\2\u0161\u015a\3\2\2"+
		"\2\u0161\u015c\3\2\2\2\u0161\u015d\3\2\2\2\u0161\u015f\3\2\2\2\u0162\24"+
		"\3\2\2\2\u0163\u0164\t\b\2\2\u0164\26\3\2\2\2\u0165\u0166\t\t\2\2\u0166"+
		"\30\3\2\2\2\u0167\u0168\7\'\2\2\u0168\32\3\2\2\2\u0169\u016a\7>\2\2\u016a"+
		"\u016b\7/\2\2\u016b\34\3\2\2\2\u016c\u016d\7\60\2\2\u016d\u016e\7\60\2"+
		"\2\u016e\36\3\2\2\2\u016f\u0170\7*\2\2\u0170 \3\2\2\2\u0171\u0172\7+\2"+
		"\2\u0172\"\3\2\2\2\u0173\u0174\7]\2\2\u0174$\3\2\2\2\u0175\u0176\7_\2"+
		"\2\u0176&\3\2\2\2\u0177\u0178\t\n\2\2\u0178(\3\2\2\2\u0179\u017a\7(\2"+
		"\2\u017a*\3\2\2\2\u017b\u017c\7`\2\2\u017c,\3\2\2\2\u017d\u017f\13\2\2"+
		"\2\u017e\u017d\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0181\3\2\2\2\u0180\u017e"+
		"\3\2\2\2\u0181.\3\2\2\2\16\2\u0124\u012a\u0130\u0135\u013b\u013d\u0142"+
		"\u0144\u0153\u0161\u0180\4\3\b\2\3\t\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}