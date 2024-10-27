package com.vtalent.employeeInfo.binding;

public class EmployeeResponse {
	private int empId;
	private String empName;
	private String empDesgination;
	private String empLocation;
	private double empSalary;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDesgination() {
		return empDesgination;
	}
	public void setEmpDesgination(String empDesgination) {
		this.empDesgination = empDesgination;
	}
	public String getEmpLocation() {
		return empLocation;
	}
	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	@Override
	public String toString() {
		return "EmployeeResponse [empId=" + empId + ", empName=" + empName + ", empDesgination=" + empDesgination
				+ ", empLocation=" + empLocation + ", empSalary=" + empSalary + "]";
	}

	
}
