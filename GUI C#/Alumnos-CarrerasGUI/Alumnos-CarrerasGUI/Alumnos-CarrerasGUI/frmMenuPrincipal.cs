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
    public partial class frmMenuPrincipal : Form
    {
        ManejaAlumno manejaAlumno;
        ManejaCarrera manejaCarrera;
        public frmMenuPrincipal(ManejaAlumno manejaAlumno, ManejaCarrera manejaCarrera)
        {
            InitializeComponent();
            this.manejaAlumno = manejaAlumno;
            this.manejaCarrera = manejaCarrera;
        }

        private void frmMenuPrincipal_Load(object sender, EventArgs e)
        {

        }

        private void salirToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void agregarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            frmAgregaCarrera agregaCarrera = new frmAgregaCarrera(manejaCarrera);
            agregaCarrera.ShowDialog();
        }

        private void agregarToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            frmAlumnos agregaAlumnos = new frmAlumnos(manejaAlumno, manejaCarrera);
            agregaAlumnos.ShowDialog();
        }

        private void consultarToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            
        }

        private void carreraToolStripMenuItem_Click(object sender, EventArgs e)
        {
            
        }

        private void todosToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            frmConsultaAlumnos consultaAlumnos = new frmConsultaAlumnos(manejaAlumno);
            consultaAlumnos.ShowDialog();
        }

        private void individualToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            frmConsultaAlumnoIndividual consultaAlumnoIndividual = new frmConsultaAlumnoIndividual(manejaAlumno);
            consultaAlumnoIndividual.ShowDialog();
        }

        private void todosToolStripMenuItem_Click(object sender, EventArgs e)
        {
            frmConsultaCarreraTotal consultaCarreraTotal = new frmConsultaCarreraTotal(manejaCarrera);
            consultaCarreraTotal.ShowDialog();
        }

        private void individualToolStripMenuItem_Click(object sender, EventArgs e)
        {
            frmConsultaCarreraIndividual consultaCarreraIndividual = new frmConsultaCarreraIndividual(manejaCarrera);
            consultaCarreraIndividual.ShowDialog();
        }
    }
}
