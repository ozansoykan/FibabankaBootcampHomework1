package com.example.demo.web;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Employee;

@Controller
public class EmployeeController {
	
	@GetMapping("/employee/get")
	@ResponseBody	
	public String getEmployee() {
		long employeeId = 100;
		String url = "http://localhost:8080/api/employee"+employeeId;
		RestTemplate restTemplate = new RestTemplate();
		Employee result = restTemplate.getForObject(url, Employee.class);
		return "Edinme Başarılı : "+result.getEmployeeId()+" "+result.getEmployeeName()+" "+result.getMonthlySalary();
	}
	
	@GetMapping("/employee/post")
	@ResponseBody
	public String postEmployee() {
		Employee employee = new Employee(101,"özge",12000);
		String url = "http://localhost:8080/api/employee";
		RestTemplate restTemplate = new RestTemplate();
		Employee result = restTemplate.postForObject(url,employee, Employee.class);
		return "Yükleme Başarılı : "+result.getEmployeeId()+" "+result.getEmployeeName()+" "+result.getMonthlySalary();
		
	}
	
	@GetMapping("/employee/put")
	@ResponseBody
	public String putEmployee() {
		Employee employee = new Employee(105,"tarçın",2000);
		String url = "http://localhost:8080/api/employee";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(url, HttpMethod.PUT,new HttpEntity<Employee>(employee),Void.class);
		return "güncellendi";
	}
	
	@GetMapping("/employee/delete")
	@ResponseBody
	public String deleteEmployee() {
		long employeeId = 105;
		String url = "http://localhost:8080/api/employee/"+employeeId;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
		return "silindi";
	}
	

}
