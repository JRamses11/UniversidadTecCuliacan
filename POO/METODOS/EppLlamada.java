package METODOS;

//Esta clase utiliza el metodo CalculaCosto para calcular el costo de una llamada telefonica
//Jose Ramses Aldama Cazares
//8:00-9:00

import java.util.Scanner;
public class EppLlamada{
     static Scanner lectura= new Scanner (System.in);
     public static void main (String [] args){
	          int cost;
			  Ejercicios min = new Ejercicios();
			  System.out.println ("Cuanto fue la duracion de su llamada");
			  cost=lectura.nextInt();
			  System.out.println ("El costo de su llamada fue " +min.CalculaCosto(cost));
			                                   }
					 }