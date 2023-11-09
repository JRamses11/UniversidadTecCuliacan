package ProyectoU3;
import UNIDAD3.*;

public class Tenedor {
	private Semaforo s= new Semaforo(1);
	private boolean usar=false;
	
	public Tenedor() {
		this.s=s;
		this.usar=usar;
	}
	
	public boolean isUsar() {
		return usar;
	}

	public boolean Tomar() {
			s.Espera();
			usar=true;
		return true;
	}
	
	public boolean Soltar() {
			s.Libera();
			usar=false;
		return false;
	}

}
