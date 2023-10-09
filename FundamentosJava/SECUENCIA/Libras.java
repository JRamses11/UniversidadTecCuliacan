package SECUENCIA;

//Este programa convierte de kilogramos a libras

public class Libras {
           public static void main (String  args []){
           int kilogramos=0;
           System.out.println ("Cuantos kilogramos quieres pasar a libras");
           kilogramos=Keyboard.readInt();
           double libras= (kilogramos*2.02);
           System.out.println ("Cuantas libras son " +libras);
           System.out.print ("Fin del programa");
          }
}