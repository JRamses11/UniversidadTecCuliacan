package UNIDAD1;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TablaModel extends JFrame implements ActionListener {
	JButton btnMostrar,btnEliminar, btnModificar;
	JTable tbl;
	DefaultTableModel modelo;
	
	public TablaModel() {
		super("TABLA MODELO");
		HazInterfaz();
		HazEscucha();
	}
	
	
	private void HazInterfaz() {
		setSize(500,500);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		tbl=new JTable();
		String [] col= {"Id","Nombre","Edad (años)","Estatura (cm)"};
		modelo=new DefaultTableModel();
		modelo.setColumnIdentifiers(col);
		
		
		tbl.setModel(modelo);
		Agrega();
		JScrollPane barra= new JScrollPane(tbl);
		
		JPanel panel= new JPanel();
		btnMostrar= new JButton("Mostrar");
		btnEliminar= new JButton("Eliminar");
		btnModificar= new JButton("Modiificar");
		
		panel.add(btnMostrar);
		panel.add(btnEliminar);
		panel.add(btnModificar);
		
		add(panel,BorderLayout.SOUTH);
		add(barra);
		
		
		setVisible(true);
		
	}


	private void Agrega() {
		Vector fila;
		for(int i=0;i<1000;i++) {
			fila=new Vector();
			fila.addElement(i+1);
			fila.addElement(Rutinas.nextNombre(2));
			fila.addElement(Rutinas.nextInt(18,60));
			fila.addElement(Rutinas.nextInt(160,190));
			modelo.addRow(fila);
		}
		
	}


	private void HazEscucha() {
		btnMostrar.addActionListener(this);
		btnEliminar.addActionListener(this);
		btnModificar.addActionListener(this);
		
	}


	public static void main (String []args) {
		new TablaModel();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnMostrar) {
			if(tbl.getSelectedRow()==-1)
				return;
		   int valor1= (int) modelo.getValueAt(tbl.getSelectedRow(), 0);
		   String valor2= (String) modelo.getValueAt(tbl.getSelectedRow(), 1);
		   int valor3= (int) modelo.getValueAt(tbl.getSelectedRow(), 2);
		   int valor4= (int) modelo.getValueAt(tbl.getSelectedRow(), 3);
		   Rutinas.Mensaje(valor1+" "+valor2+" "+valor3+" "+valor4+" ");
	    }
		if (e.getSource()==btnEliminar) {
			if(tbl.getSelectedRow()==-1)
				return;
			int resp=JOptionPane.showConfirmDialog(null, "Estas Seguro");
			if(resp==0)
				modelo.removeRow((int)tbl.getSelectedRow());
		}
		if (e.getSource()==btnModificar) {
			if(tbl.getSelectedRow()==-1)
				return;
			modelo.setValueAt(9999, (int)tbl.getSelectedRow(), 2);
		}
		
}

}
