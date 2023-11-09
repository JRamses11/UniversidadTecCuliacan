using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Alumnos_CarrerasGUI
{
    public class ManejaCarrera
    {
        private List<Carrera> listCarreras = new List<Carrera>();
        public void AgregaCarrera(int ID, string Nombre, char Estatus)
        {
            listCarreras.Add(new Carrera(ID, Nombre, Estatus));
        }

        public string[] getCarreras()
        {
            string[] arregloNomCarreras = new string[listCarreras.Count];
            int i = 0;
            foreach (Carrera carreras in listCarreras)
            {
                if (carreras.pEstatus.Equals('A'))
                {
                    arregloNomCarreras[i] = carreras.pNombre;
                    i++;
                }
            }
            return arregloNomCarreras;
        }

        public bool ValidaIdDuplicado(int id)
        {
            foreach (Carrera carrera in listCarreras)
            {
                if (carrera.pId == id)
                {
                    return false;
                }
            }
            return true;
        }

        public List<Carrera> getListaCarreras()
        {
            List<Carrera> listCarrerasAux = new List<Carrera>();
            foreach (Carrera carreras in listCarreras)
            {
                listCarrerasAux.Add(carreras);
            }
            return listCarrerasAux;
        }

        public string getNombre(int id)
        {
            string nombre = "";
            foreach (Carrera carreras in listCarreras)
            {
                if (carreras.pId.Equals(id))
                {
                    nombre = carreras.pNombre;
                }
            }
            return nombre;
        }

        public char getEstatus(int id)
        {
            char estatus = ' ';
            foreach (Carrera carreras in listCarreras)
            {
                if (carreras.pId.Equals(id))
                {
                    estatus = carreras.pEstatus;
                }
            }
            return estatus;
        }
    }
}

