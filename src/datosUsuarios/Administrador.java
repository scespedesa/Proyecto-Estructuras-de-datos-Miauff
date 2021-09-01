package datosUsuarios;
import java.util.ArrayList;

import dataStructures.MyArrayList;
import datosMascotas.Mascotas;
import logicaNegocio.LectorMascotas;

public class Administrador<T>  extends Usuario{
	private String urlPagina;
	private MyArrayList<Mascotas> mascotas ;
	
	public Administrador(String idUsuario, String contrasenia, String nombre, String nacimiento, String direccion,
			String telefono, String descripcion, String urlFoto, int rol, String urlPagina, MyArrayList<Mascotas> mascotas) {
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
	@Override
	public String toString() {
		return "Administrador % idUsuario=" + idUsuario  + "% contrasenia=" + contrasenia + "% nombre=" + nombre + "% descripcion=" + descripcion ;
	}

}
