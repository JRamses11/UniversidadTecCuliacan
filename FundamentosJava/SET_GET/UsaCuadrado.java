package SET_GET;

//Este programa importa la clase cuadrado para calcular el area y perimetros de varios cuadrados
//Jose Ramses Aldama Cazares
//11:00-12:00

public class UsaCuadrado{
            public static void main (String [] args){
                          
                          Cuadrado operaciones []= new Cuadrado[5];
                          for (int i=0; i<operaciones.length; i++){
                                  System.out.println( "Cuanto miden los lados de cuadrado: " +(i+1));
                                  int l=Keyboard.readInt();
                                  operaciones[i]= new Cuadrado (l);
                                                                                                        }
                          System.out.println();
                          for (int i=0; i<operaciones.length; i++){
                                 System.out.println ("Cuadrado " +(i+1));
                                 System.out.println ("Su area es: " +operaciones[i].area());
                                 System.out.println ("Su perimetro es: " +operaciones[i].perimetro());
                                                                                                        }

                                                                                        }// fin del main
                                                  }// fin de la clase