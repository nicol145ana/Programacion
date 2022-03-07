package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Mascota {


	protected static int identificador = 0;
	protected int id;
	protected String nombre;
	protected Fecha fecha;
	protected String dniDueno;

	public Mascota(String nombre, Fecha fecha, String dniDueno) {
		identificador = identificador + 1;
		this.id = identificador;	
		this.nombre = nombre;
		this.fecha = fecha;
		this.dniDueno = dniDueno;
	}
	
	private void calcularEdad() {
		
		LocalDate fechaActual = LocalDate.now();
		String fechaN = String.valueOf(this.fecha.getDia()).concat("-" + String.valueOf(this.fecha.getMes()) + "-" + String.valueOf(this.fecha.getAno()));

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d"); 		
		LocalDate fechaNacimiento = LocalDate.parse(fechaN, formatter);

		int edad = fechaActual.getYear() - fechaNacimiento.getYear();

	}
		
	@Override
	public String toString() {
		return id + ", " + nombre + ", " + fecha + ", " + dniDueno ;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	public String getDniDueno() {
		return dniDueno;
	}

	public void setDniDueno(String dniDueno) {
		this.dniDueno = dniDueno;
	}

}
