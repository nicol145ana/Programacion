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
			if(opcion !=6) {
				ejecutarOpcion(opcion);
			}

		}while(opcion > 0 || opcion < 6);
		
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

		}while(op <= 0 || op > 6);

		return op;
	}

	private void escribirMenu() {

		System.out.println("	1.- Nuevo");
		System.out.println("	2.- Ver todas las publicaciones");
		System.out.println("	3.- Venta de periodico o libro");
		System.out.println("	4.- Recepcion del pedido");
		System.out.println("	5.- Facturacion de libros y periodicos");
		System.out.println("	6.- Salir");
	}

	private void ejecutarOpcion(int opcion) {
		String resultado;
		
		switch (opcion) {
		case 1: 
			gestor.insertarNuevo();
			break;
		case 2:
			gestor.verPublicaciones();
			break;
		case 3:
			resultado = gestor.venta();
			System.out.println(resultado);
			break;
		case 4:
			resultado = gestor.recepcion();
			System.out.println(resultado);
			break;
		case 5:
			gestor.generarFacturacion();
			break;
		}

	}

}