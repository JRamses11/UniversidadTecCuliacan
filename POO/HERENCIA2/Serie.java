package HERENCIA2;

/*rearemos una clase llamada Serie con las siguientes caracter�sticas:
Sus atributos son titulo, numero de temporadas, entregado, genero y creador.
Por defecto, el numero de temporadas es de 3 temporadas y entregado false. El resto de atributos ser�n valores por defecto seg�n el tipo del atributo.
Los constructores que se implementaran ser�n:
Un constructor por defecto.
Un constructor con el titulo y creador. El resto por defecto.
Un constructor con todos los atributos, excepto de entregado.
Los m�todos que se implementara ser�n:
M�todos get de todos los atributos, excepto de entregado.
M�todos set de todos los atributos, excepto de entregado.
Sobrescribe los m�todos toString. */

public class Serie implements Entregable{
	 //Atributos
	 private String titulo;
	 private int numTem;
	 private boolean entregado;
	 private String genero;
	 private String autor;
	 
	 //Contructores
	 public Serie (String titulo, String genero, String autor, int numTem){
		 this.titulo=titulo;
		 this.genero=genero;
		 this.autor=autor;
		 this.numTem=numTem;
		 entregado=false;
	 }
	 
	 public Serie(String titulo, String creador){
		 this(titulo, "", creador, 3);
	 }
	 
	 public Serie(){
		 this("", "", "", 3);
	 }
		 
	 public String toString(){
		 return "La serie "+titulo +" del genero de "+genero +"por el autor " +autor  +" tiene una duracion de " +numTem;
	 }
		 
		 
	  //Metodos get y set
	  //Titulo
	  public String getTitulo(){
		  return titulo;
	  }
	  public void setTitulo(String titulo){
		  this.titulo=titulo;
	  }
	  
      //Numero de temporadas
	  public int getNumTem(){
		  return numTem;
	  }
	  public void setNumTem(int numTem){
		  this.numTem=numTem;
	  }  
	  //Genero
	  public String getGenero(){
		  return genero;
	  }
	  public void setGenero(String genero){
		  this.genero=genero;
	  }
	  
	  //Autor
	  public String getAutor(){
		  return autor;
	  }
	  public void setAutor(String autor){
	      this.autor=autor;
	  }
	  //A++
	  public void entregar(){
		entregado=true;
	  }
	  public void devolver(){
		entregado=false;
	  }
	  public boolean isEntregado(){
		return entregado;
	  }
	  public boolean compareTo (Object a){
		if (a instanceof Serie)
			return numTem==((Serie) a).numTem;
				return false;
	  }
}