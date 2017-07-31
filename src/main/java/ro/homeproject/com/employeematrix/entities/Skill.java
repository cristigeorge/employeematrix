package ro.homeproject.com.employeematrix.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Skill {

	@Id
	@GeneratedValue(generator = "SKILL_SEQ_GEN", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "SKILL_SEQ_GEN", sequenceName = "skill_seq", allocationSize = 1)
	private int id;

	private String name;

	@Enumerated(EnumType.STRING)
	private Type type;
}

