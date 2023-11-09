using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using LibreriaBD;   

namespace CitasMedicasGUI
{
    public partial class frmConsultaIndividualCitas : Form
    {
        public frmConsultaIndividualCitas()
        {
            InitializeComponent();
        }

        private void frmConsultaIndividualCitas_Load(object sender, EventArgs e)
        {
            string conecta = "Data Source=DESKTOP-GNJIN56;Initial Catalog=CLINICAMEDICA;Integrated Security=True";
            SqlConnection con = UsoBD.ConectaBD(conecta);


            string strComando = "SELECT CLAVECITA FROM CITAMEDICA";
            SqlDataReader lector = UsoBD.Consulta(strComando, con);
            if (lector.HasRows)
            {
                cmbClaveCita.Items.Clear();
                while (lector.Read())
                {
                    cmbClaveCita.Items.Add(lector.GetValue(0).ToString());
                }
            }
        }

        private void cmbClaveCita_SelectedIndexChanged(object sender, EventArgs e)
        {
            string clave = cmbClaveCita.SelectedItem.ToString();
            string conecta = "Data Source=DESKTOP-GNJIN56;Initial Catalog=CLINICAMEDICA;Integrated Security=True";
            SqlConnection con = UsoBD.ConectaBD(conecta);

            string strComando = "SELECT CLAVEMEDICO, NOMBRE, FECHA, HORA, NOMBREPACIENTE, TELEFONOPACIENTE, OBSERVACIONES " +
                "FROM CITAMEDICA CM INNER JOIN MEDICO M ON CM.CLAVEMEDICO = M.CLAVE WHERE CLAVECITA=" + clave;
            SqlDataReader lector = UsoBD.Consulta(strComando, con);
            if (lector.HasRows)
            {
                while (lector.Read())
                {
                    txtClaveMedico.Text = lector.GetValue(0).ToString();
                    txtNombreMedico.Text = lector.GetValue(1).ToString();
                    txtFecha.Text = lector.GetValue(2).ToString();
                    txtHora.Text = lector.GetValue(3).ToString();
                    txtNombrePaciente.Text = lector.GetValue(4).ToString();
                    txtTelefonoPaciente.Text = lector.GetValue(5).ToString();
                    txtObservaciones.Text = lector.GetValue(6).ToString();
                }
            }
        }
    }
}
