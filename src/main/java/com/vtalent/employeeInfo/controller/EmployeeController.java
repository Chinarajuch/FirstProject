package com.vtalent.employeeInfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtalent.employeeInfo.binding.EmployeeRequest;
import com.vtalent.employeeInfo.binding.EmployeeResponse;
import com.vtalent.employeeInfo.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/getAllEmployees")
	public ResponseEntity<List<EmployeeResponse>> getAllEmployee()
	{
		List<EmployeeResponse> empRes=employeeService.getAllEmployee();
		
		return new ResponseEntity<>(empRes,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Boolean> addEmployee(@RequestBody EmployeeRequest employeeRequest) {
		
		return new ResponseEntity<>(employeeService.addEmployee(employeeRequest),HttpStatus.CREATED);
	}
	@GetMapping("/get/id/{id}")
	public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable int id)
	{
		return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.FOUND);
	}
	@GetMapping("/get/name/{name}")
	public ResponseEntity<List<EmployeeResponse>> getEmployeeByName(@PathVariable String name)
	{
		return new ResponseEntity<>(employeeService.getEmployeeByName(name),HttpStatus.FOUND);
	}
	@GetMapping("/get/address/{address}")
	public ResponseEntity<List<EmployeeResponse>> getEmployeeByAddress(@PathVariable String address)
	{
		return new ResponseEntity<>(employeeService.getEmployeeByAddress(address),HttpStatus.FOUND);
	}
	
	@PutMapping("update/id/{id}")
	public ResponseEntity<EmployeeResponse> updateDetailsById(@RequestBody EmployeeRequest employeeRequest,@PathVariable Integer id)
	{
		return new ResponseEntity<>(employeeService.updateDetailsById(employeeRequest, id),HttpStatus.CREATED);
	}
	@DeleteMapping("delete/id/{id}")
	public ResponseEntity<Boolean> deleteDetailsById(@PathVariable Integer id)
	{
		return new ResponseEntity<>(employeeService.deleteDetailsById(id),HttpStatus.OK);
	}


}
