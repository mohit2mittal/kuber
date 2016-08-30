package kuberstock.sessionbeans.web;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;



@ApplicationPath("/rest")
public class StockDataApplication extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();
	
	public StockDataApplication(){
	     singletons.add(new StockDataResource());
	     singletons.add(new StockExchangeResource());
	     singletons.add(new StockDataSearchResource());
	     
	     	}
	
	@Override
	public Set<Class<?>> getClasses() {
	     return empty;
	}
	
	@Override
	public Set<Object> getSingletons() {
	     return singletons;
	}

}
