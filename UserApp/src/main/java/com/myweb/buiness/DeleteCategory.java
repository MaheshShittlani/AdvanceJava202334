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

/**
 * Servlet implementation class DeleteCategory
 */
@WebServlet("/deleteCategory")
public class DeleteCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoryDao categoryDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	this.categoryDao = new CategoryDao(new DBConnection());
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int categoryId = 0;
		if(id != null) {
			categoryId = Integer.parseInt(id);
		}
		
		boolean isDeleted = categoryDao.delete(categoryId);
		
		HttpSession session = request.getSession();
		
		if(isDeleted) {
			session.setAttribute("message", "Category deleted successfully");
		} else {
			session.setAttribute("message", "Category can't be deleted");
		}
		
		response.sendRedirect("category.jsp");
	}

}
