class MiParser extends Parser;options {buildAST=true;}
tokens{
ENTERO ;
REAL;
ID;
Whitespace;
DELIM_PUNTOCOMA;
DELIM_PAREN_A;
DELIM_PAREN_C;
OP_IGUAL;
OP_AS;
OP_MAS;
OP_MENOS;
OP_MOD;
OP_MUL_DIV;
OP_OR ;
OP_AND;
OP_NOT;
OP_COMP;
OP_IN;
OP_OUT;
FIN ;
}


sprog: prog FIN;
prog : decs accs;



decs : dec rdecs
	  |
	 ;
rdecs : SEP rrdecs;
rrdecs : decs
		;

dec : tipo ID;


accs : acc racs;
racs : SEP rracs;
rracs: accs | ;

acc : in
	  |out
      |accasign
      ;

in  : OP_IN ID;
out : OP_OUT accasign;

accasign : ID raccasign;
raccasign: OP_AS value;
value    : raccasign | acccomp;

acccomp  : accadit racccomp;
racccomp : OP_COMP accadit
		   |OP_IGUAL accadit
		   | 
		;

accadit : accmult raccadit;
raccadit: OP_MAS accadit
		  | OP_MENOS accadit
		  | OP_OR accadit
		  |
		;

accmult  : accun raccmult;
raccmult :  OP_MUL_DIV accmult
			| OP_MOD accmult
			| OP_AND accmult
			|
		 ;

accun   : factor
		 | OP_MENOS factor
		 | OP_NOT factor
		 | DELIM_PAREN_A raccun
	    ;
raccun  : accadit DELIM_PAREN_C
		;
rraccun: DELIM_PAREN_C factor;

factor : ID
		 |num
	   ;

num : REAL | ENTERO;
tipo: TIPOREAL | TIPOENT;



class MiLexer extends Lexer; options {k=2;}
//------------------------- Analizador Lexico ------------------------ 

protected LETRA :('a'..'z') | ('A'..'Z');
protected DIGITO: '0'..'9';
protected DELIM_PUNTO : '.';
protected ENTERO : (DIGITO)+;
protected REAL : ENTERO (DELIM_PUNTO) (DIGITO)+;
protected TIPOREAL: ('R'|'r')('E'|'e')('A'|'a')('L'|'l');
protected TIPOENT: ('I'|'i')('N'|'n')('T'|'t');
protected OP_IN : ('I'|'i')('N'|'n');
protected OP_OUT : ('O'|'o')('U'|'u')('T'|'t');
protected ID : (LETRA | '_') (((LETRA) | ENTERO | '_' ))*  ( '?')? ;
protected OP_AS : '=';
protected OP_IGUAL: "==";

ID_TIPO_OPIN_OPOUT:   (OP_IN ('T'|'t') ' ')=> TIPOENT {$setType(TIPOENT);}
				| (OP_IN ('T'|'t') ~' ') => ID {$setType(ID);} 
				| (OP_IN ~('t'|' ')) => ID {$setType(ID);}
				| (OP_IN (' '))=> OP_IN {$setType(OP_IN);}
				| (OP_OUT ' ')=>OP_OUT {$setType(OP_OUT);}
		  		| (OP_OUT ~(' '))=> ID {$setType(ID);}
				| (ID) => ID {$setType(ID);}
		  ;

COMENTARIO : '@' ( LETRA|DIGITO|DELIM_PUNTO|' '|'\t')* ('\r') {$setType(Token.SKIP);};

INT_O_REAL: ( ENTERO (DELIM_PUNTO)) => REAL {$setType(REAL);}
			| ENTERO {$setType (ENTERO);}
			;


Whitespace :  (' ' | '\r' | '\n' | '\t')+  {$setType(Token.SKIP);};

SEP : ';';

DELIM_PAREN_A : '(';

DELIM_PAREN_C : ')';

OP_MAS : '+' ;

OP_MENOS : '-';

OP_MOD : '%';

OP_MUL_DIV : '*' | '/';

OP_OR : "||";

OP_AND : "&&";

OP_NOT : '!';

OP_COMP : "!="|'>'|'<'|">="|"<=";

ASIG_IGUAL: (OP_AS '=')=> OP_IGUAL {$setType(OP_IGUAL);}
			| (OP_AS) => OP_AS {$setType(OP_AS);}
			; 

FIN : "$$";