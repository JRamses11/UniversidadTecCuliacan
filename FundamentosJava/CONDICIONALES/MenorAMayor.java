package CONDICIONALES;

//Este programa lee 3 valores y  los ordena de menor a mayor
//Jose Ramses Aldama Cazares
//11:00-12:00

public class MenorAMayor{
            public static void main (String [] args){
                          int a;
                          int b;
                          int c;
                          System.out.println ("Cuales son tus tres valores");
                         a=Keyboard.readInt();
                         b=Keyboard.readInt();
                         c=Keyboard.readInt();
                         if ( a<b && a<c && b<c){
                         System.out.println (a);
                         System.out.println (b);
                          System.out.println (c);
}
                                if (b<a && b<c && c<a){
                                System.out.println (b);
                                System.out.println (c);
                                System.out.println (a);
}
                                        if (c<a && c<b && a<b){
                                        System.out.println (c);
                                        System.out.println (a);
                                        System.out.println (b);
}
                                                                                           }                                                                                                                                    
                                                           }