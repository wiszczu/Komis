package pl.altkom.web.tomek.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet ("/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException
    {
        String choice = req.getParameter("chosen");
        switch (choice) {
            case "Audi":
                resp.sendRedirect("https://www.audi.com/");
                break;
            case "BMW":
                resp.sendRedirect("https://www.bmwusa.com/");
                break;
            case "Dodge":
                resp.sendRedirect("https://www.dodge.com/");
                break;
            case "Mazda":
                resp.sendRedirect("https://www.mazda.com/");
                break;
            default:
                resp.sendRedirect("https://www.google.com/");
                break;
        }

    }
}
