package kuberstock.sessionbeans.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

//import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the stock_exchange database table.
 * 
 */
@Entity
@Table(name="stock_exchange")
@NamedQuery(name="StockExchange.findAll", query="SELECT s FROM StockExchange s")
public class StockExchange implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String exchange_Name;

	@Id
	private String exchange_Code;
	
	public String getExchange_Code() {
		return this.exchange_Code;
	}

	public void setExchange_Code(String exchange_Code) {
		this.exchange_Code = exchange_Code;
	}

	public String getExchange_Name() {
		return this.exchange_Name;
	}

	public void setExchange_Name(String exchange_Name) {
		this.exchange_Name = exchange_Name;
	}

	//bi-directional many-to-one association to StockData
	@OneToMany(mappedBy="stockExchange")
	@JsonManagedReference
	private List<StockData> stocks;
	public List<StockData> getStocks() {
		return this.stocks;
	}

	public void setStocks(List<StockData> stocks) {
		this.stocks = stocks;
	}

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="Country_Code")
	@JsonBackReference
	private Country country;
	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	public StockExchange() {
	}

	

	

	public StockData addStock(StockData stock) {
		getStocks().add(stock);
		stock.setStockExchange(this);

		return stock;
	}

	public StockData removeStock(StockData stock) {
		getStocks().remove(stock);
		stock.setStockExchange(null);

		return stock;
	}

	

}