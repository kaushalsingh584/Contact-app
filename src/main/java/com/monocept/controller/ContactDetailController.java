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
import org.springframework.web.bind.annotation.RestController;

import com.monocept.service.IContactDetailService;
import com.monocept.entity.ContactDetail;


@RestController
@RequestMapping("/contactapp/contactdetail")
public class ContactDetailController {

	@Autowired
	private IContactDetailService contactDetailservice;
	
	@PostMapping
	public List<ContactDetail> saveAll(@RequestBody List<ContactDetail> contactDetails)
	{
		return contactDetailservice.saveAll(contactDetails);
	}
	
	@GetMapping
	public List<ContactDetail> findAll()
	{
		return contactDetailservice.findAll();
	}
	
	@DeleteMapping("/{ContactDetailid}")
	public void deleteById(@PathVariable int contactDetailid)
	{
		 contactDetailservice.deleteById(contactDetailid);
	}
	
	
	
	@PutMapping
	public ContactDetail saveAll(@RequestBody ContactDetail contactDetail)
	{
		return contactDetailservice.save(contactDetail);
	}
}
