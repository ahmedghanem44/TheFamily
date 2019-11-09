package com.nemo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nemo.Models.User;

import com.nemo.Services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TheFamilyApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	User userExpected;
	UserService service;
	
//	@Test
//	public void testAddUser() {
//		User user = new User(101,"ahmed","ghanem","a@email","1234","ahmedUserName","mypass",Role.USER,new Date());
//		userExpected = new User(101,"ahmed","ghanem","a@email","1234","ahmedUserName","mypass",Role.USER,new Date());
//		assertEquals(service.addUser(user), user);
//	}

}
