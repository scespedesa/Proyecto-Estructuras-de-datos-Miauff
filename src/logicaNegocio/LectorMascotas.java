package logicaNegocio;
import datosMascotas.Mascotas;
import dataStructures.PriorityQueueQueue;
import dataStructures.PriorityNode;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import com.mysql.cj.xdevapi.Statement;
import logicaNegocio.Conexion;
import java.sql.*;

public class LectorMascotas {
    
	private PriorityQueueQueue<Mascotas> datosMascotas ;
	private Conexion conec = new Conexion();
	private Connection conexion = conec.Conectar();

	public LectorMascotas(String nombreArchivo) { 
		datosMascotas = new PriorityQueueQueue<Mascotas>();
	}

//	private void procesar(String line) {
//		Scanner sc = new Scanner (line);
//		sc.useDelimiter(diferenciador);
//		Mascotas it1=null;
//		String nombre = sc.next().trim();
//		String tipo = sc.next().trim();
//		String raza = sc.next().trim();
//		String edad =sc.next().trim();
//		String foto = sc.next().trim();
//		
//		switch("") {
//		case"":
//			int edad1= Integer.parseInt(edad);
//			 //it1 = new Mascotas(nombre,tipo,raza, edad1, foto);
//			datosMascotas.add(it1);
//			break;
//
//		default:
//			System.out.println("Categoria desconocida "+ tipo);
//		}
//		sc.close();
//	}

	public PriorityQueueQueue<Mascotas> getDatosMascotas() {
		return datosMascotas;
	}
	public void setDatosMascotas(PriorityQueueQueue<Mascotas> datosMascotas) {
		this.datosMascotas = datosMascotas;
	}
	
 private void ConsultarMascotasDB() {
	try {
		// Preparamos la consulta
		 java.sql.Statement s = conexion.createStatement();
		            ResultSet rs = s.executeQuery("select * from mascota");
		// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.

		            while (rs.next()) {
		                System.out.println(
		                        "ID: " + rs.getInt(1)
		                        + "\tNombre: " + rs.getString(2)
		                        + "\tSexo: " + rs.getString("sexo")
		                );
		            }
		        } catch (SQLException ex) {
		            System.out.println("Imposible realizar consulta ... FAIL");
		        }
}
}
