<%@page import="com.huihuang.javabean.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../noLogin.jsp" %><%--- 静态包含--%>
<%
	String contextPath = request.getContextPath();// 取得上下文资源名称
	String scheme = request.getScheme();//获取传输协议http ftp
	String serverName = request.getServerName();//获取服务器的域名
	int serverPort = request.getServerPort();//获取服务器的端口
	//根据以上信息组成项目的根路径
	String basePath = scheme + "://" + serverName + ":" + serverPort + contextPath + "/";
%>
<%
	List<User> lu=(List<User>)request.getAttribute("userList");
	User u=lu.get(0);//修改只传了一个集合值；
	
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户增加</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/pintuer.js"></script> 
<script type="text/javascript">
			function chform(){
				var errTag=document.getElementsByClassName("errTag");
				var passWord=document.getElementById("passWord");
				var chpassWord=document.getElementById("chpassWord");
				var name=document.getElementById("name");
				var userType=document.getElementById("userType");
				
				if(name.value.length<=0){
					errTag[0].innerHTML="*请输入姓名！";
					name.focus();
					return false;
				}else{
					errTag[0].innerHTML=" ";
				}
				if(userType.value==0){
					errTag[1].innerHTML="*请选择用户类型！";
					userType.focus();
					return false;
				}else{
					errTag[1].innerHTML=" ";
				}
				if(passWord.value.length<=0){
					errTag[2].innerHTML="*请输入密码！";
					passWord.focus();
					return false;
				}else{
					errTag[2].innerHTML=" ";
				}
				if(passWord.value.length<=0){
					errTag[3].innerHTML="*请输入确认密码！";
					ckpassWord.focus();
					return false;
				}else{
					errTag[3].innerHTML=" ";
				}
				if(passWord.value!=ckpassWord.value){
					errTag[4].innerHTML="*密码不一致，请重新输入！";
					ckpassWord.focus();
					return false;
				}else{
					errTag[4].innerHTML=" ";
				}
				
				return true;
			}
		</script>
		<script type="text/javascript">
		window.onload=function(){
			var userType=document.getElementById("userType");
			var sex=document.getElementsByClassName("sex");
			for(var i=0;i<userType.options.length;i++){
				if(userType.options[i].value=="<%=u.getUserType()%>"){
					userType.options[i].selected=true;
				}
			}
			for(var i=0;i<sex.length;i++){
				if(sex[i].value=="<%=u.getSex()%>"){
					sex[i].checked=true;
				}
			}
		}
	</script>
</head>
<body>

	<div class="panel-head">
		<strong><span class="icon-pencil-square-o"></span> 用户信息修改</strong>
  	</div>
	<div class="body-content">
		<form class="form-x" action="userServlet?action=update&upId=<%=u.getId() %>" method="post" onsubmit="return chform()">
			<div class="form-group">
		        <div class="label">
		          	<label for="sitename">用户名：</label>
		        </div>
		        <div class="label">
		          	<%=u.getUserName() %>
	        	</div>
	      	</div> 

	      	<div class="form-group">
		        <div class="label">
		          	<label for="sitename">姓名：</label>
		        </div>
		        <div class="field">
		          	<input type="text" class="input w50" name="name" id="name" size="50" value="<%=u.getName()%>"/>       
	        		<i class="errTag" style="color:red;font-size:13px;"></i>
	        	</div>
	      	</div> 

      		<div class="form-group">
          		<div class="label">
           			 <label>用户类型：</label>
         		</div>
	          	<div class="field">
		            <select name="userType" id="userType" class="input w50">
			            <option value=0>选择用户类型</option>
			            <option value="管理员">管理员</option>
			            <option value="教师">教师</option>
			            <option value="学生">学生</option>
		            </select>
		            <i class="errTag" style="color:red;font-size:13px;"></i>
		            <div class="tips"></div>
	          	</div>
	        </div>
			
			<div class="form-group">
		        <div class="label">
		          	<label for="sitename">性别：</label>
		        </div>
		        <div class="field">
		          	男：<input type="radio" name="sex" class="sex" value="男" />  
		          	女：<input type="radio" name="sex" class="sex" value="女" />    
	        	</div>
	      	</div> 
			<div class="form-group">
		        <div class="label">
		          	<label for="sitename">密码：</label>
		        </div>
		        <div class="field">
		          	<input type="password" class="input w50" id="passWord" name="passWord" size="50" value="<%=u.getPassword()%>"/>       
	        		<i class="errTag" style="color:red;font-size:13px;"></i>
	        	</div>
	      	</div>
	      	<div class="form-group">
		        <div class="label">
		          	<label for="sitename">确认密码：</label>
		        </div>
		        <div class="field">
		          	<input type="password" class="input w50" id="ckpassWord" name="ckpassWord" size="50" value="<%=u.getPassword()%>" />    
	        		<i class="errTag" style="color:red;font-size:13px;"></i>
	        	</div>
	      	</div> 
			<div class="form-group">
		        <div class="field">
		          	<input class="button bg-main" type="submit" value="提交" />
	        	</div>
	      	</div>  
		</form>
	</div>
	
</body>
</html>