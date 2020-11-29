/**
 * @author Andres, Dylan
 */
import java.io.*;

public class Escritor
{
    private BufferedWriter escritor;
    private boolean usando;
    
    /**
     * El constructor de la clase Escritor es la que abre el asrchivo
     * indicado en el String ruta.
     * @param ruta
     */
    public Escritor(String ruta)
    {
        abrirArchivo(ruta, true);
    }
    /**
     * Abre el archivo
     * @param ruta
     * @param agregarAlFinal
     */
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
    /**
     * Cierra el archivo
     */
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
    /**
     * agrega el texto deseado al archivo.
     * @param texto
     * @return
     */
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
