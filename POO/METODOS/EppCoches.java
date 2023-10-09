package METODOS;

//En esta clase usamos el metodo CostoVehiculo y retornamos el costo final de el
//Jose Ramses Aldama Cazares
//8:00-9:00
import java.util.Scanner;
public class EppCoches{
     static Scanner lectura= new Scanner (System.in);
     public static void main (String [] args){
	          int valCoche;
	          Ejercicios compra= new Ejercicios();
			  System.out.println ("Cuanto cuesta el coche");
			  valCoche=lectura.nextInt();
			  System.out.println("El costo neto del vehiculo es " +compra.CostoVehiculo(valCoche));
			                                   }
				   }