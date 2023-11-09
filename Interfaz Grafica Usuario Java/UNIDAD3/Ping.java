package UNIDAD3;

public class Ping extends Thread{
	Semaforo sping, spong;
	
	public Ping(Semaforo sping, Semaforo spong) {
		this.sping=sping;
		this.spong=spong;
	}
		
	public void run() {
		for(int i=0; i<10; i++) {
			sping.Espera();
			System.out.println("PING");
			spong.Libera();
		}
	}

}
