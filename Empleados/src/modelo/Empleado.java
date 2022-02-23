package modelo;

public class Empleado {
	
	protected String nombre;
	protected String apellidos;
	protected String dni;
	protected String direccion;
	protected int edad;
	protected char sexo;
	protected boolean estadoCivil;
	protected int antiguedad;
	protected String tel;
	protected double salario;
	
	public Empleado(String nombre, String apellidos, String dni, String direccion, int edad, char sexo,
			boolean estadoCivil, int antiguedad, String tel, double salario) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.direccion = direccion;
		this.edad = edad;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.antiguedad = antiguedad;
		this.tel = tel;
		this.salario = salario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public boolean isEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(boolean estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", direccion=" + direccion
				+ ", edad=" + edad + ", sexo=" + sexo + ", estadoCivil=" + estadoCivil + ", antiguedad=" + antiguedad
				+ ", tel=" + tel + ", salario=" + salario + "]";
	}

}
