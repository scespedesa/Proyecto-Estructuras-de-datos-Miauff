package logicaNegocio;
import datosMascotas.Mascotas;
import dataStructures.PriorityQueueQueue;
import dataStructures.PriorityNode;
import dataStructures.MyArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import com.mysql.cj.xdevapi.Statement;
import logicaNegocio.Conexion;
import java.sql.*;

public class LectorMascotas {
	private PriorityQueueQueue<Integer> datosMascotas = new PriorityQueueQueue<Integer>() ;
	private Conexion conec = new Conexion();
	private Connection conexion = conec.Conectar();

	public LectorMascotas(String nombreArchivo) { 
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

	public PriorityQueueQueue<Integer> getDatosMascotas() {
		return datosMascotas;
	}
	public void setDatosMascotas( PriorityQueueQueue<Integer> datosMascotas) {
		this.datosMascotas = datosMascotas;
	}
	
 private void ConsultarMascotasDB(int n) {
	try {
		// Preparamos la consulta
		 java.sql.Statement s = conexion.createStatement();
		            ResultSet rs = s.executeQuery("select * from ANIMALES where ESTADO >= 2");
		// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
                   int i =0;
		            while (rs.next() && i <= n) {
		            	double prior = rs.getInt(9)*0.7 + rs.getInt(6) ;// edad*0.7+factor prioridad
		            	datosMascotas.add(rs.getInt(1), prior);
		                i++;
		            }
		        } catch (SQLException ex) {
		            System.out.println("Imposible realizar consulta ... FAIL");
		        }
}
}
