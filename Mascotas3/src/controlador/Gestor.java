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
		Perro p1 = new Perro("Lur", new Fecha(6,9,2018), "12345679K", "Pastor aleman", false);
		Perro p2 = new Perro("Beethoven", new Fecha(1,2,2018), "56478936G", "San bernardo", true);
		Perro p3 = new Perro("Pongo", new Fecha(25,5,2016), "78965847F", "Dalmata", false);
		Gato g1 = new Gato("Baltzi", new Fecha(1,6,2009), "12345679K", 'L', "Negro");
		Gato g2 = new Gato("Bola", new Fecha(31,1,2015), "14785469S", 'C', "Tricolor (calicó)");
		Gato g3 = new Gato("Garfield", new Fecha(31,7,2012), "12345679K", 'M', "Naranja");

		mascotas = new ArrayList<>(Arrays.asList(p1, g1, p2, p3, g2, g3));

		validacion = new ValidacionDatos();
	}

	public String andirMascota() {

		String opcion = "";
		
		opcion = validacion.leerCaracter("¿Que tipo de mascota deseas insertar? \n1.- Perro(P) \n2.- Gato(G)");
		
		Mascota mascota = insertar(opcion);
		
		mascotas.add(mascota);

		return "Su mascota se ha introducido con exito.";

	}

	private Mascota insertar(String opcion) {
		Mascota mascota = null;

		String nombre = validacion.leerString("Introduce el nombre de tu mascota: ");

		Fecha fecha = introducirFecha();

		String dni = validacion.validarDni("Introduce tu DNI: ");

		if(opcion.equalsIgnoreCase("P")) {

			String raza = validacion.leerString("Introduce la raza de tu perro: ");
			boolean pulgas = validacion.validarBoolean("¿Tu perro tiene pulgas S o N? ");

			mascota = new Perro(nombre, fecha, dni, raza, pulgas);

		}else {
			char pelo = validacion.validarCaracter("¿El pelo del gato es Largo(L), Corto(C) o Mediano(M)? ");
			String color = validacion.leerString("Introduce el color del pelo del gato: ");

			mascota = new Gato(nombre, fecha, dni, pelo, color);

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

	public ArrayList<Mascota> mostrarDatos() {
				
		ArrayList<Mascota> totMascotas = new ArrayList<Mascota>();

		for(int i=0; i < mascotas.size(); i++) {
			totMascotas.add(mascotas.get(i));
		}

		return totMascotas;
	}

	public String modificarMascota() {

		int id = validacion.leerEntero("Introduce el id de la mascota: ");

		int indice = comprobarInstancia(id);

		if(indice == -2) {
			return "No existe una mascota con ese numero de identificacion.";

		}else {
			int opcion = validacion.leerRangoEntero("¿Que desea modificar? \n1.- Nombre \n2.- Fecha de nacimiento");

			if(opcion == 1) {
				String nombreNuevo = validacion.leerString("Introduce el nuevo nombre de tu mascota: ");
				((Mascota) mascotas.get(indice)).setNombre(nombreNuevo);
			}else if(opcion == 2) {
				Fecha fecha = introducirFecha();
				((Mascota) mascotas.get(indice)).setFecha(fecha);
			}

			return "Los datos de su mascota se ha actualizado con exito.";

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

	public String eliminarMascota() {
		int id = validacion.leerEntero("Introduce el id de la mascota: ");

		int indice = comprobarInstancia(id);

		if(indice == -2) {
			return "No existe una mascota con ese numero de identificacion.";

		}else {
			mascotas.remove(indice);
			return "Su mascota se ha eliminado con exito.";
		}

	}

	public String eliminarMascotaPorDueno() {

		String dni = validacion.validarDni("Introduce tu DNI: ");

		for(int i=0; i < mascotas.size(); i++) {
			if(mascotas.get(i).getDniDueno().equals(dni)) {
				mascotas.remove(i);
				i--;
			}
		}
		return "Las mascotas relacionadas con el DNI:" + dni + " se han eliminado.";

	}

	public ArrayList<Mascota> buscarMascotasporDueno() {
		ArrayList<Mascota> mascotasDueno = new ArrayList<Mascota>();
		String dni = validacion.validarDni("Introduce tu DNI: ");

		for(int i=0; i < mascotas.size(); i++) {
			if(mascotas.get(i).getDniDueno().equals(dni)) {
				mascotasDueno.add(mascotas.get(i));
			}
		}
		return mascotasDueno;
	}

}
