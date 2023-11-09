package MVC;

public class Modelo {
	private float cotizacion;
	
	public Modelo() {
		this(20.00f);
		
	}
	
	public Modelo(float cotizacion) {
		this.cotizacion=cotizacion;
	}
	
	public float Dolares(long importe) {
		return importe/cotizacion;
	}
	
	public float Pesos(long importe) {
		return importe*cotizacion;
	}

}
