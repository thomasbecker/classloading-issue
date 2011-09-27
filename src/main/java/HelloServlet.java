import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* ------------------------------------------------------------ */
/**
 */

public class HelloServlet extends HttpServlet
{

    /**
     *
     */
    private static final long serialVersionUID = -3654876251516837609L;

    @SuppressWarnings("unused")
    private ClassUsingMySQL classUsingMySQL = new ClassUsingMySQL();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("request.getSession called");
        request.getSession(true).setAttribute("foo", "bar");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<HTML>");
        out.println("<HEAD><TITLE>Hello World</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<BIG>Hello World</BIG>");
        out.println("</BODY></HTML>");
    }
}
