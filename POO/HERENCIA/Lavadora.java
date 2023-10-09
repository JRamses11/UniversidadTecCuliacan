package HERENCIA;

//LAVADORA HEREDA
//Jose Ramses Aldama cazares
//8:00-9:00

public class Lavadora extends Electrodomestico{
     private float carga;
	   
	   //Constructor
	   public Lavadora(float precio, String color, char consumo, float peso, float carga){
	   super(precio, color, consumo, peso);
	   carga=this.carga;
	   }
	   
	   public Lavadora (float precio, float peso){
	   /*super(precio, peso);
	   carga=5; */
	   this (precio, "Blanco", 'F', peso, 5);
	   }
	   
	   public Lavadora(){
	   /*super();
	   carga=5; */
	   this (100, "Blanco", 'F', 5, 5);
	   }
	   //Metodo
	  public float precioFinal(){
	  float precioF= super.precioFinal();
	  if (carga>30)
		  precioF+=50;
	  return precioF;
	  }
	   //Metodos get
	   public float getcarga(){
	   return carga;
	   }
}
