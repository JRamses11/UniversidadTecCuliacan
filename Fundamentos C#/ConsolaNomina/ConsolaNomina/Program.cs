using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsolaNomina
{
    class Program
    {
        ManejaEmpleado maneja = new ManejaEmpleado();
        public static void Main(string [] args)
        {
            Program main = new Program();
            PresentaEmpleado presenta = new PresentaEmpleado(main.maneja);
            presenta.Menu();
            Console.ReadKey();
        }
    }
}
