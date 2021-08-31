package logicaNegocio;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion { 
	public Connection con = null; 

	public Connection Conectar() {
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://db-maiuff.c9mtqquqphkj.us-east-2.rds.amazonaws.com/miauff","admin","miauff2021"); 
			System.out.println("Conexion exitosa");
		 }
		 catch (Exception e) {
			 System.out.println(e);
		 }
		 return con;
	 }
}