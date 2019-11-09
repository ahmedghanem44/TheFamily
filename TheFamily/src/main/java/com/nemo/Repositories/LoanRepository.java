package com.nemo.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nemo.Models.Loan;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Integer> {

}
