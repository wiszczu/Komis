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
import java.io.PrintWriter;
import java.util.List;

@WebServlet ("/users")
public class GetUserTableServlet extends HttpServlet {


    @Resource(name="jdbc:komis")
    private DataSource ds;
    @Override
    protected void doGet(HttpServletRequest req
            , HttpServletResponse resp) throws ServletException, IOException
    {
        PrintWriter out = resp.getWriter();
        try {

            // linijki nizej zastapiono wtrzyknieciem zaleznosci - patrz wyzej
//            InitialContext initCtx = new InitialContext();
//            Context context = (Context) initCtx.lookup("java:comp/env");
//            DataSource ds = (DataSource) context.lookup(getServletContext()
//                    .getInitParameter("dataSource"));
            ClientDataDAO dao = new ClientDataDAOImpl();
            List<Client> users = dao.readClientsData(ds);
            req.setAttribute("clList", users);
            req.getRequestDispatcher("userList.jsp").forward(req,resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
