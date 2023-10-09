package HERENCIA3;

//Clase ejecutable
import java.util.Random;
public class AppFuncion{
  public static void main (String [] args){
	       Random r= new Random();
		   Cine cine= new Cine(new Peliculas("It", 90, r.nextInt(18)+5, "Juan Perez"), r.nextInt(131)+20);
		   System.out.println (cine);
		   
		   for (int i=1; i<=20; i++){
			   int fila= r.nextInt(8);
			   int col= r.nextInt(9);
			   if (cine.getLugar(fila, col)==null){
				   Espectador espec= new Espectador("Espectador " +i, r.nextInt(101)+5, r.nextInt(600)+50);
				   
				   if (espec.getEdad()>=cine.getPeli().getEdadMin() && espec.getDinero()>=cine.getEntrada()){
					   cine.setLugar(fila, col, new Asiento(espec));
				   } else{
				   System.out.println ("Espectador rechazado: " +espec); 
			       i--;
			     }
			   } else 
			       i--;
	     }
		   for (int f=1; f<=8; f++){
			   for (int c=1; c<9; c++){
				   System.out.print (cine.getLugar(f,c) !=null?"0\t": "X\t");
			   }
			   System.out.println();
		   }
		}
	}

