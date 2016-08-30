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


@Path("/stock")
public class StockDataResource {
	
	private SessionBeansLocal bean;
	
	public StockDataResource() {
        try {
        	InitialContext context = new InitialContext();
            bean = (SessionBeansLocal) context.lookup("java:global/KuberstockSessionBeans/KuberstockSessionBeansEJB/SessionBeans!kuberstock.sessionbeans.ejb.SessionBeansLocal");
        }
		catch (NamingException ex) {}
	}
	
	/*@POST
	@Consumes("text/plain")
	@Produces("application/json")
	public List<GetExchangeCodeResponse> takeCountryCode(String country_Code) {
		return getExchangeCode(country_Code);		
	}
	
	
//	@GET
//	@Produces("application/json")
	public List<GetExchangeCodeResponse> getExchangeCode(String country_Code){
		
		System.out.println(country_Code);
		
		 List<GetExchangeCodeResponse> response = new ArrayList<>();
		 if(country_Code.equalsIgnoreCase("ALL")){
			 List<StockExchange> alldata =bean.getStockExchanges();
			 for(StockExchange s:alldata){
				 GetExchangeCodeResponse object = new GetExchangeCodeResponse();
				 object.ExchangeCode = s.getExchange_Code();
				 object.ExchangeName = s.getExchange_Name();
				 response.add(object);
			 }
			 return response;
			 
		 }
		 else{
			 List<StockExchange> alldata =bean.getStockExchangesInCountry(country_Code);
			 for(StockExchange s:alldata){
				 GetExchangeCodeResponse object = new GetExchangeCodeResponse();
				 object.ExchangeCode = s.getExchange_Code();
				 object.ExchangeName = s.getExchange_Name();
				 response.add(object);
			 }
		 
		 return response;
		//return ("hellllo");
		 }
	}*/
	
	@GET
	@Consumes("text/plain")
	@Produces("application/json")
	@Path("/{exchange_Code}")
	public List<GetStockResponse> takeExchangeCode(@PathParam("exchange_Code")String exchange_Code) {
		return getStocks(exchange_Code);		
	}
	

	public List<GetStockResponse> getStocks(String exchange_Code){
		
		 List<GetStockResponse> response = new ArrayList<>();
		 List<StockData> alldata =bean.getStocksInStockExchange(exchange_Code);
		 for(StockData s:alldata){
			 GetStockResponse object = new GetStockResponse();
			 object.stock_Id = s.getId().getStock_Id();
			response.add(object);
		}
		 System.out.println(exchange_Code);
		 for (GetStockResponse temp:response)
		 System.out.println(temp.getStock_Id());
		 return response;
		
		 
	}
	
	
	
	/*@POST
	@Produces("application/json")
    @Path("/{country_Code}")
	public List<StockExchange> getStockExchangesInCountry(@PathParam("country_Code")String country_Code) {

		if (bean == null) 
			return null;
		
		return bean.getStockExchangesInCountry(country_Code);	
	}*/
	
	
	
	/*@POST
	@Consumes("text/plain")
	public String test(String dummytext,String check) {
		System.out.println(dummytext);
		System.out.println(check);
		return "text entered is "+ dummytext;
		
		
	}
	*/
	

}

/*class GetExchangeCodeResponse{
	String ExchangeName;
	String ExchangeCode;
	public String getExchangeName() {
		return ExchangeName;
	}
	public void setExchangeName(String exchangeName) {
		ExchangeName = exchangeName;
	}
	public String getExchangeCode() {
		return ExchangeCode;
	}
	public void setExchangeCode(String exchangeCode) {
		ExchangeCode = exchangeCode;
	}
}
*/
class GetStockResponse{
	String stock_Id;

	public String getStock_Id() {
		return stock_Id;
	}

	public void setStock_Id(String stock_Id) {
		this.stock_Id = stock_Id;
	}
	
}
