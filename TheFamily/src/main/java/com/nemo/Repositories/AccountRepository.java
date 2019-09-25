package com.nemo.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.nemo.Models.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {

}
