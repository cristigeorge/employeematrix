package ro.homeproject.com.employeematrix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.homeproject.com.employeematrix.entities.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {

	Optional<Account> findByEmail(String email);

	Optional<Account> findById(Long id);

	List<Account> findByActive(Boolean active);
}
