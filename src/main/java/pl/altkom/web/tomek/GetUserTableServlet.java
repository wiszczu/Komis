package pl.altkom.web.tomek;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet ("/users")
public class GetUserTableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req
            , HttpServletResponse resp) throws ServletException, IOException
    {
        PrintWriter out = resp.getWriter();
        try {
            InitialContext initCtx = new InitialContext();
            Context context = (Context) initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource) context.lookup(getServletContext().getInitParameter("dataSource"));
            ClientDataDAO dao = new ClientDataDAOImpl();
            List<Client> users = dao.readClientsData(ds);
            out.println("<html><head><title> Lista userów </title></head><body>");
            for (Object o : users){
                Client c = (Client)o;
                out.println("<table>");
                // - poczatek kolumny
                out.println("<tr>");
                out.println("<th>");
                out.println(c.getName());
                out.println("</th>");
                out.println("<th>");
                out.println(c.getSurname());
                out.println("</th>");
                out.println("<th>");
                out.println(c.getAge());
                out.println("</th>");
                out.println("<th>");
                out.println(c.getRegion());
                out.println("</th>");
                out.println("<th>");
                out.println(c.getGender());
                out.println("</th>");
                out.println("</tr>");
                out.println("</table>");
                // - koniec kolumny - analogicznie dla pozostalych parametrow
                out.println("</body></html>");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
