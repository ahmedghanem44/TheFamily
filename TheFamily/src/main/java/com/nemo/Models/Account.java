package com.nemo.Models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Accounts")
public class Account implements Serializable{
	
	public enum AccountType{
		CURRENT,SAVING;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="account_id")
	private int id;
	
	@Column(name="account_name")
	private String accountName;
	
	@Column(name="account_type")
	private AccountType accountType;
	
	@Column(name="account_number")
	private String accountNumber;
	
	@Column(name="account_balance")
	private double accountBalance;
	
	@Column(name="is_closed")
	private boolean isClosed = false;
	
	@ManyToOne
	@JoinColumn(name="bank_id",nullable = false)
	private Bank bank;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable = false)
	private User owner;
	
	
	@Column(name="last_update")
	private Date lastUpdated = new Date();
	
	
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated() {
		this.lastUpdated = new Date();
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public boolean isClosed() {
		return isClosed;
	}
	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	

}
