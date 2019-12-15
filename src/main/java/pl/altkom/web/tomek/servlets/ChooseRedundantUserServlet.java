package pl.altkom.web.tomek.servlets;

import pl.altkom.web.tomek.Client;
import pl.altkom.web.tomek.dao.ClientDataDAO;
import pl.altkom.web.tomek.dao.ClientDataDAOImpl;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/redundant-user")
public class ChooseRedundantUserServlet extends HttpServlet {

    @Resource(name="jdbc:komis")
    private DataSource ds;


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        try {
            List<Client> clList = new ArrayList<>();
            ClientDataDAO dao = new ClientDataDAOImpl();
            clList = dao.readClientsData(ds);
            req.setAttribute("clList", clList);
            req.getRequestDispatcher("user-removal-list.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException("Cannot read clients", e);
        }

    }

}
