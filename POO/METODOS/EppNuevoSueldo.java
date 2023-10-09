package METODOS;

//Esta clase utiliza el metodo Bonos para darle un bono a los empleados de una empresa
//Jose Ramses Aldama Cazares
//8:00-9:00
import java.util.Scanner;
public class EppNuevoSueldo{
	
	   static Scanner lectura= new Scanner (System.in);
     public static void main (String [] args){
	          int paga;
			  double sueld=0;
			  String nombre;
			  int trabajadores=50;
			  Ejercicios aumento= new Ejercicios();
			  for (int i=0; i<trabajadores; i++){
			  System.out.println ("Cual es tu nombre");
			  nombre=lectura.nextLine();
			  System.out.println ("Cuanto es su sueldo");
			  paga=lectura.nextInt();
			  sueld=sueld+aumento.Bonos(paga);
			  System.out.println ("Nombre T\tSueldo\tSueldo Nuevo");
			  System.out.println (nombre +"\t" +paga +"\t" +sueld);
			                                   }
            System.out.println ();
			  
				        }
}
