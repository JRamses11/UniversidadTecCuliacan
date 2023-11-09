package MVC;


public class AplHanoi {
	public static void main(String [] a) {
		System.out.println("________________");
		VistaHanoi vista = new VistaHanoi();
		ModeloHanoi modelo=new ModeloHanoi(3);
		ControladorHanoi controlador=new ControladorHanoi(vista,modelo);
		vista.setCntrolador(controlador);
		
		
	}

}
