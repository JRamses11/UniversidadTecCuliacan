using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Arreglos
{
    class Program
    {
        int [] arreVenta = new int [7];
        static void Main(string[] args)
        {
            Program e = new Program();
            int num = 0;
            Console.WriteLine("ELIJE LAS SIGUIENTES OPCIONES");
            Console.WriteLine("1.AGREGAR VENTAS 2.CONSULTAR TOTAL VENDIDO 3.Salir");
            num = Convert.ToInt32(Console.ReadLine());
            do
            {
                num = menu();
                switch (num)
                {
                    case 1:
                        Console.WriteLine("Dia se la semana agregar");
                        int dia = Convert.ToInt32(Console.ReadLine());
                        Console.WriteLine("Ingrese el importe");
                        int impo = Convert.ToInt32(Console.ReadLine());
                        e.AgregaVentas(dia,impo); break;
                    case 2: e.ConsultaTotalVtas(); break;
                    case 3: Console.WriteLine("Seguro que desea salir (Y/N)");
                        char r = Console.ReadLine();
                        if (r != 'Y')
                            num = 10;
                        break;
                }

            } while (num!=3);
            Console.WriteLine("BYE");
        }

        public void AgregaVentas(int pos, int importeVenta)
        {
            //TOMAR LA POSICION DEL ARREGLO Y ACUMULAR LA VENTA
            arreVenta[pos] += importeVenta;
        }

        public int BuscaDia()
        {
            //REGRESAR LA POSICION DEL DIA
            // 1.LUNES, 2.MARTES, 3.MIERCOLES
            //LUNES=0, MARTES=1

            //PEDIR EL DIA
            Console.WriteLine("Dia de la semana a agregar");
            Console.WriteLine("1.-Lunes 2.-Martes 3.-Miercoles 4.-Jueves 5.-Viernes 6.-Sabado 7.-Domingo");
            int dia = Convert.ToInt32(Console.ReadLine());
            while (dia <=0 || dia > 7)
            {
                Console.WriteLine("Dia invalido vuelva a capturar");
                Console.WriteLine("1.-Lunes 2.-Martes 3.-Miercoles 4.-Jueves 5.-Viernes 6.-Sabado 7.-Domingo");
                dia = Convert.ToInt32(Console.ReadLine());
            } 

            return dia--;
        }

        public int PideImporteVenta()
        {
            //PEDIR Y VALIDAR QUE EL IMPORTE SEA MAYOR A CERO 
            //RETORNAR EL IMPORTE
            Console.WriteLine("Ingresa el importe de venta");
            int importe = Convert.ToInt32(Console.ReadLine());
            while (importe <= 0)
            {
                Console.WriteLine("Importe de venta tiene que ser mayor a cero");
                Console.WriteLine("Volver a ingresar el importe");
                importe = Convert.ToInt32(Console.ReadLine());
            }
            return importe;
        }

        public void ConsultaTotalVtas()
        {
            int suma = 0;
            foreach(int item in arreVenta)
            {
                suma = suma + item;
            }
        }

        public void PedirYAgregarVentas()
        {
            Program p = new Program();
            int dia;
            int imp;
            //PEDIR EL DIA (INVOCANDO EL METODO)
            //INVOCAR PIDEIMPORTE
            //AGREGAR VENTAS
            Console.WriteLine("Registra el dia de la semana");
            dia = Convert.ToInt32(Console.ReadLine());
            p.BuscaDia();

            Console.WriteLine("Registra tu importe");
            imp = Convert.ToInt32(Console.ReadLine());
            p.PideImporteVenta();
        }

        public void ConsultarVentaDia()
        {
            Program p = new Program();
            Console.WriteLine("Ingresa el dia a consultar");
            int dia = Convert.ToInt32(Console.ReadLine();
            p.ConsultaTotalVtas();
        }

        public void MostrarDiaMayorVenta()
        {

        }

        public static int menu()
        {
            Console.WriteLine("-----------MENU----------");
            Console.WriteLine("1. Agregar venta");
            Console.WriteLine("2. Consultar Total de Ventas");
            Console.WriteLine("3. Salir");
            Console.WriteLine("Opcion: ");
            int x;
            try
            {
                x = Convert.ToInt32(Console.ReadLine());
            }
            catch (FormatException)
            {
                Console.WriteLine("Escriba un numero");
                x = Convert.ToInt32(Console.ReadLine());
                return 10;
            }
            return x;
        }
        
    }
}
