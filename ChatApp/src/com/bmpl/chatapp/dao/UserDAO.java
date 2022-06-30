package com.bmpl.chatapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bmpl.chatapp.dto.UserDTO;

public class UserDAO {

	public boolean isLogin(UserDTO userDTO) throws ClassNotFoundException, SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String query = "select user_id from users where user_id=? and pwd=?";

		try {
			String userId = userDTO.getUserId();
			String password = new String(userDTO.getPassword());
			
			conn = CommonDAO.createConnection();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			return rs.next();
		}
		finally {
			if(pstmt != null) {
				pstmt.close();
			}
			if(rs != null) {
				rs.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
		
	}
	
	public int register(UserDTO userDTO) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Statement stmt = null;
		
//		Create connection for user...
		try {
			conn = CommonDAO.createConnection();
			stmt = conn.createStatement();
			
			String userId = userDTO.getUserId();
			String password = new String(userDTO.getPassword());
			
			String query = "insert into users(user_id, pwd) values('" + userId + "','" + password + "')";
			int record = stmt.executeUpdate(query);
			
			return record;
		}
		finally {
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}
	}
	
}
