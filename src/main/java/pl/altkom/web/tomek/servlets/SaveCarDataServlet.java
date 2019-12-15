package pl.altkom.web.tomek.servlets;

import pl.altkom.web.tomek.Car;
import pl.altkom.web.tomek.dao.CarDataDAO;
import pl.altkom.web.tomek.dao.CarDataDAOImpl;

import javax.annotation.Resource;
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

    @Resource(name="jdbc:komis")
    private DataSource ds;

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
        car.setMileage(req.getParameter("mileage"));
        car.setMileage(req.getParameter("capacity"));

        CarDataDAO dao = new CarDataDAOImpl();
        try {
            dao.saveCarData(car, ds);
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/hello").forward(req, resp);

    }

}
