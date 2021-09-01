package datosUsuarios;
import java.util.ArrayList;

import dataStructures.MyArrayList;
import datosMascotas.Mascotas;
import logicaNegocio.LectorMascotas;

public class Administrador<T>  extends Usuario{
	private String urlPagina;
	private MyArrayList<Mascotas> mascotas ;
	
	public Administrador(String idUsuario, String contrase�a, String nombre, String nacimiento, String direccion,
			String telefono, String descripcion, String urlFoto, String rol, String urlPagina, MyArrayList<Mascotas> mascotas) {
		super(idUsuario, contrase�a, nombre, nacimiento, direccion, telefono, descripcion, urlFoto, rol);
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
		return "Administrador % idUsuario=" + idUsuario  + "% contrase�a=" + contrase�a+ "% nombre=" + nombre + "% descripcion=" + descripcion ;
	}

}
