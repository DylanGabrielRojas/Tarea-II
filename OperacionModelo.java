
/**
 * Write a description of class OperacionModelo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OperacionModelo
{
    private Ecuacion Ecuacion1;
    private Ecuacion Ecuacion2;
    /**
     * Constructor for objects of class OperacionModelo
     */
    public OperacionModelo(Ecuacion Ecuacion01, Ecuacion Ecuacion02)
    {
        this.Ecuacion1 = Ecuacion01;
        this.Ecuacion2 = Ecuacion02;
    }

    public void Suma()
    {
        Monomio auxiliar1 = Ecuacion1.getInicio();
        Monomio auxiliar2 = Ecuacion2.getInicio();
        String resultado = SumarSemejantes(auxiliar1, auxiliar2);
        System.out.println(resultado);
    }

    public String SumarSemejantes(Monomio auxiliar1, Monomio auxiliar2)
    {
        String suma = "";
        if(auxiliar1.getPotencia() == auxiliar2.getPotencia()){
            if(auxiliar2.getSiguiente() != null && auxiliar1.getSiguiente() != null){
                int valor = auxiliar1.getValor() + auxiliar2.getValor();
                suma = valor + auxiliar1.getIncognita() + auxiliar1.getPotencia() + "+" +
                SumarSemejantes(auxiliar1.getSiguiente(), auxiliar2.getSiguiente()); 
            }
            else {
                int valor = auxiliar1.getValor() + auxiliar2.getValor();
                suma = valor + auxiliar1.getIncognita() + auxiliar1.getPotencia(); 
            }
        }
        else {
            if (auxiliar1.getPotencia() >  auxiliar2.getPotencia() && auxiliar2.getSiguiente() != null) {
            return SumarSemejantes(auxiliar1, auxiliar2.getSiguiente()); 
            }
            else if (auxiliar1.getSiguiente() != null){
                SumarSemejantes(auxiliar1.getSiguiente(), auxiliar2);
            }
        }
        return suma;
    }

    public void Resta()
    {
        Monomio auxiliar1 = Ecuacion1.getInicio();
        Monomio auxiliar2 = Ecuacion2.getInicio();
        CambiarValor(auxiliar2);
        String resultado = SumarSemejantes(auxiliar1, auxiliar2);
        System.out.println(resultado);
    }

    public void CambiarValor(Monomio auxiliar)
    {
        auxiliar.setValor(auxiliar.getValor()*-1);
        if(auxiliar.getSiguiente() != null){
        CambiarValor(auxiliar.getSiguiente());
        }
    }

    public void Multiplicacion()
    {
    }
    
    public boolean existeSemejante()
    {
        Monomio auxiliar1 = Ecuacion1.getInicio();
        Monomio auxiliar2 = Ecuacion2.getInicio();
        boolean encontrado = false;
        
        while(auxiliar1 != null && !encontrado)
        {
            encontrado = (auxiliar1.getValor() == auxiliar2.getValor());
            auxiliar2 = auxiliar2.getSiguiente();
        }
        
        return encontrado;
    }
    
    public Ecuacion retorno(){return Ecuacion1;}
}
