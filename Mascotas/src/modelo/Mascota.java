package modelo;

public class Mascota {
//public abstract class Mascota {


	protected static int identificador = 0;
	protected int id;
	protected String nombre;
	protected int edad;
	protected Fecha fecha;
	protected String dniDueno;

	public Mascota(String nombre, int edad, Fecha fecha, String dniDueno) {
		identificador = identificador + 1;
		this.id = identificador;	
		this.nombre = nombre;
		this.edad = edad;
		this.fecha = fecha;
		this.dniDueno = dniDueno;
	}
	
//	public abstract void come();
	
	@Override
	public String toString() {
		return id + ", " + nombre + ", " + edad + ", " + fecha + ", " + dniDueno ;
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
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
