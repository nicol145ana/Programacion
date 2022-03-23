package vista;

import javax.swing.JFrame;

import paneles.PeliculasAlmacenada;

public class VentanaPrincipal extends JFrame{

	private static final long serialVersionUID = 1L;

	public VentanaPrincipal() {
		iniCaractVentana();
		iniciarPanel();
	}
	
	private void iniCaractVentana() {
		this.setSize(500, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
	}
	
	private void iniciarPanel() {
		PeliculasAlmacenada panelPeliculas = new PeliculasAlmacenada();
		this.setContentPane(panelPeliculas);
	}
}
