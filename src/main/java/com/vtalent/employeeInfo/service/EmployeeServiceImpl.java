package com.vtalent.employeeInfo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vtalent.employeeInfo.binding.EmployeeRequest;
import com.vtalent.employeeInfo.binding.EmployeeResponse;
import com.vtalent.employeeInfo.repo.Employee;
import com.vtalent.employeeInfo.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo employeeRepo;
	
	
	
	@Override
	public List<EmployeeResponse> getAllEmployee() {
			
		List<Employee> li=employeeRepo.findAll();
		List<EmployeeResponse> empLi=new ArrayList<>();
		
		for(Employee e:li) {
			EmployeeResponse emp=new EmployeeResponse();
			BeanUtils.copyProperties(e,emp);
			empLi.add(emp);
		}
		
		
		return empLi;
	}

	@Override
	public boolean addEmployee(EmployeeRequest employeeRequest) {
		
		Employee e=new Employee();
		BeanUtils.copyProperties(employeeRequest, e);
		Employee emp=employeeRepo.save(e);
		if(emp!=null)
		return true;
		
		return false;
	}

	@Override
	public EmployeeResponse getEmployeeById(int id) {
		
		Optional<Employee> emp=employeeRepo.findById(id);
		EmployeeResponse e=new EmployeeResponse();
		if(emp.isPresent())
		{
			BeanUtils.copyProperties(emp.get(),e);
			return e;
		}
		return e;
	}

	@Override
	public List<EmployeeResponse> getEmployeeByName(String name) {
		
		List<Employee> emp=employeeRepo.findByEmpName(name);
		List<EmployeeResponse> resList=new ArrayList<>();
		for(Employee em:emp)
		{
			EmployeeResponse e=new EmployeeResponse();
			BeanUtils.copyProperties(em, e);
			resList.add(e);
		}
		return resList;
	}

	@Override
	public List<EmployeeResponse> getEmployeeByAddress(String address) {
		
		System.out.println(address);
		List<Employee> emp=employeeRepo.findByEmpLocation(address);
		System.out.println(emp);
		List<EmployeeResponse> resList=new ArrayList<>();
		for(Employee em:emp)
		{
			EmployeeResponse e=new EmployeeResponse();
			BeanUtils.copyProperties(em, e);
			resList.add(e);
		}
		return resList;
	}

	@Override
	public EmployeeResponse updateDetailsById(EmployeeRequest employeeRequest, Integer id) {
		
		Optional<Employee> emp=employeeRepo.findById(id);
		EmployeeResponse e=new EmployeeResponse();

		if(emp.isPresent())
		{
			Employee employee=emp.get();
			if(employeeRequest.getEmpDesgination()!=null)
				employee.setEmpDesgination(employeeRequest.getEmpDesgination());
			if(employeeRequest.getEmpLocation()!=null)
				employee.setEmpLocation(employeeRequest.getEmpLocation());
			if(employeeRequest.getEmpName()!=null)
				employee.setEmpName(employeeRequest.getEmpName());
			if(employeeRequest.getEmpSalary()!=0.0)
				employee.setEmpSalary(employeeRequest.getEmpSalary());
			Employee res=employeeRepo.save(employee);
			BeanUtils.copyProperties(res,e);
			return e;
		}
		return e; 
	}

	@Override
	public boolean deleteDetailsById(Integer id) {
		
		Optional<Employee> emp=employeeRepo.findById(id);
		if(emp.isPresent())
		{
			employeeRepo.delete(emp.get());
			return true;
		}
		return false;
	}

}
