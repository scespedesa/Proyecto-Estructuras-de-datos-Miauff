package logicaNegocio;
import java.io.IOException;
import java.net.URISyntaxException;
public class AbrirSitioWeb {
	public AbrirSitioWeb(String enlace) {
		if(java.awt.Desktop.isDesktopSupported()) {
			java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
			if(desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
				try {
					java.net.URI uri = new java.net.URI(enlace);
					desktop.browse(uri);
				}catch(URISyntaxException | IOException ex) {}		
			}
		}
	}
}
