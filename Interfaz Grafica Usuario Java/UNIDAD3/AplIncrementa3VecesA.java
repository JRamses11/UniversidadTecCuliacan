package UNIDAD3;

public class AplIncrementa3VecesA {

	public static void main(String[] args) {
		IncrementaA obj1,obj2,obj3;
		obj1=new IncrementaA();
		obj1.start();
		obj2=new IncrementaA();
		obj2.start();
		obj3=new IncrementaA();
		
		
		
		obj3.start();
		
		while(obj1.isAlive() || obj2.isAlive() || obj3.isAlive());
		
		System.out.println("A= "+obj1);
		
		

	}

}

