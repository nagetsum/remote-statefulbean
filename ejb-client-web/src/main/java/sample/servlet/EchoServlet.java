package sample.servlet;

import sample.ejb.DelegateBean;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/echo")
public class EchoServlet extends HttpServlet {

    @EJB
    private DelegateBean delegate;

    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws IOException {

        String s = delegate.echo("try to call remote SFSB");

        res.setContentType("text/plain; charset=utf-8");
        res.getWriter().println(s);
    }
}
