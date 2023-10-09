package SET_GET;

//Declaracion de la clase Operaciones.java para una calculadora
//Jose Ramses Aldama Cazares 
//11:00-12:00

public class Calculadora{

 
           /* atributos
para los objetos */
              private double val1;
  
              private double val2;

 

          /* constructor
para los parametros de los atributos */
            public Calculadora (double x, double y) {
     
            this.val1 = x;
      
            this.val2 = y;

                                                                                            }

  
          // operacion de Suma
 
            public double suma() {
     
            return val1 + val2;
 
                                                        }

  
          // operacion de Resta
  
             public double resta() {
      
             return val1-val2;
  
                                                        }

  
          // operacion de Multiplicacion
  
             public double multiplicacion() {
     
             return val1*val2;

                                                                           }

 
          // operacion de division
  
             public double division() {
     
             return val1/val2;

                                                              }


                                                  
}// Fin de la clase