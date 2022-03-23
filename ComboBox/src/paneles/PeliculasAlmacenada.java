package paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PeliculasAlmacenada extends JPanel{

	private static final long serialVersionUID = 1L;

	private int x;
	private int width;
	private int height;
	private JTextField addPelicula;
	private JComboBox<String> comboPeliculas;

	public PeliculasAlmacenada() {
		this.setLayout(null);
		iniciarVariables();
		add(iniciarJTextField());
		add(iniciarJButton());
		add(iniciarJComboBox());
	}
	
	private void iniciarVariables() {
		x=50;
		width=150;
		height=40;
	}

	private JTextField iniciarJTextField() {
		addPelicula = new JTextField();
		addPelicula.setBounds(x, 200, width, height);
		return addPelicula;
	}

	private JButton iniciarJButton() {
		JButton agregarPelicula = new JButton("Añadir");
		agregarPelicula.setBounds(x, 250, width, height);

		agregarPelicula.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!addPelicula.getText().equals("")){
					comboPeliculas.addItem(addPelicula.getText());
					addPelicula.setText("");
				}
			}
		});
		return agregarPelicula;
	}

	private JComboBox<String> iniciarJComboBox(){
		comboPeliculas = new JComboBox<String>();
		comboPeliculas.setBounds(300, 200, width, height);
		return comboPeliculas;
	}
}
