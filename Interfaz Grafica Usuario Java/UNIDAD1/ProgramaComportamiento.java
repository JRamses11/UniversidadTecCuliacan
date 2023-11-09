package UNIDAD1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProgramaComportamiento extends JFrame implements ActionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	private JButton btn,btnNorte,btnSur;
	Color original;
	
	public ProgramaComportamiento() {
		HazInterfaz();
		HazEscuchas();
	}
	
    private void HazInterfaz() {
    	setSize(400,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn=new JButton();
		btnNorte=new JButton("Norte");	
		btnSur=new JButton("Sur");
		add(btn);
		add(btnNorte,BorderLayout.NORTH);
		add(btnSur,BorderLayout.SOUTH);
		
		setVisible(true);
		
	}

	private void HazEscuchas() {
		btn.addActionListener(this);
		btnNorte.addActionListener(this);
		btnSur.addActionListener(this);
		
		btn.addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		if(e.getSource() == btn) {
//	     btn.setBackground(Color.red);
//	     return;
//	}
//	if(e.getSource() == btnNorte) {
//	     btnNorte.setBackground(Color.blue);
//	     return;
//	}	
//	if(e.getSource() == btnSur) {
//	     btnSur.setBackground(Color.ORANGE);
//	     return;
//	}
	
	JButton aux = (JButton) e.getSource();
	aux.setBackground(Color.ORANGE);
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		original=btn.getBackground();
		btn.setBackground(Color.PINK);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		btn.setBackground(original);
		
	}
    
	public static void main(String []args) {
		new ProgramaComportamiento();
	}
	

}
