package com.cdac.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;

public class LoginLogic {
	public boolean isCheck(String username, String password) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_for_jdbc", "anuj", "cdac");
			boolean check = false;
			PreparedStatement st = conn.prepareStatement("select username, password from studentsdb where username = ?");
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				String uname = rs.getString(1);
				String upass = rs.getString(2);
				byte[] decodedBytes = Base64.getDecoder().decode(upass);
				String decodedPassword = new String(decodedBytes);
				if (username.equals(uname) && password.equals(decodedPassword)) {
					check = true;
				}
			}
			return check;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		} finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}
}
