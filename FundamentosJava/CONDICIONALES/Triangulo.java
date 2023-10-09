package CONDICIONALES;

//Este programa lee los datos de un triangulo y si son mayores a 0 saca su area
//Jose Ramses Aldama Cazares
//11:00-12:00

public class Triangulo{
           public static void main (String [] args){
                        int base;
                        int altura;
                        double area;
                        System.out.print ("Cual es el valor de la base : " );
                        base=Keyboard.readInt();
                        System.out.print ("Cual es el valor de la altura : " );
                        altura=Keyboard.readInt();
                        area=base*altura/2;
                        if ( altura>0 && altura>0)
                        System.out.println ("El area del triangulo es : " +area);
                        else
                               System.out.println ("Los valores tienen que ser mayores a cero");
                                                                                            }
                                               }