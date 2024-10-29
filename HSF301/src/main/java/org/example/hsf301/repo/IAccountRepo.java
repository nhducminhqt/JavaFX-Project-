package org.example.hsf301.repo;

import java.util.List;
import org.example.hsf301.pojo.Account;

public interface IAccountRepo {

	void save(Account account);
	List<Account> findAll();
	void delete(Integer id);
	Account findById(Integer id);
	void update(Account account);
	Account login(String email, String password);
}
