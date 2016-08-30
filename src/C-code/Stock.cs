using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Text;
using System.Threading.Tasks;

namespace Mainstockproject
{
    [DataContract]
    public class Stock
    {
       // [DataMember]
       // public string stock_Id; //{ get; private set; }
        [DataMember]
        public string country; //{ get; private set; }
        [DataMember]
        public string exchangeName;//{ get; private set; }
        [DataMember]

        public double bid_price; //{ get; private set; }
        [DataMember]
        public string exchangeCode;//{ get; private set; }

    [DataMember]
    public double ask_price;//{ get; private set; }
        [DataMember]
        public double high; //{ get; private set; }
        [DataMember]
        public double low; //{ get; private set; }
        [DataMember]
        public double volume; //{ get; private set; }

        public Stock()
        {

        }
        public Stock(String exchangeName, String exchangeCode)

        {
            this.exchangeName = exchangeName;
            this.exchangeCode = exchangeCode;

        }
      
        /*public Stock(String stock_Id)
        {
            this.stock_Id = stock_Id;
        }
        */

        public override string ToString()
        {
            return (exchangeName+" ("+exchangeCode+")");

        }
        /*stocks ex = new stocks();
        public string exchangestring(stocks ex)
        {
            return ( ex.exchangeCode);

        }*/
        public string country_response;

        public static string countrycode(string code)
        {


            switch (code)
            {
                case "All":
                     return("ALL");
                    
                case "Botswana":
                    return("BOT");
                    
                case "Ghana":
                    return("GHA");
                    
                case "China":
                    return("CHI");
                    
                case "India":
                    return("IND");
                    
                case "Japan":
                     return("JAP");
                   
                case "Germany":
                    return("GER");
                   
                case "United Kingdom":
                     return("UK");
                   
                case "Switzerland":
                    return("SWITZ");
                    
                case "Egypt":
                    return("EGY");
                    
                case "Israel":
                   return("ISR");
                    
                case "Canada":
                   return("CAN");
                   
                case "United States":
                    return("US");
                   
                default:
                    return ("Null");
                        
            }

        }
        public static string exchangecode(string code)
        {
            switch(code)
            {
                case ("Botswana Stock Exchange"): return ("GB");
                case ("Ghana Stock Exchange"): return ("GH");
                case ("Hong Kong Stock Exchange"): return ("HK");
                case ("Shanghai Stock Exchange"): return ("SHA");
                case ("Shenzen Stock Exchange"): return ("SZ");
                case ("National Stock Exchange"): return ("IN");
                case ("Bombay Stock Exchange"): return ("BY");
                case ("Fukuoka Stock Exchange"): return ("FU");
                case ("Hercules Stock Exchange"): return ("HQ");
                case ("JASDAQ Securities Exchange"): return ("JA");
                case ("Nagoya Stock Exchange"): return ("NY");
                case ("Osaka Securities Exchange"): return ("OK");
                case ("Sapporo Securities Exchange"): return ("SO");
                case ("Tokyo Stock Exchange"): return ("TO");
                case ("Berlin Stock Exchange"): return ("BE");
                case ("Dusseldorf Stock Exchange"): return ("DU");
                case ("Frankfurt Stock Exchange"): return ("FF");
                case ("Munich Stock Exchange"): return ("MU");
                case ("Stuttgart Stock Exchange"): return ("ST");
                case ("London Stock Exchange"): return ("LN");
                case ("PLUS Markets Group"): return ("PZ");
                case ("Berne eXchange"): return ("BN");
                case ("SIX Swiss Exchange"): return ("EB");
                case ("Egyptian Stock Exchange"): return ("CI");
                case ("Cairo & Alexandria Stock Exchange"): return ("CA");
                case ("Tel Aviv Stock Exchange"): return ("TV");
                case ("Canada National Stock Exchange"): return ("L");
                case ("Toronto Stock Exchange"): return ("T");
                case ("TSX Venture Exchange"): return ("V");
                case ("American Stock Exchange"): return ("A");
                case ("NASDAQ OMX BX"): return ("B");
                case ("Chicago Stock Exchange"): return ("M");
                case ("NASDAQ"): return ("O");
                default: return ("Null");






            }

        }
    }
}
    

