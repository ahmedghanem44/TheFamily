package com.nemo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nemo.Models.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {

}
