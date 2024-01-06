package com.myweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.myweb.dbutil.DBConnection;
import com.myweb.model.User;

public class UserDao {
	private DBConnection dbConnection;
	
	public UserDao(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}

	public void registerUser(User user) {
		String query = "INSERT INTO users (name, email, password) VALUES (?,?,?)";

		try {
			Connection con = dbConnection.createConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPassword());
			
			
			int affectedRows = pst.executeUpdate();
			System.out.println(affectedRows + " rows affected");
		
			pst.close();
			dbConnection.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
