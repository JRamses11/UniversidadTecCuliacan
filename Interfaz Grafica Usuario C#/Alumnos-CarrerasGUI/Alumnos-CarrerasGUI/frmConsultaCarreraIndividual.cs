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
    public partial class frmConsultaCarreraIndividual : Form
    {
        ManejaCarrera maneja;
        public frmConsultaCarreraIndividual(ManejaCarrera maneja)
        {
            InitializeComponent();
            this.maneja = maneja;
        }

        private void frmConsultaCarreraIndividual_Load(object sender, EventArgs e)
        {
            List<Carrera> listaIDs = maneja.getListaCarreras();
            foreach (Carrera item in listaIDs)
            {
                cmbID.Items.Add(item.pId);
            }
        }

        private void cmbID_SelectedIndexChanged(object sender, EventArgs e)
        {
            int id = Convert.ToInt32(cmbID.SelectedItem);
            List<Carrera> listaCarrera = maneja.getListaCarreras();
            txtCarrera.Text = maneja.getNombre(id);
            txtEstatus.Text = maneja.getEstatus(id).ToString();
        }
    }
}
