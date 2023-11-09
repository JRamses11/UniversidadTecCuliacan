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
    public partial class frmAlumnos : Form
    {
        private ManejaAlumno manejaAlumno;
        private ManejaCarrera manejaCarrera;
        public frmAlumnos(ManejaAlumno a, ManejaCarrera c)
        {
            InitializeComponent();
            this.manejaAlumno = a;
            this.manejaCarrera = c;
        }

        private void frmAlumnos_Load(object sender, EventArgs e)
        {
            txtNControl.Text = manejaAlumno.CalculaNumero().ToString();
            AgregaCarrerasCMB();
        }

        public bool ValidaCarrera()
        {
            bool retorno = true;
            if (cmbCarrera.Text.Equals("SELECCIONAR"))
            {
                retorno = false;
                errP1.SetError(cmbCarrera, "ERROR FALTA SELECCIONAR UNA CARRERA");
            }
            if (cmbCarrera.Text.Equals(""))
            {
                    retorno = false;
                    errP1.SetError(cmbCarrera, "ERROR NO SELECCIONO UNA CARRERA");
            }      
            return retorno;
        }

        public bool ValidaNombre()
        {
            bool retorno = true;
            if (txtNombre.Text.Equals(""))
            {
                retorno = false;
                errP1.SetError(txtNombre, "ERROR FALTA CAPTURAR EL NOMBRE");
            }
            else
            {
                if (int.TryParse(txtNombre.Text, out int num))
                {
                    retorno = false;
                    errP1.SetError(txtNombre, "ERROR EN CAPTURA DE NOMBRE");
                }
            }
            return retorno;
        }

        public bool ValidaDomicilio()
        {
            bool retorno = true;
            if (txtDomicilio.Text.Equals(""))
            {
                retorno = false;
                errP1.SetError(txtDomicilio, "ERROR FALTA DE CAPTURAR EL DOMICILIO");
            }
            else
            {
                if (int.TryParse(txtDomicilio.Text, out int num))
                {
                    retorno = false;
                    errP1.SetError(txtDomicilio, "ERROR EN CAPTURA DE DOMICILIO");
                }
            }
            return retorno;
        }

        public bool ValidaEdad()
        {
            bool retorno = true;
            if (numEdad.Value < 17)
            {
                retorno = false;
                errP1.SetError(numEdad, "ERROR LA EDAD MINIMA DE INGRESO ES DE 17 AÑOS");
            }
            return retorno;
        }

        public bool Validatexto(string cadena)
        {
            if(string.IsNullOrWhiteSpace(cadena) || string.IsNullOrEmpty(cadena))
            {
                return false;
            }
            return true;
        }

        private void btnGuardar_Click(object sender, EventArgs e)
        {
            long NoControl = long.Parse(txtNControl.Text);
            if (ValidaCarrera())
            {
                string carrera = cmbCarrera.SelectedItem.ToString();
                string nombre = txtNombre.Text;
                if (manejaAlumno.BuscarNombreAlum(nombre))
                {
                    MessageBox.Show("ERROR DUPLICADO", "ERROR", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
                else
                {
                    if (ValidaNombre())
                    {
                        string domicilio = txtDomicilio.Text;
                        if (ValidaDomicilio())
                        {
                            decimal edad = numEdad.Value;
                            if (ValidaEdad())
                            {
                                string sexo = "";
                                if (rbMasculino.Checked)
                                {
                                    sexo = rbMasculino.Text;
                                }
                                else
                                {
                                    sexo = rbFemenino.Text;
                                }
                                manejaAlumno.AgregaAlumno(NoControl, nombre, domicilio, edad, carrera, sexo);
                                txtNControl.Text = manejaAlumno.CalculaNumero().ToString();
                                MessageBox.Show("Alumno agregado correctamente", "Exito", MessageBoxButtons.OK, MessageBoxIcon.Information);
                                Limpiar();
                            }
                        }
                    }
                }
            }
        }
    
        public void Limpiar()
        {
            txtNombre.Text = "";
            txtDomicilio.Text = "";
        }

        private void btnLimpiar_Click(object sender, EventArgs e)
        {
            Limpiar();
        }

        private void btnConsultar_Click(object sender, EventArgs e)
        {
            frmConsultaAlumnos frmConsulta = new frmConsultaAlumnos(manejaAlumno);
            frmConsulta.ShowDialog();
        }

        private void btnAgregarCarrera_Click(object sender, EventArgs e)
        {
            frmAgregaCarrera agregarCarrera = new frmAgregaCarrera(manejaCarrera);
            agregarCarrera.ShowDialog();
            AgregaCarrerasCMB();
        }

        public void AgregaCarrerasCMB()
        {
            string[] arregloCarreras = manejaCarrera.getCarreras();
            cmbCarrera.DataSource = arregloCarreras;
        }

        private void txtNombre_Validated(object sender, EventArgs e)
        {
            string dato = txtNombre.Text;
            if (!Validatexto(dato))
            {
                errP1.SetError(txtNombre, "SOLO SE ADMITEN LETRAS");
                txtNombre.Focus();
            }
            else
            {
                errP1.SetError(txtNombre, "");
            }
        }

        private void txtNombre_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!(char.IsLetter(e.KeyChar)) &&
                    (e.KeyChar != (char)Keys.Back) && !(char.IsWhiteSpace(e.KeyChar)))
            {
                errP1.SetError(txtNombre, "SOLO SE PERMITE LETRAS");
                e.Handled = true;
            }
            else
            {
                errP1.SetError(txtNombre, "");
            }
        }

        private void txtDomicilio_Validated(object sender, EventArgs e)
        {
            string dato = txtDomicilio.Text;
            if (!Validatexto(dato))
            {
                errP1.SetError(txtDomicilio, "SOLO ADMITE LETRAS");
                txtDomicilio.Focus();
            }
            else
            {
                errP1.SetError(txtDomicilio, "");
            }

        }

        private void txtDomicilio_KeyPress(object sender, KeyPressEventArgs e)
        {
            if (!(char.IsLetter(e.KeyChar)) &&
                   (e.KeyChar != (char)Keys.Back) && !(char.IsWhiteSpace(e.KeyChar)) &&
                   !(char.IsNumber(e.KeyChar)))
            {
                errP1.SetError(txtDomicilio, "SOLO SE PERMITE LETRAS");
                e.Handled = true;
            }
            else
            {
                errP1.SetError(txtDomicilio, "");
            }
        }
    }
}
