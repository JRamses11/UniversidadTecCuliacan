package UNIDAD1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppLienzos extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MyLienzo l1,l2,l3,l4;
	
	public AppLienzos() {
		super("Manejo de multiples lienzos");
		HazInterfaz();
		HazEscuchas();
	}
	
	private void HazInterfaz() {
		setSize(500,500);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		l1= new MyLienzo("Cruz azul.png");
		l2= new MyLienzo("Cruz azul.png");
		l3= new MyLienzo("Cruz azul.png");
		l4= new MyLienzo("Cruz azul.png");
		
		setLayout(new GridLayout(0,2));
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		
		String [] arreglo=new String [] {"Leon.jfif","Puebla.jfif","Chivas.jfif"};
		LienzosMultiplesImagenes l5=new LienzosMultiplesImagenes(arreglo);
		add(l5);
		
		setVisible(true);
		
	}

	private void HazEscuchas() {
		
	}

	public static void main(String[] args) {
		new AppLienzos();

	}

}
