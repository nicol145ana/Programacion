package controlador;

import java.util.ArrayList;
import java.util.Arrays;

import modelo.Fecha;
import modelo.Gato;
import modelo.Mascota;
import modelo.Perro;

public class Gestor {

	private ArrayList<Mascota> mascotas = null; 
	private ValidacionDatos validacion = null;

	public Gestor() {
		Perro p1 = new Perro("Lur", 2, new Fecha(6,9,2018), "12345679K", "Pastor aleman", false);
		Perro p2 = new Perro("Beethoven", 3, new Fecha(1,2,2018), "56478936G", "San bernardo", true);
		Perro p3 = new Perro("Pongo", 4, new Fecha(25,5,2016), "78965847F", "Dalmata", false);
		Gato g1 = new Gato("Baltzi", 10, new Fecha(1,6,2009), "12345679K", 'L', "Negro");
		Gato g2 = new Gato("Bola", 4, new Fecha(31,1,2015), "14785469S", 'C', "Tricolor (calicó)");
		Gato g3 = new Gato("Garfield", 6, new Fecha(31,7,2012), "12345679K", 'M', "Naranja");

		mascotas = new ArrayList<>(Arrays.asList(p1, g1, p2, p3, g2, g3));

		validacion = new ValidacionDatos();
	}

	public String anadirMascota() {

		String opcion = "";

		opcion = validacion.leerCaracter("¿Que tipo de mascota deseas insertar? \n1.- Perro(P) \n2.- Gato(G)");

		Mascota mascota = insertar(opcion);

		mascotas.add(mascota);

		return "Su mascota se ha introducido con exito.";

	}
	
	private Mascota insertar(String opcion) {
		Mascota mascota = null;

		String nombre = validacion.leerString("Introduce el nombre de tu mascota: ");

		int edad = validacion.leerEntero("Introduce la edad que tiene tu mascota: ");

		Fecha fecha = introducirFecha();

		String dni = validacion.validarDni("Introduce tu DNI: ");

		if(opcion.equalsIgnoreCase("P")) {

			String raza = validacion.leerString("Introduce la raza de tu perro: ");
			boolean pulgas = validacion.validarBoolean("¿Tu perro tiene pulgas S o N? ");

			mascota = new Perro(nombre, edad, fecha, dni, raza, pulgas);

		}else {
			char pelo = validacion.validarCaracter("¿El pelo del gato es Largo(L), Corto(C) o Mediano(M)? ");
			String color = validacion.leerString("Introduce el color del pelo del gato: ");

			mascota = new Gato(nombre, edad, fecha, dni, pelo, color);

		}

		return mascota;

	}

	private Fecha introducirFecha() {
		Fecha fecha = null;

		int dia = validacion.leerEntero("Introduce el dia de nacimiento de tu mascota: ");
		int mes = validacion.leerEntero("Introduce el mes de nacimiento de tu mascota: ");
		int ano = validacion.leerEntero("Introduce el año de nacimiento de tu mascota");

		fecha = new Fecha(ano, mes, dia);

		return fecha;

	}

	public void mostrarDatos() {

		for(int i=0; i < mascotas.size(); i++) {
			System.out.println(mascotas.get(i));
		}
	}

	public void modificarMascota() {

		int id = validacion.leerEntero("Introduce el id de la mascota: ");

		int indice = comprobarInstancia(id);

		if(indice == -2) {
			System.out.println("No existe una mascota con ese numero de identificacion.");

		}else {
			int opcion = validacion.leerRangoEntero("¿Que desea modificar? \n1.- Nombre \n2.- Fecha de nacimiento \n3.- Edad");

			if(opcion == 1) {
				String nombreNuevo = validacion.leerString("Introduce el nuevo nombre de tu mascota: ");
				((Mascota) mascotas.get(indice)).setNombre(nombreNuevo);
			}else if(opcion == 2) {
				Fecha fecha = introducirFecha();
				((Mascota) mascotas.get(indice)).setFecha(fecha);
			}else if(opcion == 3){
				int edad = validacion.leerEntero("Introduce la nueva edad de tu mascota: ");
				((Mascota) mascotas.get(indice)).setEdad(edad);
			}

			System.out.println("Los datos de su mascota se ha actualizado con exito.");

		}

	}

	private int comprobarInstancia(int id) {
		for(int i=0; i< mascotas.size(); i++) {
			if(mascotas.get(i) instanceof Perro) {
				if(((Perro) mascotas.get(i)).getId() == id) {
					return i;
				}
			}else if(mascotas.get(i) instanceof Gato) {
				if(((Gato) mascotas.get(i)).getId() == id) {
					return i;
				}
			}
		}
		return -2;
	}

	public void eliminarMascota() {
		int id = validacion.leerEntero("Introduce el id de la mascota: ");

		int indice = comprobarInstancia(id);

		if(indice == -2) {
			System.out.println( "No existe una mascota con ese numero de identificacion.");

		}else {
			mascotas.remove(indice);
			System.out.println("Su mascota se ha eliminado con exito.");
		}

	}

	public void eliminarMascotaPorDueno() {

		String dni = validacion.validarDni("Introduce tu DNI: ");

		for(int i=0; i < mascotas.size(); i++) {
			if(mascotas.get(i).getDniDueno().equals(dni)) {
				mascotas.remove(i);
				i--;
			}
		}
		System.out.println("Las mascotas relacionadas con el DNI:" + dni + " se han eliminado."); 

	}

	public void buscarMascotasporDueno() {
		String dni = validacion.validarDni("Introduce tu DNI: ");

		for(int i=0; i < mascotas.size(); i++) {
			if(mascotas.get(i).getDniDueno().equals(dni)) {
				System.out.println(mascotas.get(i));
			}
		}
	}

}
