package ProyectoU3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IComensales extends JFrame implements ActionListener{
	JLabel centro;
    ImageIcon imagen;
    
	public IComensales(){
		super("Filosofos");
		HazInterfaz();
		HazEscuchas();
	}
	
	private void HazInterfaz() {	
		setSize(800,600);
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
        imagen=new ImageIcon("filosofo.png");
        JLabel centro= new JLabel(imagen);
        centro.setBounds(0,0,(770),(570));
        add(centro);
        
        
        setVisible(true);
		
	}

	private void HazEscuchas() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String [] args) {
		new IComensales();
	}


}
