package vista;

import java.util.ArrayList;

import controlador.Menu;
import controlador.ValidacionDatos;
import modelo.Fecha;
import modelo.Gato;
import modelo.Mascota;
import modelo.Perro;

public class Mascotas {

	public static void main(String[] args) {

		Menu menu = new Menu();
		String fin = menu.gestorMenu();
		System.out.println(fin);

	}

	public Mascota pedirDatosMascota() {

		ValidacionDatos validacion = new ValidacionDatos();
		Mascota mascota = null;

		String opcion = validacion.leerCaracter("�Que tipo de mascota deseas insertar? \n1.- Perro(P) \n2.- Gato(G)");
		String nombre = validacion.leerString("Introduce el nombre de tu mascota: ");
		Fecha fecha = pedirFachaNaMascota();
		String dni = validacion.validarDni("Introduce tu DNI: ");

		if(opcion.equalsIgnoreCase("P")) {
			String raza = validacion.leerString("Introduce la raza de tu perro: ");
			boolean pulgas = validacion.validarBoolean("�Tu perro tiene pulgas S o N? ");
			mascota = new Perro(nombre, fecha, dni, raza, pulgas);

		}else {
			char pelo = validacion.validarCaracter("�El pelo del gato es Largo(L), Corto(C) o Mediano(M)? ");
			String color = validacion.leerString("Introduce el color del pelo del gato: ");
			mascota = new Gato(nombre, fecha, dni, pelo, color);
		}
		return mascota;
	}

	private Fecha pedirFachaNaMascota() {
		Fecha fecha = null;
		ValidacionDatos validacion = new ValidacionDatos();

		int dia = validacion.leerEntero("Introduce el dia de nacimiento de tu mascota: ");
		int mes = validacion.leerEntero("Introduce el mes de nacimiento de tu mascota: ");
		int ano = validacion.leerEntero("Introduce el a�o de nacimiento de tu mascota");

		fecha = new Fecha(ano, mes, dia);

		return fecha;
	}

	public int pedirId() {
		ValidacionDatos validacion = new ValidacionDatos();
		int id = validacion.leerEntero("Introduce el id de la mascota: ");
		return id;
	}

	public String pedirDni() {
		ValidacionDatos validacion = new ValidacionDatos();
		String dni = validacion.validarDni("Introduce tu DNI: ");

		return dni;
	}

	public void imprimirMascotas(ArrayList<Mascota> totMascotas){
		for(int i=0; i<totMascotas.size(); i++) {
			System.out.println(totMascotas.get(i));
		}
	}

	public void imprimirCadena(String cadena) {
		System.out.println(cadena);
	}

	public Object pedirDtosModificar(int opcion) {
		ValidacionDatos validacion = new ValidacionDatos();

		if(opcion == 1) {
			String nombreNuevo = validacion.leerString("Introduce el nuevo nombre de tu mascota: ");
			return nombreNuevo;
		}else if(opcion == 2) {
			Fecha fecha = pedirFachaNaMascota();
			return fecha;
		}else if(opcion == 3){
			int edad = validacion.leerEntero("Introduce la nueva edad de tu mascota: ");
			return edad;
		}
		return 0;
	}

	public int escogerQueModificar() {
		ValidacionDatos validacion = new ValidacionDatos();
		int opcion = validacion.leerRangoEntero("�Que desea modificar? \n1.- Nombre \n2.- Fecha de nacimiento");
		return opcion;
	}

}
