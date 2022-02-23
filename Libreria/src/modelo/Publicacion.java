package modelo;

public class Publicacion {

	protected double precio;
	protected int unidades;

	public Publicacion() {

	}

	public Publicacion(double precio, int unidades) {
		super();
		this.precio = precio;
		this.unidades = unidades;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	@Override
	public String toString() {
		return "_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _\n"
				+ "				 |\n"	
				+ "    Datos de la publicacion 	 |"
				+ "\n				 |"	
				+ "\n\tPrecio = " + precio + "		 |"
				+ " \n\tUnidades = " + unidades + "		 |";
	}

	public String venderCantidad(int unidadesC) {
		
		if(unidades <= 0) {
			return "No tenemos unidades disponibles";
		}else if ((unidades - unidadesC) < 0){
			unidades = unidades - unidadesC;
			unidadesC = unidadesC + unidades;
			unidades = 0;
			return "Solo se ha adquirido " + unidadesC + " porque es lo maximo que tenemos";
		}else {
			unidades = unidades - unidadesC;
			return "Compra realizada con exito";
		}
	}

	public String aumentarNumUnidades(int unidadesP){
		unidades = unidades + unidadesP;
		return "Unidades actualizadas";
	}

}