package ui;

import java.awt.BorderLayout;
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

import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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

public class RegistroMascotasAdmin extends JFrame{
	private int alturaPantalla;
	private int anchoPantalla;
	private JPanel panel ;
	private JLabel fondoImage;
	private Image menu;
	private JPasswordField passwordField;
	private String urlFoto;
	private JTextField nombre;
	private JTextField edad;
	private MyArrayList<Mascotas> mascotas;
	

	public RegistroMascotasAdmin() {
		mascotas= new MyArrayList();
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Dimension dimension= pantalla.getScreenSize();
		this.alturaPantalla= dimension.height;
		this.anchoPantalla = dimension.width;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setBounds(anchoPantalla/3, 10 ,450, 706);
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
		ventana();
	}

	public void ventana() {
		crearMenu();		

		JTextField nombre = new JTextField();
		nombre.setBounds(76, 136, 277, 23);
		panel.add(nombre);
		
		JTextField edad = new JTextField();
		edad.setBounds(76, 262, 277, 23);
		panel.add(edad);
		
		JLabel lbln = new JLabel("Nombre");
		lbln.setFont(new Font("Swis721 Ex BT", Font.PLAIN, 11));
		lbln.setBounds(180, 123, 68, 14);
		panel.add(lbln);
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Swis721 Ex BT", Font.PLAIN, 11));
		lblTipo.setBounds(180, 164, 58, 14);
		panel.add(lblTipo);
		

		JComboBox tipo = new JComboBox();
		String [] eleccion = new String[] {"perro", "gato", "conejo","pez"} ;
		creacionCombo( tipo, eleccion);
		tipo.setBounds(76,176,277,23);
		panel.add(tipo);
		
		Lector lee = new Lector("listadoCaninos");
		lee.LecturaLineas();
		JComboBox raza = new JComboBox();
		raza.setFont(new Font("Monospac821 BT", Font.PLAIN, 13));
		raza.setEditable(true);
		raza.setBackground(Color.WHITE);
		creacionCombo(raza,lee.getListadoPerros());
		raza.setBounds(76, 219, 277, 23);
		panel.add(raza);	
		
		JLabel lblRaza = new JLabel("Raza");
		lblRaza.setFont(new Font("Swis721 Ex BT", Font.PLAIN, 12));
		lblRaza.setBounds(180, 204, 68, 14);
		panel.add(lblRaza);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setFont(new Font("Swis721 Ex BT", Font.PLAIN, 12));
		lblEdad.setBounds(180, 248, 68, 14);
		panel.add(lblEdad);
		JLabel lblDescripcionFisica = new JLabel("Descripcion fisica");
		lblDescripcionFisica.setFont(new Font("Swis721 Ex BT", Font.PLAIN, 12));
		lblDescripcionFisica.setBounds(147, 290, 125, 14);
		panel.add(lblDescripcionFisica);
		
		JTextArea descripcionfisica = new JTextArea();
		descripcionfisica.setBorder(new LineBorder(new Color(119, 136, 153)));
		descripcionfisica.setCaretColor(Color.BLACK);
		descripcionfisica.setSelectionColor(new Color(0, 120, 215));
		descripcionfisica.setBounds(76, 304, 277, 64);
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
				urlFoto = b.busqueda(e,panel);
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
		JLabel lblbotonconfirmacion = new JLabel();
		lblbotonconfirmacion.setBounds(198, 531, 54, 54);
		//ImageIcon huella= scaleImage("/imagenes/garritaboton.png",lblbotonconfirmacion.getWidth(), lblbotonconfirmacion.getHeight());
		//lblbotonconfirmacion.setIcon(huella);	
		lblbotonconfirmacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblbotonconfirmacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String [] botones = { "Si", " No", "Finalizar registro" };
				ImageIcon img = scaleImage("/imagenes/pawprint.png", 30 ,30) ;
				int variable = JOptionPane.showOptionDialog (null, " ¿Desea añadir mas mascotas a su perfil?", "Mascotas", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,img, botones, botones[0]);
				String tipo1 = (String) tipo.getSelectedItem();
				String raza1= (String) raza.getSelectedItem();
				int edad1 = Integer.parseInt(edad.getText());
				Mascotas mascota = new Mascotas("1234ID",nombre.getText(),tipo1,raza1,edad1,urlFoto,descripcionfisica.getText());
				mascotas.pushFront(mascota);
				if(variable==0) {
					RegistroMascotasNatural na = new RegistroMascotasNatural();
					na.setVisible(true);
				}else if(variable==1) {
					
				}else {
					setVisible(false);
						
					//Natural nuevoUsu = Natural(nombre.getText());		
				}
			}
		});
		panel.add(lblbotonconfirmacion);
		crearFondo();
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
		
		JLabel lblDescripcionCondicion = new JLabel("Descripcion condicion");
		lblDescripcionCondicion.setFont(new Font("Swis721 Ex BT", Font.PLAIN, 12));
		lblDescripcionCondicion.setBounds(136, 377, 165, 14);
		panel.add(lblDescripcionCondicion);
		JTextArea descripcionfisica_1 = new JTextArea();
		descripcionfisica_1.setSelectionColor(SystemColor.textHighlight);
		descripcionfisica_1.setLineWrap(true);
		descripcionfisica_1.setFont(new Font("Monospac821 BT", Font.PLAIN, 13));
		descripcionfisica_1.setCaretColor(Color.BLACK);
		descripcionfisica_1.setBorder(new LineBorder(new Color(119, 136, 153)));
		descripcionfisica_1.setBounds(76, 391, 277, 64);
		panel.add(descripcionfisica_1);
		
		
	}
	public void crearFondo() {
		fondoImage = new JLabel();
		fondoImage.setBounds(0, 0, 439, 678);
		ImageIcon fondo1= scaleImage("/imagenes/perfil persona natural (4).png",fondoImage.getWidth(), fondoImage.getHeight());
		fondoImage.setIcon(fondo1);	
		panel.add(fondoImage);
		
	
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
