package CLASE;

//Esta clase utiliza la clase persona
//Jose Ramses Aldama Cazares
//8:00-9:00

public class AppPersonas{
     public static void main (String [] args){
	          Personas p01= new Personas ("80", "Ramses", (byte) 9, 'H', "Cornoccia");
			  Personas p02= new Personas();
			  
			  System.out.println ("Id: " +p01.getid());
			  System.out.println ("Nombre: " +p01.getnombre());
			  System.out.println ("Edad : " +p01.getedad());
			  
			  p01.setid("01");
			  p01.setnombre("Ramon");
			  p01.setedad ((byte) 10);
			  
			  System.out.println ("Id: " +p01.getid());
			  System.out.println ("Nombre: " +p01.getnombre());
			  System.out.println ("Edad: " +p01.getedad());
			  
			  System.out.println ("Id: " +p02.getid());
			  System.out.println ("Nombre: " +p02.getnombre());
			  System.out.println ("Edad: " +p02.getedad());
			  
			 }
}
			
