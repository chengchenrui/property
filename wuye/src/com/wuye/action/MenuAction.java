package com.wuye.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.wuye.common.MyBaseAction;
import com.wuye.model.Menu;
import com.wuye.service.IMenuService;
import com.wuye.util.json.JSONArray;
import com.wuye.util.json.JSONObject;

public class MenuAction extends MyBaseAction {

	private static final Logger logger = Logger.getLogger(MenuAction.class);

	private IMenuService menuService;
	private List backList;

	public List getBackList() {
		return backList;
	}

	public void setBackList(List backList) {
		this.backList = backList;
	}

	public IMenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}

	public String queryAllMenu() {
		String type = this.getRequest().getParameter("type");
		
		backList = menuService.findByType(type);
		try {	
			JSONArray dateArray = new JSONArray();
			if (backList != null && backList.size() > 0) {
				for (int i = 0; i < backList.size(); i++) {
					Menu menu = (Menu) backList.get(i);
					JSONObject dateTemp = new JSONObject();
					
					dateTemp.put("accessPath", menu.getUrl());
					if(menu.getUrl() == null){
						dateTemp.put("accessPath", "");
					}
					dateTemp.put("checked", false);
					dateTemp.put("delFlag", 0);
					dateTemp.put("parentID", Integer.parseInt(menu.getParentId()));
					dateTemp.put("resourceCode", "");
					dateTemp.put("resourceDesc", "");
					dateTemp.put("resourceGrade", 2);
					dateTemp.put("resourceID", Integer.parseInt(menu.getId()));
					dateTemp.put("resourceName", menu.getMName());
					dateTemp.put("resourceOrder",menu.getSortNum());
					dateTemp.put("resourceType", menu.getType());
					
					dateArray.put(dateTemp);
				}
				
			}
			String backStr = dateArray.toString();
			
			HttpServletResponse response = this.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			String jsonStr = backStr;
			out.println(jsonStr);
			out.flush();
			out.close();

		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e);
		}
		return null;
	}
}
