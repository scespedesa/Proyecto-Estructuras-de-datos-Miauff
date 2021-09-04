package datosMascotas;

public class MascotasAdopcion extends Mascotas {
	private int estado;
	private String fechaIngreso;
	private String descripcionFisica;
	private String descripcionCondicion;

	public MascotasAdopcion( String nombre,String tipo, String raza, String foto,int estado, String user,
			String fechaIngreso, int edad, String descripcionFisica, String descripcionCondicion) {
		super(nombre,tipo, raza,  foto,user,edad);
		this.estado = estado;
		this.fechaIngreso = fechaIngreso;
		this.descripcionFisica = descripcionFisica;
		this.descripcionCondicion = descripcionCondicion;
		
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getDescripcionCondicion() {
		return descripcionCondicion;
	}
	public void setDescripcionCondicion(String descripcionCondicion) {
		this.descripcionCondicion = descripcionCondicion;
	}
	public String getDescripcionFisica() {
		return descripcionFisica;
	}

	public void setDescripcionFisica(String descripcionFisica) {
		this.descripcionFisica = descripcionFisica;
	}

	@Override
	public String toString() {
		return "MascotasAdopcion [estado=" + estado +  ", fechaIngreso=" + fechaIngreso
				+ ", descripcionCondicion=" + descripcionCondicion +", idAnimal=" + idAnimal
				+ ", tipo=" + tipo + ", raza=" + raza + ", edad=" + edad + ", foto=" + foto + ", nombre=" + nombre
				+ ", descripcionFisica=" + descripcionFisica + "]";
	}
	
	
	
}
