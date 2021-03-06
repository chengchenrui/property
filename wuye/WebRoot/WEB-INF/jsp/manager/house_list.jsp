<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type="text/javascript" src="scripts/jquery/jquery-1.7.1.js"></script>
		<link href="style/authority/basic_layout.css" rel="stylesheet" type="text/css" />
		<link href="style/authority/common_style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="scripts/authority/commonAll.js"></script>
		<script type="text/javascript" src="scripts/fancybox/jquery.fancybox-1.3.4.js"></script>
		<script type="text/javascript" src="scripts/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
		<link rel="stylesheet" type="text/css" href="style/authority/jquery.fancybox-1.3.4.css" media="screen"></link>
		<script type="text/javascript" src="scripts/artDialog/artDialog.js?skin=default"></script>
		<script type="text/javascript" src="scripts/My97DatePicker/WdatePicker.js"></script>
		<title>物业管理系统</title>
		<script type="text/javascript">
	$(document).ready(function(){
	/** 用户角色   **/
	var userRole = '';

	/** 新增   **/
	function add(){
		$("#submitForm").attr("action", "/xngzf/archives/luruFangyuan.action").submit();	
	}
	 
	/** Excel导出  **/
	function exportExcel(){
		if( confirm('您确定要导出吗？') ){
			var fyXqCode = $("#fyXq").val();
			var fyXqName = $('#fyXq option:selected').text();
//	 		alert(fyXqCode);
			if(fyXqCode=="" || fyXqCode==null){
				$("#fyXqName").val("");
			}else{
//	 			alert(fyXqCode);
				$("#fyXqName").val(fyXqName);
			}
			$("#submitForm").attr("action", "/xngzf/archives/exportExcelFangyuan.action").submit();	
		}
	}
	
	/** 删除 **/
	function del(fyID){
		// 非空判断
		if(fyID == '') return;
		if(confirm("您确定要删除吗？")){
			$("#submitForm").attr("action", "/xngzf/archives/delFangyuan.action?fyID=" + fyID).submit();			
		}
	}
	
	/** 批量删除 **/
	function batchDel(){
		if($("input[name='IDCheck']:checked").size()<=0){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'至少选择一条', ok:true,});
			return;
		}
		// 1）取出用户选中的checkbox放入字符串传给后台,form提交
		var allIDCheck = "";
		$("input[name='IDCheck']:checked").each(function(index, domEle){
			bjText = $(domEle).parent("td").parent("tr").last().children("td").last().prev().text();
// 			alert(bjText);
			// 用户选择的checkbox, 过滤掉“已审核”的，记住哦
			if($.trim(bjText)=="已审核"){
// 				$(domEle).removeAttr("checked");
				$(domEle).parent("td").parent("tr").css({color:"red"});
				$("#resultInfo").html("已审核的是不允许您删除的，请联系管理员删除！！！");
// 				return;
			}else{
				allIDCheck += $(domEle).val() + ",";
			}
		});
		// 截掉最后一个","
		if(allIDCheck.length>0) {
			allIDCheck = allIDCheck.substring(0, allIDCheck.length-1);
			// 赋给隐藏域
			$("#allIDCheck").val(allIDCheck);
			if(confirm("您确定要批量删除这些记录吗？")){
				// 提交form
				$("#submitForm").attr("action", "/xngzf/archives/batchDelFangyuan.action").submit();
			}
		}
	}
</script>
<script type="text/javascript">
	function pageButton(q_name,dateStart,dateEnd,start){
		window.location.href="house_queryData.action?q_name="+q_name+"&dateStart="+dateStart+"&dateEnd="+dateEnd+"&start="+start;
	}
	function changePageNmu(el) {
		var appOpenData = document.getElementById("submitForm");
		appOpenData.action = "house_queryData.action?start=" + el.value;
		var buttom = document.getElementById("submit");
		buttom.click();
	}
	function firm(name) {
		if(confirm("确定要提交对“"+name+"”的操作吗？")) 
		{//如果选择是，返回true ，那么就把页面转向指定链接
			return true; 
		} 
		else 
		{//否则返回false
			return false; 
		} 
	}
</script>

<style>
.alt td {
	background: black !important;
}
</style>
	</head>
	<body>
		<form id="submitForm" name="submitForm" action="house_queryData.action"
			method="post">
			<input type="hidden" id="start" value="<s:property value="#request.(#request.currentPage-1)*7" />" />
			<div id="container">
				<div class="ui_content">
					<div class="ui_text_indent">
						<div id="box_border">
							<div id="box_top">
								搜索
							</div>
							<div id="box_center">
								住户姓名：
								<input type="text" value="<s:property value="#request.q_userName"/>"
									id="q_userName" name="q_userName" class="ui_input_txt02" style="width: 100px;"/>&nbsp;
								房间号：
								<input type="text" value="<s:property value="#request.q_houseNum"/>"
									id="q_houseNum" name="q_houseNum" class="ui_input_txt02" style="width: 100px;"/>&nbsp;
								开始时间：
								<input id="dateStart" name="dateStart" style="width: 100px;"
									type="text" value="<s:property value="#request.dateStart"/>"
									class="ui_input_txt02" onfocus="WdatePicker()" />&nbsp;
								结束时间：
								<input id="dateEnd" name="dateEnd"  style="width: 100px;"
									type="text" value="<s:property value="#request.dateEnd"/>"
									class="ui_input_txt02" onfocus="WdatePicker()" />
							</div>
							<div id="box_bottom">
								<input id="submit" type="submit" value="查询" class="ui_input_btn01" />
								<input type="button" value="新增" class="ui_input_btn01"
									id="addBtn" />
								<input type="button" value="删除" class="ui_input_btn01"
									onclick="batchDel();" />
								<input type="button" value="导入" class="ui_input_btn01"
									id="importBtn" />
								<input type="button" value="导出" class="ui_input_btn01"
									onclick="exportExcel();" />
							</div>
						</div>
					</div>
				</div>
				<div class="ui_content">
					<div class="ui_tb">
						<table class="table" cellspacing="0" cellpadding="0" width="100%"
							align="center" border="0">
							<tr>
								<th width="30">
									<input type="checkbox" id="all"
										onclick="selectOrClearAllCheckbox(this);" />
								</th>
								<th>
									住户姓名
								</th>
								<th>
									房间号
								</th>
								<th>
									座
								</th>
								<th>
									楼层
								</th>
								<th>
									门号
								</th>
								<th>
									描述
								</th>
								<th>
									创建时间
								</th>
								<th>
									操作
								</th>
							</tr>
							<s:iterator value="backList" var="house">
								<tr>
									<td>
										<input type="checkbox" name="id"
											value="<s:property value="#house[0]" />" class="acb" />
									</td>
									<td>
										<s:if test='#house[1] == null'>
											未注册
										</s:if>
										<s:else>
											<s:property value="#house[1]" />
										</s:else>
									</td>
									<td>
										<s:property value="#house[2]" />
									</td>
									<td>
										<s:property value="#house[3]" />
									</td>
									<td>
										<s:property value="#house[4]" />
									</td>
									<td>
										<s:property value="#house[5]" />
									</td>
									<td>
										<s:property value="#house[6]" />
									</td>
									<td>
										<s:date name="#house[7]" />
									</td>
									<td>
										<a class="edit" href="mag_toUpdate.action?id=<s:property value="#house[0]" />
											&q_name=<s:property value="#request.q_name"/>
											&start=<s:property value="#request.(#request.currentPage-1)*7" />
											&dateStart=<s:property value="#request.dateStart"/>
											&dateEnd=<s:property value="#request.dateEnd"/>">编辑</a>
										<a onclick="return firm('<s:property value="#house[1]" />')" href="mag_deleteData.action?id=<s:property value="#house[0]" />
											&q_name=<s:property value="#request.q_name"/>
											&start=<s:property value="#request.(#request.currentPage-1)*7" />
											&dateStart=<s:property value="#request.dateStart"/>
											&dateEnd=<s:property value="#request.dateEnd"/>">删除</a>
									</td>
								</tr>
							</s:iterator>

						</table>
					</div>
					<div class="ui_tb_h30">
						<div class="ui_flt" style="height: 30px; line-height: 30px;">
							共有
							<span class="ui_txt_bold04"><s:property
									value="#request.totalRecords" />
							</span> 条记录，当前第
							<span class="ui_txt_bold04"><s:property
									value="#request.currentPage" /> / <s:property
									value="#request.allPage" />
							</span> 页
						</div>
						<div class="ui_frt">
							<!--    如果是第一页，则只显示下一页、尾页  尾页=allPage*size-size;当前页数start=(currentPage-1)*size -->
							<s:if test="#request.pre!=null">
								<input type="button"
									onclick="pageButton('<s:property value="#request.q_name"/>',
										'<s:property value="#request.dateStart"/>',
										'<s:property value="#request.dateEnd"/>',
										'0')"
									value="首页" class="ui_input_btn01" />

								<input type="button"
									onclick="pageButton('<s:property value="#request.q_name"/>',
										'<s:property value="#request.dateStart"/>',
										'<s:property value="#request.dateEnd"/>',
										'<s:property value="#request.pre"/>')"
									value="上一页" class="ui_input_btn01" />
							</s:if>
							<s:if test="#request.next!=null">
								<input type="button"
									onclick="pageButton('<s:property value="#request.q_name"/>',
										'<s:property value="#request.dateStart"/>',
										'<s:property value="#request.dateEnd"/>',
										'<s:property value="#request.next"/>')"
									value="下一页" class="ui_input_btn01" />

								<input type="button"
									onclick="pageButton('<s:property value="#request.q_name"/>',
										'<s:property value="#request.dateStart"/>',
										'<s:property value="#request.dateEnd"/>',
										'<s:property value="#request.allPage*7-7"/>')"
									value="尾页" class="ui_input_btn01" />
							</s:if>
							<!-- 如果是最后一页，则只显示首页、上一页  -->

							GO第
							<select style="width: 40px;height: 25px;" name="changePage" id="changePage" class="ui_select02"
								onchange="changePageNmu(this)">
								<s:iterator value="#request.countPageList" status="stat"
									id="item">
									<s:if test="#request.currentPage==#stat.index+1">
										<option value="<s:property />" selected>
											<s:property value="#stat.index+1" />
										</option>
									</s:if>
									<s:else>
										<option value="<s:property />">
											<s:property value="#stat.index+1" />
										</option>
									</s:else>
								</s:iterator>
							</select>页
						</div>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>
