package com.emp.model;

import java.sql.Date;

public class EmpVO implements java.io.Serializable{
	private Integer empID;
	private String empName;
	private String empGender;
	private Date empBirth;
	private String empJob;
	private String empPhone;
	private String empAddress;
	private String empPwd;
	private byte[] empPic;
	private Date hiredate;
	private Date quitdate;
	public Integer getEmpID() {
		return empID;
	}
	public void setEmpID(Integer empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpGender() {
		return empGender;
	}
	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}
	public Date getEmpBirth() {
		return empBirth;
	}
	public void setEmpBirth(Date empBirth) {
		this.empBirth = empBirth;
	}
	public String getEmpJob() {
		return empJob;
	}
	public void setEmpJob(String empJob) {
		this.empJob = empJob;
	}
	public String getEmpPhone() {
		return empPhone;
	}
	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public String getEmpPwd() {
		return empPwd;
	}
	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}
	public byte[] getEmpPic() {
		return empPic;
	}
	public void setEmpPic(byte[] empPic) {
		this.empPic = empPic;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public Date getQuitdate() {
		return quitdate;
	}
	public void setQuitdate(Date quitdate) {
		this.quitdate = quitdate;
	}

}
