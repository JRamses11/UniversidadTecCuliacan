package UNIDAD3;

class Puente {
	
	private int kmIni,kmFin;
	private Semaforo s;
	
	public Puente(int kmIni,int kmFin) {
		this.kmIni=kmIni;
		this.kmFin=kmFin;
		s=new Semaforo(1);
	}
	public Puente(int kmIni,int kmFin, int recursos) {
		this.kmIni=kmIni;
		this.kmFin=kmFin;
		s=new Semaforo(recursos);
	}
	public int Checa(int kmActual, boolean tiene) {
		if(kmActual>=kmIni && kmActual<=kmFin && !tiene) {
			s.Espera();
			return 1;
		}
		if(kmActual>kmFin && tiene) {
			s.Libera();
			return 2;
		}
		return 0;
	}
}
class Liebree extends Thread {
	private int km;
	private Puente [] puentes;

	public Liebree(Puente [] puentes) {
		km=0;
		this.puentes=puentes;
	}
	public void run() {
		int np=0,res ;
		boolean tiene=false;
		while (km<500) {
			km+=1;// Rutinas.nextInt(1, 3);
			System.out.println(getName()+" km = "+km);
			res=0;
			if (np<puentes.length) {
				res=puentes[np].Checa(km, tiene);
				switch (res) {
				case 1: tiene=true;break;
				case 2: tiene=false;np++;break;
				}
			}
		}

			System.out.println(getName()+" ha ganado la carrera");
	
	}
}
class Tortugaa extends Thread {
	private int km;
	private Puente [] puentes;

	public Tortugaa(Puente [] puentes) {
		km=0;
		this.puentes=puentes;
	}
	public void run() {
		int np=0,res ;
		boolean tiene=false;
		while (km<500) {
			km+=1;// Rutinas.nextInt(1, 3);
			System.out.println(getName()+" km = "+km);
			res=0;
			if (np<puentes.length) {
				res=puentes[np].Checa(km, tiene);
				switch (res) {
				case 1: tiene=true;break;
				case 2: tiene=false;np++;break;
				}
			}
		}

			System.out.println(getName()+" ha ganado la carrera");
	
	}
}
public class LiebreTortugaNPuentes {

	public static void main(String[] args) {
		Puente [] puentes=new Puente[4];
		puentes[0]=new Puente(1,60,2);
		puentes[1]=new Puente(100,150);
		puentes[2]=new Puente(200,250,1);
		puentes[3]=new Puente(300,350);
		
		Liebree liebre=new Liebree(puentes);
		liebre.setName("Liebre blanca ");
		Tortugaa tortuga=new Tortugaa(puentes);
		tortuga.setName("Tortuga negra ");
		
		Tortugaa tortugag=new Tortugaa(puentes);
		tortugag.setName("Tortuga gris ");
		
		liebre.start();
		tortuga.start();
		tortugag.start();
	}

}

