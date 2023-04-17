package com.monocept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.Contact;
import com.monocept.entity.ContactDetail;
import com.monocept.entity.User;
import com.monocept.repository.ContactDetailRepository;
import com.monocept.repository.ContactRepository;

@Service
public class ContactServiceImpl implements IContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private ContactDetailRepository contactDetailRepository;
	@Override
	public List<Contact> saveAll(List<Contact> contacts) {
		// TODO Auto-generated method stub
		return contactRepository.saveAll(contacts);
	}

	@Override
	public List<Contact> findAll() {
		// TODO Auto-generated method stub
		return contactRepository.findAll();
	}

	@Override
	public void deleteById(int contactid) {
		// TODO Auto-generated method stub
		contactRepository.deleteById(contactid);

	}

	@Override
	public Contact save(Contact contact) {
		// TODO Auto-generated method stub
		return contactRepository.save(contact);
	}

	@Override
	public Contact updateAccounts(int contactId, int contactDetailId) {
		// TODO Auto-generated method stub
		Contact contact = contactRepository.findById(contactId).orElseThrow();
		ContactDetail contactDetail = contactDetailRepository.findById(contactDetailId).orElseThrow();
		
		contact.getContactDetails().add(contactDetail);
		
		contactRepository.save(contact);
		return contact;
	}
}
