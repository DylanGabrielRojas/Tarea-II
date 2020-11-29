/**
 * Clase Modelo para las operaciones
 *
 * @author Dylan y Andres
 * @version 11/17/2020
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


    /**
     * Metodo de suma, envia los parametros al metodo recursivo para sumar
     */
    public String Suma()
    {
        Monomio auxiliar1 = Ecuacion1.getInicio();
        Monomio auxiliar2 = Ecuacion2.getInicio();
        String resultado = SumarSemejantes(auxiliar1, auxiliar2);
        return resultado;
    }

    /**
     * metodo recursivo para sumar, efectua el algortimo para hacer la suma de los polinomios,
     * y devuelve el String con el resultado
     */
    public String SumarSemejantes(Monomio auxiliar1, Monomio auxiliar2)
    {
        String suma = "";
        if(auxiliar1.getPotencia() == auxiliar2.getPotencia()){
            if(auxiliar2.getSiguiente() != null){ 
                if (auxiliar1.getSiguiente() != null) {
                    int valor = auxiliar1.getValor() + auxiliar2.getValor();
                    suma = valor + auxiliar1.getIncognita() + "^" + auxiliar1.getPotencia() + " + ";
                    auxiliar2 = Ecuacion2.getInicio();
                    suma = suma + SumarSemejantes(auxiliar1.getSiguiente(), auxiliar2); 
                } else {
                    int valor = auxiliar1.getValor() + auxiliar2.getValor();
                    suma = valor + auxiliar1.getIncognita() + "^" + auxiliar1.getPotencia(); 
                }
            } else if (auxiliar1.getSiguiente() != null) {
                int valor = auxiliar1.getValor() + auxiliar2.getValor();
                suma = valor + auxiliar1.getIncognita() + "^" + auxiliar1.getPotencia() + " + ";
                auxiliar2 = Ecuacion2.getInicio();
                suma = suma + SumarSemejantes(auxiliar1.getSiguiente(), auxiliar2); 
            } else {
                int valor = auxiliar1.getValor() + auxiliar2.getValor();
                suma = valor + auxiliar1.getIncognita() + "^" +auxiliar1.getPotencia(); 
            }
        }else{
           if (auxiliar2.getSiguiente() != null) {
            return SumarSemejantes(auxiliar1, auxiliar2.getSiguiente()); 
            }
            else if (auxiliar1.getSiguiente() != null){
                auxiliar2 = Ecuacion2.getInicio();
                return SumarSemejantes(auxiliar1.getSiguiente(), auxiliar2);
            }
        }
        return suma;
    }


    /**
     * Metodo de resta, funciona igual a la suma, usa el mismo metodo recursivo solo que antes cambia los 
     * valores en la segunda ecuación por su contrario
     */
    public String Resta()
    {
        Monomio auxiliar1 = Ecuacion1.getInicio();
        Monomio auxiliar2 = Ecuacion2.getInicio();
        CambiarValor(auxiliar2);
        String resultado = SumarSemejantes(auxiliar1, auxiliar2);
        return resultado;
    }


    /**
     * metodo para cambiar los valores en una ecuación multiplicandolos por -1 funciona para la resta
     */
    public void CambiarValor(Monomio auxiliar)
    {
        auxiliar.setValor(auxiliar.getValor()*-1);
        if(auxiliar.getSiguiente() != null){
        CambiarValor(auxiliar.getSiguiente());
        }
    }

    /**
     * Metodo de Multiplicacion, envia los parametros al metodo recursivo para Multiplicar
     */
    public String Multiplicacion()
    {
        Monomio auxiliar1 = Ecuacion1.getInicio();
        Monomio auxiliar2 = Ecuacion2.getInicio();
        Ecuacion ecuacionResultado = new Ecuacion();
        String resultado = Multiplicar(auxiliar1, auxiliar2, ecuacionResultado);
        return resultado;
    }
    

    /**
     * metodo recursivo para Multiplicar, efectua el algortimo para hacer la Multiplicacion de los polinomios,
     * y devuelve el String con el resultado
     */
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

    /**
     * metodo recursivo para sumar los semenjantes del  amultiplicacion, 
     * efectua el algortimo para sumar los semenjantes,
     * y devuelve el String con el resultado
     */
    public String Sumar(Monomio auxiliar1, Monomio auxiliar2)
    {
        int valor = 0;
        Monomio auxiliarAnterior = auxiliar1;
        String suma = "";
        if (auxiliar1.getSiguiente() != null){
            valor = auxiliar1.getValor();
            while (auxiliar2.getSiguiente() != null) {
                if(auxiliar1.getPotencia() == auxiliar2.getPotencia()){
                    valor+=  auxiliar2.getValor();
                    auxiliarAnterior.setSiguiente(auxiliar2.getSiguiente());
                }
                auxiliarAnterior = auxiliar2;
                auxiliar2 = auxiliar2.getSiguiente();
            }
                suma = valor + auxiliar1.getIncognita() + "^" + auxiliar1.getPotencia() + "+" + 
                Sumar(auxiliar1.getSiguiente(), auxiliar1.getSiguiente().getSiguiente());
        } else {
            suma = auxiliar1.getValor() + auxiliar1.getIncognita() + auxiliar1.getPotencia();
        } 
        return suma;
    }


    /**
     * Metodo de Division, envia los parametros al metodo recursivo para Dividir, no envia a un recursivo
     * debido a que es imposible ser recursivo ya que la divison solo se efectua en 2 monomios
     */
    public String Division()
    {
        Monomio auxiliar1 = Ecuacion1.getInicio();
        Monomio auxiliar2 = Ecuacion2.getInicio();
        String resultado = "";
        if (auxiliar1.getSiguiente() == null && auxiliar2.getSiguiente() == null) {
            if (auxiliar1.getPotencia() < auxiliar2.getPotencia()){
                resultado = auxiliar1.getValor() + "/" + auxiliar2.getValor() + auxiliar1.getIncognita() 
                + "^" + (auxiliar1.getPotencia()-auxiliar2.getPotencia());
            } else {
                float cociente = (float) auxiliar1.getValor() / (float) auxiliar2.getValor();
                resultado = cociente + auxiliar1.getIncognita() 
                + "^" + (auxiliar2.getPotencia()-auxiliar1.getPotencia());
            }
        }
        else {
            resultado = "Las ecuaciones no son monomios";
        }
        return resultado;
    }
}
