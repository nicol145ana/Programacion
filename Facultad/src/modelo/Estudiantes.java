package modelo;

public class Estudiantes extends Persona{

	private int curso;

	public Estudiantes(String nombre, String apellidos, String dni, boolean estadoCivil, int curso) {
		super(nombre, apellidos, dni, estadoCivil);
		this.curso = curso;
	}

	public void matricularNuevoCurso(int nuevoCurso) {
		this.curso = nuevoCurso;
	}
	
	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return super.toString() + "| Estudiante [ CURSO = " + curso + "] | ";
	}
	
}