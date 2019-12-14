package pl.altkom.web.tomek;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet ("/save-user-data")
public class SaveClientDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req
            , HttpServletResponse resp)
            throws ServletException, IOException
    {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req
            , HttpServletResponse resp)
            throws ServletException, IOException
    {
        Client client = new Client();

        client.setName(req.getParameter("name"));
        client.setSurname(req.getParameter("surname"));
        client.setAge(Integer.parseInt(req.getParameter("age")));
        client.setRegion(req.getParameter("region"));
        client.setGender(req.getParameter("gender"));

        ClientDataDAO dao = new ClientDataDAOImpl();
        try {
            InitialContext initCtx = new InitialContext();
            Context context = (Context) initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource) context
                    .lookup(getServletContext()
                    .getInitParameter("dataSource"));
            dao.saveClientData(client, ds);
            req.setAttribute("newClientAttribute", client);
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/successful-save").forward(req, resp);
    }

}
