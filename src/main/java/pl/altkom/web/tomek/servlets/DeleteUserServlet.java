package pl.altkom.web.tomek.servlets;

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

@WebServlet(urlPatterns = "/delete-user")
public class DeleteUserServlet extends HttpServlet {

    @Resource(name="jdbc:komis")
    private DataSource ds;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String client = req.getParameter("deleteUser");
        getServletContext().log(client);
        String name, surname;
        String[] splitted = client.split(" ");
        name = splitted[0];
        surname = splitted[1];
        ClientDataDAO dao = new ClientDataDAOImpl();
        try {
            dao.removeClient(name, surname, ds);
            req.getRequestDispatcher("/users").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException("cannot delete user", e);
        }

    }
}
