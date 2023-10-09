package HERENCIA2;

/*Crearemos una clase Videojuego con las siguientes características:
Sus atributos son titulo, horas estimadas, entregado, genero y productora.
Por defecto, las horas estimadas serán de 10 horas y entregado false. 
El resto de atributos serán valores por defecto según el tipo del atributo.
Los constructores que se implementaran serán:
Un constructor por defecto.
Un constructor con el titulo y horas estimadas. El resto por defecto.
Un constructor con todos los atributos, excepto de entregado.
Los métodos que se implementara serán:
Métodos get de todos los atributos, excepto de entregado.
Métodos set de todos los atributos, excepto de entregado.
Sobrescribe los métodos toString.*/

public class Videojuego implements Entregable{
      //Atributos
	  private String titulo;
	  private int horas;
	  private boolean entregado;
	  private String genero;
      private String productora;

      //Constructores
      public Videojuego(String titulo, String genero, String productora, int horas){
            this.titulo=titulo;
            this.genero=genero;
            this.productora=productora;
			this.horas=horas;
			entregado=false;
	  }

      public Videojuego(String titulo, int horas){
            this(titulo, "", "", horas);
	  }
	  
      public Videojuego(){
             this("", "", "", 10);	 
	  }
	  
	  public String toString(){
		  return "El videojuego " +titulo +" del genero "+genero +" por la productora " +productora +" tiene una duracion de "+horas;
	  }
	  
      //Metodos get y set
        //Titulo
        public String getTitulo(){
            return titulo;
		}
        public void setTitulo(String titulo){
			this.titulo=titulo;
		}
		//Horas
		public int getHoras(){
			return horas;
		}
		public void setHoras(int horas){
			this.horas=horas;
		}
		//Genero
		public String getGenero(){
			return genero;
		}
		public void setGenero(String genero){
			this.genero=genero;
		}
		//Compañia
		public String getProductora(){
			return productora;
		}
		public void setProductora(String productora){
			this.productora=productora;
		}

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
		   if (a instanceof Videojuego)
			   return horas== ((Videojuego) a).horas;
			 	     return false;
	}
}