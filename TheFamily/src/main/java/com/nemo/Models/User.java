package com.nemo.Models;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User implements Serializable{
	
//	public enum Role{
//		ADMIN,USER;
//	}
//	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column
	private String phone;
	
	@Column
	private String userName;
	
	@Column(name="Pasword")
	private String userPassword;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER )
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

	
	@Column(name="last_update")
	private Date lastUpdated = new Date();
	
	@Column
	private String email;
	
	@OneToMany(mappedBy = "owner", orphanRemoval = true, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private Set <Account> accounts;
	
	@OneToMany(mappedBy = "owner", orphanRemoval = true, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Loan> loans;
	
	@OneToMany(mappedBy = "owner", orphanRemoval = true, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<CreditCard> cards;
	
	@OneToMany(mappedBy = "owner", orphanRemoval = true, cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<Income> incomes;
	

	public User() {
		
	}

	public User(int userId, String firstName, String lastName, String phone, String userName, String userPassword,
			Set<Role> roles, String email, Set<Account> accounts, Set<Loan> loans, Set<CreditCard> cards,
			Set<Income> incomes) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.userName = userName;
		this.userPassword = userPassword;
		this.roles = roles;
		this.lastUpdated = new Date();
		this.email = email;
		this.accounts = accounts;
		this.loans = loans;
		this.cards = cards;
		this.incomes = incomes;
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

	public Set<Income> getIncomes() {
		return incomes;
	}

	public void setIncomes(Set<Income> incomes) {
		this.incomes = incomes;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}


	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated() {
		this.lastUpdated = new Date();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getUserId() {
		return this.userId;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
				+ ", userName=" + userName + ", userPassword=" + userPassword + ", roles=" + roles + ", lastUpdated="
				+ lastUpdated + ", email=" + email + ", accounts=" + accounts + ", loans=" + loans + ", cards=" + cards
				+ ", incomes=" + incomes + "]";
	}


}
