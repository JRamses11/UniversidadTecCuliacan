package SECUENCIA;

//Este algoritmo calcula la distancia que recorrio un objeto en metros
//Jose Ramses Aldama Cazares
//11:00-12:00

import java.util.Scanner;
public class Velocidad{

            static Scanner lectura = new Scanner(System.in);
            public static void main (String [] args) {

                          int distancia;
                          System.out.println ("Cuantos metros reccorrio el objeto");
                          distancia= lectura.nextInt(); //Metros
                          int tiempo;
                          System.out.println ("Cuanto tiempo hizo de recorrido");
                          tiempo= lectura.nextInt(); // Segundos

                          int velocidad=distancia/tiempo; //metros sobre segundos
                          System.out.println("Cual es la velocidad del objeto " +velocidad);

System.out.println("Fin del programa");
                                                                              }
                                           }