package METODOS;

//Esta clase utiliza el metodo AreaTriangulo para sacar el area de un triangulo considerando el valor de sus 3 lados
//Jose Ramses Aldama Cazares
//8:00-9:00

import java.util.Scanner;
public class EppAreaT{
     static Scanner lectura=new Scanner (System.in);
     public static void main (String [] args){
		       int lado1, lado2, lado3;
			   Ejercicios tri= new Ejercicios();
	           System.out.println ("Cual es el valor del lado 1 ");
			   lado1=lectura.nextInt();
			   System.out.println ("Cual es el valor del lado 2 ");
			   lado2=lectura.nextInt();
			   System.out.println ("Cual es el valor del lado 3 ");
			   lado3=lectura.nextInt();
			   System.out.println ("El area del triangulo es " +tri.AreaTriangulo(lado1, lado2, lado3));
	                                           }
                }