package UNIDAD1;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class TamanioBoton extends JFrame {
	 private JButton boton;
	 public TamanioBoton() 	 {
	   add(new JLabel("Esta boton aumenta 50 pixeles por dimensión"));
	    setLayout(new FlowLayout());
	    boton = new JButton("Boton");
        boton. setPreferredSize(new Dimension(80,85));

	    add(boton);
	    setSize(350, 500);
	    setLocationRelativeTo(null);
	    boton.addActionListener(new ActionListener()
	      {   public void actionPerformed(ActionEvent evt)
	          {  //JButton boton = (JButton)evt.getSource();
		    boton.setSize(boton.getWidth() + 50, boton.getHeight() + 50);
		    //repaint();
	          }
	       });

	    
	    
	    setVisible(true);
	 }
	 public static void main(String[] args)
	 {
	    TamanioBoton demo = new TamanioBoton();
	    demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 }
}
