using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsolaNomina
{
    public class ManejaEmpleado
    {
        /*
         * ESTA CLASE MANIPULARA EL ARREGLO DE EMPLEADOS
         * SE HARA TODO LO NECESARIO PARA TRABAJAR CON EL ARREGLO
         * NO SE PIDEN DATOS NI MOSTRAR DATOS
         */
        private Empleado[] arregloEmp = new Empleado[10];
        static int valorSigEmpleado = 1000;
        static int pos = 0;

        //RECIBIR LOS PARAMETROS PARA AGG OBEJTOS EMPLEADOS AL ARREGLO
        public bool AgregaEmpleado(string nombre, string domicilio, double sueldo)
        {
            if (pos < arregloEmp.Length)
            {
                valorSigEmpleado += 2;
                Empleado empleado = new Empleado(valorSigEmpleado, nombre, domicilio, sueldo);
                arregloEmp[pos] = empleado;
                pos++;
                return true;
            }
            return false;

        }

        //METODO PARA OBTENER TODO LOS EMPLEADOS
        public string [] ObtenerEmpleados()
        {
            int count = 0;
            string[] arregloString = new string[pos];
            foreach(Empleado item in arregloEmp)
            {
                if (item != null)
                {
                    arregloString[count] = string.Format("Numero Empleado: {0}  Nombre: {1}  Domicilio: {2}  " +
                        "Sueldo Diario: {3}  Dias Laborados {4}", item.pnumeroEmpleado, item.pnombre, item.pdomicilio,
                        item.psueldoDiario, item.pdiasLaborados);
                }
                count++;
            }
            return arregloString;
        }

        public string BuscaEmpleado(string nombre)
        {
            string dato = "";
            for (int i = 0; i < pos; i++)
            {
                if (arregloEmp[i].pnombre.Equals(nombre))
                {
                    dato = arregloEmp[i].ToString();
                    break;
                }
            }
            return dato;
        }
        public bool BuscaNombreEmpleado(string nombre)
        {
            bool existe = false;
            for (int i = 0; i < pos; i++)
            {
                if (arregloEmp[i].pnombre.Equals(nombre))
                {
                    existe = true;
                    break;
                }
            }

            return existe;
        }
        public bool BuscaNumEmpleado(int num)
        {
            bool existe = false;
            for (int i = 0; i < pos; i++)
            {
                if (arregloEmp[i].pnumeroEmpleado.Equals(num))
                {
                    existe = true;
                    break;
                }
            }
            return existe;
        }
        public void AgregaDiasLaborados(int num, int dias)
        {
            for (int i = 0; i < pos; i++)
            {
                if (arregloEmp[i].pnumeroEmpleado.Equals(num))
                {
                    arregloEmp[i].pdiasLaborados=+dias;
                    break;
                }
            }
        }

        public void CalculaDiasLaborados()
        {
            for (int i = 0; i <pos; i++)
            {
                if (arregloEmp[i].pdiasLaborados != 0)
                {
                    arregloEmp[i].psueldoCalculado = (double)(arregloEmp[i].pdiasLaborados * arregloEmp[i].psueldoDiario);
                }
            }
        }
        public double CalculaDiasLaboradosTotal()
        {
            double total= 0;
            for(int i=0; i < pos; i++)
            {
                if (arregloEmp[i].pdiasLaborados != 0)
                {
                    total += arregloEmp[i].psueldoCalculado;
                }
            }
            return total;
        }
        
        public string [] Obtenernomina()
        {
            double total = 0;
            string[] arregloString = new string[pos];
            
            for(int i=0; i<pos; i++)
            {
                if (arregloEmp[i].psueldoCalculado != 0)
                {
                    arregloString[i] = string.Format("Empleado {0} Sueldo Calculado {1}", arregloEmp[i].pnombre, arregloEmp[i].psueldoCalculado);
                    total = arregloEmp[i].psueldoCalculado;
                }
            } 
            return arregloString;
        }

        public void CambiarSueldo(int num, double sueldo)
        {
            for(int i=0; i<pos; i++)
            {
                if (arregloEmp[i].pnumeroEmpleado.Equals(num))
                {
                    arregloEmp[i].psueldoDiario = sueldo;
                    break;
                }
            }
        }


    }
}
