package ARREGLOS;

/*En este programa defino dos arreglos, alumnos y calificaciones, guardo datos en cada uno
de ellos e imprime un listado de todos los alumnos que tienen calificación
mayor que el promedio del grupo*/

public class Escuela{
              public static void main (String [] args){
                           int alum;
                           int promedio=0, sum=0;
                           System.out.println ("Cuantos alumnos desea capturar");
                           do{
                            alum=Keyboard.readInt();
                            if (alum<0){
                                System.out.println ("Ingrese un dato correcto"); }
                                  if (alum==0){
                                       System.out.println ("Fin del programa"); }
                                  } while(alum<0);

                           String alumnos[] = new String [alum];
                           int calificacion[] = new int [alum];

                           for (int i=0; i<alum; i++){
                                  System.out.println ("Nombre del alumno " +(i+1) +":");
                                  alumnos[i]=Keyboard.readString();
                                  System.out.println ("Cual fue su calificacion:");
                                  calificacion [i]=Keyboard.readInt();
                                  sum=sum+calificacion[i];
                                  promedio=sum/alum;
                                                                           } // Fin del for
                                    System.out.println ("El promedio del grupo es " +promedio);
                             for (int i=0; i<alum; i++){
                                     if (calificacion[i]>promedio)
                                         System.out.println (alumnos[i] +" Su calificacion: " +calificacion [i]); }
                                  
                                                                                           } //Fin del main
                                         } //Fin de la clase