
/**
 * Write a description of class OperacionModelo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OperacionModelo
{
    Ecuacion Ecuacion1;
    Ecuacion Ecuacion2;
    /**
     * Constructor for objects of class OperacionModelo
     */
    public OperacionModelo(Ecuacion Ecuacion1, Ecuacion Ecuacion2)
    {
        Ecuacion1 = Ecuacion1;
        Ecuacion2 = Ecuacion2;
    }

    public void Suma()
    {
        Monomio auxiliar1 = Ecuacion1.GetEcuacionModelo().getInicio();
        Monomio auxiliar2 = Ecuacion2.GetEcuacionModelo().getInicio();
        String resultado = SumarSemejantes(auxiliar1, auxiliar2);
    }

    public String SumarSemejantes(Monomio auxiliar1, Monomio auxiliar2)
    {
        String suma = "";
        if(auxiliar1.getPotencia() == auxiliar2.getPotencia()){
            if(auxiliar2.getSiguiente() != null){
                int valor = auxiliar1.getValor() + auxiliar2.getValor();
                suma = valor + auxiliar1.getIncognita() + auxiliar1.getPotencia() + 
                SumarSemejantes(auxiliar1, auxiliar2.getSiguiente()); 
            }
            else if(auxiliar1.getSiguiente() != null){
                int valor = auxiliar1.getValor() + auxiliar2.getValor();
                suma = valor + auxiliar1.getIncognita() + auxiliar1.getPotencia() + 
                SumarSemejantes(auxiliar1.getSiguiente(), auxiliar2); 
            }
            else {
                int valor = auxiliar1.getValor() + auxiliar2.getValor();
                suma = valor + auxiliar1.getIncognita() + auxiliar1.getPotencia(); 
            }
        }
        return suma;
    }

    public void Resta()
    {
        Monomio auxiliar1 = Ecuacion1.GetEcuacionModelo().getInicio();
        Monomio auxiliar2 = Ecuacion2.GetEcuacionModelo().getInicio();
        CambiarValor(auxiliar2);
        String resultado = SumarSemejantes(auxiliar1, auxiliar2);
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
        Monomio auxiliar1 = Ecuacion1.GetEcuacionModelo().getInicio();
        Monomio auxiliar2 = Ecuacion2.GetEcuacionModelo().getInicio();
        boolean encontrado = false;
        
        while(auxiliar1 != null && !encontrado)
        {
            encontrado = (auxiliar1.getValor() == auxiliar2.getValor());
            auxiliar2 = auxiliar2.getSiguiente();
        }
        
        return encontrado;
    }
}
