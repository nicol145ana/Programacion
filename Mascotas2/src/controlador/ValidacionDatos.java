package controlador;

import java.util.Scanner;

public class ValidacionDatos {
	
	private Scanner teclado = null;
	
	public ValidacionDatos() {
		teclado = new Scanner (System.in);
	}

	public int leerEntero(String cadena) {
		int eleccion=0;
		boolean control = false;

		do {
			System.out.println(cadena);
			try {
				eleccion = teclado.nextInt();
				control = true;
			}catch (Exception e) {
				teclado.nextLine();
				control = false;
			}
		}while(control == false);

		return eleccion;
	}
	
	public int leerRangoEntero(String cadena) {
		int eleccion=0;
		boolean control = false;

		do {
			System.out.println(cadena);
			try {
				eleccion = teclado.nextInt();
				control = true;
			}catch (Exception e) {
				teclado.nextLine();
				control = false;
			}
		}while(control == false || eleccion <= 0 || eleccion > 3);

		return eleccion;
	}
	
	public String leerCaracter(String cadena) {
		String caracter = "";
		boolean control=false;

		do {
			System.out.println(cadena);
			caracter = teclado.next();
			if(caracter.equalsIgnoreCase("P")|| caracter.equalsIgnoreCase("G")) {
				control = true;
			}else {
				control = false;
			}
		}while(control == false);

		return caracter;
	}
	
	public boolean validarBoolean(String cadena) {
		String caracter = "";
		boolean control=false;
		boolean bool= false;

		do {
			System.out.println(cadena);
			caracter = teclado.next();
			if(caracter.equalsIgnoreCase("S")) {
				bool = true;
				control = true;
			}else if(caracter.equalsIgnoreCase("N")) {
				bool = false;
				control = true;
			}
			else {
				System.out.println("Error solo puedes introducir Si o No");
				control = false;
			}
		}while(control == false);

		return bool;
	}

	public String leerString(String cadena) {
		String cad = "";
		boolean control=false;

		do {
			System.out.println(cadena);
			try {
				cad = teclado.next();
				control = true;
			}catch(Exception e) {
				teclado.nextLine();
				control = false;
			}
		}while(control == false);

		return cad;
	}
	
	public String validarDni(String cadena) {
		String dni="";
		boolean dniCorrecto = false;
		do {
			System.out.println(cadena);
			dni = teclado.next();
			dniCorrecto = dni.matches("^[0-9]{8}[A-Z a-z]$");
			if(dniCorrecto == false) {
				System.out.println("El DNI introducido no es valido ");
			}
		}while(dniCorrecto == false);

		return dni;
	}

	public char validarCaracter(String cadena) {
		String caracter;
		boolean control=false;
		char caracterElegido = 0;
		
		do {
			System.out.println(cadena);
			try {
				caracter = teclado.next();
				if(caracter.equalsIgnoreCase("L") || caracter.equalsIgnoreCase("M") || caracter.equalsIgnoreCase("C")) {
					control = true;
					caracterElegido = caracter.charAt(0);
				}
				else {
					control = false;
					System.out.println("Debes introducir un caracter L, M o C");
				}
			}catch (Exception e) {
				System.out.println("Caracter incorrecto.");
				control = false;
			}
		}while(control == false);		
		
		return caracterElegido;
	}

}
