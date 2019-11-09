package com.nemo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nemo.Models.Income;
import com.nemo.Models.Loan;
import com.nemo.Repositories.LoanRepository;

public class LoanService {
	
	@Autowired
	LoanRepository loanRepo;
	
	public Loan getLoanById(int id) {
		return (Loan) loanRepo.findById(id).get();
	}
	
//	public Bank getUserByUsername(String userName) {
//		return bankRepo.findByBankName(userName);
//	}
	
	public List<Loan> getAllLoans(){
		return (List<Loan>) loanRepo.findAll();
	}
	
	public Loan addLoan(Loan loan) {
		return loanRepo.save(loan);
	}
	
	public void deleteLoan(Loan loan) {
		loanRepo.delete(loan);
	}
	
	public void deleteByLoanId(int id) {
		loanRepo.deleteById(id);
	}
	
	public void deleteAllLoans() {
		loanRepo.deleteAll();
	}
	
	public boolean isLoanExists(int id) {
		return loanRepo.existsById(id);
	}
	
	public Loan updateLoanById(Loan loan) {
		Loan toUpdate = this.getLoanById(loan.getId());
		toUpdate.setBank(loan.getBank());
		toUpdate.setClosed(loan.isClosed());
		toUpdate.setDueDate(loan.getDueDate());
		toUpdate.setLastUpdated();
		toUpdate.setLoanBalance(loan.getLoanBalance());
		toUpdate.setLoanName(loan.getLoanName());
		toUpdate.setMonthlyPayment(loan.getMonthlyPayment());
		toUpdate.setOwner(loan.getOwner());
		toUpdate.setPaid(loan.isPaid());
		return toUpdate;
	}
	

}
