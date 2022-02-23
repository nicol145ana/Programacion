package controlador;

import java.util.Scanner;

public class Menu {

	private Scanner teclado = null;
	private Gestor gestor = null;

	public Menu() {
		teclado = new Scanner (System.in);
		gestor = new Gestor();

	}

	public void gestorMenu() {
		int opcion;

		do {
			opcion = opcionMenu();
			if(opcion !=5) {
				ejecutarOpcion(opcion);
			}

		}while(opcion > 0 || opcion < 5);

		System.out.println("Fin del programa...");

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

		}while(op <= 0 || op > 5);

		return op;
	}

	private void escribirMenu() {

		System.out.println("	1.- Darse de alta");
		System.out.println("	2.- Imprimir datos");
		System.out.println("	3.- Darse de baja");
		System.out.println("	4.- Imprimir nominas");
		System.out.println("	5.- Salir");
	}

	private void ejecutarOpcion(int opcion) {

		switch (opcion) {
		case 1: 
			gestor.darAlta();
			break;
		case 2:
			gestor.imprimirDatos();
			break;
		case 3:
			gestor.darBaja();
			break;
		case 4:
			gestor.imprimirNominas();
			break;
		}
	}

}