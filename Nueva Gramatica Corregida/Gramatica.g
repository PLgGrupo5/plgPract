class MiParser extends Parser;options {k=2;buildAST=true;}


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
ASIG_IGUAL;
INT_O_REAL;
COMP1_2;
NOT_COMP;
}


sprog : prog FIN;
prog :decs accs	;

//====================================================
//DECLARACIONES
//====================================================

decs: dec rdecs
		|
		;
	 					
rdecs :	SEP rrdecs	;
rrdecs:decs	;

dec:tipo ID	;
// Hay otra forma mas simple de escribirlo. Asi es dificil de entender (rdecs , rrdecs).


//====================================================
//ACCIONES
//====================================================

accs:acc racs;
racs: SEP rraccs ;
rraccs: accs
	|
	;
// Hay otra forma mas simple de escribirlo. Asi es dificil de entender (rdecs , rrdecs).

acc : in 
	 |out
     |exp
     ;

out: OP_OUT exp; // Aqui hay una recursion que no mola nada. Aunque no veamos que falle, es indeterminista.
in : OP_IN id:ID;

exp:ID OP_AS accasign
		|acccomp;

accasign: acc; //NO RESPETA PRIORIDADES

acccomp: accadit racccomp;
racccomp: (OP_COMP|OP_IGUAL|OP_COMP1|OP_COMP2) accadit 
			| 
			;
			
accadit: accmult raccadit;
raccadit: (OP_MAS|OP_MENOS|OP_OR) accmult raccadit
			|
			;

accmult: accun raccmult;
raccmult: (OP_MUL_DIV|OP_AND|OP_MOD) accun raccmult
			|
			;

accun: factor
		| (OP_MENOS|OP_NOT) accun
		| DELIM_PAREN_A tipo DELIM_PAREN_C accun
		;
			
factor: num
		|ID
		| DELIM_PAREN_A acc DELIM_PAREN_C
		;

num :REAL
	|ENTERO
	;

tipo :TIPOREAL
	|TIPOENT;



class MiLexer extends Lexer; options {k=2;}
//------------------------- Analizador Lexico ------------------------ 

protected LETRA :('a'..'z') | ('A'..'Z');
protected DIGITO: '0'..'9';
protected DELIM_PUNTO : '.';
protected ENTERO : ('1'|'2'|'3'|'4'|'5'|'6'|'7'|'8'|'9')(DIGITO)*;
protected REAL : ENTERO (DELIM_PUNTO) (DIGITO)+;
protected TIPOREAL: ('R'|'r')('E'|'e')('A'|'a')('L'|'l');
protected TIPOENT: ('I'|'i')('N'|'n')('T'|'t');
protected OP_IN : ('I'|'i')('N'|'n');
protected OP_OUT : ('O'|'o')('U'|'u')('T'|'t');
protected ID : (LETRA | '_') (((LETRA) | ENTERO | '_' ))*  ( '?')? ;
protected OP_AS : '=';
protected OP_IGUAL: "==";
protected OP_NOT : '!';

protected OP_COMP : "!=";
protected OP_COMP1 : '>'|'<';
protected OP_COMP2 : ">="|"<=";


COMP1_2: (OP_COMP1 '=')=> OP_COMP2 {$setType(OP_COMP2);}
		|(OP_COMP1) => OP_COMP1 {$setType(OP_COMP1);}
		;

ID_TIPO_OPIN_OPOUT:   (OP_IN ('T'|'t') ' ')=> TIPOENT {$setType(TIPOENT);}
				| (OP_IN ('T'|'t') ~' ') => ID {$setType(ID);} 
				| (OP_IN ~('t'|' ')) => ID {$setType(ID);}
				| (OP_IN (' '))=> OP_IN {$setType(OP_IN);}
				| (OP_OUT ' ')=>OP_OUT {$setType(OP_OUT);}
		  		| (OP_OUT ~(' '))=> ID {$setType(ID);}
		  		| (TIPOREAL ' ')=> TIPOREAL {$setType(TIPOREAL);}
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

ASIG_IGUAL: (OP_AS '=')=> OP_IGUAL {$setType(OP_IGUAL);}
			| (OP_AS) => OP_AS {$setType(OP_AS);}
			; 
			
NOT_COMP: (OP_NOT ('='))=> OP_COMP {$setType(OP_COMP);}
		  | (OP_NOT) => OP_NOT {$setType(OP_NOT);}
		  ;

FIN : "$$";