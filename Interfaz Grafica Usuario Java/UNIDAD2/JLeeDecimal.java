package UNIDAD2;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class JLeeDecimal extends JLeeEntero{
	private int tama�o;
	
	public JLeeDecimal(){
		this(5);
		
	}
	public JLeeDecimal(int tama�o) {
		this.tama�o=tama�o;
	}
	
	public void keyTyped(KeyEvent e) {
		if(getText().length()==tama�o) {
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
