package com.bmpl.chatapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.bmpl.chatapp.dao.ConfigReader.getValue;

public interface CommonDAO {
	
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		// Step-1 : Load Driver
		Class.forName(getValue("DRIVER"));
		
		// Step:2 : Build Connection
		final String CON_STRING = getValue("CON_STRING");
		final String USER_ID = getValue("USER_ID");
		final String USER_PWD = getValue("USER_PWD");
		Connection con = DriverManager.getConnection(CON_STRING, USER_ID, USER_PWD);
		if(con != null) {
			System.out.println("Connection Created...");
//			con.close();
		}
		return con;
	}
	
//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		CommonDAO obj = new CommonDAO();
//		obj.createConnection();
//	}

}
