package modelo;

public class Alumno {
	private String numControl;
	private String nombre;
	private String primerAp;
	private String segundoAp;
	private byte semetre;
	private String carrera;
	
	public Alumno() {}
	
	public Alumno(String numControl, String nombre, String primerAp, String segundoAp, byte semetre,
			String carrera) {
		super();
		this.numControl = numControl;
		this.nombre = nombre;
		this.primerAp = primerAp;
		this.segundoAp = segundoAp;
		this.semetre = semetre;
		this.carrera = carrera;
	}

	public String getNumControl() {
		return numControl;
	}
	public void setNumControl(String numControl) {
		this.numControl = numControl;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrimerAp() {
		return primerAp;
	}
	public void setPrimerAp(String primerAp) {
		this.primerAp = primerAp;
	}
	public String getSegundoAp() {
		return segundoAp;
	}
	public void setSegundoAp(String segundoAp) {
		this.segundoAp = segundoAp;
	}
	public byte getSemetre() {
		return semetre;
	}
	public void setSemetre(byte semetre) {
		this.semetre = semetre;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	@Override
	public String toString() {
		return "Alumno [numControl=" + numControl + ", nombre=" + nombre + ", primerAp=" + primerAp + ", segundoAp="
				+ segundoAp + ", semetre=" + semetre + ", carrera=" + carrera + "]";
	}

}
