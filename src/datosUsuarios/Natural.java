package datosUsuarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import logicaNegocio.*;
import javax.swing.Icon;

import dataStructures.MyArrayList;
import datosMascotas.Mascotas;

public class Natural extends Usuario{
	
	private MyArrayList mascotas;
	private String genero;
   
	
	public Natural(String idUsuario, String contraseņa, String rol, String nombre, String genero, String nacimiento, String direccion,
			String telefono, String descripcion, String urlFoto, MyArrayList mascotas ) {
		super(idUsuario, contraseņa, nombre, nacimiento, direccion, telefono, descripcion, urlFoto, rol);
		this.mascotas = mascotas;
		this.genero=genero;
	}

	public void adoptarMascota(int numeroPosicion){
		
		
		LectorMascotas lm= new LectorMascotas("mascotas.txt");
		lm.LecturaLineas();
		
		Lector l= new Lector("usuarios.txt");
		l.LecturaLineas();
		
		
		Manipular m= new Manipular(lm.getDatosMascotas());
		
	//-----	lm.getDatosMascotas().get(numeroPosicion).getTipo();

		m.eliminarRegistro(numeroPosicion);
		
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
		return "Natural [idUsuario=" + idUsuario + ", contraseņa="+ contraseņa +  ", nombre=" + nombre + ", genero=" + genero + ", nacimiento=" + nacimiento + ", direccion=" + direccion
				+ ", telefono=" + telefono + ", descripcion=" + descripcion + ", urlFoto=" + urlFoto + ", rol=" + rol + ", mascotas=" +mascotas
				+ "]";
	}



}
