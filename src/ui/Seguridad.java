package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import dataStructures.HashTable;
import logicaNegocio.Conexion;
import logicaNegocio.VerificacionClave;


public class Seguridad extends JFrame  {
	private JPanel contentPane;
	private int alturaPantalla;
	private int anchoPantalla;
	public JPasswordField passwordField;
	public JTextField usuario;
	private String usuarioText ;
	private String con;



	public Seguridad() {
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Dimension dimension= mipantalla.getScreenSize();
		this.alturaPantalla= dimension.height;
		this.anchoPantalla = dimension.width;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(anchoPantalla/3, alturaPantalla/4 , 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("menu");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Salir");
		mnNewMenu.add(mntmNewMenuItem);
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setForeground(Color.RED);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		passwordField = new JPasswordField();
		passwordField.setText("");
		passwordField.setBounds(112, 178, 176, 31);
		panel.add(passwordField);

		usuario = new JTextField();
		usuario.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		usuario.setBounds(112, 86, 176, 31);
		panel.add(usuario);
		usuario.setColumns(10);

		JLabel usu = new JLabel("Usuario");
		usu.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		usu.setBounds(91, 51, 118, 23);
		panel.add(usu);

		JLabel contrasenia = new JLabel("Contrase\u00F1a");
		contrasenia.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		contrasenia.setBounds(91, 153, 78, 14);
		panel.add(contrasenia);


		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.setBorder(new MatteBorder(2, 1, 1, 1, (Color) new Color(153, 0, 51)));
		btnNewButton.setBackground(new Color(255, 204, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String contra = new String( passwordField.getPassword());
				VerificacionClave o = new VerificacionClave();
				boolean ver = o.esDebil(contra);
				if (!ver) {
					usuarioText= usuario.getText();
					con = contra ;
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
							usu.put(key,value);
						}
						String contrasenia = new String(passwordField.getPassword());
						if(!usu.find(usuario.getText(),contrasenia)) {
							dispose();
						}else {
							JOptionPane.showMessageDialog(null,"El Usuario ya existe"+ "\n"+ " Por favor elija un usuario diferente" , "Error usuario existente", JOptionPane.INFORMATION_MESSAGE);
						}
					}catch (SQLException ex) {
						System.out.println(ex);
					}
				}else {
					JOptionPane.showMessageDialog(null,"Contrasenia invalida"+ "\n"+ "Debe tener como minimo 8 caracteres con :" +"\n"+" Mayusculas , minusculas , numeros y simbolos", "Error contrasenia invalida", JOptionPane.INFORMATION_MESSAGE);
				}			
			}
		});
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		btnNewButton.setBounds(260, 272, 104, 23);
		panel.add(btnNewButton);

	}

	public String getUsuarioText() {
		return usuarioText;
	}
	public String getCon() {
		return con;
	}

}
