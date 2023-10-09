package CONDICIONALES;

//Este programa lee un valor del teclado y te dice en que rango te encuentras
//Jose Ramses Aldama Cazares
//11:00-12:00

public class Rango{
            public static void main (String [] args){
                          int valor;
                          System.out.println ("Que valor deseas");
                          valor=Keyboard.readInt();
                          if (valor>=0 && valor<=5)
                              System.out.println ( "Rango Malo");
                              else
                              if (valor >=6 && valor<=7)
                                        System.out.println ( "Rango Regular");
                                        else
                                        if (valor>=8 && valor<=9)
                                                 System.out.println ("Rangulo Bueno");
                                                  else
                                                   if (valor==10)
                                                       System.out.println ("Rango Excelente");
                                                        else
                                                         System.out.print ("Valor fuera de rango");
                                                                                            }
                                              }