package UNIDAD1;

import javax.swing.*;
import java.awt.*;

public class PrimerPrograma{
	static private JButton btn1,btn2,btn3,btn4,btn5;
	public static void main (String []args) {
		JFrame panel= new JFrame("INSTITUTO TECNOLOGICO DE CULIACAN");
		panel.setSize(500,200);
		panel.setLocationRelativeTo(null);
		
		btn1= new JButton("BOTON 1");
		btn2= new JButton("BOTON 2");
		btn3= new JButton("BOTON 3");
		btn4= new JButton("BOTON 4");
		btn5= new JButton("BOTON 5");
		panel.add(btn1);
		panel.add(btn2,BorderLayout.NORTH);
		panel.add(btn3,BorderLayout.SOUTH);
		panel.add(btn4,BorderLayout.EAST);
		panel.add(btn5,BorderLayout.WEST);
		
		panel.setVisible(true);
	}
}
