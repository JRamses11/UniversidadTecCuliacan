package CICLOS;

//Este programa lee un numero del 1-10 y si se encuentra dentro del rango te regresa una letra
//Jose Ramses Aldama Cazares
//11:00-12:00

public class NumLetras{
            public static void main (String [] args){
                          int num;
                          for (int i=0; i<10; i++){
                                  System.out.print ("Ingresa un numero: " );
                                  num=Keyboard.readInt();
                                  switch (num){
                                                case 1: System.out.println ("A"); break;
                                                case 2: System.out.println ("B"); break;
                                                case 3: System.out.println ("C"); break;
                                                case 4: System.out.println ("D"); break;
                                                case 5: System.out.println ("E"); break;
                                                case 6: System.out.println ("F"); break;
                                                case 7: System.out.println ("G"); break;
                                                case 8: System.out.println ("H"); break;
                                                case 9: System.out.println ("I"); break;
                                                case 10: System.out.println ("J"); break;
                                                default : System.out.println ("Numero fuera del rango"); break;
                                                                }
                                                                        }
                                                                                          }
                                                 }
