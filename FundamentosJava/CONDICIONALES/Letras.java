package CONDICIONALES;

//Este programa lee un numero del 1 al 10 y te regresa una letra del abecedario
//Jose Ramses Aldama Cazares 
//11:00-12:00

public class Letras{
            public static void main (String [] args){
                         int num;
                         System.out.print ("Ingrese un numero " );
                         num=Keyboard.readInt();
                         switch (num){
                         case 1:  System.out.println("A"); break;
                         case 2:  System.out.println ("B"); break;
                         case 3:  System.out.println ("C"); break;
                         case 4:  System.out.println ("D"); break;
                         case 5:  System.out.println ("E"); break;
                         case 6:  System.out.println ("F"); break;
                         case 7:  System.out.println ("G"); break;
                         case 8:  System.out.println ("H"); break;
                         case 9:  System.out.println ("I"); break;
                         case 10:  System.out.println ("J"); break;
                         default: System.out.println ("Valor fuera de rango"); break;
                                                       }
                                                                                           }
                                          }
