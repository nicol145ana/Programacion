package modelo;

public class Periodicos extends Publicacion{

	private String nombre;
	private String fechaPublicacion;
	
	public Periodicos() {
		super();
	}

	public Periodicos(double precio, int unidades, String nombre, String fechaPublicacion) {
		super(precio, unidades);
		this.nombre = nombre;
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getFechaPublicacion() {
		return fechaPublicacion;
	}
	
	public void setFechaPublicacion(String fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	@Override
	public String toString() {
		return super.toString() + 
				"\n_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _|\n"
				+ "				 |\n" 
				+ "    Datos del periodico 	 |"
				+ "\n				 |"	
				+ "\n\tNombre = " + nombre + "		 |"
				+ " \n\tFecha = " + fechaPublicacion + "		 |"
				+ "\n_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _|";
	}
	
	
}