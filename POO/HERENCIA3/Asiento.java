package HERENCIA3;

/*Los asientos son etiquetados por una letra (columna) y un número (fila)
la fila 1 empieza al final de la matriz como se muestra en la tabla
También deberemos saber si está ocupado o no el asiento. */

public class Asiento{
	 //Atributos
     private boolean ocupada;
	 private Espectador espe;
	 
	 //Constructores
	 public Asiento(Espectador espe){
		 this.ocupada=true;
		 this.espe=espe;
	 }
	 public String toString (){
		 return "Asientos ocupados: " +ocupada +" espectador: " +espe;
	 }
	 
	 //Metodos get y set
	 //Asiento ocupado
	 public boolean isOcupada(){
		 return ocupada;
	 }
	 public void setOcupada(boolean ocupada){
		 this.ocupada=ocupada;
	 }
	 //Espectador
	 public Espectador getEspe(){
		 return espe;
	 }
	 public void setEspe(Espectador espe){
		 this.espe=espe;
	 }
		 
	 
	 
} 