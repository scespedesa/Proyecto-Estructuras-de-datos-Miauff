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
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
import rojeru_san.componentes.RSDateChooser;

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
	private String urlFoto;
	private MyArrayList<MascotasAdopcion> mascotas;
	private int fecha;
	private JComboBox raza;
	private JSpinner edadnum;
	private JTextField nombre;
	private JComboBox tipo;
	private JTextArea descripcionfisica;
	private JTextArea descripcioncondicion;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxTieneAlgunaCondicion ;
	


	public RegistroMascotasAdmin() {
		mascotas= new MyArrayList<MascotasAdopcion>();
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
		ventana();
		
		
}
//*************display de la ventana principal********
	public void ventana() {		
		 nombre = new JTextField();
		nombre.setBounds(76, 140, 277, 25);
		panel.add(nombre);
		
		 edadnum = new JSpinner();
		edadnum.setFont(new Font("Tahoma", Font.PLAIN, 16));
		edadnum.setModel(new SpinnerNumberModel(0, 0, 25, 1));
		edadnum.setBounds(167, 296, 81, 25);
		panel.add(edadnum);
		
		JLabel lbln = new JLabel("Nombre");
		lbln.setFont(new Font("Swis721 Ex BT", Font.PLAIN, 12));
		lbln.setBounds(180, 123, 68, 14);
		panel.add(lbln);
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Swis721 Ex BT", Font.PLAIN, 12));
		lblTipo.setBounds(188, 172, 58, 14);
		panel.add(lblTipo);
		

		tipo = new JComboBox();
		String [] eleccion = new String[] {"perro", "gato", "conejo","pez"} ;
		creacionCombo( tipo, eleccion);
		tipo.setBounds(76,189,277,25);
		panel.add(tipo);
		
		Lector lee; 
		JComboBox raza = new JComboBox();
		raza.setFont(new Font("Monospac821 BT", Font.PLAIN, 13));
		raza.setEditable(true);
		raza.setBackground(Color.WHITE);
		if(eleccion.equals("perro")) {
			lee= new Lector("listadoCaninos");
			lee.LecturaLineas();
			creacionCombo(raza,lee.getListadoCaninos());
		}else if (eleccion.equals("gato")) {
			lee= new Lector("listadoGatos");
			lee.LecturaLineas();
			creacionCombo(raza,lee.getListadoGatos());
		}else if (eleccion.equals("conejo")) {
			lee= new Lector("listadoConejos");
			lee.LecturaLineas();
			creacionCombo(raza,lee.getListadoConejos());
		}else if (eleccion.equals("pez")) {
			lee= new Lector("listadoPeces");
			lee.LecturaLineas();
			creacionCombo(raza,lee.getListadoPeces());
		}
		
		raza.setBounds(76, 241, 277, 25);
		panel.add(raza);	
		
		JLabel lblRaza = new JLabel("Raza");
		lblRaza.setFont(new Font("Swis721 Ex BT", Font.PLAIN, 12));
		lblRaza.setBounds(188, 225, 68, 14);
		panel.add(lblRaza);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Swis721 Ex BT", Font.PLAIN, 12));
		lblEdad.setBounds(188, 277, 68, 14);
		panel.add(lblEdad);
		
		JLabel lblDescripcionFisica = new JLabel("Descripcion fisica y de personalidad");
		lblDescripcionFisica.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcionFisica.setFont(new Font("Swis721 Ex BT", Font.PLAIN, 12));
		lblDescripcionFisica.setBounds(76, 332, 277, 14);
		panel.add(lblDescripcionFisica);
		
		descripcionfisica = new JTextArea();
		descripcionfisica.setBorder(new LineBorder(new Color(119, 136, 153)));
		descripcionfisica.setCaretColor(Color.BLACK);
		descripcionfisica.setSelectionColor(new Color(0, 120, 215));
		descripcionfisica.setBounds(76, 348, 277, 90);
		descripcionfisica.setFont(new Font("Monospac821 BT", Font.PLAIN, 13));
		descripcionfisica.setLineWrap(true); 
		panel.add(descripcionfisica);
		
		JLabel lblfotoanimalito = new JLabel("");
		lblfotoanimalito.setBounds(299, 459, 54, 52);
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
		panel.add(lblfotoanimalito);
		
		JLabel lblSiLoDeseea = new JLabel("Si lo desea: ");
		lblSiLoDeseea.setFont(new Font("Swis721 Ex BT", Font.PLAIN, 12));
		lblSiLoDeseea.setBounds(136, 459, 88, 14);
		panel.add(lblSiLoDeseea);
		JLabel lblInserteUnaFoto = new JLabel("Inserte una foto de su mascota ->");
		lblInserteUnaFoto.setFont(new Font("Swis721 Ex BT", Font.PLAIN, 12));
		lblInserteUnaFoto.setBounds(76, 478, 223, 14);
		panel.add(lblInserteUnaFoto);
		
		JButton btnsiguiente = new JButton("Siguiente");
		btnsiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				String tipo1 = (String) tipo.getSelectedItem();
				String raza1= (String) raza.getSelectedItem();
				int edad1 = (int) edadnum.getValue();
				String  nombre1 = (String) nombre.getText();
				String  descripcionfisica1 = (String) descripcionfisica.getText();
				
				if( nombre1==null || tipo1=="" || raza1==null || descripcionfisica1==null) {
					JOptionPane.showMessageDialog(null,"Por favor llene todos los campos", "Error de datos", JOptionPane.INFORMATION_MESSAGE);
					System.out.println(nombre1+ "  " +tipo1+"  " + raza1+ "  " +descripcionfisica1);
				}else {
				ventana2(nombre1,tipo1,raza1,edad1,descripcionfisica1);
				panel.setVisible(false);
			}}
		});

		btnsiguiente.setBounds(256, 543, 89, 23);
		btnsiguiente.setForeground(Color.BLACK);
		btnsiguiente.setBorder(new LineBorder(new Color(119, 136, 153), 1, true));
		btnsiguiente.setBackground(new Color(253, 245, 230));
		btnsiguiente.setFont(new Font("Monospaced", Font.PLAIN, 14));
		panel.add(btnsiguiente);
			
	
		crearFondo(true);
		
	}

	public void ventana2(String nombre1,String tipo1,String raza1,int edad1,String descripcionfisica1) {
		panel2.setVisible(true);
				
		JLabel lblFechaDeIngreso = new JLabel("Fecha de ingreso");
		lblFechaDeIngreso.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaDeIngreso.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblFechaDeIngreso.setBounds(10, 123, 412, 35);
		panel2.add(lblFechaDeIngreso);
		
		RSDateChooser dateChooser = new RSDateChooser();
		dateChooser.setBounds(92, 169, 253, 23);
		panel2.add(dateChooser);
		JButton btnAceptar = new JButton("ok");
		btnAceptar.setBorder(new LineBorder(new Color(119, 136, 153)));
		btnAceptar.setFont(new Font("Monospac821 BT", Font.PLAIN, 11));
		btnAceptar.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				 Instant fech= dateChooser.getDatoFecha().toInstant();
					Instant today = Instant.now();
					fecha = (int) Duration.between(fech, today).toDays();
			}
		});
		btnAceptar.setBounds(293, 203, 52, 19);
		panel2.add(btnAceptar);
		
		chckbxNewCheckBox = new JCheckBox("No tiene todas extremidades");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxNewCheckBox.setBounds(92, 258, 253, 14);
		panel2.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel = new JLabel("o es ciega o sorda");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(124, 279, 184, 14);
		panel2.add(lblNewLabel);
		
		 chckbxTieneAlgunaCondicion = new JCheckBox("Tiene una condicion medica especial");
		chckbxTieneAlgunaCondicion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxTieneAlgunaCondicion.setBounds(92, 310, 253, 14);
		panel2.add(chckbxTieneAlgunaCondicion);
		
		JLabel lblAlergiasEnLa = new JLabel("o necesita tratamiento a largo plazo");
		lblAlergiasEnLa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAlergiasEnLa.setBounds(119, 333, 227, 14);
		panel2.add(lblAlergiasEnLa);
		
		JLabel lblLaMascota = new JLabel("La Mascota... ");
		lblLaMascota.setHorizontalAlignment(SwingConstants.CENTER);
		lblLaMascota.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblLaMascota.setBounds(10, 226, 402, 25);
		panel2.add(lblLaMascota);
		
		descripcioncondicion = new JTextArea();
		descripcioncondicion.setSelectionColor(SystemColor.textHighlight);
		descripcioncondicion.setLineWrap(true);
		descripcioncondicion.setFont(new Font("Dialog", Font.PLAIN, 11));
		descripcioncondicion.setCaretColor(Color.BLACK);
		descripcioncondicion.setBorder(new LineBorder(new Color(119, 136, 153)));
		descripcioncondicion.setBounds(92, 404, 253, 74);
		panel2.add(descripcioncondicion);
		
		
		JLabel lblbotonconfirmacion = new JLabel();
		lblbotonconfirmacion.setBounds(171, 536, 54, 54);
		ImageIcon huella= scaleImage("/imagenes/garritaboton.png",lblbotonconfirmacion.getWidth(), lblbotonconfirmacion.getHeight());
		lblbotonconfirmacion.setIcon(huella);	
		lblbotonconfirmacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblbotonconfirmacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//pasa with finalizar*********************
                int sub1 = chckbxNewCheckBox.isSelected()? 1:0;
                int sub2 = chckbxTieneAlgunaCondicion.isSelected()? 1:0;
                int estado = (int)Math.floor(edad1*0.7)+sub1*6+sub2*4+2; 
					MascotasAdopcion mascota = new MascotasAdopcion(1, nombre1,tipo1,raza1,urlFoto,estado,"",fecha,edad1,descripcionfisica1,descripcioncondicion.getText());
					mascotas.pushFront(mascota);
					String now = Instant.now().atZone(ZoneId.of("America/Bogota")).format(DateTimeFormatter.ISO_LOCAL_DATE);
					System.out.println(now);
				String [] botones = { "Si", " No", "Finalizar registro" };
				ImageIcon img = scaleImage("/imagenes/pawprint.png", 30 ,30) ;
				int variable = JOptionPane.showOptionDialog (null, " ¿Desea agregar mas mascotas a su perfil?", "Mascotas", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,img, botones, botones[0]);
				if(variable==0) {
					allNull();
				}else if(variable==1) {
					dispose();
				}else {
					setVisible(false);
				}
				
			}});
		panel2.add(lblbotonconfirmacion);
		JLabel lblDescripcionCondicion = new JLabel("Descripcion condicion");
		lblDescripcionCondicion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcionCondicion.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblDescripcionCondicion.setBounds(10, 378, 402, 25);
		panel2.add(lblDescripcionCondicion);
		crearFondo(false);
		//contentPane.updateU();
		
	}
	public MyArrayList<MascotasAdopcion> getMascotas() {
		return mascotas;
	}

	public void setMascotas(MyArrayList<MascotasAdopcion> mascotas) {
		this.mascotas = mascotas;
	}

	public void allNull() {
		nombre.setText("");
		edadnum.setValue(0);
		descripcionfisica.setText("");
		descripcioncondicion.setText("");
		tipo.setSelectedItem("perro");
		chckbxTieneAlgunaCondicion.setSelected(false);
		chckbxNewCheckBox.setSelected(false);
		ventana();
		panel2.setVisible(false);
		panel.setVisible(true);

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
