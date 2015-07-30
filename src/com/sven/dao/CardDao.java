package com.sven.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.sven.bean.Card;
import com.sven.db.DBAccess;

/**
 * 卡数据操作类
 * @author Sven
 *
 */
public class CardDao {

	public List<Card> queryCard(String cardNo, String cardOwner) {
		// TODO Auto-generated method stub
		DBAccess dbAcess = new DBAccess();
		List<Card> cardList = new ArrayList<Card>();
		SqlSession sqlSession = null;
		try{
			sqlSession = dbAcess.getSqlSession();
			Card param = new Card();
			param.setCard_no(cardNo);
			param.setCard_owner(cardOwner);
			cardList = sqlSession.selectList("Card.cardList", param);
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			// 通过sqlSession执行Sql语句
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return cardList;
	}

}
