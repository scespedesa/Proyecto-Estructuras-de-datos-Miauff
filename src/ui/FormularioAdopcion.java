package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


import logicaNegocio.Conexion;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;

public class FormularioAdopcion extends JFrame {

	private JPanel contentPane;
	private String usuario="pepe";
	private int id;
	public static String name;
	public  int age;
	public  String descripcionFisica ;
	public  String descripcionCon ;
	public  ImageIcon fotoEnviar;
	public String raza;
	

	/**
	 * Launch the application.
	 */
	public  void correr( ){

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioAdopcion frame = new FormularioAdopcion();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormularioAdopcion() {
		
	
		
		AdoptarMascota ad= new  AdoptarMascota();
		Ingreso i = new Ingreso();
		usuario= i.usuarioEnviar;
		
		id=ad.id;
		name=ad.name;
		age=ad.age;
		descripcionFisica=ad.descripcionFisica;
		descripcionCon=ad.descripcionCon;
		fotoEnviar=ad.fotoEnviar;
		raza=ad.r;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 192, 203));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBackground(new Color(230, 230, 250));
		btnConfirmar.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Conexion conec= new Conexion();
				Connection conexion = conec.Conectar();
				
				try {
					PreparedStatement actualizar = conexion.prepareStatement("UPDATE ANIMALES SET USER=? WHERE IDANIMAL = ?");
					actualizar.setString(1,usuario );
					actualizar.setInt(2,id);
					actualizar.executeUpdate();
					JOptionPane.showMessageDialog(null, "adoptado");
					AdoptarMascota a= new AdoptarMascota();
					a.correr();
				
					dispose();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnConfirmar.setBounds(166, 312, 89, 30);
		contentPane.add(btnConfirmar);
		
		JButton btnNewButton = new JButton("no");
		btnNewButton.setBackground(new Color(240, 255, 255));
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdoptarMascota a= new AdoptarMascota();
				a.correr();
				dispose();
			}
		});
		btnNewButton.setBounds(78, 312, 89, 30);
		contentPane.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(238, 232, 170));
		panel_2.setBounds(10, 170, 294, 131);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBackground(new Color(255, 192, 203));
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setBounds(0, 0, 294, 131);
		
		panel_2.add(textArea);
		
		JLabel lblfoto = new JLabel("");
		lblfoto.setBounds(10, 11, 136, 118);
		lblfoto.setIcon(fotoEnviar);
		
		contentPane.add(lblfoto);
		
		JLabel lblNombre = new JLabel("New label");
		lblNombre.setBounds(159, 11, 130, 24);
		lblNombre.setText(name);
		contentPane.add(lblNombre);
		
		JLabel lblEdad = new JLabel("New label");
		lblEdad.setBounds(159, 46, 115, 14);
	
		lblEdad.setText(String.valueOf(age));
		contentPane.add(lblEdad);
		
		JLabel lblRaza = new JLabel("New label");
		lblRaza.setBounds(156, 71, 133, 14);
		lblRaza.setText(raza);
		contentPane.add(lblRaza);
		
			
		String variable="";
		int a=1;
		
		for(char c: descripcionFisica.toCharArray()) {
			
			variable+=c;
			if(a%48==0 || a==descripcionFisica.length()) {
				
				System.out.println(variable);
				textArea.append(variable+"\n");
				variable="";
			}
			a++;
					
		}
		int b=1;
		String variable2="";
		
		for(char c: descripcionCon.toCharArray()) {
			
			variable2+=c;
			if(b%48==0||  b==descripcionCon.length()) {
				
				System.out.println(variable2);
				textArea.append(variable2+"\n");
				variable2="";
			}
			b++;
					
		}
		/*
		for(int i=0; descripcionFisica.length()>i;i++) {
			
			variable+=descripcionFisica.charAt(i);
			if(i%48==0) {
				textArea.append(variable+"\n");
				variable="";
			}
		}

		
		String variable2="";
		
		for(int i=0; descripcionCon.length()>i;i++) {
			
			variable+=descripcionCon.charAt(i);
			if(i%48==0) {
				textArea.append(variable2+"\n");
				variable2="";
			}
		}
		*/
	}

	public ImageIcon scaleImage(String url, int ancho , int altura) {
		ImageIcon icon = new ImageIcon(FormularioAdopcion.class.getResource(url));
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(ancho, altura, Image.SCALE_SMOOTH);
		return new ImageIcon(imgScale);}
}
