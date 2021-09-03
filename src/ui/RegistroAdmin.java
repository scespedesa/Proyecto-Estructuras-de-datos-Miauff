package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import dataStructures.MyArrayList;
import datosMascotas.Mascotas;
import datosUsuarios.Administrador;
import datosUsuarios.Natural;

import java.time.ZoneId;

import logicaNegocio.BusquedaArchivos;
import logicaNegocio.Conexion;
import logicaNegocio.VerificacionClave;
import rojeru_san.componentes.RSDateChooser;

import java.text.SimpleDateFormat;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistroAdmin extends JFrame {
	private JPanel contentPane;
	private JPanel panel ;
	private Image fondo;
	private Image menu ;
	private int alturaPantalla;
	private int anchoPantalla;
	private String urlFoto;
	private String campo3 = "";
	private JLabel fondoImage;
	private JTextField textField;
	private JTextField lugarResidencia;
	private String nacimiento;
	private JTextField telefono;
	private JLabel lbldesea;
	private String urlPagina;
	private RegistroMascotasAdmin na;
	public RegistroAdmin() {
	Toolkit pantalla = Toolkit.getDefaultToolkit();
	Dimension dimension= pantalla.getScreenSize();
	this.alturaPantalla= dimension.height;
	this.anchoPantalla = dimension.width;
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(anchoPantalla/3, 10 , anchoPantalla/3, alturaPantalla - alturaPantalla/10);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	setContentPane(contentPane);
	setTitle("Registro");
	setResizable(false);

	panel = new JPanel();
	panel.setBackground(Color.WHITE);
	panel.setForeground(Color.DARK_GRAY);
	panel.setBounds(0, 0,450, 706);
	contentPane.add(panel);
	panel.setLayout(null);
	
	ventana();

}public void ventana() {
	crearMenu();
	JLabel registro = new JLabel("Registro");
	registro.setFont(new Font("Monospac821 BT", Font.PLAIN, 16));
	registro.setHorizontalAlignment(SwingConstants.CENTER);
	registro.setBounds(133, 117, 165, 25);
	panel.add(registro);

	JLabel lblnombre = new JLabel("Nombre de la organizacion");
	lblnombre.setFont(new Font("Monospaced", Font.PLAIN, 11));
	lblnombre.setBounds(92, 151, 229, 21);
	
	panel.add(lblnombre);
	RSDateChooser dateChooser = new RSDateChooser();
	dateChooser.setBounds(92, 218, 253, 23);
	panel.add(dateChooser);
	JButton btnAceptar = new JButton("ok");
	btnAceptar.setBorder(new LineBorder(new Color(119, 136, 153)));
	btnAceptar.setFont(new Font("Monospac821 BT", Font.PLAIN, 11));
	btnAceptar.addActionListener(new ActionListener() {
		

		public void actionPerformed(ActionEvent e) {
			Date fecha= dateChooser.getDatoFecha();
			SimpleDateFormat sd= new SimpleDateFormat("dd MMMM yyy");
			nacimiento = sd.format(fecha);
		}
	});
	btnAceptar.setBounds(293, 243, 52, 19);
	panel.add(btnAceptar);
	JTextField direccion = new JTextField();
	direccion.setForeground(Color.BLACK);
	direccion.setFont(new Font("Monospac821 BT", Font.PLAIN, 15));
	direccion.setBorder(new LineBorder(new Color(119, 136, 153)));
	direccion.setBounds(92, 273, 253, 23);
	panel.add(direccion);
	
	JLabel lblFechaDeLa = new JLabel("Fecha de la creacion");
	lblFechaDeLa.setFont(new Font("Monospaced", Font.PLAIN, 11));
	lblFechaDeLa.setBounds(92, 200, 229, 21);
	panel.add(lblFechaDeLa);
	
	JTextField telefono = new JTextField();
	telefono.setForeground(Color.BLACK);
	telefono.setFont(new Font("Monospac821 BT", Font.PLAIN, 15));
	telefono.setBorder(new LineBorder(new Color(119, 136, 153)));
	telefono.setBounds(92, 323, 253, 25);
	panel.add(telefono);

	
	JLabel lblresidencia = new JLabel("Direcci\u00F3n");
	lblresidencia.setFont(new Font("Monospaced", Font.PLAIN, 11));
	lblresidencia.setBounds(92, 252, 229, 23);
	panel.add(lblresidencia);
	
	JTextField nombre = new JTextField();
	nombre.setBorder(new LineBorder(new Color(119, 136, 153)));
	creacionCampoTexto(15,92, 222, 253, 25, nombre);
	
	
	JLabel lblsexo = new JLabel("Numero de contacto");
	lblsexo.setFont(new Font("Monospaced", Font.PLAIN, 11));
	lblsexo.setBounds(92,302, 165, 21);
	panel.add(lblsexo);
	
	JLabel lbldescripcion = new JLabel("Descripcion");
	lbldescripcion.setFont(new Font("Monospaced", Font.PLAIN, 11));
	lbldescripcion.setBounds(92, 359, 229, 21);
	panel.add(lbldescripcion);
	
	JTextArea descripcion = new JTextArea();
	descripcion.setBorder(new LineBorder(new Color(119, 136, 153)));
	descripcion.setCaretColor(Color.BLACK);
	descripcion.setSelectionColor(new Color(0, 120, 215));
	descripcion.setBounds(92, 379, 253, 108);
	descripcion.setFont(new Font("Monospac821 BT", Font.PLAIN, 14));
	descripcion.setLineWrap(true); 
	panel.add(descripcion);
	na = new RegistroMascotasAdmin();	
	JButton btnsiguiente = new JButton("Finalizar");
	btnsiguiente.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			Seguridad segu = new Seguridad();
			segu.getCon();
			Administrador organizacion = new Administrador(segu.getUsuarioText(), segu.getCon(),nombre.getText(),nacimiento,direccion.getText(),telefono.getText(),descripcion.getText(),urlFoto, 1,urlPagina,na.getMascotas());  
			System.out.println(organizacion.toString());
			PerfilAdministrador af = new PerfilAdministrador();
			af.setVisible(true);
			//// Insercion de los Datos
			Conexion conec = new Conexion();
			Connection con = conec.Conectar();
			try {
				//// Preparamos la insercion de un registro
				PreparedStatement insertar = con.prepareStatement("insert into USUARIOS (USER, NAME, BIRTHDATE, ADDRESS, PHONE, DESCRIPTION, PHOTO, PASSWORD, ADMIN) values ( ? , ?,?,?,?,?,?,?,?,?)");
				insertar.setString(1, segu.getUsuarioText());
				insertar.setString(2, nombre.getText());
				insertar.setString(3, nacimiento);
				insertar.setString(5, direccion.getText());
				insertar.setString(6, telefono.getText());
				insertar.setString(7, descripcion.getText());
				insertar.setString(8, urlFoto);
				insertar.setString(9, segu.getCon());
				insertar.setInt(10, 1);
				int retorn = insertar.executeUpdate();
				System.out.println(retorn + " insertado");
			} catch (SQLException ex) {
				System.out.println("Imposible realizar insercion ... FAIL");
			}
			dispose();
			
		}
	});
	btnsiguiente.setBounds(256, 564, 85, 20);
	btnsiguiente.setForeground(Color.BLACK);
	btnsiguiente.setBorder(new LineBorder(new Color(119, 136, 153), 1, true));
	btnsiguiente.setBackground(new Color(253, 245, 230));
	btnsiguiente.setFont(new Font("Monospac821 BT", Font.PLAIN, 12));
	
	JButton btnAadirMascotas = new JButton("A\u00F1adir mascotas");
	btnAadirMascotas.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			na.setVisible(true);
		}
	});
	btnAadirMascotas.setForeground(Color.BLACK);
	btnAadirMascotas.setFont(new Font("Monospaced", Font.PLAIN, 14));
	btnAadirMascotas.setBorder(new LineBorder(new Color(119, 136, 153), 1, true));
	btnAadirMascotas.setBackground(new Color(253, 245, 230));
	btnAadirMascotas.setBounds(104, 563, 123, 20);
	panel.add(btnAadirMascotas);
	panel.add(btnsiguiente);
	lbldesea = new JLabel("Si lo desea adjunte:");
	lbldesea.setFont(new Font("Monospaced", Font.PLAIN, 11));
	lbldesea.setBounds(152, 486, 146, 21);
	panel.add(lbldesea);
	JLabel lblfoto = new JLabel("foto");
	lblfoto.setBounds(151, 518, 45, 40);
	ImageIcon ima = scaleImage("/imagenes/Basic_Ui_(74).jpg",lblfoto.getWidth(),lblfoto.getHeight());
	lblfoto.setIcon(ima);
	lblfoto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	lblfoto.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			BusquedaArchivos b = new BusquedaArchivos() ;
			urlFoto = b.busqueda(e);
		}
	});
	panel.add(lblfoto);
	
	JLabel lblPaginaweb = new JLabel("paginaweb");
	lblPaginaweb.setBounds(256, 523, 55, 35);
	ImageIcon imag = scaleImage("/imagenes/pag.jpg",lblPaginaweb.getWidth(),lblPaginaweb.getHeight());
	lblPaginaweb.setIcon(imag);
	lblPaginaweb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	lblPaginaweb.addMouseListener(new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent e) {
			urlPagina = JOptionPane.showInputDialog("Escribe el link de su pagina web");
			JOptionPane.showMessageDialog(null, "Direccion url ingresada :  " + urlPagina);
		}
	});
	
	panel.add(lblPaginaweb);	
	
	JLabel lblAdjunteUnaFoto = new JLabel("Foto");
	lblAdjunteUnaFoto.setFont(new Font("Monospaced", Font.PLAIN, 11));
	lblAdjunteUnaFoto.setBounds(92, 506, 104, 21);
	panel.add(lblAdjunteUnaFoto);
	
	JLabel lblUrlDeSu = new JLabel("Pagina web");
	lblUrlDeSu.setFont(new Font("Monospaced", Font.PLAIN, 11));
	lblUrlDeSu.setBounds(249, 506, 92, 19);
	panel.add(lblUrlDeSu);
	crearFondo();
}


public void crearFondo() {
	fondoImage = new JLabel();
	fondoImage.setBounds(0, 0, 439, 653);
	ImageIcon fondo1= scaleImage("/imagenes/registro.png",fondoImage.getWidth(), fondoImage.getHeight());
	fondoImage.setIcon(fondo1);	
	panel.add(fondoImage);
	

}
public void creacionCombo(int x, int y ,int ancho , int alto, JComboBox caja, String[] lista) {
	caja.setBackground(Color.WHITE);
	caja.setModel(new DefaultComboBoxModel(lista));
	caja.setEditable(true);
	caja.setSelectedItem("");
	caja.setBounds(92,361,253,25);
	caja.setFont(new Font("Monospac821 BT", Font.PLAIN, 14));
	panel.add(caja);
	AutoCompleteDecorator.decorate(caja);
}
public void creacionEtiquetas(int tamanioLetra,int x,int y,int ancho,int largo, JLabel label) {
	label.setBounds(92, 359, ancho, largo);
	label.setForeground(SystemColor.desktop);
	label.setFont(new Font("Monospac821 BT", Font.PLAIN, tamanioLetra));
	panel.add(label);

}
public void creacionCampoTexto(int tamanioLetra,int x,int y,int ancho,int largo, JTextField field) {
	field.setBounds(92,171,253,23);
	field.setFont(new Font("Monospac821 BT", Font.PLAIN, tamanioLetra));
	field.setForeground(SystemColor.desktop);
	panel.add(field);
}
public void crearMenu(){
	JMenuBar menuBar = new JMenuBar();
	menuBar.setBounds(0, 0, 35, 35);
	panel.add(menuBar);

	JMenu menu_1 = new JMenu("");
	menu_1.setBounds(0, 0, 35, 35);
	menu = new ImageIcon(RegistroPersonas.class.getResource("/imagenes/menu.png")).getImage().getScaledInstance(26, 26, Image.SCALE_DEFAULT);
	menu_1.setIcon(new ImageIcon(menu));
	menuBar.add(menu_1);
	JMenuItem menuItem_2 = new JMenuItem("Ir a Ingreso");
	menuItem_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent a) {
			Ingreso persona = new Ingreso();
			persona.setVisible(true);
		}
	});
	menuItem_2.setFont(new Font("Monospac821 BT", Font.PLAIN, 14));
	menu_1.add(menuItem_2);
	JMenuItem menuItem_3 = new JMenuItem("Salir");
	menuItem_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	});
	menuItem_3.setFont(new Font("Monospac821 BT", Font.PLAIN, 14));
	menu_1.add(menuItem_3);
}

public ImageIcon scaleImage(String url, int ancho , int altura) {
	ImageIcon icon = new ImageIcon(RegistroPersonas.class.getResource(url));
	Image img = icon.getImage();
	Image imgScale = img.getScaledInstance(ancho, altura, Image.SCALE_SMOOTH);
	return new ImageIcon(imgScale);

}
}

