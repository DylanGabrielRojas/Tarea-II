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
        SepararEcuaciones separarEcuaciones= new SepararEcuaciones(lector.leerLinea());
        Separador separarEcuacion1= new Separador(separarEcuaciones.getEcuacion1());
        Separador separarEcuacion2= new Separador(separarEcuaciones.getEcuacion2());
        System.out.println(separarEcuaciones.getEcuacion1());
        
        System.out.println("Que operacion desea hacer?");
        System.out.println("1) Suma");
        System.out.println("2) Resta");
        System.out.println("3) Multiplicación");
        System.out.println("4) División");
        int op = scan.nextInt();
            if( op != 4) {
            Ecuacion ecuacion1 = new Ecuacion();
            Ecuacion ecuacion2 = new Ecuacion();
            for(int potencia=0;potencia<separarEcuacion1.getGrado()+1;potencia++)
            {
                ecuacion1.AgregarAModelo(separarEcuacion1.coeficientes[potencia],separarEcuacion1.getIncognita(),potencia);
                ecuacion2.AgregarAModelo(separarEcuacion2.coeficientes[potencia],separarEcuacion1.getIncognita(),potencia);

            }
            
            ecuacion1.imprimirEcuacion();
            Operacion Operacion = new Operacion(ecuacion1, ecuacion2);
            Operacion.SwitchOperacion(op);
        }
        
        
        
    }
}
