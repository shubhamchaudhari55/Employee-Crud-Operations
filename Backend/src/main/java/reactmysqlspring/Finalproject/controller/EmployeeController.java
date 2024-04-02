package reactmysqlspring.Finalproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import reactmysqlspring.Finalproject.exception.ResourceNotFoundException;
import reactmysqlspring.Finalproject.model.Employee;
import reactmysqlspring.Finalproject.repository.EmployeeRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;



@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	@GetMapping
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	//buid create employee Rest Api
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	//build get emp by id
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
		Employee employee= employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee is not exist with id:"+id));
		return ResponseEntity. ok(employee);
	}
	
	//update employee
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee emloyeeDetails) {
		Employee updateEmployee = employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id:"+id));
		updateEmployee.setFirstName(emloyeeDetails.getFirstName());
		updateEmployee.setLastName(emloyeeDetails.getLastName());
		updateEmployee.setEmailId(emloyeeDetails.getEmailId());
		
		employeeRepository.save(updateEmployee);
		return ResponseEntity.ok(updateEmployee);
	}
	
	//Delete employee
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
		
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id:"+id));
		employeeRepository.delete(employee);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
}
