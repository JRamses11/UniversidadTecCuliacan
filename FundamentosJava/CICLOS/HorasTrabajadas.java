package CICLOS;

//Este programa canaliza los datos de un trabajador y obtiene su pago por cada hora trabajada
//Jose Ramses Aldama Cazares
//11:00-12:00

public class HorasTrabajadas{
           public static void main (String [] args){
            int horas=0;
            int cuenta=0;
            String nombre;
                         for (int i=1; i<=20; i++){
                         System.out.print ("Nombre : " );
                         nombre=Keyboard.readString();
                         System.out.print ("Cuantas horas trabajaste " );
                         horas=Keyboard.readInt();
                         cuenta=horas*50;
                         System.out.println("Nombre: " +nombre);
                         System.out.println ("Tu pago es "+cuenta);
                                                                        }
                                                                                       }
                                                        }
                     