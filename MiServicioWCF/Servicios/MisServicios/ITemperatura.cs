using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace MisServicios
{
    [ServiceContract]
    public interface ITemperatura
    {
        [OperationContract]
        [WebInvoke(Method = "GET", UriTemplate = "/CelsiusToFahrenheit/{t}",
            RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Wrapped)]
        double CelsiusToFahrenheit(string t);
        [OperationContract]
        [WebInvoke(Method = "GET", UriTemplate = "/FahrenheitToCelsius/{t}",
            RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Wrapped)]
        double FahrenheitToCelsius(string t);
        [OperationContract]
        [WebInvoke(Method = "GET", UriTemplate = "/CelsiusToKelvin/{t}",
            RequestFormat = WebMessageFormat.Json, ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Wrapped)]
        double CelsiusToKelvin(string t);
    }
}
