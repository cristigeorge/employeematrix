package ro.homeproject.com.employeematrix.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeSkill {
	@Id
	@GeneratedValue(generator = "EMPLOYEE_SKILL_SEQ_GEN", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "EMPLOYEE_SKILL_SEQ_GEN", sequenceName = "employee_skill_seq", allocationSize = 1)
	private int id;

	@ManyToOne
	private Employee employee;

	@ManyToOne
	private Skill skill;

	@Enumerated(value = EnumType.STRING)
	private Value value;

	@Enumerated(value = EnumType.STRING)
	private Status status;
}
