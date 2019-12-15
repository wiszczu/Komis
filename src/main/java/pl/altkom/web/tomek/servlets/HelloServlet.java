package pl.altkom.web.tomek.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "")
public class HelloServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request,
                        HttpServletResponse response)
            throws IOException {
        PrintWriter pw = response.getWriter();
        pw.println("<HTML><HEAD>");
        pw.println("<TITLE>Hello</TITLE>");
        pw.println("</HEAD><BODY>");
        pw.println("<H3>Hello World!</H3>");
        pw.println("<a href=\"Komis/hello\">Let's start!</a>");
        pw.println("</BODY></HTML>");
    }
}
