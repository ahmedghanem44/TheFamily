//package com.nemo.Models;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
//@Entity
//public class IncomeSource implements Serializable{
//	
//	private enum IncomeType{
//		DAILY,WEEKLY,BIWEEKLY,MONTHLY,YEARLY,QUARTERLY,OTHER;
//	}
//	
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	@Column(name="Income Source ID")
//	private int id;
//	
//	@Column(name="Income Source Name")
//	private String sourceName;
//	
//	@Column(name="Income Type")
//	private IncomeType incomeType;
//	
//	@ManyToOne
//	@JoinColumn(name="user_id", nullable=false)
//	private User owner;
//	
//	
//	
//	public User getOwner() {
//		return owner;
//	}
//	public void setOwner(User owner) {
//		this.owner = owner;
//	}
//
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getSourceName() {
//		return sourceName;
//	}
//	public void setSourceName(String sourceName) {
//		this.sourceName = sourceName;
//	}
//	public IncomeType getIncomeType() {
//		return incomeType;
//	}
//	public void setIncomeType(IncomeType incomeType) {
//		this.incomeType = incomeType;
//	}
//	
//	
//
//}
