package UNIDAD1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LienzosMultiplesImagenes extends Canvas implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    String [] imagenes;
    int pos;
	Timer t;
	public LienzosMultiplesImagenes(String [] a) {
		imagenes=a;
		pos=0;
		t=new Timer(300,this);
		t.start();
	}
	public void paint(Graphics g) 	{
		g.drawImage(Rutinas.AjustarImagen(imagenes[pos%imagenes.length], this.getWidth(), this.getHeight()).getImage(), 0, 0,null);
	//	g.drawString("EJEMPLO DEL LLIENZO EN CANVAS", 20, 20);
	//	g.drawImage(Rutinas.AjustarImagen("avion.png", 50, 50).getImage(), 1+xAvion, this.getHeight()-55,null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		pos++;
		repaint();
		
	}


}
