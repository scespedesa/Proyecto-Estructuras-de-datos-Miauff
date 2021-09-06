package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;



import dataStructures.Heap;
import dataStructures.ListaDoblementeEnlazada;
import dataStructures.MyArrayList;
import datosMascotas.MascotasAdopcion;
import logicaNegocio.Conexion;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class AdoptarMascota extends JFrame implements Runnable {

	private JPanel contentPane;
	private int filtroGenero;
	private int filtroEdad;
	private int filtroTiempo;
	public static int numFila=0;
	public static int variableScroll=0;
	public static int variableScroll2=0;
	public static int variable=0;
	static int totalDeMascotasParaAdoptar=0;

	static int posicionEnY=0;
	static int posicionEnY2=0;
	
	public static int id;
	public static String name;
	public static int age;
	public static String descripcionFisica ;
	public static String descripcionCon ;
	public static ImageIcon fotoEnviar;
	public static String r;
	public static int conteo=10;
	private ListaDoblementeEnlazada<Object> listad= new ListaDoblementeEnlazada<Object> ();

	/**
	 * Launch the application.
	 */
	public void correr() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdoptarMascota frame = new AdoptarMascota();
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
	public AdoptarMascota() {
		
		
		JButton button = new JButton("New button");
		getContentPane().add(button, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(3, 10 , 450, 706);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		JPanel panelFiltro = new JPanel();
		panelFiltro.setBackground(Color.LIGHT_GRAY);
		panelFiltro.setBounds(86, 145, 259, 400);
		
		panelFiltro.setLayout(null);

		//contentPane.add(panelFiltro);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 63);
		panel.setBackground(new Color(154, 205, 50));
		contentPane.add(panel);
		panel.setLayout(null);
		

		
		

		JScrollPane x2= new JScrollPane();
		x2.setBounds(34,293,396,372);
		//x2.setViewportView(panel_2);
		
		
		
		//contentPane.add(x2);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);

		JScrollPane x3= new JScrollPane();
		

		//panel_3.setPreferredSize(new Dimension(259,(154*2)));
		panel_3.setLayout(null);
		JButton btnMas = new JButton("mas");
		btnMas.setBackground(Color.WHITE);

		btnMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				

				String tipo="";
				ImageIcon imagen =null;
				ImageIcon imagenSeleccionada =null;
				
				Conexion conec= new Conexion();
				Connection conexion = conec.Conectar();
				try {
					int idAnimal=variable;
					//"select  TIPO from ANIMALES"
					Statement ps =  conexion.createStatement();
					ResultSet rs = ps.executeQuery("select  TIPO,EDAD,NOMBRE,IDANIMAL,ADMIN,DES_FISICA,DES_COND,RAZA from ANIMALES join USUARIOS USING (USER) WHERE ADMIN != 0 and IDANIMAL>"+idAnimal+" LIMIT 10");
			
		
					while(rs.next()) {
							
							totalDeMascotasParaAdoptar++;
							System.out.println(totalDeMascotasParaAdoptar);
							if(rs.getString(1).equals("perro")) {
								tipo="perro";
								imagen = scaleImage("/Imagenes/ImagenPerro.jpg",315,154);
								imagenSeleccionada = scaleImage("/Imagenes/ImagenPerroSeleccionado.jpg",315,154);
								
							}
							
							if(rs.getString(1).equals("gato")){
								tipo="gato";
								 imagen = scaleImage("/Imagenes/ImagenGato.png",315,154);
								 imagenSeleccionada = scaleImage("/Imagenes/ImagenGatoSeleccionado.png",420,154);
							}
							if(rs.getString(1).equals("conejo")) {
								tipo="conejo";
								imagen = scaleImage("/Imagenes/ImagenConejo.jpg",315,154);
								imagenSeleccionada= scaleImage("/Imagenes/ImagenConejoSeleccionado.png",420,154);;
							}
							if(rs.getString(1).equals("pez")) {
								tipo="pez";
								imagen = scaleImage("/Imagenes/ImagenConejo.jpg",315,154);
								imagenSeleccionada= scaleImage("/Imagenes/ImagenConejo.jpg",420,154);;
							}
					
							JLabel imagenMascota = new JLabel();
							imagenMascota.setFont(new Font("Century Gothic", Font.BOLD, 17));
							imagenMascota.setForeground(Color.WHITE);
							imagenMascota.setBounds(0, posicionEnY, 420, 154);
							imagenMascota.setIcon(imagen);
							imagenMascota.setText(rs.getString(4));
							
							JLabel nombre = new JLabel();
							nombre.setFont(new Font("Dialog", Font.BOLD, 13));
							nombre.setForeground(new Color(154, 205, 50));
							nombre.setText( rs.getString(3));
							nombre.setBounds(340, 20+posicionEnY, 100, 41);
							
							JLabel edad = new JLabel("edad");
							edad.setFont(new Font("Dialog", Font.BOLD, 13));
							edad.setForeground(new Color(154, 205, 50));
							edad.setBounds(340, 100+posicionEnY, 100, 41);
							edad.setText(rs.getString(2));
							posicionEnY+=154;
							panel_3.add(nombre);
							panel_3.add(edad);
							panel_3.add(imagenMascota);
											
							JLabel descripcionF= new JLabel(rs.getString(6));
							JLabel descripcionC= new JLabel(rs.getString(7));
							JLabel raza= new JLabel(rs.getString(8));
		
					
							
							imagenMascota.setBorder(BorderFactory.createLineBorder(Color.black,1));
							imagenMascota.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									System.out.println(imagenMascota.getText());
									
									fotoEnviar= (ImageIcon) imagenMascota.getIcon();
									descripcionCon=descripcionC.getText();
									name=nombre.getText();
									age=Integer.parseInt(edad.getText());
									descripcionFisica= descripcionF.getText(); 
									id=Integer.parseInt( imagenMascota.getText());
									r=raza.getText();
									
		
									FormularioAdopcion formulario = new FormularioAdopcion();
									
									formulario.correr();
									variableScroll=0;
									posicionEnY=0;
									dispose();
									
									
									
								}
							});
							
							//btnNewButton.setRolloverIcon(imagenSeleccionada);
						

							
							int variable=rs.getInt(4);
					}
					
					
			
					
				} catch (SQLException e1) {	
					e1.printStackTrace();
				
				}
		
				
				variableScroll+=10;
				panel_3.setPreferredSize(new Dimension(259,(154*(variableScroll+1)-124)));
				x3.setViewportView(panel_3);
				
				System.out.println("numFila"+numFila);
				
	
			
				btnMas.setBounds(0,154*(variableScroll),428 , 30 );
				
			}
		});
		
		
		panel_3.setLayout(null);
		
		panel_3.add(btnMas);
		
		btnMas.setBounds(0, 0,428 , 30 );

		
		
		x3.setBounds(0,235,430,430);
		x3.setViewportView(panel_3);
		contentPane.add(x3);
		
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setLayout(null);
		panel_4.setPreferredSize(new Dimension(259,(154*(0)-124)));
		JScrollPane x4= new JScrollPane();
		x4.setBounds(0,235,430,430);
		
		contentPane.add(x4);
		
		JLabel lblNewLabel = new JLabel("MENU DE ADOPCION");
	
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(143, 11, 225, 41);
		panel.add(lblNewLabel);
		
		JCheckBox checkPrioridad = new JCheckBox("Filtrar por prioridad");
	
		checkPrioridad.setForeground(SystemColor.window);
		checkPrioridad.setBackground(new Color(154, 205, 50));
		checkPrioridad.setBounds(0, 0, 137, 23);
		panel.add(checkPrioridad);
		
		JPanel panel_1 = new JPanel();
		
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setPreferredSize(new Dimension(585,126));
		JScrollPane x= new JScrollPane();
		x.setEnabled(false);
		x.setBounds(0,66,480,170);
		x.setViewportView(panel_1);
		
		
		
		panel_1.setLayout(null);
		
		/*
	
	    JPanel panelPerros = new JPanel();
	    panelPerros=porAnimal("conejo");	
		
		x2.setViewportView(panelPerros);
		
		JPanel panelGatos= new JPanel();
		panelGatos=porAnimal("gato");		
		
		JPanel panelConejo= new JPanel();
		panelConejo=porAnimal("conejo");	
		
		JPanel panelPez= new JPanel();
		panelPez=porAnimal("pez");		
		*/
		JButton btnPerro = new JButton("Perro");
		btnPerro.setEnabled(false);
		btnPerro.setBackground(Color.WHITE);
		

		
		
		btnPerro.addActionListener(new ActionListener() {
			

			
			public void actionPerformed(ActionEvent e) {		
				
				panel_4.removeAll();
				variableScroll2=0;
				posicionEnY2=0;
				Conexion conec1= new Conexion();
				Connection conexion2 = conec1.Conectar();
				System.out.println("si");
				Heap hp= new Heap();
				hp.glob.clear();
				hp.globarr.clear();
				Statement ps;
				try {
					ArrayList big_arr= new ArrayList<Integer>();
					ImageIcon imagen = scaleImage("/Imagenes/ImagenPerro.jpg",315,154);
					
					ps = conexion2.createStatement();
					ResultSet re = ps.executeQuery("select * from ANIMALES join USUARIOS using(USER) where TIPO = 'perro' and ADMIN = 1 limit 50");
					
			/////////////////////////////////////////////////////////////////////////
					while(re.next()){
						MascotasAdopcion madop= new MascotasAdopcion(re.getInt(2),re.getString(3),re.getString(4), re.getString(5), re.getString(6), re.getInt(7),re.getString(1),re.getInt(8),re.getInt(9),re.getString(10),re.getString(11));
						listad.pushBack(re.getString(3));
						
						hp.insert(hp.globarr, re.getInt(7), madop);

						
					}
			////////////////////////////////////////////////////////////////////////
					long startTime = System.nanoTime();
					long stopTime = System.nanoTime();
					MascotasAdopcion madop= new MascotasAdopcion(0, "", "", "", "", 0, "", 0, 0, "", "");
					hp.insert(hp.globarr, 0, madop);
					System.out.println("Adoptar Mascota Insert: "+ (stopTime - startTime));
					hp.deleteNode(hp.globarr, 0, madop);
					
					
					/*for(int ji=0; ji< conteo; ji++) {
						MascotasAdopcion madop1= new MascotasAdopcion(0, "", "", "", "", 0, "", 0, 0, "", "");
						hp.insert(hp.globarr, 0, madop1);
					}
					
					MascotasAdopcion madp= new MascotasAdopcion(0, "", "", "", "", 0, "", 0, 0, "", "");
					hp.insert(hp.globarr, 60, madp);
					startTime = System.nanoTime();
					hp.deleteNode(hp.globarr, 0, madp);
					stopTime = System.nanoTime();
					System.out.println("Adoptar Mascota delete: "+ (stopTime - startTime));
					hp.globarr.clear();*/
			////////////////////////////////////////////////////////////////////////
					System.out.println(hp.globarr);
					int conta= 0;
					for (MascotasAdopcion o: hp.glob) {
						
						conta++;
						if (conta== hp.glob.size()) {
							System.out.println("si");
							break;
						} else {
							System.out.println(hp.globarr.toString());
							JLabel imagenMascota2 = new JLabel();
						imagenMascota2.setFont(new Font("Century Gothic", Font.BOLD, 17));
						imagenMascota2.setForeground(Color.WHITE);
						imagenMascota2.setBounds(0, posicionEnY2, 420, 154);
						imagenMascota2.setIcon(imagen);
						imagenMascota2.setText(String.valueOf(o.getId()));
						
						JLabel nombre = new JLabel();
						nombre.setFont(new Font("Dialog", Font.BOLD, 13));
						nombre.setForeground(new Color(154, 205, 50));
						nombre.setText( o.getNombre());
						nombre.setBounds(340, 20+posicionEnY2, 100, 41);
						
						JLabel edad = new JLabel("edad");
						edad.setFont(new Font("Dialog", Font.BOLD, 13));
						edad.setForeground(new Color(154, 205, 50));
						edad.setBounds(340, 100+posicionEnY2, 100, 41);
						edad.setText(String.valueOf( o.getEdad()));
						posicionEnY2+=154;
						panel_4.add(nombre);
						panel_4.add(edad);
						panel_4.add(imagenMascota2);
						
						
						JLabel descripcionF= new JLabel(o.getDescripcionfisica());
						JLabel descripcionC= new JLabel(o.getDescripcionCondicion());
						JLabel raza= new JLabel(o.getRaza());

	
			
			imagenMascota2.setBorder(BorderFactory.createLineBorder(Color.black,1));
			imagenMascota2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println(imagenMascota2.getText());
					
					fotoEnviar= (ImageIcon) imagenMascota2.getIcon();
					descripcionCon=descripcionC.getText();
					name=nombre.getText();
					age=Integer.parseInt(edad.getText());
					descripcionFisica= descripcionF.getText(); 
					id=Integer.parseInt( imagenMascota2.getText());
					r=raza.getText();
					

					FormularioAdopcion formulario = new FormularioAdopcion();
					
					formulario.correr();
					variableScroll2=0;
					posicionEnY2=0;
					dispose();
					
					
					
				}
			});
			
			//btnNewButton.setRolloverIcon(imagenSeleccionada);
		

			
			int variable=o.getId();	
					
						}
						}
					
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}
		
		
				variableScroll2+=10;
				panel_4.setPreferredSize(new Dimension(259,(154*( hp.glob.size()))));
				x4.setViewportView(panel_4);
				x4.setVisible(true);
			
				System.out.println("numFila"+numFila);
				long startTime3 = System.nanoTime();
				long stopTime3 = System.nanoTime();	


				listad.topFront();

				System.out.println("AdoptarMascotas Top: "+ (stopTime3 - startTime3));

				long startTime = System.nanoTime();
				long stopTime = System.nanoTime();
				
				//for(int i=0; i<conteo;i++){

				//}
				
				listad.popBack();
/////////////////////////////////////////////////////////

				System.out.println("AdoptarMascotas popBack: "+ (stopTime - startTime));
			


				//btnMas.setBounds(0,154*(),428 , 30 );
				contentPane.updateUI();
				
			}
		});
		btnPerro.setBounds(0, 0, 140, 151);
		panel_1.add(btnPerro);
		x4.setViewportView(panel_4);
		JButton btnConejo = new JButton("Conejo");
		btnConejo.setEnabled(false);
		btnConejo.setBackground(Color.WHITE);
		btnConejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				panel_4.removeAll();
				variableScroll2=0;
				posicionEnY2=0;
				Conexion conec1= new Conexion();
				Connection conexion2 = conec1.Conectar();
				System.out.println("si");
				Heap hp= new Heap();
				hp.glob.clear();
				hp.globarr.clear();
				Statement ps;
				try {
					ArrayList big_arr= new ArrayList<Integer>();
					ImageIcon imagen = scaleImage("/Imagenes/ImagenConejo.jpg",315,154);
					
					ps = conexion2.createStatement();
					ResultSet re = ps.executeQuery("select * from ANIMALES join USUARIOS using(USER) where TIPO = 'conejo' and ADMIN = 1 limit 50");
					while(re.next()){
						MascotasAdopcion madop= new MascotasAdopcion(re.getInt(2),re.getString(3),re.getString(4), re.getString(5), re.getString(6), re.getInt(7),re.getString(1),re.getInt(8),re.getInt(9),re.getString(10),re.getString(11));
						hp.insert(hp.globarr, re.getInt(7), madop);
					}
					MascotasAdopcion madop= new MascotasAdopcion(0, "", "", "", "", 0, "", 0, 0, "", "");
					hp.insert(hp.globarr, 0, madop);
					System.out.println(hp.globarr);
					int conta= 0;
					for (MascotasAdopcion o: hp.glob) {
						
						conta++;
						if (conta== hp.glob.size()) {
							System.out.println("si");
							break;
						} else {
							System.out.println(hp.globarr.toString());
							JLabel imagenMascota2 = new JLabel();
						imagenMascota2.setFont(new Font("Century Gothic", Font.BOLD, 17));
						imagenMascota2.setForeground(Color.WHITE);
						imagenMascota2.setBounds(0, posicionEnY2, 420, 154);
						imagenMascota2.setIcon(imagen);
						imagenMascota2.setText(String.valueOf(o.getId()));
						
						JLabel nombre = new JLabel();
						nombre.setFont(new Font("Dialog", Font.BOLD, 13));
						nombre.setForeground(new Color(154, 205, 50));
						nombre.setText( o.getNombre());
						nombre.setBounds(340, 20+posicionEnY2, 100, 41);
						
						JLabel edad = new JLabel("edad");
						edad.setFont(new Font("Dialog", Font.BOLD, 13));
						edad.setForeground(new Color(154, 205, 50));
						edad.setBounds(340, 100+posicionEnY2, 100, 41);
						edad.setText(String.valueOf( o.getEdad()));
						posicionEnY2+=154;
						panel_4.add(nombre);
						panel_4.add(edad);
						panel_4.add(imagenMascota2);
						
						
						JLabel descripcionF= new JLabel(o.getDescripcionfisica());
						JLabel descripcionC= new JLabel(o.getDescripcionCondicion());
						JLabel raza= new JLabel(o.getRaza());

	
			
			imagenMascota2.setBorder(BorderFactory.createLineBorder(Color.black,1));
			imagenMascota2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println(imagenMascota2.getText());
					
					fotoEnviar= (ImageIcon) imagenMascota2.getIcon();
					descripcionCon=descripcionC.getText();
					name=nombre.getText();
					age=Integer.parseInt(edad.getText());
					descripcionFisica= descripcionF.getText(); 
					id=Integer.parseInt( imagenMascota2.getText());
					r=raza.getText();
					

					FormularioAdopcion formulario = new FormularioAdopcion();
					
					formulario.correr();
					variableScroll2=0;
					posicionEnY2=0;
					dispose();
					
					
					
				}
			});
			
			//btnNewButton.setRolloverIcon(imagenSeleccionada);
		

			
			int variable=o.getId();	
					
						}
						}
					
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}
		
		
				variableScroll2+=10;
				panel_4.setPreferredSize(new Dimension(259,(154*( hp.glob.size()))));
				x4.setViewportView(panel_4);
				x4.setVisible(true);
			
				System.out.println("numFila"+numFila);
				
				
			
				//btnMas.setBounds(0,154*(),428 , 30 );
				contentPane.updateUI();
				
			}
		});
		btnConejo.setBounds(137, 0, 140, 151);
		panel_1.add(btnConejo);
		
		JButton btnGato = new JButton("Gato");
		btnGato.setEnabled(false);
		btnGato.setBackground(Color.WHITE);
		btnGato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				panel_4.removeAll();
				variableScroll2=0;
				posicionEnY2=0;
				Conexion conec1= new Conexion();
				Connection conexion2 = conec1.Conectar();
				System.out.println("si");
				Heap hp= new Heap();
				hp.glob.clear();
				hp.globarr.clear();
				Statement ps;
				try {
					ArrayList big_arr= new ArrayList<Integer>();
					ImageIcon imagen = scaleImage("/Imagenes/ImagenGato.png",315,154);
					
					ps = conexion2.createStatement();
					ResultSet re = ps.executeQuery("select * from ANIMALES join USUARIOS using(USER) where TIPO = 'gato' and ADMIN = 1 limit 50");
					while(re.next()){
						MascotasAdopcion madop= new MascotasAdopcion(re.getInt(2),re.getString(3),re.getString(4), re.getString(5), re.getString(6), re.getInt(7),re.getString(1),re.getInt(8),re.getInt(9),re.getString(10),re.getString(11));
						hp.insert(hp.globarr, re.getInt(7), madop);
					}
					MascotasAdopcion madop= new MascotasAdopcion(0, "", "", "", "", 0, "", 0, 0, "", "");
					hp.insert(hp.globarr, 0, madop);
					System.out.println(hp.globarr);
					int conta= 0;
					for (MascotasAdopcion o: hp.glob) {
						
						conta++;
						if (conta== hp.glob.size()) {
							System.out.println("si");
							break;
						} else {
							System.out.println(hp.globarr.toString());
							JLabel imagenMascota2 = new JLabel();
						imagenMascota2.setFont(new Font("Century Gothic", Font.BOLD, 17));
						imagenMascota2.setForeground(Color.WHITE);
						imagenMascota2.setBounds(0, posicionEnY2, 420, 154);
						imagenMascota2.setIcon(imagen);
						imagenMascota2.setText(String.valueOf(o.getId()));
						
						JLabel nombre = new JLabel();
						nombre.setFont(new Font("Dialog", Font.BOLD, 13));
						nombre.setForeground(new Color(154, 205, 50));
						nombre.setText( o.getNombre());
						nombre.setBounds(340, 20+posicionEnY2, 100, 41);
						
						JLabel edad = new JLabel("edad");
						edad.setFont(new Font("Dialog", Font.BOLD, 13));
						edad.setForeground(new Color(154, 205, 50));
						edad.setBounds(340, 100+posicionEnY2, 100, 41);
						edad.setText(String.valueOf( o.getEdad()));
						posicionEnY2+=154;
						panel_4.add(nombre);
						panel_4.add(edad);
						panel_4.add(imagenMascota2);
						
						
						JLabel descripcionF= new JLabel(o.getDescripcionfisica());
						JLabel descripcionC= new JLabel(o.getDescripcionCondicion());
						JLabel raza= new JLabel(o.getRaza());

	
			
			imagenMascota2.setBorder(BorderFactory.createLineBorder(Color.black,1));
			imagenMascota2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println(imagenMascota2.getText());
					
					fotoEnviar= (ImageIcon) imagenMascota2.getIcon();
					descripcionCon=descripcionC.getText();
					name=nombre.getText();
					age=Integer.parseInt(edad.getText());
					descripcionFisica= descripcionF.getText(); 
					id=Integer.parseInt( imagenMascota2.getText());
					r=raza.getText();
					

					FormularioAdopcion formulario = new FormularioAdopcion();
					
					formulario.correr();
					variableScroll2=0;
					posicionEnY2=0;
					dispose();
					
					
					
				}
			});
			
			//btnNewButton.setRolloverIcon(imagenSeleccionada);
		

			
			int variable=o.getId();	
					
						}
						}
					
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}
		
		
				variableScroll2+=10;
				panel_4.setPreferredSize(new Dimension(259,(154*( hp.glob.size()))));
				x4.setViewportView(panel_4);
				x4.setVisible(true);
			
				System.out.println("numFila"+numFila);
				
				
			
				//btnMas.setBounds(0,154*(),428 , 30 );
				contentPane.updateUI();
			}
		});
		btnGato.setBounds(276, 0, 140, 151);
		panel_1.add(btnGato);
		
		JButton btnPez = new JButton("Pez");
		btnPez.setEnabled(false);
		btnPez.setBackground(Color.WHITE);
		btnPez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	
				
				panel_4.removeAll();
				variableScroll2=0;
				posicionEnY2=0;
				Conexion conec1= new Conexion();
				Connection conexion2 = conec1.Conectar();
				System.out.println("si");
				Heap hp= new Heap();
				hp.glob.clear();
				hp.globarr.clear();
				Statement ps;
				try {
					ArrayList big_arr= new ArrayList<Integer>();
					ImageIcon imagen = scaleImage("/Imagenes/peces.jpg",315,154);
					
					ps = conexion2.createStatement();
					ResultSet re = ps.executeQuery("select * from ANIMALES join USUARIOS using(USER) where TIPO = 'pez' and ADMIN = 1 limit 50");
					while(re.next()){
						MascotasAdopcion madop= new MascotasAdopcion(re.getInt(2),re.getString(3),re.getString(4), re.getString(5), re.getString(6), re.getInt(7),re.getString(1),re.getInt(8),re.getInt(9),re.getString(10),re.getString(11));
						hp.insert(hp.globarr, re.getInt(7), madop);
					}
					MascotasAdopcion madop= new MascotasAdopcion(0, "", "", "", "", 0, "", 0, 0, "", "");
					hp.insert(hp.globarr, 0, madop);
					System.out.println(hp.globarr);
					int conta= 0;
					for (MascotasAdopcion o: hp.glob) {
						
						conta++;
						if (conta== hp.glob.size()) {
							System.out.println("si");
							break;
						} else {
							System.out.println(hp.globarr.toString());
							JLabel imagenMascota2 = new JLabel();
						imagenMascota2.setFont(new Font("Century Gothic", Font.BOLD, 17));
						imagenMascota2.setForeground(Color.WHITE);
						imagenMascota2.setBounds(0, posicionEnY2, 420, 154);
						imagenMascota2.setIcon(imagen);
						imagenMascota2.setText(String.valueOf(o.getId()));
						
						JLabel nombre = new JLabel();
						nombre.setFont(new Font("Dialog", Font.BOLD, 13));
						nombre.setForeground(new Color(154, 205, 50));
						nombre.setText( o.getNombre());
						nombre.setBounds(340, 20+posicionEnY2, 100, 41);
						
						JLabel edad = new JLabel("edad");
						edad.setFont(new Font("Dialog", Font.BOLD, 13));
						edad.setForeground(new Color(154, 205, 50));
						edad.setBounds(340, 100+posicionEnY2, 100, 41);
						edad.setText(String.valueOf( o.getEdad()));
						posicionEnY2+=154;
						panel_4.add(nombre);
						panel_4.add(edad);
						panel_4.add(imagenMascota2);
						
						
						JLabel descripcionF= new JLabel(o.getDescripcionfisica());
						JLabel descripcionC= new JLabel(o.getDescripcionCondicion());
						JLabel raza= new JLabel(o.getRaza());

	
			
			imagenMascota2.setBorder(BorderFactory.createLineBorder(Color.black,1));
			imagenMascota2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.out.println(imagenMascota2.getText());
					
					fotoEnviar= (ImageIcon) imagenMascota2.getIcon();
					descripcionCon=descripcionC.getText();
					name=nombre.getText();
					age=Integer.parseInt(edad.getText());
					descripcionFisica= descripcionF.getText(); 
					id=Integer.parseInt( imagenMascota2.getText());
					r=raza.getText();
					

					FormularioAdopcion formulario = new FormularioAdopcion();
					
					formulario.correr();
					variableScroll2=0;
					posicionEnY2=0;
					dispose();
					
					
					
				}
			});
			
			//btnNewButton.setRolloverIcon(imagenSeleccionada);
		

			
			int variable=o.getId();	
					
						}
						}
					
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}
		
		
				variableScroll2+=10;
				panel_4.setPreferredSize(new Dimension(259,(154*( hp.glob.size()))));
				x4.setViewportView(panel_4);
				x4.setVisible(true);
			
				System.out.println("numFila"+numFila);
				
				
			
				//btnMas.setBounds(0,154*(),428 , 30 );
				contentPane.updateUI();
			}
		});
		btnPez.setBounds(276+140, 0, 140, 151);
		panel_1.add(btnPez);
		contentPane.add(x);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(0, 235, 434, 430);
		contentPane.add(panel_7);
		panel_7.setLayout(null);

		
		checkPrioridad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!checkPrioridad.isSelected()) {
					btnPerro.setEnabled(false);
					btnConejo.setEnabled(false);
					btnGato.setEnabled(false);
					btnPez.setEnabled(false);
					x4.setVisible(false);;
					x3.setVisible(true);
					contentPane.updateUI();
					
				}else {
					btnPerro.setEnabled(true);
					btnConejo.setEnabled(true);
					btnGato.setEnabled(true);
					btnPez.setEnabled(true);
					x3.setVisible(false);;
					x4.setVisible(true);;

					contentPane.updateUI();
				}
			}
		});
		
	}


	@Override
	public void run() {
		
	

		
	}
	
	/*public JPanel todosLosAnimales() {

	}*/
	
	/*
	public void todos() {
		int totalDeMascotasParaAdoptar=0;
		int posicionEnY=0;
	
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);


		String tipo="";
		ImageIcon imagen =null;
		ImageIcon imagenSeleccionada =null;
		
		Conexion conec= new Conexion();
		Connection conexion = conec.Conectar();
		try {
			int idAnimal=numFila+1;
			//"select  TIPO from ANIMALES"
			Statement ps =  conexion.createStatement();
			ResultSet rs = ps.executeQuery("select  TIPO,EDAD,NOMBRE,IDANIMAL from ANIMALES WHERE IDANIMAL>"+idAnimal+" LIMIT 10");
			
			
	
			while(rs.next()) {
					
					totalDeMascotasParaAdoptar++;
					System.out.println(totalDeMascotasParaAdoptar);
					if(rs.getString(1).equals("perro")) {
						tipo="perro";
						
					}
					
					if(rs.getString(1).equals("gato")){
						tipo="gato";
					}
					
					if(rs.getString(1).equals("conejo")) {
						tipo="conejo";
					}
					if(rs.getString(1).equals("pez")) {
						tipo="pez";
					}
			
					JButton btnNewButton = new JButton("");
					if(tipo.equals("perro")) {
						imagen = scaleImage("/Imagenes/ImagenPerro.jpg",420,154);
						imagenSeleccionada = scaleImage("/Imagenes/ImagenPerroSeleccionado.jpg",420,154);
					}
					if(tipo.equals("gato")) {
						 imagen = scaleImage("/Imagenes/ImagenGato.png",420,154);
						 imagenSeleccionada = scaleImage("/Imagenes/ImagenGatoSeleccionado.png",420,154);
					}
					if(tipo.equals("conejo")) {
						imagen = scaleImage("/Imagenes/ImagenConejo.jpg",420,154);
						imagenSeleccionada= scaleImage("/Imagenes/ImagenConejoSeleccionado.png",420,154);;
					}
					if(tipo.equals("pez")) {
						imagen = scaleImage("/Imagenes/ImagenConejo.jpg",420,154);
						imagenSeleccionada= scaleImage("/Imagenes/ImagenConejo.jpg",420,154);;
					}
				
					btnNewButton.setBounds(0, posicionEnY, 420, 154);
					btnNewButton.setIcon(imagen);
					btnNewButton.setBorder(BorderFactory.createLineBorder(Color.black,1));
					btnNewButton.setRolloverIcon(imagenSeleccionada);
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							FormularioAdopcion formulario= new FormularioAdopcion();
							formulario.correr();
						}
					});
					
					
					JLabel nombre = new JLabel();
					nombre.setFont(new Font("Century Gothic", Font.BOLD, 13));
					nombre.setForeground(new Color(154, 205, 50));
					nombre.setText("nombre: " +rs.getString(3));
					nombre.setBounds(10, 100+posicionEnY, 100, 41);
					
					JLabel edad = new JLabel("edad");
					edad.setFont(new Font("Century Gothic", Font.BOLD, 13));
					edad.setForeground(new Color(154, 205, 50));
					edad.setBounds(340, 100+posicionEnY, 100, 41);
					edad.setText("Edad: " +rs.getString(2));
					posicionEnY+=154;
					panel_3.add(nombre);
					panel_3.add(edad);
					panel_3.add(btnNewButton);
					
					
					array.pushBack(rs.getInt(4));
			}
			
			panel_3.setPreferredSize(new Dimension(259,(154*numFila)));
			panel_3.setLayout(null);
			
			
			
	
			
		} catch (SQLException e1) {	
			e1.printStackTrace();
		
		}
		

	}
	/*
	public JPanel porAnimal(String animal) {
		
	
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
	
	
		panel_2.setLayout(null);
		

		String tipo="";
		ImageIcon imagen =null;
		ImageIcon imagenSeleccionada =null;
		
		Conexion conec= new Conexion();
		Connection conexion = conec.Conectar();
		try {
			//"select  TIPO from ANIMALES"
			PreparedStatement ps =  conexion.prepareStatement("select  TIPO,EDAD,NOMBRE from ANIMALES WHERE TIPO=? ");
			ps.setString(1, animal);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
					
					totalDeMascotasParaAdoptar++;
					System.out.println(totalDeMascotasParaAdoptar);
					if(rs.getString(1).equals("perro")) {
						tipo="perro";
						imagen = scaleImage("/Imagenes/ImagenPerro.jpg",420,154);
						imagenSeleccionada = scaleImage("/Imagenes/ImagenPerroSeleccionado.jpg",420,154);
					}
					
					if(rs.getString(1).equals("gato")){
						tipo="gato";
						 imagen = scaleImage("/Imagenes/ImagenGato.png",420,154);
						 imagenSeleccionada = scaleImage("/Imagenes/ImagenGatoSeleccionado.png",420,154);
					}
					
					if(rs.getString(1).equals("conejo")) {
						tipo="conejo";
						imagen = scaleImage("/Imagenes/ImagenConejo.jpg",420,154);
						imagenSeleccionada= scaleImage("/Imagenes/ImagenConejoSeleccionado.png",420,154);;
					}
					if(rs.getString(1).equals("pez")) {
						tipo="pez";
						imagen = scaleImage("/Imagenes/ImagenPerro.jpg",420,154);
						imagenSeleccionada = scaleImage("/Imagenes/ImagenPerroSeleccionado.jpg",420,154);
					}
			
					JButton btnNewButton = new JButton("");

					btnNewButton.setBounds(0, posicionEnY, 420, 154);
					btnNewButton.setIcon(imagen);
					btnNewButton.setBorder(BorderFactory.createLineBorder(Color.black,1));
					btnNewButton.setRolloverIcon(imagenSeleccionada);
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							FormularioAdopcion formulario= new FormularioAdopcion();
							formulario.correr();
						}
					});
					
					
					JLabel nombre = new JLabel();
					nombre.setFont(new Font("Century Gothic", Font.BOLD, 13));
					nombre.setForeground(new Color(154, 205, 50));
					nombre.setText("nombre: " +rs.getString(3));
					nombre.setBounds(10, 100+posicionEnY, 100, 41);
					
					JLabel edad = new JLabel("edad");
					edad.setFont(new Font("Century Gothic", Font.BOLD, 13));
					edad.setForeground(new Color(154, 205, 50));
					edad.setBounds(340, 100+posicionEnY, 100, 41);
					edad.setText("Edad: " +rs.getString(2));
					posicionEnY+=154;
					panel_3.add(nombre);
					panel_3.add(edad);
					panel_3.add(btnNewButton);

			}
			
		} catch (SQLException e1) {	
			e1.printStackTrace();
		}
		
		panel_3.setPreferredSize(new Dimension(259,(154*numFila)));
		return panel_2;
	}
	*/
	public ImageIcon scaleImage(String url, int ancho , int altura) {
		ImageIcon icon = new ImageIcon(AdoptarMascota.class.getResource(url));
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(ancho, altura, Image.SCALE_SMOOTH);
		return new ImageIcon(imgScale);

	}
}
