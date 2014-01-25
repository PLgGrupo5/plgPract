package maquinacodp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Esta clase tokenizara un fichero de texto plano con codigo pila con notacion currificada (para facilitar la tokenizacion) e ira realizando en una pila las operaciones correspondientes hasta obtener el resultado de la ejecucion del programa.
*/
public class MaquinaP {

    private String _dirFichEntrada;
    private String _dirFichSalida;

    private List<String> _lineasEntrada; //Array que almacenara las instruccionse separadas. Unicamente separa las lineas de la entrada
    private List<String> _lineasSalida;

    private int[] _memoria;

    public static void main(String args[]) {
        String dirFichEntrada = args[0];
        String dirFichSalida = args[1];
        MaquinaP traductor = new MaquinaP(dirFichEntrada, dirFichSalida);
        //Llamar a traduce
        traductor.traduce();
    }

    public MaquinaP(String dirFichEntrada, String dirFichSalida) {
        this._dirFichEntrada = dirFichEntrada;
        this._dirFichSalida = dirFichSalida;
    }
    public void traduce(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fichero = null;
        PrintWriter pw = null;

        try {
            //LECTURA//////////////////////////////////////////////////////////
            System.out.println("Leyendo de " + _dirFichEntrada + " . . .");
            archivo = new File (_dirFichEntrada);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            String linea;
            _lineasEntrada = new ArrayList<String>();
            while((linea = br.readLine()) != null) {
                _lineasEntrada.add(linea);
            }

           //TRADUCCIÃ“N///////////////////////////////////////////////////////
           inicializa(); //Metodo que inicializara la pila al estado que mas nos interese
           System.out.println("Traduciendo . . .");
           comienzaTraduccion();

           //ESCRITURA////////////////////////////////////////////////////////
           try {
              System.out.println("Escribiendo en " + _dirFichSalida + " . . .");
              fichero = new FileWriter(_dirFichSalida);
              pw = new PrintWriter(fichero);
              for (int i = 0; i < _lineasSalida.size(); i++) {
                 pw.println(_lineasSalida.get(i));
              }
           } catch (Exception e1) {
              e1.printStackTrace();
           } finally {
                try {
                    if (null != fichero)
                        fichero.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
           }
           ///////////////////////////////////////////////////////////////////
        }
        catch(Exception e1){
           e1.printStackTrace();
        }finally{
            try{
                if( null != fr ){
                    fr.close();
                }
           }catch (Exception e2){
                e2.printStackTrace();
           }
        }
     }

    private void inicializa(){
        // Este metodo borra la memoria e incializara la pila
       _memoria = new int[20]; // Si no se quieres un numero finito de posiciones de memoria, se puede hacer con un arraylist
       //inicializar Pila
    }

    private void comienzaTraduccion() {
        _lineasSalida = new ArrayList<String>();
        for (int i = 0; i < _lineasEntrada.size(); i++) {
            distingueOperacion(_lineasEntrada.get(i));
        }
    }

    public void distingueOperacion(String linea){
           //Ojito con las ambiguedades, en caso de que una operacion contenga el nombre de otra (por ej: apila y desapila) chequear primero la mas larga (en el ejemplo: desapila)
        if (linea.contains("apila_entrada")) { //Es operacion "apila_entrada"
            // bla bla
        } else if (linea.contains("desapila_entrada:")){//Es operacion "apila_entrada"
            // bla bla
            // .
            // .
            // .
            // .
        } else {
             // bla bla
        }

    }

    public void op_apila_entrada(String e){
        /*Cuerpo*/

    }

    public void op_desapila_entrada(String e){
        /*Cuerpo*/
    }

    public void op_apila_dir(String e){
        /*Cuerpo*/
    }

    public void op_in(String e){
    }

    public void op_out(String e){
    }
    // .
    // .

    /*
     * Recursos
     *      if (linea.contains("+")
     *
     *      if (linea.replaceAll(" ","").endsWith(":")) { //Sí es etiqueta
                f (!linea.contains("class ")) {
                     //NO ES COMIENZO DE UNA CLASE:
                     if (linea.contains("&")){

            if (linea.startsWith("if")) {
     *
     *       StringTokenizer sT = new StringTokenizer(comp);
      String s1 = sT.nextToken("<>=!|&");
      String s2 = sT.nextToken("<>=!|&");


     String strDatos="6.3\n6.2\n6.4\n6.2";
    StringTokenizer tokens=new StringTokenizer(strDatos, "\n");
        int nDatos=tokens.countTokens();
        double[] datos=new double[nDatos];
        int i=0;
        while(tokens.hasMoreTokens()){
            String str=tokens.nextToken();
            datos[i]=Double.valueOf(str).doubleValue();
            System.out.println(datos[i]);
            i++;
        }
     *
     */
    // .
    // .
}
