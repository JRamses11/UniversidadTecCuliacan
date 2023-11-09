package UNIDAD2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ComponenteV3 extends JPanel implements ComponentListener, ActionListener{
	private JLeeEntero txtNoControl;
	private JTextField txtNombre, txtCarrera;
	private JButton btnGrabar, btnLimpiar;
	private JLabel lblNoControl, lblNombre, lblCarrera;
	public ComponenteV3() {
		HazInterfaz();
		HazEscuchas();
	}

	private void HazInterfaz() {
		setLayout(null);
		setSize(200,200);
		lblNoControl=new JLabel("NoControl");
		lblNombre=new JLabel("Nombre");
		lblCarrera=new JLabel("Carrera");
		
		txtNoControl=new JLeeEntero(8);
		txtNombre=new JTextField();
		txtCarrera=new JTextField();

		
	}
	private void HazEscuchas() {
		this.addComponentListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	public long getTxtNoControl() {
		return txtNoControl.getCantidad();
	}
	public void setTxtNoControl(JLeeEntero txtNoControl) {
		this.txtNoControl = txtNoControl;
	}
	public String getTxtNombre() {
		return txtNombre.getText();
	}
	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}
	public String getTxtCarrera() {
		return txtCarrera.getText();
	}
	public void setTxtCarrera(JTextField txtCarrera) {
		this.txtCarrera = txtCarrera;
	}
	@Override
	public void componentHidden(ComponentEvent arg0) {
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
	
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		
		int h=this.getHeight();
		int w=this.getWidth();
		
		lblNoControl.setBounds((int)(w*0.10),(int)(h*0.05),60,20);
		lblNombre.setBounds((int)(w*0.10),(int)(h*0.25),50,10);
//		lblCarrera.setBounds(15,60,50,10);
//		
		txtNoControl.setBounds((int)(w*0.10)+lblNoControl.getWidth()+20,(int)(h*0.05),150,20);
		txtNombre.setBounds   ((int)(w*0.10)+lblNombre.getWidth()+20,(int)(h*0.25),300,20);
//		txtCarrera.setBounds(100,60,300,20);
		add(lblNoControl);
		add(lblNombre);
//		add(lblCarrera);
		add(txtNoControl);
		add(txtNombre);
//		add(txtCarrera);
		
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		
		
	}
	

}
