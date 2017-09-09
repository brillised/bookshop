package com.huihuang.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.huihuang.dao.UserDao;
import com.huihuang.dao.impl.UserDaoImpl;
import com.huihuang.javabean.User;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/userServlet")
public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		String action=request.getParameter("action");
		switch(action){//这里判断用户请求类型而跳转相应的服务//默认登录
		case "login":
			loginServlet(request, response);
			break;
		case "add":
			addServlet(request,response);
			break;
		case "userManage":
			userManageServlet(request,response);
			break;
		case "outLogin":
			outLoginServlet(request,response);
			break;
		case "del":
			delServlet(request,response);
			break;
		case "up":
			upRqServlet(request,response);
			break;
		case "update":
			updateServlet(request,response);
			break;
		}
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	//用户登录服务处理
	private void loginServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String loginErrPath="login.jsp";//登录页面
		String mainPath="index.jsp";//内容主页面
		UserDao ud=new UserDaoImpl();
		User user=new User();//声明要传入验证的用户类
		
		String userName=request.getParameter("userName");
		String passWord=request.getParameter("passWord");
		
		user.setUserName(userName);
		user.setPassword(passWord);
			
		if(userName!=null&&passWord!=null){
			List<User> lu=ud.selectUser(2, user);
			if(lu.size()>0){
				System.out.println("****用户登录****");
				User u=lu.get(0);//登录默认获取返回集合第一个（这里只有一个）；
				HttpSession session=request.getSession();
				session.setAttribute("userName", u.getUserName());
				session.setAttribute("name",u.getName());
				session.setAttribute("userType", u.getUserType());
				session.setAttribute("lastTime", u.getLastTime());
				session.setAttribute("uId",u.getId());
				response.sendRedirect(mainPath);
				
				new UserDaoImpl().upUser(1, u);//更新登录时间
				//request.setAttribute("info", info);
				//request.getRequestDispatcher(mainPath).forward(request, response);
			}else{
				request.setAttribute("info","用户或密码错误！");
				request.getRequestDispatcher(loginErrPath).forward(request, response);
			}
		}else{
			request.setAttribute("info", "用户和密码不能为空");
			request.getRequestDispatcher(loginErrPath).forward(request, response);
		}
	}
	//用户增加服务处理
	private void addServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String addPath="admin/add.jsp";
		//String userManagePath="admin/userManage.jsp";
		User user=new User();
		UserDao ud1=new UserDaoImpl();
		
		user.setUserName(request.getParameter("userName"));
		user.setName(request.getParameter("name"));
		user.setUserType(request.getParameter("userType"));
		user.setSex(request.getParameter("sex"));
		user.setPassword(request.getParameter("passWord"));
		
		if(new UserDaoImpl().selectUser(1, user).size()>0){//1表示进行判断用户存在查询
			request.setAttribute("adderr","*用户名已存在！");
			request.getRequestDispatcher(addPath).forward(request, response);
		}else{
			if(ud1.addUser(user)){
				request.setAttribute("info","*用户名添加成功！");
			}else{
				request.setAttribute("info","*用户名添加失败！");
			}
			userManageServlet(request, response);
//			List<User> lu=new UserDaoImpl().findUser();
//			request.setAttribute("userList", lu);
//			request.getRequestDispatcher(userManagePath).forward(request, response);
		}
	}
	
	//用户管理服务操作
	private void userManageServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userManagePath="admin/userManage.jsp";
		UserDao ud=new UserDaoImpl();
		List<User> lu=ud.selectUser(0, null);
		request.setAttribute("userList", lu);
		request.getRequestDispatcher(userManagePath).forward(request, response);
		
	}
	//退出登录注销session
	private void outLoginServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		HttpSession session=request.getSession();
		session.invalidate();//注销session
		response.sendRedirect("login.jsp");
	}
	//用户删除操作
	private void delServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		//String userManagePath="admin/userManage.jsp";
		Integer delId=Integer.valueOf(request.getParameter("delId"));//这里把参数的值转为int型
		HttpSession session=request.getSession();
		Integer uId=(Integer) session.getAttribute("uId");
		UserDao ud=new UserDaoImpl();
		if(delId==uId){
			request.setAttribute("info","*当前用户已经登录，不能删除！");
		}else{
			if(ud.delUser(delId)){
				request.setAttribute("info","*用户已删除！");
			}else{
				request.setAttribute("info", "*用户删除失败！");
			}
		}
		userManageServlet(request, response);
//		List<User> lu=new UserDaoImpl().findUser(0,null);
//		request.setAttribute("userList", lu);
//		request.getRequestDispatcher(userManagePath).forward(request, response);
	}
	//处理用户修改请求,接收请求id发送集合数据到修改界面
	private void upRqServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException  {
		String upPath="admin/update.jsp";
		Integer upId=Integer.valueOf(request.getParameter("upId"));//这里把参数的值转为int型
		UserDao ud=new UserDaoImpl();
		User user=new User();
		user.setId(upId);
		List<User> lu=ud.selectUser(3, user);//3表示sql查询id
		request.setAttribute("userList", lu);
		request.getRequestDispatcher(upPath).forward(request, response);
		
	}
	//修改用户信息
	private void updateServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao ud=new UserDaoImpl();
		User u=new User();
		Integer upId=Integer.valueOf(request.getParameter("upId"));
		u.setId(upId);
		u.setName(request.getParameter("name"));
		u.setUserType(request.getParameter("userType"));
		u.setSex(request.getParameter("sex"));
		u.setPassword(request.getParameter("passWord"));
		if(ud.upUser(0,u)){
			request.setAttribute("info","*用户信息已修改！");
		}else{
			request.setAttribute("info","*用户名修改失败！");
		}
		userManageServlet(request, response);
	}
	
}
