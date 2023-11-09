using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data.SqlClient;
using System.Windows.Forms;
using LibreriaBD;
namespace CitasMedicasGUI
{
    public partial class frmClinicaMedica : Form
    {
        public frmClinicaMedica()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            string conexion = "Data Source=DESKTOP-GNJIN56;Initial Catalog=CLINICAMEDICA;Integrated Security=True";
            SqlConnection con = UsoBD.ConectaBD(conexion);

            string strComando = "select clave from Medico";
            SqlDataReader lector = UsoBD.Consulta(strComando, con);

            if (lector.HasRows)
            {
                cmbClave.Items.Clear();
                while (lector.Read())
                {
                    cmbClave.Items.Add(lector.GetValue(0).ToString());
                }
            }
        }

        private void cmbClave_SelectedIndexChanged(object sender, EventArgs e)
        {
            string clave = cmbClave.SelectedItem.ToString();
            string conexion = "Data Source=DESKTOP-GNJIN56;Initial Catalog=CLINICAMEDICA;Integrated Security=True";
            SqlConnection con = UsoBD.ConectaBD(conexion);

            string strComando = "select nombre, especialidad, subespecialidad, telefono, consultorio from Medico where clave="+clave;
            SqlDataReader lector = UsoBD.Consulta(strComando, con);

            if (lector.HasRows)
            {
                while (lector.Read())
                {
                    txtNombre.Text=lector.GetValue(0).ToString();
                    txtEspecialidad.Text = lector.GetValue(1).ToString();
                    txtSubespecialidad.Text= lector.GetValue(2).ToString();
                    txtTelefono.Text= lector.GetValue(3).ToString();
                    txtConsultorio.Text=lector.GetValue(4).ToString();
                }
            }
        }
    }
}
