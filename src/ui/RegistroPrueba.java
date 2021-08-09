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

public class RegistroPrueba extends JFrame {
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
	private JTextField lugarResidencia;
	
	public RegistroPrueba() {
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
	registro.setBounds(133, 130, 165, 43);
	creacionEtiquetas(32,133, 130, 165, 43,registro);

	JLabel lblTelefono = new JLabel("Telefono");
	lblTelefono.setBounds(92, 196, 229, 21);
	creacionEtiquetas(16,92, 196, 229, 21,lblTelefono);
	panel.add(lblTelefono);

	JTextField lugarResidencia = new JTextField();
	lugarResidencia.setForeground(Color.BLACK);
	lugarResidencia.setFont(new Font("Monospac821 BT", Font.PLAIN, 15));
	lugarResidencia.setBorder(new LineBorder(new Color(119, 136, 153)));
	lugarResidencia.setBounds(92, 284, 253, 25);
	panel.add(lugarResidencia);
	
	
	JLabel lblresidencia = new JLabel("Direcci�n de residencia");
	lblresidencia.setBounds(92, 256, 229, 23);
	creacionEtiquetas(16,92, 256, 229, 23,lblresidencia);
	panel.add(lblresidencia);
	
	JTextField nombre = new JTextField();
	nombre.setBorder(new LineBorder(new Color(119, 136, 153)));
	creacionCampoTexto(15,92, 222, 253, 25, nombre);
	
	JLabel lblsexo = new JLabel("Sexo");
	creacionEtiquetas(16,92, 340, 229, 21,lblsexo);
	
	JComboBox sexo = new JComboBox();
	String [] eleccion = new String[] {"Mujer", "Hombre", "No binario"} ;
	creacionCombo(122, 370, 225, 25, sexo, eleccion);
	
	JLabel lbldescripcion = new JLabel("Descripcion");
	creacionEtiquetas(16,92, 400, 229, 21, lbldescripcion);
	
	JTextArea textArea = new JTextArea();
	textArea.setBorder(new LineBorder(new Color(119, 136, 153)));
	textArea.setCaretColor(Color.BLACK);
	textArea.setSelectionColor(new Color(0, 120, 215));
	textArea.setBounds(92, 425, 253, 125);
	textArea.setFont(new Font("Monospac821 BT", Font.PLAIN, 14));
	textArea.setLineWrap(true); 
	panel.add(textArea);
		
	JButton btnsiguiente = new JButton("Siguiente");
	btnsiguiente.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			ventana2();
			dispose();
		}
	});
	btnsiguiente.setBounds(256, 556, 89, 23);
	btnsiguiente.setForeground(Color.BLACK);
	btnsiguiente.setBorder(new LineBorder(new Color(119, 136, 153), 1, true));
	btnsiguiente.setBackground(new Color(253, 245, 230));
	btnsiguiente.setFont(new Font("Monospac821 BT", Font.PLAIN, 14));
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
	caja.setBounds(92,361,253,25);
	caja.setFont(new Font("Monospac821 BT", Font.PLAIN, 14));
	panel.add(caja);
	AutoCompleteDecorator.decorate(caja);
}
public void creacionEtiquetas(int tama�oLetra,int x,int y,int ancho,int largo, JLabel label) {
	label.setBounds(x, y, ancho, largo);
	label.setForeground(SystemColor.desktop);
	label.setFont(new Font("Monospac821 BT", Font.PLAIN, tama�oLetra));
	panel.add(label);

}
public void creacionCampoTexto(int tama�oLetra,int x,int y,int ancho,int largo, JTextField field) {
	field.setBounds(x,y,ancho,largo);
	field.setFont(new Font("Monospac821 BT", Font.PLAIN, tama�oLetra));
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

