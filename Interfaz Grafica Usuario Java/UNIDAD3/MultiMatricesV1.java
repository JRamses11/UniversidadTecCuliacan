package UNIDAD3;

class Par extends Thread {
	int [][] m1,m2,m3;
	public Par(int [][] m1, int [][] m2, int[][] m3) {
		this.m1=m1;
		this.m2=m2;
		this.m3=m3;
	}
	public void run() {
		for(int i=0 ; i<m1.length; i+=2) {
			for(int j=0 ; j< m1.length ; j++) {
				for(int k=0; k<m1.length; k++) {
					m3[j][k]+=m1[i][j]*m2[j][i];
				}
			}
		}
		
	}
}
class Impar extends Thread {
	int [][] m1,m2,m3;
	public Impar(int [][] m1, int [][] m2, int[][] m3) {
		this.m1=m1;
		this.m2=m2;
		this.m3=m3;
	}
	public void run() {
		for(int i=1 ; i<m1.length; i+=2) {
			for(int j=0 ; j< m1.length ; j++) {
				for(int k=0; k<m1.length; k++) {
					m3[j][k]+=m1[i][j]*m2[j][i];
				}
			}			
		}
		
	}
}
public class MultiMatricesV1 {

	public static void main(String[] args) {
		final int N=300;
		int [][] m1=new int[N][N];
		int [][] m2=new int[N][N];
		int [][] m3=new int[N][N];
		Llena(m1);
		Llena(m2);
		Par par=new Par(m1,m2,m3);
		Impar impar=new Impar(m1,m2,m3);
		par.start();
		impar.start();
		
		while(par.isAlive() || impar.isAlive());
		Imprime(m1);
		Imprime(m2);
		Imprime(m3);

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
		for(int i=0 ; i<10;i++) {
			for(int j=0 ; j<10 ; j++) {
				System.out.printf("%4d ", m[i][j]);
			}
			System.out.println();
		}
		
		
	}
}
