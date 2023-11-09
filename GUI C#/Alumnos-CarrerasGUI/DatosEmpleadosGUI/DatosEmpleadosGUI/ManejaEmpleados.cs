using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DatosEmpleadosGUI
{
    public class ManejaEmpleados
    {
        Dictionary<int, Empleado> DicEmpleados = new Dictionary<int, Empleado>();

        public bool AgregaEmpleados(int id, string Nombre, string Apellido, string Ciudad)
        {
            bool retorno = false;
            bool busca =BuscarId(id);
            if (busca==false)
            {
                DicEmpleados.Add(id, new Empleado(Nombre, Apellido, Ciudad));
                retorno = true;
            }
            return retorno;
        }

        public bool BuscarId(int id)
        {
            return DicEmpleados.ContainsKey(id);
        }

        public int [] RegresaID()
        {
            int[] arreglo = new int[DicEmpleados.Count];
            int pos = 0;
            foreach (int elemento in DicEmpleados.Keys)
            {
                arreglo[pos] = elemento;
                pos++;
            }

            return arreglo;
        }

        public Empleado ObtenerValores(int id)
        {
            // Buscar el elemento con el ID seleccionado en el Dictionary
            if (DicEmpleados.TryGetValue(id, out var empleado))
            {
                return empleado;
            }
            return null;
        }
    }
}
