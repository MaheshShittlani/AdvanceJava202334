

import java.io.IOException;

import business.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.UserModel;

/**
 * Servlet implementation class Subscribe
 */
@WebServlet(urlPatterns = {"/subscribe"}, 
			initParams = {
					@WebInitParam(name = "counterStart", value ="100")
			})
public class Subscribe extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int counter;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Subscribe() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.counter = Integer.parseInt(config.getInitParameter("counterStart"));
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.counter = this.counter + 1;
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		
		User user = new User(name, mobile, email);
		
		ServletContext context =  request.getServletContext();
		String path = context.getRealPath("WEB-INF/subscriber.txt");
		UserModel.store(user, path);
		
		request.setAttribute("user", user);
		request.setAttribute("counter", counter);
		RequestDispatcher dispatcher = context.getRequestDispatcher("/subscriber.jsp");
		dispatcher.forward(request, response);
		
//		response.sendRedirect("subscriber.jsp");
	}
}
