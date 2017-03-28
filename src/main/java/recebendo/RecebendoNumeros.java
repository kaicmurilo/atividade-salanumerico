package recebendo;

public class RecebendoNumeros {
	private int num1;
	private int num2;
	private String operador;
	
	public RecebendoNumeros() {
	
	}
	public RecebendoNumeros(String operador,int num1,int num2) {
		this.setNum1(num1);
		this.setNum2(num2);
		this.setOperador(operador); 
		
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
}
