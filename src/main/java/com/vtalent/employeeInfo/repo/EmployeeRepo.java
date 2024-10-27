package com.vtalent.employeeInfo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer>{

	public List<Employee> findByEmpName(String name);

	public List<Employee> findByEmpLocation(String address);

}
