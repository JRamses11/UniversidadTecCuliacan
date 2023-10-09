package CONDICIONALES;
//Este programa te dice si te hace falta dormir o no dependiendo de tus horas de sue�o
//Jose Ramses Aldama Cazares
//11:00-12:00

public class Sueno{
            public static void main (String [] args){
                         int horas=0;
                         System.out.println ("Cuantas horas duermes");
                         horas=Keyboard.readInt();
                         if (horas<0)
                        System.out.println ("No puedes dar valores negativos");
                        else
                           if (horas<=6)
                         System.out.println ("Necesitas dormir mas");
                         else 
                               if (horas>=7 && horas<=8)
                               System.out.println ("Duermes lo suficiente");
                               else 
                                      if (horas>=9)
                                      System.out.println ("Duermes en exceso");
                        System.out.println ("Fin del programa");
                                                                                           }
                                         }