package reactmysqlspring.Finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import reactmysqlspring.Finalproject.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	
	
}