package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Employee;

@RestController
public class EmployeeResource {
	
	@GetMapping("/api/employee/{id}")
	public Employee getEmployee(@PathVariable("id")long employeeId) {
		Employee employee = new Employee(100,"ozan",10000);
		return employee;
	}
	
	@GetMapping("/api/employees")
	public List<Employee> getEmployees(){
		Employee employee1 = new Employee(101,"özge",12000);
		Employee employee2 = new Employee(101,"arzu",15000);
		Employee employee3 = new Employee(101,"şerif",16000);
		Employee employee4 = new Employee(101,"ozan",10000);
		
		List<Employee> employees = new ArrayList<Employee>();
		
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		employees.add(employee4);
		
		return employees;
	
	}
	
	@PostMapping("/api/employee")
	public Employee postEmployee(@RequestBody Employee employee) {
		employee.setEmployeeId(105);
		System.out.println("eleman eklendi :"+employee.getEmployeeId()+" "+employee.getEmployeeName()
							+" "+employee.getMonthlySalary());
		return employee;
	}
	
	@PutMapping("/api/employee")
	public void putEmployee(@RequestBody Employee employee) {
		System.out.println("Güncellendi "+employee.getEmployeeId()+" "+employee.getEmployeeName()+" "+employee.getMonthlySalary());
	}
	
	@DeleteMapping("/api/employee/{id}")
	public void deleteEmployee(@PathVariable("id")long employeeId) {
	    Employee employee = new Employee(employeeId,"arzu",16000);
	    System.out.println("silindi "+employee.getEmployeeId()+" "+employee.getEmployeeName()+" "+employee.getMonthlySalary());
	} 

}
