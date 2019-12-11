package pl.altkom.web.tomek;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException
    {
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
        pw.println("<a href=\"carForm.html\">Add a car</a>");
        pw.println("</BODY></HTML>");
    }
}
