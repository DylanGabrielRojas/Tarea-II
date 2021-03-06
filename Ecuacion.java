
/**
 * Clase lista para las ecuaciones
 *
 * @author Dylan, Andres
 * @version 11/17/2020
 */
public class Ecuacion
    {
        private EcuacionModelo EcuacionModelo = new EcuacionModelo();
        private EcuacionVista EcuacionVista = new EcuacionVista();
    
    /**
     * Constructor for objects of class Ecuacion
     */
    public Ecuacion()
    {
    }
    
    public EcuacionVista getEcuacionVista(){
        return this.EcuacionVista;
    }
    
    /**
     * Metodo para agregar nodos a la lista
     */
    public void AgregarAModelo(int valor, char incognita, int potencia){
        EcuacionModelo.agregar(valor, incognita, potencia);
    }
    
    public Monomio getInicio(){
        return EcuacionModelo.getInicio();
    }
    
    
    public int getTamanio(){
        return EcuacionModelo.getTamanio();
    }
    
    /**
     * imprime la lista de ecuacion
     */
    public void imprimirEcuacion() {
        EcuacionVista.imprimirEcuacion(EcuacionModelo.imprimirEcuacion());
    }
}
