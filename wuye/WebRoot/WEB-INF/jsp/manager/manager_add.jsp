<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>物业管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
		 * 取消
		 */
		$("#cancelbutton").click(function() {
			window.location.href = "javascript:history.go(-1)";
		});
			
	});
</script>
</head>
<body>
<form id="submitForm" name="submitForm" action="mag_addDate.action" method="post">
	<div id="container">
		<div id="nav_links">
			<h3 style="color: #1A5CC6;margin-left: 50px;">管理员添加</h3>
		</div>
		<div class="ui_content">
			<table  cellspacing="0" cellpadding="0" width="100%" align="left" border="0">
				<tr>
					<td class="ui_text_rt" width="10%">管理员姓名：</td>
					<td class="ui_text_lt" width="15%">
						<input id="name" name="name" value="<s:property value="#request.name" />" />
					</td>
					<td class="ui_text_lt"><font color="red"><s:fielderror><s:param>name</s:param></s:fielderror></font></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td class="ui_text_rt">用&nbsp;户&nbsp;&nbsp;名：</td>
					<td class="ui_text_lt">
						<input id="userName" name="userName" value="<s:property value="#request.userName" />" />
					</td>
					<td class="ui_text_lt"><font color="red"><s:fielderror><s:param>userName</s:param></s:fielderror></font></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td class="ui_text_rt">手&nbsp;机&nbsp;&nbsp;号：</td>
					<td class="ui_text_lt">
						<input id="phone" name="phone" value="<s:property value="#request.phone" />" />
					</td>
					<td class="ui_text_lt"><font color="red"><s:fielderror><s:param>phone</s:param></s:fielderror></font></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td class="ui_text_rt">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述：</td>
					<td class="ui_text_lt" colspan="2">
						<textarea id="description" name="description" rows="6" cols="40"><s:property value="#request.description" /></textarea>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td class="ui_text_lt" colspan="3">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input id="submitbutton" type="submit" value="提交" class="ui_input_btn01"/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input id="cancelbutton" type="button" value="取消" class="ui_input_btn01"/>
					</td>
					<td>&nbsp;</td>
				</tr>
			</table>
		</div>
	</div>
</form>
</body>
</html>