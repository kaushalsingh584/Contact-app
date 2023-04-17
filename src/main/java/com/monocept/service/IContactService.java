package com.monocept.service;

import java.util.List;

import com.monocept.entity.Contact;
import com.monocept.entity.User;

public interface IContactService {

	void deleteById(int contactid);

	List<Contact> saveAll(List<Contact> contacts);

	List<Contact> findAll();

	Contact save(Contact contact);

	Contact updateAccounts(int contactId, int contactDetailId);



	

}
