import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SQLParser extends Parser {
    static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
        new PredictionContextCache();
    public static final int
        SELECT=1, FROM=2, WHERE=3, GROUP=4, BY=5, HAVING=6, UNION=7, ALL=8, AS=9, 
        DISTINCT=10, CASE=11, WHEN=12, THEN=13, ELSE=14, END=15, COLLATE=16, 
        IN=17, NOT=18, AND=19, OR=20, EXISTS=21, LIKE=22, GLOB=23, REGEXP=24, 
        MATCH=25, ESCAPE=26, ISNULL=27, NOTNULL=28, NULL=29, BETWEEN=30, IDENTIFIER=31, 
        NUMERIC_LITERAL=32, STRING_LITERAL=33, SPACES=34;
    public static final int
        RULE_parse = 0, RULE_sql_stmt_list = 1, RULE_sql_stmt = 2, RULE_select_stmt = 3, 
        RULE_select_core = 4, RULE_result_column = 5, RULE_table_or_subquery = 6, 
        RULE_expr = 7, RULE_keyword = 8;
    private static String[] makeRuleNames() {
        return new String[] {
            "parse", "sql_stmt_list", "sql_stmt", "select_stmt", "select_core", 
            "result_column", "table_or_subquery", "expr", "keyword"
        };
    }
    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[] {
        };
    }
    private static final String[] _LITERAL_NAMES = makeLiteralNames();
    private static String[] makeSymbolicNames() {
        return new String[] {
            null, "SELECT", "FROM", "WHERE", "GROUP", "BY", "HAVING", "UNION", "ALL", 
            "AS", "DISTINCT", "CASE", "WHEN", "THEN", "ELSE", "END", "COLLATE", 
            "IN", "NOT", "AND", "OR", "EXISTS", "LIKE", "GLOB", "REGEXP", "MATCH", 
            "ESCAPE", "ISNULL", "NOTNULL", "NULL", "BETWEEN", "IDENTIFIER", "NUMERIC_LITERAL", 
            "STRING_LITERAL", "SPACES"
        };
    }
    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    @Override
    @Deprecated
    public String getGrammarFileName() { return "SQL.g4"; }

    @Override
    public String[] getRuleNames() { return ruleNames; }

    @Override
    public String getSerializedATN() { return _serializedATN; }

    @Override
    public ATN getATN() { return _ATN; }

    public SQLParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
    }

	
    public static class ParseContext extends ParserRuleContext {
        public Sql_stmt_listContext sql_stmt_list() {
            return getRuleContext(Sql_stmt_listContext.class,0);
        }
        public TerminalNode EOF() { return getToken(SQLParser.EOF, 0); }
        public ParseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_parse; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof SQLListener ) (listener).enterParse(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof SQLListener ) ((SQLListener)listener).exitParse(this);
        }
    }


    public final ParseContext parse() throws RecognitionException {
        ParseContext _localctx = new ParseContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_parse);
        try {
            enterOuterAlt(_localctx, 1);
            {
            setState(18);
            //sql_stmt_list();
            setState(19);
            match(EOF);
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
		"\u0004\u0001+\u009e\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0005\u0001$\b\u0001\n\u0001\f\u0001"+
		"\'\t\u0001\u0001\u0001\u0001\u0001\u0004\u0001+\b\u0001\u000b\u0001\f"+
		"\u0001,\u0005\u0001/\b\u0001\n\u0001\f\u00012\t\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u00039\b\u0003\u0001"+
		"\u0003\u0005\u0003<\b\u0003\n\u0003\f\u0003?\t\u0003\u0001\u0004\u0001"+
		"\u0004\u0003\u0004C\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004H\b\u0004\n\u0004\f\u0004K\t\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0005\u0004Q\b\u0004\n\u0004\f\u0004T\t\u0004\u0003"+
		"\u0004V\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004]\b\u0004\n\u0004\f\u0004`\t\u0004\u0003\u0004b\b\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005j\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006q\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007y\b\u0007\n\u0007\f\u0007"+
		"|\t\u0007\u0001\u0007\u0003\u0007\u007f\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0087\b\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0003\r\u009a\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0000\u0000\u000f"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u0000\u0002\u0002\u0000((**\u0002\u0000\u0019 \"$\u00a4\u0000\u001e"+
		"\u0001\u0000\u0000\u0000\u0002!\u0001\u0000\u0000\u0000\u00043\u0001\u0000"+
		"\u0000\u0000\u00065\u0001\u0000\u0000\u0000\b@\u0001\u0000\u0000\u0000"+
		"\ni\u0001\u0000\u0000\u0000\fp\u0001\u0000\u0000\u0000\u000e\u0086\u0001"+
		"\u0000\u0000\u0000\u0010\u0088\u0001\u0000\u0000\u0000\u0012\u008a\u0001"+
		"\u0000\u0000\u0000\u0014\u008c\u0001\u0000\u0000\u0000\u0016\u008e\u0001"+
		"\u0000\u0000\u0000\u0018\u0090\u0001\u0000\u0000\u0000\u001a\u0099\u0001"+
		"\u0000\u0000\u0000\u001c\u009b\u0001\u0000\u0000\u0000\u001e\u001f\u0003"+
		"\u0002\u0001\u0000\u001f \u0005\u0000\u0000\u0001 \u0001\u0001\u0000\u0000"+
		"\u0000!%\u0003\u0004\u0002\u0000\"$\u0005\u0001\u0000\u0000#\"\u0001\u0000"+
		"\u0000\u0000$\'\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000%&\u0001"+
		"\u0000\u0000\u0000&0\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000"+
		"(*\u0003\u0004\u0002\u0000)+\u0005\u0001\u0000\u0000*)\u0001\u0000\u0000"+
		"\u0000+,\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000,-\u0001\u0000"+
		"\u0000\u0000-/\u0001\u0000\u0000\u0000.(\u0001\u0000\u0000\u0000/2\u0001"+
		"\u0000\u0000\u00000.\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u0000"+
		"1\u0003\u0001\u0000\u0000\u000020\u0001\u0000\u0000\u000034\u0003\u0006"+
		"\u0003\u00004\u0005\u0001\u0000\u0000\u00005=\u0003\b\u0004\u000068\u0005"+
		"\u001d\u0000\u000079\u0005\u001e\u0000\u000087\u0001\u0000\u0000\u0000"+
		"89\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:<\u0003\b\u0004\u0000"+
		";6\u0001\u0000\u0000\u0000<?\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000"+
		"\u0000=>\u0001\u0000\u0000\u0000>\u0007\u0001\u0000\u0000\u0000?=\u0001"+
		"\u0000\u0000\u0000@B\u0005\u0019\u0000\u0000AC\u0005\u001e\u0000\u0000"+
		"BA\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000"+
		"\u0000DI\u0003\n\u0005\u0000EF\u0005\u0005\u0000\u0000FH\u0003\n\u0005"+
		"\u0000GE\u0001\u0000\u0000\u0000HK\u0001\u0000\u0000\u0000IG\u0001\u0000"+
		"\u0000\u0000IJ\u0001\u0000\u0000\u0000JU\u0001\u0000\u0000\u0000KI\u0001"+
		"\u0000\u0000\u0000LM\u0005\u001a\u0000\u0000MR\u0003\f\u0006\u0000NO\u0005"+
		"\u0005\u0000\u0000OQ\u0003\f\u0006\u0000PN\u0001\u0000\u0000\u0000QT\u0001"+
		"\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000"+
		"SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000UL\u0001\u0000\u0000"+
		"\u0000UV\u0001\u0000\u0000\u0000Va\u0001\u0000\u0000\u0000WX\u0005\u001b"+
		"\u0000\u0000XY\u0005\u001c\u0000\u0000Y^\u0003\u000e\u0007\u0000Z[\u0005"+
		"\u0005\u0000\u0000[]\u0003\u000e\u0007\u0000\\Z\u0001\u0000\u0000\u0000"+
		"]`\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000"+
		"\u0000_b\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000aW\u0001\u0000"+
		"\u0000\u0000ab\u0001\u0000\u0000\u0000b\t\u0001\u0000\u0000\u0000cj\u0005"+
		"\u0007\u0000\u0000de\u0003\u0016\u000b\u0000ef\u0005\u0002\u0000\u0000"+
		"fg\u0005\u0007\u0000\u0000gj\u0001\u0000\u0000\u0000hj\u0003\u000e\u0007"+
		"\u0000ic\u0001\u0000\u0000\u0000id\u0001\u0000\u0000\u0000ih\u0001\u0000"+
		"\u0000\u0000j\u000b\u0001\u0000\u0000\u0000kq\u0003\u0016\u000b\u0000"+
		"lm\u0005\u0003\u0000\u0000mn\u0003\u0006\u0003\u0000no\u0005\u0004\u0000"+
		"\u0000oq\u0001\u0000\u0000\u0000pk\u0001\u0000\u0000\u0000pl\u0001\u0000"+
		"\u0000\u0000q\r\u0001\u0000\u0000\u0000r\u0087\u0003\u0014\n\u0000st\u0003"+
		"\u0010\b\u0000t~\u0005\u0003\u0000\u0000uz\u0003\u000e\u0007\u0000vw\u0005"+
		"\u0005\u0000\u0000wy\u0003\u000e\u0007\u0000xv\u0001\u0000\u0000\u0000"+
		"y|\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000"+
		"\u0000{\u007f\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000}\u007f"+
		"\u0005\u0007\u0000\u0000~u\u0001\u0000\u0000\u0000~}\u0001\u0000\u0000"+
		"\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000"+
		"\u0080\u0081\u0005\u0004\u0000\u0000\u0081\u0087\u0001\u0000\u0000\u0000"+
		"\u0082\u0083\u0005\u0003\u0000\u0000\u0083\u0084\u0003\u000e\u0007\u0000"+
		"\u0084\u0085\u0005\u0004\u0000\u0000\u0085\u0087\u0001\u0000\u0000\u0000"+
		"\u0086r\u0001\u0000\u0000\u0000\u0086s\u0001\u0000\u0000\u0000\u0086\u0082"+
		"\u0001\u0000\u0000\u0000\u0087\u000f\u0001\u0000\u0000\u0000\u0088\u0089"+
		"\u0003\u001a\r\u0000\u0089\u0011\u0001\u0000\u0000\u0000\u008a\u008b\u0007"+
		"\u0000\u0000\u0000\u008b\u0013\u0001\u0000\u0000\u0000\u008c\u008d\u0003"+
		"\u001a\r\u0000\u008d\u0015\u0001\u0000\u0000\u0000\u008e\u008f\u0003\u001a"+
		"\r\u0000\u008f\u0017\u0001\u0000\u0000\u0000\u0090\u0091\u0007\u0000\u0000"+
		"\u0000\u0091\u0019\u0001\u0000\u0000\u0000\u0092\u009a\u0005(\u0000\u0000"+
		"\u0093\u009a\u0003\u001c\u000e\u0000\u0094\u009a\u0005*\u0000\u0000\u0095"+
		"\u0096\u0005\u0003\u0000\u0000\u0096\u0097\u0003\u001a\r\u0000\u0097\u0098"+
		"\u0005\u0004\u0000\u0000\u0098\u009a\u0001\u0000\u0000\u0000\u0099\u0092"+
		"\u0001\u0000\u0000\u0000\u0099\u0093\u0001\u0000\u0000\u0000\u0099\u0094"+
		"\u0001\u0000\u0000\u0000\u0099\u0095\u0001\u0000\u0000\u0000\u009a\u001b"+
		"\u0001\u0000\u0000\u0000\u009b\u009c\u0007\u0001\u0000\u0000\u009c\u001d"+
		"\u0001\u0000\u0000\u0000\u0011%,08=BIRU^aipz~\u0086\u0099";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
