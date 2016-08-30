package kuberstock.sessionbeans.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the stock database table.
 * 
 */
@Embeddable
public class StockDataPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private java.util.Date date;

	private String stock_Id;

	public StockDataPK() {
	}
	public java.util.Date getDate() {
		return this.date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public String getStock_Id() {
		return this.stock_Id;
	}
	public void setStock_Id(String stock_Id) {
		this.stock_Id = stock_Id;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof StockDataPK)) {
			return false;
		}
		StockDataPK castOther = (StockDataPK)other;
		return 
			this.date.equals(castOther.date)
			&& this.stock_Id.equals(castOther.stock_Id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.date.hashCode();
		hash = hash * prime + this.stock_Id.hashCode();
		
		return hash;
	}
}