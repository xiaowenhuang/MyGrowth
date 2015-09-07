package com.sven.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sven.service.CardService;

@SuppressWarnings("serial")
@Controller
@RequestMapping("card")
public class CardServlet extends HttpServlet {
	@Override
	@RequestMapping("doPost")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置编码
		req.setCharacterEncoding("UTF-8");
		//接收页面参数
		String cardNo = req.getParameter("cardNo");
		String cardOwner = req.getParameter("cardOwner");
		//向页面传值
		req.setAttribute("cardNo",cardNo);
		req.setAttribute("cardOwner", cardOwner);
		/**
		 * servlet只负责接收和回传，业务逻辑在service层处理
		 */
		CardService cardService = new CardService();
		req.setAttribute("queryList", cardService.queryCard(cardNo,cardOwner));
		
		//向页面跳转
		req.getRequestDispatcher("/WEB-INF/jsp/back/cardList.jsp").forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	@RequestMapping(value="queryBy",method=RequestMethod.GET)
	String querySituation(@RequestParam("")String cardNo,@RequestParam("")String cardOwner,Model model){
		
		return "back/cardList";
	}
}
