package com.myweb.buiness;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.myweb.dao.CategoryDao;
import com.myweb.dbutil.DBConnection;
import com.myweb.model.Category;

/**
 * Servlet implementation class CreateCategory
 */
@WebServlet("/createCategory")
public class CreateCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDao categoryDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	this.categoryDao = new CategoryDao(new DBConnection());
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String status = request.getParameter("status");
		
		Category category = new Category(title, status);
		
		boolean result = this.categoryDao.create(category);
		HttpSession session = request.getSession();
		
		String actionURL;
		if(result) {
			session.setAttribute("message", "Category Created Successfully");
			actionURL = "category.jsp";
		}else {
			session.setAttribute("message", "Something went wrong");
			actionURL = "add-category.jsp";
		}
		
		response.sendRedirect(actionURL);
	}

}
