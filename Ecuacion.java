
/**
 * Clase lista para las ecuaciones
 *
 * @author Dylan, Andres
 * @version 11/17/2020
 */
public class Ecuacion
    {
    private EcuacionModelo EcuacionModelo;
    private EcuacionVista EcuacionVista;

    public void Ecuacion()
    {
         EcuacionModelo EcuacionModelo = new EcuacionModelo();
         EcuacionVista EcuacionVista = new EcuacionVista();
    }
    
    public EcuacionModelo GetEcuacionModelo(){
        return EcuacionModelo;
    }
}
