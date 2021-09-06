package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import datosUsuarios.Administrador;
import datosUsuarios.Natural;
import java.awt.BorderLayout;

import java.awt.EventQueue;


import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


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
public class EdicionMascotas extends JFrame{
	
	private JPanel contentPane;
	private Administrador organizacion;
    private Natural aficionado;
	private boolean esAdmin;
	
	public EdicionMascotas(Natural aficionado, boolean esAdmin) {
		this.esAdmin=esAdmin;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,450,745);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.organizacion = organizacion;
		createBigMenu(esAdmin);
    Inicio(esAdmin);
	}

	public EdicionMascotas(Administrador organizacion, boolean esAdmin) {
		// TODO Auto-generated constructor stub
	}

	

		public void Inicio(boolean esAdmin) {
	    
        
        if(esAdmin){

		}else{

		}
		
        createFondo();
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
					
				}
			});
			Contactos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LabelTitulo.setText("CONTACTOS");
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
			Inicio.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {	
					if(esAdmin) {
                PerfilNatural2 frame = new PerfilNatural2(organizacion, 1);
					frame.setVisible(true);}
					else {  PerfilNatural2 frame = new PerfilNatural2(aficionado, 0);
					frame.setVisible(true);}
					}

			});
					Inicio.setBounds(353, 652, 81, 54);
					Inicio.setIcon(scaleImage("imagenes/hogar.png",31,31));
					Inicio.setRolloverIcon(scaleImage("imagenes/hogar.png",35,35));
					contentPane.add(Inicio);
			
			JButton Publicar = new JButton("Publicar");
			Publicar.setVerticalTextPosition(SwingConstants.BOTTOM);
			Publicar.setHorizontalTextPosition(SwingConstants.CENTER);
			Publicar.setContentAreaFilled(false);
			Publicar.setBorderPainted(false);
			
			Publicar.setBounds(171, 652, 93, 54);
			Publicar.setIcon(scaleImage("/imagenes/mas (1).png",31,31));
			Publicar.setRolloverIcon(scaleImage("/imagenes/mas (1).png",34,34));
			contentPane.add(Publicar);
			
			Contactos.setIcon(new ImageIcon(PerfilNatural2.class.getResource("/imagenes/telefono.png")));
			Contactos.setVerticalTextPosition(SwingConstants.BOTTOM);
			Contactos.setHorizontalTextPosition(SwingConstants.CENTER);
			Contactos.setContentAreaFilled(false);
			Contactos.setBorderPainted(false);
			Contactos.setBounds(264, 652, 93, 54);
			
					Contactos.setRolloverIcon(scaleImage("/imagenes/telefono.png",35,35));
					
						contentPane.add(Contactos);
		}

		public void createFondo(){
			JLabel Fondo = new JLabel("");
			Fondo.setBackground(new Color(255, 255, 255));
			
				Fondo.setBounds(0,0,450,706);
				Fondo.setIcon( scaleImage("/imagenes/FondoInterfazChat.jpg",450,760));
				contentPane.add(Fondo);		
		}

		public ImageIcon scaleImage(String url, int ancho , int altura) {
			ImageIcon icon = new ImageIcon(PerfilNatural2.class.getResource(url));
			Image img = icon.getImage();
			Image imgScale = img.getScaledInstance(ancho, altura, Image.SCALE_SMOOTH);
			return new ImageIcon(imgScale);

		}
		
			
}
