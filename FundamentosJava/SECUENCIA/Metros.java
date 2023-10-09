package SECUENCIA;

//Este programa convierte de yardas a kilometros
//Jose Ramses Aldama Cazares
//11:00-12:00

import java.util.Scanner;
public class Metros{

          static Scanner lectura= new Scanner(System.in);
          public static void main (String [] args){
                      int yardas;
                      System.out.println( "Cuantas yardas desea convertir a metros");
                      yardas= lectura.nextInt();
                      double metros= (yardas/1.094);
                      System.out.format ("Cuantos metros son " +"%.3f%n", +metros);

System.out.print("Fin del programa");
                                                                           }
}