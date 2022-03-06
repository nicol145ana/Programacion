package vista;

import controlador.Menu;
import controlador.ValidacionDatos;
import modelo.Gato;
import modelo.Perro;

public class Mascotas {

	public static void main(String[] args) {

		Menu menu = new Menu();

		String fin = menu.gestorMenu();

		System.out.println(fin);

	}
}
