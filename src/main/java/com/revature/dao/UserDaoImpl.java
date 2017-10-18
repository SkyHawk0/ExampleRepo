package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.beans.UserTable;

public class UserDaoImpl implements UserDao{

	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "school_db";
	private static final String PASSWORD = "p4ssw0rd";

	@Override
	public UserTable getUserByUsername(UserTable user) {
		UserTable sUser = null;
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			String sql = "SELECT * FROM s_user WHERE u_username = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getU_username());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				sUser = new UserTable(rs.getInt("U_ID"), rs.getString("U_FN"), rs.getString("U_LN"), rs.getString("U_USERNAME"),
						 rs.getString("U_PASSWORD"), rs.getInt("UR_ID"), rs.getString("U_EMAIL"));
			};
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	
		return sUser;

	}
	

	@Override
	public void saveUser(UserTable user) {

		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);){
			String sql = "INSERT INTO s_user (u_fn, u_ln, u_username, u_password, ur_id, u_email) VALUES (?, ?, ?, ?, 1, ?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getU_fn());
			ps.setString(2, user.getU_ln());
			ps.setString(3, user.getU_username());
			ps.setString(4, user.getU_password());
			ps.setString(5, user.getU_email());
			ps.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
//	public static void main(String[] args) {
////		UserTable u = new UserTable("owner");
////		u = new UserDaoImpl().getUserByUsername(u);
////		System.out.println(u);
//		UserTable u = new UserTable("Bob", "Test", "hate", "this", "bob123@aol.com");
//		System.out.println(u);
//		new UserDaoImpl().saveUser(u);
//		u = new UserDaoImpl().getUserByUsername(u);
//		System.out.println(u);
//	}
	
}
