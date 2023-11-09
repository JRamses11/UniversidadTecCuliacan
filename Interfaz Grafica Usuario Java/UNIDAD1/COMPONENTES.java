package UNIDAD1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class COMPONENTES extends JFrame {

        public COMPONENTES(){
               super("MANEJO DE COMPONENTES");
               HazInterfaz();
               HazEscucha();
        }


        private void HazInterfaz() {
        setSize(400,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0,2,5,5));
        
         //ADD ETIQUETAS
        add(new JLabel("Etiqueta",JLabel.CENTER));
        add(new JLabel("Etiqueta",JLabel.CENTER));

        add(new JLabel("Etiqueta con imagen", JLabel.CENTER));
        JLabel etiqueta= new JLabel(new ImageIcon("Cruz azul.png"));
        add(etiqueta);
        
        add(new JLabel("Etiqueta con texto  e imagen",JLabel.CENTER));
		etiqueta=new JLabel("Mi escudo",new ImageIcon("Cruz azul.png"),JLabel.CENTER);
		add(etiqueta);
		

        //ADD CAJA DE TEXTO
        add(new JLabel("Caja de texto",JLabel.CENTER));
        JTextField txt=new JTextField();
        add(txt);

        add(new JLabel("Caja de texto con valor",JLabel.CENTER));
        txt=new JTextField("ESTE SIEMPRE TENDRA ESTE VALOR",JLabel.CENTER);
        add(txt);

        add(new JLabel("Caja de texto con valor numerico",JLabel.CENTER));
        txt=new JTextField(20);
        add(txt);

        //ADD BOTONES
        JButton btn=new JButton();
        add(new JLabel("Boton Tradicional",JLabel.CENTER));
        add(btn);
   
        btn= new JButton("GRABAR");
        add(new JLabel("Botones con texto"));
        add(btn);
   
        btn= new JButton(new ImageIcon("Cruz azul.png"));//añaddir la direccion con imagen new ImageIcon()
        add(new JLabel("Boton con imagen", JLabel.CENTER));
        add(btn);
   
        btn= new JButton("Escudo", new ImageIcon("Cruz azul.png"));//añaddir la direccion con imagen "NOMBRE DE LA IMAGEN",new ImageIcon()
        add(new JLabel("Boton con imagen y texto",JLabel.CENTER));
        add(btn);
   
 
   
        //ADD COMBO
        JComboBox cmb= new JComboBox();
        add(new JLabel("ComboVacio",JLabel.CENTER));
        add(cmb);
   
        String [] estaciones={"Seleccione","Primavera","Verano","Otoño"};
        cmb=new JComboBox(estaciones);
        add(new JLabel("Combo con informacion",JLabel.CENTER));
        add(cmb);
   
       //ADD BOTONES DE TIPO RADIO
       JRadioButton radio= new JRadioButton();
       add(new JLabel("Radio Button",JLabel.CENTER));
       add(radio);
   
       radio= new JRadioButton("Masculino");
       add(new JLabel("Radio Button con texto",JLabel.CENTER));
       add(radio);
   
       setVisible(true);
       System.out.println(btn.getWidth()+"Altura"+btn.getHeight());
    }


       private void HazEscucha() {

 
       }


      public static void main (String []args){
             new COMPONENTES();
      }

  }
