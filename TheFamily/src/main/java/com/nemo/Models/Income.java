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
@Table(name="Incomes")
public class Income implements Serializable{
	
	public enum IncomeType{
		DAILY,WEEKLY,BIWEEKLY,MONTHLY,YEARLY,QUARTERLY,OTHER;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="Income_ID")
	private int id;
	
	@Column(name="Income_Source")
	private String sourceName;
	
	@Column(name="Income_Type")
	private IncomeType incomeType;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User owner;
	
	@Column(name="Amount")
	private double amount;
	
	@Column(name="Date_Of_Income")
	private Date dateOfIncome;
	
	@Column(name="last_update")
	private Date lastUpdated = new Date();
	
	
	public void setLastUpdated() {
		this.lastUpdated = new Date();
	}
	
	public Date getLastUpdated() {
		return lastUpdated;
	}

	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public IncomeType getIncomeType() {
		return incomeType;
	}
	public void setIncomeType(IncomeType incomeType) {
		this.incomeType = incomeType;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public IncomeSource getIncomeSource() {
//		return incomeSource;
//	}
//	public void setIncomeSource(IncomeSource incomeSource) {
//		this.incomeSource = incomeSource;
//	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDateOfIncome() {
		return dateOfIncome;
	}
	public void setDateOfIncome(Date dateOfIncome) {
		this.dateOfIncome = dateOfIncome;
	}
	
	
	
}
