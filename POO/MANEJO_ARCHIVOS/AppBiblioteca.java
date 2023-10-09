package MANEJO_ARCHIVOS;

//Jose Ramses Aldama Cazares
//8:00-9:00
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class AppBiblioteca {
  static Scanner leer= new Scanner (System.in);
  public static void main (String [] args) {
	try {
  	Biblioteca.ValidaLibro();
  	}catch (IOException e) {
  		System.out.println ("Error 001: "+e.getMessage());
  	}
		int op;
		do {
			op = Menu();
			switch (op) {
			case 1:
		    Agrega();
		    break;
			case 2:
			Borra();
			break;
			case 3:
			Consulta();
			break;	
			case 4:
			Modifica();
			break;
			case 5:
			Listado();
			break;
			case 0:
				System.out.print("Seguro que deseas salir (S/N)?");
				char r = leer.next().toUpperCase().charAt(0);
				if (r != 'S')
					op = 100;
				break;
			default:
				System.out.println("Opcion no valida");
			}
		} while (op != 0);
		System.out.println("Bye...");
	
  }
  //MENU
  private static int Menu() {
	    System.out.println("* * * M E N U * * *");
	   	System.out.println("1.- Agregar Libro");
	   	System.out.println("2.- Borarr Libro");
	   	System.out.println("3.- Consultar Libro");
	  	System.out.println("4.- Modificar Libro");
	   	System.out.println("5.- Listado Libro");
	   	System.out.println ("0.- Salir");
	   	System.out.print("Opcion: ");
	   		return leer.nextInt();
	   	}
  //AGREGA
  private static void Agrega() {
		System.out.println ("Agregar nuevo Libro");
		leer.nextLine();
		System.out.print ("Titulo: ");
		String tit=leer.next();
		System.out.print("Autor: ");
		String aut=leer.next();
		System.out.print("Editorial: ");
		String edit=leer.next();
		leer.nextLine();
		System.out.print("Año ");
		String anio= leer.nextLine();
		try {
	         Biblioteca.agregaLibro(new Libro(Biblioteca.sigClave(), tit, aut, edit, anio));
		     System.out.println ("Libro agregado existosamente");
		}catch (NumberFormatException e) {
			System.out.println ("Archivo Corrupto");
		}catch(IOException e) {
			System.out.println ("Error al agregar "+e.getMessage());
		}
	}
  //BORRAR
  private static void Borra() {
		System.out.println("Eliminar Libro");
		char op = 'n';
		Libro datos = null;
		leer.nextLine();
		do {

			System.out.print("Nombre: ");
			String nom = leer.nextLine();
			try {
				datos = Biblioteca.leeLibro(nom);
				if (datos != null) {
					System.out.println("Clave: " + datos.getClave());
					System.out.println("Titulo: " + datos.getTitulo());
					System.out.println("Autor: " + datos.getAutor());
					System.out.println("Editorial: " + datos.getEditorial());
					System.out.println("Año: " + datos.getAnio());
					System.out.println();
					System.out.print("Este es el que deseas eliminar (s/n) (c para cancelar)? ");
					op = leer.next().toLowerCase().charAt(0);
					leer.nextLine();
				} else {
					System.out.println("Libro no encontrado");
					System.out.println();
					op = 'n';
				}
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		} while (op == 'n');
		if (op == 's') {
			try {
				Biblioteca.Elimina(datos.getClave());
				System.out.println("Libro eliminado exitosamente");
			} catch (NumberFormatException e) {
				System.out.println("Archivo corrupto");
			} catch (IOException e) {
				System.out.println("Error al agregar: " + e.getMessage());
			}
		}
	}
  //CONSULTAR
  private static void Consulta() {
		System.out.println ("Consulta un Libro");
		leer.nextLine();
		System.out.print ("Titulo: ");
		String nom=leer.nextLine();
		
		try {
		    Libro datos = Biblioteca.leeLibro(nom);
		    if(datos != null){
		    	System.out.println("Clave: "+datos.getClave());
		    	System.out.println("Titulo: "+datos.getTitulo());
		    	System.out.println("Autor: "+datos.getAutor());
		    	System.out.println("Editorial: "+datos.getEditorial());
		    	System.out.println("Año: "+datos.getAnio());
		    }else 
		    	System.out.println("Libro no encontrado");
		    	
		}catch (NumberFormatException e) {
	         System.out.println(e.getMessage());
	    }catch(IOException e) {
	    	System.out.println(e.getMessage());
	    
	    } 
	    System.out.println();
	}
  //MODFICAR
  private static void Modifica() {
      System.out.println("Modifica Libro");
      char op = 'n';
      Libro datos = null;
      leer.nextLine();
      do {

          System.out.print("Nombre: ");
          String nom = leer.nextLine();
          try {
              datos = Biblioteca.leeLibro(nom);
              if (datos != null) {
                  System.out.println("Clave: " + datos.getClave());
                  System.out.println("Titulo: " + datos.getTitulo());
                  System.out.println("Autor: " + datos.getAutor());
                  System.out.println("Editorial: " + datos.getEditorial());
                  System.out.println("Año: " + datos.getAnio());
                  System.out.println();
                  System.out.print("Este es el que deseas modificar (s/n) (c para cancelar)? ");
                  op = leer.next().toLowerCase().charAt(0);
                  leer.nextLine();
              } else {
                  System.out.println("Libro no encontrado");
                  System.out.println();
                  op = 'n';
              }
          } catch (NumberFormatException e) {
              System.out.println(e.getMessage());
          } catch (IOException e) {
              System.out.println(e.getMessage());
          }
      } while (op == 'n');
      if (op == 's') {
          // leer.nextLine();
          System.out.print("Titulo: ");
          String tit = leer.nextLine();
          datos.setTitulo(tit);
          System.out.print("Autor: ");
          String aut = leer.next();
          datos.setAutor(aut);
          System.out.print("Editorial: ");
          String edit = leer.next();
          datos.setEditorial(edit);
          leer.nextLine();
          System.out.print("Año: ");
          String anio = leer.nextLine();
          datos.setAnio(anio);
          try {
              Biblioteca.Actualiza(datos);
              System.out.println("Libro actualizado exitosamente");
          } catch (NumberFormatException e) {
              System.out.println("Archivo corrupto");
          } catch (IOException e) {
              System.out.println("Error al agregar: " + e.getMessage());
          }
        }
      }
  //IMPRIMIR LISTADO
  private static void Listado() {
		ArrayList<Libro> listado = Biblioteca.RegresaListado();
		Libro datos;
		System.out.println("Clave\tTitulo\t\tAutor\t\tEditorial\t\tAño");
		for(int i=0; i<listado.size(); i++) {
			datos = listado.get(i);
			if(datos != null){
		    	System.out.print(datos.getClave()+"\t");
		    	System.out.print(datos.getTitulo()+"\t\t");
		    	System.out.print(datos.getAutor()+"\t\t");
		    	System.out.print(datos.getEditorial()+"\t\t");
		    	System.out.println(datos.getAnio());
		    } 
			
		}
		 
	}

   
}
