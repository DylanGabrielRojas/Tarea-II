
/**
 * Write a description of class SeparadorEcuaciones here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SepararEcuaciones 
{
    private String ecuacion1;
    private String ecuacion2;
    private String operando;
    private int posicion;
    SepararEcuaciones(String ecuacion)
    {
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
