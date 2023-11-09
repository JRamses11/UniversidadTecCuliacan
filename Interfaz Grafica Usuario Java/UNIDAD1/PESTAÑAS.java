package UNIDAD1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PESTAÑAS extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel Panel1, Panel2, Panel3,Panel4;
	JButton BtnGira,BtnArchivo;
	JLabel LblTexto;
	JScrollPane JS;
	Timer T;
	int cont=0;
	private PESTAÑAS(){
		super("Manejo de pestañas");
		HazInterfaz();
		HazEscuchas();
		T=new Timer(300,this);
	}
	private void HazInterfaz(){
		setSize(600,300);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane P=new JTabbedPane();
		
		Panel1=new JPanel();
		Panel1.setLayout(new GridLayout(0,8));
		for(int i=0; i<170 ; i++){
			Panel1.add(new JButton((i+1)+""));
		}
		JS=new JScrollPane(Panel1);

		Panel2=new JPanel();
		Panel2.setLayout(new GridLayout(0,2,5,5));
		for(int i=0 ; i<10; i++){
			Panel2.add(new JLabel("Dato # "+(i+1), SwingConstants.RIGHT));
			Panel2.add(new JTextField());
		}
		
		Panel3=new JPanel();
		Panel4=new JPanel();
		BtnArchivo=new JButton("Abrir archivo");
		Panel3.add(BtnArchivo);
		Panel4.setLayout(new BorderLayout(0,1));
		Panel4.add(BtnGira=new JButton("Gira Texto"),BorderLayout.NORTH);
		Panel4.add(LblTexto=new JLabel("Este es el texto que quiero que gire for ever",SwingConstants.CENTER),BorderLayout.SOUTH);

		P.addTab("Datos Generales", Rutinas.AjustarImagen("Cruz azul.png",40,30),JS, "información del empleado");
		P.addTab("Finanzas", Rutinas.AjustarImagen("Cruz azul.png",40,30), Panel2, "situación económica");
		P.addTab("Abrir archivo", null, Panel3, "FileDialog");
		P.addTab("Texto", null, Panel4, "Texto Girando");		
//		for(int i=0 ; i<15 ; i++)
//			P.addTab("pestaña"+i,null,null,"ojojo");
		add(P);
	    P.setSelectedIndex(3);
		setVisible(true);
		
	}
	private void HazEscuchas(){
		BtnGira.addActionListener(this);
		BtnArchivo.addActionListener(this);
	}
	public static void main(String[] args) {
		new PESTAÑAS();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==BtnGira) {
			T.start();
			return;
		}
		if(e.getSource()==T) {
			cont++;
			LblTexto.setText( LblTexto.getText().substring(1)  +   LblTexto.getText().charAt(0)    );
			if(cont==10) {
				T.stop();
				return;
			}
		
		}
	}


}

