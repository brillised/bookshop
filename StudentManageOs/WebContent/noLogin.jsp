<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userName=(String)session.getAttribute("userName");
	if(userName==null){
		out.print("抱歉！当前没有登录！将跳转到登录页面！");
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}
%>