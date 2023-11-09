using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EjercicioClase
{
    class Program
    {
        static void Main(string[] args)
        {
            int value;
            string nombre;
            Console.WriteLine("Registra tu nombre: ");
            nombre = Console.ReadLine();
            Console.WriteLine("Tu nombre es {0} ", nombre.ToUpper());
            value = nombre.Length();

            if (nombre.Length % 2 = 0)
            {
                Console.WriteLine("Tu nombre es par");
            }
            else
            {
                Console.WriteLine("Tu nombre es impar");
            }
            Console.ReadKey();
        }
    }
}
