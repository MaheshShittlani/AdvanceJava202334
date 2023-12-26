import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/subscribe")
public class SubscribeServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String email = req.getParameter("email");



        out.println("<!doctype html>");
        out.println("<html>");
            out.println("<head>");
                out.println("<title>Print Subscriber Detail</title>");
            out.println("</head>");

            out.println("<body>");
                out.println("<h1>Susbsriber Detail</h1>");
                out.println("<p>Thanks for subscribing us</p>");
                out.println("<p>Firstname: " + firstName + "</p>");
                out.println("<p>Lastname: " + lastName + "</p>");
                out.println("<p>Email: " + email + "</p>");
            out.println("</body>");
        out.println("</html>");

        out.close();
    }
}
