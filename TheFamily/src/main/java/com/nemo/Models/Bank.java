package com.nemo.Models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Banks")
public class Bank implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="bank_id")
	private int id;
	
	@Column(name="bank_name")
	private String bankName;
	
	@OneToMany(mappedBy = "bank")
	private List<Account> accounts;
	
	@OneToMany(mappedBy = "bank")
	private List<Loan> loans;
	
	@OneToMany(mappedBy = "bank")
	private List<CreditCard> cards;
	
	@Column(name="last_update")
	private Date lastUpdated;
	
	
	
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public List<Loan> getLoans() {
		return loans;
	}
	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
	public List<CreditCard> getCards() {
		return cards;
	}
	public void setCards(List<CreditCard> cards) {
		this.cards = cards;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	
	
	
	
}
