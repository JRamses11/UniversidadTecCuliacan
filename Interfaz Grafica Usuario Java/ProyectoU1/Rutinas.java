package ProyectoU1;

import java.awt.Image;
import java.util.*;
import javax.swing.*;
public class Rutinas {
	static Random r=new Random();
	
	static String []VN ={"Zoila","Daniel","Yessenia","Luis","Anastacia","Plutarco","Alicia","Maria","Sofia","Antonio","Nereida","Carolina",
			"Rebeca","Javier","Luis"};
	static String [] VA={"Garcia","Lopez","Perez","Urias","Mendoza","Coppel","Diaz"};
	static boolean [] Sexo={false,true,false,true,false,true,false,false,false,true,false,false,false,true,true};	

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
		//int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro?");
	}


	
	public static String nextNombre(int Numero){
		String Nom="",NomTra="";
		int Pos;
		boolean Genero=true;

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
			Nom+=VA[nextInt(VA.length)]+" ";
		}
		return Nom.trim();
	} 
	public static int nextInt(int numero) {
		return r.nextInt(numero);
	}
	public static int nextInt(int numeroIni, int numeroFin) {
		return r.nextInt(numeroFin-numeroIni+1)+numeroIni;
	}
}
