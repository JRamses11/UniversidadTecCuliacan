package ProyectoU1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfazEspiral extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JButton [] [] btns;
	JButton btnInicio;
	JButton Reseteo;
    Color bg;
    
	public InterfazEspiral() {
		super("CARACOL ESPIRAL");
		HazInterfaz();
		HazEscucha();
	}
	
    private void HazInterfaz() {
    	setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
        JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(0,10,5,5));
	    btns= new JButton[10][10];
	    for (int i=0;i<btns.length;i++) {
	    	for(int j=0;j<btns[i].length;j++) {

	    		btns[i][j] = new JButton();
	    		panel.add(btns[i][j]);
	   	    	}
	    }	    
	    add(panel,BorderLayout.CENTER);
	    JPanel panel2= new JPanel();
	    
	    btnInicio=new JButton("Inicio");
	    Reseteo=new JButton("Reseteo");
		panel2.add(btnInicio);
		panel2.add(Reseteo);
		add(panel2,BorderLayout.NORTH);
		setVisible(true);
       }
	

	private void HazEscucha() {
		btnInicio.addActionListener(this);
		Reseteo.addActionListener(this);
		for(int i=0;i<btns.length;i++) {
			for (int j=0;j<btns[i].length;j++) {
				btns[i][j].addActionListener(this);
			}
		}
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
	        int inicioMatriz=0;
	        int valor=1;
	        int longitudMatriz=btns.length;
	        if(e.getSource()==btnInicio) {
			for (int i=0; i<=btns.length/2;i++) {
			     for (int j=inicioMatriz; j<btns.length-valor; j++) {
			    	
				     btns[inicioMatriz][j].setBackground(Color.GREEN);
				     btns[inicioMatriz][j].update(btns[inicioMatriz][j].getGraphics());
				     DormirHilo();
			     }
			     for (int j=inicioMatriz; j<=btns.length-valor; j++) {
			    	
				     btns[j][longitudMatriz-valor].setBackground(Color.GREEN); 
				     btns[j][longitudMatriz-valor].update(btns[j][longitudMatriz-valor].getGraphics());
				     DormirHilo();
			     }
			     for (int j=btns.length-valor;j>=inicioMatriz; j--) {
			    	
				     btns[longitudMatriz-valor][j].setBackground(Color.GREEN);
				     btns[longitudMatriz-valor][j].update( btns[longitudMatriz-valor][j].getGraphics());
				     DormirHilo();
			     }
			     for (int j=btns.length-valor;j>=inicioMatriz; j--) {
			    	 //matriz[j][inicioMatriz]= new JButton();
				     btns[j][inicioMatriz].setBackground(Color.GREEN);
				     btns[j][inicioMatriz].update( btns[j][inicioMatriz].getGraphics());
				     DormirHilo();
			    }
			     inicioMatriz++;
			     valor++;	     
			}
           
	       }
	        if(e.getSource()==Reseteo) {
	        	Reset();
	        }
	}
	public void Reset() {
		bg = new JButton().getBackground();
		for (int i=0;i<btns.length;i++) {
			for (int j=0;j<btns[i].length;j++) {
				btns[i][j].setBackground(bg);
				btns[i][j].update(btns[i][j].getGraphics());
			}
		}
		
	}
	
	
	public void DormirHilo(){
		try{
			Thread.sleep(100);
		}catch(Exception error) {
			System.out.println(error.getMessage());
		}
		
	}
	
	
	
    public static void main(String[] args) {
           new InterfazEspiral ();

	}
    
}
