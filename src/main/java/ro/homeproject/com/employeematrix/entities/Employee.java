package ro.homeproject.com.employeematrix.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Employee {

	@Id
	@GeneratedValue(generator = "EMPLOYEE_SEQ_GEN", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "EMPLOYEE_SEQ_GEN", sequenceName = "employee_seq", allocationSize = 1)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private String email;

	private String phone;

}
