package logicaNegocio;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BusquedaArchivos extends JFrame {
	private JPanel panel;
	
	public BusquedaArchivos( ) {
	}
	public String busqueda(java.awt.event.MouseEvent e, JPanel panel ) {
		JFileChooser fc= new JFileChooser();
		FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
		fc.setFileFilter(fil);
		fc.showOpenDialog(this.panel);
		File archivo = fc.getSelectedFile();
		if(archivo!=null) {
			return archivo.getAbsolutePath();
		}else {
			return "";
		}
	}
}
