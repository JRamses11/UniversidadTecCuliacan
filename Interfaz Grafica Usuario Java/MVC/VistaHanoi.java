package MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class VistaHanoi extends JFrame{
	JButton btnIniciar;
	int noDiscos;
	JPanel panel;
	public VistaHanoi() {
		this(3);
	}
	public VistaHanoi(int noDiscos) {
		super("Torre de Hanoi");
		this.noDiscos=noDiscos;
		HazInterfaz();
	}
	private void HazInterfaz() {
		setSize(400,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		btnIniciar=new JButton("Iniciar");
		add(btnIniciar,BorderLayout.NORTH);
		panel=new JPanel();
		panel.setLayout(new GridLayout(0,3));

		
		
		setVisible(true);
		
		
	}
	
	public void setCntrolador(ControladorHanoi c) {
		btnIniciar.addActionListener(c);
	}
	public void Imprime(ArrayList<Movimiento> movimientos) {
		panel.add(new JLabel(""));
		panel.add(new JLabel("Total de Movtos: "+movimientos.size()));
		panel.add(new JLabel(""));
		
		
			
		panel.add(new JLabel("Torre origen",JLabel.CENTER));
		panel.add(new JLabel("Torre destino",JLabel.CENTER));
		panel.add(new JLabel("Disco",JLabel.CENTER));
		add(panel);
		for(Movimiento m : movimientos) {
			
			panel.add(new JLabel(m.getIni()+"",JLabel.CENTER));
			panel.add(new JLabel(m.getFin()+"",JLabel.CENTER));
			panel.add(new JLabel(m.getDisco()+"",JLabel.CENTER));
			
		}

		validate();
	}
}

