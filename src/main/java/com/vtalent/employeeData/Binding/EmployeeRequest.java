package com.vtalent.employeeData.Binding;

public class EmployeeRequest {

	
	private String empName;
	@Override
	public String toString() {
		return "EmployeeRequest [empName=" + empName + ", empDesgination=" + empDesgination + ", empLocation="
				+ empLocation + ", empSalary=" + empSalary + "]";
	}
	private String empDesgination;
	private String empLocation;
	private double empSalary;
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
}
