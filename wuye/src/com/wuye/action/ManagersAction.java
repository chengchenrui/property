package com.wuye.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.wuye.common.MyBaseAction;
import com.wuye.model.Managers;
import com.wuye.service.IManagersService;
import com.wuye.util.AppConstants;
import com.wuye.util.MD5;
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

	/**
	 * 转到添加页面
	 * 
	 * @return
	 */
	public String toAddDate() {
		return "addMag";
	}

	public String addDate() {
		String name = this.getRequest().getParameter("name");
		String userName = this.getRequest().getParameter("userName");
		String phone = this.getRequest().getParameter("phone");
		String description = this.getRequest().getParameter("description");

		this.getRequest().setAttribute("name", name);
		this.getRequest().setAttribute("userName", userName);
		this.getRequest().setAttribute("phone", phone);
		this.getRequest().setAttribute("description", description);

		if (Tools.isEmptyString(name) == true) {
			addFieldError("name", getText("*管理员姓名不能为空！"));
			return "addMag";
		}
		if (Tools.isEmptyString(userName) == true) {
			addFieldError("userName", getText("*用户名不能为空！"));
			return "addMag";
		}
		backList = managersService.findByUserName(userName);
		if (backList != null && backList.size() > 0) {
			addFieldError("userName", getText("*用户名“" + userName + "”已存在！"));
			return "addMag";
		}
		if (Tools.isEmptyString(phone) == true) {
			addFieldError("phone", getText("*电话号不能为空！"));
			return "addMag";
		}

		Managers manager = new Managers();
		manager.setName(name);
		manager.setUserName(userName);
		manager.setPhone(phone);
		manager.setPassword(MD5
				.getMD5Code(AppConstants.MANAGER_DEFAULT_PASSWORD));
		manager.setDescription(description);
		manager.setCreateTime(new Date());

		managersService.save(manager);

		return "toList";
	}

	/**
	 * 转到修改
	 * 
	 * @return
	 */
	public String toUpdate() {
		String id = this.getRequest().getParameter("id");
		Managers manager = managersService.findById(Integer.parseInt(id));
		if (manager == null) {
			addFieldError("manager", getText("管理员不存在！"));
			return "error";
		}
		this.getRequest().setAttribute("id", id);
		this.getRequest().setAttribute("name", manager.getName());
		this.getRequest().setAttribute("userName", manager.getUserName());
		this.getRequest().setAttribute("phone", manager.getPhone());
		this.getRequest().setAttribute("description", manager.getDescription());

		// 修改完回到原页面
		String name = this.getRequest().getParameter("q_name");
		String start = this.getRequest().getParameter("start");
		this.getRequest().setAttribute("q_name", name);
		this.getRequest().setAttribute("start", start);

		return "magUpdate";
	}

	/**
	 * 修改
	 * 
	 * @return
	 */
	public String updateData() {
		String id = this.getRequest().getParameter("id");
		String name = this.getRequest().getParameter("name");
		String userName = this.getRequest().getParameter("userName");
		String phone = this.getRequest().getParameter("phone");
		String description = this.getRequest().getParameter("description");

		this.getRequest().setAttribute("id", id);
		this.getRequest().setAttribute("name", name);
		this.getRequest().setAttribute("userName", userName);
		this.getRequest().setAttribute("phone", phone);
		this.getRequest().setAttribute("description", description);

		String q_name = this.getRequest().getParameter("q_name");
		String start = this.getRequest().getParameter("start");

		if (Tools.isEmptyString(name) == true) {
			addFieldError("name", getText("*管理员姓名不能为空！"));
			this.getRequest().setAttribute("q_name", q_name);
			this.getRequest().setAttribute("start", start);
			return "magUpdate";
		}
		if (Tools.isEmptyString(userName) == true) {
			addFieldError("userName", getText("*用户名不能为空！"));
			this.getRequest().setAttribute("q_name", q_name);
			this.getRequest().setAttribute("start", start);
			return "error";
		}
		Managers manager = managersService.findById(Integer.parseInt(id));
		List magList = managersService.findByUserName(userName);
		if (magList != null && magList.size() > 0) {
			int flag = 0;
			for (int i = 0; i < magList.size(); i++) {
				Managers magTemp = (Managers) magList.get(i);
				if (magTemp.getId() != Integer.parseInt(id)) {
					flag++;
				}
			}
			if (flag > 0) {
				addFieldError("userName", getText("*用户" + userName + "已存在！"));
				this.getRequest().setAttribute("q_name", q_name);
				this.getRequest().setAttribute("start", start);
				return "magUpdate";
			}
		}
		if (Tools.isEmptyString(phone) == true) {
			addFieldError("phone", getText("*电话号不能为空！"));
			this.getRequest().setAttribute("q_name", q_name);
			this.getRequest().setAttribute("start", start);
			return "magUpdate";
		}

		manager.setName(name);
		manager.setUserName(userName);
		manager.setPhone(phone);
		manager.setDescription(description);
		manager.setUpdateTime(new Date());

		managersService.merge(manager);

		return queryData();
	}
	public String deleteData(){
		String id = this.getRequest().getParameter("id");
		
		//返回元页面
		String name = this.getRequest().getParameter("q_name");
		String start = this.getRequest().getParameter("start");
		
		Managers manager = managersService.findById(Integer.parseInt(id));
		if(manager == null){
			addFieldError("manager", getText("管理员不存在！"));
			//返回元页面
			this.getRequest().setAttribute("q_name", name);
			this.getRequest().setAttribute("start", start);
			return "error";
		}
		
		try {
			managersService.delete(manager);
		} catch (Exception e) {
			logger.error("删除管理员出错", e);
		}
		//返回元页面
		this.getRequest().setAttribute("q_name", name);
		this.getRequest().setAttribute("start", start);
		
		return queryData();
	}
}
