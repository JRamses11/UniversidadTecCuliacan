package ARREGLOS;

//Este programa almacena la informacion de los trabajadores su nombre y horas trabajadas, sacamos su sueldo neto en base a sus horas trabajadas mas los impuestos
//Este programa captura un numero determinado de empleados y imprime una lista con su sueldo, nombre, impuesto y sueldo neto
//Jose Ramses Aldama Cazares
//11:00-12:00

public class SueldoNeto{
            public static void main (String [] args){
                          int emp;
                          System.out.println ("Cuantos empleados deseas capturar");
                         do{
                                emp=Keyboard.readInt();
                                if (emp<0)
                                      System.out.println ("Ingrese un numero valido");
                                       else
                                              if (emp==0)
                                                   System.out.println ("Fin del programa");
                                  } while (emp<0);

                             String nombre[]= new String [emp];
                             int horas []=new int [emp];
                             double impuesto[]=new double [emp];
                             int sueldob[]=new int [emp];
                             double sueldon[]=new double [emp];

                             for (int i=0; i<emp; i++){
                                     System.out.println ("Nombre del trabajador " +(i+1) +":");
                                     nombre[i]=Keyboard.readString();
                                     System.out.println ("Cuantas horas trabajaste");
                                     horas[i]=Keyboard.readInt();
                                     if (horas[i]<=40){
                                          sueldob[i]=horas[i]*15;
                                          impuesto[i]=sueldob[i]*0.06;
                                          sueldon[i]=sueldob[i]+impuesto[i]; }
                                          if (horas[i]>40){
                                                sueldob[i]=horas[i]*20;
                                                impuesto [i]=sueldob[i]*0.06;
                                                sueldon[i]=sueldob[i]+impuesto[i]; }
                                                                               } //fin del for
                                 System.out.print ("Nombre" +"\t");
                                 System.out.print ("Horas" +"\t");
                                 System.out.print ("Sueldo_bruto" +"\t");
                                 System.out.print ("Impuesto" +"\t");
                                 System.out.print ("Sueldo_Neto" + "\t");
                                 System.out.println();
                             for (int i=0; i<emp; i++){
                                      System.out.print (nombre[i] +"\t");
                                      System.out.print (horas[i] +"\t");
                                      System.out.print (sueldob[i] +"\t");
                                      System.out.print (impuesto[i] +"\t");
                                      System.out.print (sueldon[i] +"\t");
                                      System.out.println();
                                                                              }// fin del for
                                    } //fin del main
               } //fin de la clase