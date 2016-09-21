package servelets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServeletWithCookies extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");

        // Create cookies
        Cookie fname = new Cookie("fname", request.getParameter("fname"));
        Cookie lname = new Cookie("lname", request.getParameter("lname"));
        Cookie age = new Cookie("age", request.getParameter("age"));

        // Set expiry date after 24 Hrs
        fname.setMaxAge(60*60*24);
        lname.setMaxAge(60*60*24);
        age.setMaxAge(60*60*24);

        // Add cookies in the response header
        response.addCookie(fname);
        response.addCookie(lname);
        response.addCookie(age);

        try {
            PrintWriter out = response.getWriter();
            String title = "Setting Cookies Example";
            String docType =
                    "<!doctype html public \"-//w3c//dtd html 4.0 " +
                            "transitional//en\">\n";
            out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + title + "</h1>\n" +
                    "<ul>\n" +
                    "  <li><b>First Name</b>: "
                    + request.getParameter("fname") + "\n" +
                    "  <li><b>Last Name</b>: "
                    + request.getParameter("lname") + "\n" +
                    "  <li><b>Age</b>: "
                    + request.getParameter("age") + "\n" +
                    "</ul>\n" +
                    "</body></html>");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

