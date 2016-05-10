package com.wuye.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.wuye.common.MyBaseAction;
import com.wuye.service.ICarService;
import com.wuye.util.AppConstants;
import com.wuye.util.PagingTool;
import com.wuye.util.Tools;

public class CarAction extends MyBaseAction {
	private static final Logger logger = Logger.getLogger(CarAction.class);

	private ICarService carService;
	private List backList;
	private String dateStart;
	private String dateEnd;

	public ICarService getCarService() {
		return carService;
	}

	public void setCarService(ICarService carService) {
		this.carService = carService;
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
		String location = this.getRequest().getParameter("q_location");
		String carNum = this.getRequest().getParameter("q_carNum");
		String stateStr = this.getRequest().getParameter("q_state");
		
		this.getRequest().setAttribute("q_location", location);
		this.getRequest().setAttribute("q_carNum", carNum);
		
		int state = -1;
		try {
			state = Integer.parseInt(stateStr);
		} catch (Exception e) {
		}
		
		this.getRequest().setAttribute("q_state", state);
		
		int size = AppConstants.DATA_SIZE;
		int start = 0;
		try {
			start = Integer.parseInt(this.getRequest().getParameter("start"));
		} catch (Exception e) {
		}
		
		backList = carService.findByPrama(location, carNum, state, startDate, endDate, start, size);
		int countNum = carService.findByCount(location, carNum, state, startDate, endDate);
		logger.info("countNum="+countNum);
		
		HttpServletRequest request = this.getRequest();
		PagingTool.paging(request, countNum, start, size);
		
		return "carList";
	}
}
