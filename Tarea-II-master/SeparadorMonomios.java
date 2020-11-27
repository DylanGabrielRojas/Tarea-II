/**
 * @author Andres Camacho
 * @version 18/11/2020
 */
public class SeparadorMonomios 
{
    private int cantidadMonomios;
    String gradoString="0";
    String coeficienteString="";
    String potenciaString="";
    private int[] coeficientes;
    private int[] potencias;
    private char incognita;
    int posicion=0;
    boolean encontrado=false;
    SeparadorMonomios(String ecuacion)
    {
        cantidadMonomios(ecuacion);
        hallarIncognita(ecuacion);
        coeficientes=new int[cantidadMonomios];
        potencias=new int[cantidadMonomios];
        coeficientesPolinomio(ecuacion);
        asignarPotencias(ecuacion);
    }
    
    public void cantidadMonomios(String ecuacion)
    {
        for(int posCoef=0;posCoef<ecuacion.length();posCoef++)
        {
            if(posCoef>0)
            {
              if(ecuacion.charAt(posCoef)=='-'||ecuacion.charAt(posCoef)=='+')
            {
                cantidadMonomios++;
            }  
            }
        }
        cantidadMonomios++;
    }
    public void hallarIncognita(String ecuacion)
    {
        int posCoef=0;
        while(!Character.isAlphabetic(ecuacion.charAt(posCoef)))
        {
            posCoef++;
        }
        incognita=ecuacion.charAt(posCoef);
    }
    public void coeficientesPolinomio(String ecuacion)
    {
        int indice=cantidadMonomios-1;
        for(int posCoef=0;posCoef<ecuacion.length();posCoef++)
        {
            if(Character.isDigit(ecuacion.charAt(posCoef)))
            {
                if(posCoef>0)
                {
                    if(ecuacion.charAt(posCoef-1)=='-')
                    {
                        coeficienteString+=ecuacion.charAt(posCoef-1);
                    }
                }
                coeficienteString+=ecuacion.charAt(posCoef);
            }
            else if(ecuacion.charAt(posCoef)==incognita)
            {
                coeficientes[indice]=Integer.parseInt(coeficienteString);
                indice--;
            }
            else
            {
                coeficienteString="";
            }
        }
    }
    public void asignarPotencias(String ecuacion)
    {
        int indice=cantidadMonomios-1;
        for(int posCoef=0;posCoef<ecuacion.length();posCoef++)
        {
            if(posCoef>0)
            {
                if(Character.isDigit(ecuacion.charAt(posCoef)))
                {
                    potenciaString+=ecuacion.charAt(posCoef);
                }
                else if(ecuacion.charAt(posCoef)=='+'||ecuacion.charAt(posCoef)=='-')
                {
                    potencias[indice]=Integer.parseInt(potenciaString);
                    indice--;
                }
                else
                {
                    potenciaString="";
                }
            }
        }
    }
    public int getCoeficiente(int posicion)
    {
        return coeficientes[posicion];
    }
    public int getPotencia(int posicion)
    {
        return potencias[posicion];
    }
    public int getCantidadMonomios() {
        return cantidadMonomios;
    }

     public char getIncognita() {
        return incognita;
    }
    public void setIncognita(char incognita) {
        this.incognita = incognita;
    }

    public int[] getCoeficientes() {
        return coeficientes;
    }

    public void setCoeficientes(int[] coeficientes) {
        this.coeficientes = coeficientes;
    }
    
}
