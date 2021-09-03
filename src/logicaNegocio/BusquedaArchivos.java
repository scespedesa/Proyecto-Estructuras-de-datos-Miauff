package logicaNegocio;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BusquedaArchivos extends JFrame {
	private JLabel l;
	
	public BusquedaArchivos( ) {
	}
	
	public String busqueda(java.awt.event.MouseEvent e ) {
		l = new JLabel();
	    l.setBounds(10,10,365,290);
	    add(l);
	    setLayout(null);
	    setLocationRelativeTo(null);
	    setSize(400,400);
	    setVisible(true);
	    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		JFileChooser fc= new JFileChooser();
		//*****definir donde******
		fc.setCurrentDirectory(new File(System.getProperty("user.home")));
		FileNameExtensionFilter fil = new FileNameExtensionFilter("*.Images", "JPG, PNG & GIF","jpg","png","gif");
		fc.setFileFilter(fil);
		fc.showOpenDialog(this.l);
		File archivo = fc.getSelectedFile();
		String path = archivo.getAbsolutePath();
		if(archivo!=null) {
	    l.setIcon(resize(path));
	    JOptionPane.showMessageDialog(null,"Foto guardada", "Exito", JOptionPane.INFORMATION_MESSAGE);
			return path;
		}else {
			return "";
		}
		
	}
	  public ImageIcon resize(String imgPath)
	  {
	    ImageIcon path = new ImageIcon(imgPath);
	    Image img = path.getImage();
	    Image newImg = img.getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_SMOOTH);
	    ImageIcon image = new ImageIcon(newImg);
	    return image;
	  }
}
