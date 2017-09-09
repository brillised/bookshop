package com.huihuang.javabean;

public class Teacher {
	private Integer tID;// 教师编号：从1开始自动编号，不能修改，不能为空
	private String tName;// 姓名不能为空，必须输入
	private String sex;// 只能选择男 女 
	private String spec;// 专业必须输入，不能为空
	private String cNum;// 课程编码必须输入，不能为空
	private String cName;// 课程名称必须输入，不能为空
	
	public Teacher() {}
	
	public Teacher(Integer tID, String tName, String sex, String spec, String cNum, String cName) {
		super();
		this.tID = tID;
		this.tName = tName;
		this.sex = sex;
		this.spec = spec;
		this.cNum = cNum;
		this.cName = cName;
	}
	public Integer gettID() {
		return tID;
	}
	public void settID(Integer tID) {
		this.tID = tID;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
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
	
	
	
	
}
