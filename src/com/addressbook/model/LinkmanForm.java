package com.addressbook.model;

public class LinkmanForm {
	private int id = 0;
	private String name;
	private String tel;
	private String mobileTel;
	private String email;
	private String address;
	private String postCode;
	private int byUser;
	private int byGroup;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMobileTel() {
		return mobileTel;
	}
	public void setMobileTel(String mobileTel) {
		this.mobileTel = mobileTel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public int getByUser() {
		return byUser;
	}
	public void setByUser(int byUser) {
		this.byUser = byUser;
	}
	public int getByGroup() {
		return byGroup;
	}
	public void setByGroup(int byGroup) {
		this.byGroup = byGroup;
	}
}
