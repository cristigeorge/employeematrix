package ro.homeproject.com.employeematrix.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ro.homeproject.com.employeematrix.entities.Account;
import ro.homeproject.com.employeematrix.mapper.AccountMapper;
import ro.homeproject.com.employeematrix.model.AccountModel;
import ro.homeproject.com.employeematrix.repositories.AccountRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AccountService {

	private static final Logger logger = LoggerFactory.getLogger(AccountService.class);
	private final AccountRepository accountRepository;

	public AccountService(final AccountRepository accountRepository) {
		this.accountRepository = Objects.requireNonNull(accountRepository, "accountRepository must not be null");
	}

	public AccountModel save(final AccountModel accountModel) {
		final Account client = accountRepository.save(AccountMapper.toEntity(accountModel));
		return AccountMapper.toModel(client);
	}

	public List<AccountModel> getAllAccounts() {
		return accountRepository.findAll().stream()
				.map(AccountMapper::toModel)
				.collect(Collectors.toList());
	}

	public AccountModel getClientModelById(final Long userId) {
		return accountRepository.findById(userId)
				.map(AccountMapper::toModel)
				.orElseGet(AccountModel::new);
	}

	public AccountModel getClientModelByEmail(final String  email) {
		return accountRepository.findByEmail(email)
				.map(AccountMapper::toModel)
				.orElseGet(AccountModel::new);
	}

	public List<AccountModel> getAllActiveAccounts() {
		return accountRepository.findByActive(Boolean.TRUE).stream()
				.map(AccountMapper::toModel)
				.collect(Collectors.toList());
	}

	public void activateUser(final Long userId) {
		setAccountStatus(userId, Boolean.TRUE);
	}

	public void deleteAccount(final Long userId) {
		setAccountStatus(userId, Boolean.FALSE);
	}

	private void setAccountStatus(final Long userId, final Boolean active) {
		Optional<Account> account = accountRepository.findById(userId);
		if (account.isPresent()) {
			Account accountFound = account.get();
			accountFound.setActive(active);
			accountRepository.saveAndFlush(accountFound);
		} else {
			logger.info("No account with id: " + userId);
		}
	}
}
