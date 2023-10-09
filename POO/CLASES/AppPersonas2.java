package CLASE;

//Usamos la clase Persona2
//Jose Ramses Aldama Cazares
//8:00-9:00

import java.util.Scanner;
public class AppPersonas2{
     static Scanner lectura= new Scanner (System.in);
     public static void main(String [] args){
	          String nombre;
			  int edades;
			  char sexo;
			  float peso, altura;
			  int num;
			  System.out.print ("Cuantas personas desea capturar " );
			  num=lectura.nextInt();
			  Personas2 [] grupo= new Personas2 [num];
			  
			  for (int i=0; i<num; i++){
			  System.out.print ("Nombre: " +(i+1)+" ");
			  nombre=lectura.nextLine();
			  
			  System.out.print ("Edad: " );
			  edades=lectura.nextInt();
			  
			  System.out.print ("Sexo: ");
			  sexo=lectura.next().charAt(0);
			  
			  System.out.print ("Altura: ");
			  altura=lectura.nextFloat();
			  
			  System.out.print ("Peso: ");
			  peso=lectura.nextFloat();
			  
			  grupo[i]=new Personas2(nombre,edades,sexo,peso,altura);
			  }
			  for (int i=0; i<num; i++){
			      System.out.println (grupo[i]);
				  System.out.println (CalculaPeso(grupo[i]));
				  System.out.println (EsMayorEdad(grupo[i]));
			  }
	   }// fin del main
			  
			  public static String EsMayorEdad(Personas2 p){
			       return p.getnombre() + (p.MayorEdad()? " Es mayor de edad" : " Es menor de edad");
			  }
			  
			  public static String CalculaPeso(Personas2 p){
			         switch (p.CalculaIMC()){
					        case Personas2.BAJOPESO:
							     return p.getnombre() +" Esta por debajo de su peso ideal";
						    case Personas2.ENPESO:
							     return p.getnombre() + " Esta en su peso idea";
						    default:
							     return p.getnombre() + " Esta por encima de su peso ideal";
			        }
			}
		
}