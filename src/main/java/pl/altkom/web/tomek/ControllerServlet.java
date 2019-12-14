package pl.altkom.web.tomek;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException
    {
        HttpSession session = req.getSession();
        PrintWriter pw = resp.getWriter();
        pw.println("<HTML><HEAD>");
        pw.println("<TITLE>Start page</TITLE>");
        pw.println("</HEAD><BODY>");
        pw.println("<H3>Menu</H3>");
//        pw.println(req.getParameter("name"));
//        if (req.getParameter("name") != null){
//            pw.print(req.getParameter("name") + "<BR>");
//        }
        pw.println("<a href=\"makeForm.html\">Choose a brand</a><br>");
        pw.println("<a href=\"userForm.html\">User Registration</a><br>");
        pw.println("<a href=\"carForm.html\">Add a car</a><br><br>");
        pw.println("<h5>liczba aktywnych sesji: " + SessionCounter.getActiveSessions());
        pw.println("</h5><br>");
        Object counter = getServletContext().getAttribute("savedClientsCounter");
        if (counter == null){
            pw.println("no users added");
        } else {
            pw.println(counter.toString() + " user(s) added");
        }
        pw.println("<br>");
        pw.println("</BODY></HTML>");

    }
}
