package ro.homeproject.com.employeematrix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.homeproject.com.employeematrix.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

	Employee findEmployeeByEmail(String email);
}
