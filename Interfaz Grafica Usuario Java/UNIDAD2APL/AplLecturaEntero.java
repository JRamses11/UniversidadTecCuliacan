package UNIDAD2APL;
import javax.swing.*;

import UNIDAD1.Rutinas;
import java.awt.*;
import java.awt.event.*;
import UNIDAD2.*;
public class AplLecturaEntero extends JFrame implements ActionListener{

	JLeeEntero txtEdad,txtEstatura,txtPeso;
	JButton btnGrabar,btnLimpiar;
	
	public AplLecturaEntero() {
		super("prueba del componente entero");
		HazInterfaz();
		HazEscuchas();
	}
	public void HazInterfaz() {
		setSize(500,300);
		setLocationRelativeTo(null);
		txtEdad=new JLeeEntero();
		txtEstatura=new JLeeEntero(8);
		txtPeso=new JLeeEntero(10);
		
		setLayout(new GridLayout(0,2));
		add(new JLabel("EDAD",JLabel.RIGHT));
		add(txtEdad);
		add(new JLabel("estatura",JLabel.RIGHT));
		add(txtEstatura);
		add(new JLabel("peso",JLabel.RIGHT));
		
		add(txtPeso);
		btnGrabar=new JButton("Grabar");
		btnLimpiar=new JButton("Limpiar");
		add(btnGrabar);
		add(btnLimpiar);
		setVisible(true);
	}
	public void HazEscuchas() {
		txtEdad.addActionListener(this);
		txtEstatura.addActionListener(this);
		txtPeso.addActionListener(this);
		
		btnGrabar.addActionListener(this);
		btnLimpiar.addActionListener(this);
		
		
	}
	private void Valida(ActionEvent e) {
		if(e.getSource()==txtEdad) {
		
			long valor=txtEdad.getCantidad();
			if(valor<18 || valor>60) {
				Rutinas.Mensaje("Rango no válido de edades");
				return;
			}
			txtEstatura.requestFocus();
			return;
		}
		if(e.getSource()==txtEstatura) {
			
			long valor=txtEstatura.getCantidad();
			if(valor<170 || valor>200) {
				Rutinas.Mensaje("Rango no válido de estatura, válido(170-200)");
				return;
			}
			txtPeso.requestFocus();
			return;
		}	
		
		if(e.getSource()==txtPeso) {
	
			long valor=txtPeso.getCantidad();
			if(valor<70 || valor>100) {
				Rutinas.Mensaje("Rango no válido de peso, válido(70-100)");
				return;
			}
			btnGrabar.requestFocus();			
			
			return;
		}
	}
	public static void main(String[] args) {
		new AplLecturaEntero();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JLeeEntero ) {
			Valida(e);
			return;
		}

		if(e.getSource()==btnLimpiar) {
			txtEdad.setText("");
			txtEstatura.setText("");
			txtPeso.setText("");
			txtEdad.requestFocus();
			return;
			
		}
		if(e.getSource()==btnGrabar) {
			Valida(e);
		}
	}

}
