package logicaNegocio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import dataStructures.ListaSimplementeEnlazada;
import dataStructures.MyArrayList;
import datosMascotas.Mascotas;
import datosUsuarios.Administrador;
import datosUsuarios.Natural;
import datosUsuarios.Usuario;


public class Lector<E> {
	private String nombreArchivo;
	private String[] listadoCaninos;
	private String[] listadoGatos;
	private String[] listadoConejos;
	private String[] listadoPeces;

	public Lector(String nombreArchivo) { 
		this.nombreArchivo= nombreArchivo;
		
	}
	public void LecturaLineas() {
		File inFile= new File(nombreArchivo);
		try {
			Scanner sc = new Scanner(inFile);
			int i =0;
			if(nombreArchivo.equals(listadoCaninos)) {
					listadoCaninos = new String[283];
			}else if(nombreArchivo.equals(listadoGatos)) {
				listadoGatos = new String[43];
			}else if(nombreArchivo.equals(listadoConejos)) {
				listadoConejos = new String[46];	
			}else if(nombreArchivo.equals(listadoPeces)) {
				listadoPeces = new String[43];
				
			}
			while(sc.hasNext()) {
					String linea = sc.nextLine();
					procesarLinea(i,linea);
					i+=1;	
			}

		}catch (FileNotFoundException e) {
			System.err.println("No se encontro el archivo: " + nombreArchivo);
			e.printStackTrace();
		}
	}public void procesarLinea(int i,String linea) {
		if(nombreArchivo.equals(listadoCaninos)) {
			listadoCaninos[i]=linea;
		}else if(nombreArchivo.equals(listadoGatos)) {
			listadoGatos[i]=linea;
		}else if(nombreArchivo.equals(listadoConejos)) {
			listadoConejos[i]=linea;
		}else if(nombreArchivo.equals(listadoPeces)) {
			listadoPeces[i]=linea;
		}		
	}
	
	public void setNombreArchivo(String nombreArchivo){
		this.nombreArchivo = nombreArchivo;
	}
	public String[] getListadoCaninos() {
		return listadoCaninos;
	}
	public void setListadoCaninos(String[] listadoCaninos) {
		this.listadoCaninos = listadoCaninos;
	}
	public String[] getListadoGatos() {
		return listadoGatos;
	}
	public void setListadoGatos(String[] listadoGatos) {
		this.listadoGatos = listadoGatos;
	}
	public String[] getListadoConejos() {
		return listadoConejos;
	}
	public void setListadoConejos(String[] listadoConejos) {
		this.listadoConejos = listadoConejos;
	}
	public String[] getListadoPeces() {
		return listadoPeces;
	}
	public void setListadoPeces(String[] listadoPeces) {
		this.listadoPeces = listadoPeces;
	}
	



}
