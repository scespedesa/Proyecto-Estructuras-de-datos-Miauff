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
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import logicaNegocio.BusquedaArchivos;
import dataStructures.HashTable;
import rojeru_san.componentes.RSDateChooser;

import java.text.SimpleDateFormat;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class RegistroUsuario extends JFrame {

	private int alturaPantalla;
	private int anchoPantalla;
	private JPanel panel ;
	private JLabel fondoImage;
	private Image menu;
	private JPasswordField passwordField;
	public String urlFoto;
	public String usuario;
	public String contraseña;


	public RegistroUsuario() {
		
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Dimension dimension= pantalla.getScreenSize();
		this.alturaPantalla= dimension.height;
		this.anchoPantalla = dimension.width;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(anchoPantalla/3, 10 , anchoPantalla/3, alturaPantalla - alturaPantalla/10);
		JPanel contentPane = new JPanel();
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
	}
	

	public void ventana() {
		crearMenu();
		
		JLabel registro = new JLabel("Registro");
		registro.setHorizontalAlignment(SwingConstants.CENTER);
		registro.setBounds(135, 121, 165, 43);
		registro.setForeground(SystemColor.desktop);
		registro.setFont(new Font("Monospaced", Font.PLAIN, 32));
		panel.add(registro);

		JLabel lbldesea = new JLabel("Si lo desea adjunte");
		creacionEtiquetas(92, 180, 253, 25,lbldesea);
		lbldesea.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblfoto = new JLabel("Una foto de perfil ->");
		creacionEtiquetas(92, 220, 231, 23,lblfoto);
		lblfoto.setFont(new Font("Monospaced", Font.PLAIN, 14));
		panel.add(lblfoto);

		JLabel lblfo = new JLabel("Foto");
		lblfo.setBounds(190, 250, 57, 47);
		ImageIcon ima = scaleImage("/imagenes/Basic_Ui_(74).jpg",lblfo.getWidth(),lblfo.getHeight());
		lblfo.setIcon(ima);
		lblfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BusquedaArchivos b = new BusquedaArchivos() ;
				urlFoto = b.busqueda(e,panel);
			}
		});
		panel.add(lblfo);
		
		JButton btnAadirMascotas = new JButton("A\u00F1adir mascotas");
		btnAadirMascotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroMascotasNatural na = new RegistroMascotasNatural();
				na.setVisible(true);
				na.getMascotas();
			}
		});
		btnAadirMascotas.setForeground(Color.BLACK);
		btnAadirMascotas.setFont(new Font("Monospaced", Font.PLAIN, 14));
		btnAadirMascotas.setBorder(new LineBorder(new Color(119, 136, 153), 1, true));
		btnAadirMascotas.setBackground(new Color(253, 245, 230));
		btnAadirMascotas.setBounds(157, 308, 123, 23);
		panel.add(btnAadirMascotas);
		JLabel lblusu = new JLabel("Usuario");
		lblusu.setFont(new Font("Monospaced", Font.PLAIN, 14));
		lblusu.setBounds(92, 335, 253, 25);
		panel.add(lblusu);
		
		JTextField usuario1 = new JTextField();
		usuario1.setForeground(Color.BLACK);
		usuario1.setFont(new Font("Monospac821 BT", Font.PLAIN, 13));
		usuario1.setBorder(new LineBorder(new Color(119, 136, 153)));
		usuario1.setBounds(92, 364, 253, 25);
		panel.add(usuario1);
		
		JLabel lblcontra = new JLabel("Contraseña");
		lblcontra.setFont(new Font("Monospaced", Font.PLAIN, 14));
		lblcontra.setBounds(92, 415, 253, 25);
		panel.add(lblcontra);
			
		passwordField = new JPasswordField();
		passwordField.setBounds(94, 443, 251, 25);
		panel.add(passwordField);
		
			
		JButton btnsiguiente = new JButton("Registrar");
		btnsiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// verificar si el usuario ya se encuentra en la base de datos
				//HashTable usui = new HashTable(9);
				//usui.put("prueba", "micontraseña");
				usuario = usuario1.getText();
				contraseña =new String(passwordField.getPassword());
				if(usuario!=null && contraseña!=null) {
					dispose();
				}
				
				
			}
		});
		btnsiguiente.setBounds(253, 495, 89, 23);
		btnsiguiente.setForeground(Color.BLACK);
		btnsiguiente.setBorder(new LineBorder(new Color(119, 136, 153), 1, true));
		btnsiguiente.setBackground(new Color(253, 245, 230));
		btnsiguiente.setFont(new Font("Monospaced", Font.PLAIN, 14));
		panel.add(btnsiguiente);	
		crearFondo();
	}
	public void crearFondo() {
		fondoImage = new JLabel();
		fondoImage.setBounds(0, 0, 439, 653);
		ImageIcon fondo1= scaleImage("/imagenes/registro (2).png",fondoImage.getWidth(), fondoImage.getHeight());
		fondoImage.setIcon(fondo1);	
		panel.add(fondoImage);	
		
		
	}
	public void creacionCombo(int x, int y ,int ancho , int alto, JComboBox caja, String[] lista) {
		
	}
	public void creacionEtiquetas(int x, int y ,int ancho , int alto, JLabel label) {
		label.setBounds(x,y, ancho, alto);
		label.setFont(new Font("Monospaced", Font.BOLD, 15));
		panel.add(label);
	}
	public void creacionCampoTexto(int tamañoLetra,int x,int y,int ancho,int largo, JTextField field) {
		field.setBounds(92,185,ancho,largo);
		field.setFont(new Font("Monospac821 BT", Font.PLAIN, tamañoLetra));
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
	public String getUrlFoto() {
		return urlFoto;
	}


	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

}
