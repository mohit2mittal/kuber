package kuberstock.sessionbeans.jpa;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The persistent class for the stock database table.
 * 
 */
@Entity
@Table(name="stock")
@NamedQuery(name="StockData.findAll", query="SELECT s FROM StockData s")
public class StockData implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private StockDataPK id;
	
	public StockDataPK getId() {
		return this.id;
	}

	public void setId(StockDataPK id) {
		this.id = id;
	}

	private double closing_Price;

	private double highest_Price;

	private double lowest_Price;

	private double opening_Price;
	
	private double ask_Price;

	

	private double bid_Price;

	private int volume;

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
	

	//bi-directional many-to-one association to StockExchange
	@ManyToOne
	@JoinColumn(name="Exchange_Code")
	@JsonBackReference
	private StockExchange stockExchange;
	public StockExchange getStockExchange() {
		return this.stockExchange;
	}

	public void setStockExchange(StockExchange stockExchange) {
		this.stockExchange = stockExchange;
	}

	public StockData() {
	}

	

	public double getClosing_Price() {
		return this.closing_Price;
	}

	public void setClosing_Price(double closing_Price) {
		this.closing_Price = closing_Price;
	}

	public double getHighest_Price() {
		return this.highest_Price;
	}

	public void setHighest_Price(double highest_Price) {
		this.highest_Price = highest_Price;
	}

	public double getLowest_Price() {
		return this.lowest_Price;
	}

	public void setLowest_Price(double lowest_Price) {
		this.lowest_Price = lowest_Price;
	}

	public double getOpening_Price() {
		return this.opening_Price;
	}

	public void setOpening_Price(double opening_Price) {
		this.opening_Price = opening_Price;
	}

	public int getVolume() {
		return this.volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public double getAsk_Price() {
		return ask_Price;
	}

	public void setAsk_Price(double ask_Price) {
		this.ask_Price = ask_Price;
	}

	public double getBid_Price() {
		return bid_Price;
	}

	public void setBid_Price(double bid_Price) {
		this.bid_Price = bid_Price;
	}

	

	

}