package com.huihuang.javabean;

public class Student {
	private Integer sID;// 学号：从1开始自动编号，不能为空，必须输入
	private String sName;// 姓名：不能为空，必须输入
	private String sex;// 性别：只能选择男 女
	private String spec;// 专业：不能为空，必须输入
	private String sClass;// 年级：不能为空，必须输入
	private String sDate;// 出生日期：不能为空，必须输入
	public Integer getsID() {
		return sID;
	}
	public void setsID(Integer sID) {
		this.sID = sID;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getsClass() {
		return sClass;
	}
	public void setsClass(String sClass) {
		this.sClass = sClass;
	}
	public String getsDate() {
		return sDate;
	}
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
	
	
}
