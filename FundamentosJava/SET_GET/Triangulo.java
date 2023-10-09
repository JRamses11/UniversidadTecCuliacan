package SET_GET;

//Creacion del objeto Triangulo

public class Triangulo {
           //atributos
           int base;
           int altura;
           // constructor
           public Triangulo ( int b, int a){
                         base = b;
                         altura = a;
                                                                    }
            // calcular área
            public int area(){
                         return base * altura / 2 ;
                                            }
            // método toString
                public String toString(){
                return "base = " +base +
                              "altura = " + altura;
                                                               }
            // métodos get
                public int getAltura(){
                             return altura ;
                                                           }
                 public int getBase(){
                              return base ;
                                                         }
             // métodos set
                 public void setBase (int b){
                               base = b;                                                                      
                                                                     }
                  public void setAltura (int a){
                               altura = a;
                                                                         }
} // fin de clase
