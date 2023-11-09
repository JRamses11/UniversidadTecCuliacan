package UNIDAD2APL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import UNIDAD2.*;

public class AplComponentes extends JFrame implements ActionListener{
	
	private ComponenteV3 c1,c2,c3;
	private JButton btn;
	
	public AplComponentes() {
		super("Uso de componentes");
		HazInterfaz();
		HazEscuchas();
	}

	private void HazInterfaz() {
		setSize(500,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setLayout(new GridLayout(0,1,5,5));
		c1= new ComponenteV3();
		c2= new ComponenteV3();
		c3= new ComponenteV3();		
		add(c1);
		add(c2);
		add(c3);
		add(btn=new JButton("Boton"));
		
		setVisible(true);
		
	}

	private void HazEscuchas() {
		btn.addActionListener(this);
		
	}
	
    @Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn) {
			System.out.println(c1.getTxtNoControl());
			System.out.println(c1.getTxtNombre());
			System.out.println(c1.getTxtCarrera());
		}
		
	}
	public static void main(String[] args) {
		new AplComponentes();

	}

	

}
