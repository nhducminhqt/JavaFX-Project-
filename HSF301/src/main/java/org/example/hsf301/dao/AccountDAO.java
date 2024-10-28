package org.example.hsf301.dao;

import org.example.hsf301.pojo.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class AccountDAO {
	private static EntityManager em;
	private static EntityManagerFactory emf;

	public AccountDAO(String persistanceName) {
		emf = Persistence.createEntityManagerFactory(persistanceName);
	}

	public Account findByUsername(String username) {
		Account account = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			account = em.find(Account.class, username);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			em.close();
		}
		return account;
	}
}
