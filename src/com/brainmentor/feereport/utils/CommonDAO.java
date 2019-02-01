
package com.brainmentor.feereport.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CommonDAO {

	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		ResourceBundle rb = ResourceBundle.getBundle("config");
		String  name = rb.getString("username");
		String pwd = rb.getString("password");
		String url = rb.getString("dbURL");
		Connection con = DriverManager.getConnection(url,name,pwd);
		return con;
	}
	
}
