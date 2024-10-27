package hsf301.repo;

import java.util.List;

import hsf301.pojo.Account;

public interface IAccountRepo {
	public hsf301.pojo.Account findByUserName(String username);
}
