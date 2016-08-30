package kuberstock.sessionbeans.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import kuberstock.sessionbeans.jpa.StockData;
import kuberstock.sessionbeans.jpa.StockExchange;


/**
 * Session Bean implementation class SessionBeans
 */
@Stateless
@Remote(SessionBeansRemote.class)
@Local(SessionBeansLocal.class)
public class SessionBeans implements SessionBeansRemote, SessionBeansLocal {

    /**
     * Default constructor. 
     */
    public SessionBeans() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(name="KuberstockSessionBeansJPA-PU")
	private EntityManager em;
    
    @Override
    public String getEntry(){
    	return "Helloo";
    }
    
    @Override
    public List<StockExchange> getStockExchangesInCountry(String country_Code){
    	TypedQuery<StockExchange> query = em.createQuery("Select se from StockExchange as se where se.country.country_Code = :name",StockExchange.class);
    	query.setParameter("name", country_Code);
    	
    	//Execute the query and get collection of stock exchanges back
    	List<StockExchange> stockExchange = query.getResultList();
    	
    	/*for (StockExchange exchange : stockExchange){
    		displayOnServerConsole("Got stock exchanges in country ", exchange.getExchange_Name());
    	}*/
    	
    	return stockExchange;
    }
    
    @Override
    public List<StockExchange> getStockExchanges(){
    	TypedQuery<StockExchange> query = em.createQuery("Select se from StockExchange as se",StockExchange.class);
    	List<StockExchange> stockExchange = query.getResultList();
    	return stockExchange;
    }
    
    @Override
    public List<StockData> getStocksInStockExchange(String exchange_Code){
    	TypedQuery<StockData> query = em.createQuery("Select distinct st from StockData as st where st.stockExchange.exchange_Code = :name",StockData.class);
    	query.setParameter("name", exchange_Code);
    	
    	//Execute the query and get collection of stock exchanges back
    	List<StockData> stocks = query.getResultList();
    	return stocks;

    }
    
    
    @Override
    public List<StockData> getStockInformation(String stock_Id){
    	TypedQuery<StockData> query = em.createQuery("Select st from StockData as st where st.id.stock_Id = :name",StockData.class);
    	query.setParameter("name", stock_Id);
    	
    	//Execute the query and get collection of stock exchanges back
    	List<StockData> stocks = query.setMaxResults(1).getResultList();
    	return stocks;

    }
    
    
    
    
    
    
    private void displayOnServerConsole(String message, String exchange ) {

        System.out.println(message);
        if (exchange == null) {
            System.out.print("exchange is null");
        } else {
            System.out.println(exchange);
        }
    }

    
    
    

}
