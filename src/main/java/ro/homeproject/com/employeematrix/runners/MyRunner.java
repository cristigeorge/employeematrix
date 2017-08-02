package ro.homeproject.com.employeematrix.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ro.homeproject.com.employeematrix.entities.Role;
import ro.homeproject.com.employeematrix.model.AccountModel;
import ro.homeproject.com.employeematrix.services.AccountService;

@Component
public class MyRunner implements CommandLineRunner {

	@Autowired
	private AccountService accountService;

	@Override
	public void run(final String... args) throws Exception {
		AccountModel accountModel = AccountModel.builder()
				.phone("021323")
				.jobTitle("sef")
				.active(Boolean.TRUE)
				.lastName("last")
				.firstName("first")
				.password("pass")
//				.creationDate(LocalDateTime.now())
				.email("heeh@gmail.com")
				.role(Role.USER)
				.build();

//		accountService.save(accountModel);
//		System.out.println(accountService.getAllAccounts());
//		accountService.deleteAccount(2L);
//		accountService.activateUser(2L);
	}
}
