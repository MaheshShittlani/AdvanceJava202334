package com.myweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.myweb.dbutil.DBConnection;
import com.myweb.model.Category;

public class CategoryDao {
	private DBConnection dbConnection;

	public CategoryDao(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
	
	public boolean create(Category category) {
		String query = "INSERT INTO categories (title, status) VALUES (?,?)";
		
		try {
			Connection con = dbConnection.createConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, category.getTitle());
			pst.setString(2, category.getStatus());
			
			int affectedRows = pst.executeUpdate();
			
			return affectedRows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
