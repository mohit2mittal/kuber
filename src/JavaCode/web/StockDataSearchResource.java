package kuberstock.sessionbeans.web;

import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import kuberstock.sessionbeans.ejb.SessionBeansLocal;
import kuberstock.sessionbeans.jpa.StockData;


@Path("/search")
public class StockDataSearchResource {

	



	
	private SessionBeansLocal bean;
	
	public StockDataSearchResource() {
        try {
        	InitialContext context = new InitialContext();
            bean = (SessionBeansLocal) context.lookup("java:global/KuberstockSessionBeans/KuberstockSessionBeansEJB/SessionBeans!kuberstock.sessionbeans.ejb.SessionBeansLocal");
        }
		catch (NamingException ex) {}
	}
	
	@GET
	@Consumes("text/plain")
	@Produces("application/json")
	@Path("/{stock_Id}")
	public List<GetStockInfoResponse> takeStockCode(@PathParam("stock_Id")String stock_Id) {
		return getStockInfo(stock_Id);		
	}
	

	public List<GetStockInfoResponse> getStockInfo(String stock_Id){
		
		System.out.println(stock_Id);
		
		 List<GetStockInfoResponse> response = new ArrayList<>();
		 if(bean.getStockInformation(stock_Id)==null)
			 return null;
			
		 else{
			 List<StockData> alldata =bean.getStockInformation(stock_Id);
			 for(StockData s:alldata){
				 GetStockInfoResponse object = new GetStockInfoResponse();
				 
				 object.Stock_Id = s.getId().getStock_Id();
				 object.Opening_Price = s.getOpening_Price();
				 object.Highest_Price = s.getHighest_Price();
				 object.Lowest_Price = s.getLowest_Price();
				 object.Closing_Price = s.getClosing_Price();
				 object.volume = s.getVolume();
				 object.Country_Code = s.getCountry().getCountry_Code();
				 object.Exchange_Code = s.getStockExchange().getExchange_Code();
				 object.Ask_Price = s.getAsk_Price();
				 object.Bid_Price = s.getBid_Price();				 
				 response.add(object);
			 
			 }		 
			 return response;
	}	

}


}
class GetStockInfoResponse {
	String Stock_Id;
	double Opening_Price;
	double Highest_Price;
	double Lowest_Price;
	double Closing_Price;
	int volume;
	String Country_Code;
	String Exchange_Code;
	double Ask_Price;
	double Bid_Price;
	
	public String getStock_Id() {
		return Stock_Id;
	}
	public void setStock_Id(String stock_Id) {
		Stock_Id = stock_Id;
	}
	public double getOpening_Price() {
		return Opening_Price;
	}
	public void setOpening_Price(double opening_Price) {
		Opening_Price = opening_Price;
	}
	public double getHighest_Price() {
		return Highest_Price;
	}
	public void setHighest_Price(double highest_Price) {
		Highest_Price = highest_Price;
	}
	public double getLowest_Price() {
		return Lowest_Price;
	}
	public void setLowest_Price(double lowest_Price) {
		Lowest_Price = lowest_Price;
	}
	public double getClosing_Price() {
		return Closing_Price;
	}
	public void setClosing_Price(double closing_Price) {
		Closing_Price = closing_Price;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public String getCountry_Code() {
		return Country_Code;
	}
	public void setCountry_Code(String country_Code) {
		Country_Code = country_Code;
	}
	public String getExchange_Code() {
		return Exchange_Code;
	}
	public void setExchange_Code(String exchange_Code) {
		Exchange_Code = exchange_Code;
	}
	public double getAsk_Price() {
		return Ask_Price;
	}
	public void setAsk_Price(double ask_Price) {
		Ask_Price = ask_Price;
	}
	public double getBid_Price() {
		return Bid_Price;
	}
	public void setBid_Price(double bid_Price) {
		Bid_Price = bid_Price;
	}
	
}




	

