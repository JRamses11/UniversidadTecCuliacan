using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DatosEmpleadosGUI
{
    public partial class frmConsulta : Form
    {
        ManejaEmpleados maneja;
        public frmConsulta(ManejaEmpleados m)
        {
            InitializeComponent();
            maneja = m;
            int[] arrID = maneja.RegresaID();
            
        }

        private void cmbEmpleado_SelectedIndexChanged(object sender, EventArgs e)
        {
            int idSeleccionado = (int)cmbIDEmpleado.SelectedItem;


            // Obtener los valores correspondientes al ID seleccionado
            Empleado emp = maneja.ObtenerValores(idSeleccionado);

            if (emp != null)
            {
                // Asignar los valores a los campos de texto correspondientes
                txtNombre.Text = emp.pNombre;
                txtApellido.Text = emp.pApellido;
                txtCiudad.Text = emp.pCiudad;
            }
        }
        private void frmConsulta_Load(object sender, EventArgs e)
        {
            int[] arrID = maneja.RegresaID();
            foreach(int item in arrID)
            {
                cmbIDEmpleado.Items.Add(item);
            }
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }
    }
}
