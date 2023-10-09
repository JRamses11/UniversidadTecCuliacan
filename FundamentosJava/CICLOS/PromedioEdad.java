package CICLOS;

//Este programa lee el nombre y edad de 10 personas y realiza cual es el promedio de las edades
//Jose Ramses Aldama Cazares
//11:00-12:00

public class PromedioEdad{
           public static void main (String [] args){
                         int edad;
                         int promedio=0;
                         for (int i=0; i<10; i++){
                                System.out.print ("Cual es tu edad : ");
                                edad=Keyboard.readInt();                         
                                promedio=promedio+edad;
                                                                       }
                                promedio=promedio/10;
                                System.out.print ("El promedio de edad es : " +promedio); 
                                                                                         }
                                                          }