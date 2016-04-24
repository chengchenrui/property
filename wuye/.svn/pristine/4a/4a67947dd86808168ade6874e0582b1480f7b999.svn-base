package com.wuye.client.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.wuye.action.UserAction;
import com.wuye.common.MyBaseAction;
import com.wuye.service.IHouseService;
import com.wuye.service.IUserService;

public class UserClientAction extends MyBaseAction {
	private static final Logger logger = Logger.getLogger(UserAction.class);
	
	private IUserService userService;
	private IHouseService houseService;
	private List backList;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IHouseService getHouseService() {
		return houseService;
	}

	public void setHouseService(IHouseService houseService) {
		this.houseService = houseService;
	}

	public List getBackList() {
		return backList;
	}

	public void setBackList(List backList) {
		this.backList = backList;
	}
	/**
	 * 转到登录页面
	 * @return
	 */
	public String toLogin(){
		return "cliLogin";
	}
	/**
	 * 转到注册页面
	 * @return
	 */
	public String toAdd(){
		return "cliAdd";
	}
	
}
