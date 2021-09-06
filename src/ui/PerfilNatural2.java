package ui;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import datosUsuarios.Administrador;
import datosUsuarios.Natural;
import logicaNegocio.Conexion;

import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.net.*;
import java.sql.*;


import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
public class PerfilNatural2 extends JFrame {
	
		private JPanel contentPane;
		private Administrador organizacion;
        private Natural aficionado;
    	private int x;
    	private String toContact;
    	private String usuario="pepe";
        


		
		/**
		 * @wbp.parser.constructor
		 */
		public PerfilNatural2(Natural e,int num) {
			boolean esAdmin = (num==1);
			usuario= e.getIdUsuario();
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(0,0,450,745);
			contentPane = new JPanel();
			contentPane.setBackground(SystemColor.window);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			aficionado = e;
		createBigMenu(esAdmin);
        Inicio(esAdmin);
		}

		public PerfilNatural2(Administrador organizador,int num) {
			boolean esAdmin = (num==1);
			usuario= organizador.getIdUsuario();
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(0,0,450,745);
			contentPane = new JPanel();
			contentPane.setBackground(SystemColor.window);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			this.organizacion = organizador;
			createBigMenu(esAdmin);
        Inicio(esAdmin);
		}
	public void Inicio(boolean esAdmin) {
	    
        
        JLabel lblNewLabel = new JLabel("Bienvenidos a Miauff");
			lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 30));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(10, 70, 426, 54);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Creado por:");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 25));
			lblNewLabel_1.setBounds(8, 168, 426, 54);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Sofía Salina Rico");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setFont(new Font("Gill Sans MT", Font.PLAIN, 16));
			lblNewLabel_2.setBounds(73, 233, 284, 29);
			contentPane.add(lblNewLabel_2);
			
			JLabel lblNewLabel_2_1 = new JLabel("Juan Sebastián Reyes");
			lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_1.setFont(new Font("Gill Sans MT", Font.PLAIN, 16));
			lblNewLabel_2_1.setBounds(73, 273, 284, 29);
			contentPane.add(lblNewLabel_2_1);
			
			JLabel lblNewLabel_2_2 = new JLabel("Samara Césepedes Afanador");
			lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_2.setFont(new Font("Gill Sans MT", Font.PLAIN, 16));
			lblNewLabel_2_2.setBounds(73, 313, 284, 29);
			contentPane.add(lblNewLabel_2_2);
			
			JLabel lblNewLabel_2_3 = new JLabel("Juan David Gomez ");
			lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_3.setFont(new Font("Gill Sans MT", Font.PLAIN, 16));
			lblNewLabel_2_3.setBounds(73, 353, 284, 29);
			contentPane.add(lblNewLabel_2_3);
			
			JLabel lblNewLabel_2_3_1 = new JLabel("David Garcia");
			lblNewLabel_2_3_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_3_1.setFont(new Font("Gill Sans MT", Font.PLAIN, 16));
			lblNewLabel_2_3_1.setBounds(73, 393, 284, 29);
			contentPane.add(lblNewLabel_2_3_1);
			
			JLabel lblNewLabel_2_3_2 = new JLabel("José Luis Pulido");
			lblNewLabel_2_3_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2_3_2.setFont(new Font("Gill Sans MT", Font.PLAIN, 16));
			lblNewLabel_2_3_2.setBounds(73, 433, 284, 29);
			contentPane.add(lblNewLabel_2_3_2);
			
			JLabel lblNewLabel_3 = new JLabel("Miauff es una app sin animo de lucro");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 25));
			lblNewLabel_3.setBounds(8, 493, 426, 54);
			contentPane.add(lblNewLabel_3);
			
			JLabel lblNewLabel_1_1 = new JLabel("2021® Derechos reservados");
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 25));
			lblNewLabel_1_1.setBounds(8, 539, 426, 54);
			contentPane.add(lblNewLabel_1_1);
			
			JLabel lblNewLabel_7 = new JLabel("profe, ponganos 50");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 5));
			lblNewLabel_7.setBounds(288, 106, 116, 29);
			contentPane.add(lblNewLabel_7);
        createFondo();
		}

	public ImageIcon scaleImage(String url, int ancho , int altura) {
		ImageIcon icon = new ImageIcon(RegistroPersonas.class.getResource(url));
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(ancho, altura, Image.SCALE_SMOOTH);
		return new ImageIcon(imgScale);

	}

		public void createFondo(){
			JLabel Fondo = new JLabel("");
			Fondo.setBackground(new Color(255, 255, 255));
			
				Fondo.setBounds(0,0,450,706);
				Fondo.setIcon( scaleImage("/imagenes/FondoInterfazChat.jpg",450,760));
				contentPane.add(Fondo);		
		}
		
	

		public void createBigMenu(boolean esAdmin) {
			 JLabel LabelTitulo = new JLabel("USUARIO");
				LabelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
				LabelTitulo.setBounds(99, 13, 260, 25);
				contentPane.add(LabelTitulo);
				LabelTitulo.setForeground(new Color(255, 255, 255));
				LabelTitulo.setHorizontalTextPosition(SwingConstants.CENTER);
				LabelTitulo.setVerticalTextPosition(SwingConstants.CENTER);
				LabelTitulo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
			 
			
			JButton Contactos = new JButton("Contactos");
		
				Contactos.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						Usuario frame = new Usuario();
						frame.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			
			
			JButton Mascotas = new JButton("Mascotas");
			Mascotas.setIcon(scaleImage("/imagenes/gato-birmano.png",31,31));
			Mascotas.setVerticalTextPosition(SwingConstants.BOTTOM);
			Mascotas.setHorizontalTextPosition(SwingConstants.CENTER);
			Mascotas.setContentAreaFilled(false);
			Mascotas.setBorderPainted(false);
			Mascotas.setRolloverIcon(scaleImage("/imagenes/gato-birmano.png",34,34));
			Mascotas.setBounds(73, 652, 93, 54);
			contentPane.add(Mascotas);
			Mascotas.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {	
               if(esAdmin) {
            	   EdicionMascotas perf = new EdicionMascotas(organizacion,true);
            	   perf.setVisible(true);
               }else {
            	   EdicionMascotas perf = new EdicionMascotas(aficionado,false);
            	   perf.setVisible(true);
               }
					}

			});
			
			JButton btnPerfill = new JButton("Perfil");
			btnPerfill.setHorizontalTextPosition(SwingConstants.CENTER);
			btnPerfill.setVerticalTextPosition(SwingConstants.BOTTOM);
			btnPerfill.setIcon(new ImageIcon(PerfilNatural2.class.getResource("/imagenes/usuario (5).png")));
			btnPerfill.setRolloverIcon(scaleImage("/imagenes/usuario (5).png",35,35));
			btnPerfill.setBounds(0, 652, 76, 54);
			btnPerfill.setContentAreaFilled(false);
			btnPerfill.setBorderPainted(false);
			
			contentPane.add(btnPerfill);
			btnPerfill.setIcon(new ImageIcon(PerfilNatural2.class.getResource("/imagenes/usuario (5).png")));
			btnPerfill.setRolloverIcon(scaleImage("/imagenes/usuario (5).png",35,35));
			btnPerfill.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {	
               if(esAdmin) {
            	   PerfilAdministrador perf = new PerfilAdministrador(organizacion,true);
            	   perf.setVisible(true);
               }else {
            	   PerfilAdministrador perf = new PerfilAdministrador(aficionado,false);
            	   perf.setVisible(true);
               }
					}

			});
			JButton Inicio = new JButton("Inicio");
			Inicio.setVerticalTextPosition(SwingConstants.BOTTOM);
			Inicio.setHorizontalTextPosition(SwingConstants.CENTER);
			Inicio.setContentAreaFilled(false);
			Inicio.setBorderPainted(false);
			
					
					Inicio.setBounds(353, 652, 81, 54);
					Inicio.setIcon(scaleImage("/Imagenes/hogar.png",31,31));
					Inicio.setRolloverIcon(scaleImage("/Imagenes/hogar.png",35,35));
					contentPane.add(Inicio);
			
			JButton Publicar = new JButton("Adoptar");
			Publicar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AdoptarMascota a= new AdoptarMascota();
					a.correr();
				}
			});
			Publicar.setVerticalTextPosition(SwingConstants.BOTTOM);
			Publicar.setHorizontalTextPosition(SwingConstants.CENTER);
			Publicar.setContentAreaFilled(false);
			Publicar.setBorderPainted(false);
			
			Publicar.setBounds(171, 652, 93, 54);
			Publicar.setIcon(scaleImage("/imagenes/mas (1).png",31,31));
			Publicar.setRolloverIcon(scaleImage("/imagenes/mas (1).png",34,34));
			contentPane.add(Publicar);
			
			Contactos.setIcon(new ImageIcon(Usuario.class.getResource("/imagenes/telefono.png")));
			Contactos.setVerticalTextPosition(SwingConstants.BOTTOM);
			Contactos.setHorizontalTextPosition(SwingConstants.CENTER);
			Contactos.setContentAreaFilled(false);
			Contactos.setBorderPainted(false);
			Contactos.setBounds(264, 652, 93, 54);
			
					Contactos.setRolloverIcon(scaleImage("/imagenes/telefono.png",35,35));
					
						contentPane.add(Contactos);
		}
	}

