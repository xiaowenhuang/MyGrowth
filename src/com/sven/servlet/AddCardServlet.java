package com.sven.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sven.bean.Card;
import com.sven.service.CardService;

/**
 * 新增卡片业务控制层
 * @author Sven
 *
 */
@Controller
@RequestMapping("add")
public class AddCardServlet {
	private String backUrl = ""; 
	//跳转到新增页面
	@RequestMapping(value="newCard",method=RequestMethod.GET)
	String addNewCard( HttpServletRequest req){
		backUrl = req.getRequestURI();
		return "back/add";
	}
	//保存新增数据并跳转回初始查询页面
	@RequestMapping(value="saveCard",method=RequestMethod.GET)
	void addCardData(Card card, HttpServletRequest req,HttpServletResponse res){
		//card.setId(id);
		//backUrl = req.getRequestURI();
		System.out.println("test:"+backUrl);
		
		CardService cardService = new CardService();
		cardService.saveCard(card);
		try {
			res.sendRedirect("/MyGrowth/card/doPost");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
