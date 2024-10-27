package com.vtalent.employeeInfo.service;

import java.util.List;

import com.vtalent.employeeInfo.binding.EmployeeRequest;
import com.vtalent.employeeInfo.binding.EmployeeResponse;

public interface EmployeeService {
	
	public List<EmployeeResponse> getAllEmployee();
	
	public boolean addEmployee(EmployeeRequest employeeRequest);
	
	public EmployeeResponse getEmployeeById(int id);
	
	public List<EmployeeResponse> getEmployeeByName(String name);
	
	public List<EmployeeResponse> getEmployeeByAddress(String Address);
	
	public EmployeeResponse updateDetailsById(EmployeeRequest employeeRequest,Integer id);
	
	public boolean deleteDetailsById(Integer id);

}
