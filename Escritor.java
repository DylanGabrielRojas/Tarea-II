/**
 * @author Andres Camacho
 * @version 18/11/2020
 */
import java.io.*;

public class Escritor
{
    private BufferedWriter escritor;
    private boolean usando;
    public Escritor(String ruta)
    {
        abrirArchivo(ruta, true);
    }
    
    public void abrirArchivo(String ruta, boolean agregarAlFinal)
    {
        try{
            escritor = new BufferedWriter(new FileWriter(ruta, agregarAlFinal));
            usando = true;
        }   
        catch(IOException error)
        {
            usando = false;
            System.out.println("Ocurrio un error al abrir el archivo");
        }
    }
    
    public void cerrarArchivo()
    {
        if(usando)
        {
            try
            {
                escritor.close();
            }
            catch(IOException error)
            {
                System.out.println("Error");
            }
        }
        
        usando = false;
    }
    
    public boolean escribir(String texto)
    {
        boolean escrito = false;
        
        if(usando)
        {
            try
            {
                escritor.write(texto);
                escrito = true;
            }
            catch(IOException error)
            {
                System.out.println("Error");
            }
        }
        
        return escrito;
    }
}
