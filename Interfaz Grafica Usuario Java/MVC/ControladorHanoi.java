package MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ControladorHanoi implements ActionListener{
	VistaHanoi vista;
	ModeloHanoi modelo;
	public ControladorHanoi(VistaHanoi vista,ModeloHanoi modelo) {
		this.vista=vista;
		this.modelo=modelo;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==vista.btnIniciar) {
			modelo.Hanoi('A','B','C',4);
			vista.Imprime(modelo.getMovtos());
		}
		
	}

}
