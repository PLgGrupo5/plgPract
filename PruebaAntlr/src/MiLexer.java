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
				switch ( LA(1)) {
				case 'A':  case 'B':  case 'C':  case 'D':
				case 'E':  case 'F':  case 'G':  case 'H':
				case 'I':  case 'J':  case 'K':  case 'L':
				case 'M':  case 'N':  case 'O':  case 'P':
				case 'Q':  case 'R':  case 'S':  case 'T':
				case 'U':  case 'V':  case 'W':  case 'X':
				case 'Y':  case 'Z':  case '_':  case 'a':
				case 'b':  case 'c':  case 'd':  case 'e':
				case 'f':  case 'g':  case 'h':  case 'i':
				case 'j':  case 'k':  case 'l':  case 'm':
				case 'n':  case 'o':  case 'p':  case 'q':
				case 'r':  case 's':  case 't':  case 'u':
				case 'v':  case 'w':  case 'x':  case 'y':
				case 'z':
				{
					mID_TIPO_OPIN_OPOUT(true);
					theRetToken=_returnToken;
					break;
				}
				case '@':
				{
					mCOMENTARIO(true);
					theRetToken=_returnToken;
					break;
				}
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				case '8':  case '9':
				{
					mINT_O_REAL(true);
					theRetToken=_returnToken;
					break;
				}
				case '\t':  case '\n':  case '\r':  case ' ':
				{
					mWhitespace(true);
					theRetToken=_returnToken;
					break;
				}
				case ';':
				{
					mSEP(true);
					theRetToken=_returnToken;
					break;
				}
				case '(':
				{
					mDELIM_PAREN_A(true);
					theRetToken=_returnToken;
					break;
				}
				case ')':
				{
					mDELIM_PAREN_C(true);
					theRetToken=_returnToken;
					break;
				}
				case '+':
				{
					mOP_MAS(true);
					theRetToken=_returnToken;
					break;
				}
				case '-':
				{
					mOP_MENOS(true);
					theRetToken=_returnToken;
					break;
				}
				case '%':
				{
					mOP_MOD(true);
					theRetToken=_returnToken;
					break;
				}
				case '*':  case '/':
				{
					mOP_MUL_DIV(true);
					theRetToken=_returnToken;
					break;
				}
				case '|':
				{
					mOP_OR(true);
					theRetToken=_returnToken;
					break;
				}
				case '&':
				{
					mOP_AND(true);
					theRetToken=_returnToken;
					break;
				}
				case '=':
				{
					mASIG_IGUAL(true);
					theRetToken=_returnToken;
					break;
				}
				case '$':
				{
					mFIN(true);
					theRetToken=_returnToken;
					break;
				}
				default:
					if ((LA(1)=='!') && (true)) {
						mOP_NOT(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='!'||LA(1)=='<'||LA(1)=='>') && (true)) {
						mOP_COMP(true);
						theRetToken=_returnToken;
					}
				else {
					if (LA(1)==EOF_CHAR) {uponEOF(); _returnToken = makeToken(Token.EOF_TYPE);}
				else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
				}
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
		int _cnt10495=0;
		_loop10495:
		do {
			if (((LA(1) >= '0' && LA(1) <= '9')) && (true)) {
				mDIGITO(false);
			}
			else {
				if ( _cnt10495>=1 ) { break _loop10495; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt10495++;
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
		int _cnt10499=0;
		_loop10499:
		do {
			if (((LA(1) >= '0' && LA(1) <= '9'))) {
				mDIGITO(false);
			}
			else {
				if ( _cnt10499>=1 ) { break _loop10499; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt10499++;
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
		_loop10521:
		do {
			if ((_tokenSet_0.member(LA(1)))) {
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
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				case '8':  case '9':
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
				break _loop10521;
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
	
	public final void mID_TIPO_OPIN_OPOUT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ID_TIPO_OPIN_OPOUT;
		int _saveIndex;
		
		boolean synPredMatched10528 = false;
		if (((LA(1)=='I'||LA(1)=='i') && (LA(2)=='N'||LA(2)=='n'))) {
			int _m10528 = mark();
			synPredMatched10528 = true;
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
				synPredMatched10528 = false;
			}
			rewind(_m10528);
inputState.guessing--;
		}
		if ( synPredMatched10528 ) {
			mTIPOENT(false);
			if ( inputState.guessing==0 ) {
				_ttype = TIPOENT;
			}
		}
		else {
			boolean synPredMatched10537 = false;
			if (((LA(1)=='I'||LA(1)=='i') && (LA(2)=='N'||LA(2)=='n'))) {
				int _m10537 = mark();
				synPredMatched10537 = true;
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
					synPredMatched10537 = false;
				}
				rewind(_m10537);
inputState.guessing--;
			}
			if ( synPredMatched10537 ) {
				mOP_IN(false);
				if ( inputState.guessing==0 ) {
					_ttype = OP_IN;
				}
			}
			else {
				boolean synPredMatched10539 = false;
				if (((LA(1)=='O'||LA(1)=='o') && (LA(2)=='U'||LA(2)=='u'))) {
					int _m10539 = mark();
					synPredMatched10539 = true;
					inputState.guessing++;
					try {
						{
						mOP_OUT(false);
						match(' ');
						}
					}
					catch (RecognitionException pe) {
						synPredMatched10539 = false;
					}
					rewind(_m10539);
inputState.guessing--;
				}
				if ( synPredMatched10539 ) {
					mOP_OUT(false);
					if ( inputState.guessing==0 ) {
						_ttype = OP_OUT;
					}
				}
				else {
					boolean synPredMatched10531 = false;
					if (((_tokenSet_1.member(LA(1))) && (true))) {
						int _m10531 = mark();
						synPredMatched10531 = true;
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
							synPredMatched10531 = false;
						}
						rewind(_m10531);
inputState.guessing--;
					}
					if ( synPredMatched10531 ) {
						mID(false);
						if ( inputState.guessing==0 ) {
							_ttype = ID;
						}
					}
					else {
						boolean synPredMatched10534 = false;
						if (((_tokenSet_1.member(LA(1))) && (true))) {
							int _m10534 = mark();
							synPredMatched10534 = true;
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
								synPredMatched10534 = false;
							}
							rewind(_m10534);
inputState.guessing--;
						}
						if ( synPredMatched10534 ) {
							mID(false);
							if ( inputState.guessing==0 ) {
								_ttype = ID;
							}
						}
						else {
							boolean synPredMatched10542 = false;
							if (((_tokenSet_1.member(LA(1))) && (true))) {
								int _m10542 = mark();
								synPredMatched10542 = true;
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
									synPredMatched10542 = false;
								}
								rewind(_m10542);
inputState.guessing--;
							}
							if ( synPredMatched10542 ) {
								mID(false);
								if ( inputState.guessing==0 ) {
									_ttype = ID;
								}
							}
							else {
								boolean synPredMatched10544 = false;
								if (((_tokenSet_1.member(LA(1))) && (true))) {
									int _m10544 = mark();
									synPredMatched10544 = true;
									inputState.guessing++;
									try {
										{
										mID(false);
										}
									}
									catch (RecognitionException pe) {
										synPredMatched10544 = false;
									}
									rewind(_m10544);
inputState.guessing--;
								}
								if ( synPredMatched10544 ) {
									mID(false);
									if ( inputState.guessing==0 ) {
										_ttype = ID;
									}
								}
								else {
									throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
								}
								}}}}}}
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
		_loop10547:
		do {
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
			case '0':  case '1':  case '2':  case '3':
			case '4':  case '5':  case '6':  case '7':
			case '8':  case '9':
			{
				mDIGITO(false);
				break;
			}
			case '.':
			{
				mDELIM_PUNTO(false);
				break;
			}
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
				break _loop10547;
			}
			}
		} while (true);
		}
		{
		match('\r');
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
		
		boolean synPredMatched10552 = false;
		if ((((LA(1) >= '0' && LA(1) <= '9')) && (_tokenSet_4.member(LA(2))))) {
			int _m10552 = mark();
			synPredMatched10552 = true;
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
				synPredMatched10552 = false;
			}
			rewind(_m10552);
inputState.guessing--;
		}
		if ( synPredMatched10552 ) {
			mREAL(false);
			if ( inputState.guessing==0 ) {
				_ttype = REAL;
			}
		}
		else if (((LA(1) >= '0' && LA(1) <= '9')) && (true)) {
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
		int _cnt10555=0;
		_loop10555:
		do {
			switch ( LA(1)) {
			case ' ':
			{
				match(' ');
				break;
			}
			case '\r':
			{
				match('\r');
				break;
			}
			case '\n':
			{
				match('\n');
				break;
			}
			case '\t':
			{
				match('\t');
				break;
			}
			default:
			{
				if ( _cnt10555>=1 ) { break _loop10555; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			}
			_cnt10555++;
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
	
	public final void mOP_MUL_DIV(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_MUL_DIV;
		int _saveIndex;
		
		switch ( LA(1)) {
		case '*':
		{
			match('*');
			break;
		}
		case '/':
		{
			match('/');
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
	
	public final void mOP_NOT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
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
	
	public final void mOP_COMP(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = OP_COMP;
		int _saveIndex;
		
		if ((LA(1)=='>') && (LA(2)=='=')) {
			match(">=");
		}
		else if ((LA(1)=='<') && (LA(2)=='=')) {
			match("<=");
		}
		else if ((LA(1)=='!')) {
			match("!=");
		}
		else if ((LA(1)=='>') && (true)) {
			match('>');
		}
		else if ((LA(1)=='<') && (true)) {
			match('<');
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
	
	public final void mASIG_IGUAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ASIG_IGUAL;
		int _saveIndex;
		
		boolean synPredMatched10569 = false;
		if (((LA(1)=='=') && (LA(2)=='='))) {
			int _m10569 = mark();
			synPredMatched10569 = true;
			inputState.guessing++;
			try {
				{
				mOP_AS(false);
				match('=');
				}
			}
			catch (RecognitionException pe) {
				synPredMatched10569 = false;
			}
			rewind(_m10569);
inputState.guessing--;
		}
		if ( synPredMatched10569 ) {
			mOP_IGUAL(false);
			if ( inputState.guessing==0 ) {
				_ttype = OP_IGUAL;
			}
		}
		else {
			boolean synPredMatched10571 = false;
			if (((LA(1)=='=') && (true))) {
				int _m10571 = mark();
				synPredMatched10571 = true;
				inputState.guessing++;
				try {
					{
					mOP_AS(false);
					}
				}
				catch (RecognitionException pe) {
					synPredMatched10571 = false;
				}
				rewind(_m10571);
inputState.guessing--;
			}
			if ( synPredMatched10571 ) {
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
	
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 287948901175001088L, 576460745995190270L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 0L, 576460745995190270L, 0L, 0L};
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
		long[] data = { 288019269919178752L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	
	}
