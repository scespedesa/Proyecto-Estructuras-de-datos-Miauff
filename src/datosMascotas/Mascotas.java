package datosMascotas;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.stream.Stream;

import dataStructures.MyArrayList;
import logicaNegocio.Conexion;

public class Mascotas {
	protected String tipo;
	protected String raza;
	protected int edad;
	protected String foto;
	protected String nombre;
    protected String descripcionfisica;
	protected String user;

	public Mascotas(String nombre, String tipo, String raza, String foto ,String user ,int edad ,String descripcionfisica) {
		this.tipo = tipo;
		this.raza = raza;
		this.edad = edad;
		this.foto = foto;
		this.nombre = nombre;
		this.user = user;
		this.descripcionfisica = descripcionfisica;

	}

	public String getDescripcionfisica() {
		return descripcionfisica;
	}

	public void setDescripcionfisica(String descripcionfisica) {
		this.descripcionfisica = descripcionfisica;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getFoto() {
		return foto;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}public String getNombre() {
		return this.nombre;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Mascotas [ nombre=" + nombre +", tipo=" + tipo + ", raza=" + raza + ", edad=" + edad + ", foto="
				+ foto + "]";
	}
	
	public boolean checkNull() {
	     return  nombre==null || tipo=="" || raza==null ;
	}
	
    public void setInDB(String user) {
    	this.user=user;
    	try {
    	Conexion conec = new Conexion();
		Connection con = conec.Conectar();
   //// Preparamos la insercion de un registro
        PreparedStatement insertar = con.prepareStatement("insert into ANIMALES (NOMBRE, TIPO, RAZA, FOTO, USER, EDAD,DES_FISICA) values (?,?,?,?,?,?,?)");
        insertar.setString(1, this.nombre);
        insertar.setString(2, this.tipo);
        insertar.setString(3, this.raza);
        insertar.setString(4, this.foto);
        insertar.setString(5, user);
        insertar.setInt(6, this.edad);
        insertar.setString(7, this.descripcionfisica);
        int retorn = insertar.executeUpdate();
        System.out.println(retorn + " insertado mascota");
    } catch (SQLException ex) {
        System.out.println("Imposible realizar insercion mascota... FAIL"+ ex);
    }
    }
	
}
