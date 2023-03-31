package com.employee.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private EmployeeRepository repository;
	
	@RequestMapping("/employees")
	public String getAllemployees(Model model)
	{
		List<Employee> result=service.getAllEmployees();
		model.addAttribute("employees", result);
		return "employees-list";
	}
	
	
	@RequestMapping("/employee/{id}") //URI parameter
	public String deleteEmployee(@PathVariable(value="id") long id)
	{
		this.service.deleteEmployeeById(id);
		return "redirect:/employees";
	}
	
	@RequestMapping("/addemployee")
	public String loadAddEmployeePage(Model model)
	{
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "add-employee";
	}
	
	@RequestMapping("/saveemployee")
	public String saveEmp(@ModelAttribute("employee") Employee emp)
	{
		this.service.saveEmployee(emp);
		return "redirect:/employees";
	}
	
	@RequestMapping("/loadupdateform/{id}")
	public String loadUpdateForm(@PathVariable("id") long id, Model model)
	{
		Employee employee=this.repository.findById(id).get();
		model.addAttribute("employee",employee);
		return "update-employee";
		
	}
	
	@RequestMapping("/updateemployee/{id}")
	public String updateEmployeeInfo(@ModelAttribute("employee") Employee emp,@PathVariable("id")long id )
	{
		
		
		this.service.updateEmployee(emp,id);
		return "redirect:/employees";
	}

}
