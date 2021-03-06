package com.wuye.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.wuye.common.MyBaseAction;
import com.wuye.model.User;
import com.wuye.service.IUserService;
import com.wuye.util.AppConstants;
import com.wuye.util.PagingTool;
import com.wuye.util.Tools;
import com.wuye.util.json.JSONObject;

public class UserAction extends MyBaseAction {
	private static final Logger logger = Logger.getLogger(UserAction.class);

	private IUserService userService;
	private List backList;
	private String dateStart;
	private String dateEnd;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
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
	 * 查询用户
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
		String userHouse = this.getRequest().getParameter("q_userHouse");
		
		int start = 0;
		try {
			start = Integer.parseInt(this.getRequest().getParameter("start"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		int size = AppConstants.DATA_SIZE;
		backList = userService.findByParam(name,userHouse ,startDate, endDate,
				start, size);
		int backCount = userService.findCount(name, userHouse, startDate,
				endDate);

		this.getRequest().setAttribute("q_name", name);
		this.getRequest().setAttribute("q_userHouse", userHouse);
		this.getRequest().setAttribute("start", start);

		// 分页
		HttpServletRequest request = this.getRequest();
		PagingTool.paging(request, backCount, start, size);

		return "userList";
	}

	/**
	 * 转到修改页面
	 * 
	 * @return
	 */
	public String toUpdate() {
		String id = this.getRequest().getParameter("id");
		User user = userService.findById(Integer.parseInt(id));
		if (user == null) {
			addFieldError(id, getText("该用户不存在！"));
			return "error";
		}
		
		this.getRequest().setAttribute("id", id);
		this.getRequest().setAttribute("user", user);
		this.getRequest().setAttribute("name", user.getName());
		this.getRequest().setAttribute("userName", user.getUserName());
		this.getRequest().setAttribute("phone", user.getPhone());
		this.getRequest().setAttribute("mail", user.getMail());
		this.getRequest().setAttribute("userHouse", user.getUserHouse());
		this.getRequest().setAttribute("description", user.getDescription());

		// 使修改完成回到原页面
		String name = this.getRequest().getParameter("q_name");
		String userHouse = this.getRequest().getParameter("q_userHouse");
		String start = this.getRequest().getParameter("start");

		this.getRequest().setAttribute("q_name", name);
		this.getRequest().setAttribute("q_houseNum", userHouse);
		this.getRequest().setAttribute("start", start);

		return "userUpdate";
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
		String mail = this.getRequest().getParameter("mail");
		String userHouse = this.getRequest().getParameter("userHouse");
		String description = this.getRequest().getParameter("description");

		this.getRequest().setAttribute("id", id);
		this.getRequest().setAttribute("name", name);
		this.getRequest().setAttribute("userName", userName);
		this.getRequest().setAttribute("phone", phone);
		this.getRequest().setAttribute("mail", mail);
		this.getRequest().setAttribute("userHouse", userHouse);
		this.getRequest().setAttribute("description", description);
		
		String q_name = this.getRequest().getParameter("q_name");
		String q_userHouse = this.getRequest().getParameter("q_userHouse");
		String start = this.getRequest().getParameter("start");

		User user = userService.findById(Integer.parseInt(id));
		List userList = userService.findByUserName(userName);
		if (userList != null && userList.size() > 0) {
			int flag = 0;
			for (int i = 0; i < userList.size(); i++) {
				User userTemp = (User) userList.get(i);
				if (userTemp.getId() != Integer.parseInt(id)) {
					flag++;
				}
			}
			if (flag > 0) {
				addFieldError("userName", getText("*用户" + userName + "已存在！"));
				this.getRequest().setAttribute("q_name", q_name);
				this.getRequest().setAttribute("q_userHouse", q_userHouse);
				this.getRequest().setAttribute("start", start);
				return "userUpdate";
			}
		}

		if (Tools.isEmptyString(name) == true) {
			addFieldError("name", getText("*用户名不能为空！"));
			this.getRequest().setAttribute("q_name", q_name);
			this.getRequest().setAttribute("q_userHouse", q_userHouse);
			this.getRequest().setAttribute("start", start);
			return "userUpdate";
		}

		if (Tools.isEmptyString(userName) == true) {
			addFieldError("userName", getText("*用户名不能为空！"));
			this.getRequest().setAttribute("q_name", q_name);
			this.getRequest().setAttribute("q_userHouse", q_userHouse);
			this.getRequest().setAttribute("start", start);
			return "userUpdate";
		}

		if (Tools.isEmptyString(userHouse) == true) {
			addFieldError("house", getText("*房间号不能为空！"));
			this.getRequest().setAttribute("q_name", q_name);
			this.getRequest().setAttribute("q_userHouse", q_userHouse);
			this.getRequest().setAttribute("start", start);
			return "userUpdate";
		}

		if (Tools.isEmptyString(phone) == true) {
			addFieldError("phone", getText("*电话号码不能为空！"));
			this.getRequest().setAttribute("q_name", q_name);
			this.getRequest().setAttribute("q_userHouse", q_userHouse);
			this.getRequest().setAttribute("start", start);
			return "userUpdate";
		}
		if (Tools.isEmptyString(mail) == true) {
			addFieldError("mail", getText("*邮箱不能为空！"));
			this.getRequest().setAttribute("q_name", q_name);
			this.getRequest().setAttribute("q_userHouse", q_userHouse);
			this.getRequest().setAttribute("start", start);
			return "userUpdate";
		}

		user.setName(name);
		user.setUserName(userName);
		user.setPhone(phone);
		user.setMail(mail);
		user.setUserHouse(userHouse);
		user.setDescription(description);
		user.setUpdateTime(new Date());

		userService.merge(user);

		return queryData();
	}
	/**
	 * 用userName查询返回json
	 * @return
	 */
	public String queryByUserName() {
		String userName = this.getRequest().getParameter("userName");
		try {
			backList = userService.findByUserName(userName);
			JSONObject dataTemp = new JSONObject();
			if (backList != null && backList.size() > 0) {
				User user = (User) backList.get(0);

				dataTemp.put("id", user.getId());
				dataTemp.put("name", user.getName());
				dataTemp.put("userName", user.getUserName());

				String jsonStr = dataTemp.toString();

				HttpServletResponse response = this.getResponse();
				response.setContentType("text/html;charset=utf-8");

				PrintWriter out = response.getWriter();
				out.println(jsonStr);

				out.flush();
				out.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	/**
	 * 删除
	 * @return
	 */
	public String deleteData(){
		String id = this.getRequest().getParameter("id");
		
		//删除返回原页面
		String name = this.getRequest().getParameter("q_name");
		String userHouse = this.getRequest().getParameter("q_userHouse");
		String start = this.getRequest().getParameter("start");

		
		User user = userService.findById(Integer.parseInt(id));
		if (user == null) {
			addFieldError(id, getText("该用户不存在！"));
			
			this.getRequest().setAttribute("q_name", name);
			this.getRequest().setAttribute("q_userHouse", userHouse);
			this.getRequest().setAttribute("start", start);
			return "error";
		}
		try {
			userService.delete(user);
		} catch (Exception e) {
			logger.error("删除失败", e);
		}
		
		this.getRequest().setAttribute("q_name", name);
		this.getRequest().setAttribute("q_userHouse", userHouse);
		this.getRequest().setAttribute("start", start);
		
		return queryData();
	}
}
