package METODOS;

//Aplicacion del metodo Mayor2
//Jose Ramses Aldama Cazares
//8:00-9:00

import java.util.Scanner;
public class EppMayorMenor{
      static Scanner lectura = new Scanner (System.in);
      public static void main (String [] args){
		       int val1;
			   int val2;
			   Ejercicios val=new Ejercicios();
			   System.out.println ("Cual es tu primer valor");
			   val1=lectura.nextInt();
			   System.out.println ("Cual es tu segundo valor");
			   val2=lectura.nextInt();
			   System.out.println (val.Mayor2(val1, val2));
			                                     }
		                    }