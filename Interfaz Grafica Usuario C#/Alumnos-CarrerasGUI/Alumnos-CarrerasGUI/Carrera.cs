using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Alumnos_CarrerasGUI
{
    public class Carrera
    {
        private int ID;
        private string Nombre;
        private char Estatus;

        public Carrera(int id, string nombre, char estatus)
        {
            this.ID = id;
            this.Nombre = nombre;
            this.Estatus = estatus;
        }

        public int pId
        {
            set
            {
                ID = value;
            } 
            get
            {
                return ID;
            }
           
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

        public char pEstatus
        {
            set
            {
                Estatus = value;
            }
            get
            {
                return Estatus;
            }
            
        }
    }
}
