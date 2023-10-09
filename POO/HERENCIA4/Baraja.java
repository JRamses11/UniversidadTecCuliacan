package HERENCIA4;

//
//
//
import java.util.Random;
import java.util.Arrays;
public class Baraja{
     //Atributo
       private Carta [] baraja;
	   private int actual;
	 //Constructor
	   public Baraja(){
		   baraja= new Carta [40];
		   int c=0;
		   for (int i=0; i<=10; i++){
			   baraja[c]= new Espada(i>6 && i<9? (byte)(i+4):(byte)(i+1));
			   c++;
		   }
		   for (int i=0; i<=10; i++){
			   baraja[c]= new Basto(i>6 && i<9? (byte)(i+4):(byte)(i+1));
			   c++;
		   }
		   for (int i=0; i<=10; i++){
			   baraja[c]= new Obo(i>6 && i<9? (byte)(i+4):(byte)(i+1));
			   c++;
		   }
		   for (int i=0; i<=10; i++){
			   baraja[c]= new Copa(i>6 && i<9? (byte)(i+4):(byte)(i+1));
			   c++;
		   }   
	   }
		//Metodos operaciones
		public void barajar(){
			actual=0;
			int n1, n2;
			Random r= new Random();
			Carta tem;
			for (int i=0; i<200; i++){
				do{
					n1=r.nextInt(40);
					n2=r.nextInt(40);
				} while (n1==n2);
			    tem=baraja[n1];
				baraja[n1]=baraja[n2];
				baraja[n2]=tem;
			}
		}
		
		public Carta sigCarta() throws Exception{
			if(actual <40)
			   return baraja[actual++];
		        else 
					throw new Exception ("Cartas agotadas");
		}
		
		public int cartasDisponibles(){
			return actual-40;
		}
		
		public Carta[] darCartas (int numCartas) throws Exception{
			if (numCartas<cartasDisponibles()){
		    Carta [] tem =new Carta[numCartas];
			for (int i=0; i<tem.length; i++)
				tem[i]=baraja[actual++];
				return tem;
			}
			else 
				throw new Exception ("Cartas insuficientes");
			}
		
		public Carta[] cartasMonton(){
			Carta [] tem= new Carta [actual];
			for (int i=0; i<tem.length; i++)
				tem[i]=baraja[i];
			    return tem;
		}
		
		public Carta [] mostrarBaraja(){
			Carta [] tem= new Carta[actual-40];
			for (int i=0; i<tem.length; i++)
				tem[i]=baraja[actual+i];
			    return tem;
		}
		
        //Metodo to String
        public String toString(){
			return "Baraja \n" +Arrays.toString(baraja);
		}
}