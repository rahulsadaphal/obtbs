package com.manipal.model;

import java.io.IOException;
import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class Sample {
	
	public static void main(String[] args) throws ClassNotFoundException, IOException 
	{ 
			try{  
			Class.forName("com.mysql.jdbc.Driver");  
			
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://35.188.185.251:3306/test","'root'@'%'","root");  
			
			if(con !=null)
			{
				System.out.println("Connected......");
			}
			else
			{
				System.out.println("Failed");
			}
			 
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
			}  

			
	

}
