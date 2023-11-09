using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
/*
 * ALUMNO: ALDAMA CAZARES JOSE RAMSES
 * MATERIA: TOPICOS AVANZADOS DE PROGRAMACION
 * DOCENTE: GLORIA EKATERINE PERALTA PEÑUÑURI
 * HORA: 12:00-13:00
 **/
namespace ArregloSimple
{
    class Program
    {
        static string[] cadena = new string[5];
        static int cont;

        static void Main(string[] args)
        {
            bool exit = false;
            int op;
            do
            {
                op = menu();
                switch (op)
                {
                    case 1:
                        AgregarCadena();
                        break;
                    case 2:
                        BorrarCadena();
                        break;
                    case 3:
                        ImprimeCadena();
                        break;
                    case 4:
                        Console.WriteLine("Hasta luego!");
                        exit = true;
                        break;
                    default:
                        Console.WriteLine("Elije una opcion entre el 1 y 4");
                        break;
                }
            } while (!exit);
                Console.ReadKey();
        }

        public static int menu()
        {
            Console.WriteLine("-----------MENU----------");
            Console.WriteLine("1. Agrega al arreglo");
            Console.WriteLine("2. Elimina al arreglo");
            Console.WriteLine("3 Imprime al arreglo");
            Console.WriteLine("4. Salir");
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

        public static void AgregarCadena()
        {
              string agg;
              do
              {
                  Console.WriteLine("Ingrese una cadena de mas de 10 caracteres");
                  agg = Console.ReadLine();
              }while (agg.Length <= 10);
              if (cont < 5)
              {
                cadena[cont] = agg;
                cont++;
              }           
        }

        public static void BorrarCadena()
        {
            int pos = 0;
            Console.WriteLine("Valor de la cadena a eliminar");
            string cad = Console.ReadLine();
            for (int i = 0; i < cadena.Length; i++)
            {
                if (cad.Equals(cadena[i]))
                {
                    pos = i;
                    cadena[i] = null;
                }
            }
            for(int j=pos; j < cadena.Length-1; j++)
            {
                cadena[j] = cadena[j + 1];
            }
            cadena[cadena.Length - 1] = null;
            cont--;
        }

        public static void ImprimeCadena()
        {
            foreach (string val in cadena)
            {
                if (val != null)
                {
                  Console.WriteLine($"Su valor es: {val.ToLower()}");
                }  
            }
        }
    }
}
