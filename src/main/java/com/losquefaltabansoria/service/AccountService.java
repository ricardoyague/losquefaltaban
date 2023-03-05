package com.losquefaltabansoria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.losquefaltabansoria.model.Account;
import com.losquefaltabansoria.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	public Optional<Account> getById(Long id) {
		return accountRepository.findById(id);
	}

	public List<Account> getAll() {
		return accountRepository.findAll();
	}

	public Account save(Account account) {
		return accountRepository.save(account);
	}

	public Optional<Account> findByEmail(String email) {
		return accountRepository.findOneByEmail(email);
	}

}
