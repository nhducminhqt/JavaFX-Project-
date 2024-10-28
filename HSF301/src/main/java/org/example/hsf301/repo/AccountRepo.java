package org.example.hsf301.repo;

import org.example.hsf301.dao.AccountDAO;
import org.example.hsf301.pojo.Account;


public class AccountRepo implements IAccountRepo{
	private AccountDAO accountDAO;
	
	public AccountRepo(String name) {
			accountDAO = new AccountDAO(name);
	}

	@Override
	public Account findByUserName(String username) {
		// TODO Auto-generated method stub
		return accountDAO.findByUsername(username);
	}

	
}
