package com.wuye.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.wuye.model.Managers;
import com.wuye.service.IManagersService;
import com.wuye.util.MD5;

public class ManagersAction extends ActionSupport {

	private IManagersService managersService;

	public IManagersService getManagersService() {
		return managersService;
	}

	public void setManagersService(IManagersService managersService) {
		this.managersService = managersService;
	}

}
