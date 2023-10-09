package ARREGLOS;

//Este programa alamcena en un arreglos las denominaciones de billetes y monedas para saber la cantidad que se necesitan de cada uno de ellos para una cantidad propuesta//
//Jose Ramses Aldama Cazares
//11.00-12:00

public class Dinero{
            public static void main (String [] args){
                           int val;
                           int cambio []= new int [10];
                           int dinero[] ={1000,500,200,100,50,20,10,5,2,1};
                           System.out.println ("Ingrese la cantidad de dinero");
                           val=Keyboard.readInt();
                           for (int i=0; i<dinero.length; i++){
                                   cambio[i]= val/dinero[i];
                                    val=val-(cambio[i]*dinero[i]);

                                                                                            }// fin del for

                            for (int i=0; i<cambio.length; i++){
                                    System.out.println( "En billetes de " +dinero[i] +" son " +cambio[i]);
                                                                                               } //fin del segundo for

                                                                                              }// Fin del main
                                        }//Fin de la clase