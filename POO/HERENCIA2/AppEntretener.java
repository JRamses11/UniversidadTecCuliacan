package HERENCIA2;

/*Implementa los anteriores métodos en las clases Videojuego y Serie. 
Ahora crea una aplicación ejecutable y realiza lo siguiente:
Crea dos arrays, uno de Series y otro de Videojuegos, de 5 posiciones cada uno.
Crea un objeto en cada posición del array, con los valores que desees, puedes usar distintos constructores.
Entrega algunos Videojuegos y Series con el método entregar().
Cuenta cuantos Series y Videojuegos hay entregados. Al contarlos, devuélvelos.
Por último, indica el Videojuego tiene más horas estimadas y la serie con mas temporadas.
Muestralos en pantalla con toda su información (usa el método toString()). */

public class AppEntretener{
       public static void main (String [] args){
		      //Objetos de 5 capacidad
	          Serie programa []= new Serie [5];
			  Videojuego consola []= new Videojuego [5];
			  int contVideo=0;
			  int contSerie=0;
			  //Valores a cada objetos
			  programa [0]= new Serie ("Flash", "Superheroes", "Geoff johns", 7);
			  programa [1]= new Serie ("Batman", "Superheroes", "Frank Cranston", 4);
			  programa [2]= new Serie ("Victorius", "Comedia", "Juan Ramos", 14);
			  programa [3]= new Serie ("Big time rush", "Comedia", "Julian Trump", 2);
			  programa [4]= new Serie ("Manuel de ned", "Comedia", "Robert de niro", 6);
			  
			  consola [0] = new Videojuego ("Spiderman", "Superheroes", "Insoniac", 20);
			  consola [1] = new Videojuego ("Arkham", "Terror", "Dc fimls", 15);
			  consola [2] = new Videojuego ("The last of us", "Aventura", "Sony", 30);
			  consola [3] = new Videojuego ("Detroit become human", "Mundo abierto", "Quantic dream", 18);
			  consola [4] = new Videojuego ("Days Gone", "Mundo abierto", "SIE Bend studio", 37);
			  //Entregar algunos objetos
			  consola[0].entregar();
			  consola[1].entregar();
			  programa [2].entregar();
			  programa [3].entregar();
			  
			 //Cuantos juegos y series hay entregados
			  for (int i=0; i<5; i++){
				  if (programa[i].isEntregado()){
					  contSerie++;
				      programa[i].devolver(); 
					  }
					  if (consola[i].isEntregado()){
						  contVideo++;
						  consola[i].devolver();
					  }
			  }
				System.out.println("Se entregaron " +contSerie +" Series");
				System.out.println("Se entregaron " +contVideo +" Videojuegos");
			  
			  
			 //Cual es el videojuego con mas horas y cual es la serie con mas temporadas
			 Serie mayor= programa[0];
			 Videojuego mayor2= consola[0];
			 
			  for (int i=0; i<5; i++){
				  if (mayor.getNumTem()<programa[i].getNumTem())
					  mayor=programa[i];
				  if (mayor2.getHoras()<consola[i].getHoras())
			          mayor2= consola[i];
					  
			  }
			  System.out.println (mayor);
			  System.out.println(mayor2);
			 //Utilzar el compareTo
			 if (programa[0].compareTo(programa[1]))
				 System.out.println ("Tienen el mismo numero de temporadas");
			     else
					 System.out.println ("No tienen el mismo numero de temporadas");
				 
			if (consola[0].compareTo(consola[1]))
				System.out.println ("Tienen el mismo numero de horas de juego");
			    else 
					System.out.println ("No tienen el mismo numero de horas de juego");
	   }
	   
}
