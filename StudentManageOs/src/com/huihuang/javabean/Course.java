package com.huihuang.javabean;

public class Course {
	private String cNum;// 课程编码：不能为空，不能重复，必须输入
	private String cName;// 课程名称：不能为空，不能重复，必须输入
	private Integer credit;// 学分：不能为空，必须输入，只能是1 位数字
	
	public String getcNum() {
		return cNum;
	}
	public void setcNum(String cNum) {
		this.cNum = cNum;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	
	
}
