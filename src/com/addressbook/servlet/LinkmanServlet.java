package com.addressbook.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.addressbook.db.ConnDB;
import com.addressbook.model.LinkmanForm;

@SuppressWarnings("serial")
public class LinkmanServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session.getAttribute("user") == null || session.getAttribute("id") == null){
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('你的帐号已过期， 请重新登陆');window.location.href='login.jsp'</script>");
		}else{
			String action = req.getParameter("action");
			if("query".equals(action)){
				this.query(req, resp);
			}else if("queryLinkman".equals(action)){
				this.queryLinkman(req,resp);
			}else if("add".equals(action)){
				this.add(req,resp);
			}else if("del".equals(action)){
				this.del(req,resp);
			}else if("modify".equals(action)){
				this.modify(req,resp);
			}else if("saveModify".equals(action)){
				this.saveModify(req,resp);
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
	}
	public void query(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		ConnDB conn = new ConnDB();
		int id = Integer.parseInt(req.getSession().getAttribute("id").toString());
		String sql = "select count(*) from tb_linkman where byUser='"+id+"'";
		ResultSet rs = conn.executeQuery(sql);
		int count = 0 ;
		try{
			if(rs.next()){
				count = rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			conn.close();
		}
		req.setAttribute("linkmanCount", count);
		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}
	
	public void add(HttpServletRequest req,HttpServletResponse resp) 
			throws ServletException, IOException {
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		String mobileTel = req.getParameter("mobileTel");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String postcode = req.getParameter("postcode");
		String byUser = req.getSession().getAttribute("id").toString();
		String byGroup = req.getParameter("byGroup");
		String message = "";
		ConnDB conn = new ConnDB();
		String sql = "insert into tb_linkman(name,tel,mobileTel,email,address,postcode,byUser,byGroup)"
				+ "values('"+name+"','"+tel+"','"+mobileTel+"','"+email+"','"+address+"','"+postcode+"','"+byUser
				+"','"+byGroup+"')";
		int rtn = conn.executeUpdate(sql);
		if(rtn>0){
			message="联系人添加成功";
		}else{
			message="联系人添加失败";
		}
		conn.close();
		req.setAttribute("message", message);
		req.getRequestDispatcher("deal.jsp").forward(req, resp);
	}
	
	public void modify(HttpServletRequest req,HttpServletResponse resp) 
			throws ServletException, IOException {
		ConnDB conn = new ConnDB();
		String linkID = req.getParameter("linkID");
		String sql = "select * from tb_linkman where id='"+linkID+"'";
		ResultSet rs = conn.executeQuery(sql);
		LinkmanForm f = new LinkmanForm();
		try{
			if(rs.next()){
				f.setId(rs.getInt(1));
				f.setName(rs.getString(2));
				f.setTel(rs.getString(3));
				f.setMobileTel(rs.getString(4));
				f.setEmail(rs.getString(5));
				f.setAddress(rs.getString(6));
				f.setPostCode(rs.getString(7));
				f.setByGroup(rs.getInt(9));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			conn.close();
		}
		GroupServlet groupServlet = new GroupServlet();
		req.setAttribute("groupList", groupServlet.queryGroup());
		req.setAttribute("linkman", f);
		req.getRequestDispatcher("linkmanModify.jsp").forward(req, resp);
	}
	
	public void saveModify(HttpServletRequest req,HttpServletResponse resp) 
			throws ServletException, IOException {
		String linkID = req.getParameter("id");
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		String mobileTel = req.getParameter("mobileTel");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String postcode = req.getParameter("postcode");
		//String byUser = req.getSession().getAttribute("id").toString();
		String byGroup = req.getParameter("byGroup");
		String message = "";
		ConnDB conn = new ConnDB();
		String sql = "update tb_linkman set name='"+name+"',tel='"+tel+"'"
				+",mobileTel='"+mobileTel+"',email='"+email+"',address='"+address+"'"
				+",postcode='"+postcode+"',byGroup='"+byGroup+"' where id='"+linkID+"'";
		int rtn = conn.executeUpdate(sql);
		if(rtn>0){
			message = "修改联系人成功";
		}else{
			message = "修改联系人失败";
		}
		conn.close();
		req.setAttribute("message", message);
		req.getRequestDispatcher("deal.jsp").forward(req, resp);
	}
	
	public void queryLinkman(HttpServletRequest req,HttpServletResponse resp) 
			throws ServletException, IOException {
		
	}
	
	public void del(HttpServletRequest req,HttpServletResponse resp) 
			throws ServletException, IOException {
		String linkID = req.getParameter("linkID");
		String message = "";
		ConnDB conn = new ConnDB();
		String sql = "delete from tb_linkman where id='"+linkID+"'";
		int rtn = conn.executeUpdate(sql);
		if(rtn>0){
			message="联系人删除成功";
		}else{
			message="联系人删除失败";
		}
		conn.close();
		req.setAttribute("message", message);
		req.getRequestDispatcher("deal.jsp").forward(req, resp);
	}

}
