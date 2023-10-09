package SECUENCIA;

//Este programa calcula la velocidad que alcanzo un objeto en m/s
//Jose Ramses Aldama Cazares
//11:00-12:00

import java.util.Scanner;
public class Distancia{

            static Scanner lectura= new Scanner (System.in);
            public static void main (String [] args ){

                         int velocidad;
                         System.out.println ("Que velocidad alcanzo el objeto en m/s");
                         velocidad=lectura.nextInt(); // m/s
                         int tiempo;
                         System.out.println ("Cuanto fue su tiempo de recorrido en segundos");
                         tiempo=lectura.nextInt(); // segundos

                         int distancia=velocidad*tiempo;
                         System.out.println ("Cuanto fue su distancia recorrida " +distancia);
                         System.out.println ("Fin del programa");
                                                                                              }
                                            }