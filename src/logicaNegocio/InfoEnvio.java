package logicaNegocio;

import java.io.Serializable;

public class InfoEnvio implements Serializable {
	public InfoEnvio() {
		
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	private String nick;
	private String ip;
	private String mensaje;
	
}
