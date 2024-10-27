package org.example.hsf301.service;

import org.example.hsf301.pojo.Account;


public interface IAccountService {
	public Account findByUserName(String userName);
	
}
