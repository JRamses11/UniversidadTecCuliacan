package METODOS;

//Aplicacion de la clase Ejercicios
//Jose Ramses Aldama Cazares
//8:00-9:00

import java.util.Scanner;
public class EppSigno{
     static Scanner lectura = new Scanner (System.in);
     public static void main (String [] args){
	           int valor;
	           Ejercicios num= new Ejercicios();
			   System.out.println ("Ingresa un valor numerico");
			   valor=lectura.nextInt();
			   System.out.println ("El numero es " +num.checasigno(valor));
			                                    }
		                  }