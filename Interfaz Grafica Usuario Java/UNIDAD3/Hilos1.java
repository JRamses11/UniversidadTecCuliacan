package UNIDAD3;

public class Hilos1 {
	
	static final int veces=5;
	
	static class Tarea1 extends Thread{
		public void run(){
			for(int i=0 ; i<veces; i++)
				System.out.println(i+" *** PROCESO UNO TRABAJANDO ");
		}
	}

	static class Tarea2 extends Thread{
		public void run(){
			for(int i=0 ; i<veces; i++)
				System.out.println(i+" *** PROCESO DOS TRABAJANDO *");
		}
	}
	static class Tarea3 extends Thread{
		public void run(){
			for(int i=0 ; i<veces; i++)
				System.out.println(i+" *** PROCESO TRES TRABAJANDO ***");
		}
	}	
	
	 public static void main(String [] a){


		 
		 
	      Tarea1 t1 = new Tarea1();
	      Tarea2 t2 = new Tarea2();
	      Tarea3 t3 = new Tarea3();
	      t1.start();
	      t2.start();
	      t3.start();
	      while ( t1.isAlive() | t2.isAlive() | t3.isAlive());
	      System.out.println("________________");
	   }

}
