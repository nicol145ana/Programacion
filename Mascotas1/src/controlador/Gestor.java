package controlador;

import java.util.ArrayList;
import java.util.Arrays;

import modelo.Fecha;
import modelo.Gato;
import modelo.Mascota;
import modelo.Perro;

public class Gestor {

	private ArrayList<Mascota> mascotas = null; 

	public Gestor() {
		Perro p1 = new Perro("Lur", 2, new Fecha(6,9,2018), "12345679K", "Pastor aleman", false);
		Perro p2 = new Perro("Beethoven", 3, new Fecha(1,2,2018), "56478936G", "San bernardo", true);
		Perro p3 = new Perro("Pongo", 4, new Fecha(25,5,2016), "78965847F", "Dalmata", false);
		Gato g1 = new Gato("Baltzi", 10, new Fecha(1,6,2009), "12345679K", 'L', "Negro");
		Gato g2 = new Gato("Bola", 4, new Fecha(31,1,2015), "14785469S", 'C', "Tricolor (calicó)");
		Gato g3 = new Gato("Garfield", 6, new Fecha(31,7,2012), "12345679K", 'M', "Naranja");

		mascotas = new ArrayList<>(Arrays.asList(p1, g1, p2, p3, g2, g3));

	}

	public String anadirMascota(Mascota mascota) {

		mascotas.add(mascota);

		return "Su mascota se ha introducido con exito.";

	}

	public ArrayList<Mascota> mostrarDatos() {
		ArrayList<Mascota> totMascotas = new ArrayList<Mascota>();
		for(int i=0; i < mascotas.size(); i++) {
			totMascotas.add(mascotas.get(i));
		}
		
		return totMascotas;
	}

	public String modificarMascota(int id, Object objeto, int opcion) {
		
		int indice = comprobarInstancia(id);
		if(indice == -2) {
			return "No existe una mascota con ese numero de identificacion.";
		}else {
			if(opcion == 1) {
				String nombreNuevo = (String) objeto;
				((Mascota) mascotas.get(indice)).setNombre(nombreNuevo);
			}else if(opcion == 2) {
				Fecha fecha = (Fecha) objeto;
				((Mascota) mascotas.get(indice)).setFecha(fecha);
			}else if(opcion == 3){
				int edad = (int) objeto;
				((Mascota) mascotas.get(indice)).setEdad(edad);
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

	public String eliminarMascota(int id) {
		int indice = comprobarInstancia(id);

		if(indice == -2) {
			return "No existe una mascota con ese numero de identificacion.";

		}else {
			mascotas.remove(indice);
			return "Su mascota se ha eliminado con exito.";
		}
	}

	public String eliminarMascotaPorDueno(String dni) {
		for(int i=0; i < mascotas.size(); i++) {
			if(mascotas.get(i).getDniDueno().equals(dni)) {
				mascotas.remove(i);
				i--;
			}
		}
		return "Las mascotas relacionadas con el DNI:" + dni + " se han eliminado."; 

	}

	public ArrayList<Mascota> buscarMascotasporDueno(String dni) {
		ArrayList<Mascota> totMascotasDueno = new ArrayList<Mascota>();
		
		for(int i=0; i < mascotas.size(); i++) {
			if(mascotas.get(i).getDniDueno().equals(dni)) {
				totMascotasDueno.add(mascotas.get(i));
			}
		}
		return totMascotasDueno;
	}

}
