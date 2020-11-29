/**
 * Clase para las operaciones
 *
 * @author Dylan y Andres
 * @version 11/17/2020
 */
public class Operacion
{
    private OperacionModelo OperacionModelo;
    private OperacionVista OperacionVista;
    private int tipo;
    private String resultado;
    /**
     * Constructor for objects of class Operacion
     */
    public Operacion(Ecuacion Ecuacion1, Ecuacion Ecuacion2)
    {
         this.OperacionModelo = new OperacionModelo(Ecuacion1, Ecuacion2);
    }
    
    public void setTipo(int Tipo){
        this.tipo = Tipo;
    }
    
    /**
     * Switch para enviar a la operacion segun el tipo de operacion que ingreso el usuario
     */
    public String SwitchOperacion() {
    switch (tipo){
        case 1:
            resultado=OperacionModelo.Suma();
        break;
        case 2:
             resultado=OperacionModelo.Resta();
        break;
        case 3:
             resultado=OperacionModelo.Multiplicacion();
        break;
        case 4:
             resultado=OperacionModelo.Division();
        break;
    }
    return resultado;
}
}
