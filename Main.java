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
        System.out.println("Que operacion desea hacer?");
        System.out.println("1) Suma");
        System.out.println("2) Resta");
        System.out.println("3) Multiplicación");
        System.out.println("4) División");
        int op = scan.nextInt();
        if( op != 4) {
        Ecuacion Ecuacion1 = new Ecuacion();
        Ecuacion Ecuacion2 = new Ecuacion();
        Operacion Operacion = new Operacion(Ecuacion1, Ecuacion2);
        Operacion.SwitchOperacion(op);
        }
        
    }
}
