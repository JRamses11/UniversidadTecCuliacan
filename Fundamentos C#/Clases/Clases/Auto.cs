using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Clases
{
    class Auto
    {
        private string numSerie;
        private string description;
        private int modelo;
        private string marca;

        public Auto(string serie, string desc, int modelo, string marca)
        {
            numSerie = serie;
            description = desc;
            modelo = modelo;
            marca = marca;
        }

        public string pnumSerie
        {
            set
            {
                numSerie = value;
            }
            get
            {
                return numSerie;
            }
        }

        public string pdescription
        {
            set
            {
                description = value;
            }
            get
            {
                return description;
            }
        }

        public int pmodelo
        {
            set
            {
                modelo = value;
            }
            get
            {
                return modelo;
            }
        }

        public string pmarca
        {
            set
            {
                marca = value;
            }
            get
            {
                return marca;
            }
        }

        
        
    }
}
