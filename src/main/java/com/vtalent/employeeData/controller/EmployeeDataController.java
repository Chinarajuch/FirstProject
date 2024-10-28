package com.vtalent.employeeData.controller;

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

import com.vtalent.employeeData.Binding.EmployeeRequest;
import com.vtalent.employeeData.Binding.EmployeeResponse;
import com.vtalent.employeeData.service.EmployeeService;

@RestController
@RequestMapping("/rest")
public class EmployeeDataController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/getAllEmployees")
	public ResponseEntity<EmployeeResponse[]> getAll()
	{
		return employeeService.getAll();
	}
	@PostMapping("/Rest/addEmployee")
	public ResponseEntity<Boolean> addEmployeeRest(@RequestBody EmployeeRequest employeeRequest) {
		
		return employeeService.addEmployeeRest(employeeRequest);
	}
	@GetMapping("/getRest/id/{id}")
	public ResponseEntity<EmployeeResponse> getEmployeeByIdByRest(@PathVariable int id)
	{
		return employeeService.getEmployeeByIdByRest(id);
	}
	@GetMapping("/getRest/name/{name}")
	public ResponseEntity<EmployeeResponse[]> getEmployeeByNameByRest(@PathVariable String name)
	{
		
		return employeeService.getEmployeeByNameByRest(name);
	}
	@PutMapping("updateRest/id/{id}")
	public ResponseEntity<EmployeeResponse> updateDetailsByIdByRest(@RequestBody EmployeeRequest employeeRequest,@PathVariable Integer id)
	{
		return employeeService.updateDetailsByIdByRest(employeeRequest, id);
	}
	@GetMapping("/getRest/address/{address}")
	public ResponseEntity<EmployeeResponse[]> getEmployeeByAddressByRest(@PathVariable String address)
	{
		return employeeService.getEmployeeByAddressByRest(address);
	}
	@DeleteMapping("deleteRest/id/{id}")
	public ResponseEntity<Boolean> deleteDetailsByIdbyRest(@PathVariable Integer id)
	{
		return employeeService.deleteDetailsByIdByRest(id);
	}

}
