package com.addressbook.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnDB {
	public Connection conn = null;
	public Statement stmt = null;
	public ResultSet rs = null;
	private static String propFileName = "connDB.properties";
	private static Properties prop = new Properties();
	private static String dbClassName = "com.mysql.jdbc.Driver";
	private static String dbURL = "jdbc:mysql://localhost:3306/mygrowth?user=root&password=''&useUnicode=true"; 
	public ConnDB(){
		try{
			InputStream in = getClass().getResourceAsStream(propFileName);
			prop.load(in);
			dbClassName = prop.getProperty("DB_CLASS_NAME");
			dbURL = prop.getProperty("DB_URL");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		try{
			Class.forName(dbClassName).newInstance();//装载数据库驱动
			conn = DriverManager.getConnection(dbURL);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(conn == null){
			System.err.println("警告：ConnDB.getConnection()获得数据库链接失败。\r\n链接类型："
					+ dbClassName+"\r\n链接位置："+dbURL);
		}
		return conn;
	}
	
	public ResultSet executeQuery(String sql){
		try{
			conn = getConnection();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
		}catch(SQLException e){
			System.err.println(e.getMessage());
		}
		return rs;
	}
	
	public int executeUpdate(String sql){
		int result = 0;
		try{
			conn = getConnection();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			result = stmt.executeUpdate(sql);
		}catch(SQLException ex){
			result = 0;
		}
		return result;
	}
	
	public void close(){
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
		}catch(Exception e){
			e.printStackTrace(System.err);
		}
	}
}
