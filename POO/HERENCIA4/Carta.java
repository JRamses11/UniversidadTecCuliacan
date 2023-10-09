package HERENCIA4;

//
//
//

public class Carta{
	   //Atributos
	   private byte numero;
	   private String nombre;
	   
	   //Metodos
	   public Carta(byte numero, String nombre){
		   this.numero=numero;
		   this.nombre=nombre;
	   }
	   public String toString(){
		   return "\n" + nombre +" " +numero;
	   }
}
