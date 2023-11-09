using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DatosEmpleadosGUI
{
    public class Empleado
    {
        private string Nombre;
        private string Apellido;
        private string Ciudad;

        public Empleado(string Nombre, string Apellido, string Ciudad)
        {
            this.Nombre = Nombre;
            this.Apellido = Apellido;
            this.Ciudad = Ciudad;
        }

        public string pNombre
        {
            set
            {
                Nombre = value;
            }
            get
            {
                return Nombre;
            }
        }

        public string pApellido
        {
            set
            {
                Apellido = value;
            }
            get
            {
                return Apellido;
            }
        }

        public string pCiudad
        {
            set
            {
                Ciudad = value;
            }
            get
            {
                return Ciudad;
            }
        }

    }
}
