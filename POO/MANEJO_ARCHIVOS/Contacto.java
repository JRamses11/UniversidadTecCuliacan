package MANEJO_ARCHIVOS;

public class Contacto {
	//Atributos
	private int Clave;
	private String Nombre;
	private String cel;
	private String Correo;
	private String Domicilio;
	
	//Constructores
	public Contacto() {
		this(0,null,null,null,null);
	}
	public Contacto(int clave, String nombre, String cel, String correo, String domicilio) {
		super();
		Clave = clave;
		Nombre = nombre;
		this.cel = cel;
		Correo = correo;
		Domicilio = domicilio;
	}
	//get y set
	public int getClave() {
		return Clave;
	}
	public void setClave(int clave) {
		Clave = clave;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getCel() {
		return cel;
	}
	public void setCel(String cel) {
		this.cel = cel;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	public String getDomicilio() {
		return Domicilio;
	}
	public void setDomicilio(String domicilio) {
		Domicilio = domicilio;
	}
	
	@Override
	public String toString() {
		return  + Clave + "|" + Nombre + "|" + cel + ", |" + Correo
				+ "|" + Domicilio ;
	}
}
