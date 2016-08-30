import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import kuberstock.sessionbeans.ejb.SessionBeansRemote;

public class Main {
	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		prop.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName()); 
		prop.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		prop.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		prop.put("jboss.naming.client.ejb.context", true);

		// Create the JNDI InitialContext.
		Context context = new InitialContext(prop);
		// Look-up the Diary bean.
				SessionBeansRemote demo = (SessionBeansRemote) context.lookup("KuberstockSessionBeans/KuberstockSessionBeansEJB/SessionBeans!kuberstock.sessionbeans.ejb.SessionBeansRemote");
				System.out.println(demo.getEntry());
				
				
				
				
	}
	

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}