package ui;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import datosUsuarios.Administrador;
import datosUsuarios.Natural;
import logicaNegocio.Conexion;
import logicaNegocio.InfoEnvio;

import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.net.*;
import java.sql.*;


import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
public class Usuario extends JFrame implements Runnable {

	private JPanel contentPane;
	private JTextField textoEnviar;
	private JTextArea areaTexto = new JTextArea();
	private int x;
	private String toContact;
	private String usuario;
	private boolean esAdmin;
	private Administrador organizacion;
    private Natural aficionado;

	/**
	 * Launch the application.
	 */
//	public void correr() {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Usuario frame = new Usuario();
//					frame.setVisible(true);
//					Conexion conec = new Conexion();
//					Connection conexion = conec.Conectar();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Usuario(boolean esAdmin) {
		this.esAdmin= esAdmin;
	//(0,0,450,706)
		 x=1;
		 Ingreso i= new Ingreso();
		usuario=i.usuarioEnviar;
		this.organizacion=i.organizacion;
		this.aficionado=i.aficionado;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,450,745);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton Contactos = new JButton("Contactos");
			JLabel LabelTitulo = new JLabel("USUARIO");
			LabelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			LabelTitulo.setBounds(99, 13, 260, 25);
			contentPane.add(LabelTitulo);
			LabelTitulo.setForeground(new Color(255, 255, 255));
			LabelTitulo.setHorizontalTextPosition(SwingConstants.CENTER);
			LabelTitulo.setVerticalTextPosition(SwingConstants.CENTER);
			LabelTitulo.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 17));
			JPanel panel3 = new JPanel();
			
			JPanel panel2 = new JPanel();
			panel2.setBackground(new Color(255, 255, 255));
			panel2.setBounds(0, 47, 1, 605);
					
			
					panel2.setLayout(null);		
					JButton btnYo = new JButton("Yo");
					btnYo.setBackground(new Color(255, 255, 255));
					
					Thread hilo3 = new Thread() {
						@Override
						public void run() {
							try {
							
							
								
							
								for(int i=0;i<400000000;i++) {
									contentPane.updateUI();
									try {
										Conexion conec = new Conexion();
										Connection conexion = conec.Conectar();
										
										
										PreparedStatement ps =  conexion.prepareStatement("select  NAME,MESSAGE from CHAT, USUARIOS WHERE ((FUSER= ? AND TUSER= ?) OR (FUSER= ? AND TUSER= ?)) and FUSER = USER ");
										ps.setString(1,usuario);
										ps.setString(2,toContact);
										ps.setString(3,toContact);
										ps.setString(4,usuario);
										
										ResultSet r = ps.executeQuery();
										areaTexto.setText("");
										while (r.next()) {
											
											areaTexto.append("\n"+r.getString(1)+": " + r.getString(2));
											
											
										}
										
										}catch (SQLException e1) {
											System.out.println(e1);
										}
									Thread.sleep(2500);
									System.out.println(i);
									
									
									
									
									
									
								}	
								
								
							} catch (InterruptedException e1) {
							
								e1.printStackTrace();
							}

						}
					};hilo3.start();
					
					btnYo.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							panel3.setVisible(true);
							LabelTitulo.setText(btnYo.getText());
							if(x==0) {
								
								Thread hilo = new Thread() {
									@Override
									public void run() {
										try {
										
										try {
										Conexion conec = new Conexion();
										Connection conexion = conec.Conectar();
										
										PreparedStatement ps =  conexion.prepareStatement("select  NAME,MESSAGE from CHAT, USUARIOS WHERE ((FUSER= ? AND TUSER= ?) OR (FUSER= ? AND TUSER= ?)) and FUSER = USER ");
										ps.setString(1, usuario);
										ps.setString(2,toContact);
										ps.setString(3,toContact);
										ps.setString(4, usuario);
										
										ResultSet r = ps.executeQuery();
										areaTexto.setText("");
										while (r.next()) {
											areaTexto.append("\n"+r.getString(1)+": " + r.getString(2));
											
											
										}
										contentPane.updateUI();
										}catch (SQLException e1) {
											System.out.println(e1);
										}
										
										
											for(int i=0;i<434;i++) {
												Thread.sleep(1);
												panel2.setSize(434-i, 605);
												contentPane.updateUI();
												x=0;
												
												
											}	
											
											
										} catch (InterruptedException e1) {
										
											e1.printStackTrace();
										}

									}
								};hilo.start();

							
						
						}
							

						}
					});
					btnYo.setBounds(0, 0, 434, 61);
					panel2.add(btnYo);
					
					JButton btnDavid = new JButton("David");
					btnDavid.setBackground(new Color(255, 255, 255));
					btnDavid.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							
							
							toContact= "dav2021";
							LabelTitulo.setText(btnDavid.getText());
				
					
								x=1;
								panel3.setVisible(true);
								
								if(x==1){
									System.out.println("entra if");
									Thread hilo2 = new Thread() {
										@Override
										public void run() {
											try {
												System.out.println("entra try");
												for(int i=0;i<434;i++) {
													Thread.sleep(1);
													panel2.setSize(434-i, 605);
													contentPane.updateUI();
													x=0;
													
													
												
												
											}} catch (InterruptedException e1) {
											
												e1.printStackTrace();
											}
				
										}
									};hilo2.start();
				
									
								
								}
								
							}
							
						
					});
					btnDavid.setBounds(0, 60, 434, 61);
					panel2.add(btnDavid);
					
					JButton btnSebastian = new JButton("Sebastian");
					btnSebastian.setBackground(new Color(255, 255, 255));
					btnSebastian.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							toContact= "Sebas";
							LabelTitulo.setText(btnSebastian.getText());
							
	
				
					
								x=1;
								panel3.setVisible(true);
								
								if(x==1){
									System.out.println("entra if");
									Thread hilo2 = new Thread() {
										@Override
										public void run() {
											try {
												System.out.println("entra try");
												for(int i=0;i<434;i++) {
													Thread.sleep(1);
													panel2.setSize(434-i, 605);
													contentPane.updateUI();
													x=0;
													
													
												
												
											}} catch (InterruptedException e1) {
											
												e1.printStackTrace();
											}
				
										}
									};hilo2.start();
				
									
								
								}
							
						}
					});
					btnSebastian.setBounds(0, 120, 434, 61);
					panel2.add(btnSebastian);
					
					JButton btnSamara = new JButton("Samara");
					btnSamara.setBackground(new Color(255, 255, 255));
					btnSamara.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							toContact= "Sam";
							LabelTitulo.setText(btnSamara.getText());
							

				
					
								x=1;
								panel3.setVisible(true);
								
								if(x==1){
									System.out.println("entra if");
									Thread hilo2 = new Thread() {
										@Override
										public void run() {
											try {
												System.out.println("entra try");
												for(int i=0;i<434;i++) {
													Thread.sleep(1);
													panel2.setSize(434-i, 605);
													contentPane.updateUI();
													x=0;
													
													
												
												
											}} catch (InterruptedException e1) {
											
												e1.printStackTrace();
											}
				
										}
									};hilo2.start();
				
									
								
								}
						}
					});
					btnSamara.setBounds(0, 180, 434, 61);
					panel2.add(btnSamara);
					
					JButton btnGomez = new JButton("Juan G");
					btnGomez.setBackground(new Color(255, 255, 255));
					btnGomez.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							toContact= "juan2021";
							LabelTitulo.setText(btnGomez.getText());
							
			
				
					
								x=1;
								panel3.setVisible(true);
								
								if(x==1){
									System.out.println("entra if");
									Thread hilo2 = new Thread() {
										@Override
										public void run() {
											try {
												System.out.println("entra try");
												for(int i=0;i<434;i++) {
													Thread.sleep(1);
													panel2.setSize(434-i, 605);
													contentPane.updateUI();
													x=0;
													
													
												
												
											}} catch (InterruptedException e1) {
											
												e1.printStackTrace();
											}
				
										}
									};hilo2.start();
				
									
								
								}
						}
					});
					btnGomez.setBounds(0, 240, 434, 61);
					panel2.add(btnGomez);
		Contactos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				
			}
		});
		Contactos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LabelTitulo.setText("CONTACTOS");
				panel3.setVisible(false);
			}
		});
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(0, 598, 434, 54);
			panel.setLayout(null);
			
			textoEnviar = new JTextField();
			textoEnviar.setBounds(10, 10, 347, 37);
			panel.add(textoEnviar);
			textoEnviar.setColumns(10);
			
				
				JButton btnEnviar = new JButton("");
				btnEnviar.setBounds(365, 10, 59, 33);
				btnEnviar.setIcon(scaleImage("/Imagenes/enviar.png",31,31));
				
				btnEnviar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						areaTexto.append("\n"+" yo: "+textoEnviar.getText());
						contentPane.updateUI();
						
						try {

							Conexion conec = new Conexion();
							Connection conexion = conec.Conectar();
							
							
							PreparedStatement ps =  conexion.prepareStatement("INSERT INTO CHAT (FUSER,TUSER,MESSAGE) VALUES (?,?,?) ");
							
							ps.setString(1, usuario);
							ps.setString(2, toContact);
							ps.setString(3, textoEnviar.getText());

							ps.executeUpdate();
							
							//Socket socketPrueba= new Socket("192.168.100.11",2222);
							//InfoEnvio datos = new InfoEnvio();
							//datos.setNick("David");
							//datos.setIp(IPContacto.getText());
							//datos.setMensaje(textoEnviar.getText());
							//ObjectOutputStream paquete = new ObjectOutputStream(socketPrueba.getOutputStream());
							
							//paquete.writeObject(datos);
							//socketPrueba.close();
							//textoEnviar.setText("");
						} catch (SQLException e1) {
							
							System.out.println(e1);
						} 
						
						textoEnviar.setText("");
						
					}
				});
				btnEnviar.setContentAreaFilled(false);
				btnEnviar.setBorderPainted(false);
				
					btnEnviar.setPressedIcon(scaleImage("/Imagenes/enviar.png",35,35));
					btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 9));
					btnEnviar.setBackground(new Color(220, 220, 220));
					panel.add(btnEnviar);
					

					contentPane.add(panel);
					contentPane.add(panel2);
					
						panel3.setBounds(0, 53, 434, 498);
						contentPane.add(panel3);
						panel3.setBackground(new Color(255, 255, 255));
						panel3.setLayout(null);
						areaTexto.setEditable(false);
						areaTexto.setBackground(new Color(255, 255, 255));
						areaTexto.setFont(new Font("Microsoft JhengHei", Font.BOLD, 14));
						areaTexto.setBounds(10, 5, 414, 482);
						panel3.add(areaTexto);
		
		
						JButton Mascotas = new JButton("Mascotas");
						Mascotas.setIcon(scaleImage("/imagenes/gato-birmano.png",31,31));
						Mascotas.setVerticalTextPosition(SwingConstants.BOTTOM);
						Mascotas.setHorizontalTextPosition(SwingConstants.CENTER);
						Mascotas.setContentAreaFilled(false);
						Mascotas.setBorderPainted(false);
						Mascotas.setRolloverIcon(scaleImage("/imagenes/gato-birmano.png",34,34));
						Mascotas.setBounds(73, 652, 93, 54);
						contentPane.add(Mascotas);
						Mascotas.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {	
								
			               if(esAdmin) {
			            	   EdicionMascotas perf = new EdicionMascotas(organizacion,true);
			            	   perf.setVisible(true);
			               }else {
			            	   EdicionMascotas perf = new EdicionMascotas(aficionado,false);
			            	   perf.setVisible(true);
			               }
			               dispose();
								}
						});
		
		JButton btnPerfill = new JButton("Perfil");
		btnPerfill.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPerfill.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPerfill.setIcon(new ImageIcon(PerfilNatural2.class.getResource("/imagenes/usuario (5).png")));
		btnPerfill.setRolloverIcon(scaleImage("/imagenes/usuario (5).png",35,35));
		btnPerfill.setBounds(0, 652, 76, 54);
		btnPerfill.setContentAreaFilled(false);
		btnPerfill.setBorderPainted(false);
		
		contentPane.add(btnPerfill);
		btnPerfill.setIcon(new ImageIcon(PerfilNatural2.class.getResource("/imagenes/usuario (5).png")));
		btnPerfill.setRolloverIcon(scaleImage("/imagenes/usuario (5).png",35,35));
		btnPerfill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				dispose();
           if(esAdmin) {
        	   PerfilAdministrador perf = new PerfilAdministrador(organizacion,true);
        	   perf.setVisible(true);
           }else {
        	   PerfilAdministrador perf = new PerfilAdministrador(aficionado,false);
        	   perf.setVisible(true);
           }
				}

		});
		
		JButton Inicio = new JButton("Inicio");
		Inicio.setVerticalTextPosition(SwingConstants.BOTTOM);
		Inicio.setHorizontalTextPosition(SwingConstants.CENTER);
		Inicio.setContentAreaFilled(false);
		Inicio.setBorderPainted(false);
		Inicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				dispose();
				if(esAdmin) {
            PerfilNatural2 frame = new PerfilNatural2(organizacion, 1);
				frame.setVisible(true);}
				else {  PerfilNatural2 frame = new PerfilNatural2(aficionado, 0);
				frame.setVisible(true);}
				}

		});
		Inicio.setBounds(353, 652, 81, 54);
		Inicio.setIcon(scaleImage("/Imagenes/hogar.png",31,31));
		Inicio.setRolloverIcon(scaleImage("/Imagenes/hogar.png",35,35));
		contentPane.add(Inicio);
		
				
				Inicio.setBounds(353, 652, 81, 54);
				Inicio.setIcon(scaleImage("/Imagenes/hogar.png",31,31));
				Inicio.setRolloverIcon(scaleImage("/Imagenes/hogar.png",35,35));
				contentPane.add(Inicio);
		
				JButton Publicar = new JButton("Adoptar");
				Publicar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AdoptarMascota a= new AdoptarMascota();
						a.correr();
					}
				});
				Publicar.setVerticalTextPosition(SwingConstants.BOTTOM);
				Publicar.setHorizontalTextPosition(SwingConstants.CENTER);
				Publicar.setContentAreaFilled(false);
				Publicar.setBorderPainted(false);
				
				Publicar.setBounds(171, 652, 93, 54);
				Publicar.setIcon(scaleImage("/imagenes/mas (1).png",31,31));
				Publicar.setRolloverIcon(scaleImage("/imagenes/mas (1).png",34,34));
				contentPane.add(Publicar);
		
		Contactos.setIcon(new ImageIcon(Usuario.class.getResource("/Imagenes/telefono.png")));
		Contactos.setVerticalTextPosition(SwingConstants.BOTTOM);
		Contactos.setHorizontalTextPosition(SwingConstants.CENTER);
		Contactos.setContentAreaFilled(false);
		Contactos.setBorderPainted(false);
		Contactos.setBounds(264, 652, 93, 54);
		
				Contactos.setRolloverIcon(scaleImage("/Imagenes/telefono.png",35,35));
				
					contentPane.add(Contactos);
					
							Contactos.addMouseListener(new MouseAdapter() {
					
								@Override
								public void mouseClicked(MouseEvent e) {
									System.out.println("hola");
									x=1;
									if(x==1){
									
										Thread hilo2 = new Thread() {
											@Override
											public void run() {
												try {
													
													for(int i=0;i<434;i++) {
														Thread.sleep(1);
													
														
														panel2.setSize( i, 605);
														x=0;
													}	
													
													
												} catch (InterruptedException e1) {
												
													e1.printStackTrace();
												}
					
											}
										};hilo2.start();
					
										
									
									}
									
								}
								
							});
		
		JLabel Fondo = new JLabel("");
		Fondo.setBackground(new Color(255, 255, 255));
		
			Fondo.setBounds(0,0,450,706);
			Fondo.setIcon( scaleImage("/Imagenes/FondoInterfazChat.jpg",450,760));
			contentPane.add(Fondo);
			
			JPanel panelContactos = new JPanel();
			panelContactos.setBounds(0, 47, 434, 602);;;
		
		//IPContacto = new JTextField();
		//IPContacto.setBounds(207, 13, 86, 20);
		//panel.add(IPContacto);
		//IPContacto.setColumns(10);

		Thread hilo= new Thread(this);
		hilo.start();
		
	}

	@Override
	public void run() {
		try {
			ServerSocket servidoUsuario=new ServerSocket(9090);
			Socket usuario;
			InfoEnvio paquete;
			while(true){
				usuario=servidoUsuario.accept();
				ObjectInputStream entrada= new ObjectInputStream(usuario.getInputStream());
				paquete=(InfoEnvio) entrada.readObject();
				areaTexto.append("\n"+paquete.getNick()+": "+paquete.getMensaje());
				usuario.close();
				entrada.close();
				
			}
		}catch(Exception e) {
			
		}
	}
	public ImageIcon scaleImage(String url, int ancho , int altura) {
		ImageIcon icon = new ImageIcon(Usuario.class.getResource(url));
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(ancho, altura, Image.SCALE_SMOOTH);
		return new ImageIcon(imgScale);

	}
}
