
public class SeparadorEcuaciones 
{
	private String ecuacion1;
	private String ecuacion2;
	private String operando;
	String[] ecuaciones;
	SeparadorEcuaciones(String ecuacion)
	{
		ecuaciones=ecuacion.split("|");
		
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
	public String getOperando() {
		return operando;
	}
	public void setOperando(String operando) {
		this.operando = operando;
	}
	
}
