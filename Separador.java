/**
 * @author Andres Camacho
 * @version 18/11/2020
 */
public class Separador
{
	private int grado;
	String gradoString="0";
	private int potencia=0;
	String coeficienteString;
	 int[] coeficientes;
	private char incognita;
	int posicion=0;
	boolean encontrado=false;
	Separador(String ecuacion)
	{
		gradoEcuacion(ecuacion);
		coeficientes=new int[grado+1];
		coeficientesPolinomio(ecuacion);
	}
	
	public void gradoEcuacion(String ecuacion)
	{
		while(!encontrado)
		{
			if(ecuacion.charAt(posicion)=='^')
			{
				for(int posGrado=posicion+1;ecuacion.charAt(posGrado+1)=='+'||ecuacion.charAt(posGrado+1)=='-';posGrado++)
				{
					gradoString+=Character.toString(ecuacion.charAt(posGrado));
				}
				grado=Integer.parseInt(gradoString);
				incognita=ecuacion.charAt(posicion-1);
				encontrado= true;
			}
			posicion++;
		}
	}
	public void coeficientesPolinomio(String ecuacion)
	{
		
		int repeticiones=0;
		posicion=ecuacion.length()-1;
		while(repeticiones<ecuacion.length())
		{
			
			if(ecuacion.charAt(posicion)=='+'||ecuacion.charAt(posicion)=='-')
			{
				for(int posCoef=posicion+1;ecuacion.charAt(posCoef+1)==incognita;posCoef++)
				{
					if(ecuacion.charAt(posicion)=='-')
					{
						coeficienteString=Character.toString('-');
						posCoef++;
					}
					if(posCoef==posicion+1)
					{
						coeficienteString=Character.toString(ecuacion.charAt(posCoef));
					}
					else
					{
						coeficienteString+=Character.toString(ecuacion.charAt(posCoef-1));
					}
					
				}
				if(coeficienteString!=null)
				{
						coeficientes[potencia]=Integer.parseInt(coeficienteString);
						potencia++;
				}
				
			}
			posicion--;
			repeticiones++;
		}
		for(int posCoef=0; ecuacion.charAt(posCoef+1)==incognita;posCoef++)
		{
			if(ecuacion.charAt(0)=='-')
			{
				coeficienteString=Character.toString('-');
				posCoef++;
			}
			if(posCoef==0)
			{
				coeficienteString=Character.toString(ecuacion.charAt(posCoef));
			}
			else
			{
				coeficienteString+=Character.toString(ecuacion.charAt(posCoef));
			}
		}
		if(coeficienteString!=null)
		{
				coeficientes[potencia]=Integer.parseInt(coeficienteString);
		}
	}
	public int getGrado() {
		return grado;
	}
	public void setGrado(int grado) {
		this.grado = grado;
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
