package sample.ejb;

import javax.ejb.Remote;
import java.io.Serializable;

@Remote
public interface RemoteService extends Serializable {
    String echo(String s);
}
