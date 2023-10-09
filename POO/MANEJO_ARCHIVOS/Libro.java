package MANEJO_ARCHIVOS;

//Jose Ramses Aldama Cazares
//8:00-9:00
public class Libro {
    private int Clave;
    private String Titulo;
    private String Autor;
    private String Editorial;
    private String Anio;
    
  //Constructores
  public Libro() {
  	this(0, null, null, null, null);
  }
  
  public Libro(int clave, String titulo, String autor, String editorial, String anio) {
  	super();
  	Clave=clave;
  	Titulo=titulo;
  	Autor=autor;
  	Editorial=editorial;
  	Anio=anio;
  }
  //METODO TO STRING 
  public String toString() {
  	return  Clave + "|" + Titulo + "|" + Autor + "|" + Editorial
				+ "|" + Anio;
  }
  //METODOS GET Y SET
  public int getClave() {
		return Clave;
	}

	public void setClave(int clave) {
		Clave = clave;
	}

	public String getTitulo() {
		return Titulo;
	}

	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public String getAutor() {
		return Autor;
	}

	public void setAutor(String autor) {
		Autor = autor;
	}

	public String getEditorial() {
		return Editorial;
	}

	public void setEditorial(String editorial) {
		Editorial = editorial;
	}

	public String getAnio() {
		return Anio;
	}

	public void setAnio(String anio) {
		this.Anio = anio;
	}
  	
  
}