package datosUsuarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import logicaNegocio.*;
import javax.swing.Icon;

import dataStructures.MyArrayList;
import datosMascotas.Mascotas;

public class Natural extends Usuario{
	
	private MyArrayList<Mascotas> mascotas = new MyArrayList<Mascotas>();
	private String genero;
   
	
	public Natural(String idUsuario, String contraseña, String rol, String nombre, String genero, String nacimiento, String direccion,
			String telefono, String descripcion, String urlFoto, MyArrayList<Mascotas> mascotas ) {
		super(idUsuario, contraseña, nombre, nacimiento, direccion, telefono, descripcion, urlFoto, rol);
		this.mascotas = mascotas;
		this.genero=genero;
	}
	
public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Natural [idUsuario=" + idUsuario + ", contraseña="+ contraseña +  ", nombre=" + nombre + ", genero=" + genero + ", nacimiento=" + nacimiento + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", descripcion=" + descripcion + ", urlFoto=" + urlFoto + ", rol=" + rol + ", mascotas=" +mascotas
				+ "]";
	}



}
