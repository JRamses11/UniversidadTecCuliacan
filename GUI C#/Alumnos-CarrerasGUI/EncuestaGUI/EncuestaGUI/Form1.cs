using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace EncuestaGUI
{
    public partial class frmPrincipal : Form
    {
        public frmPrincipal()
        {
            InitializeComponent();
        }
        int[] votos = new int[100];
        private void cmbSeleccion_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void btnVotar_Click(object sender, EventArgs e)
        {
            int opcionSelecc = cmbSeleccion.SelectedIndex;
            votos[opcionSelecc]++;
            MessageBox.Show("Se guardo el voto", "Voto", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }

        private void btnFinalizar_Click(object sender, EventArgs e)
        {
            int maxVotos = -1;
            List<int> empate = new List<int>();

            for (int i = 0; i < 5; i++)
            {
                if (votos[i] > maxVotos)
                {
                    maxVotos = votos[i];
                    empate.Clear();
                    empate.Add(i);
                }
                else if (votos[i] == maxVotos)
                {
                    empate.Add(i);
                }
            }

            if (empate.Count == 1)
            {
                string equipo = cmbSeleccion.Items[empate[0]].ToString();
                string mensaje = "El equipo de futbol ganador es: " + equipo + " con " + maxVotos + " votos";
                MessageBox.Show(mensaje);
            }
            else
            {
                string mensaje = "Se ha producido un empate entre los equipos de futbol\n";
                foreach (int indiceMarca in empate)
                {
                    string equipoEmpate = cmbSeleccion.Items[indiceMarca].ToString();
                    mensaje += equipoEmpate + "\n";
                }
                mensaje += "Cada una obtuvo " + maxVotos + " votos.";
                MessageBox.Show(mensaje);
            }
        }
    }
}
