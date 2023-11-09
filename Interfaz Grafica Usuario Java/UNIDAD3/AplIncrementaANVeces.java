package UNIDAD3;

public class AplIncrementaANVeces {

	public static void main(String[] args) {
		final int tamaño=100000;
		IncrementaA [] h=new IncrementaA[tamaño];
		
		for(int i=0 ; i<h.length ; i++) {
			h[i]=new IncrementaA();
			
		}	
		
		for(int i=0 ; i<h.length ; i++)
			h[i].start();
		while (HayVivos(h));
		
		System.out.println("A= "+h[0]);

	}
	private static boolean HayVivos(IncrementaA [] a) {
		for(int i=0 ; i<a.length ; i++)
			if(a[i].isAlive())
				return true;
		return false;
	}

}
 