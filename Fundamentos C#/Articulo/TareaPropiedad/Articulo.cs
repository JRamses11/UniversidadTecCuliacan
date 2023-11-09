using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TareaPropiedad
{
    class Articulo
    {
        private int ID;
        private string nombre;
        private string marca;
        private int existencia;
        private int precio;

        public Articulo(int ID, string nombre, string marca, int existencia, int precio)
        {
            this.ID = ID;
            this.nombre = nombre;
            this.marca = marca;
            this.existencia = existencia;
            this.precio = precio;
        }

        public int pID
        {
            get
            {
                return ID;
            }
            set
            {

            }
        }

        public string pnombre
        {
            get
            {
                return nombre;
            }
            set
            {

            }
        }

        public string pmarca
        {
            get
            {
                return marca;
            }
            set
            {

            }

        }

        public int pexistencia
        {
            get
            {

            }
            set
            {

            }
        }
    }
}
