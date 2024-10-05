grammar SQL;

parse
 : sql_stmt_list EOF
 ;

sql_stmt_list
 : sql_stmt ';'* ( sql_stmt ';'+ )*
 ;

sql_stmt
 : select_stmt
 ;

select_stmt
 : select_core ( UNION ALL? select_core )*
 ;

select_core
 : SELECT ( ALL )? result_column ( ',' result_column )*
   ( FROM table_or_subquery ( ',' table_or_subquery )* )?
   ( GROUP BY expr ( ',' expr )* )?
 ;

result_column
 : '*'
 | table_name '.' '*'
 | expr
 ;

table_or_subquery
 : table_name
 | '(' select_stmt ')'
 ;

expr
 : column_name
 | function_name '(' ( expr ( ',' expr )* | '*' )? ')'
 | '(' expr ')'
 ;

function_name
 : any_name
 ;

column_alias
 : IDENTIFIER
 | STRING_LITERAL
 ;

column_name 
 : any_name
 ;

table_name 
 : any_name
 ;

table_alias
 : IDENTIFIER
 | STRING_LITERAL
 ;

any_name
 : IDENTIFIER
 | keyword
 | STRING_LITERAL
 | '(' any_name ')'
 ;

keyword
 : SELECT | FROM | GROUP | BY | UNION | ALL | CASE | END | NOT | AND | OR
 ;

SCOL : ';';
DOT : '.';
OPEN_PAR : '(';
CLOSE_PAR : ')';
COMMA : ',';
ASSIGN : '=';
STAR : '*';
PLUS : '+';
MINUS : '-';
TILDE : '~';
PIPE2 : '||';
DIV : '/';
MOD : '%';
LT2 : '<<';
GT2 : '>>';
AMP : '&';
PIPE : '|';
LT : '<';
LT_EQ : '<=';
GT : '>';
GT_EQ : '>=';
EQ : '==';
NOT_EQ1 : '!=';
NOT_EQ2 : '<>';

// Keywords
SELECT : S E L E C T;
FROM : F R O M;
GROUP : G R O U P;
BY : B Y;
UNION : U N I O N;
ALL : A L L;
CASE : C A S E;
END : E N D;
IN : I N;
NOT : N O T;
AND : A N D;
OR : O R;
ISNULL : I S N U L L;
NOTNULL : N O T N U L L;
NULL : N U L L;

IDENTIFIER
 : [a-zA-Z_] [a-zA-Z_0-9]*
 ;

NUMERIC_LITERAL
 : DIGIT+ ( '.' DIGIT* )? ( E [-+]? DIGIT+ )?
 | '.' DIGIT+ ( E [-+]? DIGIT+ )?
 ;

STRING_LITERAL
 : '\'' ( ~'\'' | '\'\'' )* '\''
 ;

SPACES
 : [ \t\r\n] -> skip
 ;

fragment DIGIT : [0-9];

fragment A : [aA];
fragment B : [bB];
fragment C : [cC];
fragment D : [dD];
fragment E : [eE];
fragment F : [fF];
fragment G : [gG];
fragment H : [hH];
fragment I : [iI];
fragment J : [jJ];
fragment K : [kK];
fragment L : [lL];
fragment M : [mM];
fragment N : [nN];
fragment O : [oO];
fragment P : [pP];
fragment Q : [qQ];
fragment R : [rR];
fragment S : [sS];
fragment T : [tT];
fragment U : [uU];
fragment V : [vV];
fragment W : [wW];
fragment X : [xX];
fragment Y : [yY];
fragment Z : [zZ];