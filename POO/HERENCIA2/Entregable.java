package HERENCIA2;

/*interfaz llamada Entregable con los siguientes m�todos:
entregar(): cambia el atributo prestado a true.
devolver(): cambia el atributo prestado a false.
isEntregado(): devuelve el estado del atributo prestado.
M�todo compareTo (Object a), compara las horas estimadas en los videojuegos 
y en las series el numero de temporadas. Como par�metro que tenga un objeto,
no es necesario que implementes la interfaz Comparable. Recuerda el uso de los casting de objetos. */

public interface Entregable{
	public void entregar();
	
	public void devolver();
	
	public boolean isEntregado();
	
	public boolean compareTo (Object a);
	

}
 