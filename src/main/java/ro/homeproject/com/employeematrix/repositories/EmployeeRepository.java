package ro.homeproject.com.employeematrix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.homeproject.com.employeematrix.entities.Employee;
import ro.homeproject.com.employeematrix.projections.EmployeeProjection;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

	Employee findEmployeeByEmail(String email);

	EmployeeProjection findById(Long id);
}
