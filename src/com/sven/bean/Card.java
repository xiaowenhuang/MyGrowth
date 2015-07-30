package com.sven.bean;

import java.math.BigDecimal;

public class Card {
	/**主键**/
	private int id;
	/**卡号**/
	private String card_no;
	/**卡名**/
	private String card_name;
	/**资产**/
	private BigDecimal money;
	/**持卡人**/
	private String card_owner;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCard_no() {
		return card_no;
	}
	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}
	public String getCard_name() {
		return card_name;
	}
	public void setCard_name(String card_name) {
		this.card_name = card_name;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public String getCard_owner() {
		return card_owner;
	}
	public void setCard_owner(String card_owner) {
		this.card_owner = card_owner;
	}
	

}
