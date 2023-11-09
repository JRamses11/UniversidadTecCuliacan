package UNIDAD2;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class JLeeDecimal extends JLeeEntero{
	private int tamaño;
	
	public JLeeDecimal(){
		this(5);
		
	}
	public JLeeDecimal(int tamaño) {
		this.tamaño=tamaño;
	}
	
	public void keyTyped(KeyEvent e) {
		if(getText().length()==tamaño) {
			Toolkit.getDefaultToolkit().beep();
		    e.consume();
		    return;
		}
		char car=e.getKeyChar();
		if("-.0123456789".indexOf(car)==-1) {
			e.consume();
			return;
		}
		if(car=='.') {
			if(getText().length()==0)
				return;
			if(getText().charAt(0)=='.') {
				e.consume();
				return;
			}
			e.consume();
			return;
			
			
		}
	}

}
