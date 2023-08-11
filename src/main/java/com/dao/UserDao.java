package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDao {
	private Connection conn;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean register(User u) {
		boolean f = false;
		try {
			String sql = "insert into user_details(full_name, email, password) values(?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u.getFullName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public User login(String userEmail, String userPassword) {
		User user = null;

		try {
			String sql = "select * from user_details where email = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userEmail);
			ps.setString(2, userPassword);

			ResultSet rSet = ps.executeQuery();
			while (rSet.next()) {
				user = new User();
				user.setId(rSet.getInt(1));
				user.setFullName(rSet.getString(2));
				user.setEmail(rSet.getString(3));
				user.setPassword(rSet.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public boolean changePass(User user) {
		boolean f = false;
		try {
			String sql = "update user_details set password = ? where id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, user.getPassword());
			preparedStatement.setInt(2, user.getId());
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return f;
	}

	public int countUser() {
		int count = 0;
		try {
			String sql = "select * from user_details";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet executeQuery = preparedStatement.executeQuery();
			while (executeQuery.next()) {
				count++;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return count;
	}

}
