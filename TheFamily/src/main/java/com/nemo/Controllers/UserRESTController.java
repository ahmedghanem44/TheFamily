package com.nemo.Controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nemo.Models.Account;
import com.nemo.Models.CreditCard;
import com.nemo.Models.Income;
import com.nemo.Models.Loan;
import com.nemo.Models.User;
import com.nemo.Services.UserService;

@Controller
@RequestMapping("/api/user")
public class UserRESTController {
	
	@Autowired 
	UserService userService;
	
	@GetMapping("/findAll")
	public @ResponseBody List<User> findAll(){
		return userService.getAllUser();
	}
	
	@GetMapping("/find/{id}")
	public @ResponseBody User findUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/find/{id}/accounts")
	public @ResponseBody Set<Account> findUserAccounts(@PathVariable int id) {
		return userService.getAllUserAccounts(id);
	}
	
	@GetMapping("/find/{id}/incomes")
	public @ResponseBody Set<Income> findUserIncomes(@PathVariable int id) {
		return userService.getAllUserIncomes(id);
	}
	
	@GetMapping("/find/{id}/loans")
	public @ResponseBody Set<Loan> findUserLoans(@PathVariable int id) {
		return userService.getAllUserLoans(id);
	}
	
	@GetMapping("/find/{id}/cards")
	public @ResponseBody Set<CreditCard> findUserCards(@PathVariable int id) {
		return userService.getAllUserCreditCards(id);
	}
	@GetMapping("/find/username/{username}")
	public @ResponseBody User findUserByUsername(@PathVariable String username) {
		return userService.getUserByUsername(username);
	}
	
	@DeleteMapping("/remove/{id}")
	public void removeUserById(@PathVariable Integer id) {
		userService.deleteByUserId(id);
	}
	
	@DeleteMapping("/removeAll")
	public void removeAllUsers() {
		userService.deleteAllUsers();
	}
	
	@PostMapping("/add")
	public @ResponseBody String addUser(@RequestBody User user) {
		User newUser = userService.addUser(user);
		return "A new user has been created successfully \n" + newUser.toString(); 
	}
	
	@PutMapping("/edit")
	public @ResponseBody String editUser(@RequestBody User user) {
		User updatedUser = userService.updateUser(user);
		return "The user has been updated successfully \n" + updatedUser.toString();
	}
	
	
//	@RequestMapping(value= "/")
//	public @ResponseBody String home(){
//		return "Please specify your method and your URL"; // add a list of avaialble url
//	}
	
	
	
	

}
