package CICLOS;

//Este programa presenta un menu de opciones y hasta que se de la opcion de salir se acaba el programa
//Jose Ramses Aldama Cazares
//11:00-12:00

public class Menu{
           public static void main (String [] args){
                        int opcion, lado, base, altura;
                        double area;
                        int radio;
                        System.out.println ("BIENVENIDO ESTE ES EL MENU DE OPERACIONES PARA SACAR SU AREA");
                        System.out.println ("1-Triangulo");
                        System.out.println ("2-Cuadrado");
                        System.out.println ("3-Circulo");
                        System.out.println ("4-Rectangulo");
                        System.out.println ("5-Salir del menu");
                        do{
                        System.out.println ("Ingrese el numero de la instruccion que desea operar " );
                        opcion=Keyboard.readInt();
                            if (opcion==1){
                            System.out.println ("Cual es el valor de la altura");
                            altura=Keyboard.readInt();
                            System.out.println ("Cual es el valor de la base");
                            base=Keyboard.readInt();
                            area=base*altura/2;
                            System.out.println ("El area es  " +area);
                                                     }
                            if (opcion==2){
                                System.out.println ("Cual es el valor del los lados");
                                lado=Keyboard.readInt();
                                area=lado*lado;
                                System.out.println ("El valor del area es " + area);
                                                          }
                                  if (opcion==3){
                                      System.out.println ("Cual es el valor del radio");
                                      radio=Keyboard.readInt();
                                      area=Math.PI*Math.pow(radio,2);
                                     System.out.format  ("El area es " +" %.2f %n ", +area);
                                                               }
                                          if (opcion==4){
                                          System.out.println ("Cual es el valor de la base");
                                          base=Keyboard.readInt();
                                          System.out.println ("Cual es el valor de la altura");
                                          altura=Keyboard.readInt();
                                          area=base*altura;
                                          System.out.println ("El valor del area es " + area); 
                                          System.out.println ("Ingrese el numero de la instruccion que desea operar " );
                                          opcion=Keyboard.readInt();
                                                                        }
                                       } while (opcion<0 && opcion>6);
                                                                                        }
                                    }