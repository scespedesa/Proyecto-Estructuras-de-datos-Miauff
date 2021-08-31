package datosMascotas;

public class Mascotas {
	protected String idAnimal;
	protected String tipo;
	protected String raza;
	protected int edad;
	protected String foto;
	protected String nombre;
	protected String descripcionFisica;

	public Mascotas(String idAnimal,String nombre, String tipo, String raza, int edad, String foto, 
			String descripcionFisica) {
		this.idAnimal = idAnimal;
		this.tipo = tipo;
		this.raza = raza;
		this.edad = edad;
		this.foto = foto;
		this.nombre = nombre;
		this.descripcionFisica = descripcionFisica;
	}
	
	public String getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(String idAnimal) {
		this.idAnimal = idAnimal;
	}

	public String getDescripcionFisica() {
		return descripcionFisica;
	}

	public void setDescripcionFisica(String descripcionFisica) {
		this.descripcionFisica = descripcionFisica;
	}

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getFoto() {
		return foto;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}public String getNombre() {
		return this.nombre;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Mascotas [idAnimal=" + idAnimal + ", nombre=" + nombre +", tipo=" + tipo + ", raza=" + raza + ", edad=" + edad + ", foto="
				+ foto +  ", descripcionFisica=" + descripcionFisica + "]";
	}

	
}
