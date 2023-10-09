package CICLOS;

//Este programa reside los datos de los trabajores y dependiendo de su categoria de empleado es el pago x hora de sus labores
//Jose Ramses Aldama Cazares
//11:00-12:00

public class PagoTrabajador{
           public static void main (String [] args){
                        String nombre;
                        int cuenta;
                        char categoria;
                        int horas;
                        for (int i=1; i<=20; i++){
                        System.out.print ("Cual es tu nombre " );
                        nombre=Keyboard.readString();
                        System.out.print ("Cuantas horas trabajaste " );
                        horas=Keyboard.readInt();
                        System.out.print ("Cual es tu categoria " );
                        categoria=Keyboard.readChar();                                                 
                        switch (categoria){
                                      case 'A': cuenta=horas*50; 
                                       System.out.println("Nombre: "+nombre);
                                       System.out.println ("Su pago es " +cuenta); break;
                                       case 'B': cuenta=horas*60; 
                                       System.out.println("Nombre: "+nombre);
                                       System.out.println ("Su pago es " +cuenta); break;
                                       case 'C': cuenta =horas*70; 
                                       System.out.println("Nombre: "+nombre);
                                       System.out.println ("Su pago es " +cuenta); break;
                                       default: System.out.println ("No cuenta con una categoria");
                                                               } //Fin del switch
                                                                       } //Fin del for
                                                                                              }//Fin del main
                                                                    }//Fin de la clase
