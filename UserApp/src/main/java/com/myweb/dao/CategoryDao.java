package com.myweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public ArrayList<Category> fetchAll() {
		String query = "SELECT id, title, status, created_at, updated_at from categories";
		
		try {
			Connection con = dbConnection.createConnection();
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Category> categories = new ArrayList<Category>();
			
			while(rs.next()) {
//				Category category = new Category();
//				category.setId(rs.getInt("Id"));
//				category.setTitle(rs.getString("title"));
//				category.setStatus(rs.getString("status"));
//				category.setCreatedAt(rs.getString("created_at"));
//				category.setUpdateAt(rs.getString("updated_at"));
				
				categories.add(new Category(
						rs.getInt("id"), 
						rs.getString("title"), 
						rs.getString("status"),
						rs.getString("created_at"), 
						rs.getString("updated_at")
					));
			}
			
			return categories;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Category fetchOne(int id) {
		String query = "SELECT * FROM categories WHERE id = ?";
		
		try {
			Connection con = dbConnection.createConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			Category category = null;
			
			if(rs.next()) {
				category = new  Category(
						rs.getInt("id"), 
						rs.getString("title"), 
						rs.getString("status"),
						rs.getString("created_at"), 
						rs.getString("updated_at")
					);
			}
			return category;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean delete(int id) {
		String query = "DELETE FROM categories WHERE id = ?";
		
		try {
			Connection con = dbConnection.createConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			
			int affectedRows = pst.executeUpdate();
			
			return affectedRows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean update(Category category) {
		String query = "UPDATE categories set title = ?, status = ? where id = ?";
		
		try {
			Connection con = dbConnection.createConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, category.getTitle());
			pst.setString(2, category.getStatus());
			pst.setInt(3, category.getId());
			
			int affectedRows = pst.executeUpdate();
			
			return affectedRows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
