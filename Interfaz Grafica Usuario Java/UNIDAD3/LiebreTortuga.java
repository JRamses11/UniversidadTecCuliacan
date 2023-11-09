package UNIDAD3;
import UNIDAD1.*;
public class LiebreTortuga {
	static class Liebre extends Thread {
		private int km;
		public Liebre() {
			km=0;
		}
		public void run() {
			int no=0;
			while (km<100) {
				km+=Rutinas.nextInt(1, 3);
				System.out.println(getName()+" km = "+km);
				no++;
				if( no % 5 ==0) {
					try {
						sleep(10);
					} catch (Exception e) {

					}
				}
			}
			System.out.println(getName()+" ha ganado la carrera");	

		}
	}
	static class Tortuga extends Thread {
		private int km;
		public Tortuga() {
			km=0;
		}

		public void run() {
			while (km<100) {
				km++;
				System.out.println(getName()+" km = "+km);
			}
			System.out.println(getName()+" ha ganado la carrera");
		}		
	}
	
	public static void main(String [] a) {
		Liebre liebre=new Liebre();
		Tortuga tortuga=new Tortuga();
		liebre.setName("Liebre ");
		tortuga.setName("Tortuga ");
		liebre.start();
		tortuga.start();
		
	}
}
