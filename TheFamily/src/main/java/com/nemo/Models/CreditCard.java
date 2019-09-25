package com.nemo.Models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CreditCard implements Serializable{
	private enum RewardType{
		CASH,POINTS;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="Credit ID")
	private int id;
	
	@Column(name="Credit Name")
	private String creditName;
	
	@Column(name="Credit Balance")
	private double creditBalance;
	
	@Column(name="Credit Limit")
	private double creditLimit;
	
	@Column(name="Reward Type")
	private RewardType rewardType;
	
	@Column(name="Reward")
	private double reward;
	
	@Column(name="Due Date")
	private Date dueDate;
	
	@Column(name="Closing Date")
	private Date closingDate;
	
	@Column(name="is Paid")
	private boolean isPaid;
	
	@Column(name="Date Of Payment")
	private Date datePaid;
	
	@Column(name="Last Update")
	private Date lastUpdated;
	
	@ManyToOne
	@JoinColumn(name="bank_id",nullable = false)
	private Bank bank;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable = false)
	private User owner;
	
	
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
	public String getCreditName() {
		return creditName;
	}
	public void setCreditName(String creditName) {
		this.creditName = creditName;
	}
	public double getCreditBalance() {
		return creditBalance;
	}
	public void setCreditBalance(double creditBalance) {
		this.creditBalance = creditBalance;
	}
	public double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	public RewardType getRewardType() {
		return rewardType;
	}
	public void setRewardType(RewardType rewardType) {
		this.rewardType = rewardType;
	}
	public double getReward() {
		return reward;
	}
	public void setReward(double reward) {
		this.reward = reward;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getClosingDate() {
		return closingDate;
	}
	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	public Date getDatePaid() {
		return datePaid;
	}
	public void setDatePaid(Date datePaid) {
		this.datePaid = datePaid;
	}
	public boolean isClosed() {
		return isClosed;
	}
	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
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
	private boolean isClosed = false;
	
}
