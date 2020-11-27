/**
 * @author Andres Camacho
 * @version 18/11/2020
 */
import java.io.*;

public class Lector
{
     BufferedReader lector;
     boolean usando;

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
 