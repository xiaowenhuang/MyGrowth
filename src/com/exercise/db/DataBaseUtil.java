package com.exercise.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtil {
	/**
	 * 原始获取数据库连接的方法
	 * 
	 * @author Sven
	 * 
	 */
	public static Connection getConnection() {

		Connection conn = null;
		try {
			// load driver
			Class.forName("com.mysql.jdbc.Driver");
			// database connect url
			String url = "jdbc:mysql://127.0.0.1:3306/mygrowth?characterEncoding=utf8";
			// get db connect
			conn = DriverManager.getConnection(url, "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return conn;
	}

	/**
	 * 关闭数据库连接
	 */
	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
