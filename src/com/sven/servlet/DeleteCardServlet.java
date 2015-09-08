package com.sven.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sven.bean.Card;
import com.sven.service.CardService;

/**
 * 删除数据
 * @author Sven
 *
 */
@Controller
@RequestMapping("delete")
public class DeleteCardServlet {
	//private HttpServletResponse response = ;

	@RequestMapping(value="delCard",method=RequestMethod.GET)
	public void  deleteCard(Card card,HttpServletResponse response) throws IOException{
		CardService cardService = new CardService();
		cardService.deleteCard(card);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print("{\"success\":true }");
		response.getWriter().flush();
		//return "back/cardList";
		//response = null;
		
	}

}
