package datosUsuarios;


import java.util.*;

import javax.swing.Icon;
import logicaNegocio.*;
import datosMascotas.Mascotas;
public abstract class Usuario {
	
	protected String idUsuario;
	protected String contrasenia; 
	protected String nombre;
	protected String nacimiento;
	protected String direccion;
	protected String telefono;
	protected String descripcion;
	protected String urlFoto;
	protected int rol;

	public Usuario(String idUsuario, String contrasenia, String nombre, String nacimiento, String direccion,
			String telefono, String descripcion, String urlFoto, int rol) {
		this.idUsuario = idUsuario;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.nacimiento = nacimiento;
		this.direccion = direccion;
		this.telefono = telefono;
		this.descripcion = descripcion;
		this.urlFoto = urlFoto;
		this.rol = rol;
	}

public String getNacimiento() {
		return nacimiento;
	}


	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getUrlFoto() {
		return urlFoto;
	}


	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}


	
	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public String getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getContrasenia() {
		return contrasenia;
	}


	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + "\\ numeroSeguidores=" + "\\ nombre=" + nombre + "\\ descripcion=" + descripcion + "]";
	}
}
