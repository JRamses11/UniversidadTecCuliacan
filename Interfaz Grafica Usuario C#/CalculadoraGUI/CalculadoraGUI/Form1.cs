using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CalculadoraGUI
{
    public partial class frmPrincipal : Form
    {
        public frmPrincipal()
        {
            InitializeComponent();
        }

        private void btnSuma_Click(object sender, EventArgs e)
        {
            try
            {
              //CONVERTIMOS EL VALOR DEL TEXT DE STRING A ENTERO
              int num1 = Convert.ToInt32(txtNum1.Text);
              int num2 = Convert.ToInt32(txtNum2.Text);
              lblOperacion.Text = "SUMA (+)";
              int operacion = num1 + num2;
              txtResultado.Text = operacion.ToString();
            }
            catch (FormatException)
            {
                MessageBox.Show("Error al no ingresar valores numericos", "Eror", MessageBoxButtons.OK, MessageBoxIcon.Error);
                txtNum1.Text = "";
                txtNum2.Text = "";
            }

        }

        private void btnResta_Click(object sender, EventArgs e)
        {
            try
            {
               //CONVERTIMOS EL VALOR DEL TEXT DE STRING A ENTERO
               int num1 = Convert.ToInt32(txtNum1.Text);
               int num2 = Convert.ToInt32(txtNum2.Text);
               lblOperacion.Text = "RESTA (-)";
               int operacion = num1 - num2;
               txtResultado.Text = operacion.ToString();
            }catch (FormatException)
            {
                MessageBox.Show("Error al no ingresar valores numericos", "Eror", MessageBoxButtons.OK, MessageBoxIcon.Error);
                txtNum1.Text = "";
                txtNum2.Text = "";
            }

        }

        private void btnMultiplicar_Click(object sender, EventArgs e)
        {
            try
            {
              int num1 = Convert.ToInt32(txtNum1.Text);
              int num2 = Convert.ToInt32(txtNum2.Text);
              lblOperacion.Text = "MULTIPLICAR (X)";
              int operacion = num1 * num2;
              txtResultado.Text = operacion.ToString();
            }
            catch (FormatException)
            {
                MessageBox.Show("Error al no ingresar valores numericos", "Eror", MessageBoxButtons.OK,MessageBoxIcon.Error);
                txtNum1.Text = "";
                txtNum2.Text = "";
            }
            //CONVERTIMOS EL VALOR DEL TEXT DE STRING A ENTERO
            
         
        }

        private void btnLimpiar_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("Seguro que deseas limpiar las cajas de texto?",
                  "Limpiando cajas",
                  MessageBoxButtons.YesNo,
                  MessageBoxIcon.Information
                  ) == DialogResult.Yes)
            {
                txtNum1.Text = "";
                txtNum2.Text = "";
                txtResultado.Text = "";
                lblOperacion.Text = "- ninguna -";
                MessageBox.Show("Borrado con exito!",
                "Limpiado cajas",
                MessageBoxButtons.OK,
                MessageBoxIcon.Information
                );
            }
            else
            {
                MessageBox.Show("No se limpiaron las cajas",
                "Limpiado cajas",
                MessageBoxButtons.OK,
                MessageBoxIcon.Information
                );
            }
        }
    }
}
