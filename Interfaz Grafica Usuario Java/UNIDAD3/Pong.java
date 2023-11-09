package UNIDAD3;

public class Pong extends Thread{
	Semaforo sping, spong;
	
	public Pong(Semaforo sping, Semaforo spong) {
		this.sping=sping;
		this.spong=spong;
	}
	public void run() {
		for(int i=0; i<10; i++) {
			spong.Espera();
			System.out.println("PONG");
			sping.Libera();
		}
	}
}
