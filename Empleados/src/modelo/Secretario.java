package modelo;

public class Secretario extends Empleado{

	private int nDespacho;
	private int nFax;
	private double salarioS;
	
	public Secretario(String nombre, String apellidos, String dni, String direccion, int edad, char sexo,
			boolean estadoCivil, int antiguedad, String tel, double salario, int nDespacho, int nFax) {
		super(nombre, apellidos, dni, direccion, edad, sexo, estadoCivil, antiguedad, tel, salario);
		this.nDespacho = nDespacho;
		this.nFax = nFax;
		this.salarioS = salario + 15/100; 
	}

	public int getnDespacho() {
		return nDespacho;
	}

	public void setnDespacho(int nDespacho) {
		this.nDespacho = nDespacho;
	}

	public int getnFax() {
		return nFax;
	}

	public void setnFax(int nFax) {
		this.nFax = nFax;
	}

	public double getSalarioS() {
		return salarioS;
	}

	public void setSalarioS(double salarioS) {
		this.salarioS = salarioS;
	}

	@Override
	public String toString() {
		return super.toString() + "Secretario [nDespacho=" + nDespacho + ", nFax=" + nFax + ", salarioS=" + salarioS + "]";
	}	
}
