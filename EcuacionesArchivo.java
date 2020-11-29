/**
 * La clase EcuacionesArchivo es la clase encargada de leer el archivo
 * Ecuaciones.txt y saca las ecuaciones que luego agrega a una lista
 * enlazada
 * @author Andres, Dylan
 *
 */
public class EcuacionesArchivo 
{
	private Ecuacion ecuacion1;
    private Ecuacion ecuacion2;
    private String resultado;
    /**
     * resolverArchivo() es el metodo que lee el archivo, arma las listas
     * y finalmente agrega los resultados al archivo Resultados.txt
     */
    public void resolverArchivo()
    {
        
        Lector lector= new Lector("Archivos/Ecuaciones.txt");
        String linea="";
        Escritor escritor= new Escritor("Archivos/Resultados.txt");
        while((linea=lector.leerLinea())!=null)
        {
            Ecuacion ecuacion1 = new Ecuacion();
            Ecuacion ecuacion2 = new Ecuacion();
            SeparadorEcuaciones separarEcuaciones= new SeparadorEcuaciones(linea);
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
            resultado=Operacion.SwitchOperacion();
            escritor.escribir(separarEcuaciones.armarResultado(resultado));
        }
        escritor.cerrarArchivo();
        lector.cerrarArchivo();
    }
}
