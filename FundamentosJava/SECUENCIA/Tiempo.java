package SECUENCIA;

//Este programa el tiempo que hizo un objeto en su recorrido
//Jose Ramses Aldama Cazares
//11:00-12:00

public class Tiempo{
            public static void main (String [] args){
                          int velocidad=0; // m/s
                          int distancia=0; //Metros
                          System.out.println ("Cual fue la velocidad que alcanzo");
                          velocidad=Keyboard.readInt();
                          System.out.println ("Cual es la distancia que recorrio");
                          distancia=Keyboard.readInt();
                          double tiempo=distancia/velocidad; //Segundos
                          System.out.println ("Cual fue su tiempo de recorrido " +tiempo);
                          System.out.println("Fin del programa");
                                                                                         }
                                       }