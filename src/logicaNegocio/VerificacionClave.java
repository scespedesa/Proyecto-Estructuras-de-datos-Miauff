package logicaNegocio;

public class VerificacionClave {
	public boolean esDebil(String contrasenia) {
		int contLetrasMin=0 ;
		int contLetrasMay=0 ;
		int contSimbol=0 ;
		int contDigit=0 ;

		if((contrasenia.matches(".*\\s.*"))||(contrasenia.length()<8)) {
			return true ;
		}
		if (contrasenia.matches(".*[a-z]+.*")) {
			contLetrasMin=1 ;
		}if (contrasenia.matches(".*[A-Z]+.*")) {
			contLetrasMay=1 ;
		}if (contrasenia.matches(".*[0-9]+.*")) {
			contDigit=1 ;
		}if(contrasenia.matches(".*\\W.*")) {
			contSimbol=1 ;
		}if (contLetrasMin+contLetrasMay+contSimbol+contDigit<3) {
			return true;
		}else {
			return false;
		}

	}
}
