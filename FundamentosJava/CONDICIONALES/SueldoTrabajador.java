package CONDICIONALES;

//Este programa lee el sueldo y categoria de un trabajador y en base a ello se le hace un incremento
public class SueldoTrabajador{
           public static void main (String args []){
                        double pago=0;
                        double sueldo;
                        System.out.println ("Cual es el sueldo del trabajador");
                        sueldo=Keyboard.readDouble();
                        int categoria;
                        System.out.println ("Que categoria tienes");
                        categoria=Keyboard.readInt();
                        switch (categoria){
                                       case 1 : pago=sueldo+(sueldo*0.15); 
                                       System.out.println("Su nuevo suedo es " +pago); break;

                                       case 2 : pago=sueldo+(sueldo*0.10); 
                                       System.out.println("Su nuevo sueldo es " +pago); break;

                                       case 3 : pago=sueldo+(sueldo*0.08); 
                                       System.out.println("Su nuevo sueldo es " +pago); break;

                                       case 4 : pago=sueldo+(sueldo*0.05); 
                                       System.out.println("Su nuevo sueldo es " +pago); break;

                                       default: System.out.println("Categoria invalida"); break;
                                                                }
                                                                                          }
}
                                                             
