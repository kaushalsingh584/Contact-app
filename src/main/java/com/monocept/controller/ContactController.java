package com.monocept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.entity.Contact;
import com.monocept.entity.User;
import com.monocept.service.IContactService;

@RestController
@RequestMapping("/contactapp/contact")
public class ContactController {

	@Autowired
	private IContactService contactservice;
	
	@PostMapping
	public List<Contact> saveAll(@RequestBody List<Contact> contacts)
	{
		return contactservice.saveAll(contacts);
	}
	
	@GetMapping
	public List<Contact> findAll()
	{
		return contactservice.findAll();
	}
	
	@DeleteMapping("/{Contactid}")
	public void deleteById(@PathVariable int contactid)
	{
		 contactservice.deleteById(contactid);
	}
	
	
	
	@PutMapping
	public Contact saveAll(@RequestBody Contact Contact)
	{
		return contactservice.save(Contact);
	}
	@PutMapping("/update")
	public Contact updateAccounts(
			@RequestParam int  contactId,
			@RequestParam int contactDetailId)
	{
		return contactservice.updateAccounts(contactId,contactDetailId);
	}
}
