package modelo;

public class Persona {

	protected static int identificacion = 0;
	protected int id;
	protected String nombre;
	protected String apellidos;
	protected String dni;
	protected boolean estadoCivil;

	public Persona(String nombre, String apellidos, String dni, boolean estadoCivil) {
		this.id = identificacion;
		identificacion = identificacion + 1;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.estadoCivil = estadoCivil;
	}
	
	private String estadoCivil() {
		if(this.estadoCivil == true) {
			return "casado";
		}else {
			return "soltero";
		}
	}
	
	public void cambiarEstadoCivil(boolean cambioEstado) {
		if(cambioEstado == true) {
			this.estadoCivil = true;
		}else {
			this.estadoCivil = false;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public boolean isEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(boolean estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	@Override
	public String toString() {
		return " | Persona [ ID = " + id + ", NOMBRE = " + nombre + ", APELLIDOS = " + apellidos + ", DNI = " + dni
				+ ", ESTADO CIVIL = " + estadoCivil() + "] | ";
	}

}