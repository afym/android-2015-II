using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace MisServicios
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Temperatura" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select Temperatura.svc or Temperatura.svc.cs at the Solution Explorer and start debugging.
    public class Temperatura : ITemperatura
    {
        public double CelsiusToFahrenheit(string t) 
        {
            return (this.GetDouble(t) * (9 / 5)) + 32;
        }

        public double FahrenheitToCelsius(string t) 
        {
            return (this.GetDouble(t) - 32) * (5 / 9);
        }

        public double CelsiusToKelvin(string t) 
        {
            return this.GetDouble(t) + 273.15;
        }

        private double GetDouble(string t) 
        {
            return Convert.ToDouble(t);
        }
    }
}
