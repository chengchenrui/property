package com.wuye.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
/**
 * 分页工具类
 * @author cheng
 *
 */
public class PagingTool {
	private static Logger log = Logger.getLogger(PagingTool.class);
	/**
	 * 分页工具方法
	 * @param request request对象
	 * @param total   总记录数
	 * @param start   起始记录数
	 * @param size    每页显示条数
	 */
	public static void paging(HttpServletRequest request,int total ,int start,int size){
		//新加的分页信息
		Integer pre = start - size;
		Integer next = start + size;
		if (pre >= 0) {
			request.setAttribute("pre", pre);
		}
		if (total > next) {
			request.setAttribute("next", next);
		}
		Integer currentPage=start/size+1;//当前页
		Integer allPage=0;//总页数
		List<Integer> countPageList =new ArrayList<Integer>();//所有页数的list
		Integer totalRecords= total;//总记录数
		if(totalRecords%size==0){
			allPage =totalRecords/size;
		}else{
			allPage =totalRecords/size+1;
		}
		Integer temp=0;
		for(int i=0;i<allPage;i++){
			countPageList.add(temp);
			temp=temp+size;
		}
		//如果总页数为零，则当前页数也归零
		if(allPage == 0){
			currentPage = 0;
		}
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("allPage", allPage);
		request.setAttribute("totalRecords", totalRecords);
		request.setAttribute("countPageList", countPageList);
	}
}
