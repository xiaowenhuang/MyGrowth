package com.addressbook.model;

/**
 * 模型层
 * @author Sven
 *
 */
public class UserForm {
	private int id = 0;
	private String name;
	private String pwd;
	private String email;
	private String abode;//居住地属性
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the abode
	 */
	public String getAbode() {
		return abode;
	}
	/**
	 * @param abode the abode to set
	 */
	public void setAbode(String abode) {
		this.abode = abode;
	}
}
