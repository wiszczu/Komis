package pl.altkom.web.tomek;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveClientDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            dao.saveClientData(client, getServletContext().getInitParameter("dataSource"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/successful-save").forward(req, resp);
    }

}
