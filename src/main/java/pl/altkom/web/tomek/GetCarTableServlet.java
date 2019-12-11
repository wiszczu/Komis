package pl.altkom.web.tomek;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GetCarTableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req
            , HttpServletResponse resp) throws ServletException, IOException
    {
        PrintWriter out = resp.getWriter();
        try {
            InitialContext initCtx = new InitialContext();
            Context context = (Context) initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource) context.lookup(getServletContext().getInitParameter("dataSource"));
            CarDataDAO dao = new CarDataDAOImpl();
            List<Car> cars = dao.readCarsData(ds);
            out.println("<html><head><title> Lista samochodów </title></head><body>");
            for (Object o : cars){
                Car car = (Car)o;
                out.println("<table>");
                // - poczatek kolumny
                out.println("<tr>");
                out.println("<th>");
                out.println(car.getBrand());
                out.println("</th>");
                out.println("<th>");
                out.println(car.getModel());
                out.println("</th>");
                out.println("<th>");
                out.println(car.getYearOfProduction());
                out.println("</th>");
                out.println("<th>");
                out.println(car.getMileage());
                out.println("</th>");
                out.println("</tr>");
                out.println("</table>");
                // - konbiuec kolumny - analogicznie dla pozostalych parametrow
                out.println("</body></html>");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
