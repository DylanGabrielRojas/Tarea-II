/**
 * @author Andres, Dylan
 */
import java.io.*;

public class Lector
{
     BufferedReader lector;
     boolean usando;
     /**
      * Lee el archivo que se le indique.
      * @param rutaArchivo
      */
    public Lector(String rutaArchivo)
    {
        try
        {
            lector = new BufferedReader( new FileReader(rutaArchivo));
            usando = true;
        }
        catch(IOException error)
        {
            usando = false;
            System.out.println("Error " + error);
        }	
    }
    /**
     * Cierra el archivo
     */
    public void cerrarArchivo()
    {
        if(usando)
        {
            try
            {
                lector.close();
            }
            catch(IOException error)
            {
                System.out.println("Error " + error);
            }
        }
        
        usando = false;
    }
    /**
     * Lee una linea y la devuelve como String
     * @return
     */
    public String leerLinea()
    {
        String contenido = null;
        
        if(usando)
        {
            try
            {
                contenido = lector.readLine(); 
            }
            catch(IOException error)
            {
                System.out.println("Error " + error);
            }
        }
        
        return contenido;
    }
    
}
 