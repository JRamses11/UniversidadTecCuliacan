package ARREGLOS;

//Este programa procesa los datos de 30 empleados, te dice cuantos trabajaron mas que el promedio y el salario de cada uno de ellos
//Jose Ramses Aldama Cazares
//11:00-12:00

public class Empleados{
            public static void main (String [] args){
                          final int numEmpleados=3;
                          int horas []=new int [numEmpleados];
                          String nombre []= new String [numEmpleados];
                          int sueldo []= new int [numEmpleados];
                          int sum=0, mas=0;
                          double promedio=0;
                          
                         
                          for (int i=0; i<numEmpleados; i++){
                                  System.out.println ("Nombre del empleados " +(i+1) + " : ");
                                  nombre[i]=Keyboard.readString();
                                  System.out.println ("Horas trabajadas por " +nombre[i] + " : ");
                                  horas [i]=Keyboard.readInt();
                                  sum=sum+horas[i];
                                  promedio=sum/numEmpleados;
                                  sueldo[i]=horas[i]*30;
                                  if (horas[i]>promedio)
                                       mas++;
                                                                                                 }
                          System.out.println (mas +" Trabajadores trabajaron mas que el promedio");
                          for (int i=0; i<numEmpleados; i++){
                                  System.out.println (nombre[i] +" su sueldo es: " +sueldo[i]);
                                                                                                }
            
  
                                                                                              }// fin del main
                                                 }// Fin de la clase
             

