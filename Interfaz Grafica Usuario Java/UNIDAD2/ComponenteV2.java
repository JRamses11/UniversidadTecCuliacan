package UNIDAD2;

import javax.swing.*;
import java.util.*;
import java.awt.GridLayout;
import java.awt.event.*;

public class ComponenteV2 extends JPanel implements ActionListener{
	private JLeeEntero txtNoControl;
	private JTextField txtNombre, txtCarrera;
	private JButton btnGrabar, btnLimpiar;
    private	JLabel lblNoControl, lblNombre, lblCarrera;
	
	public ComponenteV2() {
		HazInterfaz();
		HazEscuchas();
	}

	private void HazInterfaz() {
		setLayout(null);
		setSize(200,200);
		lblNoControl=new JLabel("NoControl");
		lblNombre= new JLabel ("Nombre");
		lblCarrera=new JLabel("Carrera");
		
		txtNoControl=new JLeeEntero(8);
		txtNombre= new JTextField();
		txtCarrera= new JTextField();
		
		lblNoControl.setBounds(15,20,60,20);
		lblNombre.setBounds(15,40,50,10);
		lblCarrera.setBounds(15,60,50,10);
		txtNoControl.setBounds(100,20,150,20);
		txtNombre.setBounds(100,40,150,20);
		txtCarrera.setBounds(100,60,150,20);
		
		add(lblNoControl);
        add(lblNombre);
        add(lblCarrera);
		add(txtNoControl);
		add(txtNombre);
		add(txtCarrera);
		
		txtNoControl= new JLeeEntero(8);
        txtNombre= new JTextField();
        txtCarrera= new JTextField();
        btnGrabar= new JButton("Grabar");
        btnLimpiar= new JButton("Limpiar");
        	
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