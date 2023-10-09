package CICLOS;

//Este programa lee el nombre y el sexo de 1o personas y calcula el numero de mujeres
//Jose Ramses Aldama Cazares
//11:00-12:00

public class Mujeres{
            public static void main (String [] args){
            
            String sexo;
            int mujeres=0;
            System.out.println ("Masculino o Femenino");
            for (int i=1; i<=10; i++){
                    System.out.print ("Cual es tu sexo : ");
                    sexo=Keyboard.readString();
                    sexo=sexo.toUpperCase();
                     if(sexo.equals("FEMENINO")){
                         mujeres=mujeres+1;
                        
                                                                                  }
                                                         }
                    System.out.println ("Cuantas mujeres hay " +mujeres);
                                                                                           }
                                            }