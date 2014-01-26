// $ANTLR : "Gramatica.g" -> "MiLexer.java"$

import java.io.InputStream;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.TokenStreamRecognitionException;
import antlr.CharStreamException;
import antlr.CharStreamIOException;
import antlr.ANTLRException;
import java.io.Reader;
import java.util.Hashtable;
import antlr.CharScanner;
import antlr.InputBuffer;
import antlr.ByteBuffer;
import antlr.CharBuffer;
import antlr.Token;
import antlr.CommonToken;
import antlr.RecognitionException;
import antlr.NoViableAltForCharException;
import antlr.MismatchedCharException;
import antlr.TokenStream;
import antlr.ANTLRHashString;
import antlr.LexerSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.SemanticException;

public class MiLexer extends antlr.CharScanner implements MiParserTokenTypes, TokenStream
 {

	String erroresLexicos="";
public MiLexer(InputStream in) {
	this(new ByteBuffer(in));
}
public MiLexer(Reader in) {
	this(new CharBuffer(in));
}
public MiLexer(InputBuffer ib) {
	this(new LexerSharedInputState(ib));
}
public MiLexer(LexerSharedInputState state) {
	super(state);
	caseSensitiveLiterals = true;
	setCaseSensitive(true);
	literals = new Hashtable();
}

public Token nextToken() throws TokenStreamException {
	Token theRetToken=null;
tryAgain:
	for (;;) {
		Token _token = null;
		int _ttype = Token.INVALID_TYPE;
		resetText();
		try {   // for char stream error handling
			try {   // for lexical error handling
				if ((LA(1)=='|') && (LA(2)=='|')) {
					mOP_OR(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='&') && (LA(2)=='&')) {
					mOP_AND(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='$') && (LA(2)=='$')) {
					mFIN(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='\n'||LA(1)=='\r') && (true)) {
					mSALTODELINEA(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='>') && (true)) {
					mCOMP1(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='<') && (true)) {
					mCOMP2(true);
					theRetToken=_returnToken;
				}
				else if ((_tokenSet_0.member(LA(1))) && (true)) {
					mID_TIPO_OPIN_OPOUT(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='@') && (true)) {
					mCOMENTARIO(true);
					theRetToken=_returnToken;
				}
				else if (((LA(1) >= '1' && LA(1) <= '9')) && (true)) {
					mINT_O_REAL(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='\t'||LA(1)==' ') && (true)) {
					mWhitespace(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)==';') && (true)) {
					mSEP(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='(') && (true)) {
					mDELIM_PAREN_A(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)==')') && (true)) {
					mDELIM_PAREN_C(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='+') && (true)) {
					mOP_MAS(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='-') && (true)) {
					mOP_MENOS(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='%') && (true)) {
					mOP_MOD(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='*') && (true)) {
					mOP_MUL(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='/') && (true)) {
					mOP_DIV(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='=') && (true)) {
					mASIG_IGUAL(true);
					theRetToken=_returnToken;
				}
				else if ((LA(1)=='!') && (true)) {
					mNOT_COMP(true);
					theRetToken=_returnToken;
				}
				else if (((LA(1) >= '\u0000' && LA(1) <= '\u007f')) && (true)) {
					mERRORES(true);
					theRetToken=_returnToken;
				}
				else {
					if (LA(1)==EOF_CHAR) {uponEOF(); _returnToken = makeToken(Token.EOF_TYPE);}
				else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
				}
				
				if ( _returnToken==null ) continue tryAgain; // found SKIP token
				_ttype = _returnToken.getType();
				_ttype = testLiteralsTable(_ttype);
				_returnToken.setType(_ttype);
				return _returnToken;
			}
			catch (RecognitionException e) {
				throw new TokenStreamRecognitionException(e);
			}
		}
		catch (CharStreamException cse) {
			if ( cse instanceof CharStreamIOException ) {
				throw new TokenStreamIOException(((CharStreamIOException)cse).io);
			}
			else {
				throw new TokenStreamException(cse.getMessage());
			}
		}
	}
}

	protected final void mLETRA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LETRA;
		int _saveIndex;
		
		switch ( LA(1)) {
		case 'a':  case 'b':  case 'c':  case 'd':
		case 'e':  case 'f':  case 'g':  case 'h':
		case 'i':  case 'j':  case 'k':  case 'l':
		case 'm':  case 'n':  case 'o':  case 'p':
		case 'q':  case 'r':  case 's':  case 't':
		case 'u':  case 'v':  case 'w':  case 'x':
		case 'y':  case 'z':
		{
			{
			matchRange('a','z');
			}
			break;
		}
		case 'A':  case 'B':  case 'C':  case 'D':
		case 'E':  case 'F':  case 'G':  case 'H':
		case 'I':  case 'J':  case 'K':  case 'L':
		case 'M':  case 'N':  case 'O':  case 'P':
		case 'Q':  case 'R':  case 'S':  case 'T':
		case 'U':  case 'V':  case 'W':  case 'X':
		case 'Y':  case 'Z':
		{
			{
			matchRange('A','Z');
			}
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mDIGITO(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DIGITO;
		int _saveIndex;
		
		matchRange('0','9');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mDELIM_PUNTO(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DELIM_PUNTO;
		int _saveIndex;
		
		match('.');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mENTERO(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ENTERO;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case '1':
		{
			match('1');
			break;
		}
		case '2':
		{
			match('2');
			break;
		}
		case '3':
		{
			match('3');
			break;
		}
		case '4':
		{
			match('4');
			break;
		}
		case '5':
		{
			match('5');
			break;
		}
		case '6':
		{
			match('6');
			break;
		}
		case '7':
		{
			match('7');
			break;
		}
		case '8':
		{
			match('8');
			break;
		}
		case '9':
		{
			match('9');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		{
		_loop1869:
		do {
			if (((LA(1) >= '0' && LA(1) <= '9')) && (true)) {
				mDIGITO(false);
			}
			else {
				break _loop1869;
			}
			
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mREAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = REAL;
		int _saveIndex;
		
		mENTERO(false);
		{
		mDELIM_PUNTO(false);
		}
		{
		int _cnt1873=0;
		_loop1873:
		do {
			if (((LA(1) >= '0' && LA(1) <= '9'))) {
				mDIGITO(false);
			}
			else {
				if ( _cnt1873>=1 ) { break _loop1873; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt1873++;
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mTIPOREAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = TIPOREAL;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case 'R':
		{
			match('R');
			break;
		}
		case 'r':
		{
			match('r');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		{
		switch ( LA(1)) {
		case 'E':
		{
			match('E');
			break;
		}
		case 'e':
		{
			match('e');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		{
		switch ( LA(1)) {
		case 'A':
		{
			match('A');
			break;
		}
		case 'a':
		{
			match('a');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		{
		switch ( LA(1)) {
		case 'L':
		{
			match('L');
			break;
		}
		case 'l':
		{
			match('l');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mTIPOENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = TIPOENT;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case 'I':
		{
			match('I');
			break;
		}
		case 'i':
		{
			match('i');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		{
		switch ( LA(1)) {
		case 'N':
		{
			match('N');
			break;
		}
		case 'n':
		{
			match('n');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		{
		switch ( LA(1)) {
		case 'T':
		{
			match('T');
			break;
		}
		case 't':
		{
			match('t');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mOP_IN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_IN;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case 'I':
		{
			match('I');
			break;
		}
		case 'i':
		{
			match('i');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		{
		switch ( LA(1)) {
		case 'N':
		{
			match('N');
			break;
		}
		case 'n':
		{
			match('n');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mOP_OUT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_OUT;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case 'O':
		{
			match('O');
			break;
		}
		case 'o':
		{
			match('o');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		{
		switch ( LA(1)) {
		case 'U':
		{
			match('U');
			break;
		}
		case 'u':
		{
			match('u');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		{
		switch ( LA(1)) {
		case 'T':
		{
			match('T');
			break;
		}
		case 't':
		{
			match('t');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mID(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ID;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case 'A':  case 'B':  case 'C':  case 'D':
		case 'E':  case 'F':  case 'G':  case 'H':
		case 'I':  case 'J':  case 'K':  case 'L':
		case 'M':  case 'N':  case 'O':  case 'P':
		case 'Q':  case 'R':  case 'S':  case 'T':
		case 'U':  case 'V':  case 'W':  case 'X':
		case 'Y':  case 'Z':  case 'a':  case 'b':
		case 'c':  case 'd':  case 'e':  case 'f':
		case 'g':  case 'h':  case 'i':  case 'j':
		case 'k':  case 'l':  case 'm':  case 'n':
		case 'o':  case 'p':  case 'q':  case 'r':
		case 's':  case 't':  case 'u':  case 'v':
		case 'w':  case 'x':  case 'y':  case 'z':
		{
			mLETRA(false);
			break;
		}
		case '_':
		{
			match('_');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		{
		_loop1895:
		do {
			if ((_tokenSet_1.member(LA(1)))) {
				{
				switch ( LA(1)) {
				case 'A':  case 'B':  case 'C':  case 'D':
				case 'E':  case 'F':  case 'G':  case 'H':
				case 'I':  case 'J':  case 'K':  case 'L':
				case 'M':  case 'N':  case 'O':  case 'P':
				case 'Q':  case 'R':  case 'S':  case 'T':
				case 'U':  case 'V':  case 'W':  case 'X':
				case 'Y':  case 'Z':  case 'a':  case 'b':
				case 'c':  case 'd':  case 'e':  case 'f':
				case 'g':  case 'h':  case 'i':  case 'j':
				case 'k':  case 'l':  case 'm':  case 'n':
				case 'o':  case 'p':  case 'q':  case 'r':
				case 's':  case 't':  case 'u':  case 'v':
				case 'w':  case 'x':  case 'y':  case 'z':
				{
					{
					mLETRA(false);
					}
					break;
				}
				case '1':  case '2':  case '3':  case '4':
				case '5':  case '6':  case '7':  case '8':
				case '9':
				{
					mENTERO(false);
					break;
				}
				case '_':
				{
					match('_');
					break;
				}
				default:
				{
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
				}
				}
				}
			}
			else {
				break _loop1895;
			}
			
		} while (true);
		}
		{
		if ((LA(1)=='?')) {
			match('?');
		}
		else {
		}
		
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mOP_AS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_AS;
		int _saveIndex;
		
		match('=');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mOP_IGUAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_IGUAL;
		int _saveIndex;
		
		match("==");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mOP_NOT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_NOT;
		int _saveIndex;
		
		match('!');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mOP_COMP(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_COMP;
		int _saveIndex;
		
		match("!=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mOP_MENQ(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_MENQ;
		int _saveIndex;
		
		match('<');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mOP_MAYQ(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_MAYQ;
		int _saveIndex;
		
		match('>');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mOP_MAYOI(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_MAYOI;
		int _saveIndex;
		
		match(">=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mOP_MENOI(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_MENOI;
		int _saveIndex;
		
		match("<=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSALTODELINEA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SALTODELINEA;
		int _saveIndex;
		
		{
		if ((LA(1)=='\r') && (LA(2)=='\n')) {
			match("\r\n");
		}
		else if ((LA(1)=='\n')) {
			match('\n');
		}
		else if ((LA(1)=='\r') && (true)) {
			match('\r');
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		}
		if ( inputState.guessing==0 ) {
			
							_ttype = Token.SKIP;
							newline();
						
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCOMP1(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COMP1;
		int _saveIndex;
		
		boolean synPredMatched1909 = false;
		if (((LA(1)=='>') && (LA(2)=='='))) {
			int _m1909 = mark();
			synPredMatched1909 = true;
			inputState.guessing++;
			try {
				{
				mOP_MAYQ(false);
				match('=');
				}
			}
			catch (RecognitionException pe) {
				synPredMatched1909 = false;
			}
			rewind(_m1909);
inputState.guessing--;
		}
		if ( synPredMatched1909 ) {
			mOP_MAYOI(false);
			if ( inputState.guessing==0 ) {
				_ttype = OP_MAYOI;
			}
		}
		else {
			boolean synPredMatched1911 = false;
			if (((LA(1)=='>') && (true))) {
				int _m1911 = mark();
				synPredMatched1911 = true;
				inputState.guessing++;
				try {
					{
					mOP_MAYQ(false);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched1911 = false;
				}
				rewind(_m1911);
inputState.guessing--;
			}
			if ( synPredMatched1911 ) {
				mOP_MAYQ(false);
				if ( inputState.guessing==0 ) {
					_ttype = OP_MAYQ;
				}
			}
			else {
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			}
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		}
		
	public final void mCOMP2(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COMP2;
		int _saveIndex;
		
		boolean synPredMatched1914 = false;
		if (((LA(1)=='<') && (LA(2)=='='))) {
			int _m1914 = mark();
			synPredMatched1914 = true;
			inputState.guessing++;
			try {
				{
				mOP_MENQ(false);
				match('=');
				}
			}
			catch (RecognitionException pe) {
				synPredMatched1914 = false;
			}
			rewind(_m1914);
inputState.guessing--;
		}
		if ( synPredMatched1914 ) {
			mOP_MENOI(false);
			if ( inputState.guessing==0 ) {
				_ttype = OP_MENOI;
			}
		}
		else {
			boolean synPredMatched1916 = false;
			if (((LA(1)=='<') && (true))) {
				int _m1916 = mark();
				synPredMatched1916 = true;
				inputState.guessing++;
				try {
					{
					mOP_MENQ(false);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched1916 = false;
				}
				rewind(_m1916);
inputState.guessing--;
			}
			if ( synPredMatched1916 ) {
				mOP_MENQ(false);
				if ( inputState.guessing==0 ) {
					_ttype = OP_MENQ;
				}
			}
			else {
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			}
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		}
		
	public final void mID_TIPO_OPIN_OPOUT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ID_TIPO_OPIN_OPOUT;
		int _saveIndex;
		
		boolean synPredMatched1920 = false;
		if (((LA(1)=='I'||LA(1)=='i') && (LA(2)=='N'||LA(2)=='n'))) {
			int _m1920 = mark();
			synPredMatched1920 = true;
			inputState.guessing++;
			try {
				{
				mOP_IN(false);
				{
				switch ( LA(1)) {
				case 'T':
				{
					match('T');
					break;
				}
				case 't':
				{
					match('t');
					break;
				}
				default:
				{
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
				}
				}
				}
				match(' ');
				}
			}
			catch (RecognitionException pe) {
				synPredMatched1920 = false;
			}
			rewind(_m1920);
inputState.guessing--;
		}
		if ( synPredMatched1920 ) {
			mTIPOENT(false);
			if ( inputState.guessing==0 ) {
				_ttype = TIPOENT;
			}
		}
		else {
			boolean synPredMatched1929 = false;
			if (((LA(1)=='I'||LA(1)=='i') && (LA(2)=='N'||LA(2)=='n'))) {
				int _m1929 = mark();
				synPredMatched1929 = true;
				inputState.guessing++;
				try {
					{
					mOP_IN(false);
					{
					match(' ');
					}
					}
				}
				catch (RecognitionException pe) {
					synPredMatched1929 = false;
				}
				rewind(_m1929);
inputState.guessing--;
			}
			if ( synPredMatched1929 ) {
				mOP_IN(false);
				if ( inputState.guessing==0 ) {
					_ttype = OP_IN;
				}
			}
			else {
				boolean synPredMatched1931 = false;
				if (((LA(1)=='O'||LA(1)=='o') && (LA(2)=='U'||LA(2)=='u'))) {
					int _m1931 = mark();
					synPredMatched1931 = true;
					inputState.guessing++;
					try {
						{
						mOP_OUT(false);
						match(' ');
						}
					}
					catch (RecognitionException pe) {
						synPredMatched1931 = false;
					}
					rewind(_m1931);
inputState.guessing--;
				}
				if ( synPredMatched1931 ) {
					mOP_OUT(false);
					if ( inputState.guessing==0 ) {
						_ttype = OP_OUT;
					}
				}
				else {
					boolean synPredMatched1936 = false;
					if (((LA(1)=='R'||LA(1)=='r') && (LA(2)=='E'||LA(2)=='e'))) {
						int _m1936 = mark();
						synPredMatched1936 = true;
						inputState.guessing++;
						try {
							{
							mTIPOREAL(false);
							match(' ');
							}
						}
						catch (RecognitionException pe) {
							synPredMatched1936 = false;
						}
						rewind(_m1936);
inputState.guessing--;
					}
					if ( synPredMatched1936 ) {
						mTIPOREAL(false);
						if ( inputState.guessing==0 ) {
							_ttype = TIPOREAL;
						}
					}
					else {
						boolean synPredMatched1923 = false;
						if (((_tokenSet_0.member(LA(1))) && (true))) {
							int _m1923 = mark();
							synPredMatched1923 = true;
							inputState.guessing++;
							try {
								{
								mOP_IN(false);
								{
								switch ( LA(1)) {
								case 'T':
								{
									match('T');
									break;
								}
								case 't':
								{
									match('t');
									break;
								}
								default:
								{
									throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
								}
								}
								}
								matchNot(' ');
								}
							}
							catch (RecognitionException pe) {
								synPredMatched1923 = false;
							}
							rewind(_m1923);
inputState.guessing--;
						}
						if ( synPredMatched1923 ) {
							mID(false);
							if ( inputState.guessing==0 ) {
								_ttype = ID;
							}
						}
						else {
							boolean synPredMatched1926 = false;
							if (((_tokenSet_0.member(LA(1))) && (true))) {
								int _m1926 = mark();
								synPredMatched1926 = true;
								inputState.guessing++;
								try {
									{
									mOP_IN(false);
									{
									match(_tokenSet_2);
									}
									}
								}
								catch (RecognitionException pe) {
									synPredMatched1926 = false;
								}
								rewind(_m1926);
inputState.guessing--;
							}
							if ( synPredMatched1926 ) {
								mID(false);
								if ( inputState.guessing==0 ) {
									_ttype = ID;
								}
							}
							else {
								boolean synPredMatched1934 = false;
								if (((_tokenSet_0.member(LA(1))) && (true))) {
									int _m1934 = mark();
									synPredMatched1934 = true;
									inputState.guessing++;
									try {
										{
										mOP_OUT(false);
										{
										match(_tokenSet_3);
										}
										}
									}
									catch (RecognitionException pe) {
										synPredMatched1934 = false;
									}
									rewind(_m1934);
inputState.guessing--;
								}
								if ( synPredMatched1934 ) {
									mID(false);
									if ( inputState.guessing==0 ) {
										_ttype = ID;
									}
								}
								else {
									boolean synPredMatched1938 = false;
									if (((_tokenSet_0.member(LA(1))) && (true))) {
										int _m1938 = mark();
										synPredMatched1938 = true;
										inputState.guessing++;
										try {
											{
											mID(false);
											}
										}
										catch (RecognitionException pe) {
											synPredMatched1938 = false;
										}
										rewind(_m1938);
inputState.guessing--;
									}
									if ( synPredMatched1938 ) {
										mID(false);
										if ( inputState.guessing==0 ) {
											_ttype = ID;
										}
									}
									else {
										throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
									}
									}}}}}}}
									if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
										_token = makeToken(_ttype);
										_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
									}
									_returnToken = _token;
								}
								
	public final void mCOMENTARIO(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COMENTARIO;
		int _saveIndex;
		
		match('@');
		{
		_loop1942:
		do {
			if ((_tokenSet_4.member(LA(1)))) {
				{
				match(_tokenSet_4);
				}
			}
			else {
				break _loop1942;
			}
			
		} while (true);
		}
		if ( inputState.guessing==0 ) {
			_ttype = Token.SKIP;
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mINT_O_REAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = INT_O_REAL;
		int _saveIndex;
		
		boolean synPredMatched1946 = false;
		if ((((LA(1) >= '1' && LA(1) <= '9')) && (_tokenSet_5.member(LA(2))))) {
			int _m1946 = mark();
			synPredMatched1946 = true;
			inputState.guessing++;
			try {
				{
				mENTERO(false);
				{
				mDELIM_PUNTO(false);
				}
				}
			}
			catch (RecognitionException pe) {
				synPredMatched1946 = false;
			}
			rewind(_m1946);
inputState.guessing--;
		}
		if ( synPredMatched1946 ) {
			mREAL(false);
			if ( inputState.guessing==0 ) {
				_ttype = REAL;
			}
		}
		else if (((LA(1) >= '1' && LA(1) <= '9')) && (true)) {
			mENTERO(false);
			if ( inputState.guessing==0 ) {
				_ttype = ENTERO;
			}
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mWhitespace(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = Whitespace;
		int _saveIndex;
		
		{
		int _cnt1949=0;
		_loop1949:
		do {
			switch ( LA(1)) {
			case ' ':
			{
				match(' ');
				break;
			}
			case '\t':
			{
				match('\t');
				break;
			}
			default:
			{
				if ( _cnt1949>=1 ) { break _loop1949; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			}
			_cnt1949++;
		} while (true);
		}
		if ( inputState.guessing==0 ) {
			_ttype = Token.SKIP;
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSEP(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SEP;
		int _saveIndex;
		
		match(';');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mDELIM_PAREN_A(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DELIM_PAREN_A;
		int _saveIndex;
		
		match('(');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mDELIM_PAREN_C(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DELIM_PAREN_C;
		int _saveIndex;
		
		match(')');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOP_MAS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_MAS;
		int _saveIndex;
		
		match('+');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOP_MENOS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_MENOS;
		int _saveIndex;
		
		match('-');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOP_MOD(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_MOD;
		int _saveIndex;
		
		match('%');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOP_MUL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_MUL;
		int _saveIndex;
		
		match('*');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOP_DIV(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_DIV;
		int _saveIndex;
		
		match('/');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOP_OR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_OR;
		int _saveIndex;
		
		match("||");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mOP_AND(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_AND;
		int _saveIndex;
		
		match("&&");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mASIG_IGUAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ASIG_IGUAL;
		int _saveIndex;
		
		boolean synPredMatched1962 = false;
		if (((LA(1)=='=') && (LA(2)=='='))) {
			int _m1962 = mark();
			synPredMatched1962 = true;
			inputState.guessing++;
			try {
				{
				mOP_AS(false);
				match('=');
				}
			}
			catch (RecognitionException pe) {
				synPredMatched1962 = false;
			}
			rewind(_m1962);
inputState.guessing--;
		}
		if ( synPredMatched1962 ) {
			mOP_IGUAL(false);
			if ( inputState.guessing==0 ) {
				_ttype = OP_IGUAL;
			}
		}
		else {
			boolean synPredMatched1964 = false;
			if (((LA(1)=='=') && (true))) {
				int _m1964 = mark();
				synPredMatched1964 = true;
				inputState.guessing++;
				try {
					{
					mOP_AS(false);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched1964 = false;
				}
				rewind(_m1964);
inputState.guessing--;
			}
			if ( synPredMatched1964 ) {
				mOP_AS(false);
				if ( inputState.guessing==0 ) {
					_ttype = OP_AS;
				}
			}
			else {
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			}
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		}
		
	public final void mNOT_COMP(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NOT_COMP;
		int _saveIndex;
		
		boolean synPredMatched1968 = false;
		if (((LA(1)=='!') && (LA(2)=='='))) {
			int _m1968 = mark();
			synPredMatched1968 = true;
			inputState.guessing++;
			try {
				{
				mOP_NOT(false);
				{
				match('=');
				}
				}
			}
			catch (RecognitionException pe) {
				synPredMatched1968 = false;
			}
			rewind(_m1968);
inputState.guessing--;
		}
		if ( synPredMatched1968 ) {
			mOP_COMP(false);
			if ( inputState.guessing==0 ) {
				_ttype = OP_COMP;
			}
		}
		else {
			boolean synPredMatched1970 = false;
			if (((LA(1)=='!') && (true))) {
				int _m1970 = mark();
				synPredMatched1970 = true;
				inputState.guessing++;
				try {
					{
					mOP_NOT(false);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched1970 = false;
				}
				rewind(_m1970);
inputState.guessing--;
			}
			if ( synPredMatched1970 ) {
				mOP_NOT(false);
				if ( inputState.guessing==0 ) {
					_ttype = OP_NOT;
				}
			}
			else {
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			}
			if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
				_token = makeToken(_ttype);
				_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
			}
			_returnToken = _token;
		}
		
	public final void mFIN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = FIN;
		int _saveIndex;
		
		match("$$");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mERRORES(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ERRORES;
		int _saveIndex;
		
		matchNot(EOF_CHAR);
		if ( inputState.guessing==0 ) {
			erroresLexicos += "Hemos encontrado un error lexico: " + getText()+ " Linea: " + getLine()+ " Columna: " + getColumn() +"\n";
						_ttype = Token.SKIP;
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 0L, 576460745995190270L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 287667426198290432L, 576460745995190270L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { -4294967297L, -4503599627370497L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { -4294967297L, -1L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { -9217L, -1L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 288019269919178752L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	
	}
