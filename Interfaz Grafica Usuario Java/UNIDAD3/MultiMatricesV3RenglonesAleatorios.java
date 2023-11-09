package UNIDAD3;

import java.util.Arrays;

import UNIDAD1.Rutinas;

class MultRenglonesAleatorios extends Thread {
	int [][] m1,m2,m3;
	
	static Semaforo [] s;
	static boolean [] band;
	
	public MultRenglonesAleatorios(int [][] m1, int [][] m2, int[][] m3) {
		this.m1=m1;
		this.m2=m2;
		this.m3=m3;
		if(s==null) {
			s=new Semaforo[m1.length];
			for(int i=0 ; i<s.length ; i++)
				s[i]=new Semaforo(1);
			band=new boolean[m1.length];
			Arrays.fill(band, false);
		}
		

	}
	public void run() {
		while (HayaPendientes()) {
			int renglon=Rutinas.nextInt(m1.length);
			s[renglon].Espera();
			if(band[renglon]) {
				s[renglon].Libera();
				continue;
			}
			band[renglon]=true;
			s[renglon].Libera();

			for(int j=0 ; j< m1.length ; j++) {
				for(int k=0; k<m1.length; k++) {
					m3[j][k]+=m1[renglon][j]*m2[j][renglon];
				}
			}

		}
	}
	private boolean HayaPendientes() {
		for(int i=0 ; i<m1.length;i++)
			if(!band[i])
				return true;
		return false;
		
	}
}
public class MultiMatricesV3RenglonesAleatorios {
	public static void main(String[] args) {
		final int N=4000;
		int [][] m1=new int[N][N];
		int [][] m2=new int[N][N];
		int [][] m3=new int[N][N];
		Llena(m1);
		Llena(m2);

		 MultRenglonesAleatorios [] hilos = new  MultRenglonesAleatorios[100];
		for(int i=0 ; i<hilos.length ; i++)
			hilos[i]=new  MultRenglonesAleatorios(m1,m2,m3);
		
		for(int i=0 ; i<hilos.length; i++)
			hilos[i].start();
		
		

		while(HayVivos(hilos));
		Imprime(m1);
		Imprime(m2);
		Imprime(m3);

	}
	private static boolean HayVivos( MultRenglonesAleatorios [] arreglo) {
		for(int i=0 ; i<arreglo.length ; i++)
			if(arreglo[i].isAlive())
				return true;
		return false;
	}
	public static void Llena(int [][] m) {
		for(int i=0 ; i<m.length;i++) {
			for(int j=0 ; j<m[i].length ; j++) {
				m[i][j]=i+1;
			}

		}
	}
	public static void Imprime(int [][] m) {
		System.out.println("_________________");
		for(int i=0 ; i<(m.length<10?m.length:10);i++) {
			for(int j=0 ; j<(m.length<10?m.length:10) ; j++) {
				System.out.printf("%4d ", m[i][j]);
			}
			System.out.println();
		}


	}


}

