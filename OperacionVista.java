
/**
 * Write a description of class OperacionVista here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OperacionVista
{
    private int contador=1;
    public void imprimirResultado(String resultado)
    {
        System.out.println("El resultado de la ecuacion "+contador+" es: "+ resultado);
        contador++;
    }
}
