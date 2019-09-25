package Repositories;

import org.springframework.data.repository.CrudRepository;

import com.nemo.Models.Loan;

public interface LoanRepository extends CrudRepository<Loan, Integer> {

}
