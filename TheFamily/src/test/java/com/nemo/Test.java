package com.nemo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;


import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.nemo.Models.User;

import com.nemo.Services.UserService;

@RunWith(MockitoJUnitRunner.class)
public class Test {
	
//	@InjectMocks
//	UserService service;
	
	@Mock
	UserService service;
	
	
//	@org.junit.Test
//	public void testgetUserById() {
//		User userexp = new User(101,"ahmed","ghanem","a@email","1234","ahmedUserName","mypass",Role.USER,new Date());
//		when(service.getUserById(1)).thenReturn(userexp);
//		User act = service.getUserById(1);
////		User useractual = new User(101,"ahmed","ghanem","a@email","1234","ahmedUserName","mypass",Role.USER,new Date());
//		assertEquals("ahmed", act.getFirstName());
//		verify(service).getUserById(1);
//		
//	}
	
	

}
