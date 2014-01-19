import java.util.HashMap;
import antlr.ANTLRException;

public class TablaSimbolos {

	private HashMap<String,Linea> tabla;
	public TablaSimbolos(){
		this.tabla  = new HashMap<String,Linea>();
	}
	public Linea getLinea(String key)
	{
		Linea linea = this.tabla.get(key);
		return linea;
	}
	public void insertaDec( Declaracion dec)// throws ANTLRException
	{
		if (!tabla.containsKey(dec.getNombre().toLowerCase()))
		{
			Linea nuevaLinea = new Linea (dec);
			nuevaLinea.setNombre(dec.getNombre().toLowerCase());
			nuevaLinea.setTipo(dec.getTipo());
			nuevaLinea.setValorDouble(0.0);
			nuevaLinea.setValorInt(0);
			nuevaLinea.setDirMemoria(this.tabla.size());
			this.tabla.put(nuevaLinea.getNombre(), nuevaLinea);
			//System.out.println(nuevaLinea.toString());
		}
		/*else
		{
			ANTLRException e = new ANTLRException("Variable ya declarada!!");
			throw e;
		}*/
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
