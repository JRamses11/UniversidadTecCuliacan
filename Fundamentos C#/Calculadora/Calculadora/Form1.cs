using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Calculadora
{
    public partial class Calculadora : Form
    {
        public Calculadora()
        {
            InitializeComponent();
        }

        private void btnSuma_Click(object sender, EventArgs e)
        {

            int num1 = Convert.ToInt32(txtNum1.Text);
            int num2 = Convert.ToInt32(txtNum2.Text);
            lblOperacion.Text = " S U M A (+)";
            int operacion = num1 + num2;
            txtResultado.Text = operacion.ToString();


        }

        private void btnLimpiar_Click(object sender, EventArgs e)
        {
            txtResultado.Text = "";
            txtNum1.Text = "0";
            txtNum2.Text = "0";
            lblOperacion.Text = "- ninguna -";
            MessageBox.Show("se va a limpiar","titulo",
            MessageBoxButtons.YesNoCancel,
            MessageBoxIcon.Error);
        }

        private void btnResta_Click(object sender, EventArgs e)
        {
            int num1 = Convert.ToInt32(txtNum1.Text);
            int num2 = Convert.ToInt32(txtNum2.Text);
            lblOperacion.Text = " R E S T A (-)";
            int operacion = num1 - num2;
            txtResultado.Text = operacion.ToString();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            int num1 = Convert.ToInt32(txtNum1.Text);
            int num2 = Convert.ToInt32(txtNum2.Text);

            lblOperacion.Text = "MULTIPLICACION";
            int multiplicacion = num1 * num2;
            txtResultado.Text = multiplicacion.ToString();


        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
    }
}
