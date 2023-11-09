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
    public partial class frmConsultaAlumnoIndividual : Form
    {
        ManejaAlumno maneja;
        public frmConsultaAlumnoIndividual(ManejaAlumno maneja)
        {
            InitializeComponent();
            this.maneja = maneja;
        }

        private void frmConsultaAlumnoIndividual_Load(object sender, EventArgs e)
        {
            List<long> listaIDs = maneja.ListaIds();
            foreach (long item in listaIDs)
            {
                cmbNumControl.Items.Add(item);
            }
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            int nControl = Convert.ToInt32(cmbNumControl.SelectedItem);
            Dictionary<long, Alumno> dicAlumnos = maneja.DicAlumnos();
            txtNombre.Text = dicAlumnos[nControl].pNombre;
            txtDomicilio.Text = dicAlumnos[nControl].pDomicilio;
            txtEdad.Text = dicAlumnos[nControl].pEdad.ToString();
            txtSexo.Text = dicAlumnos[nControl].pSexo;
            txtCarrera.Text = dicAlumnos[nControl].pCarrera;
        }

        private void lblNumCon_Click(object sender, EventArgs e)
        {

        }
    }
}
