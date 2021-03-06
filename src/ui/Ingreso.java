package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.SystemColor;

import com.mysql.cj.xdevapi.Statement;

import dataStructures.HashTable;
import dataStructures.MyArrayList;
import datosMascotas.Mascotas;
import datosMascotas.MascotasAdopcion;
import datosUsuarios.Administrador;
import datosUsuarios.Natural;
import logicaNegocio.Conexion;
import java.sql.*;


public class Ingreso extends JFrame {
	private JPanel contentPane;
	private JPanel panel ;
	private Image fondo;
	private Image menu ;
	private int alturaPantalla;
	private int anchoPantalla;
	private String urlFoto;
	private JTextField usuario;
	private String urlVideo;
	private String campo3 = "";
	private JLabel fondoImage;
	private JTextField textField;
	private JPasswordField passwordField ;
	public static String usuarioEnviar;
	public static Administrador organizacion;
	public static Natural aficionado;


	public Ingreso() {
	Toolkit pantalla = Toolkit.getDefaultToolkit();
	Dimension dimension= pantalla.getScreenSize();
	this.alturaPantalla= dimension.height;
	this.anchoPantalla = dimension.width;
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(anchoPantalla/3, 10 , 450, 706);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	setContentPane(contentPane);
	setTitle("Ingreso");
	setResizable(false);
	//fondo = new ImageIcon(RegistroPersonas.class.getResource("/imagenes/fondomiauff.png")).getImage().getScaledInstance(anchoPantalla/3 , alturaPantalla - alturaPantalla/10 ,  Image.SCALE_SMOOTH);

	panel = new JPanel();
	panel.setBackground(Color.WHITE);
	panel.setForeground(Color.DARK_GRAY);
	panel.setBounds(0, 0,450, 706);
	contentPane.add(panel);
	panel.setLayout(null);
	Connection con;
	
	ventana();

}public void ventana() {
	crearMenu();
	JLabel ingreso = new JLabel("Ingreso");
	ingreso.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.text, null));
	ingreso.setForeground(SystemColor.windowBorder);
	ingreso.setFont(new Font("Monospac821 BT", Font.BOLD, 30));
	ingreso.setHorizontalAlignment(SwingConstants.CENTER);
	ingreso.setBounds(155, 186, 172, 48);
	panel.add(ingreso);

	JLabel lblUsuario = new JLabel("Usuario");
	lblUsuario.setFont(new Font("Monospac821 BT", Font.PLAIN, 18));
	lblUsuario.setForeground(SystemColor.windowBorder);
	lblUsuario.setBounds(168, 261, 84, 36);
	panel.add(lblUsuario);
		
	JLabel hu = new JLabel("New label");
	hu.setBounds(106, 261, 46, 36);
	ImageIcon hueso = scaleImage("/imagenes/pawprint.png",hu.getWidth(),hu.getHeight());
	hu.setIcon(hueso);
	panel.add(hu);
	
	
	usuario = new JTextField();
	usuario.setSize(new Dimension(7, 16));
	usuario.setSelectionColor(Color.WHITE);
	usuario.setSelectedTextColor(Color.YELLOW);
	usuario.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 15));
	usuario.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
	usuario.setBackground(new Color(255, 255, 255));
	usuario.setBounds(105, 308, 222, 30);
	panel.add(usuario);
	usuario.setColumns(10);	
	
	JLabel lblcandado = new JLabel();
	lblcandado.setBounds(105, 354, 46, 36);
	ImageIcon candado = scaleImage("/imagenes/padlock.png",lblcandado.getWidth(),lblcandado.getHeight());
	lblcandado.setIcon(candado);
	panel.add(lblcandado);
	
	JLabel lblContrasenia = new JLabel("Contrasenia");
	lblContrasenia.setForeground(SystemColor.windowBorder);
	lblContrasenia.setFont(new Font("Monospac821 BT", Font.PLAIN, 18));
	lblContrasenia.setBounds(167, 354, 160, 36);
	panel.add(lblContrasenia);
	
	passwordField = new JPasswordField();
	passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
	passwordField.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
	passwordField.setBounds(105, 401, 222, 30);
	panel.add(passwordField);
	
/// *******************ingreso de usuario************************
	JButton btningresar = new JButton("Ingresar");
	btningresar.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			Conexion conec = new Conexion();
			Connection conexion = conec.Conectar();

			//realizar consulta
			 
	        try {
	// Preparamos la consulta
	            java.sql.Statement s = conexion.createStatement();
	            ResultSet rs = s.executeQuery("select USER , PASSWORD from USUARIOS");
	// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
	           HashTable usu = new HashTable(10);

	            while (rs.next()) {


	            	String key = rs.getString(1);
	            	String value = rs.getString(2);

////////////////////////////////////////////////////////////////////////
				long startTime = System.nanoTime();
				long stopTime = System.nanoTime();
				//for(int ji=0; ji< conteo; ji++) {
				//}
	            	usu.put(key,value);
				System.out.println("Ingreso Put: "+ (stopTime - startTime));
////////////////////////////////////////////////////////////////////////
	            }
	            String contrasenia = new String(passwordField.getPassword());



///////////////////////////////////////////////////////////////////
				long startTime = System.nanoTime();
				long stopTime = System.nanoTime();
				
	            if(usu.find(usuario.getText(),contrasenia)) {
				System.out.println("Ingreso Find: "+ (stopTime - startTime));
//////////////////////////////////////////////////////////////////////

					 usuarioEnviar= usuario.getText();

	            	System.out.println("paso por aqui cate que no lo vi");
                   ///lo que pasa si la contrase?a es correcta.********************************

	            	PreparedStatement ps =  conexion.prepareStatement("select * from USUARIOS WHERE USER = ?");
	            	
	            	ps.setString(1, usuario.getText());

		            ResultSet r = ps.executeQuery();


		            PreparedStatement pst =  conexion.prepareStatement("select * from ANIMALES WHERE  USER = ?");

		            pst.setString(1, usuario.getText());
		            
		            ResultSet re = pst.executeQuery();

		            r.next(); 
		            re.next();
		            if(r.getInt(10)==0) {
		                MyArrayList<Mascotas> masco = new MyArrayList<Mascotas>(1);
		            	while (re.next()) {
		            		 Mascotas ma = new Mascotas(re.getString(2), re.getString(3), re.getString(4), re.getString(5),r.getString(1), re.getInt(9),re.getString(10));
		            		masco.pushBack(ma);
		            	}
		            	 
		            	 Natural aficionado1 = new Natural(r.getString(1),r.getString(2),r.getString(3), r.getString(4), r.getString(5),r.getString(6), 
				            		r.getString(7),r.getString(8),r.getString(9), r.getInt(10),masco);
		            	 System.out.println(aficionado1.toString());
		            	 aficionado = aficionado1;
		            	 PerfilNatural2 afi = new PerfilNatural2(aficionado1,0);
			 				afi.setVisible(true);
		            }else {
		                MyArrayList<MascotasAdopcion> masco = new MyArrayList<MascotasAdopcion>(1);
		            	 while (re.next()) {
				           	MascotasAdopcion madop= new MascotasAdopcion(re.getInt(1),re.getString(2),re.getString(3), re.getString(4), re.getString(5), re.getInt(6),r.getString(1),re.getInt(8),re.getInt(9),re.getString(10),re.getString(11));
				            masco.pushBack(madop);
				            }
		            	 Administrador organizacion1 = new Administrador(r.getString(1),r.getString(2),r.getString(3),r.getString(5),r.getString(6), 
				            		r.getString(7),r.getString(8),r.getString(9),r.getInt(10),r.getString(11),masco);
		            	 System.out.println(organizacion1.toString());
		            	 PerfilNatural2 afi = new PerfilNatural2(organizacion1,1);
		            	 organizacion = organizacion1;
		 				afi.setVisible(true);
		            }  
		            dispose();
	            }else {
	            	//*************lo que pasa cuando la contase?a es incorrecta en el ingreso**********
					JOptionPane.showMessageDialog(null,"Verifique el usuario y contrasenia escritos","Error usuario no encontrado", JOptionPane.INFORMATION_MESSAGE);
				}

				//PerfilNatural2 p= new PerfilNatural2();

	        } catch (SQLException ex) {
	            System.out.println(ex);
	        }
			
			
		}
	});
	btningresar.setForeground(Color.BLACK);
	btningresar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
	btningresar.setBackground(new Color(253, 245, 230));
	btningresar.setFont(new Font("Monospac821 BT", Font.PLAIN, 18));
	btningresar.setBounds(151, 459, 132, 30);
	panel.add(btningresar);
	JLabel lblcasita = new JLabel("New label");
	lblcasita.setBounds(105, 186, 46, 48);
	ImageIcon care = scaleImage("/imagenes/pet-house.png",lblcasita.getWidth(),lblcasita.getHeight());
	lblcasita.setIcon(care);
	panel.add(lblcasita);
	JLabel lblNewLabel = new JLabel();
	lblNewLabel.setBorder(null);
	lblNewLabel.setBackground(new Color(119, 136, 153));
	lblNewLabel.setBounds(68, 160, 300, 387);
	panel.add(lblNewLabel);
	
	fondoImage = new JLabel();
	fondoImage.setBounds(0, 0, 439, 653);
	ImageIcon fondo1= scaleImage("/imagenes/fondi (2).png",fondoImage.getWidth(), fondoImage.getHeight());
	fondoImage.setIcon(fondo1);
	panel.add(fondoImage);
}
	public void creacionEtiquetas(int tamanioLetra,int x,int y,int ancho,int largo, JLabel label) {
	label.setForeground(Color.BLACK);
	label.setFont(new Font("Segoe UI Semibold", Font.PLAIN, tamanioLetra));
	label.setSize(ancho,largo);
	label.setLocation(161, 148);
}

	
public void crearMenu(){
	
	/////// **********el display del menu de la esquina superior******************
	JMenuBar menuBar = new JMenuBar();
	menuBar.setBackground(new Color(255, 255, 255));
	menuBar.setBounds(0, 0, 35, 35);
	panel.add(menuBar);

	JMenu menu_1 = new JMenu("");
	menu_1.setBounds(0, 0, 35, 35);
	menu = new ImageIcon(RegistroPersonas.class.getResource("/imagenes/menu.png")).getImage().getScaledInstance(26, 26, Image.SCALE_DEFAULT);
	menu_1.setIcon(new ImageIcon(menu));
	menuBar.add(menu_1);
	//*************Registro Aficionado*******************
	JMenuItem menuItem_2 = new JMenuItem("Ir a Registro Aficionado");
	menuItem_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent a) {
			dispose();
			RegistroPersonas persona = new RegistroPersonas();
			persona.setVisible(true);
			
		}
	});
	menuItem_2.setFont(new Font("Monospac821 BT", Font.PLAIN, 14));
	menu_1.add(menuItem_2);
	JMenuItem menuItem_3 = new JMenuItem("Salir");
	menuItem_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			dispose();
			
		}
	});
	//*************Registro Organizacion*******************
	JMenuItem menuItem_2_1 = new JMenuItem("Ir a Registro Organizacion");
	menuItem_2_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent a) {
			dispose();
			RegistroAdmin persona = new RegistroAdmin();
			persona.setVisible(true);
			
		}
	});
	menuItem_2_1.setFont(new Font("Monospac821 BT", Font.PLAIN, 14));
	menu_1.add(menuItem_2_1);
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