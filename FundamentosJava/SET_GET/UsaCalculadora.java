package SET_GET;

//Este programa funciona como una calculadora importada de la clase Calculadora
//Jose Ramses Aldama Cazares
//11:00-12:00

public class UsaCalculadora{
            public static void main (String [] args){
                          // Declaracion de variables

                          double val1;
                          double val2;
                          int opcion;           
                          String continuar;   
                          // ciclo para la ejecucion

                          do{    
                          System.out.println ("------------------------CALCULADORA-------------------------");
                          System.out.println ("1- SUMA");
                          System.out.println ("2- RESTA");
                          System.out.println ("3- MULTIPLICACION");
                          System.out.println ("4- DIVISION"); 
                          System.out.println ("ELIGE LA OPCION DE LA OPERACION QUE DESEAS EJECUTAR");  
                         // si la opcion no es correcta te vuelve a pedir el dato, aunque te vuelve aparecer el mensaje :(

                          do{      
                                opcion=Keyboard.readInt();
                                System.out.println ("Ingresa la opcion correcta"); 
                                 }while (opcion<=0 || opcion>4);
                         // Pregunto el valor de las variables

                               System.out.println ("Ingresa el valor del primer numero");
                               val1=Keyboard.readDouble();
                               System.out.println ("Ingresa el valor del segundo numero");
                               val2=Keyboard.readDouble();
                               Calculadora resultado = new Calculadora(val1, val2);  

                         // Se realiza la ejecucion de las operacion señalada
                               if (opcion==1){     
                                 System.out.println ("La suma de " +val1 +" y " +val2 +" es = " +resultado.suma());
                                                              }
                                     if (opcion==2){  
                                         System.out.println ("La resta de " +val1 +" y " +val2 +" es =" +resultado.resta());
                                                                   }
                                         if (opcion==3){                                                                                                       
                                              System.out.println ("La multiplicacion de " +val1 +" y " +val2 +" es = " +resultado.multiplicacion());
                                                                         }
                                              if (opcion==4){                                                                             
                                                  if (val2==0){
                                                       System.out.println ("ERROR DE CALCULO"); 
                                                                       }
                                                  System.out.println ("La division de " +val1 +" y " +val2 +" es = " +resultado.division());
                                                                          }  
                             // pregunto si desea continuar con el programa en dado caso que la respuesta no sea no, vuelve a ejecutar                                                         
                               System.out.println("Deseas continuar con las operaciones SI--------NO");
                               continuar=Keyboard.readString();
                               continuar=continuar.toUpperCase();  
                               } while ((!continuar.equals("NO")));
                                

                                                                                               } // Fin del main
                                                         } // fin de la clase

