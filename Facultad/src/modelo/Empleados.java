package modelo;

import java.time.Year;

public class Empleados extends Persona{

	private Year anoIncorporacion;
	private int numeroDespacho;

	public Empleados(String nombre, String apellidos, String dni, boolean estadoCivil, Year anoIncorporacion,
			int numeroDespacho) {
		super(nombre, apellidos, dni, estadoCivil);
		this.anoIncorporacion = anoIncorporacion;
		this.numeroDespacho = numeroDespacho;
	}
	
	public void reasignarDespacho(int nDespacho) {
		this.numeroDespacho = nDespacho;
	}

	public Year getAnoIncorporacion() {
		return anoIncorporacion;
	}

	public void setAnoIncorporacion(Year anoIncorporacion) {
		this.anoIncorporacion = anoIncorporacion;
	}

	public int getNumeroDespacho() {
		return numeroDespacho;
	}

	public void setNumeroDespacho(int numeroDespacho) {
		this.numeroDespacho = numeroDespacho;
	}

	@Override
	public String toString() {
		return super.toString() + "| Empleados [ AÑO DE INCORPORACION = " + anoIncorporacion + ", Nº DESPACHO = " + numeroDespacho + "] | ";
	}
		
}