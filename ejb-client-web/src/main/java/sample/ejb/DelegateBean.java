package sample.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

@Stateful
public class DelegateBean {

    // remote SLSB
    private RemoteService remote;

    @PostConstruct
    public void init() {
        Properties properties = new Properties();  
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory"); 

        try {
            Context context = new InitialContext(properties);
            this.remote = (RemoteService) context.lookup("ejb:/remote-ejb/RemoteServiceImpl!sample.ejb.RemoteService?stateful");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    // transaction propagation with XADataSource
    public String echo(String s) {
        return remote.echo(s);
    }
}
