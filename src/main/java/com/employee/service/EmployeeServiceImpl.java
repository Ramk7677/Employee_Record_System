package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	
	@Override
	public List<Employee> getAllEmployees() {
		
		return repository.findAll();
	}


	@Override
	public void deleteEmployeeById(long id) {
		
		repository.deleteById(id);
		
	}


	@Override
	public void saveEmployee(Employee employee) {
		
		this.repository.save(employee);
		
	}


	@Override
	public void updateEmployee(Employee employee, long id) {
		
		
		
		Optional<Employee> emp=this.repository.findById(id);
		
		if(emp.isPresent())
		{
			Employee e=emp.get();
			e.setFirstName(employee.getFirstName());
			e.setLastName(employee.getLastName());
			e.setEmail(employee.getEmail());
			
			this.repository.save(e);
		}
		
		
	}

}
