using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Mainstockproject
{
    class classstock_Id
    {
        public string stock_Id;


        public classstock_Id(string stock_Id)
        {
            this.stock_Id = stock_Id;
        }

        public classstock_Id()
        {
            
        }
        public override string ToString()
        {
            return (stock_Id);

        }
    }
}
