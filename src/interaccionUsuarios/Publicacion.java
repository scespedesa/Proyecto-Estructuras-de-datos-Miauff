package interaccionUsuarios;
import dataStructures.Nodo;

import dataStructures.PilaListaEnlazada;

import javax.swing.Icon;

public class Publicacion extends Interaccion{
    private String publicacionID;
    private Icon Imagen;
    private String titulo;
    private String descripcion;
    
    public Publicacion(String autor, String titulo, String descripcion , String publicacionID, Icon Imagen) {
    	super(autor, null);   
        this.descripcion= descripcion;
        this.titulo=titulo;
		this.publicacionID=publicacionID;
		this.Imagen=Imagen;
		Nodo<String> subcontent = new Nodo(titulo,descripcion,null,null);
		PilaListaEnlazada<String> content = new PilaListaEnlazada(subcontent);
		this.setContenido(content);
	}
    public void crearPublicacion(){

    }
    public void editarPublicacion(){
        
    }
    public void eliminarPublicacion(){

    }
	public String getPublicacionID() {
		return publicacionID;
	}
	public void setPublicacionID(String publicacionID) {
		this.publicacionID = publicacionID;
	}

	public Icon getImagen() {
		return Imagen;
	}
	public void setImagen(Icon imagen) {
		Imagen = imagen;
	}
    
    

    
	
    

}


