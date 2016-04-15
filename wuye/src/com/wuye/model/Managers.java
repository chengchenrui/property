package com.wuye.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Managers entity. @author MyEclipse Persistence Tools
 */

public class Managers implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String userName;
	private String password;
	private String phone;
	private String description;
	private Date createTime;
	private Date updateTime;

	// Constructors

	/** default constructor */
	public Managers() {
	}

	/** full constructor */
	public Managers(String name, String userName, String password,
			String phone, String description, Timestamp createTime,
			Timestamp updateTime) {
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.description = description;
		this.createTime = createTime;
		this.updateTime = updateTime;
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
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

}