<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="noLogin.jsp" %><%--- 静态包含--%>
<%
	String contextPath = request.getContextPath();// 取得上下文资源名称
	String scheme = request.getScheme();//获取传输协议http ftp
	String serverName = request.getServerName();//获取服务器的域名
	int serverPort = request.getServerPort();//获取服务器的端口
	//根据以上信息组成项目的根路径
	String basePath = scheme + "://" + serverName + ":" + serverPort + contextPath + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="renderer" content="webkit">
		<title>后台管理中心</title>
		<link rel="stylesheet" href="css/pintuer.css">
		<link rel="stylesheet" href="css/admin.css">
		<script src="js/jquery.js"></script>
		<script type="text/javascript" src="js/pintuer.js"></script>
		<script type="text/javascript">
			window.onload = function() {
				function showTime() {
					var now = new Date();
					var time = now.toLocaleDateString() + " " + now.toLocaleTimeString();
					document.getElementById('showtime').innerHTML = time;
				}
				setInterval(showTime, 1000);
			}
		</script>
	</head>
	<body style="background-color:#f2f9fd;">
		<div class="header bg-main">
			<div class="logo margin-big-left fadein-top">
				<h1><img src="images/y.jpg" class="radius-circle rotate-hover" height="50" alt="" />学生成绩管理系统<sup style="color:red"><%=application.getInitParameter("ver")%></sup></h1>
			</div>
			<div class="head-r">
				<a href="##" class="button button-little bg-blue">
					当前用户：<%=session.getAttribute("name")+"("+session.getAttribute("userType")+")" %></a> &nbsp;&nbsp;
				<a class="button button-little bg-red" href="userServlet?action=outLogin">
					<span class="icon-power-off"></span> 退出登录
				</a>
			</div>
			<div style="margin:17px auto 0;width:180px;color:#fff;font-size:20px;"><span id="showtime"></span></div>
		</div>
		
		<div class="leftnav">
			<div class="leftnav-title">
				<strong><span class="icon-list"></span>管理员菜单</strong>
			</div>
			<h2>
				<a href="userServlet?action=userManage" target="right" class="button button-little bg-blue">
				<span class="icon-pencil-square-o"></span>
				用户管理</a>
			</h2>

			<h2>
				<a href="teacherServlet?action=teacherManage" target="right" class="button button-little bg-blue">
				<span class="icon-pencil-square-o"></span>
				教师管理</a>
			</h2>
			
			<h2>
				<a href="list.html" target="right" class="button button-little bg-blue">
				<span class="icon-pencil-square-o"></span>
				学生管理</a>
			</h2>
			<h2>
				<a href="list.html" target="right" class="button button-little bg-blue">
				<span class="icon-pencil-square-o"></span>
				课程管理</a>
			</h2>
			<h2>
				<a href="list.html" target="right" class="button button-little bg-blue">
				<span class="icon-pencil-square-o"></span>
				成绩管理</a>
			</h2>
			<h2></h2>
			
		</div>
		<script type="text/javascript">
			$(function() {
				$(".leftnav ul li a").click(function() {
					$("#a_leader_txt").text($(this).text());
					$(".leftnav ul li a").removeClass("on");
					$(this).addClass("on");
				})
			});
		</script>
		<ul class="bread"><%-- 导航条预留 --%>
			<li>
				<a href="index.jsp"  class="icon-home"> 首页/</a>
			</li>
		</ul>
		<div class="admin">
			<iframe scrolling="auto" rameborder="0" src="admin/admin.jsp" name="right" width="100%" height="100%"></iframe>
		</div>
	</body>

</html>