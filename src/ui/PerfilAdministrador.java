package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datosUsuarios.Administrador;
import datosUsuarios.Natural;
import logicaNegocio.Conexion;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class PerfilAdministrador extends JFrame{

	private int alturaPantalla;
	private int anchoPantalla;
	private JPanel contentPane;
	private Administrador organizacion;
	private boolean esAdmin;
	private Natural aficionado;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_1_2_1;
	private JLabel lblNewLabel_1_2_2;
	private JLabel lblNewLabel_1_2_3;
	private JLabel lblNewLabel_1_2_4;
	private JLabel lblNewLabel_1_2_5;
	private JLabel lblNewLabel_1_2_6;
	private JLabel lblNewLabel_1_2_7;

	public PerfilAdministrador(Administrador organizacion,boolean esAdmin) {
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
	/**
	 * @wbp.parser.constructor
	 */
	public PerfilAdministrador(Natural aficionado,boolean esAdmin) {
		this.esAdmin=esAdmin;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,450,745);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.aficionado = aficionado;
		createBigMenu(esAdmin);
    Inicio(esAdmin);
	}

public void Inicio(boolean esAdmin) {
	 lblNewLabel = new JLabel("nombre :");
	lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setBounds(51, 66, 353, 25);
	contentPane.add(lblNewLabel);
	
	 lblNewLabel_1 = new JLabel("nacimiento:");
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 15));
	lblNewLabel_1.setBounds(51, 114, 353, 25);
	contentPane.add(lblNewLabel_1);
	
	 lblNewLabel_1_1 = new JLabel("Género: ");
	lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 15));
	lblNewLabel_1_1.setBounds(51, 162, 353, 25);
	contentPane.add(lblNewLabel_1_1);
	
	 lblNewLabel_1_2 = new JLabel("Dirección: ");
	lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1_2.setFont(new Font("Dialog", Font.BOLD, 15));
	lblNewLabel_1_2.setBounds(51, 210, 353, 25);
	contentPane.add(lblNewLabel_1_2);
	
	 lblNewLabel_1_2_1 = new JLabel("Teléfono: ");
	lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1_2_1.setFont(new Font("Dialog", Font.BOLD, 15));
	lblNewLabel_1_2_1.setBounds(51, 258, 353, 25);
	contentPane.add(lblNewLabel_1_2_1);
	
	 lblNewLabel_1_2_2 = new JLabel("Descripción: ");
	lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1_2_2.setFont(new Font("Dialog", Font.BOLD, 15));
	lblNewLabel_1_2_2.setBounds(51, 306, 353, 25);
	contentPane.add(lblNewLabel_1_2_2);

	 lblNewLabel_1_2_3 = new JLabel("URL: ");
	lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel_1_2_2.setFont(new Font("Dialog", Font.BOLD, 15));
	lblNewLabel_1_2_2.setBounds(51, 306, 353, 25);
	contentPane.add(lblNewLabel_1_2_3);

        
        if(esAdmin){
        	lblNewLabel.setText("Nombre : "+ this.organizacion.getNombre());
        	lblNewLabel_1.setText("Fecha de creacion: "+ this.organizacion.getNacimiento());
        	lblNewLabel_1_1.setText("Dirección: "+ this.organizacion.getDireccion());
        	lblNewLabel_1_2.setText("Telefono : "+ this.organizacion.getTelefono());
        	lblNewLabel_1_2_1.setText("Descripcion : "+ this.organizacion.getDescripcion());
        	lblNewLabel_1_2_2.setText("URL : "+ this.organizacion.getUrlPagina());
}else{
	lblNewLabel.setText("Nombre : "+ this.aficionado.getNombre());
	lblNewLabel_1.setText("Nacimiento: "+ this.aficionado.getNacimiento());
	lblNewLabel_1_1.setText("Genero : "+ this.aficionado.getGenero());
	lblNewLabel_1_2.setText("Dirección: "+ this.aficionado.getDireccion());
	lblNewLabel_1_2_1.setText("Telefono : "+ this.aficionado.getTelefono());
	lblNewLabel_1_2_2.setText("Descripcion : "+ this.aficionado.getDescripcion());
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
				Contactos.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						try {
							Usuario frame = new Usuario(esAdmin);
							frame.setVisible(true);
							Conexion conec = new Conexion();
							Connection conexion = conec.Conectar();
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
					dispose();
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
		
			JButton Inicio = new JButton("Inicio");
			Inicio.setVerticalTextPosition(SwingConstants.BOTTOM);
			Inicio.setHorizontalTextPosition(SwingConstants.CENTER);
			Inicio.setContentAreaFilled(false);
			Inicio.setBorderPainted(false);
			Inicio.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {	
					dispose();
					if(esAdmin) {
                PerfilNatural2 frame = new PerfilNatural2(organizacion, 1);
					frame.setVisible(true);}
					else {  PerfilNatural2 frame = new PerfilNatural2(aficionado, 0);
					frame.setVisible(true);}
					}

			});
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
}
