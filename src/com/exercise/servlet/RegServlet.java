package com.exercise.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exercise.bean.User;
import com.exercise.dao.UserDao;
@SuppressWarnings("serial")
public class RegServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String photo = request.getParameter("photo");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		UserDao userDao = new UserDao();
		if(username != null && !username.isEmpty()){
			if(userDao.userIsExist(username)){
				User user = new User();
				user.setUsername(username);
				user.setPassword(password);
				user.setSex(sex);
				user.setPhoto(photo);
				user.setTel(tel);
				user.setEmail(email);
				userDao.saveUser(user);
				request.setAttribute("info", "恭喜！注册成功！<br/>");
			}else{
				request.setAttribute("info", "错误！此用户已存在！<br/>");
			}
		}
		request.getRequestDispatcher("message.jsp").forward(request, response);
				
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
}
