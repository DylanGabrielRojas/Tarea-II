 
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
                suma = valor + auxiliar1.getIncognita() + "^" + auxiliar1.getPotencia() + "+" +
                SumarSemejantes(auxiliar1.getSiguiente(), auxiliar2.getSiguiente()); 
            }
            else {
                int valor = auxiliar1.getValor() + auxiliar2.getValor();
                suma = valor + auxiliar1.getIncognita() + "^" +auxiliar1.getPotencia(); 
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
        Monomio auxiliar1 = Ecuacion1.getInicio();
        Monomio auxiliar2 = Ecuacion2.getInicio();
        Ecuacion ecuacionResultado = new Ecuacion();
        String resultado = Multiplicar(auxiliar1, auxiliar2, ecuacionResultado);
        System.out.println(resultado);
    }
    
    public String Multiplicar(Monomio auxiliar1, Monomio auxiliar2, Ecuacion ecuacionResultado)
    {
        String multiplicacion = "";
        if(auxiliar2.getSiguiente() != null){
            int valor = auxiliar1.getValor() * auxiliar2.getValor();
            int potencia = auxiliar1.getPotencia() + auxiliar2.getPotencia();
            ecuacionResultado.AgregarAModelo(valor, auxiliar1.getIncognita().charAt(0), potencia);
            multiplicacion = multiplicacion + Multiplicar(auxiliar1, auxiliar2.getSiguiente(), ecuacionResultado);
        }
        else if(auxiliar1.getSiguiente() != null){
            int valor = auxiliar1.getValor() * auxiliar2.getValor();
            int potencia = auxiliar1.getPotencia() + auxiliar2.getPotencia();
            ecuacionResultado.AgregarAModelo(valor, auxiliar1.getIncognita().charAt(0), potencia);
            auxiliar2 = Ecuacion2.getInicio();
            multiplicacion = multiplicacion + Multiplicar(auxiliar1.getSiguiente(), auxiliar2, ecuacionResultado);
        } else {
            int valor = auxiliar1.getValor() * auxiliar2.getValor();
            int potencia = auxiliar1.getPotencia() + auxiliar2.getPotencia();
            ecuacionResultado.AgregarAModelo(valor, auxiliar1.getIncognita().charAt(0), potencia);
            auxiliar1 = ecuacionResultado.getInicio();
            auxiliar2 = auxiliar1.getSiguiente();
            multiplicacion = Sumar(auxiliar1, auxiliar2);
        }
        return multiplicacion;
    }

    public String Sumar(Monomio auxiliar1, Monomio auxiliar2)
    {
        int valor = 0;
        Monomio auxiliarAnterior = auxiliar1;
        String suma = "";
        if (auxiliar1.getSiguiente() != null){
            while (auxiliar2.getSiguiente() != null) {
                if(auxiliar1.getPotencia() == auxiliar2.getPotencia()){
                    valor+= auxiliar1.getValor() + auxiliar2.getValor();
                    auxiliarAnterior.setSiguiente(auxiliar2.getSiguiente());
                }
                auxiliarAnterior = auxiliar2;
                auxiliar2 = auxiliar2.getSiguiente();
            }
            if (valor == 0) {
                suma = auxiliar1.getValor() + auxiliar1.getIncognita() + "^" + auxiliar1.getPotencia()
                + "+" + Sumar(auxiliar1.getSiguiente(), auxiliar1.getSiguiente().getSiguiente());
            } else {
                suma = valor + auxiliar1.getIncognita() + "^" + auxiliar1.getPotencia() + "+" + 
                Sumar(auxiliar1.getSiguiente(), auxiliar1.getSiguiente().getSiguiente());
            }
        } else {
            suma = auxiliar1.getValor() + auxiliar1.getIncognita() + auxiliar1.getPotencia();
        } 
        return suma;
    }

    public void Division()
    {
        Monomio auxiliar1 = Ecuacion1.getInicio();
        Monomio auxiliar2 = Ecuacion2.getInicio();
        String resultado = "";
        if (auxiliar1.getSiguiente() == null && auxiliar2.getSiguiente() == null) {
            if (auxiliar1.getPotencia() < auxiliar2.getPotencia()){
                resultado = auxiliar1.getValor() + "/" + auxiliar2.getValor() + auxiliar1.getIncognita() 
                + "^" + (auxiliar2.getPotencia()-auxiliar1.getPotencia());
            } else {
                float cociente = (float) auxiliar1.getValor() / (float) auxiliar2.getValor();
                resultado = cociente + auxiliar1.getIncognita() 
                + "^" + (auxiliar2.getPotencia()-auxiliar1.getPotencia());
            }
        }
        else {
            resultado = "Las ecuaciones no son monomios";
        }
            System.out.println(resultado);
    }
}
