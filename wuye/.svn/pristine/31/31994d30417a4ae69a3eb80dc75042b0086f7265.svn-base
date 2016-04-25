package com.wuye.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.wuye.common.MyBaseAction;
import com.wuye.service.IHouseService;
import com.wuye.util.AppConstants;
import com.wuye.util.PagingTool;
import com.wuye.util.Tools;

public class HouseAction extends MyBaseAction {
	private static final Logger logger = Logger.getLogger(HouseAction.class);
	private IHouseService houseService;
	private List backList;
	private String dateStart;
	private String dateEnd;

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
	 * 查询房间信息
	 * @return
	 */
	public String queryData(){
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
		
		String userName = this.getRequest().getParameter("q_userName");
		String houseNum = this.getRequest().getParameter("q_houseNum");
		this.getRequest().setAttribute("q_userName", userName);
		this.getRequest().setAttribute("q_houseNum", houseNum);
		int start = 0;
		try {
			start = Integer.parseInt(this.getRequest().getParameter("start"));
		} catch (Exception e) {
			
		}
		int size = AppConstants.DATA_SIZE;
		backList = houseService.findByPrama(userName, houseNum, startDate, endDate, start, size);
		int countNum = houseService.findCount(userName, houseNum, startDate, endDate);
		
		HttpServletRequest request = this.getRequest();
		PagingTool.paging(request, countNum, start, size);
		return "houseList";
	}

}
