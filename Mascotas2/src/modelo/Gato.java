package modelo;

public class Gato extends Mascota{

	private String color;
	private char largoPelo;

	public Gato(String nombre, Fecha fecha, String dniDueno, char largoPelo, String color) {
		super(nombre, fecha, dniDueno);
		this.color = color;
		this.largoPelo = largoPelo;
	}
	
	@Override
	public String toString() {
		return "G" + ", " + super.id + ", " + super.nombre +  ", " + super.fecha + ", " + color + ", " + largoPelo + ", " + super.dniDueno + ";";
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public char getLargoPelo() {
		return largoPelo;
	}

	public void setLargoPelo(char largoPelo) {
		this.largoPelo = largoPelo;
	}
	
}
