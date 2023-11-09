package MVC;

public class AplConvertidor {

	public static void main(String[] args) {
		
		Vista vista= new Vista();
		Modelo modelo= new Modelo();
		Controlador control= new Controlador(vista,modelo);

		vista.setControlador(control);
	}

}
