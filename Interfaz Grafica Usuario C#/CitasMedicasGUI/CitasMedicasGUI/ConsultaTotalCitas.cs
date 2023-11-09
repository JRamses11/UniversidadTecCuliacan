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
    public partial class frmConsultaTotalCitas : Form
    {
        public frmConsultaTotalCitas()
        {
            InitializeComponent();
        }

        private void frmConsultaTotalCitas_Load(object sender, EventArgs e)
        {
            string conecta = "Data Source=DESKTOP-GNJIN56;Initial Catalog=CLINICAMEDICA;Integrated Security=True";
            SqlConnection con =UsoBD.ConectaBD(conecta);

            string strComando = "select CLAVECITA, CLAVEMEDICO, NOMBRE, FECHA, HORA, NOMBREPACIENTE, TELEFONOPACIENTE, OBSERVACIONES " +
                "FROM CITAMEDICA CM INNER JOIN MEDICO M ON CM.CLAVEMEDICO = M.CLAVE";
            SqlDataReader lector =UsoBD.Consulta(strComando, con);
            if (lector.HasRows)
            {
                while (lector.Read())
                {
                    dgvCitas.Rows.Add(lector.GetValue(0), lector.GetValue(1), lector.GetValue(2),
                        lector.GetValue(3), lector.GetValue(4), lector.GetValue(5), lector.GetValue(6), lector.GetValue(7));
                }
            }

        }
    }
}
