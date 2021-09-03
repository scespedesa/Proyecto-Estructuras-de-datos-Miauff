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

public class RegistroMascotasNatural extends JFrame{
	private int alturaPantalla;
	private int anchoPantalla;
	private JPanel panel ;
	private JLabel fondoImage;
	private Image menu;
	private JPasswordField passwordField;
	private String urlFoto;
	private JTextField nombre;
	private JTextField edad;
	private MyArrayList<Mascotas> mascotas = new MyArrayList<Mascotas>();
	

	public RegistroMascotasNatural() {
		mascotas = new MyArrayList();
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Dimension dimension= pantalla.getScreenSize();
		this.alturaPantalla= dimension.height;
		this.anchoPantalla = dimension.width;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(anchoPantalla/3, 10 , anchoPantalla/3, alturaPantalla - alturaPantalla/15);
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
		JTextField nombre = new JTextField();
		nombre.setBounds(76, 140, 277, 25);
		panel.add(nombre);
		
		JTextField edad = new JTextField();
		edad.setBounds(76, 295, 277, 26);
		panel.add(edad);
		
		JLabel lbln = new JLabel("Nombre");
		lbln.setFont(new Font("Swis721 Ex BT", Font.PLAIN, 12));
		lbln.setBounds(180, 123, 68, 14);
		panel.add(lbln);
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Swis721 Ex BT", Font.PLAIN, 12));
		lblTipo.setBounds(188, 172, 58, 14);
		panel.add(lblTipo);
		

		JComboBox tipo = new JComboBox();
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
		JLabel lblDescripcionFisica = new JLabel("Descripcion fisica");
		lblDescripcionFisica.setFont(new Font("Swis721 Ex BT", Font.PLAIN, 12));
		lblDescripcionFisica.setBounds(165, 332, 125, 14);
		panel.add(lblDescripcionFisica);
		
		JTextArea descripcionfisica = new JTextArea();
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
		JLabel lblbotonconfirmacion = new JLabel();
		lblbotonconfirmacion.setBounds(198, 531, 54, 54);
		ImageIcon huella= scaleImage("/imagenes/garritaboton.png",lblbotonconfirmacion.getWidth(), lblbotonconfirmacion.getHeight());
		lblbotonconfirmacion.setIcon(huella);	
		lblbotonconfirmacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblbotonconfirmacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String [] botones = { "Si", " No" };
				ImageIcon img = scaleImage("/imagenes/pawprint.png", 30 ,30) ;
				int variable = JOptionPane.showOptionDialog (null, " �Desea agregar mas mascotas a su perfil?", "Mascotas", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,img, botones, botones[0]);
				String tipo1 = (String) tipo.getSelectedItem();
				String raza1= (String) raza.getSelectedItem();
				int edad1 = Integer.parseInt(edad.getText());
				Mascotas mascota = new Mascotas(nombre.getText(),tipo1,raza1,urlFoto,edad1,descripcionfisica.getText());
				mascotas.pushBack(mascota);
				if(variable==0) {
					nombre.setText(null);
					tipo.setSelectedItem(null);
					raza.setSelectedItem(null);
					edad.setText(null);
					descripcionfisica.setText(null);
				}else {
					dispose();
				}
			}
		});
		panel.add(lblbotonconfirmacion);
		crearFondo();
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
		caja.setBounds(76,189,277,25);
		caja.setFont(new Font("Monospac821 BT", Font.PLAIN, 13));
		panel.add(caja);
		AutoCompleteDecorator.decorate(caja);
	}
	public ImageIcon scaleImage(String url, int ancho , int altura) {
		ImageIcon icon = new ImageIcon(RegistroPersonas.class.getResource(url));
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(ancho, altura, Image.SCALE_SMOOTH);
		return new ImageIcon(imgScale);
	}

	public MyArrayList getMascotas() {
		return mascotas;
	}

	public void setMascotas(MyArrayList mascotas) {
		this.mascotas = mascotas;
	}
	
}
