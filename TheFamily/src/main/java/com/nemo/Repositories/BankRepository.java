package com.nemo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nemo.Models.Bank;

@Repository
public interface BankRepository extends CrudRepository<Bank, Integer> {

}
