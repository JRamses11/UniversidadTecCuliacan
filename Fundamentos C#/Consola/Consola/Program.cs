using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Consola
{
    class Program
    {
        static void Main(string[] args)
        {
            Program p = new Program();
            int valor;
            Console.WriteLine("Proporciona un numero: ");
            // valor=p.ValidaNumero(0);  OTRA FORMA DE SOLUCIONAR

            valor = Convert.ToInt32(Console.ReadLine());
            valor = p.ValidaNumero(valor);

            valor =Convert.ToInt32(Console.ReadLine());
            p.PresentaNumero(valor);

            Console.ReadKey();
            //VALIDAR QUE SEA MAYOR DE 10
        }
        
        public int ValidaNumero(int num)
        {
            int valor = num;
            do
            {
                Console.WriteLine("Proporciona un numero: ");
                valor = Convert.ToInt32(Console.ReadLine());

            } while(valor<=10);
            return valor;
        }

        public void PresentaNumero(int val)
        {
            int suma = 0;
            for (int i = val; i >= 0, i--)
            {
                Console.WriteLine("Valor de i:= {0}",i);
                suma = suma + 1;
            }
            Console.WriteLine("La suma es {0} ", suma);

    }
}
