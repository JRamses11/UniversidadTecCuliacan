package UNIDAD3;

class ParImpar extends Thread {
	int [][] m1,m2,m3;
	int renInicio, totalHilos;
	public ParImpar(int [][] m1, int [][] m2, int[][] m3,int renInicio,int totalHilos) {
		this.m1=m1;
		this.m2=m2;
		this.m3=m3;
		 this.renInicio=renInicio;
		 this.totalHilos=totalHilos;
	}
	public void run() {
		for(int i=renInicio ; i<m1.length; i+=totalHilos) {
			for(int j=0 ; j< m1.length ; j++) {
				for(int k=0; k<m1.length; k++) {
					m3[j][k]+=m1[i][j]*m2[j][i];
				}
			}
		}
		
	}
}
public class MultiMatricesV2 {

	public static void main(String[] args) {
		final int N=40;
		int [][] m1=new int[N][N];
		int [][] m2=new int[N][N];
		int [][] m3=new int[N][N];
		Llena(m1);
		Llena(m2);

		ParImpar [] hilos = new ParImpar[10];
		for(int i=0 ; i<hilos.length ; i++)
			hilos[i]=new ParImpar(m1,m2,m3,i,10);
		
		for(int i=0 ; i<hilos.length; i++)
			hilos[i].start();
		
		

		while(HayVivos(hilos));
		Imprime(m1);
		Imprime(m2);
		Imprime(m3);

	}
	private static boolean HayVivos(ParImpar [] arreglo) {
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
