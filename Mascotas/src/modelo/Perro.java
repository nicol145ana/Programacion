package modelo;

public class Perro extends Mascota{

	private String raza;
	private boolean pulgas;

	public Perro(String nombre, int edad, Fecha fecha, String dniDueno, String raza, boolean pulgas) {
		super(nombre, edad, fecha, dniDueno);
		this.raza = raza;
		this.pulgas = pulgas;
	}

	private String pulgas() {
		if(this.pulgas == true) {
			return "S";
		}else {
			return "N";
		}
	}
	
//	@Override
//	public void come() {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public String toString() {
		return "P"  + ", " + super.id + ", " + super.nombre + ", " + super.edad + ", " + super.fecha + ", " + raza + ", " + pulgas() + ", " + super.dniDueno + ";";
	}
	
	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public boolean isPulgas() {
		return pulgas;
	}

	public void setPulgas(boolean pulgas) {
		this.pulgas = pulgas;
	}

}
