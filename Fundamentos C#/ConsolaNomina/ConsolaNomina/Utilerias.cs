using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsolaNomina
{
    public class Utilerias
    {
        public static string ValidaString(string mensaje)
        {
            string cadena = "";
            do
            {
                Console.Write(mensaje);
                cadena = Console.ReadLine();
            } while (string.IsNullOrEmpty(cadena));

            return cadena.ToUpper();
        }

        public static int ValidaNumero(string mensaje)
        {
            int n = 0;
            string num;
            bool esNum;
            do
            {
                Console.Write(mensaje);
                num= Console.ReadLine();
                esNum = int.TryParse(num, out n);

            } while (!esNum);

            return n;
        }

        public static double ValidaDouble(string mensaje)
        {
            double d = 0;
            string Double;
            bool esDouble;
            do
            {
                Console.Write(mensaje);
                Double = Console.ReadLine();
                esDouble = double.TryParse(Double, out d);

            } while (!esDouble);

            return d;
        }

        public static double ValidaSueldo(string mensaje)
        {
            double sueldo = 0;
            do
            {
                sueldo = ValidaDouble(mensaje);

            } while (sueldo <= 0);

            return sueldo;
        }

        public static int ValidaDias(string mensaje)
        {
            int dias = 0;
            do
            {
                dias = ValidaNumero(mensaje);

            } while (dias <= 0 || dias > 16);

            return dias;
        }
    }
}
