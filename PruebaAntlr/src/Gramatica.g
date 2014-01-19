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
ASIG_IGUAL;
INT_O_REAL;
}


sprog  : prog FIN;
prog {TablaSimbolos TBS;}:
						TBS=decs 
						(accs [TBS]);



decs returns [TablaSimbolos TB = new TablaSimbolos();]
		{Declaracion dec1; TablaSimbolos TBS;}:
						dec1=dec
						TBS=rdecs
						{TBS.insertaDec(dec1);
						TB=TBS;}
	  			|		
	  					{TB= new TablaSimbolos();}
	 					;
exception
catch [ANTLRException e]
{System.out.println (e.getMessage());
 System.out.println("Hemos descubierto un error");}
	 					
rdecs returns [TablaSimbolos TBS = new TablaSimbolos();]:
						SEP
						TBS=rrdecs
						;
rrdecs returns [TablaSimbolos TBS = new TablaSimbolos();]:
						TBS=decs
						;

dec returns [Declaracion deca = new Declaracion();]{String nombreTipo, nombreVar;}:
						nombreTipo=tipo
						ident:ID
						{
							nombreVar = ident.getText();
							System.out.println(nombreVar);
							Declaracion decla = new Declaracion (nombreTipo, nombreVar);
							deca=decla;
						}
						;

accs[TablaSimbolos TBh] : acc [TBh] racs[TBh];
racs [TablaSimbolos TBh] : SEP rracs [TBh];
rracs [TablaSimbolos TBh]: accs[TBh] | ;

acc [TablaSimbolos TBh] : in
	  |out [TBh]
      |accasign
      ;

in  : OP_IN ID;
out [TablaSimbolos TBh] : OP_OUT rout [TBh]
	  ;

rout [TablaSimbolos TBh]: acc [TBh]
	  | DELIM_PAREN_A rout [TBh] DELIM_PAREN_C
	  ;

accasign : ident:ID raccasign
;
raccasign: OP_AS value;
value    : raccasign | acccomp;

acccomp  : accadit racccomp;
racccomp : OP_COMP accadit
		   |OP_IGUAL accadit
		   | 
		;

accadit : accmult raccadit;
raccadit: OP_MAS accmult raccadit
		  | OP_MENOS accmult raccadit
		  | OP_OR accmult raccadit
		  |
		;

accmult  : accun raccmult;
raccmult :  OP_MUL_DIV accun raccmult
			| OP_AND accun raccmult 
			| OP_MOD accun raccmult
			|
		 ;

accun   : factor
		 | OP_MENOS accun//cambiar accun
		 | OP_NOT accun//cambiar accun
		 | DELIM_PAREN_A raccun
		 
	    ;

raccun : tipo DELIM_PAREN_C factor
		| acccomp DELIM_PAREN_C
		| in DELIM_PAREN_C
		;

factor : ID
		 |num
	   ;

num : REAL | ENTERO;
tipo returns [String tipo=""]:
			{tipo="real";} TIPOREAL
			|{tipo = "entero";} TIPOENT;



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
protected OP_NOT : '!';
protected OP_COMP : "!="|'>'|'<'|">="|"<=";


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

ASIG_IGUAL: (OP_AS '=')=> OP_IGUAL {$setType(OP_IGUAL);}
			| (OP_AS) => OP_AS {$setType(OP_AS);}
			; 
			
NOT_COMP: (OP_NOT ('='))=> OP_COMP {$setType(OP_COMP);}
		  | OP_NOT
		  ;

FIN : "$$";