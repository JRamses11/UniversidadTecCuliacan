package HERENCIA;

//Herencia
//Jose Ramses Aldama Cazares
//8:00-9:00

public class Electrodomestico{
       protected float precio;
		 protected String color;
		 protected char consumo;
		 protected float peso;
		 
		 //Constructor
		 public Electrodomestico (float precio, String color, char consumo, float peso){
			    this.precio=precio;
				this.color=color;
				this.consumo=Character.toUpperCase(consumo);
				comprobarConsumoEnergetico(this.consumo);
				this.peso=peso;
		 }
		 public Electrodomestico(float precio, float peso){
			 this (precio, "Blanco", 'F', peso);
		 }
	     public Electrodomestico(){
			 this(100, "Blanco", 'F', 5);
		 }
		 
		 //Metodos
       private void comprobarConsumoEnergetico (char letra){
       if (!(letra>='A' && letra<='F') || (letra>='a' && letra<= 'f'))
			 consumo='F';
		 }
		 
		 public float precioFinal(){
	     float precioF=precio;
		 switch (consumo){
			    case 'A': precioF+=100; break;
		        case 'B': precioF+=80; break;
		        case 'C': precioF+=60; break;
				case 'D': precioF+=50; break;
				case 'E': precioF+=30; break;
				case 'F': precioF+=10; break;
		 }
		 if (peso<=19)
			 precioF+=10;
		    if (peso<=49)
				precioF+=50;
			    if (peso<=79)
					precioF+=80;
		            else
				    precioF+=100;
		 return precioF;
		 }
		 //Metodos Get
		 public float getprecio(){
			    return precio;
	     }
		 public String getcolor(){
			    return color;
		 }
		 public char consumo(){
			    return consumo;
		 }
		 public float peso(){
			    return peso;
		 }
		 
}