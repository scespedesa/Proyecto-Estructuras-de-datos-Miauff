package datosUsuarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import logicaNegocio.*;
import javax.swing.Icon;

import dataStructures.MyArrayList;
import datosMascotas.Mascotas;

public class Natural extends Usuario{
	
	private int numeroDeAnimales;
	private String genero;
   
	
	public Natural(String idUsuario, String contraseña, String nombre, String nacimiento, String direccion,
			String telefono, String descripcion, String urlFoto, String rol, int numeroDeAnimales, String genero) {
		super(idUsuario, contraseña, nombre, nacimiento, direccion, telefono, descripcion, urlFoto, rol);
		this.numeroDeAnimales = numeroDeAnimales;
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





	public int getNumeroDeAnimales() {
		return numeroDeAnimales;
	}


	public void setNumeroDeAnimales(int numeroDeAnimales) {
		this.numeroDeAnimales = numeroDeAnimales;
	}


public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

@Override
	public String toString() {
		
		return "Persona natural% idUsuario=" + idUsuario  + "% contraseña="+ contraseña+ "% nombre=" + nombre + "% descripcion=" + descripcion +  "% telefono=" + telefono + "% " ;
	}


}
