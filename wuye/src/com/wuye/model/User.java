package com.wuye.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String userName;
	private String password;
	private String userHouse;
	private String phone;
	private String mail;
	private String description;
	private Date createTime;
	private Date updateTime;
	private String userIcon;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String name, String userName, String userHouse,
			String password, String phone, String mail, String description,
			Date createTime, Date updateTime, String userIcon) {
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.userHouse = userHouse;
		this.phone = phone;
		this.mail = mail;
		this.description = description;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.userIcon = userIcon;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserHouse() {
		return userHouse;
	}

	public void setUserHouse(String userHouse) {
		this.userHouse = userHouse;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUserIcon() {
		return this.userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}

}