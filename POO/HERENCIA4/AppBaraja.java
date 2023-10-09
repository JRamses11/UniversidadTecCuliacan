package HERENCIA4;

//
//
//
import java.util.Scanner;
public class AppBaraja{
	
	   public static Scanner leer= new Scanner (System.in);
	   
          public static void main (String [] args){
		  Baraja b= new Baraja();
		  System.out.println(b);
		  int op;
		  do{ 
		     op=Menu();
		    } while (op!=0);
		  }
		  
		  private static int Menu(){
			  System.out.println("*** MENU ***");
			  System.out.println("1- Barajar (iniciar de nuevo)");
			  System.out.println("2-Pedir una carta");
			  System.out.println("3-Pedir varias cartas");
			  System.out.println("4-Mostrar cartas ya utilizadas");
			  System.out.println("5-Mostrar cartas restantes");
			  System.out.println("6-Numero de cartas disponibles");
			  System.out.println("0-SALIR");
              System.out.print("Opcion:");
              leer.nextInt();	
              return 0;
		  }			    
}
