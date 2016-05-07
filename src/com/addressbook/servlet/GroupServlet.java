package com.addressbook.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.addressbook.db.ConnDB;
import com.addressbook.model.GroupForm;

@SuppressWarnings("serial")
public class GroupServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getParameter("action");
		if("query".equals(action)){
			this.query(req,resp);
		}else if("query_add".equals(action)){
			this.query_add(req,resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List queryGroup(){
		ConnDB conn = new ConnDB();
		String sql = "select * from tb_group;";
		ResultSet rs = conn.executeQuery(sql);
		List list = new ArrayList();
		try{
			if(rs.next()){
				GroupForm f = new GroupForm();
				f.setId(rs.getInt(1));
				f.setName(rs.getString(2));
				list.add(f);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			conn.close();
		}
		return list;
	}
	
	public void query(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		req.setAttribute("groupList", queryGroup());
		req.getRequestDispatcher("left.jsp").include(req, resp);//forward跳到另一页面，而include还包含在原来的main页面
	}
	
	public void query_add(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException{
		req.setAttribute("groupList", queryGroup());
		req.getRequestDispatcher("linkmanAdd.jsp").forward(req, resp);
	}
}
