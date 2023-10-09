package CLASE;

//Ejemplos

public class Personas{
	   // Declaracion de variables
     private String id, nombre;
	   private byte edad;
	   private char sexo;
	   private String direccion;
	   
	   // mismo metodo para la clase
	   public Personas(){
		   this("", "Sin nombre", (byte) 0, 'H', "Sin especificar");
	   }
	   public Personas (String id, String nombre, byte edad, char sexo, String direccion){
		   this.id=id;
		   this.nombre=nombre;
		   this.edad=edad;
		   this.setSexo(sexo);
		   this.setDireccion(direccion);
	   }
		   
	   //ID
	   public String getid(){
	   return id;
	   }
	   public void setid(String id){
	   this.id=id;
	   }
	   // NOMBRE
	   public String getnombre(){
	   return nombre;
	   }
	   public void setnombre(String nombre){
	   this.nombre=nombre;
	   }
	   //EDAD
	   public byte getedad(){
	   return edad;
	   }
	   public void setedad( byte edad){
	   this.edad=edad;
	   }
	   //SEXO
	   public char getSexo() {
		return sexo;
	   }
	   public void setSexo(char sexo) {
		this.sexo = sexo;
	   }
	   //DIRECCION
	   public String getDireccion() {
		return direccion;
	   }
	   public void setDireccion(String direccion) {
		this.direccion = direccion;
	   }
}
