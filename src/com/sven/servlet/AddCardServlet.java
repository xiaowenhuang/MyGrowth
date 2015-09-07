package com.sven.servlet;

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
	
	//跳转到新增页面
	@RequestMapping(value="newCard",method=RequestMethod.GET)
	String addNewCard(){	
		return "back/add";
	}
	//保存新增数据并跳转回初始查询页面
	@RequestMapping(value="saveCard",method=RequestMethod.GET)
	String addCardData(Card card){
		//card.setId(id);
		CardService cardService = new CardService();
		cardService.saveCard(card);
		return "back/cardList";
	}

}
