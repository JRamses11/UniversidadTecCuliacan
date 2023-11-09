package UNIDAD2;

import javax.swing.*;
import java.util.*;
import java.awt.GridLayout;
import java.awt.event.*;

public class ComponenteV1 extends JPanel implements ActionListener{
	JLeeEntero txtNoControl;
	JTextField txtNombre, txtCarrera;
	JButton btnGrabar, btnLimpiar;
	
	public ComponenteV1() {
		HazInterfaz();
		HazEscuchas();
	}

	private void HazInterfaz() {
        txtNoControl= new JLeeEntero(8);
        txtNombre= new JTextField();
        txtCarrera= new JTextField();
        btnGrabar= new JButton("Grabar");
        btnLimpiar= new JButton("Limpiar");
        
        setLayout(new GridLayout(0,2,5,5));
		add(new JLabel("No control",JLabel.RIGHT));
		add(txtNoControl);
		add(new JLabel("Nombre",JLabel.RIGHT));
		add(txtNombre);
		add(new JLabel("Carrera",JLabel.RIGHT));
		add(txtCarrera);
		add(btnGrabar);
		add(btnLimpiar);
		
		setVisible(true);
		
	}

	public long getTxtNoControl() {
		return txtNoControl.getCantidad();
	}

	public void setTxtNoControl(JLeeEntero txtNoControl) {
		this.txtNoControl = txtNoControl;
	}

	public String getTxtNombre() {
		return txtNombre.getText();
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public String getTxtCarrera() {
		return txtCarrera.getText();
	}

	public void setTxtCarrera(JTextField txtCarrera) {
		this.txtCarrera = txtCarrera;
	}

	private void HazEscuchas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
