package com.sven.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sven.bean.Card;
import com.sven.service.CardService;

/**
 * 修改function
 * @author Sven
 *
 */
@Controller
@RequestMapping("modify")
public class EditServlet {
	private Card card;

	@RequestMapping(value="edit",method=RequestMethod.GET)
	public String edit(@RequestParam("cardNo") String cardNo ,@RequestParam("cardOwner")String cardOwner,Model model){
		CardService cardService = new CardService();
		card = (Card) cardService.queryOneCard(cardNo,cardOwner);
		model.addAttribute(card);
		return "back/edit";
	}
}
