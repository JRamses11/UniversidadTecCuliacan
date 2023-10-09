package SET_GET;

//Este programa utiliza una clase de tipo persona para obener el numero de mujeres del grupo, el promedio de edad de las personas y el total de niñños, adolescentes, adultos, ancianos
//Jose Ramses Aldama Cazares
//11:00-12:00

public class UsaPersona{
            public static void main (String [] args){
                           Persona personas[]= new Persona[10];
                           int promedio=0, mujeres=0, nin=0, ado=0, adu=0, anc=0, sum=0;
                           
                           for( int i=0; i<personas.length; i++){
                                   System.out.println ("Nombre de la persona " +(i+1));
                                   String n= Keyboard.readString();
                                   System.out.println ("Cual es tu edad");
                                   int e= Keyboard.readInt();
                                   System.out.println ("Cual es tu sexo F o M");
                                   char s=Keyboard.readChar();

                                   personas[i]= new Persona (n, s, e);
                                   sum=sum+personas[i].getEdad();
                                   promedio=sum/personas.length;
                                                                                                   } // fin del for
                            for (int i=0; i<personas.length; i++){
                                    if (personas[i].getSexo() == 'F')
                                         mujeres++;
                                                                                                   } // fin del for
                            for ( int i=0; i<personas.length; i++){
                                    int ed=personas[i].getEdad();
                                    if(ed>=0 && ed<=12){
                                         nin++;
                                         }
                                         if (ed>=13 && ed<=17){
                                              ado++;
                                               }
                                               if (ed>=18 && ed<=59){
                                                     adu++;
                                                      }
                                                      if (ed>=60){
                                                            anc++;
                                                            }
                                                                                                      }// fin del for
                                System.out.println ("El total de mujeres son " +mujeres);
                                System.out.println ("El total de niños son " +nin);
                                System.out.println ("El total de adolescentes son " +ado);
                                System.out.println ("El total de adultos son "  +adu);
                                System.out.println ("El total de ancianos son " +anc);
                                System.out.println ("El promedio de la edad es " +promedio);
                                 
                                                                                           } // fin del main
                                                   } // fin de la clase