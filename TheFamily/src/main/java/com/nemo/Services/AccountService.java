package com.nemo.Services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nemo.Models.Account;
import com.nemo.Models.Bank;
import com.nemo.Models.CreditCard;
import com.nemo.Models.Loan;
import com.nemo.Repositories.AccountRepository;
import com.nemo.Repositories.BankRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accRepo;
	
	public Account getAccountById(int id) {
		return (Account) accRepo.findById(id).get();
	}
	
//	public Bank getUserByUsername(String userName) {
//		return bankRepo.findByBankName(userName);
//	}
	
	public List<Account> getAllAccounts(){
		return (List<Account>) accRepo.findAll();
	}
	
	public Account addAccount(Account acc) {
		return accRepo.save(acc);
	}
	
	public void deleteAccount(Account acc) {
		accRepo.delete(acc);
	}
	
	public void deleteByAccountId(int accId) {
		accRepo.deleteById(accId);
	}
	
	public void deleteAllAccounts() {
		accRepo.deleteAll();
	}
	
	public boolean isAccountExists(int accId) {
		return accRepo.existsById(accId);
	}
	
	public Account updateAccountById(Account acc) {
		Account toUpdate = this.getAccountById(acc.getId());
		toUpdate.setAccountBalance(acc.getAccountBalance());
		toUpdate.setAccountName(acc.getAccountName());
		toUpdate.setAccountNumber(acc.getAccountNumber());
		toUpdate.setAccountType(acc.getAccountType());
		toUpdate.setBank(acc.getBank());
		toUpdate.setOwner(acc.getOwner());
		toUpdate.setLastUpdated();
		toUpdate.setClosed(acc.isClosed());
		return toUpdate;
	}
	


}
