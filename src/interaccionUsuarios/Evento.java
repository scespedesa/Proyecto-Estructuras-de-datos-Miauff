package interaccionUsuarios;

import dataStructures.PilaListaEnlazada;

public class Evento extends Interaccion{
	private char[] fecha ;
    private Double numeroDeAsistentes;
    private String tipoDeEvento;

	public Evento(String autor,PilaListaEnlazada<String> contenido, char[] fecha, Double numeroDeAsistentes, String tipoDeEvento) {
		super(autor,contenido);
		this.fecha=fecha;
        this.numeroDeAsistentes=numeroDeAsistentes;
        this.tipoDeEvento=tipoDeEvento;
	}
	
    public void compartirEvento(){

    }
	public char[] getFecha() {
		return fecha;
	}
	public void setFecha(char[] fecha) {
		this.fecha = fecha;
	}
	public Double getNumeroDeAsistentes() {
		return numeroDeAsistentes;
	}
	public void setNumeroDeAsistentes(Double numeroDeAsistentes) {
		this.numeroDeAsistentes = numeroDeAsistentes;
	}
	public String getTipoDeEvento() {
		return tipoDeEvento;
	}
	public void setTipoDeEvento(String tipoDeEvento) {
		this.tipoDeEvento = tipoDeEvento;
	}

}
