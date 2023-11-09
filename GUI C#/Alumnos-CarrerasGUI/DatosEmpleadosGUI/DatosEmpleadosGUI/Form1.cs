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
    public partial class Form1 : Form
    {
        ManejaEmpleados maneja;
        public Form1(ManejaEmpleados m)
        {
            InitializeComponent();
            maneja = m;
        }

        public bool ValidaId()
        {
            bool retorno = true;
            if (txtID.Text.Equals(""))
            {
                retorno = false;
                MessageBox.Show("Error caja vacia captura un ID", "Mensaje", MessageBoxButtons.OK, MessageBoxIcon.Information);

            }
            else
            {
                try
                {
                    int IDEmpleado = Convert.ToInt32(txtID.Text);
                }
                catch (Exception e)
                {
                    retorno = false;
                    MessageBox.Show("Error en captura de ID", "Mensaje", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    Limpiar();
                }
            }           
            return retorno;
        }

        public bool ValidaNombre()
        {
            bool retorno = true;
            if (txtNombre.Text.Equals(""))
            {
                retorno = false;
                MessageBox.Show("Error caja vacia captura un nombre", "Mensaje", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            else
            {
                if (int.TryParse(txtNombre.Text, out int num))
                {
                    retorno = false;
                    MessageBox.Show("Error en captura nombre", "Mensaje", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    Limpiar();
                }
            }
            return retorno;
        }

        public bool ValidaApellido()
        {
            bool retorno = true;
            if (txtApellido.Text.Equals(""))
            {
                retorno = false;
                MessageBox.Show("Error caja vacia captura un apellido", "Mensaje", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            else
            {
                if (int.TryParse(txtApellido.Text, out int num))
                {
                    retorno = false;
                    MessageBox.Show("Error en captura apellido", "Mensaje", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    Limpiar();
                }
            }          
            return retorno;
        }

        public bool ValidaCiudad()
        {
            bool retorno = true;
            if (cmbCiudad.Text.Equals(""))
            {
                retorno = false;
                MessageBox.Show("Error no selecciono una ciudad", "Mensaje", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
            else
            {
                if (cmbCiudad.Text.Equals("SELECCIONAR"))
                {
                    retorno = false;
                    MessageBox.Show("Error selecciona una ciudad", "Mensaje", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
            }
            return retorno;
        }
        public void Limpiar()
        {
            txtID.Text = "";
            txtNombre.Text = "";
            txtApellido.Text = "";
            cmbCiudad.SelectedIndex=0;
        }
        private void btnGuardar_Click(object sender, EventArgs e)
        {
            string idString = txtID.Text;
            if (ValidaId())
            {
                int id = Convert.ToInt32(idString);
                string Nombre = txtNombre.Text;
                if (ValidaNombre())
                {
                    string Apellido = txtApellido.Text;
                    if (ValidaApellido())
                    {
                        string ciudad = cmbCiudad.SelectedItem.ToString();
                        if (ValidaCiudad())
                        {
                            if (!maneja.AgregaEmpleados(id, Nombre, Apellido, ciudad))
                            {
                                MessageBox.Show("Error id duplicado", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                                return;
                            }
                            maneja.AgregaEmpleados(id, Nombre, Apellido, ciudad);
                            MessageBox.Show("Empleado agregado correctamente", "Exito", MessageBoxButtons.OK, MessageBoxIcon.Information);
                            Limpiar();
                        }
                    }                
                }
            }
        }

        private void btnLimpiar_Click(object sender, EventArgs e)
        {
            Limpiar();
        }

        private void btnConsultar_Click(object sender, EventArgs e)
        {
            frmConsulta consulta = new frmConsulta(maneja);
            consulta.ShowDialog();
        }

        private void txtID_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
