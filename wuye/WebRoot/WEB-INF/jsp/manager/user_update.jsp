<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>信息管理系统</title>
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
		$("#submitbutton").click(function() {
			if(validateForm()){
				checkFyFhSubmit();
				window.parent.$.fancybox.close();
			}
		});
		
		/*
		 * 取消
		 */
		$("#cancelbutton").click(function() {
			/**  关闭弹出iframe  **/
			window.parent.$.fancybox.close();
		});
		
		var result = 'null';
		if(result =='success'){
			/**  关闭弹出iframe  **/
			window.parent.$.fancybox.close();
		}
	});
	
	/** 检测房源房号是否存在并提交form  **/
	function checkFyFhSubmit(){
		$("#submitForm").attr("action", "user_updateData.action").submit();
	}
	
	/** 表单验证  **/
	function validateForm(){
		if($("#name").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写用户姓名', ok:true,});
			return false;
		}
		if($("#fyDh").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写房源栋号', ok:true,});
			return false;
		}
		if($("#fyCh").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写房源层号', ok:true,});
			return false;
		}
		if($("#fyFh").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写房源房号', ok:true,});
			return false;
		}
		if($("#fyZongMj").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写房源面积', ok:true,});
			return false;
		}
		if($("#fyJizuMj").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写计租面积', ok:true,});
			return false;
		}
		if($("#fyZldz").val()==""){
			art.dialog({icon:'error', title:'友情提示', drag:false, resize:false, content:'填写房源座落地址', ok:true,});
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<form id="submitForm" name="submitForm" action="user_updateData.action" method="post">
	<input type="hidden" name="id" value="<s:property value="#request.id" />" id="id"/>
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
					<td class="ui_text_rt" width="80">用户名：</td>
					<td class="ui_text_lt">
						<input id="name" name="name" value="<s:property value="#request.name" />" />
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt" width="80">房间号：</td>
					<td class="ui_text_lt">
						<input id="houseId" name="houseId" value="<s:property value="#request.houseId" />" />
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt" width="80">手机号：</td>
					<td class="ui_text_lt">
						<input id="phone" name="phone" value="<s:property value="#request.phone" />" />
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt" width="80">邮箱号：</td>
					<td class="ui_text_lt">
						<input id="mial" name="mial" value="<s:property value="#request.mial" />" />
					</td>
				</tr>
				<tr>
					<td class="ui_text_rt" width="80">描述：</td>
					<td class="ui_text_lt">
						<textarea id="description" name="description" rows="6" cols="50"><s:property value="#request.description" /></textarea>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td class="ui_text_lt">
						&nbsp;<input id="submitbutton" type="button" value="提交" class="ui_input_btn01"/>
						&nbsp;<input id="cancelbutton" type="button" value="取消" class="ui_input_btn01"/>
					</td>
				</tr>
			</table>
		</div>
	</div>
</form>
</body>
</html>