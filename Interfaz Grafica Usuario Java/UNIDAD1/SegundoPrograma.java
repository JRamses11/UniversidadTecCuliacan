package UNIDAD1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SegundoPrograma extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public SegundoPrograma() {
		HazInterfaz();
		HazEscuchas();
	}
	
    private void HazInterfaz() {
		setSize(400,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		 * setLayout(new FlowLayout(FlowLayout.LEFT));
		 * for (int i=0;i<20;i++){
		 *     add(new JButton("Btn"+i));
		 *     }
		 */
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(0,10));
		for (int i=0;i<100;i++)
			p.add(new JButton("Btn1"+i));
		    JScrollPane s= new JScrollPane(p);
		    add(s);
		    setVisible(true);
	}

	private void HazEscuchas() {
		
	}
    
	public static void main(String []args) {
		new SegundoPrograma();
	}
	
}
