package MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import UNIDAD2.*;

public class Vista extends JFrame{
	JButton btnDolares, btnPesos;
	JLeeEntero cantidad;
	JLabel resultado;
	
	public Vista() {
		super("Conversion de pesos-dolares-pedos");
		HazInterfaz();
		HazEscuchas();
	}

	private void HazInterfaz() {
		setSize(400,250);
		this.setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    this.setResizable(false);
	    
	    setLayout(new GridLayout(0,2,5,5));
	    
	    btnDolares= new JButton("Dolares");
	    btnPesos= new JButton("Pesos");
	    cantidad= new JLeeEntero();
	    resultado=new JLabel("");
	    
	    add(new JLabel("Cantidad",JLabel.RIGHT));
	    add(cantidad);
	    add(btnDolares);
	    add(btnPesos);
	    add(new JLabel("Entregar : "), JLabel.RIGHT);
	    add(resultado);
	    
	    setVisible(true);
	}

	public long DameCantidad() {
		return cantidad.getCantidad();
		
	}
	
	public void setResultado(float importe) {
		// long entero= (long) importe;
		//String res=Rutinas.Editacomas(entero);
		//
		resultado.setText(importe+"");
		
	}
	
	public void setControlador(Controlador c) {
		btnDolares.addActionListener(c);
		btnPesos.addActionListener(c);
		
	}
	
	private void HazEscuchas() {
		// TODO Auto-generated method stub
		
	}

}
