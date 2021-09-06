package datosMascotas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import logicaNegocio.Conexion;

public class MascotasAdopcion extends Mascotas {
	private int estado;
	private int fechaIngreso;
	private String descripcionFisica;
	private String descripcionCondicion;
	private int idAnimal;

	public MascotasAdopcion( int idAnimal,String nombre,String tipo, String raza, String foto,int estado, String user,
			int fechaIngreso, int edad, String descripcionFisica, String descripcionCondicion) {
		super(nombre,tipo, raza,foto,user,edad,descripcionFisica);
		this.estado = estado;
		this.fechaIngreso = fechaIngreso;
		this.descripcionCondicion = descripcionCondicion;
		this.idAnimal = idAnimal;
	}
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(int fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getDescripcionCondicion() {
		return descripcionCondicion;
	}
	public void setDescripcionCondicion(String descripcionCondicion) {
		this.descripcionCondicion = descripcionCondicion;
	}
	public int getId() {
		return idAnimal;
	}
	public void setId(int idAnimal) {
		this.idAnimal = idAnimal;
	}

	@Override
	public String toString() {
		return "MascotasAdopcion [estado=" + estado +  ", fechaIngreso=" + fechaIngreso
				+ ", descripcionCondicion=" + descripcionCondicion +", tipo=" + tipo + ", raza=" + raza + ", edad=" + edad + ", foto=" + foto + ", nombre=" + nombre
				+ ", descripcionFisica=" + descripcionFisica + "]";
	}
	@Override
    public void setInDB(String user) {
		this.user=user;
    	try {
    	Conexion conec = new Conexion();
		Connection con = conec.Conectar();
   //// Preparamos la insercion de un registro
        PreparedStatement insertar = con.prepareStatement("insert into ANIMALES (NOMBRE, TIPO, RAZA, FOTO, ESTADO,USER, FECHA_ING,EDAD,DES_FISICA,DES_COND) values (?,?,?,?,?,?,?,?,?,?)");
        insertar.setString(1, this.nombre);
        insertar.setString(2, this.tipo);
        insertar.setString(3, this.raza);
        insertar.setString(4, this.foto);
        insertar.setInt(5, this.estado);
        insertar.setString(6, user);
        insertar.setInt(7, this.fechaIngreso);
        insertar.setInt(8, this.edad);
        insertar.setString(9,this.descripcionfisica);
        insertar.setString(10, this.descripcionCondicion);

        int retorn = insertar.executeUpdate();
        System.out.println(retorn + " insertado mascota");
    } catch (SQLException ex) {
        System.out.println("Imposible realizar insercion ... FAIL mascota"+ ex);
    }
        }
	
	
}