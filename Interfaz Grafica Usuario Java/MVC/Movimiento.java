package MVC;

public class Movimiento {
	private char ini,fin;
	private int disco;
	public Movimiento(char ini,char fin, int disco) {
		this.ini=ini;
		this.fin=fin;
		this.disco=disco;
	}
	public char getIni() {
		return ini;
	}
	public void setIni(char ini) {
		this.ini = ini;
	}
	public char getFin() {
		return fin;
	}
	public void setFin(char fin) {
		this.fin = fin;
	}
	public int getDisco() {
		return disco;
	}
	public void setDisco(int disco) {
		this.disco = disco;
	}
	
}