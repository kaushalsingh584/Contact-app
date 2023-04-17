package com.monocept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.monocept.entity.Contact;

import com.monocept.entity.User;
import com.monocept.repository.ContactRepository;
import com.monocept.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ContactRepository contactRepository;
	@Override
	public List<User> saveAll(List<User> users) {
		// TODO Auto-generated method stub
		return userRepository.saveAll(users);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public void deleteById(int userid) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userid);

	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User updateAccounts(int userId, int contactId) {
		
		User customer = userRepository.findById(userId).orElseThrow();
		Contact contact = contactRepository.findById(contactId).orElseThrow();
		
		customer.getContacts().add(contact);
		
		userRepository.save(customer);
		return customer;
	}

}
