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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在此处插入标题</title>
</head>
<body>
<h2 style="text-align:center;color:blue;margin-top:60px;">欢迎<%=session.getAttribute("name")%>登录学生成绩管理系统</h2>
<p style="text-align:center;color:#aaa;font-size:12px;">上次登录时间：<%=session.getAttribute("lastTime") %>

</body>
</html>