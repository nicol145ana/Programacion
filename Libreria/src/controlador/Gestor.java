package controlador;

import java.util.ArrayList;

import modelo.Libros;
import modelo.Periodicos;
import modelo.Publicacion;

public class Gestor {

	private ArrayList<Publicacion> nuevaPublic = null;
	private ValidacionDatos validacionDatos = null;
	private double importeLibros=0;
	private double importePeriodicos=0;
	private double importePublicaciones=0;

	public Gestor() {
		nuevaPublic = new ArrayList<Publicacion>();
		validacionDatos = new ValidacionDatos();
	
	}

	public void insertarNuevo() {

		String opcion="";

		opcion = validacionDatos.leerCaracter("Elige el tipo de publicacion que vas a crear \n\t 1.- Periodico(P) \n\t 2.- Libro(L) ");

		Publicacion publicacion = insertar(opcion);

		nuevaPublic.add(publicacion);


	}

	public void verPublicaciones() {
		for(int i=0; i< nuevaPublic.size(); i++) {
			System.out.println(nuevaPublic.get(i));
		}
	}

	public String venta() {
		String opcionElegida="";

		String opcion = validacionDatos.leerCaracter("¿Que deseas comprar? \n\t 1.- Periodico(P) \n\t 2.- Libro(L)");

		if(opcion.equalsIgnoreCase("P")) {
			opcionElegida = validacionDatos.leerString("Introduce el nombre del periodico que deseas compar: ");
		}else {
			opcionElegida = validacionDatos.leerString("Introduce el titulo del libro que deseas compar: ");
		}	

		int unidadesC = validacionDatos.leerEntero("¿Cuantas unidades del pedido deseas? ");

		int indice = comprobarInstancia(opcionElegida);

		String resultado = ((Publicacion) nuevaPublic.get(indice)).venderCantidad(unidadesC);
		
		if(opcion.equalsIgnoreCase("P")) {
			importePeriodicos = importePeriodicos + ((Publicacion) nuevaPublic.get(indice)).getPrecio() * unidadesC;
		}else {
			importeLibros = importeLibros + ((Publicacion) nuevaPublic.get(indice)).getPrecio() * unidadesC;
		}

		importePublicaciones = importeLibros + importePeriodicos;
		
		
		return resultado;
	}

	public String recepcion() {
		String opcionElegida="";

		String opcion = validacionDatos.leerCaracter("¿Que es lo que desea actualizar? \n\t 1.- Periodico(P) \n\t 2.- Libro(L)");

		if(opcion.equalsIgnoreCase("P")) {
			opcionElegida = validacionDatos.leerString("Introduce el nombre del periodico que deseas actualizar: ");
		}else {
			opcionElegida = validacionDatos.leerString("Introduce el titulo del libro que deseas actualizar: ");
		}	

		int unidadesP = validacionDatos.leerEntero("¿Cuantas unidades del pedido deseas actualizar? ");

		int indice = comprobarInstancia(opcionElegida);

		String resultado = ((Publicacion) nuevaPublic.get(indice)).aumentarNumUnidades(unidadesP);

		return resultado;

	}

	private int comprobarInstancia(String opcionElegida) {
		for(int i=0; i< nuevaPublic.size(); i++) {
			if(nuevaPublic.get(i) instanceof Libros) {
				if(((Libros) nuevaPublic.get(i)).getTitulo().equals(opcionElegida)) {
					return i;
				}
			}else if(nuevaPublic.get(i) instanceof Periodicos) {
				if(((Periodicos) nuevaPublic.get(i)).getNombre().equals(opcionElegida)) {
					return i;
				}
			}
		}
		return 0;
	}

	private Publicacion insertar(String opcion) {

		Publicacion publicacion = null;

		double precio = validacionDatos.leerDouble("Introduce el precio: ");
		int unidades = validacionDatos.leerEntero("Introduce el numero de unidades disponibles: ");

		if(opcion.equalsIgnoreCase("L")) {

			String titulo = validacionDatos.leerString("Introduce el titulo del libro: ");
			String autor = validacionDatos.leerString("Introduce el nombre del autor: ");
			String editorial = validacionDatos.leerString("Introduce la editorial: ");

			publicacion = new Libros(precio, unidades, titulo, autor, editorial);

		}else {

			String nombre = validacionDatos.leerString("Introduce el nombre del periodico: ");
			String fecha = validacionDatos.leerString("Introduce la fecha de publicacion (dd/mm/aa): ");

			publicacion = new Periodicos(precio, unidades, nombre, fecha);
		}

		return publicacion;
	}

	public void generarFacturacion() {
		
		System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
		System.out.println("									 |\n"
				+ "				FACTURA					 |");
		System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _|"
				+ "\n									 |");
		System.out.println("Detalles de la compra				 			 |"
				+ "\n									 |");
		System.out.println("Importe de lo libros vendidos:	" + importeLibros + "					 |");
		System.out.println("Importe de los periodicos vendidos:		" + importePeriodicos + "			 |");
		System.out.println("Importe de las publicaciones vendidas:		" + importePublicaciones + "		 	 |");
		System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _|");
	}

}