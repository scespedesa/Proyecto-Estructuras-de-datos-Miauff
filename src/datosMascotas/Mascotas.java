package datosMascotas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import logicaNegocio.Conexion;

public class Mascotas {
	protected String idAnimal;
	protected String tipo;
	protected String raza;
	protected int edad;
	protected String foto;
	protected String nombre;

	protected String user;

	public Mascotas(String nombre, String tipo, String raza, String foto ,String user ,int edad) {
		this.tipo = tipo;
		this.raza = raza;
		this.edad = edad;
		this.foto = foto;
		this.nombre = nombre;
		this.user = user;

	}
	
	public String getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(String idAnimal) {
		this.idAnimal = idAnimal;
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
		return "Mascotas [idAnimal=" + idAnimal + ", nombre=" + nombre +", tipo=" + tipo + ", raza=" + raza + ", edad=" + edad + ", foto="
				+ foto + "]";
	}
    public void insertarDB() {
    	try {
    	Conexion conec = new Conexion();
		Connection con = conec.Conectar();
   //// Preparamos la insercion de un registro
        PreparedStatement insertar = con.prepareStatement("insert into ANIMALES (NOMBRE, TIPO, RAZA, FOTO, USER, EDAD) values (?,?,?,?,?,?)");
        insertar.setString(2, this.nombre);
        insertar.setString(3, this.tipo);
        insertar.setString(4, this.raza);
        insertar.setString(5, this.foto);
        insertar.setString(7, this.user);
        insertar.setInt(9, this.edad);
        int retorn = insertar.executeUpdate();
        System.out.println(retorn + " insertado");
    } catch (SQLException ex) {
        System.out.println("Imposible realizar insercion ... FAIL");
    }
    }
	
}
