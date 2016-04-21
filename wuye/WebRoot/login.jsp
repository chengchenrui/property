<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>物业管理系统登录</title>
		<link href="style/authority/login_css.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript" src="scripts/jquery/jquery-1.7.1.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$("#login_sub").click(function() {
					$("#submitForm").attr("action", "log_login.action").submit();
				});
			});
		
			/*回车事件*/
			function EnterPress(e) { //传入 event 
				var e = e || window.event;
				if (e.keyCode == 13) {
					$("#submitForm").attr("action", "log_login.action").submit();
				}
			}	
		</script>
	</head>
	<body>
		<div id="login_center">
			<div id="login_area">
				<div id="login_box">
					<div id="login_form">
						<form id="" action="log_login.action" method="post">
							<div id="login_tip">
								<span id="login_err" class="sty_txt2"></span>
							</div>
							<div>
								用户名：
								<input type="text" name="userName" class="username"
									id="name" value="<s:property value="#request.userName"/>" />
							</div>
							<div>
								密&nbsp;&nbsp;&nbsp;&nbsp;码：
								<input type="password" name="password" class="pwd" id="pwd"
									value="<s:property value="#request.password"/>" onkeypress="EnterPress(event)"
									onkeydown="EnterPress()" />
							</div>
							<font color="red"><s:fielderror><s:param>loginFail</s:param></s:fielderror></font>
							<div id="btn_area">
								<input type="submit" class="login_btn" id="login_sub"
									value="登  录" />
								<input type="reset" class="login_btn" id="login_ret" value="重 置" />
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>