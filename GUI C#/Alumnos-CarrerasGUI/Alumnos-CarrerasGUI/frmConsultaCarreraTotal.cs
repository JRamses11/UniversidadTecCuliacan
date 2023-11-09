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
    public partial class frmConsultaCarreraTotal : Form
    {
        ManejaCarrera maneja;
        public frmConsultaCarreraTotal(ManejaCarrera maneja)
        {
            InitializeComponent();
            this.maneja = maneja;
        }

        private void frmConsultaCarreraTotal_Load(object sender, EventArgs e)
        {
            List<Carrera> lista = maneja.getListaCarreras();
            foreach (Carrera carrera in lista)
            {
                dgvCarreras.Rows.Add(carrera.pId, carrera.pNombre, carrera.pEstatus);
            }
        }
    }
}
