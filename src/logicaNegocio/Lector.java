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
	private String[] listadoPerros;


	public Lector(String nombreArchivo) { 
		this.nombreArchivo= nombreArchivo;
		listadoPerros = new String[283];
	}
	public void LecturaLineas() {
		File inFile= new File(nombreArchivo);
		try {
			Scanner sc = new Scanner(inFile);
			int i =0;
			while(sc.hasNext()) {
				String linea = sc.nextLine();
				listadoPerros[i] = linea;
				i+=1;	
			}
		}catch (FileNotFoundException e) {
			System.err.println("No se encontro el archivo: " + nombreArchivo);
			e.printStackTrace();
		}
	}
	

	private void procesarLinea(String line) {
		
	}
	
	public void setNombreArchivo(String nombreArchivo){
		this.nombreArchivo = nombreArchivo;
	}
	public String[] getListadoPerros() {
		return listadoPerros;
	}
	public void setListadoPerros(String[] listadoPerros) {
		this.listadoPerros = listadoPerros;
	}



}
