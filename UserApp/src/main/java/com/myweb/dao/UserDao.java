package com.myweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.myweb.dbutil.DBConnection;
import com.myweb.model.User;

public class UserDao {
	private DBConnection dbConnection;

	public UserDao(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}

	public boolean registerUser(User user) {
		String query = "INSERT INTO users (name, email, password) VALUES (?,?,?)";

		try {
			Connection con = dbConnection.createConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPassword());

			int affectedRows = pst.executeUpdate();

			pst.close();
			dbConnection.closeConnection(con);
			return affectedRows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public User authenticate(User user) {
		String query = "select id, name, email, age, gender from users where email = ? and password = ?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = dbConnection.createConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, user.getEmail());
			pst.setString(2, user.getPassword());

			rs = pst.executeQuery();

			if (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setAge(rs.getInt("age"));
				user.setGender(rs.getString("gender"));
				user.setPassword("");
				return user;
			}

			return null;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
				pst.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}
}
