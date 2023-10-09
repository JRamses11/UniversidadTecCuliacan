package METODOS;

//Esta clase utiliza el metodo Calificaciones para descubrir el estado academico del alumno
//Jose Ramses Aldama Cazares
//8:00-9:00
import java.util.Scanner;
public class EppAproRepro{
	   static Scanner lectura= new Scanner (System.in);
     public static void main (String [] args){
	          int nota, nota2, nota3;
			  Ejercicios pasar=new Ejercicios();
			  System.out.println ("Cual es tu calificacion 1");
			  nota=lectura.nextInt();
			  System.out.println ("Cual es tu calificacion 2");
			  nota2=lectura.nextInt();
			  System.out.println ("Cual es tu calificacion 3");
			  nota3=lectura.nextInt();
			  System.out.println(pasar.Calificaciones(nota, nota2, nota3));
			  }
}
