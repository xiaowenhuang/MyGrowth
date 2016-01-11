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
	CardDao cardDao = new CardDao();
	public List<Card> queryCard(String cardNo, String cardOwner) {
		return cardDao.queryCard(cardNo, cardOwner);
	}

	public Card queryOneCard(String cardNo, String cardOwner) {
		return cardDao.queryOneCard(cardNo, cardOwner);
	}

	public void saveCard(Card card) {
		cardDao.saveCard(card);
	}

	public void deleteCard(Card card) {
		cardDao.deleteCard(card);
	}

	public int getRecordCount() {
		return cardDao.getRecordCount();
	}

}
