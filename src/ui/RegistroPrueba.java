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
	private String nacimiento;
	private JTextField textField_1;
	private JLabel lbldesea;
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
	registro.setBounds(133, 117, 165, 43);
	panel.add(registro);

	JLabel lblnombre = new JLabel("Nombre de la organizacion");
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
	JTextField lugarResidencia = new JTextField();
	lugarResidencia.setForeground(Color.BLACK);
	lugarResidencia.setFont(new Font("Monospac821 BT", Font.PLAIN, 15));
	lugarResidencia.setBorder(new LineBorder(new Color(119, 136, 153)));
	lugarResidencia.setBounds(92, 273, 253, 23);
	panel.add(lugarResidencia);
	
	JLabel lblFechaDeLa = new JLabel("Fecha de la creacion");
	lblFechaDeLa.setBounds(92, 200, 229, 21);
	panel.add(lblFechaDeLa);
	textField_1 = new JTextField();
	textField_1.setForeground(Color.BLACK);
	textField_1.setFont(new Font("Monospac821 BT", Font.PLAIN, 15));
	textField_1.setBorder(new LineBorder(new Color(119, 136, 153)));
	textField_1.setBounds(92, 323, 253, 25);
	panel.add(textField_1);

	
	JLabel lblresidencia = new JLabel("Direcci\u00F3n");
	lblresidencia.setBounds(92, 252, 229, 23);
	panel.add(lblresidencia);
	
	JTextField nombre = new JTextField();
	nombre.setBorder(new LineBorder(new Color(119, 136, 153)));
	creacionCampoTexto(15,92, 222, 253, 25, nombre);
	
	JLabel lblsexo = new JLabel("Numero de contacto");
	lblsexo.setBounds(92,305, 110, 21);
	panel.add(lblsexo);
	
	JLabel lbldescripcion = new JLabel("Descripcion");
	lbldescripcion.setBounds(92, 359, 229, 21);
	panel.add(lbldescripcion);
	
	JTextArea textArea = new JTextArea();
	textArea.setBorder(new LineBorder(new Color(119, 136, 153)));
	textArea.setCaretColor(Color.BLACK);
	textArea.setSelectionColor(new Color(0, 120, 215));
	textArea.setBounds(92, 379, 253, 108);
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
	btnsiguiente.setBounds(272, 563, 89, 23);
	btnsiguiente.setForeground(Color.BLACK);
	btnsiguiente.setBorder(new LineBorder(new Color(119, 136, 153), 1, true));
	btnsiguiente.setBackground(new Color(253, 245, 230));
	btnsiguiente.setFont(new Font("Monospac821 BT", Font.PLAIN, 14));
	panel.add(btnsiguiente);
	lbldesea = new JLabel("Si lo desea:");
	lbldesea.setBounds(187, 493, 89, 21);
	panel.add(lbldesea);
	JLabel lblfoto = new JLabel("New label");
	lblfoto.setBounds(92, 525, 70, 49);
	panel.add(lblfoto);
	
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
public void creacionEtiquetas(int tamañoLetra,int x,int y,int ancho,int largo, JLabel label) {
	label.setBounds(92, 359, ancho, largo);
	label.setForeground(SystemColor.desktop);
	label.setFont(new Font("Monospac821 BT", Font.PLAIN, tamañoLetra));
	panel.add(label);

}
public void creacionCampoTexto(int tamañoLetra,int x,int y,int ancho,int largo, JTextField field) {
	field.setBounds(92,171,253,23);
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

