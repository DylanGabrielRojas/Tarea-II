
/**
 * Clase Monomio para los monomios
 *
 * @author Dylan, Andres
 * @version 11/17/2020
 */
public class Monomio
{
    // instance variables - replace the example below with your own
    private int valor;
    private String incognita;
    private int potencia;
    private Monomio siguiente;

    /**
     * Constructor for objects of class Monomio
     */
    public void Monomio()
    {
        this.valor = 0;
        String incognita = "X";
        int potencia= 0;
        this.siguiente = null;
    }
    
    public int getValor()
    {
        return valor;
    }
    
    public void setValor(int valor)
    {
        this.valor = valor;
    }
    
    public int getPotencia()
    {
        return valor;
    }
    
    public void setPotencia(int potencia)
    {
        this.valor = potencia;
    }
    
    public String getIncognita()
    {
        return incognita;
    }
    
    public void setIncognita(String Incognita)
    {
        this.incognita = incognita;
    }

    public Monomio getSiguiente()
    {
        return siguiente;
    }
    
    public void setSiguiente(Monomio siguiente)
    {
        this.siguiente = siguiente;
    }
}
