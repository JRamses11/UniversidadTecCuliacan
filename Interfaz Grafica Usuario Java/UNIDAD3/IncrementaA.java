package UNIDAD3;

public class IncrementaA extends Thread{
	static int a;
	public IncrementaA() {
		a=0;
	}
	public  void run() {
		Suma();
		
	}
	private void Suma() {
		a++;
	}	
		
	public String toString() {
		return a+"";
	}
}
