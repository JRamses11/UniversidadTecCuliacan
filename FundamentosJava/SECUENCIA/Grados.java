package SECUENCIA;

//Este programa convierte de grados celcius a fahrenheit
//Jose Ramses Aldama Cazares
//11:00-12:00

public class Grados {
         public static void main (String [ ] args) {
        double celscius =0;
        System.out.println("Cuantos grados celcius deseas convertir");
         celscius=Keyboard.readDouble();
         double fahrenheit = (celscius*9/5)+32;
         System.out.println("Cuantos grados fahrenheit son " +fahrenheit);
         System.out.print("Fin del programa");
         
         }//Fin del proceso
}//Fin de la clase