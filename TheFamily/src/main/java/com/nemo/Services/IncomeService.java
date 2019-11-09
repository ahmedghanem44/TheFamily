package com.nemo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nemo.Models.Account;
import com.nemo.Models.Income;
import com.nemo.Repositories.IncomeRepository;

public class IncomeService {
	
	@Autowired
	IncomeRepository incomeRepo;
	
	public Income getIncomeById(int id) {
		return (Income) incomeRepo.findById(id).get();
	}
	
//	public Bank getUserByUsername(String userName) {
//		return bankRepo.findByBankName(userName);
//	}
	
	public List<Income> getAllIncomes(){
		return (List<Income>) incomeRepo.findAll();
	}
	
	public Income addIncome(Income income) {
		return incomeRepo.save(income);
	}
	
	public void deleteIncome(Income income) {
		incomeRepo.delete(income);
	}
	
	public void deleteByIncomeId(int id) {
		incomeRepo.deleteById(id);
	}
	
	public void deleteAllIncomes() {
		incomeRepo.deleteAll();
	}
	
	public boolean isIncomeExists(int id) {
		return incomeRepo.existsById(id);
	}
	
	public Income updateIncomeById(Income income) {
		Income toUpdate = this.getIncomeById(income.getId());
		toUpdate.setAmount(income.getAmount());
		toUpdate.setDateOfIncome(income.getDateOfIncome());
		toUpdate.setIncomeType(income.getIncomeType());
		toUpdate.setLastUpdated();
		toUpdate.setOwner(income.getOwner());
		toUpdate.setSourceName(income.getSourceName());
		return toUpdate;
	}
	
}
