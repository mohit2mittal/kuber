using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;

namespace Mainstockproject
{
    [DataContract]
    public class exchange_class
    {
        [DataMember]
        public string exchangeName;//{ get; private set; }
        [DataMember]
        public string exchangeCode; //{ get; private set; }

        public exchange_class()
        {

        }
        public exchange_class(String exchangeName, String exchangeCode)
        {
            this.exchangeName = exchangeName;
            this.exchangeCode = exchangeCode;

        }
        public override String ToString()
        {
            return (exchangeName+"("+ exchangeCode+ ")");
        }
        public String getExchangecode()
        {
            return (exchangeCode);
        }
             


    }
}
