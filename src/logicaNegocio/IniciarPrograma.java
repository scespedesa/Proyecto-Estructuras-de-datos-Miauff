package logicaNegocio;

import java.util.Scanner;

import datosUsuarios.Natural;
import ui.Ingreso;

public class IniciarPrograma {
	

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" ----------------------------------");
		System.out.println("|      ¡Bienvenido a MIAUFF!       |");
		System.out.println(" ----------------------------------");
		//Consola con = new Consola();
		//con.consolaInicial();
		//Lector l = new Lector("usuarios.txt");
		//l.LecturaLineas();	
		Ingreso i = new Ingreso () ;
		i.setVisible(true);
		
		}
	
}

	
