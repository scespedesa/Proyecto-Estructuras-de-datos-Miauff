package datosMascotas;

public class MascotasAdopcion extends Mascotas {
	private String estado;
	private String idFundacion;
	private String fechaIngreso;
	private String descripcionCondicion;
	private String urlInfo;
	public MascotasAdopcion(String idAnimal, String tipo, String raza, int edad, String foto, String nombre,
			String descripcionFisica, String estado, String idFundacion, String fechaIngreso,
			String descripcionCondicion, String urlInfo) {
		super(idAnimal, nombre,tipo, raza, edad, foto,  descripcionFisica);
		this.estado = estado;
		this.idFundacion = idFundacion;
		this.fechaIngreso = fechaIngreso;
		this.descripcionCondicion = descripcionCondicion;
		this.urlInfo = urlInfo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getIdFundacion() {
		return idFundacion;
	}
	public void setIdFundacion(String idFundacion) {
		this.idFundacion = idFundacion;
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
	public String getUrlInfo() {
		return urlInfo;
	}
	public void setUrlInfo(String urlInfo) {
		this.urlInfo = urlInfo;
	}
	@Override
	public String toString() {
		return "MascotasAdopcion [estado=" + estado + ", idFundacion=" + idFundacion + ", fechaIngreso=" + fechaIngreso
				+ ", descripcionCondicion=" + descripcionCondicion + ", urlInfo=" + urlInfo + ", idAnimal=" + idAnimal
				+ ", tipo=" + tipo + ", raza=" + raza + ", edad=" + edad + ", foto=" + foto + ", nombre=" + nombre
				+ ", descripcionFisica=" + descripcionFisica + "]";
	}
	
	
	
}
