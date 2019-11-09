package com.nemo.Services;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nemo.Models.Account;
import com.nemo.Models.Bank;
import com.nemo.Models.CreditCard;
import com.nemo.Models.Loan;
import com.nemo.Repositories.BankRepository;

@Service
public class BankService {
	
	@Autowired
	private BankRepository bankRepo;
	
	public Bank getBankById(int id) {
		return (Bank) bankRepo.findById(id).get();
	}
	
//	public Bank getUserByUsername(String userName) {
//		return bankRepo.findByBankName(userName);
//	}
	
	public List<Bank> getAllBanks(){
		return (List<Bank>) bankRepo.findAll();
	}
	
	public Bank addBank(Bank bank) {
		return bankRepo.save(bank);
	}
	
	public void deleteBank(Bank bank) {
		bankRepo.delete(bank);
	}
	
	public void deleteByBankId(int bankId) {
		bankRepo.deleteById(bankId);
	}
	
	public void deleteAllBanks() {
		bankRepo.deleteAll();
	}
	
	public boolean isBankExists(int bankId) {
		return bankRepo.existsById(bankId);
	}
	
	public Bank updateBankById(Bank bank) {
		Bank toUpdate = this.getBankById(bank.getId());
		toUpdate.setBankName(bank.getBankName());
		toUpdate.setLastUpdated();
		toUpdate.setAccounts(bank.getAccounts());
		toUpdate.setCards(bank.getCards());
		toUpdate.setLoans(bank.getLoans());
		return toUpdate;
	}
	
	
	public Set<Account> getAllBankAccounts(int id){
		return this.getBankById(id).getAccounts();
	}
	
	public Set<Loan> getAllUserLoans(int id){
		return this.getBankById(id).getLoans();
	}
	
	public Set<CreditCard> getAllUserCreditCards(int id){
		return this.getBankById(id).getCards();
	}
	

	
}
