package SECUENCIA;

//Este programa calcula el indice de masa corporal de una persona
//Jose Ramses Aldama Cazares
//11:00-12:00

public class IMC{
            public static void main (String [] args){
                         int peso=0;
                         double altura=0;
                         System.out.println ("Cuanto pesas");
                         peso=Keyboard.readInt();
                         System.out.println ("Cuanto mides");
                         altura=Keyboard.readDouble();
                         double imc=peso/Math.pow(altura,2);
                         System.out.format ("Tu IMC es " +"%.3f%n", +imc);
                         System.out.println ("Fin del programa");
                                                                                          }
                                  }