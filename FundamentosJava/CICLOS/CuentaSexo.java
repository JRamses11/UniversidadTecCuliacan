package CICLOS;

//Este programa lee el nombre y el sexo de 1o personas y calcula el numero de mujeres y hombres
//Jose Ramses Aldama Cazares
//11:00-12:00

public class CuentaSexo{
            public static void main (String [] args){
            String sexo;
            int mujeres=0;
            int hombres=0;
            System.out.println ("Masculino o Femenino");
            for (int i=1; i<=2; i++){
                    System.out.print ("Cual es tu sexo : ");
                    sexo=Keyboard.readString();
                    sexo=sexo.toUpperCase();
                    if(sexo.equals("FEMENINO")){
                        mujeres=mujeres+1;
                   
                                                                                }
                              if (sexo.equals("MASCULINO")){
                                   hombres=hombres+1;
                                                                                               }
                    }
                    System.out.println ("Cuantas Mujeres hay " +mujeres);
                    System.out.println ("Cuantos Hombres hay " +hombres);
                                                                                           }
                                            }