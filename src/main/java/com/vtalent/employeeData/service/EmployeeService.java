package com.vtalent.employeeData.service;

import java.net.http.HttpRequest;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vtalent.employeeData.Binding.EmployeeRequest;
import com.vtalent.employeeData.Binding.EmployeeResponse;

@Service
public class EmployeeService {

	@Autowired
	RestTemplate restTemplate;
	
	public ResponseEntity<EmployeeResponse[]> getAll() {
		
		String url="http://localhost:8080/employee/getAllEmployees";
		
			
				return restTemplate.exchange(url,HttpMethod.GET,null,EmployeeResponse[].class);
				
	}

	public ResponseEntity<Boolean> addEmployeeRest(EmployeeRequest employeeRequest) {
		
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<EmployeeRequest> httpEntity=new HttpEntity<>(employeeRequest,httpHeaders);
		ResponseEntity<Boolean> res=restTemplate.exchange("http://localhost:8080/employee/add",HttpMethod.POST,httpEntity,Boolean.class);  
		
		return res;
	}

	public ResponseEntity<EmployeeResponse> getEmployeeByIdByRest(int id) {
		
		String url="http://localhost:8080/employee/get/id"+"/"+id;
		
		return restTemplate.getForEntity(url,EmployeeResponse.class);
	}

	public ResponseEntity<EmployeeResponse[]> getEmployeeByNameByRest(String name) {
		
		String url="http://localhost:8080/employee/get/name"+"/"+name;
		
		return restTemplate.getForEntity(url,EmployeeResponse[].class);
	}

	public ResponseEntity<EmployeeResponse> updateDetailsByIdByRest(EmployeeRequest employeeRequest, Integer id) {
		
		String url="http://localhost:8080/employee/update/id/"+id;
		
		HttpHeaders headers=new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<EmployeeRequest> httpEntity=new HttpEntity(employeeRequest,headers);
		
		return restTemplate.exchange(url, HttpMethod.PUT,httpEntity,EmployeeResponse.class,id);
		
	}

	public ResponseEntity<EmployeeResponse[]> getEmployeeByAddressByRest(String address) {
		
		String url="http://localhost:8080/employee/get/address"+"/"+address;
		
		
		return  restTemplate.getForEntity(url,EmployeeResponse[].class);
	}

	public ResponseEntity<Boolean> deleteDetailsByIdByRest(Integer id) {
		String url="http://localhost:8080/employee/delete/id/"+"{id}";
		System.out.println(url);
		return restTemplate.exchange(url,HttpMethod.DELETE,null,Boolean.class,id);
	}

}
