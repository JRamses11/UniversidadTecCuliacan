package UNIDAD1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Graficos extends JFrame implements ActionListener, MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel;
	JButton btnAvanzar, btnTriangulo, btnCirculo, btnRectangulo;
	int x=0, xImagen=0;
	boolean band=true, banderaImagen=true, banderaTriangulo=false, banderaCirculo=false;
	Timer t;
	
	public Graficos() {
		super("MANEJO DE GRAFICOS");
		HazInterfaz();
		HazEscuchas();
		t= new Timer(300,this);
		t.start();
	}
	public void HazInterfaz() {
		setSize(600,500);
		setLocationRelativeTo(null);
		
		btnAvanzar=new JButton("Avanzar");
		add(btnAvanzar,BorderLayout.SOUTH);
		panel= new JPanel();
		panel.setLayout(new GridLayout(0,1));
		btnTriangulo= new JButton("Triangulo");
		btnCirculo= new JButton ("Circulo");
		btnRectangulo= new JButton("Rectangulo");
		
		panel.add(btnTriangulo);
		panel.add(btnCirculo);
		panel.add(btnRectangulo);
		
		add(panel,BorderLayout.EAST);
		
		setVisible(true);
	}
	public void HazEscuchas() {
		btnAvanzar.addActionListener(this);
		btnCirculo.addMouseListener(this);
		btnRectangulo.addMouseListener(this);
		btnTriangulo.addMouseListener(this);
	}
	public void paint( Graphics g) 	{
	       super.paint(g);
	        g.drawString("INSTITUTO TECNOLÓGICO DE CULIACÁN",50,40);
	        g.drawLine(20,45,300,45);
	        g.drawString("INGENIERÍA EN SISTEMAS COMPUTACIONALES",50,60);
	        g.setColor(Color.BLUE);
	        g.fillRect(50,70,100,50);
	        g.fillRoundRect(250, 70,100, 50, 20, 20);
	        Color CAFE=new Color(192,128,64);
	        g.setColor(CAFE);
	        g.fillRect(50+x,150,200,100);
	        g.setColor(Color.RED);
	        g.fillOval(60+x,220,60,60);
	        g.fillOval(190+x,220,50,60);
	        g.setColor(Color.WHITE);
	        g.fillRect(200+x,160,50,30);
	        g.drawImage(Rutinas.AjustarImagen("Cruz azul.png",60,60).getImage(), 5+xImagen,400,null);
	        
	        if(banderaCirculo) {
	        	g.setColor(CAFE);
	        	g.fillOval(this.getWidth()/2,this.getHeight()/2-50,80,80);
	        }
	        
	        if(banderaTriangulo) {
	        	int [] vx= {400,300,500};
				int [] vy= {400,500,500};
				g.setColor(Color.RED);
				g.fillPolygon(vx,vy,vx.length);
			}
	        }
	public static void main(String [] a) {
		new Graficos();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if( e.getSource()==btnAvanzar) {
			if(x<0 || x+250>this.getWidth())
				band=!band;
			if(band)
			   x+=10;
			       else
			          x-=10;
			repaint();
			return;
		}
		if(e.getSource()==t) {
			if(xImagen<0 || xImagen+80>this.getWidth())
				banderaImagen=!banderaImagen;
			if(banderaImagen)
			   xImagen+=10;
			       else
			          xImagen-=10;
			repaint();
			return;
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==btnCirculo) {
			banderaCirculo=true;
			repaint();
			return;
		}
		
		if(e.getSource()==btnTriangulo) {
			banderaTriangulo=true;
			repaint();
			return;
		}
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==btnCirculo) {
			banderaCirculo=false;
			repaint();
			return;
		}
		if(e.getSource()==btnTriangulo) {
			banderaTriangulo=false;
			repaint();
			return;
		}
		
	}
}
