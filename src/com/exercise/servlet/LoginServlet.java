package com.exercise.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exercise.bean.User;
import com.exercise.dao.UserDao;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		UserDao userDao = new UserDao();
		User user = userDao.login(username, password);
		if(user != null){
			req.getSession().setAttribute("user", user);
			req.getRequestDispatcher("message.jsp").forward(req, resp);
		}else{
			req.setAttribute("info", "用户名或密码错误！");
			req.getRequestDispatcher("message.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
