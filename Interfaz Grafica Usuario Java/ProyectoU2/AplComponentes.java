package ProyectoU2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AplComponentes extends JFrame implements ActionListener, KeyListener{
	private ComponenteCheck c1;
	private ComponenteCombo c2;
	
	public AplComponentes() {
		super("Componentes");
		HazInterfaz();
		HazEscuchas();
	}
	
	private void HazInterfaz() {
		setSize(700,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setLayout(new GridLayout(0,1));
		
		c1= new ComponenteCheck();
		c2= new ComponenteCombo();
		add(c1);
		add(c2);
		
		setVisible(true);
	}

	private void HazEscuchas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main (String []args) {
		new AplComponentes();
			
	}

}
