package interaccionUsuarios;
import dataStructures.PilaListaEnlazada;

public abstract class Interaccion {
	
    protected String autor;
    protected PilaListaEnlazada<String> contenido = new PilaListaEnlazada<String>(null);
    
	public Interaccion(String autor,  PilaListaEnlazada<String> contenido2) {

		this.autor = autor;
		this.contenido = contenido2;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}


	public void setContenido(PilaListaEnlazada<String> contenido) {
		this.contenido = contenido;
	}


    
}
