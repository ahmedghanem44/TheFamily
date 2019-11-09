package com.nemo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nemo.Models.Income;

@Repository
public interface IncomeRepository extends CrudRepository<Income, Integer> {

}
