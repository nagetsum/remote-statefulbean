package sample.ejb;

import javax.ejb.Stateful;

@Stateful
public class RemoteServiceImpl implements RemoteService {

    private static final long serialVersionUID = 1L;

    private int processCount = 0;

    @Override
    public String echo(String s) {
        System.out.println("call RemoteServiceImpl on hostname: " + System.getenv("HOSTNAME"));
        processCount++;
        return s + " count = " + processCount;
    }
}
