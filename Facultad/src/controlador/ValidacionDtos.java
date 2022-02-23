package controlador;

import java.time.Year;
import java.util.Scanner;

public class ValidacionDtos {

	private Scanner teclado = null;

	public ValidacionDtos() {
		teclado = new Scanner(System.in);
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

	public double leerDouble(String cadena) {
		double eleccion=0;
		boolean control = false;

		do {
			System.out.println(cadena);
			try {
				eleccion = teclado.nextDouble();
				control = true;
			}catch (Exception e) {
				teclado.nextLine();
				control = false;
			}
		}while(control == false);

		return eleccion;
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

	public String validarEstadoCivil(String cadena) {
		String caracter = "";
		boolean control=false;

		do {
			System.out.println(cadena);
			caracter = teclado.next();
			if(caracter.equalsIgnoreCase("C")) {
				caracter = "Casado";
				control = true;
			}else if(caracter.equalsIgnoreCase("S")) {
				caracter = "Soltero";
				control = true;
			}else if(caracter.equalsIgnoreCase("V")) {
				caracter = "Viudo";
				control = true;
			}
			else {
				System.out.println("Error solo puedes introducir soltero(S), casado(C) o viudo(V)");
				control = false;
			}
		}while(control == false);

		return caracter;
	}
	
	public boolean validarEstadoCivilBoolean(String cadena) {
		String caracter = "";
		boolean control=false;
		boolean estadoCivil= false;

		do {
			System.out.println(cadena);
			caracter = teclado.next();
			if(caracter.equalsIgnoreCase("S")) {
				estadoCivil = true;
				control = true;
			}else if(caracter.equalsIgnoreCase("N")) {
				estadoCivil = false;
				control = true;
			}
			else {
				System.out.println("Error solo puedes introducir Si o No");
				control = false;
			}
		}while(control == false);

		return estadoCivil;
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

	public String validarTipoPersona(String cadena) {
		String caracter = "";
		boolean control=false;

		do {
			System.out.println(cadena);
			caracter = teclado.next();
			if(caracter.equalsIgnoreCase("E")|| caracter.equalsIgnoreCase("A")) {
				control = true;
			}else {
				System.out.println("Error solo puedes introducir empleado(E) o alumno(A)");
				control = false;
			}
		}while(control == false);

		return caracter;
	}

	public Year validarAno(String cadena) {
		String anoIncorporacion="";
		boolean anoCorrecto = false;
		do {
			System.out.println(cadena);
			anoIncorporacion = teclado.next();
			anoCorrecto = anoIncorporacion.matches("^(17|18|19|20)[0-9]{2}$");

			if(anoCorrecto == false) {
				System.out.println("El año introducido no es valido ");
			}
		}while(anoCorrecto == false);

		Year anoIncorp = Year.parse(anoIncorporacion);
		
		return anoIncorp;

	}

	public String validarTipoEmpleado(String cadena) {
		String caracter = "";
		boolean control=false;

		do {
			System.out.println(cadena);
			caracter = teclado.next();
			if(caracter.equalsIgnoreCase("P")|| caracter.equalsIgnoreCase("L")) {
				control = true;
			}else {
				System.out.println("Error solo puedes introducir profesor(P) o personal de limpieza(L)");
				control = false;
			}
		}while(control == false);

		return caracter;
	}

}