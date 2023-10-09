package SECUENCIA;

//Este algortimo convierte de centimetros a pulgadas
//Jose Ramses Aldama Cazares
//11:00-12:00

import java.util.Scanner;
public class Pulgadas {

static Scanner lectura= new Scanner(System.in);
public static void main (String args[]) {

            int centimetros;
            System.out.println("Cuantos centimetros deseas convertir");
            centimetros= lectura.nextInt();

            double pulgadas=centimetros/2.54;
            System.out.format("Cuantas pulgadas son " +"%.2f%n", +pulgadas);

System.out.println("Fin del programa");
                                                                          }
                                           }