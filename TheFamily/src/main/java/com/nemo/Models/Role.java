package com.nemo.Models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

// this class implements GrantedAuthority to be able to return the user roles in UserPrincipal
@Entity
@Table(name="Roles")
public class Role implements Serializable,GrantedAuthority{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="Role_Id")
	private int id;
	
	@Column(name="Role")
	private String role;
	
	@ManyToMany(mappedBy ="roles")
	private Set<User> users; 
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String getAuthority() {
		
		return this.role;
	}
	
	

}
