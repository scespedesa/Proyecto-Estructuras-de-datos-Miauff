package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datosUsuarios.Natural;

import javax.swing.JLabel;

public class PerfilNatural extends JFrame{

	private int alturaPantalla;
	private int anchoPantalla;
	private JPanel panel;

	public PerfilNatural(Natural e, String nose) {
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Dimension dimension= pantalla.getScreenSize();
		this.alturaPantalla= dimension.height;
		this.anchoPantalla = dimension.width;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(anchoPantalla/3, 10 , 450, 706);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Perfil Admin");
		setResizable(false);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.DARK_GRAY);
		panel.setBounds(0, 0,450, 706);
		contentPane.add(panel);
		panel.setLayout(null);
			
		JLabel jijo = new JLabel("<html>" +"estoe es un intent " + "\n"+ "lo otroo jajajajajajajajajagrt"+ "\n"+ "ggtrfgggggggggggggggggggggggggggggggggggg"
				+ "+ \"\\n\"+ ggggggggggggggggggggggggggggggggggggg"
				+ "gggggggggggggggggggggggggggggggggggggggggggggggggj"+"<html>");
		jijo.setBounds(0, 11, 434, 284);
		panel.add(jijo);
		
		JLabel lblfondo = new JLabel("New label");	
		lblfondo.setBounds(0, 0, 434, 667);
		ImageIcon ji = scaleImage("/imagenes/fondi (1).png", lblfondo.getWidth(),lblfondo.getHeight()) ;
		lblfondo.setIcon(ji);
		panel.add(lblfondo);
	

	}
	public ImageIcon scaleImage(String url, int ancho , int altura) {
		ImageIcon icon = new ImageIcon(RegistroPersonas.class.getResource(url));
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(ancho, altura, Image.SCALE_SMOOTH);
		return new ImageIcon(imgScale);

	}
}

		
		/*
		if(tipo!="propio") {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}else {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		setBounds(100, 100, 600, 600);

		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(UIManager.getColor("window"));
		panel.setBounds(0, 35, 572, 160);
		contentPane.add(panel);
		panel.setLayout(null);


		JLabel lblnombre = new JLabel("Nombre: ".concat(persona.getNombre()));
		lblnombre.setBounds(164, 14, 243, 20);
		panel.add(lblnombre);

	

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(119, 136, 153));
		panel_1.setBounds(0, 0, 572, 36);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		//**********lista clickeable*********
		if(tipo.equals("propio")) {
			JComboBox comboBox = new JComboBox();
			av = new Averiguar ();
			creacionCombo(comboBox,av.listaCombo(1));
			comboBox.setBounds(158, 5, 241, 22);
			panel_1.add(comboBox);
			JLabel lblimagenBusqueda = new JLabel("New label");
			lblimagenBusqueda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lblimagenBusqueda.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String nombre = (String) comboBox.getSelectedItem();
					for(Empleador a : av.getEmpleadores()) {
						if(a.getNombre().equals(nombre)) {
							mirar = a ;
							break;
						}
					}if(mirar!=null) {
						PerfilEmpleador ver = new PerfilEmpleador(mirar,"no propio");
						ver.setVisible(true);
					}
				}
			});

			lblimagenBusqueda.setBounds(410, 5, 24, 22);
			lblimagenBusqueda.setIcon(setIcono("/imagenes/Recurso 30@3x.png",lblimagenBusqueda,true));
			panel_1.add(lblimagenBusqueda);

		}


		JLabel lblfoto = new JLabel();
		lblfoto.setBounds(10, 14, 107, 99);
		if (persona.getUrlFoto()==null) {
			System.out.println("icono default");
			lblfoto.setIcon(setIcono("/imagenes/profile.PNG",lblfoto,true));
		}else {
			System.out.println("icono foto" + persona.getUrlFoto());
			lblfoto.setIcon(setIcono(persona.getUrlFoto(),lblfoto,false));
		}
		panel.add(lblfoto);

		JLabel lbllogo = new JLabel("New label");
		lbllogo.setBounds(10, 5, 92, 22);
		lbllogo.setIcon(setIcono("/imagenes/Recurso 41.png",lbllogo,true));
		panel_1.add(lbllogo);

		JLabel lblicon1 = new JLabel();
		lblicon1.setBounds(438, 49, 27, 25);
		panel.add(lblicon1);
		lblicon1.setIcon(setIcono("/imagenes/Capa 5 (7)@3x.png",lblicon1,true));

		JLabel lblicon = new JLabel();
		lblicon.setBounds(438, 85, 27, 25);
		panel.add(lblicon);
		lblicon.setIcon(setIcono("/imagenes/Recurso 23@3x.png",lblicon,true));

		JLabel lbliconhomunculo = new JLabel("");
		lbliconhomunculo.setBounds(438, 14, 27, 25);
		panel.add(lbliconhomunculo);
		lbliconhomunculo.setIcon(setIcono("/imagenes/hombre.png",lbliconhomunculo,true));

		JLabel sexo = new JLabel(persona.getSexo());
		sexo.setBounds(164, 109, 240, 20);
		panel.add(sexo);

		JLabel lblwa = new JLabel("New label");
		accionWa(lblwa);
		lblwa.setBounds(46, 124, 27, 25);
		lblwa.setIcon(setIcono("/imagenes/wa.png",lblwa,true));
		panel.add(lblwa);

		panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("window"));
		panel_2.setBounds(0, 206, 572, 155);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lbltextoFondo = new JLabel("Perfil profesional");
		lbltextoFondo.setOpaque(true);
		lbltextoFondo.setHorizontalAlignment(SwingConstants.CENTER);
		lbltextoFondo.setForeground(Color.WHITE);
		lbltextoFondo.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		lbltextoFondo.setBackground(SystemColor.infoText);
		lbltextoFondo.setBounds(0, 0, 180, 35);
		panel_2.add(lbltextoFondo);

		JLabel lblperfil = new JLabel("<html>".concat(persona.getDescripcion()).concat("<html>"));
		lblperfil.setBounds(243, 71, 219, 70);
		panel_2.add(lblperfil);

		JLabel lblvariado = new JLabel("New label");
		lblvariado.setBounds(190, 0, 219, 35);
		lblvariado.setIcon(setIcono("/imagenes/Capa 5 (4)@3x.png",lblvariado,true));
		panel_2.add(lblvariado);

		JLabel hojaDeVida = new JLabel("Hoja de vida");
		hojaDeVida.setBounds(23, 84, 114, 35);
		accionHoja(hojaDeVida);
		panel_2.add(hojaDeVida);
		hojaDeVida.setIcon(setIcono("/imagenes/hoja.png",hojaDeVida,true));
		panel_3 = new JPanel();
		panel_3.setBackground(UIManager.getColor("window"));
		panel_3.setBounds(0, 372, 572, 155);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblestudios = new JLabel("<html>".concat("eddw".concat("<html>")));
		lblestudios.setBounds(31, 83, 250, 61);
		panel_3.add(lblestudios);

		JLabel lblvideo = new JLabel("video");
		lblvideo.setBounds(468, 92, 40, 35);
		lblvideo.setIcon(setIcono("/imagenes/Capa 5 (7)@3x.png",lblvideo,true));
		panel_3.add(lblvideo);

		JLabel label = new JLabel("Trayectoria profesional y academica");
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(240, 248, 255));
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		label.setBackground(SystemColor.infoText);
		label.setAutoscrolls(true);
		label.setBounds(0, 0, 300, 35);
		panel_3.add(label);

		JLabel lbltra = new JLabel("New label");
		lbltra.setBounds(310, 4, 132, 30);
		lbltra.setIcon(setIcono("/imagenes/Capa 5 (6)@3x.png",lbltra,true));
		panel_3.add(lbltra);

		JLabel lbledu = new JLabel("New label");
		lbledu.setBounds(65, 39, 172, 35);
		lbledu.setIcon(setIcono("/imagenes/Recurso 13@3x.png",lbledu,true));
		panel_3.add(lbledu);

		JLabel lblcertificado = new JLabel("New label");
		lblcertificado.setBounds(462, 2, 46, 35);
		lblcertificado.setIcon(setIcono("/imagenes/Capa 5 (5)@3x.png",lblcertificado,true));
		panel_3.add(lblcertificado);

		JLabel lblNewLabel = new JLabel("Video");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblNewLabel.setBounds(462, 70, 46, 14);
		panel_3.add(lblNewLabel);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);
		if(tipo.equals("propio")) {
			JMenu mnNewMenu_1 = new JMenu("Perfil                                            ");
			mnNewMenu_1.setHorizontalAlignment(SwingConstants.LEFT);
			mnNewMenu_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
			menuBar.add(mnNewMenu_1);

			JMenuItem mntmNewMenuItem_3 = new JMenuItem("Editar perfil");
			mntmNewMenuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lblwa.removeMouseListener(wa);
					lblvideo.removeMouseListener(vi);
					hojaDeVida.removeMouseListener(ho);
					mejorarPerfil(lblnombre, "nombre");	
					mejorarPerfil(lblprofesion, "profesion");
					mejorarPerfil(lblresidencia, "lugar de residencia");
					mejorarPerfil(lblcumpleanios, "fecha de nacimiento");
					mejorarPerfil(lblestudios, "estudios");
					mejorarPerfil(lblfoto, "foto");
					mejorarPerfil(lblperfil, "perfil");
					mejorarPerfil(lblwa, "numero de whatsapp");
					mejorarPerfil(lblvideo, "video");
					mejorarPerfil(hojaDeVida, "hoja");

				}
			});
			mntmNewMenuItem_3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
			mntmNewMenuItem_3.setIgnoreRepaint(true);
			mnNewMenu_1.add(mntmNewMenuItem_3);

			JMenuItem mntmNewMenuItem_4 = new JMenuItem("Visualizar perfil");
			mntmNewMenuItem_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel.setVisible(true);
					panel_1.setVisible(true);
					panel_2.setVisible(true);
					panel_3.setVisible(true);
					visualizarPerfil(lblnombre);
					visualizarPerfil(lblprofesion);
					visualizarPerfil(lblperfil);
					visualizarPerfil(lblresidencia);
					visualizarPerfil(lblcumpleanios);
					visualizarPerfil(lblestudios);
					visualizarPerfil(lblfoto);
					visualizarPerfil(lblwa);
					visualizarPerfil(hojaDeVida);
					visualizarPerfil(lblvideo);
					accionWa(lblwa);
				
					
				}
			});
			mntmNewMenuItem_4.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
			mnNewMenu_1.add(mntmNewMenuItem_4);

			JMenuItem mntmNewMenuItem = new JMenuItem("Cerrar sesion");
			mntmNewMenuItem.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					
					System.exit(0);
				}
			});
			mntmNewMenuItem.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
			mnNewMenu_1.add(mntmNewMenuItem);

			JMenu mnNewMenu = new JMenu("Contactos");
			mnNewMenu.setHorizontalAlignment(SwingConstants.RIGHT);
			mnNewMenu.setVerticalTextPosition(SwingConstants.BOTTOM);
			mnNewMenu.setVerticalAlignment(SwingConstants.BOTTOM);
			mnNewMenu.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
			menuBar.add(mnNewMenu);

			JMenuItem mntmNewMenuItem_2 = new JMenuItem("Ir a lista de contactos");
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel.setVisible(false);
					panel_1.setVisible(false);
					panel_2.setVisible(false);
					panel_3.setVisible(false);
					//ContactosDeEmpleados tc = new ContactosDeEmpleados(av.getNombres(), av.getEmpleadores());
					//tc.setVisible(true);
					//contentPane.add(tc);

				}
			});
			mntmNewMenuItem_2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 12));
			mnNewMenu.add(mntmNewMenuItem_2);

		}else {
			JMenu mnNewMenu_1 = new JMenu("Menu                                            ");
			mnNewMenu_1.setHorizontalAlignment(SwingConstants.LEFT);
			mnNewMenu_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
			menuBar.add(mnNewMenu_1);
			JMenuItem volver = new JMenuItem("Volver al perfil ");
			volver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			volver.setHorizontalAlignment(SwingConstants.LEFT);
			volver.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
			mnNewMenu_1.add(volver);
		}
	}private void accionWa(JLabel lblwa ) {
		lblwa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblwa.addMouseListener(wa = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(persona.getTelefono()!=null) {
					String urlWa = "https://wa.me/57".concat(persona.getTelefono());
					new AbrirSitioWeb(urlWa);
				}
			}
		});
		
		
	}public void creacionCombo(JComboBox caja, String[] lista) {
		caja.setBackground(Color.WHITE);
		caja.setModel(new DefaultComboBoxModel(lista));
		caja.setEditable(true);
		caja.setSelectedItem("");
		AutoCompleteDecorator.decorate(caja);
	}

	public void generacionContactar() {
		JLabel lblconectar = new JLabel();
		lblconectar.setBounds(463, 94, 67, 20);
		lblconectar.setIcon(setIcono("/imagenes/conectar.png",lblconectar,true));
		panel.add(lblconectar);
	}

	public Icon setIcono(String url , JLabel label, boolean esta){	
		int ancho = label.getWidth();
		int alto = label.getHeight();
		if (esta) {
			ImageIcon icon= new ImageIcon(getClass().getResource(url));
			ImageIcon icono= new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
			return icono ;
		}else {
			ImageIcon icon= new ImageIcon(url);
			ImageIcon icono= new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
			return icono ;
		}
	}

	public void mejorarPerfil(JLabel j, String dato) {
		mouseListenerIsActive = true;
		j.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		j.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(mouseListenerIsActive) {
					if(dato.equals("foto")) {
						BusquedaArchivos b = new BusquedaArchivos();
						String url = b.busqueda(e, panel);
						persona.setUrlFoto(url);
						j.setIcon(setIcono(url,j,false));
					}else if(dato.equals("hoja")) {
						BusquedaArchivos t = new BusquedaArchivos() ;
						persona.setUrlHoja(t.busqueda(e,panel));
					}else {
						String input = JOptionPane.showInputDialog("Escribe el " + dato + " nuevo");
						JOptionPane.showMessageDialog(null, dato + " ingresado :  " + input);
						/*
						if(input!=null) {
							if(dato.equals("nombre")) {
								persona.setNombre(input);
								j.setText("Nombre: ".concat(input));
							}else if(dato.equals("lugar de residencia")) {
								persona.setLugarResidencia(input);
								j.setText("Lugar de residencia: ".concat(input));
							}else if(dato.equals("estudios")) {
								persona.setEstudios(input);
								j.setText("<html>".concat(input).concat("<html>"));					
							}else if(dato.equals("profesion")) {
								persona.setProfesion(input);
								j.setText("Profesion: ".concat(input));
							}else if (dato.equals("perfil")) {
								persona.setDescripcion(input);
								j.setText("<html>".concat(input).concat("<html>"));
							}else if (dato.equals("fecha de nacimiento")) {
								persona.setFechaNacimiento(input);
								j.setText("Fecha de nacimiento: ".concat(input));
							}else if(dato.equals("numero de whatsapp")) {
								j.removeMouseListener(wa);
								persona.setNumeroContacto(input);
							}else if(dato.equals("video")) {
								persona.setUrlVideo(input);
							}
							}
							
								
						}
					}
			}
		});
		*/	
	public void visualizarPerfil(JLabel j) {
		j.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mouseListenerIsActive = false;
	}
	public ImageIcon scaleImage(String url, int ancho , int altura) {
		ImageIcon icon = new ImageIcon(RegistroPersonas.class.getResource(url));
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(ancho, altura, Image.SCALE_SMOOTH);
		return new ImageIcon(imgScale);

	}

	

}
