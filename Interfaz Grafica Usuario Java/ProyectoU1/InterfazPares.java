package ProyectoU1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InterfazPares extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	JComboBox cmb= new JComboBox();
	JButton btnInicio= new JButton();
	
	public InterfazPares() {
		super("JUEGO DE PARES");
		HazInterfaz();
		HazEscucha();
	}
	
	private void HazInterfaz() {
		setSize(900,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel= new JPanel();
		
		String [] nivel={"Seleccione","Basico","Medio","Experto"};
        cmb=new JComboBox(nivel);
        panel.add(new JLabel("Escoge tu dificultad",JLabel.CENTER));
        panel.add(cmb);
        
	    btnInicio= new JButton("INICIAR");
	    panel.add(btnInicio);
        
		add(panel, BorderLayout.NORTH );
		setVisible(true);
	}

	private void HazEscucha() {
		cmb.addActionListener(this);
		btnInicio.addActionListener(this);
	}
	
    @Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cmb) {
			
		}
		
		if(e.getSource()==btnInicio) {
			
		}
		
	}  
	public static void main(String [] args) {
		new InterfazPares();
	}

	
	
}
