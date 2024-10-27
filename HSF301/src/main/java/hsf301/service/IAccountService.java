package hsf301.service;

import hsf301.pojo.Account;

import java.util.List;


public interface IAccountService {
	public Account findByUserName(String userName);
	
}
