package SECUENCIA;

//Este programa convierte de euros a pesos
//Jose Ramses Aldama Cazares
//11:00-12:00

import java.util.Scanner;
public class Pesos {
            static Scanner lectura= new Scanner(System.in);
            public static void main (String args []){
                       int euro;
                      System.out.println("Cuanto euros deseas convertir a pesos");
                      euro= lectura.nextInt();

                      double valeuro;
                      System.out.println("Cuanto vale el euro actualmente");
                      valeuro= lectura.nextDouble();

                     double pesos=euro*valeuro;
                     System.out.println("Cuantos pesos son " +pesos);
System.out.println("Fin del programa");
                                                                                       }
                                     }