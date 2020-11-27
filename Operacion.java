
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
    }
    return resultado;
}
    public String getResultado()
    {
        return resultado;
    }
}
