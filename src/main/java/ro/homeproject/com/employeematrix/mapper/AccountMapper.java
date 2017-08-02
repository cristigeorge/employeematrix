package ro.homeproject.com.employeematrix.mapper;

import ro.homeproject.com.employeematrix.entities.Account;
import ro.homeproject.com.employeematrix.model.AccountModel;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class AccountMapper {

	AccountMapper() {
	}

	public static AccountModel toModel(final Account entity) {
		return AccountModel.builder()
				.id(entity.getId())
				.firstName(entity.getFirstName())
				.lastName(entity.getLastName())
				.role(entity.getRole())
				.jobTitle(entity.getJobTitle())
				.email(entity.getEmail())
				.password(entity.getPassword())
				.phone(entity.getPhone())
//				.creationDate(LocalDateTime.now())
				.active(entity.isActive())
				.build();
	}

	public static Account toEntity(final AccountModel model) {
		return Account.builder()
				.id(model.getId())
				.firstName(model.getFirstName())
				.lastName(model.getLastName())
				.email(model.getEmail())
				.password(model.getPassword())
				.role(model.getRole())
				.jobTitle(model.getJobTitle())
				.phone(model.getPhone())
				.active(model.isActive())
//				.creationDate(LocalDateTime.now())
				.build();
	}
}
