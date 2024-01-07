package com.myweb.buiness;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.myweb.dao.UserDao;
import com.myweb.dbutil.DBConnection;
import com.myweb.model.User;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class UserSignup
 */

@WebServlet(name = "UserSignup", description = "This servlet is used to handle the user signup process", urlPatterns = {
		"/signup" })
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
		
		HashMap<String,String> errors = new HashMap<String, String>();
		
		if(name.isEmpty()) {
			errors.put("name","Name is required");
		}
		else if(name.length() <=2) {
			errors.put("name","Name must be atleast 2 characters long.");
		}
		
		
		
		if(email.isEmpty()) {
			errors.put("email","Email is requied");
		} else if(!email.contains("@")) {
			errors.put("email","Invalid email address");
		}
		
		
		if(password.isEmpty()) {
			errors.put("password","Password is requied");
		}else if(password.length() <= 6) {
			errors.put("password","Password must be 6 characters long");
		}
		
		HttpSession session = request.getSession();
		if(errors.size() > 0) {
			session.setAttribute("errors", errors);
			response.sendRedirect("singup.jsp");
			return;
		}
		
		User user = new User(name, email, password);
		
		boolean isRegistered = userDao.registerUser(user);
		
		if(isRegistered) {
			user.setPassword("");
			session.setAttribute("user", user);
			response.sendRedirect("dashboard.jsp");
		}else {
			response.sendRedirect("signup.jsp");
		}
		
	}

}
