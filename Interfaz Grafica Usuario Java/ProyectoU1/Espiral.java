package ProyectoU1;

/*
 * 20170585
 * ALDAMA CAZARES JOSE RAMSES
 * TOPICOS AVANZADOS DE PROGRAMACION 
 * CLEMENTE GARCIA GERARDO
 * 13:00-14:00
 */
public class Espiral implements Caracol {
       private int matriz [][];
       
       public Espiral(int a) {
             matriz= new int [a][a];
       }
       public Espiral() {
    	   this((int)(Math.random()*90+10));
    	  
       }
       
	@Override
	public void Formar() { 
        int inicioMatriz=0;
        int valor=1;
        int longitudMatriz=matriz.length;
		for (int i=0; i<=matriz.length/2;i++) {
		     for (int j=inicioMatriz; j<matriz.length-valor; j++) {
			     matriz[inicioMatriz][j]=valor;
		     }
		     for (int j=inicioMatriz; j<=matriz.length-valor; j++) {
			     matriz[j][longitudMatriz-valor]=valor;   
		     }
		     for (int j=matriz.length-valor;j>=inicioMatriz; j--) {
			     matriz[longitudMatriz-valor][j]=valor;
		     }
		     for (int j=matriz.length-valor;j>=inicioMatriz; j--) {
			     matriz[j][inicioMatriz]=valor;
		    }
		     inicioMatriz++;
		     valor++;	     
		}
	}
	@Override
	public void Imprimir() {
		for(int i=0;i<matriz.length; i++) {
			for (int j=0;j<matriz.length;j++) {
				System.out.print(matriz[i][j]+"");
			}
			System.out.println();
		}
				
	
	}
       
}
