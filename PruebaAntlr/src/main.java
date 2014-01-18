import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import antlr.ANTLRException;
import antlr.CommonAST;
import antlr.ParseTree;
import antlr.Token;
import antlr.TokenStream;
import antlr.TokenStreamException;
import antlr.collections.AST;



public class main {//solo scanner
private static String fileName = "prueba1.txt";
private static FileInputStream fis = null;

	public static void main(String args[]) {
		try
		{
		/*	System.out.println("Scanning file...");
			System.out.println(new File(".").getAbsolutePath());
			fis = new FileInputStream("codigo.txt");
			MiLexer scan = new MiLexer(fis);
			Token token = scan.nextToken();
			while(token.getType() != Token.EOF_TYPE){
				System.out.println(token);
				token = scan.nextToken();
			}*/
			System.out.println("Scanning file...");
			fis = new FileInputStream("codigo.txt");
			MiLexer scan = new MiLexer(fis);
			MiParser par = new MiParser(scan);
			par.sprog();
			CommonAST a = (CommonAST)par.getAST();
			System.out.println("Resultado ASA: "+a.toStringList());
		}catch (ANTLRException ae){
			System.err.println(ae.getMessage());
		}catch(FileNotFoundException fnfe){
			System.err.println("No se encontró el fichero");
		}
	}
}