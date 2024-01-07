package com.myweb.buiness;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.myweb.dao.UserDao;
import com.myweb.dbutil.DBConnection;
import com.myweb.model.User;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet(name = "UserLogin", description = "This servlet is used to perfor the user login", urlPatterns = {
		"/login" })
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLogin() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		userDao = new UserDao(new DBConnection());
		super.init(config);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = userDao.authenticate(new User(email, password));
		
		HttpSession session =  request.getSession();
		if(user != null) {
			session.setAttribute("user", user);
			response.sendRedirect("dashboard.jsp");
		} else {
			session.setAttribute("message", "Invalid Email / Password");
			response.sendRedirect("index.jsp");
		}
	}

}
