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
 * Servlet implementation class UpdateCategory
 */
@WebServlet("/updateCategory")
public class UpdateCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoryDao categoryDao; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCategory() {
        super();
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
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String status = request.getParameter("status");
		
		Category category = new Category(title, status);
		category.setId(id);
		
		boolean isUpdated = categoryDao.update(category);
		
		HttpSession session = request.getSession();
		
		if(isUpdated) {
			session.setAttribute("message", "Category updated successfully");
		} else {
			session.setAttribute("message", "Nothing gets changed.");
		}
		
		response.sendRedirect("category.jsp");
	}

}
