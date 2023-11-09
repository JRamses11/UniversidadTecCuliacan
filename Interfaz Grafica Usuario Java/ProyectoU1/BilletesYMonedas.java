package ProyectoU1;

import java.util.Scanner;

/*
 Escribe un programa que almacene en un arreglo la denominación de
 billetes y monedas (1000, 500, 200, 100, 50, 20, 10, 5, 2, 1) lee de teclado
 una cantidad y procesa numero de billetes y monedas de cada
 denominación para tal cantidad.
 Autor: Jesus Manuel Gastelum Chaparro
 */
 public class BilletesYMonedas{
 	public static void main(String[] args) {
 		int [] denominacion = {1000,500,200,100,50,20,10,5,2,1};
 		int [] contador=new int [10];
 		int cantidad;
 		
 		System.out.println("Ingrese una cantidad en pesos");
 		cantidad = new Scanner(System.in).nextInt();
 	
 		for (int i=0;i<denominacion.length;i++){
 			contador[i] = cantidad / denominacion[i];
 			cantidad -= contador[i] * denominacion[i];

 		}
 		for (int j=0;j<denominacion.length;j++){
 			if (denominacion[j]>=50){
 			     System.out.println(contador[j] +" billetes de " +denominacion[j]);
 		    }else{
 		    	System.out.println(contador[j] +" monedas de " +denominacion[j]);
 		    }
 		}
 	}
 }
