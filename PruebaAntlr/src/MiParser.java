// $ANTLR : "Gramatica.g" -> "MiParser.java"$

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.collections.AST;
import java.util.Hashtable;
import antlr.ASTFactory;
import antlr.ASTPair;
import antlr.collections.impl.ASTArray;

public class MiParser extends antlr.LLkParser       implements MiParserTokenTypes
 {

protected MiParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public MiParser(TokenBuffer tokenBuf) {
  this(tokenBuf,2);
}

protected MiParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public MiParser(TokenStream lexer) {
  this(lexer,2);
}

public MiParser(ParserSharedInputState state) {
  super(state,2);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

	public final void sprog() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST sprog_AST = null;
		String cod;
		
		try {      // for error handling
			cod=prog();
			astFactory.addASTChild(currentAST, returnAST);
			
									System.out.println(cod);
								
			AST tmp1_AST = null;
			tmp1_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp1_AST);
			match(FIN);
			sprog_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = sprog_AST;
	}
	
	public final String  prog() throws RecognitionException, TokenStreamException {
		String cod="";;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST prog_AST = null;
		TablaSimbolos TBS;
		
		try {      // for error handling
			TBS=decs();
			astFactory.addASTChild(currentAST, returnAST);
			cod=accs(TBS);
			astFactory.addASTChild(currentAST, returnAST);
			prog_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
		returnAST = prog_AST;
		return cod;
	}
	
	public final TablaSimbolos  decs() throws RecognitionException, TokenStreamException {
		TablaSimbolos TB = new TablaSimbolos();;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST decs_AST = null;
		Declaracion dec1; TablaSimbolos TBS;
		
		try {      // for error handling
			switch ( LA(1)) {
			case TIPOREAL:
			case TIPOENT:
			{
				dec1=dec();
				astFactory.addASTChild(currentAST, returnAST);
				TBS=rdecs();
				astFactory.addASTChild(currentAST, returnAST);
				
										TBS.insertaDec(dec1);
										TB=TBS;
									
				decs_AST = (AST)currentAST.root;
				break;
			}
			case ENTERO:
			case REAL:
			case ID:
			case DELIM_PAREN_A:
			case OP_MENOS:
			case OP_NOT:
			case OP_IN:
			case OP_OUT:
			{
					
					  						TB= new TablaSimbolos();
					  				
				decs_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
		returnAST = decs_AST;
		return TB;
	}
	
	public final String  accs(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		String cod="";
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST accs_AST = null;
		String cod1, cod2;
		
		try {      // for error handling
			cod1=acc(TBh);
			astFactory.addASTChild(currentAST, returnAST);
			cod2=racs(TBh);
			astFactory.addASTChild(currentAST, returnAST);
				
									cod= cod1 + cod2 + "\n";
								
			accs_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
		returnAST = accs_AST;
		return cod;
	}
	
	public final Declaracion  dec() throws RecognitionException, TokenStreamException {
		Declaracion deca = new Declaracion();;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST dec_AST = null;
		Token  ident = null;
		AST ident_AST = null;
		String nombreTipo, nombreVar;
		
		try {      // for error handling
			nombreTipo=tipo();
			astFactory.addASTChild(currentAST, returnAST);
			ident = LT(1);
			ident_AST = astFactory.create(ident);
			astFactory.addASTChild(currentAST, ident_AST);
			match(ID);
			
									nombreVar = ident.getText();
									//System.out.println(nombreVar);
									Declaracion decla = new Declaracion (nombreTipo, nombreVar);
									deca=decla;
								
			dec_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
		returnAST = dec_AST;
		return deca;
	}
	
	public final TablaSimbolos  rdecs() throws RecognitionException, TokenStreamException {
		TablaSimbolos TBS = new TablaSimbolos();;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rdecs_AST = null;
		
		try {      // for error handling
			AST tmp2_AST = null;
			tmp2_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp2_AST);
			match(SEP);
			TBS=rrdecs();
			astFactory.addASTChild(currentAST, returnAST);
			rdecs_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
		returnAST = rdecs_AST;
		return TBS;
	}
	
	public final TablaSimbolos  rrdecs() throws RecognitionException, TokenStreamException {
		TablaSimbolos TBS = new TablaSimbolos();;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rrdecs_AST = null;
		
		try {      // for error handling
			TBS=decs();
			astFactory.addASTChild(currentAST, returnAST);
			rrdecs_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
		returnAST = rrdecs_AST;
		return TBS;
	}
	
	public final String  tipo() throws RecognitionException, TokenStreamException {
		String tipo="";
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST tipo_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case TIPOREAL:
			{
				tipo="real";
				AST tmp3_AST = null;
				tmp3_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp3_AST);
				match(TIPOREAL);
				tipo_AST = (AST)currentAST.root;
				break;
			}
			case TIPOENT:
			{
				tipo = "entero";
				AST tmp4_AST = null;
				tmp4_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp4_AST);
				match(TIPOENT);
				tipo_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
		returnAST = tipo_AST;
		return tipo;
	}
	
	public final String  acc(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		String cod="";
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST acc_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case OP_IN:
			{
				cod=in(TBh);
				astFactory.addASTChild(currentAST, returnAST);
				acc_AST = (AST)currentAST.root;
				break;
			}
			case OP_OUT:
			{
				cod=out(TBh);
				astFactory.addASTChild(currentAST, returnAST);
				acc_AST = (AST)currentAST.root;
				break;
			}
			case ENTERO:
			case REAL:
			case ID:
			case DELIM_PAREN_A:
			case OP_MENOS:
			case OP_NOT:
			{
				cod=exp(TBh);
				astFactory.addASTChild(currentAST, returnAST);
				acc_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		returnAST = acc_AST;
		return cod;
	}
	
	public final String  racs(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		String cod = "";
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST racs_AST = null;
		String cod1,desap;
		
		try {      // for error handling
			AST tmp5_AST = null;
			tmp5_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp5_AST);
			match(SEP);
			cod1=rraccs(TBh);
			astFactory.addASTChild(currentAST, returnAST);
				
									desap="desapila()\n";
									cod = desap + cod1;
								
			racs_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
		returnAST = racs_AST;
		return cod;
	}
	
	public final String  rraccs(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		String cod="";
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rraccs_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case ENTERO:
			case REAL:
			case ID:
			case DELIM_PAREN_A:
			case OP_MENOS:
			case OP_NOT:
			case OP_IN:
			case OP_OUT:
			{
				cod=accs(TBh);
				astFactory.addASTChild(currentAST, returnAST);
				rraccs_AST = (AST)currentAST.root;
				break;
			}
			case FIN:
			{
				rraccs_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
		returnAST = rraccs_AST;
		return cod;
	}
	
	public final String  in(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		String cod = "";
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST in_AST = null;
		Token  id = null;
		AST id_AST = null;
		Linea linea;
		
		try {      // for error handling
			AST tmp6_AST = null;
			tmp6_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp6_AST);
			match(OP_IN);
			id = LT(1);
			id_AST = astFactory.create(id);
			astFactory.addASTChild(currentAST, id_AST);
			match(ID);
			
									linea = TBh.getLinea(id.getText().toLowerCase());
									cod = "lectura("+linea.getDirMemoria()+")\n";
									cod += "apilaDir("+linea.getDirMemoria()+")\n";
								
			in_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		returnAST = in_AST;
		return cod;
	}
	
	public final String  out(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		String cod = "";
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST out_AST = null;
		String cod1;
		
		try {      // for error handling
			AST tmp7_AST = null;
			tmp7_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp7_AST);
			match(OP_OUT);
			cod1=exp(TBh);
			astFactory.addASTChild(currentAST, returnAST);
			
									cod += cod1 + "escritura()\n";
								
			out_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		returnAST = out_AST;
		return cod;
	}
	
	public final String  exp(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		String cod="";
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST exp_AST = null;
		Token  ident = null;
		AST ident_AST = null;
		String cod1;Linea linea;
		
		try {      // for error handling
			if ((LA(1)==ID) && (LA(2)==OP_AS)) {
				ident = LT(1);
				ident_AST = astFactory.create(ident);
				astFactory.addASTChild(currentAST, ident_AST);
				match(ID);
				AST tmp8_AST = null;
				tmp8_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp8_AST);
				match(OP_AS);
				cod1=accasign(TBh);
				astFactory.addASTChild(currentAST, returnAST);
				
										linea=TBh.getLinea(ident.getText().toLowerCase());
										cod=cod1+"desapilaDir("+linea.getDirMemoria()+")\n";
										cod+="apilaDir("+linea.getDirMemoria()+")\n";
									
				exp_AST = (AST)currentAST.root;
			}
			else if ((_tokenSet_6.member(LA(1))) && (_tokenSet_7.member(LA(2)))) {
				cod=acccomp(TBh);
				astFactory.addASTChild(currentAST, returnAST);
				exp_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		returnAST = exp_AST;
		return cod;
	}
	
	public final String  accasign(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		String cod="";
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST accasign_AST = null;
		
		try {      // for error handling
			cod=exp(TBh);
			astFactory.addASTChild(currentAST, returnAST);
			accasign_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		returnAST = accasign_AST;
		return cod;
	}
	
	public final String  acccomp(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		String cod="";;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST acccomp_AST = null;
		String cod1;
		
		try {      // for error handling
			cod1=accadit(TBh);
			astFactory.addASTChild(currentAST, returnAST);
			cod=racccomp(TBh,cod1);
			astFactory.addASTChild(currentAST, returnAST);
			acccomp_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		returnAST = acccomp_AST;
		return cod;
	}
	
	public final String  accadit(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		String cod="";;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST accadit_AST = null;
		String cod1;
		
		try {      // for error handling
			cod1=accmult(TBh);
			astFactory.addASTChild(currentAST, returnAST);
			cod=raccadit(TBh,cod1);
			astFactory.addASTChild(currentAST, returnAST);
			accadit_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_8);
		}
		returnAST = accadit_AST;
		return cod;
	}
	
	public final String  racccomp(
		TablaSimbolos TBh, String codh
	) throws RecognitionException, TokenStreamException {
		String cod="";;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST racccomp_AST = null;
		Token  opc = null;
		AST opc_AST = null;
		Token  opi = null;
		AST opi_AST = null;
		Token  opc1 = null;
		AST opc1_AST = null;
		Token  opc2 = null;
		AST opc2_AST = null;
		String op,cod1;
		
		try {      // for error handling
			switch ( LA(1)) {
			case OP_IGUAL:
			case OP_COMP:
			case OP_COMP1:
			case OP_COMP2:
			{
				{
				switch ( LA(1)) {
				case OP_COMP:
				{
					opc = LT(1);
					opc_AST = astFactory.create(opc);
					astFactory.addASTChild(currentAST, opc_AST);
					match(OP_COMP);
					break;
				}
				case OP_IGUAL:
				{
					opi = LT(1);
					opi_AST = astFactory.create(opi);
					astFactory.addASTChild(currentAST, opi_AST);
					match(OP_IGUAL);
					break;
				}
				case OP_COMP1:
				{
					opc1 = LT(1);
					opc1_AST = astFactory.create(opc1);
					astFactory.addASTChild(currentAST, opc1_AST);
					match(OP_COMP1);
					break;
				}
				case OP_COMP2:
				{
					opc2 = LT(1);
					opc2_AST = astFactory.create(opc2);
					astFactory.addASTChild(currentAST, opc2_AST);
					match(OP_COMP2);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				cod1=accadit(TBh);
				astFactory.addASTChild(currentAST, returnAST);
				
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
									
				racccomp_AST = (AST)currentAST.root;
				break;
			}
			case DELIM_PAREN_C:
			case SEP:
			{
				cod=codh;
				racccomp_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		returnAST = racccomp_AST;
		return cod;
	}
	
	public final String  accmult(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		String cod="";
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST accmult_AST = null;
		String cod1;
		
		try {      // for error handling
			cod1=accun(TBh);
			astFactory.addASTChild(currentAST, returnAST);
			cod=raccmult(TBh,cod1);
			astFactory.addASTChild(currentAST, returnAST);
			accmult_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_9);
		}
		returnAST = accmult_AST;
		return cod;
	}
	
	public final String  raccadit(
		TablaSimbolos TBh, String codh
	) throws RecognitionException, TokenStreamException {
		String cod="";
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST raccadit_AST = null;
		Token  opma = null;
		AST opma_AST = null;
		Token  opme = null;
		AST opme_AST = null;
		Token  opor = null;
		AST opor_AST = null;
		String cod1,cod2,op;
		
		try {      // for error handling
			switch ( LA(1)) {
			case OP_MAS:
			case OP_MENOS:
			case OP_OR:
			{
				{
				switch ( LA(1)) {
				case OP_MAS:
				{
					opma = LT(1);
					opma_AST = astFactory.create(opma);
					astFactory.addASTChild(currentAST, opma_AST);
					match(OP_MAS);
					break;
				}
				case OP_MENOS:
				{
					opme = LT(1);
					opme_AST = astFactory.create(opme);
					astFactory.addASTChild(currentAST, opme_AST);
					match(OP_MENOS);
					break;
				}
				case OP_OR:
				{
					opor = LT(1);
					opor_AST = astFactory.create(opor);
					astFactory.addASTChild(currentAST, opor_AST);
					match(OP_OR);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				cod1=accmult(TBh);
				astFactory.addASTChild(currentAST, returnAST);
				
										op="";
										if (opma!=null)
											op="suma()\n";
										if (opme!=null)
											op="resta()\n";
										if (opor!=null)
											op="or()\n";
										cod2=codh+cod1+op;
									
				cod=raccadit(TBh,cod2);
				astFactory.addASTChild(currentAST, returnAST);
				raccadit_AST = (AST)currentAST.root;
				break;
			}
			case DELIM_PAREN_C:
			case OP_IGUAL:
			case OP_COMP:
			case SEP:
			case OP_COMP1:
			case OP_COMP2:
			{
				cod=codh;
				raccadit_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_8);
		}
		returnAST = raccadit_AST;
		return cod;
	}
	
	public final String  accun(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		String cod="";;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST accun_AST = null;
		Token  opme = null;
		AST opme_AST = null;
		Token  opno = null;
		AST opno_AST = null;
		String op, cod1,cod2;
		
		try {      // for error handling
			if ((_tokenSet_10.member(LA(1))) && (_tokenSet_11.member(LA(2)))) {
				cod=factor(TBh);
				astFactory.addASTChild(currentAST, returnAST);
				accun_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==OP_MENOS||LA(1)==OP_NOT)) {
				{
				switch ( LA(1)) {
				case OP_MENOS:
				{
					opme = LT(1);
					opme_AST = astFactory.create(opme);
					astFactory.addASTChild(currentAST, opme_AST);
					match(OP_MENOS);
					break;
				}
				case OP_NOT:
				{
					opno = LT(1);
					opno_AST = astFactory.create(opno);
					astFactory.addASTChild(currentAST, opno_AST);
					match(OP_NOT);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				cod1=factor(TBh);
				astFactory.addASTChild(currentAST, returnAST);
				
										 op="";
										 if (opme!=null)
										 	op="invierte()\n";
										 else if (opno!=null)
										 	op="not()\n";
										 cod=cod1 + op;
									
				accun_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==DELIM_PAREN_A) && (LA(2)==TIPOREAL||LA(2)==TIPOENT)) {
				AST tmp9_AST = null;
				tmp9_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp9_AST);
				match(DELIM_PAREN_A);
				cod1=tipo();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp10_AST = null;
				tmp10_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp10_AST);
				match(DELIM_PAREN_C);
				cod2=factor(TBh);
				astFactory.addASTChild(currentAST, returnAST);
				
										cod = cod2 + "convierte_"+cod1+"()\n";
									
				accun_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_12);
		}
		returnAST = accun_AST;
		return cod;
	}
	
	public final String  raccmult(
		TablaSimbolos TBh,String codh
	) throws RecognitionException, TokenStreamException {
		String cod="";;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST raccmult_AST = null;
		Token  opmu = null;
		AST opmu_AST = null;
		Token  opan = null;
		AST opan_AST = null;
		Token  opmo = null;
		AST opmo_AST = null;
		String cod1,cod2,op;
		
		try {      // for error handling
			switch ( LA(1)) {
			case OP_MOD:
			case OP_MUL_DIV:
			case OP_AND:
			{
				{
				switch ( LA(1)) {
				case OP_MUL_DIV:
				{
					opmu = LT(1);
					opmu_AST = astFactory.create(opmu);
					astFactory.addASTChild(currentAST, opmu_AST);
					match(OP_MUL_DIV);
					break;
				}
				case OP_AND:
				{
					opan = LT(1);
					opan_AST = astFactory.create(opan);
					astFactory.addASTChild(currentAST, opan_AST);
					match(OP_AND);
					break;
				}
				case OP_MOD:
				{
					opmo = LT(1);
					opmo_AST = astFactory.create(opmo);
					astFactory.addASTChild(currentAST, opmo_AST);
					match(OP_MOD);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				cod1=accun(TBh);
				astFactory.addASTChild(currentAST, returnAST);
				
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
									
				cod=raccmult(TBh,cod2);
				astFactory.addASTChild(currentAST, returnAST);
				raccmult_AST = (AST)currentAST.root;
				break;
			}
			case DELIM_PAREN_C:
			case OP_IGUAL:
			case OP_MAS:
			case OP_MENOS:
			case OP_OR:
			case OP_COMP:
			case SEP:
			case OP_COMP1:
			case OP_COMP2:
			{
				cod=codh;
				raccmult_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_9);
		}
		returnAST = raccmult_AST;
		return cod;
	}
	
	public final String  factor(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		String cod="";;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST factor_AST = null;
		Token  iden = null;
		AST iden_AST = null;
		Linea linea;
		
		try {      // for error handling
			switch ( LA(1)) {
			case ENTERO:
			case REAL:
			{
				cod=num();
				astFactory.addASTChild(currentAST, returnAST);
				factor_AST = (AST)currentAST.root;
				break;
			}
			case ID:
			{
				iden = LT(1);
				iden_AST = astFactory.create(iden);
				astFactory.addASTChild(currentAST, iden_AST);
				match(ID);
				
										linea=TBh.getLinea(iden.getText().toLowerCase());
										cod= "apilaDir("+linea.getDirMemoria()+")\n";
									
				factor_AST = (AST)currentAST.root;
				break;
			}
			case DELIM_PAREN_A:
			{
				AST tmp11_AST = null;
				tmp11_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp11_AST);
				match(DELIM_PAREN_A);
				cod=acc(TBh);
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp12_AST = null;
				tmp12_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp12_AST);
				match(DELIM_PAREN_C);
				factor_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_12);
		}
		returnAST = factor_AST;
		return cod;
	}
	
	public final String  num() throws RecognitionException, TokenStreamException {
		String cod="";;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST num_AST = null;
		Token  r = null;
		AST r_AST = null;
		Token  e = null;
		AST e_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case REAL:
			{
				r = LT(1);
				r_AST = astFactory.create(r);
				astFactory.addASTChild(currentAST, r_AST);
				match(REAL);
				
										cod="apila("+r.getText()+")\n";
									
				num_AST = (AST)currentAST.root;
				break;
			}
			case ENTERO:
			{
				e = LT(1);
				e_AST = astFactory.create(e);
				astFactory.addASTChild(currentAST, e_AST);
				match(ENTERO);
				
										cod="apila("+e.getText()+")\n";
									
				num_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_12);
		}
		returnAST = num_AST;
		return cod;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"ENTERO",
		"REAL",
		"ID",
		"Whitespace",
		"DELIM_PUNTOCOMA",
		"DELIM_PAREN_A",
		"DELIM_PAREN_C",
		"OP_IGUAL",
		"OP_AS",
		"OP_MAS",
		"OP_MENOS",
		"OP_MOD",
		"OP_MUL_DIV",
		"OP_OR",
		"OP_AND",
		"OP_NOT",
		"OP_COMP",
		"OP_IN",
		"OP_OUT",
		"FIN",
		"ASIG_IGUAL",
		"INT_O_REAL",
		"COMP1_2",
		"NOT_COMP",
		"SEP",
		"OP_COMP1",
		"OP_COMP2",
		"TIPOREAL",
		"TIPOENT",
		"LETRA",
		"DIGITO",
		"DELIM_PUNTO",
		"SALTODELINEA",
		"ID_TIPO_OPIN_OPOUT",
		"COMENTARIO"
	};
	
	protected void buildTokenTypeASTClassMap() {
		tokenTypeToASTClassMap=null;
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 8388608L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 6832752L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 268435456L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 1088L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 268436480L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 541296L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { 8329883248L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { 1880099840L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = { 1880255488L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = { 624L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = { 1887432304L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = { 1880615936L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	
	}
