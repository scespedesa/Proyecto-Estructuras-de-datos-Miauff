package ui;

import java.awt.BorderLayout;
import java.awt.Color;
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

import rojeru_san.componentes.RSDateChooser;

import java.text.SimpleDateFormat;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistroPersonas extends JFrame {
	private JPanel contentPane;
	private JPanel panel ;
	private Image fondo;
	private Image menu ;
	private int alturaPantalla;
	private int anchoPantalla;
	private String urlFoto;
	private String urlHoja;
	private String urlVideo;
	private String campo3 = "";
	private JLabel fondoImage;
	private JTextField textField;
	private JTextField telefono;
	private JTextField direccion;
	
	public RegistroPersonas() {
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
	registro.setHorizontalAlignment(SwingConstants.CENTER);
	registro.setBounds(134, 115, 165, 43);
	registro.setForeground(SystemColor.desktop);
	registro.setFont(new Font("Monospaced", Font.PLAIN, 32));
	panel.add(registro);

	JLabel lblNombre = new JLabel("Nombre completo");
	creacionEtiquetas(92, 165, 229, 21,lblNombre);
	
	JLabel lblFecha = new JLabel("Fecha de Nacimiento");
	creacionEtiquetas(92, 215, 229, 23,lblFecha);

	RSDateChooser dateChooser = new RSDateChooser();
	dateChooser.setBounds(92, 235, 253, 23);
	panel.add(dateChooser);
	JButton btnAceptar = new JButton("ok");
	btnAceptar.setBorder(new LineBorder(new Color(119, 136, 153)));
	btnAceptar.setFont(new Font("Monospac821 BT", Font.PLAIN, 11));
	btnAceptar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Date fecha= dateChooser.getDatoFecha();
			SimpleDateFormat sd= new SimpleDateFormat("dd MMMM yyy");
			campo3= sd.format(fecha);
		}
	});
	btnAceptar.setBounds(293, 260, 52, 19);
	panel.add(btnAceptar);
	
	JTextField nombre = new JTextField();
	nombre.setBorder(new LineBorder(new Color(119, 136, 153)));
	creacionCampoTexto(13,92, 222, 253, 25, nombre);
	
	JLabel lblsexo = new JLabel("Sexo");
	creacionEtiquetas(92, 275, 229, 21,lblsexo);
	
	JComboBox sexo = new JComboBox();
	String [] eleccion = new String[] {"Mujer", "Hombre", "No binario"} ;
	creacionCombo(122, 370, 225, 25, sexo, eleccion);
	
	JLabel lblTelefono = new JLabel("Telefono");
	creacionEtiquetas(92,325, 229, 21,lblTelefono);
	
	JTextField telefono = new JTextField();
	telefono.setForeground(Color.BLACK);
	telefono.setFont(new Font("Monospac821 BT", Font.PLAIN, 13));
	telefono.setBorder(new LineBorder(new Color(119, 136, 153)));
	telefono.setBounds(92, 345, 253, 25);
	panel.add(telefono);
	
	JLabel lblLugarResidencia = new JLabel("Dirección de residencia");
	creacionEtiquetas(92, 375, 229, 21,lblLugarResidencia);
	
	JTextField direccion = new JTextField();
	direccion.setForeground(Color.BLACK);
	direccion.setFont(new Font("Monospac821 BT", Font.PLAIN, 13));
	direccion.setBorder(new LineBorder(new Color(119, 136, 153)));
	direccion.setBounds(92, 395, 253, 25);
	panel.add(direccion);
	
	
	JLabel lbldescripcion = new JLabel("Descripcion");
	creacionEtiquetas(92, 425, 229, 21,lbldescripcion);
	
	JTextArea textArea = new JTextArea();
	textArea.setBorder(new LineBorder(new Color(119, 136, 153)));
	textArea.setCaretColor(Color.BLACK);
	textArea.setSelectionColor(new Color(0, 120, 215));
	textArea.setBounds(92, 445, 253, 105);
	textArea.setFont(new Font("Monospac821 BT", Font.PLAIN, 13));
	textArea.setLineWrap(true); 
	panel.add(textArea);
		
	JButton btnsiguiente = new JButton("Siguiente");
	btnsiguiente.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			String [] botones = { "Si", " No", "Terminar perfil" };
			int variable = JOptionPane.showOptionDialog (null, " ¿Desea añadir mascotas a su perfil?", "Mascotas", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null/*icono*/, botones, botones[0]);
			System.out.println(variable);
			if(variable==0) {
				ventana2();
			}else if(variable==1) {
				
			}else {
				dispose();
			}
			
			
		}
	});
	btnsiguiente.setBounds(256, 558, 89, 23);
	btnsiguiente.setForeground(Color.BLACK);
	btnsiguiente.setBorder(new LineBorder(new Color(119, 136, 153), 1, true));
	btnsiguiente.setBackground(new Color(253, 245, 230));
	btnsiguiente.setFont(new Font("Monospaced", Font.PLAIN, 14));
	panel.add(btnsiguiente);	
	crearFondo();
}
public void ventana2() {
	crearMenu();
	
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
	caja.setBounds(92,295,253,25);
	caja.setFont(new Font("Monospac821 BT", Font.PLAIN, 13));
	panel.add(caja);
	AutoCompleteDecorator.decorate(caja);
}
public void creacionEtiquetas(int x, int y ,int ancho , int alto, JLabel label) {
	label.setBounds(x, y, ancho, alto);
	label.setFont(new Font("Monospaced", Font.BOLD, 13));
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
}

