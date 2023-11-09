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
    public partial class frmConsultaAlumnos : Form
    {
        ManejaAlumno maneja;
        public frmConsultaAlumnos(ManejaAlumno maneja)
        {
            InitializeComponent();
            this.maneja = maneja;
        }

        private void frmConsultaAlumnos_Load(object sender, EventArgs e)
        {
            List<Alumno> lista = maneja.ListaAlumnos();
            List<long> listaIds = maneja.ListaIds();
            int i = 0;
            foreach (Alumno alumno in lista)
            {
                dgvAlumnos.Rows.Add(listaIds[i], alumno.pNombre, alumno.pDomicilio, alumno.pEdad, alumno.pCarrera, alumno.pSexo);
                i++;
            }
        }
    }
}
