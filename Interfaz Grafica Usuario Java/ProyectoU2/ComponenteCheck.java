package ProyectoU2;
/*
 * 20170585
 * ALDAMA CAZARES JOSE RAMSES
 * TOPICOS AVANZADOS DE PROGRAMACION 
 * Maestro: Doc. CLEMENTE GARCIA GERARDO
 * 13:00-14:00
 */


import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
public class ComponenteCheck extends JPanel implements ActionListener, KeyListener{
	private JTextField txtbuscar;
	private ArrayList <JCheckBox>marcas= new ArrayList();
	private JCheckBox aux ;
	private JButton btnlimpiar;
	private Box contenedor;

	public ComponenteCheck() {
		HazInterfaz();
		HazEscuchas();
	}
	
	private void HazInterfaz() {
		setSize(200,500);
		txtbuscar= new JTextField();
	    btnlimpiar= new JButton("Limpiar");
	    contenedor= Box.createVerticalBox();
	    
        setLayout(new GridBagLayout());
        GridBagConstraints constraints= new GridBagConstraints();
        constraints.gridx=0; //EMPIEZA EN LA CELDA X=0
        constraints.gridy=0; //EMPIEZA EN LA CELDA Y=0
        constraints.gridwidth=2; // ABARCA DOS COLUMNAS
        constraints.gridheight=1; //ABARCA DOS FILAS
        
        constraints.weightx=1.0;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        
        add(txtbuscar, constraints);
        constraints.weighty=0.0;
        try {
        	Statement statement=ConexionBaseDatos.getStatement();
        	ResultSet tuplas= statement.executeQuery("select nombre from Marcas where Vigencia='A'");
            while(tuplas.next()) {
            	aux=new JCheckBox(tuplas.getString("Nombre"));
            	marcas.add(aux);
            	contenedor.add(aux);
            }
        }catch(Exception error) {
        	   	
        }      
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=2;
        constraints.gridheight=1; 
        constraints.weightx=1.0;
        constraints.weighty=1.0;
        constraints.fill=GridBagConstraints.BOTH;
        JScrollPane barra= new JScrollPane(contenedor);
        
        add(barra, constraints);
        
        constraints.weightx=0.0;
        constraints.weighty=0.0;   
        constraints.gridx=0;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.gridheight=1;
        add(btnlimpiar,constraints);
        
        
        
        setVisible(true);
		
	}

	private void HazEscuchas() {
		txtbuscar.addKeyListener(this);
		btnlimpiar.addActionListener(this);
		aux.addActionListener(this);
	}

	public void RecuperaDatos(){
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {	
		try {
        	Statement statement=ConexionBaseDatos.getStatement();
        	ResultSet tuplas= statement.executeQuery("Select Nombre from Marcas where Nombre LIKE'"+txtbuscar.getText()+"%'");
        //	String resultado="Select Nombre from Marcas where Nombre LIKE'"+txtbuscar.getText()+"%'";
        //	System.out.println(resultado);
        	contenedor.removeAll();
            while(tuplas.next()) {
            	aux=new JCheckBox(tuplas.getString("Nombre"));
            	marcas.add(aux);
            	contenedor.add(aux);
            }
           contenedor.revalidate();
           contenedor.repaint();
           contenedor.validate();
            
        }catch(Exception error) {
        	   	
        }	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnlimpiar) {
			 try {
		        	Statement statement=ConexionBaseDatos.getStatement();
		        	ResultSet tuplas= statement.executeQuery("select nombre from Marcas where Vigencia='A' order by Marcas.nombre ");
		        	contenedor.removeAll();
		            while(tuplas.next()) {    
		            	aux=new JCheckBox(tuplas.getString("Nombre"));
		            	marcas.add(aux);
		            	contenedor.add(aux);
		            	txtbuscar.setText("");
		            }
		        }catch(Exception error) {
		        	   	
		        }      
		}
		contenedor.revalidate();
        contenedor.repaint();
        contenedor.validate();		
	}

}
