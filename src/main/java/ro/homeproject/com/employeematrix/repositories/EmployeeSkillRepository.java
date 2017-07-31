package ro.homeproject.com.employeematrix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.homeproject.com.employeematrix.entities.Employee;
import ro.homeproject.com.employeematrix.entities.EmployeeSkill;

@Repository
public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {

	void deleteByEmployee(Employee employee);
}
