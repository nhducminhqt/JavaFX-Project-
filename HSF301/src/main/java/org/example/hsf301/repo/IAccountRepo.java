package org.example.hsf301.repo;

public interface IAccountRepo {
	public org.example.hsf301.pojo.Account findByUserName(String username);
}
