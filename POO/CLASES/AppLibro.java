package CLASE;

/*
En el fichero main, crear 2 objetos Libro (los valores que se quieran) y mostrarlos por pantalla.

Por último, indicar cuál de los 2 tiene más páginas
*/

public class AppLibro{
       public static void main (String [] args){
	          Libro obra= new Libro("El hombre del presente y del pasado", "978-78-9-45", "Juan Lopez", 567 );
			  Libro obra2= new Libro("Dinosauro fugitivo", "977-78-39-58", "Alberto Sosa", 825);
			  
			  System.out.println(obra);
			  System.out.println (obra2);
			  
			  System.out.println();
			  if(obra.getnumPag()>obra2.getnumPag())
				 System.out.println ("El libro 1 tiene mas paginas");
			     else
					  System.out.println ("El libro 2 tiene mas paginas");
			  
	   }
}