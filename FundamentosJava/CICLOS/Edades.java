package CICLOS;

//Jose Ramses Aldama Cazares

public class Edades{
            public static void main (String [] args){
                          int edad=0;
                          double promedio=0;
                           for (int i=0; i<10; i++){
                                    System.out.println ("Cuales son las edades");
                                     edad=Keyboard.readInt();
                                     promedio=promedio+edad;
                                                                      }
                             promedio=promedio/10;
                             System.out.println ("El promedio de las edades es " +promedio);
                                                                                           }
                                          }