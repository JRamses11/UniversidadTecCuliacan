package UNIDAD1;
import javax.swing.*;
import javax.swing.event.AncestorListener;

import java.awt.*;
import java.awt.event.*;

public class MyLienzo extends Canvas implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nomImagen;
	private int col;
	Timer t;
	boolean bandImagen;
	
	public MyLienzo() {
		this("Cruz azul.png");
	}
	
	public MyLienzo(String nomImagen) {
		this.nomImagen=nomImagen;
		col=0;
		t=new Timer(300,this);
		t.start();
		bandImagen=true;
	}

	public void paint(Graphics g) {
		g.drawImage(Rutinas.AjustarImagen(nomImagen, this.getWidth(), this.getHeight()).getImage(),0,0,null);
	//	g.drawString("EJMEPLO DEL LIENZO EN CANVAS",20,20);
		g.drawImage(Rutinas.AjustarImagen("Cruz azul.png", 50, 50).getImage(),1+col,this.getHeight()-55,null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (col<0 || col+80>this.getWidth())
			bandImagen=!bandImagen;
		if(bandImagen)
		   col+=10;
		else
			col-=10;
		
		repaint();
		
	}
	
}
