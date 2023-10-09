package SECUENCIA;

//Este programa calcula el area de un circulo
//Jose Ramses Aldama Cazares
//11:00-12:00

public class Circulo{
            public static void main (String [] args){
                         int radio=0;
                         System.out.println ("Cual es el valor del radio");
                         radio=Keyboard.readInt();
                         double area=Math.PI*Math.pow(radio,2);
                         System.out.format  ("El area del circulo es " +" %.2f %n ", +area);
                         System.out.println ("Fin del programa");
                                                                                        }
                                  }