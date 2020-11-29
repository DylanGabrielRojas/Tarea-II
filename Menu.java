/**
 * @author Andres, Dylan
 */
import java.util.*;
public class Menu
{
    private Scanner scan= new Scanner(System.in);
    private int modo;
    private String ecuacion;
    private boolean continuar=false;
    /**
     * Pregunta al usuario si quiere leer el archivo o
     * ingresar la ecuaciones directamente
     * @return
     */
    public int preguntarModo()
    {
        System.out.println("Desea leer las ecuaciones del archivo Ecuaciones.txt o deasea introducir las ecuaciones manualmente?");
        System.out.println("1.Leer desde archivo Ecuaciones.txt\n2.Introducir manualmente.");
        modo= scan.nextInt();
        return modo;
    }
    /**
     * Para cuando se escoge el modo manual este metodo pregunta le ecuacion que se desea simplificar
     * @return
     */
    public String preguntarEcuacion()
    {
        System.out.println("Ingrese la ecuacion que desea resolver. Formato: ecuacion|operando|ecuacion");
        ecuacion=scan.next();
        return ecuacion;
    }
    /**
     * pregunta al usuario si deasea agregar mas ecuaciones
     * @return
     */
    public boolean continuar()
    {
        int seleccion;
        System.out.println("Desea ingresar mas ecuaciones?");
        System.out.println("1.Si\n2.No");
        seleccion= scan.nextInt();
        
        switch(seleccion)
        {
            case 1:
                continuar=true;
                break;
            case 2:
                continuar=false;
                break;
        }
        return continuar;
    }
}
