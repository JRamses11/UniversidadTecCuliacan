package MANEJO_ARCHIVOS;

//Jose Ramses Aldama Cazares
//8:00-9:00
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Biblioteca {
	private static String encabezado = "Biblioteca v2.0";
	private static String direccion= "C:\\\\Users\\\\ramch\\\\OneDrive\\\\Documentos\\\\2DO PROGRA OBJETOS/Biblioteca2.txt";
	//Metodo CreaLibro
	private static Libro creaLibro(String linea) throws StringIndexOutOfBoundsException, NumberFormatException{
 	    int Pipe1=linea.indexOf('|'); 
 	    int Pipe2=linea.indexOf('|', Pipe1 +1);
 	    int Pipe3=linea.indexOf('|', Pipe2 +1);
 	    int Pipe4=linea.indexOf('|', Pipe3 +1);
 	    int cve=Integer.parseInt(linea.substring(0, Pipe1));  
 	    String titu= linea.substring(Pipe1+1, Pipe2);
 	    String aut= linea.substring(Pipe2+1, Pipe3);
 	    String edit= linea.substring(Pipe3+1, Pipe4); 
 	    String ani= linea.substring(Pipe4 + 1); 
		   return new Libro (cve, titu, aut, edit, ani);
	}
	
	//Metodo para validaAgendaLibro 
	public static void ValidaLibro()  throws IOException{
      File f = new File(direccion); // f -carga el archivo 
      boolean creaArchivo = false;
      if (f.exists()) {
          FileReader fr;
              fr = new FileReader(f); // fr -crea el flujo hacia f
              BufferedReader br = new BufferedReader(fr); // br -permite la lectura
              String linea = br.readLine(); // -linea toma el valor de la primera linea
              if (!linea.equals(encabezado))
                  creaArchivo = true;
              fr.close(); // cierra el archivo
      } else
          creaArchivo = true;
      if (creaArchivo) {
          FileWriter fw;
          PrintWriter pw;
              fw = new FileWriter(f); // fw -crea el flujo hacia f
              pw = new PrintWriter(fw); // pw -permite la escritura en el archivo
              pw.println(encabezado); // se introduce el valor de i en el archivo
              fw.close(); // se cierra el flujo del archivo
      }
  }
	
	//Metodo MuestraListado
	public static void MuestraListado(){
		
      File f=new File(direccion); // f carga el archivo 
		FileReader fr;
		
		try {
	    fr= new FileReader(f); // fr --- crea el flujo hacia f
	    BufferedReader br = new BufferedReader(fr); // br---- permite la lectura
	    String linea=br.readLine(); // ----linea toma el valor de la primera linea
	    linea=br.readLine(); 
			while(linea != null) // mientras haya datos en el archivo
			{ 
				System.out.println(linea); 
				linea=br.readLine(); 
		    }
			System.out.println();
			fr.close();
		}catch (IOException e) {
		    System.out.println("Error: "+e.getMessage());// Si no se puede accede al archivo 
		}
   } 
	
	//Metodo RegresaListadoLibro
	public static ArrayList<Libro> RegresaListado() {
		File f=new File(direccion); // f carga el archivo
		FileReader fr; 
		ArrayList<Libro> listado = new ArrayList<>();// Aqui corregi 
		try { 
	    fr= new FileReader(f); // fr --- crea el flujo hacia f
	    BufferedReader br = new BufferedReader(fr); // br---- permite la lectura
	    String linea=br.readLine(); // ----linea toma el valor de la primera linea
	    linea=br.readLine();  
			while(linea != null) // mientras haya datos en el archivo
			{ 
				listado.add(creaLibro(linea)); 
				linea=br.readLine(); 
		    }
			fr.close();  
		}catch (IOException e) {
		    System.out.println("Error: "+e.getMessage());// Si no se puede accede al archivo 
		}
		return listado;
	}
	
	//Metodo Leelibro
	public static Libro LeeLibro (int Clave) throws IOException, NumberFormatException {
		int cve;
      File f=new File(direccion); // f carga el archivo
		FileReader fr;
	    fr= new FileReader(f); // fr --- crea el flujo hacia f
	    BufferedReader br = new BufferedReader(fr); // br---- permite la lectura
	    String linea=br.readLine(); // ----linea toma el valor de la primera linea 
			while(linea!=null) // mientras haya datos en el archivo
			{ 
				try {
				    cve = Integer.parseInt(linea.substring(0, linea.indexOf("|")));
					if(cve == Clave) {
						fr.close();
						return creaLibro(linea); 
					}
						
				  }catch (StringIndexOutOfBoundsException e) {
					}	
				linea=br.readLine();
		}
		fr.close(); 
		return null; 
   }
	
	//Metodo leeLibro
  public static Libro leeLibro (String titulo) throws IOException, NumberFormatException{ 
  	String nom;
      File f=new File(direccion); // f carga el archivo 
		FileReader fr;
	    fr=new FileReader(f); // fr --- crea el flujo hacia f
	    BufferedReader br=new BufferedReader(fr); // br---- permite la lectura
	    String linea=br.readLine(); // ----linea toma el valor de la primera linea
			while(linea!=null) // mientras haya datos en el archivo
			{ 
				try {
				    int Pipe2=linea.indexOf('|', linea.indexOf('|')+1);
				    nom=linea.substring(linea.indexOf('|')+1, Pipe2);
					if(nom.equals(titulo)) {
						fr.close();
						return creaLibro(linea);
					}
						
				  }catch (StringIndexOutOfBoundsException e) {
					}	
				linea=br.readLine(); 
		}
		fr.close();
		return null;  
  }
  
  //Metodo ActualizaLibro
  public static void Actualiza (Libro datos)  throws IOException, NumberFormatException{ 
  	File f = new File(direccion); // f -carga el archivo
      FileReader fr; 
      ArrayList<Libro> listado = new ArrayList<>();
      try {
          fr = new FileReader(f); // fr -crea el flujo hacia f
          BufferedReader br = new BufferedReader(fr); // br -permite la lectura
          String linea = br.readLine(); // -linea toma el valor de la primera linea
          linea = br.readLine();
          while (linea != null) // mientras haya datos en el archivo
          {
              listado.add(creaLibro(linea)); 
              linea = br.readLine();
          }
          fr.close();
      } catch (IOException e) {
          System.out.println("error: " + e.getMessage()); // si no se pudo accede al archivo
      }
      FileWriter fw;
      PrintWriter pw;
      fw = new FileWriter(f); // fw -crea el flujo hacia f
      pw = new PrintWriter(fw); // pw -permite la escritura en el archivo
      pw.println(encabezado);
      for (int i = 0; i < listado.size(); i++) {
          pw.println(datos.getClave() == listado.get(i).getClave() ? datos : listado.get(i)); 
      }
      fw.close(); // se cierra el flujo del archivo

  }
  
  //Metodo EliminaLibro
  public static ArrayList<Libro> Elimina (int clave) throws IOException{
  	File f = new File(direccion); // f -carga el archivo
      FileReader fr;
      ArrayList<Libro> listado = new ArrayList<>(); 
      
      try {  
          fr = new FileReader(f); // fr -crea el flujo hacia f
          BufferedReader br = new BufferedReader(fr); // br -permite la lectura
          String linea = br.readLine(); // -linea toma el valor de la primera linea
          linea = br.readLine();
          while (linea != null) // mientras haya datos en el archivo
          {
          	listado.add(creaLibro(linea)); 
              linea = br.readLine();
          }
          fr.close();  
      } catch (IOException e) {
          System.out.println("error: " + e.getMessage()); // si no se pudo accede al archivo
      }
      FileWriter fw;
      PrintWriter pw;
      fw = new FileWriter(f); // fw -crea el flujo hacia f
      pw = new PrintWriter(fw); // pw -permite la escritura en el archivo
      pw.println(encabezado);
      for (int i = 0; i < listado.size(); i++) {
          if(clave  !=listado.get(i).getClave()) {
          	pw.println(listado.get(i)); 
          } 
      }
      fw.close(); // se cierra el flujo del archivo
		return listado; 
  }   
  
  //Metodo agregaLibro
  public static void  agregaLibro (Libro datos) throws IOException{ 
  	File f = new File(direccion); // f -carga el archivo
		FileWriter fw; 
		PrintWriter pw; 
		
			fw = new FileWriter(f, true); // fw -crea el flujo hacia f
			pw = new PrintWriter(fw);// permite la escritura en el archivo
	        pw.println(datos); //Se introduce el valor de 1 en el archvivo
	  		fw.close(); // se cierra el flujo del archivp
		
  }
  
  //Metodo sigClaveLibro
  public static int sigClave() throws NumberFormatException, IOException{
      File f = new File(direccion); // f -carga el archivo
      FileReader fr;
      int clave = 0, claveMay=0;
      
          fr = new FileReader(f); // fr -crea el flujo hacia f
          BufferedReader br = new BufferedReader(fr); // br -permite la lectura
          String linea = br.readLine();// -linea toma el valor de la primera linea
          linea = br.readLine();
          while (linea != null){ // mientras haya datos en el archivo
          	
          	{
          	try{
                  clave = Integer.parseInt(linea.substring(0,linea.indexOf('|')));
                  if (clave > claveMay){
                      claveMay = clave; 
                  }
              }catch (IndexOutOfBoundsException e){
                
              }
              linea = br.readLine();
            }
          }
          
          fr.close(); // cierra el archivo
          return claveMay+1;
  }

	
	

}

