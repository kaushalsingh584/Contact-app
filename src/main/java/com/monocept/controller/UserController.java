package com.monocept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.monocept.entity.User;
import com.monocept.service.IUserService;

@RestController
@RequestMapping("/contactapp/user")
public class UserController {

	@Autowired
	private IUserService userservice;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping
	public List<User> saveAll(@RequestBody List<User> users)
	{
		return userservice.saveAll(users);
	}
	
	@GetMapping
	public List<User> findAll()
	{
		return userservice.findAll();
	}
	
	@DeleteMapping("/{Userid}")
	public void deleteById(@PathVariable int userid)
	{
		 userservice.deleteById(userid);
	}
	
	@PutMapping
	public User saveAll(@RequestBody User user)
	{
		return userservice.save(user);
	}
	
	@PutMapping("/update")
	public User updateAccounts(
			@RequestParam int userId,
			@RequestParam int  contactId)
	{
		return userservice.updateAccounts(userId,contactId);
	}
}
