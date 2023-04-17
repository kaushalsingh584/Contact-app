package com.monocept.service;

import java.util.List;

import com.monocept.entity.User;

public interface IUserService {

	List<User> saveAll(List<User> users);

	List<User> findAll();

	void deleteById(int userid);

	User save(User user);

	User updateAccounts(int userId, int contactId);

}
