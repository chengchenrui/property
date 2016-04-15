package com.wuye.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MyBaseAction extends ActionSupport {
    /**
     * 用于设置json返回的数据结果
     */
    private Map resultMap=new HashMap();
	
    /**
     * 将内容添加到输出的结果中
     * @param str
     * @param o
     */
    @SuppressWarnings("unchecked")
    public void put(String str,Object o){
    	this.getResultMap().put(str, o);
    }
    
	public HttpServletRequest getRequest() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ctx
				.get(ServletActionContext.HTTP_REQUEST);
		return request;
	}
	
	public HttpServletResponse getResponse() {
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response = (HttpServletResponse) ctx
				.get(ServletActionContext.HTTP_RESPONSE);
		return response;
	}

	public Map getSession() {
		ActionContext ctx = ActionContext.getContext();
		return ctx.getSession();
	}

	public Map getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map resultMap) {
		this.resultMap = resultMap;
	}
	
}
