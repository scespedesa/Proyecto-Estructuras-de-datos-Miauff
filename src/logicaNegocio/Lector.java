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
	private ArrayList <Natural> datosPersonaNatural ;
	private ArrayList<Administrador> datosAdministrador;
	private ArrayList<Usuario> datos ;
	private String[] listadoPerros;


	public Lector(String nombreArchivo) { 
		this.nombreArchivo= nombreArchivo;
		datosPersonaNatural = new ArrayList<Natural>();
		datosAdministrador = new ArrayList<Administrador>();
		listadoPerros = new String[283];
		datos = new ArrayList<Usuario>();
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
	public Mascotas procesarAnimales(String linea) {
		Scanner in = new Scanner(linea);
		in.useDelimiter(",");
		String nombreMascota = subAnimales(in.next().trim());
		String tipoMascota = subAnimales(in.next().trim());
		String razaMascota = subAnimales(in.next().trim());	
		String edadMascota1 = subAnimales(in.next().trim());
		int edadMascota= Integer.parseInt(edadMascota1);
		String fotoMascota = subAnimales(in.next().trim());	
		in.close();
		return new Mascotas("id",nombreMascota,tipoMascota,razaMascota, edadMascota,fotoMascota,"descripcion");
	}

	private void procesarLinea(String line) {
		Scanner sc = new Scanner (line);
		sc.useDelimiter("%");
		Natural it1=null ;
		Administrador it= null ;
		String tipo = sc.next().trim();
		String idUsuario = sub(sc.next().trim());
		String contrasenia = sub(sc.next().trim());
		String nombre = sub(sc.next().trim());		
		String descripcion = sub(sc.next().trim());
		switch(tipo) {
		case"Persona natural":
			String telefono = sub(sc.next().trim());
			String mascotasAdoptadas= sc.next().trim();
			Scanner scan = new Scanner(mascotasAdoptadas);
			scan.useDelimiter("#");
			MyArrayList<Mascotas> ma = new MyArrayList<Mascotas>();
			while(scan.hasNext()) {
				String lineaAnimal = sub(scan.next().trim());
				Mascotas masco = procesarAnimales(lineaAnimal);
				ma.pushFront(masco);	
			}

			it1 = new Natural(idUsuario,contrasenia,"natural", nombre, "genero","fecha nacimiento","343 calle",telefono, descripcion,"urlFoto", ma);
			datosPersonaNatural.add(it1);
 			datos.add(it1);
			break;
		case"Administrador":
			it= new Administrador( idUsuario,contrasenia, nombre, "nacimiento","direccion",
					"4544",  descripcion, "urlFoto", "admin","urlPagina");
			datosAdministrador.add(it);
			datos.add(it);
			break;
		default:
			System.out.println("Categoria desconocida "+ tipo);
		}
		sc.close();
	}
	public String sub(String unidad) {
		int index = unidad.indexOf("=")+1;
		return unidad.substring(index);
	}public String subAnimales(String unidad) {
		int index = unidad.indexOf("-")+1;
		return unidad.substring(index);
	}



	public ArrayList<Natural> getDatosPersonaNatural() {
		return datosPersonaNatural;
	}
	public void setDatosPersonaNatural(ArrayList<Natural> datosPersonaNatural) {
		this.datosPersonaNatural = datosPersonaNatural;
	}
	public ArrayList<Administrador> getDatosAdministrador() {
		return datosAdministrador;
	}
	public void setDatosAdministrador(ArrayList<Administrador> datosAdministrador) {
		this.datosAdministrador = datosAdministrador;
	}
	public ArrayList<Usuario> getDatos() {
		return datos;
	}
	public void setDatos(ArrayList<Usuario> datos) {
		this.datos = datos;
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
