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
            // calcular �rea
            public int area(){
                         return base * altura / 2 ;
                                            }
            // m�todo toString
                public String toString(){
                return "base = " +base +
                              "altura = " + altura;
                                                               }
            // m�todos get
                public int getAltura(){
                             return altura ;
                                                           }
                 public int getBase(){
                              return base ;
                                                         }
             // m�todos set
                 public void setBase (int b){
                               base = b;                                                                      
                                                                     }
                  public void setAltura (int a){
                               altura = a;
                                                                         }
} // fin de clase
