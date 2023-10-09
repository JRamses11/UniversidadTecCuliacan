package CLASE;

/*Crear una clase Libro que contenga los siguientes atributos:
– ISBN
– Titulo
– Autor
– Número de paginas
Crear sus respectivos metodos get y set correspondientes para cada atributo. Crear el metodo toString() 
para mostrar la informacion relativa al libro con el siguiente formato:
El libro con ISBN creado por el autor tiene paginas
*/

public class Libro{
	   private String titulo, autor, ISBN;
	   private int numPag;
	   
	   //Constructores
	   public Libro(String titulo, String ISBN, String autor, int numPag){
	   this.titulo=titulo;
	   this.ISBN=ISBN;
	   this.autor=autor;
	   this.numPag=numPag;
	   }
    
	   //Metodo toString
	   public String toString(){
	   return "El libro " +titulo +" con ISBN de: " +ISBN +" creado por: " +autor +" tiene " +numPag +" paginas";
	   }
	   
	   //Metodos get y set
	   //Titulo
	   public String gettitulo(){
		      return titulo;
	   }
	   public void settitulo(String titulo){
	          this.titulo=titulo;
	   }
	   // Autor
	   public String getautor(){
		      return autor;
	   }
	   public void setautor(String autor){
		      this.autor=autor;
	   }
       //ISBN
       public String getISBN(){
		      return ISBN;
	   }
	   public void setISBN(String ISBN){
		      this.ISBN=ISBN;
	   }
	   //Numero de Paginas
	   public int getnumPag(){
		      return numPag;
	   }
	   public void setnumPag(int numPag){
		      this.numPag=numPag;
	   }
}