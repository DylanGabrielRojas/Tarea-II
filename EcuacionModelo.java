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
    
    public void agregar(int valor, char incognita, int potencia)
    {
        Monomio nuevoNodo = new Monomio();
        nuevoNodo.setValor(valor);
        nuevoNodo.setIncognita(Character.toString(incognita));
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
    
    
    public String imprimirEcuacion()
    {
        String stringEcuacion = "";
        if(!esVacia())
        {
            Monomio auxiliar = inicio;
            while(auxiliar.getSiguiente() != null)
            {
                stringEcuacion = auxiliar.getValor() + auxiliar.getIncognita() 
                + "^" + auxiliar.getPotencia() + " + ";
                auxiliar = auxiliar.getSiguiente();
            }
            stringEcuacion = auxiliar.getValor() + auxiliar.getIncognita() 
            + "^" +  auxiliar.getPotencia() + "\n";
        }
        return stringEcuacion;
    }
    
    
    
    
    
}
