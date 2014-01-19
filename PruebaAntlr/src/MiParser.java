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
  this(tokenBuf,1);
}

protected MiParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public MiParser(TokenStream lexer) {
  this(lexer,1);
}

public MiParser(ParserSharedInputState state) {
  super(state,1);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

	public final void sprog() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST sprog_AST = null;
		
		try {      // for error handling
			prog();
			astFactory.addASTChild(currentAST, returnAST);
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
	
	public final void prog() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST prog_AST = null;
		TablaSimbolos TBS;
		
		try {      // for error handling
			TBS=decs();
			astFactory.addASTChild(currentAST, returnAST);
			{
			accs(TBS);
			astFactory.addASTChild(currentAST, returnAST);
			}
			prog_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
		returnAST = prog_AST;
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
			case ID:
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
		catch (ANTLRException e) {
			System.out.println (e.getMessage());
			System.out.println("Hemos descubierto un error");
		}
		returnAST = decs_AST;
		return TB;
	}
	
	public final void accs(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST accs_AST = null;
		
		try {      // for error handling
			acc(TBh);
			astFactory.addASTChild(currentAST, returnAST);
			racs(TBh);
			astFactory.addASTChild(currentAST, returnAST);
			accs_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
		returnAST = accs_AST;
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
										System.out.println(nombreVar);
										Declaracion decla = new Declaracion (nombreTipo, nombreVar);
										deca=decla;
									
			dec_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
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
			recover(ex,_tokenSet_3);
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
			recover(ex,_tokenSet_3);
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
	
	public final void acc(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST acc_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case OP_IN:
			{
				in();
				astFactory.addASTChild(currentAST, returnAST);
				acc_AST = (AST)currentAST.root;
				break;
			}
			case OP_OUT:
			{
				out(TBh);
				astFactory.addASTChild(currentAST, returnAST);
				acc_AST = (AST)currentAST.root;
				break;
			}
			case ID:
			{
				accasign();
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
	}
	
	public final void racs(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST racs_AST = null;
		
		try {      // for error handling
			AST tmp5_AST = null;
			tmp5_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp5_AST);
			match(SEP);
			rracs(TBh);
			astFactory.addASTChild(currentAST, returnAST);
			racs_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
		returnAST = racs_AST;
	}
	
	public final void rracs(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rracs_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case ID:
			case OP_IN:
			case OP_OUT:
			{
				accs(TBh);
				astFactory.addASTChild(currentAST, returnAST);
				rracs_AST = (AST)currentAST.root;
				break;
			}
			case FIN:
			{
				rracs_AST = (AST)currentAST.root;
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
		returnAST = rracs_AST;
	}
	
	public final void in() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST in_AST = null;
		
		try {      // for error handling
			AST tmp6_AST = null;
			tmp6_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp6_AST);
			match(OP_IN);
			AST tmp7_AST = null;
			tmp7_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp7_AST);
			match(ID);
			in_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		returnAST = in_AST;
	}
	
	public final void out(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST out_AST = null;
		
		try {      // for error handling
			AST tmp8_AST = null;
			tmp8_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp8_AST);
			match(OP_OUT);
			rout(TBh);
			astFactory.addASTChild(currentAST, returnAST);
			out_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		returnAST = out_AST;
	}
	
	public final void accasign() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST accasign_AST = null;
		Token  ident = null;
		AST ident_AST = null;
		
		try {      // for error handling
			ident = LT(1);
			ident_AST = astFactory.create(ident);
			astFactory.addASTChild(currentAST, ident_AST);
			match(ID);
			raccasign();
			astFactory.addASTChild(currentAST, returnAST);
			accasign_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		returnAST = accasign_AST;
	}
	
	public final void rout(
		TablaSimbolos TBh
	) throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rout_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case ID:
			case OP_IN:
			case OP_OUT:
			{
				acc(TBh);
				astFactory.addASTChild(currentAST, returnAST);
				rout_AST = (AST)currentAST.root;
				break;
			}
			case DELIM_PAREN_A:
			{
				AST tmp9_AST = null;
				tmp9_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp9_AST);
				match(DELIM_PAREN_A);
				rout(TBh);
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp10_AST = null;
				tmp10_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp10_AST);
				match(DELIM_PAREN_C);
				rout_AST = (AST)currentAST.root;
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
		returnAST = rout_AST;
	}
	
	public final void raccasign() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST raccasign_AST = null;
		
		try {      // for error handling
			AST tmp11_AST = null;
			tmp11_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp11_AST);
			match(OP_AS);
			value();
			astFactory.addASTChild(currentAST, returnAST);
			raccasign_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		returnAST = raccasign_AST;
	}
	
	public final void value() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST value_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case OP_AS:
			{
				raccasign();
				astFactory.addASTChild(currentAST, returnAST);
				value_AST = (AST)currentAST.root;
				break;
			}
			case ENTERO:
			case REAL:
			case ID:
			case DELIM_PAREN_A:
			case OP_MENOS:
			case OP_NOT:
			{
				acccomp();
				astFactory.addASTChild(currentAST, returnAST);
				value_AST = (AST)currentAST.root;
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
		returnAST = value_AST;
	}
	
	public final void acccomp() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST acccomp_AST = null;
		
		try {      // for error handling
			accadit();
			astFactory.addASTChild(currentAST, returnAST);
			racccomp();
			astFactory.addASTChild(currentAST, returnAST);
			acccomp_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		returnAST = acccomp_AST;
	}
	
	public final void accadit() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST accadit_AST = null;
		
		try {      // for error handling
			accmult();
			astFactory.addASTChild(currentAST, returnAST);
			raccadit();
			astFactory.addASTChild(currentAST, returnAST);
			accadit_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_6);
		}
		returnAST = accadit_AST;
	}
	
	public final void racccomp() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST racccomp_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case OP_COMP:
			{
				AST tmp12_AST = null;
				tmp12_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp12_AST);
				match(OP_COMP);
				accadit();
				astFactory.addASTChild(currentAST, returnAST);
				racccomp_AST = (AST)currentAST.root;
				break;
			}
			case OP_IGUAL:
			{
				AST tmp13_AST = null;
				tmp13_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp13_AST);
				match(OP_IGUAL);
				accadit();
				astFactory.addASTChild(currentAST, returnAST);
				racccomp_AST = (AST)currentAST.root;
				break;
			}
			case DELIM_PAREN_C:
			case SEP:
			{
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
	}
	
	public final void accmult() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST accmult_AST = null;
		
		try {      // for error handling
			accun();
			astFactory.addASTChild(currentAST, returnAST);
			raccmult();
			astFactory.addASTChild(currentAST, returnAST);
			accmult_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
		returnAST = accmult_AST;
	}
	
	public final void raccadit() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST raccadit_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case OP_MAS:
			{
				AST tmp14_AST = null;
				tmp14_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp14_AST);
				match(OP_MAS);
				accmult();
				astFactory.addASTChild(currentAST, returnAST);
				raccadit();
				astFactory.addASTChild(currentAST, returnAST);
				raccadit_AST = (AST)currentAST.root;
				break;
			}
			case OP_MENOS:
			{
				AST tmp15_AST = null;
				tmp15_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp15_AST);
				match(OP_MENOS);
				accmult();
				astFactory.addASTChild(currentAST, returnAST);
				raccadit();
				astFactory.addASTChild(currentAST, returnAST);
				raccadit_AST = (AST)currentAST.root;
				break;
			}
			case OP_OR:
			{
				AST tmp16_AST = null;
				tmp16_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp16_AST);
				match(OP_OR);
				accmult();
				astFactory.addASTChild(currentAST, returnAST);
				raccadit();
				astFactory.addASTChild(currentAST, returnAST);
				raccadit_AST = (AST)currentAST.root;
				break;
			}
			case DELIM_PAREN_C:
			case OP_IGUAL:
			case OP_COMP:
			case SEP:
			{
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
			recover(ex,_tokenSet_6);
		}
		returnAST = raccadit_AST;
	}
	
	public final void accun() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST accun_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case ENTERO:
			case REAL:
			case ID:
			{
				factor();
				astFactory.addASTChild(currentAST, returnAST);
				accun_AST = (AST)currentAST.root;
				break;
			}
			case OP_MENOS:
			{
				AST tmp17_AST = null;
				tmp17_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp17_AST);
				match(OP_MENOS);
				accun();
				astFactory.addASTChild(currentAST, returnAST);
				accun_AST = (AST)currentAST.root;
				break;
			}
			case OP_NOT:
			{
				AST tmp18_AST = null;
				tmp18_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp18_AST);
				match(OP_NOT);
				accun();
				astFactory.addASTChild(currentAST, returnAST);
				accun_AST = (AST)currentAST.root;
				break;
			}
			case DELIM_PAREN_A:
			{
				AST tmp19_AST = null;
				tmp19_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp19_AST);
				match(DELIM_PAREN_A);
				raccun();
				astFactory.addASTChild(currentAST, returnAST);
				accun_AST = (AST)currentAST.root;
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
		returnAST = accun_AST;
	}
	
	public final void raccmult() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST raccmult_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case OP_MUL_DIV:
			{
				AST tmp20_AST = null;
				tmp20_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp20_AST);
				match(OP_MUL_DIV);
				accun();
				astFactory.addASTChild(currentAST, returnAST);
				raccmult();
				astFactory.addASTChild(currentAST, returnAST);
				raccmult_AST = (AST)currentAST.root;
				break;
			}
			case OP_AND:
			{
				AST tmp21_AST = null;
				tmp21_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp21_AST);
				match(OP_AND);
				accun();
				astFactory.addASTChild(currentAST, returnAST);
				raccmult();
				astFactory.addASTChild(currentAST, returnAST);
				raccmult_AST = (AST)currentAST.root;
				break;
			}
			case OP_MOD:
			{
				AST tmp22_AST = null;
				tmp22_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp22_AST);
				match(OP_MOD);
				accun();
				astFactory.addASTChild(currentAST, returnAST);
				raccmult();
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
			{
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
			recover(ex,_tokenSet_7);
		}
		returnAST = raccmult_AST;
	}
	
	public final void factor() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST factor_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case ID:
			{
				AST tmp23_AST = null;
				tmp23_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp23_AST);
				match(ID);
				factor_AST = (AST)currentAST.root;
				break;
			}
			case ENTERO:
			case REAL:
			{
				num();
				astFactory.addASTChild(currentAST, returnAST);
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
			recover(ex,_tokenSet_8);
		}
		returnAST = factor_AST;
	}
	
	public final void raccun() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST raccun_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case TIPOREAL:
			case TIPOENT:
			{
				tipo();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp24_AST = null;
				tmp24_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp24_AST);
				match(DELIM_PAREN_C);
				factor();
				astFactory.addASTChild(currentAST, returnAST);
				raccun_AST = (AST)currentAST.root;
				break;
			}
			case ENTERO:
			case REAL:
			case ID:
			case DELIM_PAREN_A:
			case OP_MENOS:
			case OP_NOT:
			{
				acccomp();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp25_AST = null;
				tmp25_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp25_AST);
				match(DELIM_PAREN_C);
				raccun_AST = (AST)currentAST.root;
				break;
			}
			case OP_IN:
			{
				in();
				astFactory.addASTChild(currentAST, returnAST);
				AST tmp26_AST = null;
				tmp26_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp26_AST);
				match(DELIM_PAREN_C);
				raccun_AST = (AST)currentAST.root;
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
		returnAST = raccun_AST;
	}
	
	public final void num() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST num_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case REAL:
			{
				AST tmp27_AST = null;
				tmp27_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp27_AST);
				match(REAL);
				num_AST = (AST)currentAST.root;
				break;
			}
			case ENTERO:
			{
				AST tmp28_AST = null;
				tmp28_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp28_AST);
				match(ENTERO);
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
			recover(ex,_tokenSet_8);
		}
		returnAST = num_AST;
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
		"SEP",
		"TIPOREAL",
		"TIPOENT",
		"LETRA",
		"DIGITO",
		"DELIM_PUNTO",
		"ID_TIPO_OPIN_OPOUT",
		"COMENTARIO",
		"NOT_COMP"
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
		long[] data = { 67108864L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 6291520L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 1088L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 67109888L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 68160512L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { 68316160L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { 68676608L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	
	}
