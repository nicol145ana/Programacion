package modelo;

public class Libros extends Publicacion {

	private String titulo;
	private String autor;
	private String editorial;
	
	public Libros() {
		super();
	}
	
	public Libros(double precio, int unidades, String titulo, String autor, String editorial) {
		super(precio, unidades);
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	@Override
	public String toString() {
		return super.toString() + 
				"\n_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _|\n"
				+ "				 |\n" 
				+ "    Datos del libro 	 	 |"
				+ "\n				 |"	
				+ "\n\tTitulo = " + titulo + "		 |"
				+ " \n\tAutor = " + autor + "		 |"
				+ " \n\tEditorial = " + editorial + "		 |"
				+ "\n_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _|";
				
	}


}