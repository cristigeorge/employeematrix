package ro.homeproject.com.employeematrix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.homeproject.com.employeematrix.entities.Employee;
import ro.homeproject.com.employeematrix.entities.EmployeeSkill;
import ro.homeproject.com.employeematrix.entities.Skill;
import ro.homeproject.com.employeematrix.projections.EmployeeProjection;

import java.util.List;

@Repository
public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {

	void deleteByEmployee(Employee employee);
}
