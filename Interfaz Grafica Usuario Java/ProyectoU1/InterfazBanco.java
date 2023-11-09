package ProyectoU1;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import UNIDAD1.Rutinas;

import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Vector;
/*
 * 20170585
 * ALDAMA CAZARES JOSE RAMSES
 * TOPICOS AVANZADOS DE PROGRAMACION 
 * Maestro: Doc. CLEMENTE GARCIA GERARDO
 * 13:00-14:00
 */

public class InterfazBanco extends JFrame implements ActionListener {
	
	JPanel panel1,panel2;
	JButton btnCambiar, btnAgregar;
    JTable tbl, tbl2;
    DefaultTableModel modelo, modelo2;
	JTextField txtCantidad=new JTextField(10);
	RandomAccessFile billetes;
	int [] d={1000,500,200,100,50,20,10,5,2,1};
	int cantidad, denominacion;
	int [] contador=new int[10];
	Vector fila;
	
	public InterfazBanco() {
		super("BANCO DEL CAMBIO--->#CAJA 1");
		HazInterfaz();
		HazEscuchas();
	}
	
	private void HazInterfaz() {
		setSize(600,500);
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
        JTabbedPane P=new JTabbedPane();
		
		tbl= new JTable();
		tbl2= new JTable();
		panel1=new JPanel();
	    panel2=new JPanel(); 
		
	    add(new JLabel("BANCO DE CAMBIO",JLabel.CENTER));
	    panel1.add(new JLabel("Importe a cambiar",JLabel.CENTER));
        panel1.add(txtCantidad);
	    btnCambiar= new JButton("CAMBIAR");
	    panel1.add(btnCambiar);
	    
	    btnAgregar=new JButton("AGREGAR BILLETES");
	    panel2.add(btnAgregar);
	    
	    //AGREGAR TABLA 
	    String []col= {"Denominacion","Numero de billetes"};
		modelo=new DefaultTableModel();
		modelo.setColumnIdentifiers(col);
		tbl.setModel(modelo);
		
		JScrollPane barra= new JScrollPane(tbl);
		barra.setBorder(BorderFactory.createEmptyBorder());
		
		//AGREGAR TABLA 2
		String [] col2= {"Denominacion", "Cantidad"};
		modelo2= new DefaultTableModel();
		modelo2.setColumnIdentifiers(col2);
		tbl2.setModel(modelo2);
        ArchivoInventario();
		JScrollPane barra2= new JScrollPane(tbl2);
		barra2.setBorder(BorderFactory.createEmptyBorder());
		
		//AGREGAR PESTAÑAS
	    add(panel1, BorderLayout.SOUTH ); 
	    panel1.add(barra);
	    panel1.setBackground(new Color(153,217,234));
	    add(panel2,BorderLayout.NORTH);
	    panel2.add(barra2);
	    panel2.setBackground(new Color(153,217,234));
	   
		P.addTab("CAMBIO DE BILLETES", panel1);
		P.addTab("INVENTARIO BILLETES", panel2);
		add(P);
		P.setSelectedIndex(0);
		
		setVisible(true);
		
	}

	private void HazEscuchas() {
		btnCambiar.addActionListener(this);
		btnAgregar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCambiar) {
			int cantidadDinero=0;
			try {
			   cantidadDinero=Integer.parseInt(txtCantidad.getText());
			} catch(Exception ex) {
				Rutinas.Mensaje("Lo escrito no representa un valor numéricos");
				return;
			}
			if(cantidadDinero<1) {
				Rutinas.Mensaje("Solo se entrega cambio mayor o igual a 1 peso");
				return;
			}
			Devolucion(cantidadDinero);
		}
		
		if(e.getSource()==btnAgregar) {
		  AgregaBilletes();
		}
		
	}
	
	public void ArchivoInventario() {
	    modelo2.setRowCount(0);
		try (RandomAccessFile billetes = new RandomAccessFile(new File("BILLETES.DAT"), "rw")) {
			for(int i=0;i<d.length;i++) {
				fila=new Vector();
				billetes.seek((d[i]-1)*8);
				fila.addElement(denominacion=billetes.readInt());
				fila.addElement(cantidad=billetes.readInt());
				modelo2.addRow(fila);
				}
			
		} catch (Exception error) {
			System.out.println("****FIN*****" + error.getMessage());
		}				
	}
	public void AgregaBilletes() {
		try (RandomAccessFile billetes = new RandomAccessFile(new File("BILLETES.DAT"), "rw")) {
			for(int i=0;i<d.length;i++) {
				billetes.seek((d[i]-1)*8);
				denominacion=billetes.readInt();
				cantidad=billetes.readInt();
				
				billetes.seek((d[i]-1)*8);
				billetes.writeInt(denominacion);
				billetes.writeInt(cantidad+ Rutinas.nextInt(10,20));
				}
			
		} catch (Exception error) {
			System.out.println("****FIN*****" + error.getMessage());
		}			
		ArchivoInventario();
	}
	public void Devolucion(int cantidadDinero) {
		try (RandomAccessFile billetes = new RandomAccessFile(new File("BILLETES.DAT"), "rw")) {
			for (int i=0;i<d.length;i++) {
				billetes.seek((d[i]-1)*8);
				denominacion=billetes.readInt();
				cantidad=billetes.readInt();
				int aux=cantidadDinero/d[i];
	 			if(cantidad>=aux) {
					contador[i] = cantidadDinero / d[i];
		 			cantidadDinero -= contador[i] * d[i];
	 			} else {
	 				contador[i]=cantidad;
					cantidadDinero -= contador[i] * d[i];
	 			}
			}
		} catch (Exception error) {
			System.out.println(error.getMessage());
		}
	
		if(cantidadDinero==0) {
			 modelo.setRowCount(0);
				try (RandomAccessFile billetes = new RandomAccessFile(new File("BILLETES.DAT"), "rw")) {
					for(int i=0;i<d.length;i++) {
						fila=new Vector();
						billetes.seek((d[i]-1)*8);
						denominacion=billetes.readInt();
						cantidad=billetes.readInt();
						
						billetes.seek((d[i]-1)*8+4);
						billetes.writeInt(cantidad-contador[i]);
						fila.addElement(denominacion);
						fila.addElement(contador[i]);
						modelo.addRow(fila);
						}
					
				} catch (Exception error) {
					System.out.println("****FIN*****" + error.getMessage());
				}		
		}else {
			Rutinas.Mensaje("No hay suficiente dinero para el intercambio");
		}
		ArchivoInventario();
	}

	
    public static void main(String [] args) {
		new InterfazBanco();
		
	}
}
