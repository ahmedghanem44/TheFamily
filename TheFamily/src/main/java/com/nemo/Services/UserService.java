package com.nemo.Services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nemo.Models.Account;
import com.nemo.Models.CreditCard;
import com.nemo.Models.Income;
import com.nemo.Models.Loan;
import com.nemo.Models.User;
import com.nemo.Repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.getUserByUsername(username);
		return new UserPrincipal(user);
	}
	
	
	public User getUserById(int id) {
		return (User) userRepo.findById(id).get();
	}
	
	public User getUserByUsername(String userName) {
		return userRepo.findByUserName(userName);
	}
	
	public List<User> getAllUser(){
		return (List<User>) userRepo.findAll();
	}
	
	public User addUser(User user) {
		user.setUserPassword(bcrypt.encode(user.getUserPassword()));
		return userRepo.save(user);
	}
	
	public void deleteUser(User user) {
		userRepo.delete(user);
	}
	
	public void deleteByUserId(Integer id) {
		userRepo.deleteById(id);
	}
	
	public void deleteAllUsers() {
		userRepo.deleteAll();
	}
	
	public boolean isUserExists(int userId) {
		return userRepo.existsById(userId);
	}
	

	public User updateUser(User user) {
		User toUpdate = this.getUserById(user.getUserId());
		toUpdate.setFirstName(user.getFirstName());
		toUpdate.setLastName(user.getLastName());
		toUpdate.setEmail(user.getEmail());
		toUpdate.setPhone(user.getPhone());
		toUpdate.setUserName(user.getUserName());
		toUpdate.setUserPassword(user.getUserPassword());
		toUpdate.setRoles(user.getRoles());
		toUpdate.setLastUpdated();
//		toUpdate.setAccounts(user.getAccounts());
//		toUpdate.setCards(user.getCards());
//		toUpdate.setLoans(user.getLoans());
//		toUpdate.setIncomes(user.getIncomes());
		this.addUser(toUpdate);
		return toUpdate;
	}
	
	
	public Set<Account> getAllUserAccounts(int id){
		return this.getUserById(id).getAccounts();
	}
	
	public Set<Loan> getAllUserLoans(int id){
		return this.getUserById(id).getLoans();
	}
	
	public Set<CreditCard> getAllUserCreditCards(int id){
		return this.getUserById(id).getCards();
	}
	
	public Set<Income> getAllUserIncomes(int id){
		return this.getUserById(id).getIncomes();
	}

	
}
