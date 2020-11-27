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
        Scanner scan = new Scanner(System.in);
        Lector lector= new Lector("Archivos/Ecuaciones.txt");
        SeparadorEcuaciones separarEcuaciones= new SeparadorEcuaciones(lector.leerLinea());
        SeparadorMonomios separarEcuacion1= new SeparadorMonomios(separarEcuaciones.getEcuacion1());
        SeparadorMonomios separarEcuacion2= new SeparadorMonomios(separarEcuaciones.getEcuacion2());
        System.out.println(separarEcuaciones.getEcuacion1());
        System.out.println(separarEcuaciones.getEcuacion2());
        Ecuacion ecuacion1 = new Ecuacion();
        Ecuacion ecuacion2 = new Ecuacion();
        for(int indice=0;indice<separarEcuacion1.getCantidadMonomios();indice++)
        {
            ecuacion1.AgregarAModelo(separarEcuacion1.getCoeficiente(indice),separarEcuacion1.getIncognita(),separarEcuacion1.getPotencia(indice));
        }
        for(int indice=0;indice<separarEcuacion2.getCantidadMonomios();indice++)
        {
            ecuacion2.AgregarAModelo(separarEcuacion2.getCoeficiente(indice),separarEcuacion2.getIncognita(),separarEcuacion2.getPotencia(indice));
        }
        Operacion Operacion = new Operacion(ecuacion1, ecuacion2);
        Operacion.setTipo(separarEcuaciones.getOperando());
        Operacion.SwitchOperacion();
    }
}
