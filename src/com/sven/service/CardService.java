package com.sven.service;

import java.util.List;

import com.sven.bean.Card;
import com.sven.dao.CardDao;
/**
 * 业务逻辑层卡显示的相关业务逻辑
 * @author Sven
 *
 */
public class CardService {

	public List<Card> queryCard(String cardNo, String cardOwner) {
		// TODO Auto-generated method stub
		CardDao cardDao = new CardDao();
		return cardDao.queryCard(cardNo, cardOwner);
	}

	public Card queryOneCard(String cardNo, String cardOwner) {
		// TODO Auto-generated method stub
		CardDao cardDao = new CardDao();
		return cardDao.queryOneCard(cardNo, cardOwner);
	}

	public void saveCard(Card card) {
		CardDao cardDao = new CardDao();
		cardDao.saveCard(card);
		// TODO Auto-generated method stub
		
	}

}
