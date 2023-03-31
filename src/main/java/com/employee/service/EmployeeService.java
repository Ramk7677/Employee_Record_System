package com.employee.service;

import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	void deleteEmployeeById(long id);
	void saveEmployee(Employee employee);
	void updateEmployee(Employee employee, long id);
	
}
