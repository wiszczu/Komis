package pl.altkom.web.tomek;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SuccessfullSaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req
            , HttpServletResponse resp)
            throws ServletException, IOException
    {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<HTML><HEAD>");
        out.println("<TITLE>New record</TITLE>");
        out.println("</HEAD><BODY>");
        out.println("<H3>New record has been added successfully.</H3>");
        out.println("<a href=\"userForm.html\">Add another user!</a>");
        out.println("<a href=\"/users\">Show users list</a>");
        out.println("</BODY></HTML>");
        out.close();
    }
}