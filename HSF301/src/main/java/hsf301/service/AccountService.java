package hsf301.service;

import java.util.List;

import hsf301.pojo.Account;
import hsf301.repo.AccountRepo;
import hsf301.repo.IAccountRepo;

public class AccountService implements IAccountService{
	private hsf301.repo.IAccountRepo accountRepo;
	
	public AccountService(String name) {
		accountRepo = new AccountRepo(name);
	}

	@Override
	public Account findByUserName(String userName) {
		// TODO Auto-generated method stub
		return accountRepo.findByUserName(userName);
	}

	
	
}
