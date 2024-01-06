package com.myweb.buiness;

import java.io.IOException;

import com.myweb.dao.UserDao;
import com.myweb.dbutil.DBConnection;
import com.myweb.model.User;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserSignup
 */

@WebServlet(name = "UserSignup", description = "This servlet is used to handle the user signup process", urlPatterns = {
		"/user/signup" })
public class UserSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserSignup() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		DBConnection dbConnection = new DBConnection();
		this.userDao = new UserDao(dbConnection);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User(name, email, password);
		
		userDao.registerUser(user);
		
	}

}
