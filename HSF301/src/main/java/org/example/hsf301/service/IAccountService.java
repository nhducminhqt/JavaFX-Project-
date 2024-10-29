package org.example.hsf301.service;

import java.util.List;
import org.example.hsf301.pojo.Account;


public interface IAccountService {
	void save(Account account);
	List<Account> findAll();
	void delete(Integer id);
	Account findById(Integer id);
	void update(Account account);
	Account login(String email, String password);
}
