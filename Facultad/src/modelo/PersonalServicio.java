package modelo;

import java.time.Year;

public class PersonalServicio extends Empleados{
	
	private String seccion;

	public PersonalServicio(String nombre, String apellidos, String dni, boolean estadoCivil, Year anoIncorporacion,
			int numeroDespacho, String seccion) {
		super(nombre, apellidos, dni, estadoCivil, anoIncorporacion, numeroDespacho);
		this.seccion = seccion;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	@Override
	public String toString() {
		return super.toString() + "| PersonalServicio [ SECCION DE TRABAJO = " + seccion + "] | ";
	}

}