package ProyectoU1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * ALUMNO: ALDAMA CAZARES JOSE RAMSES
 * HORARIO: 13:00-14:00
 * MATERIA: TOPICOS AVANZADOS DE PROGRAMACION
 * DOCENTE: DOC. CLEMENTE GARCIA BERNAL
 * PARCIAL UNIDAD 1
 */

public class Parcial1Barco extends JFrame implements ActionListener {
	
	JButton barco1,barco2,barco3,barco4,barco5;
	JLabel [][] descarga;
	JPanel panel1, panel2;
	
	public Parcial1Barco() {
		HazInterfaz();
		HazEscuchas();
	}

	private void HazInterfaz() {
		setSize(800,600);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		panel1=new JPanel();
		panel2=new JPanel();
		
		panel1.setLayout(new GridLayout(0,9));
		panel1.add(new JLabel("  ",JLabel.CENTER));
		panel1.add(new JLabel("Ensenada",JLabel.CENTER));
		panel1.add(new JLabel("La Paz",JLabel.CENTER));
		panel1.add(new JLabel("Guaymas",JLabel.CENTER));
		panel1.add(new JLabel("Topolobampo",JLabel.CENTER));
		panel1.add(new JLabel("Mazatlan",JLabel.CENTER));
		panel1.add(new JLabel("Vallarta",JLabel.CENTER));
		panel1.add(new JLabel("Manzanillo",JLabel.CENTER));
		panel1.add(new JLabel("Lazaro",JLabel.CENTER));
		add(panel1,BorderLayout.NORTH);	
		
		
		panel2.setLayout(new GridLayout(0,9));	
		barco1= new JButton(Rutinas.AjustarImagen("1.png", this.getWidth(), this.getHeight()));
		barco2= new JButton(Rutinas.AjustarImagen("2.png", this.getWidth(), this.getHeight()));
		barco3= new JButton(Rutinas.AjustarImagen("3.png", this.getWidth(), this.getHeight()));
		barco4= new JButton(Rutinas.AjustarImagen("4.png", this.getWidth(), this.getHeight()));
		barco5= new JButton(Rutinas.AjustarImagen("5.png", this.getWidth(), this.getHeight()));
		panel2.add(barco1);
		panel2.add(barco2);
		panel2.add(barco3);
		panel2.add(barco4);
		panel2.add(barco5);
		descarga= new JLabel[10][4];
		for(int i=0;i<10;i++) {
		    	for(int j=0;j<descarga[i].length;j++) {
		    		descarga[i][j] = new JLabel("0");
		    		panel2.add(descarga[i][j]);			
		   	    	}
		    }	 
		
		
	    add(panel2,BorderLayout.CENTER);
		
		setVisible(true);
	}

	private void HazEscuchas() {
		
		
	}

	public static void main(String[] args) {
		new Parcial1Barco();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
