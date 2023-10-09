package CLASE;

//Clase Persona 2
//Jose Ramses Aldama Cazares
//8:00-9:00

import java.util.Random;
public class Personas2{
     //Declaracion de Variables
	   private String id, nombre;
	   private int edad;
	   private char sexo;
	   private float peso, altura;
	   public static final char HOMBRE='H', MUJER='M';
	   public static final byte BAJOPESO=-1, ENPESO=0, SOBREPESO=1, MayoriaEdad=18;
	   
	   //Constructores
	    public Personas2 (String nombre, byte edad, char sexo){
			this(nombre, edad, sexo, 0, 0);
		}
		
		public Personas2(){
			this("",0, 'H', 0, 0);
		} 
	   public Personas2 (String nombre, int edad, char sexo, float peso, float altura){
		   this.id=generaID();
		   this.nombre=nombre;
		   this.edad=edad;
		   this.sexo=sexo;
		   this.peso=peso;
		   this.altura=altura;
	   }
	   /*Metodo calcular el IMC si el IMC es menor que 20 en BAJOPESO devuelve un -1, si es mayor que 25 SOBREPESO 
	   devuelve un 1 y si se encuentra entre 20 y 25 ENPESO devuelve un 0 */
	   public byte CalculaIMC(){
		   double imc=peso/Math.pow(altura,2);
		   if (imc<20)
			   return BAJOPESO; //-1
		       if (imc>25)
			       return SOBREPESO; //1
		           else 
			           return ENPESO; //0
	   }
	   
	   //Metodo MayorEdad y devuelve un resultado boolean
	   public boolean MayorEdad(){
		   return edad>=MayoriaEdad;
	   }
	   /*Metodo Comprueba sexo si no es correcto sera H. no sera visible al exterior
	   private porque no sera visible y void porque no regresa nada */
	   private void CompruebaSexo(char sexo){
		       switch (sexo){
				   case 'm':
				   case 'M':
				        this.sexo=MUJER;
				        break;
				   default:
				        this.sexo=HOMBRE;
	            }
	   }
	   //Metodo toString
		public String toString(){
		       return "Persona[ id=" +id +", nombre= " +nombre +", edad=" +edad +", sexo=" +sexo +", peso= " +peso
			   +", altura=" +altura +"]";
	   }
	   /*Metodo  Id genera un numero aleatorio de 8 cifras, sera invocado cuando se construya el objeto y no 
	   sera visible en el exterior*/
	   private String generaID(){
		   String id="";
		   Random r = new Random();
		   for  (int i=0; i<8; i++)
			     id+=r.nextInt(10);
	             return id;
		   
	   }
	   //Metodos get y set
	   //ID
	   public String getid(){
	   return id;
	   }
	   // NOMBRE
	   public String getnombre(){
	   return nombre;
	   }
	   public void setnombre(String nombre){
	   this.nombre=nombre;
	   }
	   //EDAD
	   public int getedad(){
	   return edad;
	   }
	   public void setedad(int edad){
	   this.edad=edad;
	   }
	   //Sexo
	   public char getsexo(){
	   return sexo;
	   }
	   public void setsexo(char sexo){
	   this.sexo=sexo;
	   CompruebaSexo(sexo);
	   }
	   //Altura
	   public float getaltura(){
	   return altura;
	   }
	   public void setaltura(float altura){
	   this.altura=altura;
	   }
	   //Peso
	   public float getpeso(){
	   return peso;
	   }
	   public void setpeso(float peso){
	   this.peso=peso;
	   }
}