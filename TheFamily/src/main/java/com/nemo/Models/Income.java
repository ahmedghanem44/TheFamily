package com.nemo.Models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Income implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="Income ID")
	private int id;
	
	private IncomeSource incomeSource;
	@Column(name="Income ID")
	private double amount;
	
	@Column(name="Date Of Income")
	private Date dateOfIncome;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public IncomeSource getIncomeSource() {
		return incomeSource;
	}
	public void setIncomeSource(IncomeSource incomeSource) {
		this.incomeSource = incomeSource;
	}
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
