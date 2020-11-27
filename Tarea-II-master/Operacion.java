
/**
 * Write a description of class Operacion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Operacion
{
    private OperacionModelo OperacionModelo;
    private OperacionVista OperacionVista;

    /**
     * Constructor for objects of class Operacion
     */
    public Operacion(Ecuacion Ecuacion1, Ecuacion Ecuacion2)
    {
         this.OperacionModelo = new OperacionModelo(Ecuacion1, Ecuacion2);
    }
    
    public void SwitchOperacion(int op) {
    switch (op){
        case 1:
            OperacionModelo.Suma();
        break;
        case 2:
            OperacionModelo.Resta();
        break;
        case 3:
            OperacionModelo.Multiplicacion();
        break;
    }
}
}
