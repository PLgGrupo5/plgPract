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


sprog {String cod;}:
					cod=prog
					{
						System.out.println(cod);
					}
					FIN
					;
prog returns [String cod="";]{TablaSimbolos TBS;}:
					TBS=decs
					cod=accs[TBS]
					;

//====================================================
//DECLARACIONES
//====================================================

decs returns [TablaSimbolos TB = new TablaSimbolos();]
			{Declaracion dec1; TablaSimbolos TBS;}:
					dec1=dec
					TBS=rdecs
					{
						TBS.insertaDec(dec1);
						TB=TBS;
					}
					|
					{	
	  						TB= new TablaSimbolos();
	  				}
					;
	 					
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
						//System.out.println(nombreVar);
						Declaracion decla = new Declaracion (nombreTipo, nombreVar);
						deca=decla;
					}
					;




//====================================================
//ACCIONES
//====================================================

accs [TablaSimbolos TBh] returns [String cod=""]{String cod1, cod2;}:
					cod1=acc[TBh]
					cod2=racs[TBh]
					{	
						cod= cod1 + cod2 + "\n";
					}
					;

racs [TablaSimbolos TBh] returns [String cod = ""] {String cod1,desap;}:
					SEP
					cod1=rraccs[TBh]
					{	
						desap="desapila()\n";
						cod = desap + cod1;
					}
					;


rraccs [TablaSimbolos TBh]returns [String cod=""]:
					cod=accs[TBh]
					|
					;

acc [TablaSimbolos TBh] returns [String cod=""] :
					cod=in[TBh] 
	 				|cod=out[TBh]
     				|cod=exp[TBh]
     				;


in [TablaSimbolos TBh] returns [String cod = ""]{Linea linea;}:
					OP_IN
					id:ID
					{
						linea = TBh.getLinea(id.getText().toLowerCase());
						cod = "lectura("+linea.getDirMemoria()+")\n";
						cod += "apilaDir("+linea.getDirMemoria()+")\n";
					}
					;
out[TablaSimbolos TBh]returns [String cod = ""]{String cod1;}:
					OP_OUT
					cod1=exp[TBh]
					{
						cod += cod1 + "escritura()\n";
					}
					;



exp[TablaSimbolos TBh] returns [String cod=""]{String cod1;Linea linea;}:
					ident:ID
					OP_AS
					cod1=accasign[TBh]
					{
						linea=TBh.getLinea(ident.getText().toLowerCase());
						cod=cod1+"desapilaDir("+linea.getDirMemoria()+")\n";
						cod+="apilaDir("+linea.getDirMemoria()+")\n";
					}
					|cod=acccomp[TBh]
					;

accasign [TablaSimbolos TBh]returns [String cod=""]:
					cod=exp[TBh]
					;

acccomp[TablaSimbolos TBh]returns [String cod="";]{String cod1;}:
					cod1=accadit[TBh]
					cod=racccomp[TBh,cod1]
					;

racccomp[TablaSimbolos TBh, String codh] returns [String cod="";]{String op,cod1;}:
					(opc:OP_COMP|opi:OP_IGUAL|opc1:OP_COMP1|opc2:OP_COMP2)
					cod1=accadit[TBh]
					{
						op="";
						if (opi!=null)
							op="igual()\n";
						else if (opc!=null)
						{
							op="distinto()\n";
						}
						else if (opc1!=null)
								{
									if (opc1.getText()=="<=")
										op="menor_o_igual()\n";
									else
										op="mayor_o_igual()\n";
								}else if (opc2!=null)
								{
									if (opc2.getText()=="<")
										op="menor_que()\n";
									else
										op="mayor_que()\n";
								}
						cod=codh+cod1+op;
					}
		  			| {cod=codh;}
					;
			
accadit[TablaSimbolos TBh]returns [String cod="";]{String cod1;}:
					cod1=accmult[TBh]
					cod=raccadit[TBh,cod1]
					;
raccadit[TablaSimbolos TBh, String codh]returns [String cod=""]{String cod1,cod2,op;}:
					(opma:OP_MAS|opme:OP_MENOS|opor:OP_OR)
					cod1=accmult[TBh]
					{
						op="";
						if (opma!=null)
							op="suma()\n";
						if (opme!=null)
							op="resta()\n";
						if (opor!=null)
							op="or()\n";
						cod2=codh+cod1+op;
					}
					cod=raccadit[TBh,cod2]
					|{cod=codh;}
					;

accmult[TablaSimbolos TBh]returns [String cod=""]{String cod1;}:
					cod1=accun[TBh]
					cod=raccmult[TBh,cod1];
raccmult[TablaSimbolos TBh,String codh]returns [String cod="";] {String cod1,cod2,op;}:
					(opmu:OP_MUL_DIV|opan:OP_AND|opmo:OP_MOD)
					cod1=accun[TBh]
					{
						op="";
						if (opmu!=null)
							if (opmu.getText()=="*")
								op="multiplicacion()\n";
							else
								op="division()\n";
						if (opan!=null)
							op="and()\n";
						if (opmo!=null)
							op="modulo()\n";
						cod2=codh+cod1+op;
					}
					cod=raccmult[TBh,cod2]
					|{cod=codh;}
					;

accun[TablaSimbolos TBh] returns [String cod="";]{String op, cod1,cod2;}:
					cod=factor[TBh]
					| (opme:OP_MENOS|opno:OP_NOT)
					cod1=factor[TBh]
					{
						 op="";
						 if (opme!=null)
						 	op="invierte()\n";
						 else if (opno!=null)
						 	op="not()\n";
						 cod=cod1 + op;
					}
					| DELIM_PAREN_A
					cod1=tipo
					DELIM_PAREN_C
					cod2=factor[TBh]
					{
						cod = cod2 + "convierte_"+cod1+"()\n";
					}
					;
			
factor[TablaSimbolos TBh]returns [String cod="";]{Linea linea;}:
					cod=num
					|iden:ID
					{
						linea=TBh.getLinea(iden.getText().toLowerCase());
						cod= "apilaDir("+linea.getDirMemoria()+")\n";
					}
					|DELIM_PAREN_A cod=acc[TBh] DELIM_PAREN_C
					;

num returns[String cod="";]: r:REAL
					{
						cod="apila("+r.getText()+")\n";
					} 
					| e:ENTERO
					{
						cod="apila("+e.getText()+")\n";
					} 
					;

tipo returns [String tipo=""]:
					{tipo="real";}TIPOREAL
					|{tipo = "entero";}TIPOENT
					;



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

SALTODELINEA:('\n'|'\r'| "\r\n")
			{
				$setType(Token.SKIP);
				newline();
			}
			;

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

COMENTARIO : '@' ( ~('\n'|'\r') )* {$setType(Token.SKIP);};


INT_O_REAL: ( ENTERO (DELIM_PUNTO)) => REAL {$setType(REAL);}
			| ENTERO {$setType (ENTERO);}
			;


//Whitespace :  (' ' | '\r' | '\n' | '\t')+  {$setType(Token.SKIP);};

Whitespace :  (' '  | '\t')+  {$setType(Token.SKIP);};
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