package com.huihuang.javabean;

public class User {
	private Integer id;
	private String userName;// 用户名：唯一，不能重复，不能为空
	private String name;// 姓名：不能为空，必须输入。
	private String password;// 密码：不能为空，必须输入。
	private String sex;
	private String userType;// 用户类型（学生s、教师t、管理员a）只能选择(s t a)
	private String lastTime;// 记录最新登录时间（年月日 时分秒）
	private Integer userID;//教师和学会少年宫对应的ID
	
	public User() {}

	public User(Integer id, String userName, String name, String password, String sex, String userType, String lastTime,
			Integer userID) {
		super();
		this.id = id;
		this.userName = userName;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.userType = userType;
		this.lastTime = lastTime;
		this.userID = userID;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getLastTime() {
		return lastTime;
	}

	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		// TODO 自动生成的方法存根
		return super.toString();
	}
	
}
