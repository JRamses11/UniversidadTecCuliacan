package HERENCIA3;

//De las películas nos interesa saber el título, duracion, edad mínima y director.
//Herencia

public class Peliculas{
	//Atributos
	private String titulo, director;
	private int duracion, edadMin;
	
	
	//Constructores
	public Peliculas(String titulo, int duracion, int edadMin, String director){
		this.titulo=titulo;
		this.duracion=duracion;
		this.edadMin=edadMin;
		this.director=director;
	}
	public String toString(){
		return "Titulo: " +titulo +", Duracion: " +duracion +", EdadMinima "+edadMin +", Director " +director;
	}
	
	//Metodos get y set
	//Titulo
	public String getTitulo(){
		return titulo;
	}
	public void setTitulo(String titulo){
		this.titulo=titulo;
	}
	//Director
	public String getDirector(){
		return director;
	}
	public void setDirector(String director){
		this.director=director;
	}
	//Edad
	public int getEdadMin(){
		return edadMin;
	}
	public void setEdadMin(int edadMin){
		this.edadMin=edadMin;
	}
	//Duracion 
	public int getDuracion(){
		return duracion;
	}
	public void setDuracion(int duracion){
		this.duracion=duracion;
	}
	

}