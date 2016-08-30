package kuberstock.sessionbeans.ejb;

import java.util.List;

import javax.ejb.Local;

import kuberstock.sessionbeans.jpa.StockData;
import kuberstock.sessionbeans.jpa.StockExchange;

@Local
public interface SessionBeansLocal {
	public String getEntry();
	public List<StockExchange> getStockExchangesInCountry(String country_Code);
	public List<StockExchange> getStockExchanges();
	public List<StockData> getStocksInStockExchange(String exchange_Code);
	List<StockData> getStockInformation(String stock_Id);

}
