package com.oocl.springbootdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.oocl.springbootdemo.model.User;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void insertUserTest() {
		User user = new User("chenge6@oocl.com", "gentle", "male");
		User result = userService.insertUser(user);
		assertEquals(user, result);
	}
	
	@Test(expected = NullPointerException.class) 
	public void should_throw_null_exception_when_input_wrong_name_for_select() {
		String name = "gentle";
		userService.getUserByName(name);
	}
	
	@Test
	public void should_return_user_when_input_right_name_for_select() {
		String name = "gentle";
		User user = userService.getUserByName(name);
		assertEquals(name, user.getName());
	}
	
	@Test(expected = NullPointerException.class)
	public void should_throw_null_exception_when_input_wrong_name_for_update() {
		String name = "gentle";
		User user = new User("chenge@oocl.com", "gentle", "male");
		userService.updateUserByName(name, user);
	}
	
	@Test
	public void should_return_update_count_when_input_right_name_for_update() {
		String name = "gentle";
		User user = new User("chenge@oocl.com", "gentle", "male");
		int result = userService.updateUserByName(name, user);
		assertEquals(1, result);
	}
	
	@Test(expected = NullPointerException.class)
	public void should_throw_null_exception_when_input_wrong_name_for_delete() {
		String name = "gentle";
		userService.deleteUserByName(name);
	}
	
	@Test
	public void should_return_delete_count_when_input_right_name_for_delete() {
		String name = "gentle";
		int result = userService.deleteUserByName(name);
		assertEquals(1, result);
	}
	
	@Test
	public void should_return_all_user_when_select_all_user() {
		List<User> users = userService.getAllUser();
		assertEquals(2, users.size());
	}


}
