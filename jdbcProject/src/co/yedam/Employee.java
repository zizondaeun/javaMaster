package co.yedam;

import java.sql.Date;

public class Employee {
	private String empName;
	private String empPhone;
	private String empEmail;
	private int salary;
	private String hireDate;
	private int empNo;
	
	

	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpPhone() {
		return empPhone;
	}
	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getHireDate() {
		return hireDate;
	}
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	@Override
	public String toString() {
		//"사번 		이름 		이메일 		급여"
		return String.format("%3d %4s %12s %5d", empNo, empName, empEmail, salary);// + " " + empName + " " + empEmail + " " + salary;
	}
	
	public String showInfo() {
		//"사번 		이름 		연락처 		급여"
		return String.format("%3d %4s %12s %5d", empNo, empName, empPhone, salary);// + " " + empName + " " + empEmail + " " + salary;
	}
	
	
	
}
