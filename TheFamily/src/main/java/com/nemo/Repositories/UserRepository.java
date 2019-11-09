package com.nemo.Repositories;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nemo.Models.Account;
import com.nemo.Models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	public User findByUserName(String username);
	
//	public Set<Account> findAllUserAccounts(){
//		
//	}
}
