package METODOS;

//Esta clase utiliza el metodo PagoVendedor para calcular el sueldo bruto y neto de la venta de autos
//Jose Ramses Aldama Cazares
//8:00-9:00

import java.util.Scanner;
public class EppVentaAuto{
     static Scanner lectura= new Scanner (System.in);
     public static void main (String [] args){
	          int vendidos;
			  Ejercicios venta= new Ejercicios();
			  System.out.println ("Cuantos autos vendiste");
			  vendidos=lectura.nextInt();
			  System.out.println (venta.PagoVendedor(vendidos));
	   }
}