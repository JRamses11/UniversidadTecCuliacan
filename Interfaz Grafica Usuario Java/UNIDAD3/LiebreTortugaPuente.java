package UNIDAD3;

import UNIDAD1.Rutinas;


class Liebre extends Thread {
	private int km;
	private Semaforo s,sem;
	boolean []gano;
	public Liebre(Semaforo s,Semaforo sem,boolean [] gano) {
		this.s=s;
		km=0;
		this.sem=sem;
		this.gano=gano;
		
	}
	public void run() {
		int no=0;
		boolean tiene=false;
		while (km<100) {
			km+=1;// Rutinas.nextInt(1, 3);
			System.out.println(getName()+" km = "+km);
			if(km>=10 && km<=30 && !tiene) {
				s.Espera();
				tiene=true;
			}
			if(km>30 && tiene) {
				s.Libera();
				tiene=false;
			}

		}
		sem.Espera();
		if(!gano[0]) {
			System.out.println(getName()+" ha ganado la carrera");
			gano[0]=true;
		}
		sem.Libera();
	}
}
class Tortuga extends Thread {
	private int km;
	Semaforo s,sem;
	boolean tiene=false;
	boolean []gano;
	public Tortuga(Semaforo s,Semaforo sem,boolean []gano) {
		km=0;
		this.s=s;
		this.sem=sem;
		this.gano=gano;
	}

	public void run() {
		while (km<100) {
			km++;
			System.out.println(getName()+" km = "+km);
			if(km>=10 && km<=30 && !tiene) {
				s.Espera();
				tiene=true;
			}
			if(km>30 && tiene) {
				s.Libera();
				tiene=false;
			}
		}
		sem.Espera();
		if(!gano[0]) {
			System.out.println(getName()+" ha ganado la carrera");
			gano[0]=true;
		}
		sem.Libera();
		
	}		
}
public class LiebreTortugaPuente {
	
// puente va del km 50 - 80 	
	
	
	public static void main(String [] a) {
		
		Semaforo s = new Semaforo(1);
		Semaforo sem=new Semaforo(1);
		boolean [] gano= {false};
		
		Liebre liebre=new Liebre(s,sem,gano);
		Tortuga tortuga=new Tortuga(s,sem,gano);
		
		liebre.setName("Liebre ");
		tortuga.setName("Tortuga ");
		liebre.start();
		tortuga.start();
		
	}
}
