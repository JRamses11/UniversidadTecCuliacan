package SECUENCIA;

//Este algoritmo calcula la energia cinetica
//Jose Ramses Aldama Cazares
//11:00-12:00

public class Cinetica{
            public static void main (String [] args){
                          int masa=0;
                          System.out.println ("Cuanto es la masa del objeto en kg");
                          masa=Keyboard.readInt();
                          int velocidad=0;
                          System.out.println ("Cuanto es la velocidad en k/h ");
                          velocidad=Keyboard.readInt();
                          double EC=(masa/2)*Math.pow(velocidad,2);
                          System.out.println ("La energia cinetica es " +EC);
                          System.out.println ("Fin del programa");
                                                                                         }
                                        }