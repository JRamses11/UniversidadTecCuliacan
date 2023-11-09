using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsolaNomina
{
    public class Empleado
    {
        private int NumEmpleado;
        private string Nombre;
        private string Domicilio;
        private int DiasLaborados;
        private double SueldoDiario;
        private double SueldoCalculado;

        public Empleado(int NumEmpleado,string nombre, string domicilio, double sueldo)
        {
            this.NumEmpleado = NumEmpleado;
            this.Nombre = nombre;
            this.Domicilio = domicilio;
            this.SueldoDiario = sueldo;
        }

        public string pnombre
        {
            get
            {
                return Nombre;
            }
            set
            {
                Nombre=value;
            }
        }

        public string pdomicilio
        {
            get
            {
                return Domicilio;
            }
            set
            {
                Domicilio = value;
            }
        }

        public int pnumeroEmpleado
        {
            get
            {
                return NumEmpleado;
            }
            set
            {
                NumEmpleado = value;
            }
        }

        public int pdiasLaborados
        {
            get
            {
                return DiasLaborados;
            }
            set
            {
                DiasLaborados = value;
            }

        }

        public double psueldoDiario
        {
            get
            {
                return SueldoDiario;
            }
            set
            {
                SueldoDiario = value;
            }
        }

        public double psueldoCalculado
        {
            get
            {
                return SueldoCalculado;
            }
            set
            {
                SueldoCalculado = value;
            }
        }
        public override string ToString()
        {
            return string.Format("Numero Empleado: {0}  Nombre: {1}  Domicilio: {2}  " +
                "Sueldo Diario: {3}  Dias Laborados: {4}", NumEmpleado, Nombre, Domicilio, SueldoDiario, DiasLaborados);
        }
    }
}
