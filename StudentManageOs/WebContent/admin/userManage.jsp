<%@page import="java.util.List"%>
<%@page import="com.huihuang.javabean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../noLogin.jsp" %><%--- 静态包含--%>
<%
	String contextPath = request.getContextPath();// 取得上下文资源名称
	String scheme = request.getScheme();//获取传输协议http ftp
	String serverName = request.getServerName();//获取服务器的域名
	int serverPort = request.getServerPort();//获 取服务器的端口
	//根据以上信息组成项目的根路径
	String basePath = scheme + "://" + serverName + ":" + serverPort + contextPath + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在此处插入标题</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>  
</head>
<body>
<%
	String info=(String)request.getAttribute("info");
	if(info!=null){
%>
	<p style="font-size:24px;align:center"><%=info %></p>
<%
	} 
	
%>
<div  class="panel admin-panel">
	<div class="panel-head"><strong class="icon-reorder">用户列表</strong></div>
	<div class="padding border-bottom">  
		<a class="button border-yellow" href="admin/add.jsp">
		<span class="icon-plus-square-o"></span>增加用户</a>
  	</div> 
	<table class="table table-hover text-center">
		<tr>
			<th>用户名</th>
			<th>姓名</th>
			<th>性别</th>
			<th>用户类型</th>
			<th>密码</th>
			<th>最后登录时间</th>
			<th>用户ID</th>
			<th>操作</th>
		</tr>
			<% 
			List<User> lu=(List<User>)request.getAttribute("userList");
			if(lu!=null){
				for(User u:lu){
				%>
				<tr>
					<td><%=u.getUserName()%></td>
					<td><%=u.getName() %></td>
					<td><%=u.getSex() %></td>
					<td><%=u.getUserType() %></td>
					<td><%=u.getPassword() %></td>
					<td><%=u.getLastTime() %></td>
					<td><%=u.getUserID()%></td>
					<td>
						<div class="button-group">
							<a href="userServlet?action=up&upId=<%=u.getId() %>" class="button border-main">修改</a>
							<a href="userServlet?action=del&delId=<%=u.getId() %>" class="button border-red" onclick="return del('<%=u.getUserName()%>')">删除</a>
						</div>
					</td>
				</tr>
			<%
			}
		}
		%>	
	</table>
</div>

<script>
function del(userName){
	return confirm("您确定要删除"+userName+"吗?");
}
</script>
</body>
</html>