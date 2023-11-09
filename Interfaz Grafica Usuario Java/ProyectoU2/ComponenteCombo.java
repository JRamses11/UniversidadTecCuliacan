package ProyectoU2;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;
/*
 * 20170585
 * ALDAMA CAZARES JOSE RAMSES
 * TOPICOS AVANZADOS DE PROGRAMACION 
 * Maestro: Doc. CLEMENTE GARCIA GERARDO
 * 13:00-14:00
 */

public class ComponenteCombo extends JPanel implements ActionListener, ItemListener, ComponentListener {
     JLabel lblEstado, lblMunicipio, lblCiudades;
	 JComboBox cmbEstado, cmbMunicipio,cmbCiudades;
	 String seleccionar= new String();
	 ArrayList<String> ConEst= new ArrayList<String>();
	 ArrayList<String> ConMun= new ArrayList<String>();
	 ArrayList<String> ConCiu= new ArrayList<String>();
	 int PKEstado=0, PKMun=0, PKCiu=0;
			
	public ComponenteCombo() {
	//	this.("Seleccionar", "Seleccionar");
		HazInterfaz();
		HazEscuchas();
	}
	
	public ComponenteCombo(String estado) {
	//	this.(estado,"Seleccionar");
		HazInterfaz();
		HazEscuchas();
		cmbEstado.setSelectedItem(estado);
		cmbEstado.setEnabled(false);
	}
	
	public ComponenteCombo(String estado, String municipio) {
	//	this.(estado, municipio);
		HazInterfaz();
		HazEscuchas();
		cmbEstado.setSelectedItem(estado);
		cmbMunicipio.setSelectedItem(municipio);
		cmbEstado.setEnabled(false);
		cmbMunicipio.setEnabled(false);
		
	}

	private void HazInterfaz() {
		setLayout(null);
		
		lblEstado= new JLabel("Estado");
		lblMunicipio= new JLabel("Municipio");
		lblCiudades= new JLabel("Ciudades");
		
		cmbEstado= new JComboBox();
		AgregaEstado();
		cmbMunicipio= new JComboBox();
		cmbCiudades= new JComboBox();
		
		setVisible(true);
	}

	private void HazEscuchas() {
		this.addComponentListener(this);
		cmbEstado.addItemListener(this);
		cmbMunicipio.addItemListener(this);
		cmbCiudades.addItemListener(this);
		
		cmbEstado.addActionListener(this);
		cmbMunicipio.addActionListener(this);
		cmbCiudades.addActionListener(this);
	}
	
	public void AgregaEstado() {
		try {
        	Statement statement=ConexionBaseDatos.getStatement();
        	ResultSet estados= statement.executeQuery("Select Nombre from Estados");
        	cmbEstado.addItem("Seleccionar");
            while(estados.next()) {
            	ConEst.add(estados.getString("Nombre"));
                cmbEstado.addItem(estados.getString("Nombre"));
            }      
        }catch(Exception error) {
        	   	
        }	
	}
	
	public void AgregaMunicipio() {
		String est=cmbEstado.getSelectedItem().toString();
		try {
        	Statement statement=ConexionBaseDatos.getStatement();
        	ResultSet ID= statement.executeQuery("Select IDEstado from Estados where Nombre='"+est + "'");
            while(ID.next()) {
            	PKEstado=ID.getInt("IDEstado");
            }      
        }catch(Exception error) {
        	   	
        }	
		System.out.println(PKEstado);
		try {
        	Statement statement=ConexionBaseDatos.getStatement();
        	ResultSet municipios= statement.executeQuery("Select Nombre from Municipios where IDEstado="+PKEstado);
        	cmbMunicipio.removeAllItems();
        	cmbMunicipio.addItem("Seleccionar");
            while(municipios.next()) {
            	 ConMun.add(municipios.getString("Nombre"));
                 cmbMunicipio.addItem(municipios.getString("Nombre"));
            }      
        }catch(Exception error) {
        	   	
        }	
	}
	
	public void AgregaCiudades() {
		String edo=cmbEstado.getSelectedItem().toString();
		try {
        	Statement statement=ConexionBaseDatos.getStatement();
        	ResultSet ID= statement.executeQuery("Select IDEstado from Estados where Nombre='"+edo + "'");
            while(ID.next()) {
            	PKEstado=ID.getInt("IDEstado");
            }      
        }catch(Exception error) {
        	   	
        }	
		String muni=cmbMunicipio.getSelectedItem().toString();
		try {
        	Statement statement=ConexionBaseDatos.getStatement();
        	ResultSet ID= statement.executeQuery("Select IDMunicipio from Municipios where Nombre='"+muni + "'");
            while(ID.next()) {
            	PKMun=ID.getInt("IDMunicipio");
            }      
        }catch(Exception error) {
        	   	
        	
        }	
		try {
			System.out.println(PKEstado);
			System.out.println(PKMun);
        	Statement statement=ConexionBaseDatos.getStatement();
        	ResultSet municipios= statement.executeQuery("Select Nombre from Ciudades where IDEstado="+PKEstado +"and IDMunicipio="+PKMun);
        	cmbCiudades.removeAllItems();
        	cmbCiudades.addItem("Seleccionar");
            while(municipios.next()) {
            	 ConCiu.add(municipios.getString("Nombre"));
                 cmbCiudades.addItem(municipios.getString("Nombre"));
            }      
        }catch(Exception error) {
        	   	
        }
	}
	

	public InfoCombo RecuperaDato() {
		String est=cmbEstado.getSelectedItem().toString();
		try {
        	Statement statement=ConexionBaseDatos.getStatement();
        	ResultSet ID= statement.executeQuery("Select IDEstado from Estados where Nombre='"+est + "'");
            while(ID.next()) {
            	PKEstado=ID.getInt("IDEstado");
            }      
        }catch(Exception error) {
        	   	
        }	
		
		String muni=cmbMunicipio.getSelectedItem().toString();
		try {
        	Statement statement=ConexionBaseDatos.getStatement();
        	ResultSet ID= statement.executeQuery("Select IDMunicipio from Municipios where Nombre='"+muni + "'");
            while(ID.next()) {
            	PKMun=ID.getInt("IDMunicipio");
            }      
        }catch(Exception error) {
        	   	 	
        }	
		
		String ciud=cmbCiudades.getSelectedItem().toString();
		try {
			Statement statement=ConexionBaseDatos.getStatement();
			ResultSet ID= statement.executeQuery("Select IDCiudades from Ciudades where Nombre='"+ciud +"'");
			while(ID.next()) {
				PKCiu=ID.getInt("IDCiudades");
			}
		}catch(Exception error) {
			
		}
		
		InfoCombo zona= new InfoCombo(PKEstado, PKMun, PKCiu);		
		return zona;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getStateChange()!=ItemEvent.SELECTED)
			return;
		
		if (e.getSource()==cmbEstado) {
			if(cmbEstado.getSelectedIndex()==0) {
				cmbMunicipio.setEnabled(false);
				cmbCiudades.setEnabled(false);
				return;
			}
			AgregaMunicipio();
			cmbCiudades.removeAllItems();
		}
		
		cmbMunicipio.setEnabled(true);
		
		if (e.getSource()==cmbMunicipio) {
			if(cmbMunicipio.getSelectedIndex()==0) {
				cmbCiudades.setEnabled(false);
				return;
			}
			AgregaCiudades();
		}
     	cmbCiudades.setEnabled(true);
	}

	@Override
	public void componentResized(ComponentEvent e) {
		int h=this.getHeight();
		int w=this.getWidth();
		
		lblEstado.setBounds((int)(w*0.10),(int)(h*0.05),40,20);
		cmbEstado.setBounds((int)(w*0.10)+lblEstado.getWidth()+10,(int)(h*0.05),110,20);
		
		lblMunicipio.setBounds((int)(w*0.10)+cmbEstado.getWidth()+70,(int)(h*0.05),190,20);
    	cmbMunicipio.setBounds((int)(w*0.10)+lblMunicipio.getWidth()+50,(int)(h*0.05),130,20);
		
		lblCiudades.setBounds((int)(w*0.10)+cmbMunicipio.getWidth()+250,(int)(h*0.05),280,20);
		cmbCiudades.setBounds((int)(w*0.10)+lblCiudades.getWidth()+170,(int)(h*0.05),130,20);
		
		add(lblEstado);
		add(cmbEstado);
		add(lblMunicipio);
		add(cmbMunicipio);
		add(lblCiudades);
		add(cmbCiudades);
	}
	

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
