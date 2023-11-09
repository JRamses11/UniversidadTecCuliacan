package UNIDAD2;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

public class JLeeEntero extends JTextField implements KeyListener, FocusListener{

	private int tamaño;
	private Color bgTxt;
	private Font font;
	public JLeeEntero() {
		this(5);
	
	}
	public JLeeEntero(int tamaño) {
		this.tamaño=tamaño;
		
		this.addKeyListener(this);
		this.addFocusListener(this);
		bgTxt=this.getBackground();
		font=getFont();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.isControlDown()) {
			e.consume();
			return;
		}
		//consume la tecla Inicio,flecha izq o flecha der
		if(e.getKeyCode()==36 ||e.getKeyCode()==37 || e.getKeyCode()==39){
			e.consume();
			return;
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(getText().length()==tamaño) {
			Toolkit.getDefaultToolkit().beep();
		    e.consume();
		    return;
		}
		char car=e.getKeyChar();
		if("-0123456789".indexOf(car)==-1) {
			e.consume();
			return;
		}
//		if(car=='-' && getText().length()>0) {
//			e.consume();
//			return;
//		}
		if(car=='-') {
			if(getText().length()==0)
				return;
			if(getText().charAt(0)=='-') {
				e.consume();
				return;
			}
			setText("-"+getText());
			e.consume();
			return;
			
			
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		JTextField aux=(JTextField) e.getSource();
		aux.selectAll();
		aux.setBackground(Color.yellow);
		aux.setBorder(new LineBorder(Color.BLUE));
		setFocusTraversalKeysEnabled(false);
		setFont(new Font( "Tahoma", Font.ITALIC+Font.BOLD, 20      ));
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField aux=(JTextField) e.getSource();
		aux.setBorder(new LineBorder(Color.LIGHT_GRAY));
		aux.setBackground(bgTxt);
		aux.setFont(font);
		
	}
	public long getCantidad() {
		long cantidad=0;
		try {
			cantidad=Long.parseLong(getText());
		}catch(Exception e) {
			
		}
		return cantidad;
	}
}
