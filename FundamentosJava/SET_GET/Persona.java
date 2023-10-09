package SET_GET;

/* Declaración de la clase Persona.java
contiene atributos nombre, sexo y edad
Metodos
: get /set para los atributos y toString
*/

public class Persona{
              // atributos para los objetos
                  private String nombre;
                  private char sexo;
                  private int edad;

             // constructor de Persona
                 public Persona ( String n){
                 nombre = n;
                                                                    }
             // constructor con los 3 parametros para los atributos
                 public Persona( String n, char s, int e){
                 this.nombre =n;
                 this.edad =e;
                 this.sexo =s;
                                                                                            }
                public String toString(){
                return nombre +", "+sexo +", "+edad;
                                                               }
             // regresa el valor del atributo edad
                public int getEdad(){
                return edad;
                                                        }
             // regresa el valor del atributo nombre
                 public String getNombre(){
                 return nombre;
                                                                      }
             // regresa el valor del atributo sexo
                 public char getSexo(){
                 return sexo;
                                                            }
             // cambia el valor del atributo edad
                 public void setEdad (int nuevaEdad){
                 edad = nuevaEdad;
                                                                                          }
            // cambia el valor del atributo nombre
                public void setNombre (String nuevoNombre){
                nombre = nuevoNombre;
                                                                                                             }
            // cambia el valor del atributo sexo
                public void setSexo (char nuevoSexo){
                sexo =nuevoSexo;
                                                                                            }
} // fin de la clase