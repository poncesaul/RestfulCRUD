package com.example.rest.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.example.rest.dao.EmployeeDAO;
import com.example.rest.model.Employee;

@Path("/employees")
public class EmployeeService {

	@GET
	@Produces("application/json")
	public List<Employee>getEmployees(){
		List<Employee>listOfEmployees = EmployeeDAO.getAllEmployees();
		return listOfEmployees;
	}
	
	@GET
	@Path("/{empNo}")
	@Produces("application/json")
	public Employee getEmployee(@PathParam("empNo")String empNo){
		return EmployeeDAO.getEmployee(empNo);
	}
	
	@POST
	@Produces("application/json")
	public Employee addEmployee(Employee emp){
		return EmployeeDAO.addEmployee(emp);
	}
	
	@PUT
	@Produces("application/json")
	public Employee updateEmployee(Employee emp){
		return EmployeeDAO.updateEmployee(emp);
	}
	
	@DELETE
	@Path("/{empNo}")
	@Produces("application/json")
	public void deleteEmployee(@PathParam("empNo")String empNo){
		EmployeeDAO.deleteEmployee(empNo);
	}	
}
