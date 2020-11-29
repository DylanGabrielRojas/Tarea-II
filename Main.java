import java.util.Scanner;
/**
 * Clase principal
 *
 * @author Dylan y Andres
 * @version 11/17/2020
 */
public class Main
{
    public static void main(String[] args)
    {
        Menu menu= new Menu();
        EcuacionesManual manual= new EcuacionesManual();
        EcuacionesArchivo archivo= new EcuacionesArchivo();
        
        switch(menu.preguntarModo())
        {
            case 1:
                archivo.resolverArchivo();
                break;
            case 2:
                manual.resolverEcuacion();
                break;
        }
    }
}
