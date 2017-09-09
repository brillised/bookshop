package com.huihuang.javabean;

public class Score {
	private Integer sID;// 学生学号：不能为空，不能重复，必须在学生信息中存在
	private String cNum;// 课程编码：不能为空，不能重复，必须在课程信息中存在。
	private double grade;// 成绩：不能为空，不能输入负数。909
	
	public Integer getsID() {
		return sID;
	}
	public void setsID(Integer sID) {
		this.sID = sID;
	}
	public String getcNum() {
		return cNum;
	}
	public void setcNum(String cNum) {
		this.cNum = cNum;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	
}
