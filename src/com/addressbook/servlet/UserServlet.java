package com.addressbook.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.addressbook.db.ConnDB;

@SuppressWarnings("serial")
public class UserServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getParameter("action");
		if("register".equals(action)){
			this.register(req,resp);
		}else if("login".equals(action)){
			this.login(req,resp);
		}else if("exit".equals(action)){
			this.exit(req,resp);
		}
	}
	/**
	 * 注册
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void register(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("user");
		String pwd = req.getParameter("pwd");
		String email = req.getParameter("email");
		String abode = req.getParameter("abode");
		String message = "";
		String url = "";
		ConnDB conn = new ConnDB();
		String sql = "select * from tb_user where name='"+name+"'";
		ResultSet rs = conn.executeQuery(sql);
		try{
			if(rs.next()){
				message = "该用户已经被注册";
				url = "register.jsp";
			}else{
				String sql_ins = "insert into tb_user(name,pwd,email,abode)values('"
						+name+"','"+pwd+"','"+email+"','"+abode+"' )";
				int rtn = conn.executeUpdate(sql_ins);
				if(rtn > 0){
					message = "用户注册成功";
					url = "login.jsp"; 
				}else{
					message = "用户注册失败";
					url = "register.jsp";
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			conn.close();
		}
		req.setAttribute("message", message);
		req.setAttribute("url", url);
		req.getRequestDispatcher("register_ok.jsp").forward(req, resp);
	}
	/**
	 * 登陆
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("user");
		String pwd = req.getParameter("pwd");
		String message = "";
		ConnDB conn = new ConnDB();
		String sql = "select * from tb_user where name='"+name+"'";
		ResultSet rs = conn.executeQuery(sql);
		try{
			int id = 0;
			if(rs.next()){
				id = rs.getInt("id");
				if(pwd.equals(rs.getString("pwd"))){
					HttpSession  session = req.getSession();
					session.setAttribute("user", name);
					session.setAttribute("pwd", pwd);
					session.setAttribute("id", id);
					req.getRequestDispatcher("LinkmanServlet?action=query").forward(req, resp);
					return;
				}else{
					message = "你输入的用户名或密码错误";
				}
			}else{
				message = "你输入的用户名或密码错误";
			}
		}catch(SQLException e){
			e.printStackTrace();
			message="登陆失败";
		}finally{
			conn.close();
		}
		req.setAttribute("message", message);
		req.getRequestDispatcher("deal.jsp").forward(req, resp);
	}
	
	public void exit(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException,IOException{
		HttpSession session = req.getSession();
		session.invalidate();
	}
	
}
