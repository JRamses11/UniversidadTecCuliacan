package SET_GET;

//Este programa almacena el area de 20 triangulos, obtiene un listado de cada uno con su area y te dice en que posicion se encuentra el triangulo mas grande
//Jose Ramses Aldama Cazares
//11:00-12:00

public class UsaTriangulo{
            public static void main (String [] args){
                          int areaMayor=0;
                          int cont=0;
                          Triangulo triangulos[] = new Triangulo[20];
                          for (int i=0; i<triangulos.length; i++){
                                   System.out.println ("Cual el base del triangulo " +(i+1));
                                    int b=Keyboard.readInt();
                                    System.out.println ("Cual es su altura del triangulo " +(i+1));
                                    int a=Keyboard.readInt();                
                                    triangulos [i]= new Triangulo (a,b);        
                                                                                                    }
                           System.out.println();                        
                           for (int i=0; i<triangulos.length; i++){
                                   System.out.println ("Triangulo " +(i+1));
                                   System.out.println ("Area = " +triangulos[i].area());
                                   if (triangulos[i].area()>areaMayor){
                                      areaMayor=triangulos[i].area();
                                      cont= (i+1);
                                                                                                         }
                                                                                                       }
                            System.out.println();
                            System.out.println("El triangulo numero " +cont +" tiene el area mas grande" );


                                                                                            }// fin del main
                                                     }// fin de la clase

                                   