package METODOS;

import java.awt.Image;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class Ejercicios2 {

	static Random R=new Random();
	static String []VN ={"Daniel","Yessenia","Luis","Anastacia","Plutarco","Alicia","Maria","Sofia","Antonio","Nereida","Carolina",
		"Rebeca","Javier","Luis"};
	static String [] VA={"Garcia","Lopez","Perez","Urias","Mendoza","Coppel","Diaz"};
	static boolean [] Sexo={true,false,true,false,true,false,false,false,true,false,false,
		false,true,true};	
	
	public static String PonBlancos(String Texto,int Tamaño){
		while (Texto.length() <Tamaño)
			Texto+=" ";
		return Texto;
	}
	public static String PonCeros(int Valor, int Tamaño){
		String Texto=Valor+"";
		while (Texto.length()<Tamaño)
			Texto="0"+Texto;
		return Texto;
	}
	public static int nextInt(int Valor){
		return R.nextInt(Valor);
	}
	public static int nextInt(int Ini,int Fin){
		return R.nextInt( Fin-Ini+1  )+Ini;
	}
	public static String nextNombre(int Numero){
		String Nom="",NomTra="";
		int Pos;
		boolean Genero=true;;

		for(int i=0;i<Numero;i++){
			Pos=nextInt(VN.length);

			NomTra=VN[Pos]+" ";

			if (i==0){
				Genero=Sexo[Pos];
			}

			if( Genero != Sexo[Pos]  || i>0 && Nom.indexOf(NomTra)>-1    ){
				i--;
				continue;
			}	

			Nom+=NomTra;

		}
		for(byte i=0;i<2;i++){
//			Nom+=VA[nextInt(VA.length)]+" ";
		}
		return Nom.trim();
	} 
	public static String nextEstacion() {
		String [] estaciones= {"primavera","verano","otoño","invierno"};
		return estaciones[R.nextInt(estaciones.length)];
	}
	public static String nextColor() {
		String [] color= {"azul","rojo","amarillo","verde","gris","negro","cafe","violeta","purpura"};
		return color[R.nextInt(color.length)];
	}
	// 773 123 123 123 123
		static public String ConvierteCantidad(String cantidad) {
			// llegó en Cantidad 123456 y el método debe regresar (ciento veintitres mis cuatrocentos cincuenta y seis).
	        String [] unidades= {"un","dos","tres","cuatro","cinco","seis","siete","ocho","nueve","diez","once",
	        		"doce","trece","catorce","quince","dieciseis","diesisiete","diesiocho","diesinueve","veinte",
	        		"veintiun","veintidos","veintitres","veinticuatro","veinticinco","veintiseis","veintisiete",
	        		"veintiocho","veintinueve"};
	        String [] decenas= {"diez","veinte","treinta","cuarenta","cincuenta","sesenta","setenta","ochenta","noventa"};
	        String [] cientos= {"ciento","doscientos","trecientos","cuatrocientos","quinientos","seiscientos","setecientos",
	        		"ochocientos","novecientos"};
	        
	       //  090 456 789 // cuatrocientos cincuenta y seies mil ciento veintitres millones  cuatrocientos cincurnta seis mil seteciento 0ch
	        if( cantidad.length() <15) {
	        	while(cantidad.length()<15)
	        		cantidad="0"+cantidad;
	        }
	        else {
	        	if(cantidad.length()>15)
	        		return "no puede convertir mas de 15 digitos";
	        }
	        int parte;
	        String resultado="",enPalabras="";
	        for(int i=0 ; i<cantidad.length(); i+=3) {
	        	parte=Integer.parseInt(cantidad.substring(i,i+3));
	        	if(parte==0)
	        		continue;
	 
	        	if(parte<30)
	        		resultado=unidades[parte-1];
	        	else {
	        		int parte2=Integer.parseInt(cantidad.substring(i+1,i+3));
	        		if(parte2<30) {
	        			if(parte2>0)
	        			   resultado=unidades[parte2-1];
	        		    int c=(int) (parte/100);
	        		    if(c !=0)
	        				resultado=(resultado.length()==0 && c==1? "cien":cientos[c-1])+" "+resultado+" ";
	        		}  
	        		else {
	        			int d=(int)(parte2/10);
	        			int u=(int)(parte2%10);
	        			int c=(int) (parte/100);
	   
	        			if (u!=0)
	        				resultado=unidades[u-1];
	        			if(d!=0)
	        				resultado=decenas[d-1]+(resultado.length()>0 ? " y ":"")+resultado;
	        			if(c !=0)
	        				resultado=cientos[c-1]+" "+resultado+" ";
	        		}

	        	} 
	        	switch (i) {
	        	case 0: resultado=resultado+"billones";break;
	        	case 3: resultado=resultado+"mil";break;
	        	case 6: resultado=resultado+"millones";break;
	        	case 9: resultado=resultado+"mil";break;
	        	}
	        	enPalabras=enPalabras+" "+resultado;
	        	resultado="";

	        }
	        
	        return enPalabras;
		
		}
	

		public static String EditaComas(long cantidad) {
			// EEJMPLO RECIBE 123456789 DEBE REGRESA 123,456,789
			String texto=cantidad+"";
			char car;
			String edicion="";
			int cont=0;
			for(int i=texto.length()-1 ; i>=0 ; i--) {
				cont++;
				car=texto.charAt(i);
				if(cont ==4 ) {
				   edicion=car+","+edicion;
				   cont=1;
				}  
				else
					edicion=car+edicion;
			}
			return edicion;
		}
		
		public static ImageIcon AjustarImagen(String ico,int Ancho,int Alto)
		{
			ImageIcon tmpIconAux = new ImageIcon(ico);
			//Escalar Imagen
			ImageIcon tmpIcon = new ImageIcon(tmpIconAux.getImage().getScaledInstance(Ancho,
					Alto, Image.SCALE_SMOOTH));//SCALE_DEFAULT
			return tmpIcon;
		}

		public static void Mensaje(String texto) {
			JOptionPane.showMessageDialog(null,texto, " ******** ",JOptionPane.ERROR_MESSAGE);
		}
}

