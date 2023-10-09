package HERENCIA;

//Clase Ejecutable Electrodomestico
//Jose Ramses Aldama Cazares
//8:00-9:00

/*Crea un array de Electrodomesticos de 10 posiciones.
Asigna a cada posición un objeto de las clases anteriores con los valores que desees.
Ahora, recorre este array y ejecuta el método precioFinal().
Deberás mostrar el precio de cada clase, es decir, el precio de todas las televisiones por un lado, el de las lavadoras por otro 
y la suma de los Electrodomesticos (puedes crear objetos Electrodomestico, pero recuerda que Television y Lavadora también son electrodomésticos). 
Recuerda el uso operador instanceof.
Por ejemplo, si tenemos un Electrodomestico con un precio final de 300, una lavadora de 200 y una televisión de 500,
el resultado final sera de 1000 (300+200+500) para electrodomésticos, 200 para lavadora y 500 para televisión */



public class AppElectrodomestico{
	   public static void main (String [] args){
	          Electrodomestico [] aparato= new Electrodomestico[10];  
			  for (int i=0; i<aparato.length; i++){
			       System.out.println ("El precio para electrodomésticos " +" El precio para televisiones " 
				   +" El precio para lavadoras " );
				   
				   }
      }
}