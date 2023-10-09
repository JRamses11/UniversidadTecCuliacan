package SET_GET;

//Creacion del objeto Cuadrado

public class Cuadrado{
           //Atributos
              int lado;
             
           //Constructor
              public Cuadrado (int l){
              lado=l;
                                                           }
            //Metodo toString
              public String toString(){
              return "lado =" +lado;
                                                             }
              //Metodos get
                public int getLado(){
                return lado;
                                                         }
              //Metodos set
                public void setLado(int l){
                lado=l;
                                                       }
               //Calcular area
                 public int area(){
                 return lado*lado;
                                                 }
               //Calcular perimetro
                  public int perimetro(){
                  return lado+lado+lado+lado;
                                                             }
  } // fin de la clase