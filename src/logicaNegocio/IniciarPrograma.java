package logicaNegocio;

import java.util.Scanner;

import dataStructures.HashTable;
import dataStructures.MyArrayList;
import datosUsuarios.Natural;
import ui.Ingreso;
import ui.PerfilAdministrador;
import ui.PerfilNatural2;

public class IniciarPrograma {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" ----------------------------------");
		System.out.println("|      Bienvenido a MIAUFF!       |");
		System.out.println(" ----------------------------------");
		//Consola con = new Consola();
		//con.consolaInicial();
		//Lector l = new Lector("usuarios.txt");
		//l.LecturaLineas();	
		Ingreso i = new Ingreso () ;
		i.setVisible(true);
		//HashTable yu = new HashTable(9);
		//RegistroUsuario usu = new RegistroUsuario();
		//usu.setVisible(true);	
		Conexion cn = new Conexion();
		cn.Conectar();
// Natural u = new Natural(null, null, null, null, null, null, null, null, null, 0, null);
//		PerfilNatural2 k = new PerfilNatural2(u, 0);
//		k.setVisible(true);
		}
	
}

	
