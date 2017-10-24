package com.wjb.service;

import java.util.List;

import com.wjb.db.po.User;

public interface UserService {

	void addUser(User user);

	void updateUserByUserName(User user);

	User getUserByUserName(String userName);

	void deleteUserByUserName(String userName);

	void loginSuccess(User user);

	String getPassword(String userName);

	List<User> getAllUser();

	User getUserByUserNameAndPassword(String userName, String password);
}
