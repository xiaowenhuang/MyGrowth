package com.sven.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sven.bean.Card;
import com.sven.service.CardService;
import com.sven.util.Paging;

@SuppressWarnings("serial")
@Controller
@RequestMapping("card")
public class CardServlet extends HttpServlet {
	CardService cardService = new CardService();
	
	@RequestMapping("doPost")
	//@ResponseBody
	protected void testPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置编码
		req.setCharacterEncoding("UTF-8");
		//接收页面参数
		String cardNo = req.getParameter("cardNo");
		String cardOwner = req.getParameter("cardOwner");
		String currentPage = req.getParameter("currentPage");//当前页
		if(currentPage==null){
			currentPage = "1";
		}
		String pageSize = "10";//req.getParameter("pageSize");//每页显示记录数,默认10
		
		//页面参数定义
		Paging page = new Paging(Integer.valueOf(currentPage),Integer.valueOf(pageSize));
		int recordCount = cardService.getRecordCount();
		page.initiatePage(recordCount);
		List<Card> cardList = cardService.queryCard(cardNo,cardOwner);
		page.setReturnValue(cardList);
		//向页面传值
		req.setAttribute("cardNo",cardNo);
		req.setAttribute("cardOwner", cardOwner);
		/**
		 * servlet只负责接收和回传，业务逻辑在service层处理
		 */

		//req.setAttribute("queryList", cardService.queryCard(cardNo,cardOwner));
		req.setAttribute("queryList", cardList);
		
		//向页面跳转
		req.getRequestDispatcher("/WEB-INF/jsp/back/cardList.jsp").forward(req, resp);
		//return page;
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
