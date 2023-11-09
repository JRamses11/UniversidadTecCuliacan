package UNIDAD3;

public class AplPingPong {

	public static void main(String[] args) {
		Semaforo sping=new Semaforo(1);
		Semaforo spong=new Semaforo(0);
		
		Ping ping=new Ping(sping,spong);
		Pong pong=new Pong(sping,spong);
		ping.setPriority(Thread.MIN_PRIORITY);
		pong.setPriority(Thread.MAX_PRIORITY);
		ping.start();
		pong.start();
		
	}

}

