package datosUsuarios;


import dataStructures.MyArrayList;
import datosMascotas.MascotasAdopcion;
import logicaNegocio.LectorMascotas;

public class Administrador  extends Usuario{
	private String urlPagina;
	private MyArrayList<MascotasAdopcion> mascotas = new MyArrayList<MascotasAdopcion>();
	 
	public Administrador(String idUsuario, String nombre,  String nacimiento, String direccion,
			String telefono, String descripcion, String urlFoto, String contrasenia,int rol, String urlPagina,MyArrayList<MascotasAdopcion> mascotas) {
		super(idUsuario, contrasenia, nombre, nacimiento, direccion, telefono, descripcion, urlFoto, rol);
		this.urlPagina = urlPagina;
		this.mascotas = mascotas;
	}

	public String getUrlPagina() {
		return urlPagina;
	}
	public void setUrlPagina(String urlPagina) {
		this.urlPagina = urlPagina;
	}
	public MyArrayList<MascotasAdopcion> getMascotas(){
		return this.mascotas;
	}
	@Override
	public String toString() {
		return "Administrador % idUsuario=" + idUsuario  + "% contrasenia=" + contrasenia + "% nombre=" + nombre + "% descripcion=" + descripcion ;
	}

}
