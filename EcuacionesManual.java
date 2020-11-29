/**
 * 
 * @author Andres, Dylan
 *
 */
public class EcuacionesManual
{
    private Ecuacion ecuacion1;
    private Ecuacion ecuacion2;
    private String ecuacionOriginal;
    private Menu menu= new Menu();
    private OperacionVista OperacionVista= new OperacionVista();
    private boolean continuar=true;
    /**
     * Este metodo es el encargado de manejar la logica para 
     * ingresar ecuaciones manualmente
     */
    public void resolverEcuacion()
    {
        Ecuacion ecuacion1 = new Ecuacion();
        Ecuacion ecuacion2 = new Ecuacion();
        while(continuar)
        {
            ecuacionOriginal=menu.preguntarEcuacion();
            SeparadorEcuaciones separarEcuaciones= new SeparadorEcuaciones(ecuacionOriginal);
            SeparadorMonomios separarEcuacion1= new SeparadorMonomios(separarEcuaciones.getEcuacion1());
            SeparadorMonomios separarEcuacion2= new SeparadorMonomios(separarEcuaciones.getEcuacion2());
            for(int indice=0;indice<separarEcuacion1.getCantidadMonomios();indice++)
            {
                ecuacion1.AgregarAModelo(separarEcuacion1.getCoeficiente(indice),separarEcuacion1.getIncognita(),separarEcuacion1.getPotencia(indice));
            }
            for(int indice=0;indice<separarEcuacion2.getCantidadMonomios();indice++)
            {
                ecuacion2.AgregarAModelo(separarEcuacion2.getCoeficiente(indice),separarEcuacion2.getIncognita(),separarEcuacion2.getPotencia(indice));
            }
            Operacion Operacion = new Operacion(ecuacion1, ecuacion2);
            Operacion.setTipo(separarEcuaciones.getOperando());
            OperacionVista.imprimirResultado(Operacion.SwitchOperacion());
            continuar=menu.continuar();
        }
        
    }
}
