package org.example.hsf301.service;

import org.example.hsf301.pojo.Account;
import org.example.hsf301.repo.AccountRepo;

public class AccountService implements IAccountService{
	private org.example.hsf301.repo.IAccountRepo accountRepo;
	
	public AccountService(String name) {
		accountRepo = new AccountRepo(name);
	}

	@Override
	public Account findByUserName(String userName) {
		// TODO Auto-generated method stub
		return accountRepo.findByUserName(userName);
	}

	
	
}
