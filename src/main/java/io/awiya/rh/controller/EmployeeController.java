package io.awiya.rh.controller;

import io.awiya.rh.entities.Employee;
import io.awiya.rh.exceptions.ResourceNotFoundException;
import io.awiya.rh.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200/")
public class EmployeeController {

	private final EmployeeRepository employeeRepository;

	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}		

	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Sorry, we could not find an employee with the specified ID. [id:] " + id));
		return ResponseEntity.ok(employee);
	}

	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee givenEmployee){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Sorry, we could not find an employee with the specified ID. [id:] " + id));
		
		employee.setFirstName(givenEmployee.getFirstName());
		employee.setLastName(givenEmployee.getLastName());
		employee.setEmail(givenEmployee.getEmail());
		
		Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Sorry, we could not find an employee with the specified ID. [id:] " + id));
		
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
