<%@page import="com.huihuang.javabean.Teacher"%>
<%@page import="java.util.List"%>
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
			<th>教师编号</th>
			<th>姓名</th>
			<th>性别</th>
			<th>专业</th>
			<th>课程编号</th>
			<th>课程名称</th>
			<th>操作</th>
		</tr>
			<% 
			List<Teacher> lt=(List<Teacher>)request.getAttribute("userList");
			if(lt!=null){
				for(Teacher t:lt){
				%>
				<tr>
					<td><%=t.gettID()%></td>
					<td><%=t.gettName()%></td>
					<td><%=t.getSex()%></td>
					<td><%=t.getSpec()%></td>
					<td><%=t.getcNum() %></td>
					<td><%=t.getcName() %></td>
					<td>
						<div class="button-group">
							<a href="userServlet?action=up&upId=<%=t.gettID() %>" class="button border-main">修改</a>
							<a href="userServlet?action=del&delId=<%=t.gettID() %>" class="button border-red" onclick="return del('<%=t.gettName()%>')">删除</a>
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
function del(name){
	return confirm("您确定要删除"+name+"吗?");
}
</script>
</body>
</html>