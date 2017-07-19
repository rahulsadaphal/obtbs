package com.manipal.DAO.jdbc;


import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.manipal.util.StringUtil;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;



public final class ConnectionHelper {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Connection con = getMySqlConnection();
		if(con!=null)
			System.out.println("connected");
	}

	public static Connection getMySqlConnection () throws ClassNotFoundException, SQLException, IOException
	{
		Properties props = StringUtil.getPropertiesFromClasspath("data.properties");
		//Load the driver
		String driverName= props.getProperty("jdbc.driver.name");
		Class.forName(driverName);
		
		//To get the connection we need url, user, password
		String url=props.getProperty("jdbc.url");
		String user=props.getProperty("jdbc.username");
		String pwd=props.getProperty("jdbc.password");
		
		Connection conn=(Connection) DriverManager.getConnection(url, user, pwd);
		return conn;
		
	}
	
	public static void cleanup(Connection conn, Statement stmt, ResultSet rs){
		try{
			if(rs != null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//LOGGER.error(e.getMessage());
		}
	}
	
	public static void cleanup(Connection conn, PreparedStatement stmt, ResultSet rs){
		try{
			if(rs != null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//LOGGER.error(e.getMessage());
		}
	}
}
