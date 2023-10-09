package CONDICIONALES;

//Este programa te dice si estas en condiciones de manejar segun a prueba del alcoholimetro
//Jose Ramses Aldama Cazares
//11:00-12:00

public class Alcoholimetro{
                      public static void main (String [] args){
                                    double parametro=0;
                                    System.out.println ("Cual es el parametro de aliento");
                                    parametro=Keyboard.readDouble();
                                    if (parametro<0 || parametro>1)
                                    System.out.println ("Valor fuera de rango");
                                    else
                                          if (parametro<0.07 && parametro>0)
                                          System.out.println ("Aceptable");
                                          else 
                                               if (parametro>0.07 && parametro<1)
                                               System.out.println ("Inaceptable");
                                                                                                    }
                                                     }  
