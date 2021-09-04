package ui;

import java.awt.BorderLayout;
import datosMascotas.MascotasAdopcion;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import dataStructures.MyArrayList;
import datosMascotas.Mascotas;
import logicaNegocio.BusquedaArchivos;
import logicaNegocio.Lector;
import java.awt.SystemColor;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

public class RegistroMascotasAdmin extends JFrame{
	private int alturaPantalla;
	private int anchoPantalla;
	private JPanel panel ;
	private JPanel panel2 ;
	private JLabel fondoImage;
	private Image menu;
	private JPasswordField passwordField;
	private String urlFoto;
	private JTextField nombre;
	private MyArrayList<Mascotas> mascotas;
	private JComboBox raza;
	private JSpinner edadnum;

	public RegistroMascotasAdmin(String user) {
		mascotas= new MyArrayList();
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Dimension dimension= pantalla.getScreenSize();
		this.alturaPantalla= dimension.height;
		this.anchoPantalla = dimension.width;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBounds(anchoPantalla/3, 10 ,anchoPantalla/3, alturaPantalla - alturaPantalla/15);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Registro Mascotas");
		setResizable(false);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.DARK_GRAY);
		panel.setBounds(0, 0,450, 706);
		contentPane.add(panel);
		panel.setLayout(null);
		
		 panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		panel2.setForeground(Color.DARK_GRAY);
		panel2.setBounds(0, 0,450, 706);
		contentPane.add(panel2);
		panel2.setLayout(null);
		ventana(user);
}
//*************display de la ventana principal********
	public void ventana(String user) {		
		JTextField nombre = new JTextField();
		nombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nombre.setBounds(76, 157, 277, 35);
		panel.add(nombre);
		
		
		JLabel lbln = new JLabel("Nombre");
		lbln.setHorizontalAlignment(SwingConstants.CENTER);
		lbln.setFont(new Font("Dialog", Font.PLAIN, 20));
		lbln.setBounds(0, 121, 439, 35);
		panel.add(lbln);
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblTipo.setBounds(0, 196, 439, 35);
		panel.add(lblTipo);
		
		raza = new JComboBox();
		raza.setFont(new Font("Tahoma", Font.PLAIN, 14));
		raza.setEditable(true);
		raza.setBackground(Color.WHITE);
		raza.setBounds(76, 344, 277, 35);
		panel.add(raza);	

		JComboBox tipo = new JComboBox();
		tipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		String [] eleccion = new String[] {"perro", "gato", "conejo","pez"} ;
		tipo.setModel(new DefaultComboBoxModel(eleccion));
		tipo.setBounds(76,242,277,35);
		// menu de lista*********
		tipo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				String tipo1 = (String) tipo.getSelectedItem();
				Lector lee; 
				if(tipo1.equals("perro")) {
					lee= new Lector("listadoCaninos");
					lee.LecturaLineas();
					creacionCombo(raza,lee.getListadoCaninos());
				}else if (tipo1.equals("gato")) {
					lee= new Lector("listadoGatos");
					lee.LecturaLineas();
					creacionCombo(raza,lee.getListadoGatos());
				}else if (tipo1.equals("conejo")) {
					lee= new Lector("listadoConejos");
					lee.LecturaLineas();
					creacionCombo(raza,lee.getListadoConejos());
				}else if (tipo1.equals("pez")) {
					lee= new Lector("listadoPeces");
					lee.LecturaLineas();
					creacionCombo(raza,lee.getListadoPeces());
				}
			
			}
		});
		panel.add(tipo);
		
		
		JLabel lblRaza = new JLabel("Raza");
		lblRaza.setHorizontalAlignment(SwingConstants.CENTER);
		lblRaza.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblRaza.setBounds(0, 288, 439, 35);
		panel.add(lblRaza);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdad.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblEdad.setBounds(0, 401, 412, 35);
		panel.add(lblEdad);
		
		JSpinner edadnum = new JSpinner();
		edadnum.setFont(new Font("Tahoma", Font.PLAIN, 16));
		edadnum.setModel(new SpinnerNumberModel(0, 0, 25, 1));
		edadnum.setBounds(176, 447, 81, 35);
		panel.add(edadnum);
		
		JButton btnsiguiente = new JButton("Siguiente");
		btnsiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				panel.setVisible(false);
				String tipo1 = (String) tipo.getSelectedItem();
				String raza1= (String) raza.getSelectedItem();
				int edad1 = (int) edadnum.getValue();
				ventana2(tipo1,raza1,edad1,user);
			}
		});

		btnsiguiente.setBounds(256, 543, 89, 23);
		btnsiguiente.setForeground(Color.BLACK);
		btnsiguiente.setBorder(new LineBorder(new Color(119, 136, 153), 1, true));
		btnsiguiente.setBackground(new Color(253, 245, 230));
		btnsiguiente.setFont(new Font("Monospaced", Font.PLAIN, 14));
		panel.add(btnsiguiente);	
		crearFondo(true);
		
	}
	private void ItemStateChanged(java.awt.event.ItemEvent evt) {
		//if(evt.getItemSelectable())
	}
	
	public void ventana2(String tipo1,String raza1, int edad1,String user) {
		panel2.setVisible(true);
		JLabel lblDescripcionFisica = new JLabel("Descripcion (como se ve tu mascota ");
		lblDescripcionFisica.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcionFisica.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblDescripcionFisica.setBounds(0, 126, 402, 25);
		panel2.add(lblDescripcionFisica);
		
		JLabel lblYQuePersonalidad = new JLabel("y que personalidad tiene)");
		lblYQuePersonalidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblYQuePersonalidad.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblYQuePersonalidad.setBounds(0, 146, 402, 25);
		panel2.add(lblYQuePersonalidad);
		
		JTextArea descripcionfisica = new JTextArea();
		descripcionfisica.setBorder(new LineBorder(new Color(119, 136, 153)));
		descripcionfisica.setCaretColor(Color.BLACK);
		descripcionfisica.setSelectionColor(new Color(0, 120, 215));
		descripcionfisica.setBounds(65, 173, 277, 46);
		descripcionfisica.setFont(new Font("Dialog", Font.PLAIN, 11));
		descripcionfisica.setLineWrap(true); 
		panel2.add(descripcionfisica);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("No tiene todas extremidades");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxNewCheckBox.setBounds(60, 268, 277, 14);
		panel2.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel = new JLabel("o es ciega o sorda");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(81, 279, 184, 14);
		panel2.add(lblNewLabel);
		
		JCheckBox chckbxTieneAlgunaCondicion = new JCheckBox("Tiene una condicion medica especial");
		chckbxTieneAlgunaCondicion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chckbxTieneAlgunaCondicion.setBounds(60, 311, 277, 14);
		panel2.add(chckbxTieneAlgunaCondicion);
		
		JLabel lblAlergiasEnLa = new JLabel("o necesita tratamiento a largo plazo");
		lblAlergiasEnLa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAlergiasEnLa.setBounds(70, 326, 267, 14);
		panel2.add(lblAlergiasEnLa);
		
		JLabel lblLaMascota = new JLabel("La Mascota... ");
		lblLaMascota.setHorizontalAlignment(SwingConstants.CENTER);
		lblLaMascota.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblLaMascota.setBounds(0, 230, 402, 25);
		panel2.add(lblLaMascota);
		
		JTextArea descripcioncondicion = new JTextArea();
		descripcioncondicion.setSelectionColor(SystemColor.textHighlight);
		descripcioncondicion.setLineWrap(true);
		descripcioncondicion.setFont(new Font("Dialog", Font.PLAIN, 11));
		descripcioncondicion.setCaretColor(Color.BLACK);
		descripcioncondicion.setBorder(new LineBorder(new Color(119, 136, 153)));
		descripcioncondicion.setBounds(65, 388, 277, 46);
		panel2.add(descripcioncondicion);
		
		JLabel lblfotoanimalito = new JLabel("");
		lblfotoanimalito.setBounds(282, 453, 54, 52);
		ImageIcon foto= scaleImage("/imagenes/fotomasc.png",lblfotoanimalito.getWidth(), lblfotoanimalito.getHeight());
		lblfotoanimalito.setIcon(foto);	
		lblfotoanimalito.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblfotoanimalito.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BusquedaArchivos b = new BusquedaArchivos() ;
				urlFoto = b.busqueda(e);
			}
		});
		panel2.add(lblfotoanimalito);
		
		JLabel lblSiLoDeseea = new JLabel("Si lo desea: ");
		lblSiLoDeseea.setFont(new Font("Swis721 Ex BT", Font.PLAIN, 12));
		lblSiLoDeseea.setBounds(81, 470, 109, 14);
		panel2.add(lblSiLoDeseea);
		
		JLabel lblInserteUnaFoto = new JLabel("Inserte una foto de su mascota ->");
		lblInserteUnaFoto.setFont(new Font("Swis721 Ex BT", Font.PLAIN, 12));
		lblInserteUnaFoto.setBounds(81, 491, 223, 14);
		panel2.add(lblInserteUnaFoto);
		
		JLabel lblbotonconfirmacion = new JLabel();
		lblbotonconfirmacion.setBounds(171, 536, 54, 54);
		ImageIcon huella= scaleImage("/imagenes/garritaboton.png",lblbotonconfirmacion.getWidth(), lblbotonconfirmacion.getHeight());
		lblbotonconfirmacion.setIcon(huella);	
		lblbotonconfirmacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblbotonconfirmacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String [] botones = { "Si", " No", "Finalizar registro" };
				ImageIcon img = scaleImage("/imagenes/pawprint.png", 30 ,30) ;
				//pasa with finalizar*********************
				int variable = JOptionPane.showOptionDialog (null, " ¿Desea agregar mas mascotas a su perfil?", "Mascotas", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,img, botones, botones[0]);
                int estado = (int)Math.floor(edad1*0.7); 
				MascotasAdopcion mascota = new MascotasAdopcion(nombre.getText(),tipo1,raza1,urlFoto,estado,"",user,edad1,descripcionfisica.getText(),descripcioncondicion.getText());
				mascotas.pushFront(mascota);
				String now = Instant.now().atZone(ZoneId.of("America/Bogota")).format(DateTimeFormatter.ISO_LOCAL_DATE);
				System.out.println(now);
				if(variable==0) {
					RegistroMascotasNatural na = new RegistroMascotasNatural();
					na.setVisible(true);
				}else if(variable==1) {
					
				}else {
					setVisible(false);
				}
			}});
		panel2.add(lblbotonconfirmacion);
		JLabel lblDescripcionCondicion = new JLabel("Descripcion condicion");
		lblDescripcionCondicion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcionCondicion.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblDescripcionCondicion.setBounds(81, 358, 227, 25);
		panel2.add(lblDescripcionCondicion);
		crearFondo(false);
		//contentPane.updateU();
		
	}
	public MyArrayList<Mascotas> getMascotas() {
		return mascotas;
	}

	public void setMascotas(MyArrayList<Mascotas> mascotas) {
		this.mascotas = mascotas;
	}

	public void crearFondo(boolean n) {
		fondoImage = new JLabel();
		fondoImage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fondoImage.setBounds(0, 0, 439, 678);
		ImageIcon fondo1= scaleImage("/imagenes/perfil persona natural (4).png",fondoImage.getWidth(), fondoImage.getHeight());
		fondoImage.setIcon(fondo1);	
		if(n) {
		panel.add(fondoImage);
		}else {
			panel2.add(fondoImage);
		}
		
		
	}
	
	public void creacionCombo(JComboBox caja, String[] lista) {
		caja.setBackground(Color.WHITE);
		caja.setModel(new DefaultComboBoxModel(lista));
		caja.setEditable(true);
		caja.setSelectedItem("");
		caja.setFont(new Font("Monospac821 BT", Font.PLAIN, 13));
		AutoCompleteDecorator.decorate(caja);
	}

	public ImageIcon scaleImage(String url, int ancho , int altura) {
		ImageIcon icon = new ImageIcon(RegistroPersonas.class.getResource(url));
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(ancho, altura, Image.SCALE_SMOOTH);
		return new ImageIcon(imgScale);

	}
}
