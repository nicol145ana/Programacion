package controlador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ValidacionDatos {

	private Scanner teclado = null;

	public ValidacionDatos() {
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

	public String leerCaracter(String cadena) {
		String caracter = "";
		boolean control=false;

		do {
			System.out.println(cadena);
			caracter = teclado.next();
			if(caracter.equalsIgnoreCase("P")|| caracter.equalsIgnoreCase("L")) {
				control = true;
			}else {
				control = false;
			}
		}while(control == false);

		return caracter;
	}

	public LocalDate validarFecha(String cadena) {
		LocalDate fecha = null;
		boolean control = false;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 		
		
		do {
			System.out.println(cadena);
			String fech = teclado.nextLine(); 
			try {
				fecha = LocalDate.parse(fech);
				if(formatter.format(fecha).equals(fech)) {
					control = true;
				}else {
					System.out.println("Formato incorrecto.");
					control = false;
				}
			}catch(DateTimeParseException e) {
				System.out.println("Error el formato es incorrecto.");
				control = false;
			}
			
		}while(control == false);
		
		return fecha;
	}
	
	public LocalTime validarHora(String cadena) {
		LocalTime fecha = null;
		boolean control = false;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm"); 		
		
		do {
			System.out.println(cadena);
			String fech = teclado.nextLine(); 
			try {
				fecha = LocalTime.parse(fech);
				if(formatter.format(fecha).equals(fech)) {
					control = true;
				}else {
					System.out.println("Formato incorrecto.");
					control = false;
				}
			}catch(DateTimeParseException e) {
				System.out.println("Error el formato es incorrecto.");
				control = false;
			}
			
		}while(control == false);
		
		return fecha;
	}
	
	public LocalDateTime validarFechaHora(String cadena) {
		LocalDateTime fechaHora = null;
		boolean control = false;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 

		do {
			System.out.println(cadena);
			String fechHor = teclado.nextLine();
			try {
				fechaHora = LocalDateTime.parse(fechHor, formatter);
				if(formatter.format(fechaHora).equals(fechHor)) {
					control = true;
				}
			}catch (DateTimeParseException e) {
				System.out.println("El formato introducido no es correcto.");
				control = false;
			}

		}while(control == false);

		return fechaHora;
	}
}