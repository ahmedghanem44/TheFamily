package com.nemo.Models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@Column(name="last_update")
	private Date lastUpdated = new Date();
	
	
	@OneToMany(mappedBy = "bank", orphanRemoval = true, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Account> accounts;
	
	@OneToMany(mappedBy = "bank", orphanRemoval = true, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Loan> loans;
	
	@OneToMany(mappedBy = "bank", orphanRemoval = true, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<CreditCard> cards;	
	
	
		
	public Set<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	public Set<Loan> getLoans() {
		return loans;
	}
	public void setLoans(Set<Loan> loans) {
		this.loans = loans;
	}
	public Set<CreditCard> getCards() {
		return cards;
	}
	public void setCards(Set<CreditCard> cards) {
		this.cards = cards;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated() {
		this.lastUpdated = new Date();
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
	
	
}
