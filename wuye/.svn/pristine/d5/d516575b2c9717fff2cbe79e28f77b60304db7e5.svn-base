<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
      <!--
        .STYLE11 {color: #0099FF; font-weight: bold; }
        .STYLE14 {
	              font-size: 24px;
	              color: #0099FF;
         }
        .text {
                background-image: url(images/register/text_bg.png);
                height: 25;
        
        }
      -->
    </style>
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
    function usernameFocus(){
        var username=document.getElementById("user_username");
        username.innerHTML="<font face='幼圆' size='2' color='red'>*用户名由大小字母、数字组成，长度为4-20个字符</font>";
    }
    function  usernameBlur() {
		var username=document.getElementById("username");
		var usernameId=document.getElementById("user_username");
		usernameId.innerHTML="";
		var reg=/^[a-zA-Z0-9]{4,20}$/;
		if(username.value==""){
				usernameId.innerHTML = "<font face='幼圆' size='2' color='red'>*用户名为必填项，请输入你的用户名</font>";
				return false;
			}
			if(reg.test(username.value)==false){
				usernameId.innerHTML = "<font face='幼圆' size='2' color='red'>*用户名格式错误，请用大小写英文字母、数字，长度4-20个字符</font>";
				return false;
			}
			return true;
	}
	
	function passwordFocus() {
		var password=document.getElementById("user_password");
		password.innerHTML = "<font face='幼圆' size='2' color='red'>*密码由大小字母、数字组成，长度为6－20字符</font>";
	}
	function passwordBlur(){
			var password = document.getElementById("password");
			var passwordId = document.getElementById("user_password");
			passwordId.innerHTML = "";
			var reg = /^[a-zA-Z0-9]{6,20}$/;
			if(password.value==""){
				passwordId.innerHTML = "<font face='幼圆' size='2' color='red'>*密码必填项,请输入密码</font>";
				return false;
			}
			if(reg.test(password.value)==false){
				passwordId.innerHTML = "<font face='幼圆' size='2' color='red'>*密码格式不正确，请重新输入</font>";	
				return false;
			}
			return true;
	}
	
	function repasswordFocus(){
			var repassword = document.getElementById("user_repassword");
			repassword.innerHTML = "<font face='幼圆' size='2' color='red'>*请再次输入密码</font>"
	}
	function repasswordBlur(){
		var repassword = document.getElementById("repassword");
			var password = document.getElementById("password");
			var repasswordId = document.getElementById("user_repassword");
			repasswordId.innerHTML = "";
			if(repassword.value==""){
				repasswordId.innerHTML = "<font face='幼圆' size='2' color='red'>*请再次输入您的密码</font>";
				return false;
			}
			if(repassword.value!=password.value){
				repasswordId.innerHTML = "<font face='幼圆' size='2' color='red'>*两次输入密码不一致，请重新输入</font>";
				return false;
			}
			return true;
	}
	
	function nameFocus() {
		var name=document.getElementById("user_name");
		name.innerHTML="<font face='幼圆' size='2' color='red'>*请输入本人真实姓名</font>";
	}
	function nameBlur() {
		var name=document.getElementById("name");
		var nameId=document.getElementById("user_name");
		nameId.innerHTML="";
		var reg=/^[\u4e00-\u9fa5]{2,5}$/;
		if(name.value==""){
		    nameId.innerHTML="<font face='幼圆' size='2' color='red'>*姓名为必填项，请输入姓名</font>";
		    return false;
		}
		if(reg.test(name.value)==false){
		    nameId.innerHTML="<font face='幼圆' size='2' color='red'>*格式不正确，请重新输入 </font>";
		    return false
		}
		return true;
	}
	
	function phoneFocus() {
		var phone=document.getElementById("user_phone");
		phone.innerHTML="<font face='幼圆' size='2' color='red'>*请输入本人电话号码</font>";
	}
	function phoneBlur() {
	    var phone=document.getElementById("phone");
	    var phoneId=document.getElementById("user_phone");
	    phoneId.innerHTML="";
	    var reg=/^[0-9]{11,11}$/;
		if(phone.value==""){
		    phoneId.innerHTML="<font face='幼圆' size='2' color='red'>*电话为必填项，请输入电话</font>"
		    return false;
		}
		if(reg.test(phone.value)==false){
		    phoneId.innerHTML="<font face='幼圆' size='2' color='red'>*电话号码格式不对，请重新输入</font>"
		    return false;
		}
		return true;
	}
	
	function housenumFocus() {
		var housenum=document.getElementById("user_housenum");
		housenum.innerHTML="<font face='幼圆' size='2' color='red'>*请输入本人所住房号</font>";
	}
	function housenumBlur() {
	    var housenum=housenum=document.getElementById("housenum");
		var housenumId=document.getElementById("user_housenum");
		housenumId.innerHTML="";
		var reg=/^[A-C0-9]{5,5}$/;
		if(housenum.value==""){
		    housenumId.innerHTML="<font face='幼圆' size='2' color='red'>*房号为必填项</font>";
		    return false;
		}
		if(reg.test(housenum.value)==false){
		    housenumId.innerHTML="<font face='幼圆' size='2' color='red'>*房号有错，请重新输入</font>"
		    return false;
		}
		return true;
	}
	
	function jihuoFocus() {
		var jihuo=document.getElementById("user_jihuo");
		jihuo.innerHTML="<font face='幼圆' size='2' color='red'>*管理员所给激活码，仅限本小区住户</font>";
	}
	function jihuoBlur() {
		var jihuo=document.getElementById("jihuo");
		var jihuoId=document.getElementById("user_jihuo");
		jihuoId.innerHTML="";
		var reg=/^[0-9]{4,4}$/;
		if(jihuo.value==""){
		    jihuoId.innerHTML="<font face='幼圆' size='2' color='red'>*激活码为必填项，仅限本小区住户拥有</font>";
		    return false;
		}
		if(reg.test(jihuo.value)==false){
		    jihuoId.innerHTML="<font face='幼圆' size='2' color='red'>*激活码格式错误</font>";
		    return false
		}
		return true;
	}
	
	function Register() {
	    if(username.equals("")&&password.equals("")&&name.equals("")&&phone.equals("")&&housenum.equals("")&&jihuo.equals("")){
	      confirm("注册成功，是否登录？");
	    }else{
		  confirm("注册失败，请检查是否有未填项！！");
		  window.location="Regiser.jsp";
		}
	}
	function Return() {
		window.location="Login.jsp";
	}	
    </script>

  </head>
  
<body background="images/register/homebg.png">
<div align="right">
   <font face="幼圆" size="3"><a href="Home.jsp">首页</a> |  <a href="#">在线留言</a> |  <a href="#" target="_blank">设为首页</a> |  <a href="#" target="_blank">加入收藏</a><br><br></font>
</div>
<fieldset style="border-color:#000000">
<legend align="left"><img src="images/register/register_word.png" /></legend>
<form action="Register" method="post">
<table cellpadding="0" cellspacing="0" align="left">
  <tr>
    <td height="50" colspan="3">    </td>
  </tr>
  <tr>
    <td width="120" height="38" align="right"><font face="幼圆"><span class="STYLE11">用&nbsp;户&nbsp;名：</span></font></td>
    <td width="160"><font face="幼圆">
    <input type="text" class="text" name="username" id="username" onblur="usernameBlur();" onfocus="usernameFocus();" />
    </font></td>
    <td width="316" id="user_username"></td>
  </tr>
  <tr>
    <td height="38" align="right"><font face="幼圆"><span class="STYLE11">密&nbsp;&nbsp;&nbsp;&nbsp;码：</span></font></td>
    <td><font face="幼圆">
    <input type="password" class="text" name="password" id="password" onblur="passwordBlur()" onfocus="passwordFocus()" />
    </font></td>
    <td id="user_password"></td>
  </tr>
  <tr>
    <td height="38" align="right"><font face="幼圆"><span class="STYLE11">确认密码：</span></font></td>
    <td><font face="幼圆">
    <input type="password" class="text" name="repassword" id="repassword" onblur="repasswordBlur();" onfocus="repasswordFocus();" />
    </font></td>
    <td id="user_repassword"></td>
  </tr>
  <tr>
    <td height="38" align="right"><font face="幼圆"><span class="STYLE11">真实姓名：</span></font></td>
    <td><font face="幼圆">
    <input type="text" class="text" name="name" id="name" onblur="nameBlur();" onfocus="nameFocus();" />
    </font></td>
    <td id="user_name"></td>
  </tr>
  <tr>
    <td height="38" align="right"><font face="幼圆"><span class="STYLE11">电&nbsp;&nbsp;&nbsp;&nbsp;话：</span></font></td>
    <td><font face="幼圆">
    <input type="text" class="text" name="phone" id="phone" onblur="phoneBlur();" onfocus="phoneFocus();" />
    </font></td>
    <td id="user_phone"></td>
  </tr>
  <tr>
    <td height="38" align="right"><font face="幼圆"><span class="STYLE11">房&nbsp;&nbsp;&nbsp;&nbsp;号：</span></font></td>
    <td><font face="幼圆">
    <input type="text" class="text" name="housenum" id="housenum" onblur="housenumBlur();" onfocus="housenumFocus();" />
    </font></td>
    <td id="user_housenum"></td>
  </tr>
  <tr>
    <td height="38" align="right"><font face="幼圆"><span class="STYLE11">激&nbsp;活&nbsp;码：</span></font></td>
    <td><font face="幼圆">
    <input type="text" class="text" name="jihuo" id="jihuo" onblur="jihuoBlur();" onfocus="jihuoFocus()"/>
    </font></td>
    <td id="user_jihuo"></td>
  </tr>
  <tr>
    <td height="38" align="right"><font face="幼圆"><span class="STYLE11">验&nbsp;证&nbsp;码：</span></font></td>
    <td colspan="2">
	  <font face="幼圆"><span class="STYLE11">
	  <input type="text" class="text"/>
	  <img height="21" width="55" src="images/register/yanzheng01.jpg"> 
	看不清，<a href="Register01.jsp">换一张</a></span></font></td>
  </tr>
  <tr>
    <td height="38"><br></td>
    <td colspan="2">
      <font face="幼圆"><span class="STYLE11"> 
    <input type="checkbox"> 
    <font size="3">同意网站网络服务条款<a href="#">用户注册协议</a></font></span></font></td>
  </tr>
  <tr>
    <td height="82" colspan="3">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="submit" value="" onclick="Register();" style="background-image:url(images/register/bu_re.png); height: 32; width: 50"/>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="" onclick="Return();" style="background-image:url(images/register/bu_esc.png); height: 32; width: 50"/>	</td>
  </tr>
</table>
<img src="images/register/logo.png" width="425" height="417" />
</form>
</fieldset>
<div align="center"><font face="幼圆" size="2" class="STYLE11">江南翠城小区物业管理有限责任公司</font></div>
</body>
</html>
