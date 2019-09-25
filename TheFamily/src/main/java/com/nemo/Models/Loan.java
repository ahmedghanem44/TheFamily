package com.nemo.Models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Loan implements Serializable{
	
	private enum AccountType{
		CAR,FURNITURE,MORTGAGE,PERSONAL,STUDENT,OTHER;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="Loan ID")
	private int id;
	
	@Column(name="Loan Name")
	private String loanName;
	
	@Column(name="Loan Balance")
	private double loanBalance;
	
	@Column(name="Monthly Payment")
	private double monthlyPayment;
	
	@Column(name="Due Date")
	private Date dueDate;
	
	@Column(name="is Paid")
	private boolean isPaid;
	
	@ManyToOne
	@JoinColumn(name="bank_id",nullable = false)
	private Bank bank;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable = false)
	private User owner;
	
	@Column(name="is Closed")
	private boolean isClosed = false;
	
	@Column(name="Last Update")
	private Date lastUpdated;
	
	
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoanName() {
		return loanName;
	}
	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}
	public double getLoanBalance() {
		return loanBalance;
	}
	public void setLoanBalance(double loanBalance) {
		this.loanBalance = loanBalance;
	}
	public double getMonthlyPayment() {
		return monthlyPayment;
	}
	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public boolean isClosed() {
		return isClosed;
	}
	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}
	
}
