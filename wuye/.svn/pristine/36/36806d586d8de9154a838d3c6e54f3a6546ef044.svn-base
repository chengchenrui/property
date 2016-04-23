<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>物业管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="scripts/jquery/jquery-1.7.1.js"></script>
<link href="style/authority/basic_layout.css" rel="stylesheet" type="text/css" />
<link href="style/authority/common_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="scripts/authority/commonAll.js"></script>
<script type="text/javascript" src="scripts/jquery/jquery-1.4.4.min.js"></script>
<script src="scripts/My97DatePicker/WdatePicker.js" type="text/javascript" defer="defer"></script>
<script type="text/javascript" src="scripts/artDialog/artDialog.js?skin=default"></script>
<script type="text/javascript">
	$(document).ready(function() {
		/*
		 * 提交
		 */
		/**$("#submitbutton").click(function() {
			if(validateForm()){
				checkUserName();
				//window.parent.$.fancybox.close();
			}
		});**/
		
		/*
		 * 取消
		 */
		$("#cancelbutton").click(function() {
			/**  关闭弹出iframe  **/
			window.parent.$.fancybox.close();
		});
	});

	/** 检测用户名是否存在并提交form  **/
	/**function checkUserName(){
		var userName = $("#userName").val();
		var id = $("#id").val();
		if(userName != null){
			$.ajax({
				type:"GET",
				url:"user_queryByUserName.action?userName="+userName,
				dataType:"json",
				success:function(data){
				alert("id="+id+"::"+"data.id="+data.id);
					if(data != null || date.length() <= 0){
						if(id != data.id){
							art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'该用户名已存在！', ok:true,});
							return false;
						}else{
							$("#submitForm").attr("action", "user_updateData.action").submit();
							window.location.href = "/wuye/WebRoot/error.jsp"
						}
					}else{
						$("#submitForm").attr("action", "user_updateData.action").submit();
					}
				}
			});
		}
		return true;
	}**/
	/** 表单验证  **/
	function validateForm(){
		if($("#name").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写住户姓名', ok:true,});
			return false;
		}
		if($("#userName").val==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写用户名', ok:true,});
			return false;
		}
		if($("#houseId").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写房间号', ok:true,});
			return false;
		}
		if($("#phone").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填手机号', ok:true,});
			return false;
		}
		if($("#mial").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写邮箱地址', ok:true,});
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<form id="submitForm" name="submitForm" action="user_updateData.action" method="post">
	<input type="hidden" id="id" name="id" value="<s:property value="#request.id" />" />
	<input type="hidden" id="q_name" name="q_name" value="<s:property value="#request.q_name" />" />
	<input type="hidden" id="q_houseId" name="q_houseId" value="<s:property value="#request.q_houseId" />" />
	<input type="hidden" id="start" name="start" value="<s:property value="#request.start" />"/>
	<input type="hidden" id="dateStart" name="dateStart" value="<s:property value="#request.dateStart"/>"/>
	<input type="hidden" id="dateEnd" name="dateEnd" value="<s:property value="#request.dateEnd"/>"/>
	<div id="container">
		<div id="nav_links">
			当前位置：基础数据&nbsp;>&nbsp;<span style="color: #1A5CC6;">用户编辑</span>
			<div id="page_close">
				<a href="javascript:parent.$.fancybox.close();">
					<img src="images/common/page_close.png" width="20" height="20" style="vertical-align: text-top;"/>
				</a>
			</div>
		</div>
		<div class="ui_content">
			<table  cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
				<tr>
					<td class="ui_text_rt" width="15%">住户姓名：</td>
					<td class="ui_text_lt" width="20%">
						<input id="name" name="name" value="<s:property value="#request.name" />" />
					</td>
					<td class="ui_text_lt" width="20%"><font color="red"><s:fielderror><s:param>name</s:param></s:fielderror></font></td>
					<td width="45%">&nbsp;</td>
				</tr>
				<tr>
					<td class="ui_text_rt">用户名：</td>
					<td class="ui_text_lt">
						<input id="userName" name="userName" value="<s:property value="#request.userName" />" />
					</td>
					<td class="ui_text_lt"><font color="red"><s:fielderror><s:param>userName</s:param></s:fielderror></font></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td class="ui_text_rt">房间号：</td>
					<td class="ui_text_lt" >
						<input id="houseId" name="houseId" value="<s:property value="#request.houseId" />" />
					</td>
					<td class="ui_text_lt" ><font color="red"><s:fielderror><s:param>house</s:param></s:fielderror></font></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td class="ui_text_rt">手机号：</td>
					<td class="ui_text_lt">
						<input id="phone" name="phone" value="<s:property value="#request.phone" />" />
					</td>
					<td class="ui_text_lt"><font color="red"><s:fielderror><s:param>phone</s:param></s:fielderror></font></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td class="ui_text_rt">邮箱号：</td>
					<td class="ui_text_lt">
						<input id="mail" name="mail" value="<s:property value="#request.mail" />" />
					</td>
					<td class="ui_text_lt"><font color="red"><s:fielderror><s:param>mail</s:param></s:fielderror></font></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td class="ui_text_rt">描述：</td>
					<td class="ui_text_lt" colspan="2">
						<textarea id="description" name="description" rows="6" cols="50"><s:property value="#request.description" /></textarea>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td class="ui_text_lt">
						&nbsp;<input id="submitbutton" type="submit" value="提交" class="ui_input_btn01"/>
						&nbsp;<input id="cancelbutton" type="button" value="取消" class="ui_input_btn01"/>
					</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</table>
		</div>
	</div>
</form>
</body>
</html>