import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out =  response.getWriter();

        out.println("<!doctype html>");
        out.println("<html>");
            out.println("<head><title>First web app</title></head>");
            out.println("<body>");
                out.println("Hello World");
            out.println("</body>");
        out.println("</html>");
        

        out.close();
    }
}