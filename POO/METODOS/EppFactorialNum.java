package METODOS;

//Esta clase utiliza el metodo factorial para sacar el factorial de un numero
//Jose Ramses Aldama Cazares
//8:00-9:00
import java.util.Scanner;
public class EppFactorialNum{
     static Scanner lectura=new Scanner (System.in);
     public static void main (String [] args){
	          Ejercicios fac= new Ejercicios();
			  int x;
			  System.out.println ("Numero del factorial a calcular");
			  x=lectura.nextInt();
			  System.out.println (fac.Factorial(x));
			                                   }
}