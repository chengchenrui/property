package com.wuye.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.wuye.common.MyBaseAction;
import com.wuye.service.IManagersService;
import com.wuye.util.AppConstants;
import com.wuye.util.PagingTool;
import com.wuye.util.Tools;

public class ManagersAction extends MyBaseAction {
	private static final Logger logger = Logger.getLogger(ManagersAction.class);

	private IManagersService managersService;
	private List backList;
	private String dateStart;
	private String dateEnd;

	public IManagersService getManagersService() {
		return managersService;
	}

	public void setManagersService(IManagersService managersService) {
		this.managersService = managersService;
	}

	public List getBackList() {
		return backList;
	}

	public void setBackList(List backList) {
		this.backList = backList;
	}

	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	/**
	 * 转到查询页面
	 * 
	 * @return
	 */
	public String toQueryData() {
		return null;

	}

	/**
	 * 查询数据
	 * 
	 * @return
	 */
	public String queryData() {
		Date startDate = null;
		Date endDate = null;
		try {
			if (dateStart != null && dateStart.length() > 0) {
				startDate = Tools.STRING_TO_DATE(dateStart);
			}
		} catch (Exception e) {
			startDate = new Date();
		}
		try {
			if (dateEnd != null && dateEnd.length() > 0) {
				endDate = Tools.STRING_TO_DATE(dateEnd);
				endDate = Tools.GET_TOMORROW(endDate);
			}
		} catch (Exception e) {
			endDate = new Date();
		}

		String name = this.getRequest().getParameter("q_name");
		int start = 0;
		try {
			start = Integer.parseInt(this.getRequest().getParameter("start"));
		} catch (Exception e) {

		}
		int size = AppConstants.DATA_SIZE;
		backList = managersService.findByParam(name, startDate, endDate, start,
				size);
		int countNum = managersService.findCount(name, startDate, endDate);

		this.getRequest().setAttribute("q_name", name);
		this.getRequest().setAttribute("start", start);

		// 分页
		HttpServletRequest request = this.getRequest();
		PagingTool.paging(request, countNum, start, size);

		return "managersList";
	}

}
