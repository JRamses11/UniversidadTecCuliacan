package HERENCIA;

//Clase TELEVISION HEREDA DE ELECTRODOMESTICO
//Jose Ramses Aldama Cazares
//8:00-9:00

/*  Sus atributos son resoluci�n (en pulgadas) y sintonizador TDT (booleano), ademas de los atributos heredados.
Por defecto, la resoluci�n sera de 20 pulgadas y el sintonizador sera false.
Los constructores que se implementaran ser�n:
Un constructor por defecto.
Un constructor con el precio y peso. El resto por defecto.
Un constructor con la resoluci�n, sintonizador TDT y el resto de atributos heredados. Recuerda que debes llamar al constructor de la clase padre.
Los m�todos que se implementara ser�n:
M�todo get de resoluci�n y sintonizador TDT.
precioFinal(): si tiene una resoluci�n mayor de 40 pulgadas, se incrementara el precio un 30% 
y si tiene un sintonizador TDT incorporado, aumentara 50 �. 
Recuerda que las condiciones que hemos visto en la clase Electrodomestico tambi�n deben afectar al precio.
*/
public class Television extends Electrodomestico{
    //Atributos
	  private double resolucion;
	  private boolean sintonizador;
	  
	  //Contructores
	  public Television (float precio, String color, char consumo, float peso, double resolucion, boolean sintonizador){
	  super (precio, color, consumo, peso);
	  this.resolucion=resolucion;
	  this.sintonizador=sintonizador;
	  }
	  
	  public Television (float precio, float peso){
      this (precio, "Blanco", 'F', peso, 20, false);
	  }  
	  
	  public Television (){
	  this (100, "Blanco", 'F', 5, 20, false);
	  }
	  //Metodos
	  public float precioFinal(){
	  float precioF= super.precioFinal();
    if (resolucion>40){
        precioF+=(precioF*.30f); 
	  }
        if (sintonizador==true){
			  precioF+=50;
		  }
		      
      return precioF;		
	  }  
	  //Metodos get
	  public double getresolucion(){
		   return resolucion;
	  }
	  public boolean getsintonizador(){
		   return sintonizador;
	  }
		  
	  
	  }