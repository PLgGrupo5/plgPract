import java.util.HashMap;
import antlr.ANTLRException;

public class TablaSimbolos {

	private HashMap<String,Linea> tabla;
	private int direccion;
	public TablaSimbolos(){
		this.direccion=0;
		this.tabla  = new HashMap<String,Linea>();
	}
	public void insertaDec( Declaracion dec) throws ANTLRException
	{
		if (!tabla.containsKey(dec.getNombre()))
		{
			Linea nuevaLinea = new Linea (dec);
			nuevaLinea.setNombre(dec.getNombre());
			nuevaLinea.setTipo(dec.getTipo());
			nuevaLinea.setValorDouble(0.0);
			nuevaLinea.setValorInt(0);
			nuevaLinea.setDirMemoria(this.direccion);
			this.tabla.put(dec.getNombre(), nuevaLinea);
			this.direccion++;
		}
		else
		{
			ANTLRException e = new ANTLRException("Variable ya declarada!!");
			throw e;
		}
	}
	public float devuelveValor()
	{
		return 0;
	}
	public String devuelveTipo()
	{
		return "";
	}
}
