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
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq_gen")
	@SequenceGenerator(allocationSize = 1, name = "account_seq_gen", sequenceName = "account_seq")
	private Long id;

	private String password;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private String email;

	@Enumerated(EnumType.STRING)
	private Role role;

	private String phone;

	private String jobTitle;

	private boolean active;

	//private LocalDateTime creationDate;

	//private String image;
}
