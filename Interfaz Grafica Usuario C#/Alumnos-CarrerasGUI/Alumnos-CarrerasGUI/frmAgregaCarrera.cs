using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Alumnos_CarrerasGUI
{
    public partial class frmAgregaCarrera : Form
    {
        ManejaCarrera manejaCarrera;
        public frmAgregaCarrera(ManejaCarrera manejaCarrera)
        {
            InitializeComponent();
            this.manejaCarrera = manejaCarrera;
        }

        public bool ValidaId()
        {
            try
            {
                int id = Convert.ToInt32(txtID.Text);
                return true;
            } catch
            {
                return false;
            }
        }

        public bool ValidaNombre(string nombre)
        {
            if (nombre.Length == 0 || nombre.StartsWith(" "))
            {
                return false;
            }
            return true;
        }

        public void Limpiar()
        {
            chkActiva.Checked = false;
            txtID.Text = "";
            txtNombreCarrera.Text = "";
        }

        
        public bool ValidaTexto(string cadena) 
        {
            if(string.IsNullOrWhiteSpace(cadena) || string.IsNullOrEmpty(cadena))
            {
                return false;
            }
            return true;
        }
        private void btnGuardar_Click(object sender, EventArgs e)
        {
            char estatus = 'C';
            if (chkActiva.Checked)
            {
                estatus = 'A';
            }
            if (!ValidaId())
            {
                errp2.SetError(txtID, "ERROR EN INGRESAR ID");
                return;
            }
            int id = Convert.ToInt32(txtID.Text);
            if (!manejaCarrera.ValidaIdDuplicado(id))
            {
                MessageBox.Show("ERROR ID DUPLICADO", "ERROR", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
            string nombre = txtNombreCarrera.Text.ToString();
            if (!ValidaNombre(nombre))
            {
                errp2.SetError(txtNombreCarrera, "ERROR EN INGRESAR NOMBRE");
                return;
            }
            manejaCarrera.AgregaCarrera(id,nombre,estatus);
            MessageBox.Show("AGREGADO EXITOSAMENTE", "MENSAJE", MessageBoxButtons.OK, MessageBoxIcon.Information);
            Limpiar();
        }

        private void btnLimpiar_Click(object sender, EventArgs e)
        {
            Limpiar();
        }

        private void btnConsultar_Click(object sender, EventArgs e)
        {
            frmConsultaCarreraTotal consultaCarreraTotal = new frmConsultaCarreraTotal(manejaCarrera);
            consultaCarreraTotal.ShowDialog();
        }

        private void txtID_KeyPress(object sender, KeyPressEventArgs e)
        {
            if(!(char.IsNumber(e.KeyChar)) &&
                    (e.KeyChar != (char)Keys.Back))
            {
                errp2.SetError(txtID, "SOLO SE PERMITE NUMEROS");
                e.Handled = true;
            }
            else
            {
                errp2.SetError(txtID, "");
            }

        }

        private void txtID_Validated(object sender, EventArgs e)
        {
            if (!ValidaNumero())
            {
                errp2.SetError(txtID, "ERROR ID");
                txtID.Focus();
            }
            else
            {
                errp2.SetError(txtID, "");
            }
        }

        private void txtNombreCarrera_Validated(object sender, EventArgs e)
        {
            string dato = txtNombreCarrera.Text;
            if (!ValidaTexto(dato))
            {
                errp2.SetError(txtNombreCarrera, "NOMBRE VACIO");
                txtNombreCarrera.Focus();
            }
            else
            {
                errp2.SetError(txtNombreCarrera, "");
            }
        }

        private void txtNombreCarrera_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!(char.IsLetter(e.KeyChar)) &&
                    (e.KeyChar != (char)Keys.Back) && !(char.IsWhiteSpace(e.KeyChar)))
            {
                errp2.SetError(txtNombreCarrera, "SOLO SE PERMITE LETRAS");
                e.Handled = true;
            }
            else
            {
                errp2.SetError(txtNombreCarrera, "");
            }
        }

        private void frmAgregaCarrera_Load(object sender, EventArgs e)
        {

        }
    }
}
