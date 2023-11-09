using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CitasMedicasGUI
{
    public partial class frmClinica_Medica : Form
    {
        public frmClinica_Medica()
        {
            InitializeComponent();
        }

        private void consultaIndividualToolStripMenuItem_Click(object sender, EventArgs e)
        {
            frmClinicaMedica consultaIndividual = new frmClinicaMedica();
            consultaIndividual.ShowDialog();
        }

        private void consultaTotalToolStripMenuItem_Click(object sender, EventArgs e)
        {
            frmConsultaTotalMedicos consultaTotal = new frmConsultaTotalMedicos();
            consultaTotal.ShowDialog();
        }

        private void frmClinica_Medica_Load(object sender, EventArgs e)
        {

        }

        private void individualToolStripMenuItem_Click(object sender, EventArgs e)
        {
            frmClinicaMedica consultaIndividual = new frmClinicaMedica();
            consultaIndividual.ShowDialog();
        }

        private void totalToolStripMenuItem_Click(object sender, EventArgs e)
        {
            frmConsultaTotalMedicos consultaTotal = new frmConsultaTotalMedicos();
            consultaTotal.ShowDialog();
        }

        private void individualToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            frmConsultaIndividualCitas consultaInd = new frmConsultaIndividualCitas();
            consultaInd.ShowDialog();
        }

        private void totalToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            frmConsultaTotalCitas consultaT = new frmConsultaTotalCitas();
            consultaT.ShowDialog();
        }
    }
}
