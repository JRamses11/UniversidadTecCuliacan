package HERENCIA3;

//Del espectador, nos interesa saber su nombre, edad y el dinero que tiene.

public class Espectador{
    //Atributos
	  private String nombre;
	  private int edad, dinero;
	  
	  //Constructores
	  public Espectador(String nombre, int edad, int dinero){
		  this.nombre=nombre;
	      this.edad=edad;
		  this.dinero=dinero;
	  }
	  public String toString (){
		  return "Nombre: " +nombre +", Edad: " +edad +", Dinero "+dinero;
	  }
		  
	  //Metodos get y set
	  //Nombre
	  public String getNombre(){
		  return nombre;
	  }
	  public void setNombre(String nombre){
		  this.nombre=nombre;
	  }
	  //Edad
	  public int getEdad(){
		  return edad;
	  }
	  public void setEdad(int edad){
		  this.edad=edad;
	  }
	  //Dinero
	  public int getDinero(){
		  return dinero;
	  }
	  public void setDinero(int dinero){
		  this.dinero=dinero;
	  }
	  
}