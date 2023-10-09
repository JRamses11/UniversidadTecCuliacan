package CONDICIONALES;

//Este programa calcula el residuo de dos numero si son mayores a cero
//Jose Ramses Aldama Cazares
//11:00-12:00

public class Residuo{ 
           public static void main (String [] args){
                         int num1=0;
                        System.out.println ("Cual es el valor del primero numero");
                        num1=Keyboard.readInt();
                        int num2=0;
                        System.out.println ("Cual es el valor del segundo numero");
                        num2=Keyboard.readInt();
                        double residuo=0;
                              if (num2<=0)
                               System.out.println ("Error de calculo");
                                else
                                       if (num1>0 && num2>0)
                                       residuo=num1%num2;
                                       System.out.println ("Cual es valor del residuo " +residuo);
                                                                                           }
                                          }