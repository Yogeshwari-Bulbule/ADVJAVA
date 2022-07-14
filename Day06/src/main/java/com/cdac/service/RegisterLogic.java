package com.cdac.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;

public class RegisterLogic {
	public boolean isStudentPresent(String email) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_for_jdbc", "anuj", "cdac");
			boolean present = false;
			PreparedStatement st = conn.prepareStatement("select count(*) from studentsdb where email = ?");
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				int c = rs.getInt(1);
				if (c == 1) {
					present = true;
				}
			}
			return present;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}
	
	public boolean registerStudent(String name, String email, long mobileno, String username, String password) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_for_jdbc", "anuj", "cdac");
			boolean registered = false;
			String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
						
			PreparedStatement st = conn.prepareStatement("insert into studentsdb (name, email, mobileno, username, password) values (?, ?, ?, ?, ?)");
			st.setString(1, name);
			st.setString(2, email);
			st.setLong(3, mobileno);
			st.setString(4, username);
			st.setString(5, encodedPassword);
			int updated = st.executeUpdate();
			if (updated > 0) {
				registered = true;
			}
			 return registered;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}
}
