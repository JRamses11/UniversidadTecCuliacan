package METODOS;

//Aplicacion del metodo Mayor3
//Jose Ramses Aldama Cazares
//8:00-9:00

import java.util.Scanner;
public class EppNumeroMayor{
     static Scanner lectura = new Scanner (System.in);
     public static void main (String [] args){
	          int num1, num2, num3;
			  Ejercicios costo= new Ejercicios();
			  System.out.println ("Ingresa tu primer valor");
			  num1=lectura.nextInt();
			  System.out.println("Ingresa tu segundo valor");
			  num2=lectura.nextInt();
			  System.out.println("Ingresa tu tercer valor");
			  num3=lectura.nextInt();
			  System.out.println(costo.Mayor3(num1, num2, num3));
			                                    }
						    }