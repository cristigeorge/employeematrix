package ro.homeproject.com.employeematrix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.homeproject.com.employeematrix.entities.Skill;

public interface SkillRepository  extends JpaRepository<Skill,Long>{
}
