package METODOS;

//Este programa retoma de la clase ParImpar y regresa como resultado si un numero es par o impar
//Jose Ramses Aldama Cazares
//8:00-9:00

import java.util.Scanner;
public class EppParOImpar{
     static Scanner lectura= new Scanner (System.in);
     public static void main (String [] args){
	          Ejercicios par= new Ejercicios();
            int num;
	          System.out.println ("Ingresa un valor");
	          num=lectura.nextInt();
	          System.out.println (par.ParImpar(num));
			                                    }
					   }