package modelo;

import java.time.Year;

public class Profesores extends Empleados{

	private String Departamento;

	public Profesores(String nombre, String apellidos, String dni, boolean estadoCivil, Year anoIncorporacion,
			int numeroDespacho, String nDepartamento) {
		super(nombre, apellidos, dni, estadoCivil, anoIncorporacion, numeroDespacho);
		this.Departamento = nDepartamento;
	}

	public void cambiarDepartamento(String departamento) {
		this.Departamento = departamento;
	}
	
	public String getDepartamento() {
		return Departamento;
	}

	public void setDepartamento(String nDepartamento) {
		this.Departamento = nDepartamento;
	}

	@Override
	public String toString() {
		return super.toString() + "| Profesores [ DEPARTAMENTO = " + Departamento + "] | ";
	}
	
}