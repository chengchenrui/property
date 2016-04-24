<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    
    <title>登录页面</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <style type="text/css">
    <!--
    .STYLE1 {
	    color: #0099FF;
	    font-weight: bold;
    }
    -->
    </style>
    <script type="text/javascript">
       function Return(){
           window.location="client_home.jsp";
        }
    </script>
    <link href="css/main.css" rel="stylesheet" type="text/css" />	

  </head>
<body background="images/login/homebg.png">
<div align="right">
   <font face="幼圆" size="3"><a href="Home.jsp">首页</a> |  <a href="#">在线留言</a> |  <a href="#" target="_blank">设为首页</a> |  <a href="#" target="_blank">加入收藏</a><br/><br/></font>
</div>
<form action="Login" method="post">
  <p>&nbsp;</p>
  
  <table align="right" width="500px" height="368px" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td height="129px" colspan="4" valign="top"><img src="images/login/login_words.png" /></td>
  </tr>
  <tr>
    <td width="114px" height="37px" align="right"><font face="幼圆"><span class="STYLE1">用户名：</span></font></td>
    <td width="20px"><img src="images/login/contact.png" width="20" height="20"/></td>
    <td width="188px"><input name="username" type="text" style="background-image: url(images/login/text_bg.png); height: 25;"/></td>
    <td width="309px">&nbsp;</td>
  </tr>
  <tr>
    <td height="24px" colspan="4">&nbsp;</td>
  </tr>
  <tr>
    <td width="114" height="36" align="right"><font face="幼圆"><span class="STYLE1">密&nbsp;&nbsp;码：</span></font></td>
    <td width="20"><img src="images/login/lock.png" width="20" height="20" /></td>
    <td width="188"><input type="password" name="password"  style="background-image: url(images/login/text_bg.png); height: 25"/></td>
    <td width="309">&nbsp;</td>
  </tr>
  <tr>
    <td height="32px"></td>
    <td height="32px" colspan="2"><span class="STYLE1">
      <input type="checkbox" /> 
      <font face="幼圆" size="2">记住密码</font></span></td>
    <td height="32"></td>
  </tr>
  <tr>
    <td height="60" colspan="4">
	  <span class="STYLE1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	  <input name="submit" type="submit" value="" style="background-image:url(images/login/bu_lo.png); height: 32px; width: 50px"/>
	  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="" style="background-image:url(images/login/bu_esc.png); height: 32px; width: 50px" onclick="Return();"/>	
	  </span></td>
  </tr>
  <tr>
    <td height="50" colspan="4" valign="top" class="STYLE1">    
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <font face="幼圆" size="2"><font color="#0080ff">没有账号</font>&nbsp;<a href="Register.jsp">立即注册</a></font></td>
  </tr>
</table>
<div align="center">
<p>&nbsp;</p>
<p><img src="images/login/logo.png" height="323px"/></p>
<p>&nbsp;</p>
</div>
<div align="center" class="STYLE1"><br/><br/><font size="2">江南翠城小区物业管理有限责任公司</font></div>
</form>
</body>
</html>
