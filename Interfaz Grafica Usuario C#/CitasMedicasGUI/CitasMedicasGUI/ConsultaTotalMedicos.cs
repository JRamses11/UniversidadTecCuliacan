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
    public partial class frmConsultaTotalMedicos : Form
    {
        public frmConsultaTotalMedicos()
        {
            InitializeComponent();
        }

        private void frmConsultaTotalMedicos_Load(object sender, EventArgs e)
        {
            string conecta = "Data Source=DESKTOP-GNJIN56;Initial Catalog=CLINICAMEDICA;Integrated Security=True";
            SqlConnection con = UsoBD.ConectaBD(conecta);

            string strComando = "select clave, nombre, especialidad, subespecialidad, telefono, consultorio from Medico";
            SqlDataReader lector = UsoBD.Consulta(strComando, con);
            if (lector.HasRows)
            {
                while (lector.Read())
                {
                    dgvMedicos.Rows.Add(lector.GetValue(0), lector.GetValue(1), lector.GetValue(2),
                        lector.GetValue(3), lector.GetValue(4), lector.GetValue(5));
                }
            }

        }
    }
}
