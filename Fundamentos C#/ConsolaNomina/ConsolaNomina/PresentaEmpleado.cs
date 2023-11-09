using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsolaNomina
{
    //SI PIDE DATOS Y LO MUESTRA
    public class PresentaEmpleado
    {
        ManejaEmpleado maneja;
        public PresentaEmpleado(ManejaEmpleado m)
        {
            maneja = m;
        }

        public void Menu()
        {
            bool exit = true;
            do
            {
                Console.WriteLine("-----------MENU----------");
                Console.WriteLine("1. Agregar empleados");
                Console.WriteLine("2. Consultar empleados");
                Console.WriteLine("3  Buscar empleado");
                Console.WriteLine("4. Agregar dias laborados");
                Console.WriteLine("5. Calcular Nomina");
                Console.WriteLine("6. Imprimir nomina");
                Console.WriteLine("7. Cambio Sueldo");
                Console.WriteLine("8. Salir ");
                int eleccion= Convert.ToInt32(Console.ReadLine());
                switch (eleccion)
                {
                    case 1:
                        Console.Clear();
                        AltaEmpleado(); 
                        break;
                    case 2:
                        Console.Clear();
                        MostrarEmpleados();
                        break;
                    case 3:
                        Console.Clear();
                        BuscaEmpleado();
                        break;
                    case 4:
                        Console.Clear();
                        AsignarDiasLaborados();
                        break;
                    case 5:
                        Console.Clear();
                        CalculaNomina();
                        break;
                    case 6:
                        Console.Clear();
                        ImprimeNomina();
                        break;
                    case 7:
                        Console.Clear();
                        CambioSueldo();
                        break;
                    case 8:
                        Console.WriteLine("Byeeeee");
                        exit = false;
                        break;
                    default:
                        Console.Clear();
                        Console.WriteLine("Elije una opcion entre el 1 y 8");
                        break;
                }
            } while (exit);
        }

        public void AltaEmpleado()
        {
            Console.WriteLine("---Alta de empleado---");
            Console.WriteLine("Nombre empleado: ");
            string nombre = Console.ReadLine();
            if (!maneja.BuscaNombreEmpleado(nombre))
            {
                string domicilio = Utilerias.ValidaString("Domicilio: ");

                double sueldo = Utilerias.ValidaDouble("Sueldo: ");

              maneja.AgregaEmpleado(nombre.ToUpper(), domicilio, sueldo);
              Console.WriteLine("Empleado agregado {0}", nombre);
            }
            else
            {
                Console.WriteLine("El nombre ya existe no es posible agregarlo");
            }
            Console.ReadKey();
            Console.Clear();
        }
        public void MostrarEmpleados()
        {
            Console.WriteLine("---EMPLEADOS---");
            string[] arreglo = maneja.ObtenerEmpleados();
            foreach (string item in arreglo)
            {
                Console.WriteLine(item);
            }
            Console.ReadKey();
            Console.Clear();
        }
        public void BuscaEmpleado()
        {
            string nombre = Utilerias.ValidaString("Escribe el nombre del empleado a buscar: ");
            if (maneja.BuscaNombreEmpleado(nombre))
            {
                Console.WriteLine(maneja.BuscaEmpleado(nombre));
            }
            else
            {
                Console.WriteLine("Empleado {0} no existe", nombre);
            }
            Console.ReadKey();
            Console.Clear();
        }

        public void AsignarDiasLaborados()
        {
            int numEmpleado = Utilerias.ValidaNumero("Ingrese el Numero de empleado: ");
            if (maneja.BuscaNumEmpleado(numEmpleado))
            {
                int diaslaborados = Utilerias.ValidaDias("Cuantos días laboró el empleado: ");
                maneja.AgregaDiasLaborados(numEmpleado, diaslaborados);
                Console.WriteLine("---Dias Laborados Agregados Exitosamente---");
            }
            else
            {
                Console.WriteLine("Numero Empleado {0} no existe", numEmpleado);
            }
            Console.ReadKey();
            Console.Clear();
        }

        public void CalculaNomina()
        {
            maneja.CalculaDiasLaborados();

            double total = maneja.CalculaDiasLaboradosTotal();
            Console.WriteLine("Dias laborados en pagar a total {0}", total);

            Console.ReadKey();
            Console.Clear();
        }

        public void ImprimeNomina()
        {
            string[] emp = maneja.Obtenernomina();
            double TotalPagar = maneja.CalculaDiasLaboradosTotal();
            foreach (string item in emp)
            {
                Console.WriteLine(item);
            }
            Console.WriteLine("El total a pagar por empleados es {0} ", TotalPagar);
            Console.ReadKey();
            Console.Clear();
        }
        
        public void CambioSueldo()
        {
            int empleadoNum = Utilerias.ValidaNumero("Ingresa el numero de empleado a modificar: ");
            if (maneja.BuscaNumEmpleado(empleadoNum))
            {
                double sueldoNuevo = Utilerias.ValidaDouble("Ingrese el nuevo sueldo: ");
                maneja.CambiarSueldo(empleadoNum, sueldoNuevo);
            }
            else
            {
                Console.WriteLine("El numero de empleado {0} no existe", empleadoNum);
            }

        }

    }
}
