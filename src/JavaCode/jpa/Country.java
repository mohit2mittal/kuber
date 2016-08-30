package kuberstock.sessionbeans.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the country database table.
 * 
 */
@Entity
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String country_Code;
	public String getCountry_Code() {
		return this.country_Code;
	}

	public void setCountry_Code(String country_Code) {
		this.country_Code = country_Code;
	}
	

	private String country_Name;

	//bi-directional many-to-one association to StockData
	@OneToMany(mappedBy="country")
	@JsonManagedReference
	private List<StockData> stocks;
	public List<StockData> getStocks() {
		return this.stocks;
	}

	public void setStocks(List<StockData> stocks) {
		this.stocks = stocks;
	}

	//bi-directional many-to-one association to StockExchange
	@OneToMany(mappedBy="country")
	@JsonManagedReference
	private List<StockExchange> stockExchanges;
	public List<StockExchange> getStockExchanges() {
		return this.stockExchanges;
	}

	public void setStockExchanges(List<StockExchange> stockExchanges) {
		this.stockExchanges = stockExchanges;
	}

	public Country() {
	}

	

	public String getCountry_Name() {
		return this.country_Name;
	}

	public void setCountry_Name(String country_Name) {
		this.country_Name = country_Name;
	}

	

	public StockData addStock(StockData stock) {
		getStocks().add(stock);
		stock.setCountry(this);

		return stock;
	}

	public StockData removeStock(StockData stock) {
		getStocks().remove(stock);
		stock.setCountry(null);

		return stock;
	}

	

	public StockExchange addStockExchange(StockExchange stockExchange) {
		getStockExchanges().add(stockExchange);
		stockExchange.setCountry(this);

		return stockExchange;
	}

	public StockExchange removeStockExchange(StockExchange stockExchange) {
		getStockExchanges().remove(stockExchange);
		stockExchange.setCountry(null);

		return stockExchange;
	}

}