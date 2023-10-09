package METODOS;

//Esta clase utiliza el metodo SumNaturales
//Jose Ramses Aldama Cazares
//8:00-9:00

import java.util.Scanner;
public class EppSumaNumeros{
     static Scanner lectura= new Scanner (System.in);
     public static void main (String [] args){
	          int nat;
			  Ejercicios sumar= new Ejercicios();
			  System.out.println ("Ingresa de los primeros numeros a sumar");
			  nat=lectura.nextInt();
			  System.out.println (sumar.SumNaturales(nat));
			                                    }
					    }