package com.monocept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.ContactDetail;
import com.monocept.repository.ContactDetailRepository;

@Service
public class ContactDetailImpl implements IContactDetailService {

	@Autowired
	private ContactDetailRepository contactDetailRepository;
	@Override
	public ContactDetail save(ContactDetail contactDetail) {
		// TODO Auto-generated method stub
		return contactDetailRepository.save(contactDetail);
	}

	@Override
	public List<ContactDetail> saveAll(List<ContactDetail> contactDetails) {
		// TODO Auto-generated method stub
		return contactDetailRepository.saveAll(contactDetails);
	}

	@Override
	public List<ContactDetail> findAll() {
		// TODO Auto-generated method stub
		return contactDetailRepository.findAll();
	}

	@Override
	public void deleteById(int contactDetailid) {
		// TODO Auto-generated method stub
		contactDetailRepository.deleteById(contactDetailid);
	}

}
