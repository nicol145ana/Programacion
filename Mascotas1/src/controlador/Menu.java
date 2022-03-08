package controlador;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Mascota;
import vista.Mascotas;

public class Menu {

	private Scanner teclado = null;
	private Gestor gestor = null;
	private Mascotas mascotas = new Mascotas();

	public Menu() {
		teclado = new Scanner (System.in);
		gestor = new Gestor();

	}

	public String gestorMenu() {
		int opcion;

		do {
			opcion = opcionMenu();
			if(opcion !=7) {
				ejecutarOpcion(opcion);
			}

		}while(opcion > 0 && opcion < 7);

		return "Fin del programa...";

	}

	private int opcionMenu() {
		int op=0;

		do {

			System.out.print("\nSeleccione una opcion: \n");
			escribirMenu();

			try {
				op = teclado.nextInt();
			} catch (Exception e) {
				teclado.nextLine();
				op = -2;
			}

		}while(op <= 0 || op > 7);

		return op;
	}

	private void escribirMenu() {

		System.out.println("	1.- Anadir mascota");
		System.out.println("	2.- Mostrar datos");
		System.out.println("	3.- Modificar mascota");
		System.out.println("	4.- Eliminar mascota");
		System.out.println("	5.- Eliminar mascota por el DNI del dueno");
		System.out.println("	6.- Buscar mascota por nombre");
		System.out.println("	7.- Salir");
	}

	private void ejecutarOpcion(int opcion) {
		String dni;	
		String resultado;
		int id;
		
		switch (opcion) {
		case 1: 
			Mascota mascota = mascotas.pedirDatosMascota();
			resultado = gestor.anadirMascota(mascota);
			mascotas.imprimirCadena(resultado);
			break;
		case 2:
			ArrayList<Mascota> totMascotas = gestor.mostrarDatos();
			mascotas.imprimirMascotas(totMascotas);
			break;
		case 3:
			id = mascotas.pedirId();
			int op = mascotas.pedirQueModificar();
			resultado = gestor.modificarMascota(id, op, mascotas.pedirFachaNaMascota());
			mascotas.imprimirCadena(resultado);
			break;
		case 4:
			id = mascotas.pedirId();
			resultado = gestor.eliminarMascota(id);
			mascotas.imprimirCadena(resultado);
			break;
		case 5:
			dni = mascotas.pedirDni();
			resultado = gestor.eliminarMascotaPorDueno(dni);
			mascotas.imprimirCadena(resultado);
			break;
		case 6:
			dni = mascotas.pedirDni();
			ArrayList<Mascota> totMascotasDueno = gestor.buscarMascotasporDueno(dni);
			mascotas.imprimirMascotas(totMascotasDueno);
			break;
		}
	}

}