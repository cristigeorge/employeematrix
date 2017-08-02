package ro.homeproject.com.employeematrix.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import ro.homeproject.com.employeematrix.entities.Role;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountModel {

	private Long id;

	@NotEmpty(message = "Please enter first name")
	private String firstName;

	@NotEmpty(message = "Please enter last name")
	private String lastName;

	@NotEmpty(message = "Please enter email")
	private String email ;

	@NotEmpty(message = "Please enter phone")
	private String phone;

	@NotEmpty(message = "Please enter password")
	private String password;

	private String jobTitle;

	@NotEmpty(message = "Please enter role")
	private Role role;

//	@NotEmpty
//	private LocalDateTime creationDate;

	private boolean active;

	public String getName() {
		return this.getFirstName() + " " + this.getLastName();
	}
}
