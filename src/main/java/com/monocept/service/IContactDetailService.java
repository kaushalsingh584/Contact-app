package com.monocept.service;

import java.util.List;

import com.monocept.entity.ContactDetail;

public interface IContactDetailService {

	ContactDetail save(ContactDetail contactDetail);

	List<ContactDetail> saveAll(List<ContactDetail> contactDetails);

	List<ContactDetail> findAll();

	void deleteById(int contactDetailid);

}
