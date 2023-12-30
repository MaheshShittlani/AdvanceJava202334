

import java.io.IOException;
import java.io.PrintWriter;

import business.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UserModel;

/**
 * Servlet implementation class Subscribe
 */
@WebServlet("/subscribe")
public class Subscribe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Subscribe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		
		User user = new User(name, mobile, email);
		
		ServletContext context =  request.getServletContext();
		String path = context.getRealPath("WEB-INF/subscriber.txt");
		UserModel.store(user, path);
		
		RequestDispatcher dispatcher = context.getRequestDispatcher("/subscriber.jsp");
		dispatcher.forward(request, response);
	}
}
