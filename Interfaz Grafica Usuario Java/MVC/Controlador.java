package MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Controlador implements ActionListener{
	private Vista vista;
	private Modelo modelo;
	
	public Controlador(Vista vista, Modelo modelo) {
		this.modelo=modelo;
		this.vista=vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vista.btnPesos) {
			long cantidad=vista.DameCantidad();
			float dolares=modelo.Dolares(cantidad);
			vista.setResultado(dolares);
			
			return;
		}
		
		if(e.getSource()==vista.btnDolares) {
			vista.setResultado(modelo.Pesos(vista.DameCantidad()));
			return;
		}
		
	}

}
