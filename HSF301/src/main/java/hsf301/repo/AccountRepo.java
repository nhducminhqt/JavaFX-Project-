package hsf301.repo;

import hsf301.dao.AccountDAO;
import hsf301.pojo.Account;

import java.util.List;


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
