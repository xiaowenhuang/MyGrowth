package sven.service.impl;

import sven.dao.ShowMyselfDao;
import sven.dao.impl.ShowMyselfDaoImpl;
import sven.model.Sven;
import sven.service.ShowMyselfService;

public class ShowMyselfServiceImpl implements  ShowMyselfService{
	ShowMyselfDao sMD = new ShowMyselfDaoImpl();
	public Sven show() {
		
		return sMD.show();
	}

}
