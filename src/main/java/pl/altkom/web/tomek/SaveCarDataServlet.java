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

@WebServlet ("/save-car-data")
public class SaveCarDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req
            , HttpServletResponse resp)
            throws ServletException, IOException
    {
        Car car = new Car();

        car.setBrand(req.getParameter("brand"));
        car.setModel(req.getParameter("model"));
        car.setYearOfProduction(Integer.parseInt(req.getParameter("production")));
        car.setMileage(Integer.parseInt(req.getParameter("mileage")));

        CarDataDAO dao = new CarDataDAOImpl();
        try {
            InitialContext initCtx = new InitialContext();
            Context context = (Context) initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource) context.lookup(getServletContext().getInitParameter("dataSource"));
            dao.saveCarData(car, ds);
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/successful-save").forward(req, resp);
    }

}
