/**
 * La clase SeparadorEcuaciones es la que recibe el String del lector 
 * y separa las ecuaciones en las partes correspondientes.
 * @author Andres, Dylan
 *
 */
public class SeparadorEcuaciones 
{
    private String ecuacion1;
    private String ecuacion2;
    private String operando;
    private String ecuacion;
    String[] ecuaciones;
    /**
     * El constructor de la clase recibe un string ecuacion y separa las dos
     * ecuaciones y el oeprando.
     * @param ecuacion
     */
    SeparadorEcuaciones(String ecuacion)
    {
            this.ecuacion=ecuacion;
            int posicion = 0;
            String ecuaciones[]=ecuacion.split("\\|");
            for(String temp: ecuaciones)
            {
                switch(posicion)
                {
                    case 0:
                    ecuacion1=temp;
                    break;
                    case 1:
                    operando=temp;
                    break;
                    case 2:
                    ecuacion2=temp;
                    break;
                }
                posicion++;
            }
    }
    /**
     * armarResultado es el metodo que se encarga de armar el string del resultado,
     * lo muestra en consola.
     * @param resultado
     * @return
     */
    public String armarResultado(String resultado)
    {
        System.out.println(ecuacion+" = "+resultado+"\n");
        return ecuacion+" = "+resultado+"\r\n";
    }
    public String getEcuacion1() {
        return ecuacion1;
    }
    public void setEcuacion1(String ecuacion1) {
        this.ecuacion1 = ecuacion1;
    }
    public String getEcuacion2() {
        return ecuacion2;
    }
    public void setEcuacion2(String ecuacion2) {
        this.ecuacion2 = ecuacion2;
    }
    public int getOperando() {
            int tipoOperacion = 0;
            switch (operando) {
                case "+":
                    tipoOperacion = 1;
                break;
                
                case "-":
                    tipoOperacion = 2;
                break;
                
                case "*":
                    tipoOperacion = 3;
                break;
                
                case "/":
                    tipoOperacion = 4;
                break;
            }
            return tipoOperacion;
    }
    public void setOperando(String operando) {
        this.operando = operando;
    }
    
}
