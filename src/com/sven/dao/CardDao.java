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
	DBAccess dbAccess = new DBAccess();
	SqlSession sqlSession = null;
	
	//查询所有卡
	public List<Card> queryCard(String cardNo, String cardOwner) {
		List<Card> cardList = new ArrayList<Card>();
		try{
			sqlSession = dbAccess.getSqlSession();
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
	//修改查询
	public Card queryOneCard(String cardNo, String cardOwner) {
		Card card = new Card();
		try{
			sqlSession = dbAccess.getSqlSession();
			Card param=  new Card();
			param.setCard_owner(cardOwner);
			param.setCard_no(cardNo);
			card = sqlSession.selectOne("Card.cardList",param);
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return card;
	}
	//保存数据
	public void saveCard(Card card) {
		try{
			sqlSession = dbAccess.getSqlSession();
			sqlSession.insert("Card.insertCard", card);
			sqlSession.commit();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		
	}
	public void deleteCard(Card card) {
		try{
			sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("Card.deleteCard", card);
			sqlSession.commit();
			
		}catch(IOException e){
			e.printStackTrace();
		}
		finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		
	}
	public int getRecordCount() {
		int recordCount = 0;
		try{
			sqlSession = dbAccess.getSqlSession();
			recordCount = sqlSession.selectOne("Card.recordCount");
		}catch(IOException e ){
			e.printStackTrace();
		}finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return recordCount;
	}

}
