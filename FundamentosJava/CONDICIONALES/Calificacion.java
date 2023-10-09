package CONDICIONALES;

//Este programa lee la calificacion de un alumno y si te dice si tiene calificacion aprobatoria o reprobatoria
//Jose Ramses Aldama Cazares
//11:00-12:00

public class Calificacion{
            public static void main (String [] args){
                         double cal;
                         System.out.print ("Cual es su calificacion : " );
                         cal=Keyboard.readDouble();
                         if (cal<0)
                         System.out.println("No se aceptan valores negativos");
                         else
                               if (cal>=70)
                                System.out.println ("Aprobado");
                                    else
                                     System.out.println ("Reprobado");
                                                                                            }
                                                 }