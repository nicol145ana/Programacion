package controlador;

import java.util.Scanner;

public class Menu {

	private Scanner teclado = null;
	private Gestor gestor = null;

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

		switch (opcion) {
		case 1: 
			gestor.andirMascota();
			break;
		case 2:
			gestor.mostrarDatos();
			break;
		case 3:
			gestor.modificarMascota();
			break;
		case 4:
			gestor.eliminarMascota();
			break;
		case 5:
			gestor.eliminarMascotaPorDueno();
			break;
		case 6:
			gestor.buscarMascotasporDueno();
			break;
		}
	}

}