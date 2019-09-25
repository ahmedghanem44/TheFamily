package com.nemo.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.nemo.Models.Bank;

public interface BankRepository extends CrudRepository<Bank, Integer> {

}
