package MANEJO_ARCHIVOS;

import java.io.*;
import java.util.ArrayList;

public class Agenda {
	
	public static void ValidaAgenda()  throws IOException{
        File f = new File("C:\\\\Users\\\\ramch\\\\OneDrive\\\\Documentos\\\\2DO PROGRA OBJETOS/Agenda.txt"); // f -carga el archivo
        boolean creaArchivo = false;
        if (f.exists()) {
            FileReader fr;
                fr = new FileReader(f); // fr -crea el flujo hacia f
                BufferedReader br = new BufferedReader(fr); // br -permite la lectura
                String linea = br.readLine(); // -linea toma el valor de la primera linea
                if (!linea.equals("Agenda v1.0"))
                    creaArchivo = true;
                fr.close(); // cierra el archivo
        } else
            creaArchivo = true;
        if (creaArchivo) {
            FileWriter fw;
            PrintWriter pw;
                fw = new FileWriter(f); // fw -crea el flujo hacia f
                pw = new PrintWriter(fw); // pw -permite la escritura en el archivo
                pw.println("Agenda v1.0"); // se introduce el valor de i en el archivo
                fw.close(); // se cierra el flujo del archivo
        }
    }
	
	public static void MuestraListado(){
		
        File f=new File("C:\\\\Users\\\\ramch\\\\OneDrive\\\\Documentos\\\\2DO PROGRA OBJETOS/Agenda.txt"); // f carga el archivo
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
	
	public static ArrayList<Contacto> RegresaListado() {
		File f=new File("C:\\\\Users\\\\ramch\\\\OneDrive\\\\Documentos\\\\2DO PROGRA OBJETOS/Agenda.txt"); // f carga el archivo
 		FileReader fr;
 		ArrayList<Contacto> listado = new ArrayList<>();
 		try {
 	    fr= new FileReader(f); // fr --- crea el flujo hacia f
 	    BufferedReader br = new BufferedReader(fr); // br---- permite la lectura
 	    String linea=br.readLine(); // ----linea toma el valor de la primera linea
 	    linea=br.readLine();  
 			while(linea != null) // mientras haya datos en el archivo
 			{ 
 				listado.add(creaContacto(linea)); 
 				linea=br.readLine(); 
 		    }
 			System.out.println();
 			fr.close();
 		}catch (IOException e) {
 		    System.out.println("Error: "+e.getMessage());// Si no se puede accede al archivo 
 		}
 		return listado;
	}
	
	public static Contacto Lee (int Clave) throws IOException, NumberFormatException {
		int cve;
        File f=new File("C:\\\\Users\\\\ramch\\\\OneDrive\\\\Documentos\\\\2DO PROGRA OBJETOS/Agenda.txt"); // f carga el archivo
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
 						return creaContacto(linea);
 					}
 						
 				  }catch (StringIndexOutOfBoundsException e) {
 					}	
 				linea=br.readLine();
 		}
 		fr.close(); 
 		return null; 
     }
	
	public static Contacto lee (String nombre) throws IOException, NumberFormatException{
    	String nom;
        File f=new File("C:\\\\Users\\\\ramch\\\\OneDrive\\\\Documentos\\\\2DO PROGRA OBJETOS/Agenda.txt"); // f carga el archivo
 		FileReader fr;
 	    fr=new FileReader(f); // fr --- crea el flujo hacia f
 	    BufferedReader br=new BufferedReader(fr); // br---- permite la lectura
 	    String linea=br.readLine(); // ----linea toma el valor de la primera linea
 			while(linea!=null) // mientras haya datos en el archivo
 			{ 
 				try {
 				    int Pipe2=linea.indexOf('|', linea.indexOf('|')+1);
 				    nom=linea.substring(linea.indexOf('|')+1, Pipe2);
 					if(nom.equals(nombre)) {
 						fr.close();
 						return creaContacto(linea);
 					}
 						
 				  }catch (StringIndexOutOfBoundsException e) {
 					}	
 				linea=br.readLine();
 		}
 		fr.close();
 		return null;  
    }
    
    private static Contacto creaContacto(String linea) throws StringIndexOutOfBoundsException, NumberFormatException {
   	    int Pipe1=linea.indexOf('|'); 
   	    int Pipe2=linea.indexOf('|', Pipe1 +1);
   	    int Pipe3=linea.indexOf('|', Pipe2 +1);
   	    int Pipe4=linea.indexOf('|', Pipe3 +1);
   	    int cve=Integer.parseInt(linea.substring(0, Pipe1));
   	    String nom= linea.substring(Pipe1+1, Pipe2);
   	    String cel= linea.substring(Pipe2+1, Pipe3);
   	    String mail= linea.substring(Pipe3+1, Pipe4);
   	    String dir= linea.substring(Pipe4+1);
		   return new Contacto (cve, nom, cel, mail, dir);
	}

    public static void Actualiza (Contacto datos)  throws IOException, NumberFormatException{ 
    	File f = new File("C:\\\\Users\\\\ramch\\\\OneDrive\\\\Documentos\\\\2DO PROGRA OBJETOS/Agenda.txt"); // f -carga el archivo
        FileReader fr;
        ArrayList<Contacto> listado = new ArrayList<>();
        try {
            fr = new FileReader(f); // fr -crea el flujo hacia f
            BufferedReader br = new BufferedReader(fr); // br -permite la lectura
            String linea = br.readLine(); // -linea toma el valor de la primera linea
            linea = br.readLine();
            while (linea != null) // mientras haya datos en el archivo
            {
                listado.add(creaContacto(linea)); 
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
        pw.println("Agenda v1.0");
        for (int i = 0; i < listado.size(); i++) {
            pw.println(datos.getClave() == listado.get(i).getClave() ? datos : listado.get(i)); 
        }
        fw.close(); // se cierra el flujo del archivo

    }

    public static ArrayList<Contacto> Elimina (int clave) throws IOException{
    	File f = new File("C:\\\\Users\\\\ramch\\\\OneDrive\\\\Documentos\\\\2DO PROGRA OBJETOS/Agenda.txt"); // f -carga el archivo
        FileReader fr;
        ArrayList<Contacto> listado = new ArrayList<>(); 
        
        try { 
            fr = new FileReader(f); // fr -crea el flujo hacia f
            BufferedReader br = new BufferedReader(fr); // br -permite la lectura
            String linea = br.readLine(); // -linea toma el valor de la primera linea
            linea = br.readLine();
           // String size = linea; 
            while (linea != null) // mientras haya datos en el archivo
            {
            	listado.add(creaContacto(linea));  
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
        pw.println("Agenda v1.0");
        for (int i = 0; i < listado.size(); i++) {
            if(clave  !=listado.get(i).getClave()) {
            	pw.println(listado.get(i)); 
            } 
        }
        fw.close(); // se cierra el flujo del archivo
		return listado;
    }   
    
    public static void Agrega (Contacto datos) throws IOException{
    	File f = new File("C:\\\\Users\\\\ramch\\\\OneDrive\\\\Documentos\\\\2DO PROGRA OBJETOS/Agenda.txt"); // f -carga el archivo
		FileWriter fw;
		PrintWriter pw;
		
			   fw = new FileWriter(f, true); // fw -crea el flujo hacia f
			   pw = new PrintWriter(fw);// permite la escritura en el archivo
	           pw.println(datos); //Se introduce el valor de 1 en el archvivo
	           fw.close(); //Se cierra el flujo de archivos
	  		   for(int i=1;i<=20;i++)
	  		   {
	  			   pw.println(i); // se introduce el valor de i en el archivo
	  		   }
	  		   fw.close(); // se cierra el flujo del archivp
		
    }
    
    public static int sigClave() throws NumberFormatException, IOException{
        File f = new File("C:\\\\Users\\\\ramch\\\\OneDrive\\\\Documentos\\\\2DO PROGRA OBJETOS/Agenda.txt"); // f -carga el archivo
        FileReader fr;
        int clave = 0, claveMay=0;
        
            fr = new FileReader(f); // fr -crea el flujo hacia f
            BufferedReader br = new BufferedReader(fr); // br -permite la lectura
            String linea = br.readLine(); // -linea toma el valor de la primera linea
            while (linea != null){ // mientras haya datos en el archivo
            	
            	{
            	try{
                    clave = Integer.parseInt(linea.substring(0,linea.indexOf('|')));
                    if (clave > claveMay){
                        claveMay = clave; 
                    }
                }catch (IndexOutOfBoundsException e){
                    System.out.println("ARCHIVO CORRUPTO");
                }
                linea = br.readLine();
              }
            }
            
            fr.close(); // cierra el archivo
            return claveMay+1;
    }

}

