package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class PerfilAdministrador extends JFrame{

	private int alturaPantalla;
	private int anchoPantalla;
	private JPanel panel;

	public PerfilAdministrador() {
		Toolkit pantalla = Toolkit.getDefaultToolkit();
		Dimension dimension= pantalla.getScreenSize();
		this.alturaPantalla= dimension.height;
		this.anchoPantalla = dimension.width;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(anchoPantalla/3, 10 , 450, 706);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Perfil Admin");
		setResizable(false);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.DARK_GRAY);
		panel.setBounds(0, 0,450, 706);
		contentPane.add(panel);
		panel.setLayout(null);
			
		JLabel jijo = new JLabel("<html>" +"estoe es un intent " + "\n"+ "lo otroo jajajajajajajajajagrt"+ "\n"+ "ggtrfgggggggggggggggggggggggggggggggggggg"
				+ "+ \"\\n\"+ ggggggggggggggggggggggggggggggggggggg"
				+ "gggggggggggggggggggggggggggggggggggggggggggggggggj"+"<html>");
		jijo.setBounds(0, 11, 434, 284);
		panel.add(jijo);
		
		JLabel lblfondo = new JLabel("New label");	
		lblfondo.setBounds(0, 0, 434, 667);
		ImageIcon ji = scaleImage("/imagenes/fondi (1).png", lblfondo.getWidth(),lblfondo.getHeight()) ;
		lblfondo.setIcon(ji);
		panel.add(lblfondo);
	

	}
	public ImageIcon scaleImage(String url, int ancho , int altura) {
		ImageIcon icon = new ImageIcon(RegistroPersonas.class.getResource(url));
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(ancho, altura, Image.SCALE_SMOOTH);
		return new ImageIcon(imgScale);

	}
}
