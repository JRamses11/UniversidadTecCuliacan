package HERENCIA3;

//Del cine nos interesa conocer la película que se está reproduciendo y el precio de la entrada en el cine.
//Herencia

public class Cine{
	   //Atributos
     private Peliculas peli;
	   private int entrada;
	   private Asiento lugar[][];
	   
	   //Constructores
	   public Cine(Peliculas peli, int entrada){
		   this.peli=peli;
		   this.entrada=entrada;
		   lugar= new Asiento[8][9];
	   }
	   public String toString (){
		   return "Pelicula: "+peli +", Costo: "+entrada;
	   }
	   
	   //Metodos get y set
	   //Peli
	   public Peliculas getPeli(){
		   return peli;
	   }
	   public void setPeli(Peliculas peli){
		   this.peli=peli;
	   }
	   //Entrada
	   public double getEntrada(){
		   return entrada;
	   }
	   public void setEntrada(int entrada){
		   this.entrada=entrada;
	   }
	   //Lugares
	   public Asiento getLugar(int ren, int col){
		   return lugar[ren][col];
	   }
	   public void setLugar(int ren, int col, Asiento b){
		   this.lugar[ren][col]= b;
	   }
}