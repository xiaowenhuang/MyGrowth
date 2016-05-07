package sven.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sven.model.Sven;
import sven.service.ShowMyselfService;
import sven.service.impl.ShowMyselfServiceImpl;
/*
 * 展示我这个对象
 */
@Controller
@RequestMapping("show")//if not define it will default be showMyselfAction
public class ShowMyselfAction {
	@RequestMapping(value="sven",method=RequestMethod.GET)
	public void showMyself(Model model){
		Sven sven = new Sven();
		ShowMyselfService sMS = new ShowMyselfServiceImpl();
		sven = sMS.show();
		model.addAttribute(sven);
	}
}
