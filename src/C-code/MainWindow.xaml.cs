using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Json;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Web.Script.Serialization;
using kuber_stock_project;

namespace Mainstockproject
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        /*private Dictionary<string, string> countryToCode = new Dictionary<string, string>();
        private void SetupCountryCodeDictionary()
        {
            countryToCode["Botswana"] = "BOT";

        }*/
        exchange_class obj = new exchange_class();
        public MainWindow()
        {

            InitializeComponent();

        }
        public string csvData, csvData2;


        //Stock stock = new Stock("Tata");
        //Stock stock1 = new Stock("Reliance");



        private void Dosetup(object sender, RoutedEventArgs e)
        {


            //stock.stock_Id = csvData;
            //DataGrid.Items.Add(stock);

        }
        stock_search stockwindow = new stock_search();
        private void Search_stock(object sender, RoutedEventArgs e)
        {

            string myself1 = txtBox.Text;

            stock_search stockwindow = new stock_search();
            bool? success = stockwindow.ShowDialog();
            if (success == true)
            {

            }

            string searched_stock = txtBox.Text;
            var cli = new WebClient();
            string URL = "http://10.87.237.12:8080/KuberstockSessionBeansWeb/rest/product";
            cli.Headers[HttpRequestHeader.ContentType] = "text/plain";
            string upresponse = cli.UploadString(URL, "Stock" + " " + searched_stock);

            MessageBox.Show(upresponse);
        }

        private void add(object sender, RoutedEventArgs e)
        {

            dataGrid.Items.Add(new Stock("tata", "scd"));

            MessageBox.Show("Stock Tata has been added");

        }

        private void select(object sender, RoutedEventArgs e)
        {

            if (dataGrid.SelectedIndex == -1)
            {
                MessageBox.Show("Please select a customer");
                return;
            }
            stockwindow.ShowDialog();
            MessageBox.Show(dataGrid.SelectedItem.ToString());
        }



        private void ReadJson(object sender, RoutedEventArgs e)
        {

            JavaScriptSerializer js = new JavaScriptSerializer();


        }

        List<exchange_class> exchangelist = new List<exchange_class>();

        private void country_search(object sender, SelectionChangedEventArgs e)
        {

            if (Search_country.SelectedIndex == -1)
            {
                MessageBox.Show("Please select a country");
                return;
            }

            else
            {

                ComboBoxItem item = (ComboBoxItem)Search_country.SelectedItem;
                search_exchange.Items.Clear();
                string country_response = item.Content.ToString();
                country_response = Stock.countrycode(country_response);
                MessageBox.Show(country_response);

                var cli = new WebClient();
                string URL = "http://10.87.230.247:8080/KuberstockSessionBeansWeb/rest/product";
                cli.Headers[HttpRequestHeader.ContentType] = "text/plain";
                string response = cli.DownloadString(URL + "/" + country_response);
                MessageBox.Show(response);
                JavaScriptSerializer exchange = new JavaScriptSerializer();
                using (WebClient web = new WebClient())
                {



                    //MessageBox.Show(response);
                    List<exchange_class> exchangelist = (List<exchange_class>)exchange.Deserialize(response, typeof(List<exchange_class>));


                    foreach (exchange_class temp1 in exchangelist)
                    {
                        search_exchange.Items.Add(temp1);

                        //MessageBox.Show(temp1.ToString());
                    }


                }

            }
        }



        private void exchange_search(object sender, SelectionChangedEventArgs e)
        {
            search_exchange.DisplayMemberPath = "FullName";
            if (search_exchange.SelectedIndex == -1)
            {
                MessageBox.Show("Please select a exchange");
                return;
            }

            else
            {

                obj = (exchange_class)search_exchange.SelectedItem;
                String exchange_response = obj.getExchangecode();
                MessageBox.Show(exchange_response);

                //var cli2 = new WebClient();
                string URL = "http://10.87.230.247:8080/KuberstockSessionBeansWeb/rest/stock";
                var cli = new WebClient();
                //string URL = "http://10.87.230.247:8080/KuberstockSessionBeansWeb/rest/product";
                //cli.Headers.Add(HttpRequestHeader.ContentType, "text/plain");
                string response = cli.DownloadString(URL + "/" + exchange_response);
                //MessageBox.Show("This is the response" + response);
                JavaScriptSerializer exchange2 = new JavaScriptSerializer();
                //MessageBox.Show("step 3");

                
                using (WebClient web = new WebClient())
                {


                    MessageBox.Show("step 4");


                    List<classstock_Id> t1 = (List<classstock_Id>)exchange2.Deserialize(response, typeof(List<classstock_Id>));
                    //string msg = "";
                    foreach (classstock_Id temp1 in t1)
                    {
                        //MessageBox.Show(temp1.ToString());
                        dataGrid.Items.Add(temp1);
                        //dataGrid.Items.Add(temp);
                       // msg += (temp + " ");
                       // MessageBox.Show(msg);
                    }


                }

            }
        }


    }
}
