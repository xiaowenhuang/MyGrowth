package com.exercise.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exercise.bean.User;
import com.exercise.db.DataBaseUtil;

public class UserDao {
	
	public boolean userIsExist(String username){
		Connection conn = DataBaseUtil.getConnection();
		String sql = "select * from tb_use where username=?";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(!rs.next()){
				return true;
			}
			rs.close();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeConnection(conn);
		}
		return false;
	}
	
	public void saveUser(User user){
		Connection conn = DataBaseUtil.getConnection();
		String sql = "insert into tb_use(username,password,sex,tel,photo,email)values(?,?,?,?,?,?)";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getSex());
			ps.setString(4, user.getTel());
			ps.setString(5, user.getPhoto());
			ps.setString(6, user.getEmail());
			ps.executeUpdate();
			ps.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeConnection(conn);
		}
	}
	
	public User login(String username, String password){
		User user = null;
		Connection conn = DataBaseUtil.getConnection();
		String sql = "select * from tb_use where username=? and password=?";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getString("sex"));
				user.setTel(rs.getString("tel"));
				user.setPhoto(rs.getString("photo"));
				user.setEmail(rs.getString("email"));
			}
			rs.close();
			ps.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeConnection(conn);
		}
		return user;
	}

}
