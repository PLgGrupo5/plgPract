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
		
		try {      // for error handling
			decs();
			astFactory.addASTChild(currentAST, returnAST);
			accs();
			astFactory.addASTChild(currentAST, returnAST);
			prog_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
		returnAST = prog_AST;
	}
	
	public final void decs() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST decs_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case TIPOREAL:
			case TIPOENT:
			{
				dec();
				astFactory.addASTChild(currentAST, returnAST);
				rdecs();
				astFactory.addASTChild(currentAST, returnAST);
				decs_AST = (AST)currentAST.root;
				break;
			}
			case ID:
			case OP_IN:
			case OP_OUT:
			{
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
	}
	
	public final void accs() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST accs_AST = null;
		
		try {      // for error handling
			acc();
			astFactory.addASTChild(currentAST, returnAST);
			racs();
			astFactory.addASTChild(currentAST, returnAST);
			accs_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
		returnAST = accs_AST;
	}
	
	public final void dec() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST dec_AST = null;
		
		try {      // for error handling
			tipo();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp2_AST = null;
			tmp2_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp2_AST);
			match(ID);
			dec_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
		returnAST = dec_AST;
	}
	
	public final void rdecs() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rdecs_AST = null;
		
		try {      // for error handling
			AST tmp3_AST = null;
			tmp3_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp3_AST);
			match(SEP);
			rrdecs();
			astFactory.addASTChild(currentAST, returnAST);
			rdecs_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
		returnAST = rdecs_AST;
	}
	
	public final void rrdecs() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rrdecs_AST = null;
		
		try {      // for error handling
			decs();
			astFactory.addASTChild(currentAST, returnAST);
			rrdecs_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
		returnAST = rrdecs_AST;
	}
	
	public final void tipo() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST tipo_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case TIPOREAL:
			{
				AST tmp4_AST = null;
				tmp4_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp4_AST);
				match(TIPOREAL);
				tipo_AST = (AST)currentAST.root;
				break;
			}
			case TIPOENT:
			{
				AST tmp5_AST = null;
				tmp5_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp5_AST);
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
	}
	
	public final void acc() throws RecognitionException, TokenStreamException {
		
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
				out();
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
			recover(ex,_tokenSet_3);
		}
		returnAST = acc_AST;
	}
	
	public final void racs() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST racs_AST = null;
		
		try {      // for error handling
			AST tmp6_AST = null;
			tmp6_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp6_AST);
			match(SEP);
			rracs();
			astFactory.addASTChild(currentAST, returnAST);
			racs_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
		returnAST = racs_AST;
	}
	
	public final void rracs() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rracs_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case ID:
			case OP_IN:
			case OP_OUT:
			{
				accs();
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
			AST tmp7_AST = null;
			tmp7_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp7_AST);
			match(OP_IN);
			AST tmp8_AST = null;
			tmp8_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp8_AST);
			match(ID);
			in_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
		returnAST = in_AST;
	}
	
	public final void out() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST out_AST = null;
		
		try {      // for error handling
			AST tmp9_AST = null;
			tmp9_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp9_AST);
			match(OP_OUT);
			accasign();
			astFactory.addASTChild(currentAST, returnAST);
			out_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
		returnAST = out_AST;
	}
	
	public final void accasign() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST accasign_AST = null;
		
		try {      // for error handling
			AST tmp10_AST = null;
			tmp10_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp10_AST);
			match(ID);
			raccasign();
			astFactory.addASTChild(currentAST, returnAST);
			accasign_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
		returnAST = accasign_AST;
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
			recover(ex,_tokenSet_3);
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
			recover(ex,_tokenSet_3);
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
			recover(ex,_tokenSet_3);
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
			recover(ex,_tokenSet_5);
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
			recover(ex,_tokenSet_3);
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
			recover(ex,_tokenSet_6);
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
				accadit();
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
				accadit();
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
				accadit();
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
			recover(ex,_tokenSet_5);
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
				factor();
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
				factor();
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
			recover(ex,_tokenSet_7);
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
				accmult();
				astFactory.addASTChild(currentAST, returnAST);
				raccmult_AST = (AST)currentAST.root;
				break;
			}
			case OP_MOD:
			{
				AST tmp21_AST = null;
				tmp21_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp21_AST);
				match(OP_MOD);
				accmult();
				astFactory.addASTChild(currentAST, returnAST);
				raccmult_AST = (AST)currentAST.root;
				break;
			}
			case OP_AND:
			{
				AST tmp22_AST = null;
				tmp22_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp22_AST);
				match(OP_AND);
				accmult();
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
			recover(ex,_tokenSet_6);
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
			accadit();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp24_AST = null;
			tmp24_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp24_AST);
			match(DELIM_PAREN_C);
			raccun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_7);
		}
		returnAST = raccun_AST;
	}
	
	public final void rraccun() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rraccun_AST = null;
		
		try {      // for error handling
			AST tmp25_AST = null;
			tmp25_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp25_AST);
			match(DELIM_PAREN_C);
			factor();
			astFactory.addASTChild(currentAST, returnAST);
			rraccun_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = rraccun_AST;
	}
	
	public final void num() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST num_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case REAL:
			{
				AST tmp26_AST = null;
				tmp26_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp26_AST);
				match(REAL);
				num_AST = (AST)currentAST.root;
				break;
			}
			case ENTERO:
			{
				AST tmp27_AST = null;
				tmp27_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp27_AST);
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
		"SEP",
		"TIPOREAL",
		"TIPOENT",
		"LETRA",
		"DIGITO",
		"DELIM_PUNTO",
		"ID_TIPO_OPIN_OPOUT",
		"COMENTARIO",
		"INT_O_REAL",
		"ASIG_IGUAL"
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
		long[] data = { 6291520L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 16777216L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 64L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 17828864L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 17984512L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { 18344960L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { 18344962L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	
	}
