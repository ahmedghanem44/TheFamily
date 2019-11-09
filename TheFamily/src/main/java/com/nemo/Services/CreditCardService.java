package com.nemo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nemo.Models.Account;
import com.nemo.Models.CreditCard;
import com.nemo.Repositories.CreditCardRepository;

public class CreditCardService {
	
	@Autowired
	CreditCardRepository ccRepo;
	
	public CreditCard getCardById(int id) {
		return ccRepo.findById(id).get();
	}
	
	public List<CreditCard> getAllCards(){
		return (List<CreditCard>) ccRepo.findAll();
	}
	
	public CreditCard addCard(CreditCard cc) {
		return ccRepo.save(cc);
	}
	
	public void deleteCard(CreditCard cc) {
		ccRepo.delete(cc);
	}
	
	public void deleteByCardId(int ccId) {
		ccRepo.deleteById(ccId);
	}
	
	public void deleteAllCards() {
		ccRepo.deleteAll();
	}
	
	public boolean isCardExists(int ccId) {
		return ccRepo.existsById(ccId);
	}
	
	public CreditCard updateCardById(CreditCard cc) {
		CreditCard toUpdate = this.getCardById(cc.getId());
		toUpdate.setBank(cc.getBank());
		toUpdate.setClosed(cc.isClosed());
		toUpdate.setClosingDate(cc.getClosingDate());
		toUpdate.setCreditBalance(cc.getCreditBalance());
		toUpdate.setCreditLimit(cc.getCreditLimit());
		toUpdate.setCreditName(cc.getCreditName());
		toUpdate.setDatePaid(cc.getDatePaid());
		toUpdate.setDueDate(cc.getDueDate());
		toUpdate.setLastUpdated();
		toUpdate.setOwner(cc.getOwner());
		toUpdate.setPaid(cc.isPaid());
		toUpdate.setReward(cc.getReward());
		toUpdate.setRewardType(cc.getRewardType());
		return toUpdate;
	}
	

}
