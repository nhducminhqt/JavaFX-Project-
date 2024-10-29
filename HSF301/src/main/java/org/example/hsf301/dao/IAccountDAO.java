package org.example.hsf301.dao;

import java.util.List;
import org.example.hsf301.pojo.Account;

public interface IAccountDAO {
    void save(Account account);
    List<Account> findAll();
    void delete(Integer id);
    Account findById(Integer id);
    List<Account> findByPassword(String password);
    Account findByUserName(String username);
    void update(Account account);
    Account login(String email, String password);
    void signup(Account newAccount);

}

