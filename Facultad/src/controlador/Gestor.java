package controlador;

import java.time.Year;
import java.util.ArrayList;

import modelo.Empleados;
import modelo.Estudiantes;
import modelo.Persona;
import modelo.PersonalServicio;
import modelo.Profesores;

public class Gestor {

	private static ArrayList<Persona> personas = null;
	private ValidacionDtos validacion = null;

	public Gestor() {
		personas = new ArrayList<Persona>();
		validacion = new ValidacionDtos();
	}

	public void darAlta() {

		Persona persona = pedirDatosPersona();
		personas.add(persona);

	}

	private Persona pedirDatosPersona() {
		Persona persona = null;

		String nombre = validacion.leerString("Introduce tu nombre: ");
		String apellidos = validacion.leerString("Introduce tus apellidos: ");
		String dni = validacion.validarDni("Introduce tu DNI");
		boolean estadoCivil = validacion.validarEstadoCivilBoolean("¿Eres casado Si(S) o No(N)?");

		String tipoPersona = validacion.validarTipoPersona("¿Eres empleado(E) o alumno(A)?");

		if(tipoPersona.equalsIgnoreCase("E")) {
			Year fecha = validacion.validarAno("Introduzca el año de incorporacion en el formato (yyyy)");
			int nDespacho = validacion.leerEntero("Introduzca su numero de despacho: ");
			String tipoEmpleado = validacion.validarTipoEmpleado("¿Eres uno profesor(P) o parte del personal de limpieza(L)?");

			if(tipoEmpleado.equalsIgnoreCase("P")) {
				String departamento = validacion.leerString("Introduzca el nombre del departamento al que pertenece: ");
				persona= new Profesores(nombre, apellidos, dni, estadoCivil, fecha, nDespacho, departamento);
			}else {
				String seccion = validacion.leerString("Introduzca la seccion en la que esta asignado: ");
				persona = new PersonalServicio(nombre, apellidos, dni, estadoCivil, fecha, nDespacho, seccion);
			}

		}else {
			int curso = validacion.leerEntero("Introduzca el curso en el que se encuentra");
			persona = new Estudiantes(nombre, apellidos, dni, estadoCivil, curso);
		}

		return persona;
	}

	public void modificarDatos() {
		int idPersona = validacion.leerEntero("Introduce el id del usuario: ");
		int indice = verificarInstancia(idPersona);
		int eleccion = eleccionModificar(idPersona, indice);

		switch (eleccion) {
		case 1:

			boolean cambioEstado = validacion.validarEstadoCivilBoolean("¿Eres casado Si(S) o No(N)?");
			((Persona) personas.get(indice)).cambiarEstadoCivil(cambioEstado);

			break;

		case 2:
			if(personas.get(indice) instanceof Estudiantes) {
				int nuevoCurso = validacion.leerEntero("Introduce el nuevo curso al que se matriculara el/la estudiante " + personas.get(indice) + ": ");
				((Estudiantes) personas.get(indice)).matricularNuevoCurso(nuevoCurso);

			}else {
				int nDespacho = validacion.leerEntero("Introduce el nuevo numero de despacho del empleado " + personas.get(indice).getNombre() + ": ");
				((Empleados) personas.get(indice)).reasignarDespacho(nDespacho);

			}
			break;

		case 3:
			String depart = validacion.leerString("Introduce el nombre del nuevo departamento para " + personas.get(indice).getNombre() + ": ");
			boolean compExistencia = comprobarDepartamento(depart);
			if(compExistencia == true) {
				((Profesores) personas.get(indice)).cambiarDepartamento(depart);
			}else {
				System.out.println("El departamento introducido no existe.");
			}
			break;

		}

	}

	private boolean comprobarDepartamento(String depart) {
		for(int i = 0; i < personas.size(); i++) {
			if(((Profesores) personas.get(i)).getDepartamento().equalsIgnoreCase(depart)) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}

	private int eleccionModificar(int id, int indice) {
		int opcion = 0;

		do {
			System.out.println("1.- Desea modificar el estado civil de la persona");

			if(personas.get(indice) instanceof Estudiantes) {
				System.out.println("2.- Matriculacion en un nuevo curso: ");
			}else{
				System.out.println("2.- Reasignacion de despacho: ");
				if(personas.get(indice) instanceof Profesores) {
					System.out.println("3.- Cambiar de departamento: ");
				}
			}
			opcion = validacion.leerEntero("Elige una de las opciones");

		}while(opcion < 1 || opcion > 3);

		return opcion;
	}

	private int verificarInstancia(int id) {
		for(int i=0; i< personas.size(); i++) {
			if(personas.get(i) instanceof Estudiantes) {
				if(((Estudiantes) personas.get(i)).getId() == id) {
					return i;
				}
			}else {
				if(personas.get(i) instanceof Profesores) {
					if(((Profesores) personas.get(i)).getId() == id) {
						return i;
					}
				}
				else if(personas.get(i) instanceof PersonalServicio) {
					if(((PersonalServicio) personas.get(i)).getId() == id) {
						return i;
					}
				}
			}

		}
		return 0;
	}

	public void darBaja() {
		int idPersona = validacion.leerEntero("Introduce el id del usuario: ");

		int indice = verificarInstancia(idPersona);

		personas.remove(indice);

	}

	public void imprimir() {
		for(int i = 0; i < personas.size(); i++) {
            System.out.println(personas.get(i).toString());
        }	}
}