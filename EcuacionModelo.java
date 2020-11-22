/**
 * Clase lista para las ecuaciones
 *
 * @author Dylan, Andres
 * @version 11/17/2020
 */
public class EcuacionModelo
{
    private Monomio inicio;
    private int tamanio;

    /**
     * Constructor for objects of class Ecuacion
     */
    public EcuacionModelo()
    {
        inicio = null;
        tamanio = 0;
    }

    public boolean esVacia()
    {
        return inicio == null;
    }
    
    public int getTamanio()
    {
        return tamanio;
    }
    
    public Monomio getInicio()
    {
        return inicio;
    }
    
    public void agregar(int valor, String incognita, int potencia)
    {
        Monomio nuevoNodo = new Monomio();
        nuevoNodo.setValor(valor);
        nuevoNodo.setIncognita(incognita);
        nuevoNodo.setPotencia(potencia);
        
        if(esVacia())
        {
            inicio = nuevoNodo;
        }
        else
        {
            Monomio auxiliar = inicio;
            
            while(auxiliar.getSiguiente() != null)
            {
                auxiliar = auxiliar.getSiguiente();
            }
            
            auxiliar.setSiguiente(nuevoNodo);
        }
        
        tamanio++;
    }
    
    
    public void imprimirEcuacion()
    {
        if(!esVacia())
        {
            Monomio auxiliar = inicio;
            
            while(auxiliar.getSiguiente() != null)
            {
                System.out.println(auxiliar.getValor() + auxiliar.getIncognita() 
                + auxiliar.getPotencia() + " + ");
                auxiliar = auxiliar.getSiguiente();
            }
            System.out.println(auxiliar.getValor() + auxiliar.getIncognita() 
            + auxiliar.getPotencia());
        }
    }
    
    
    
    
    
}
