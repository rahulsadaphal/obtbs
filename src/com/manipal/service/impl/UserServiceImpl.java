package com.manipal.service.impl;

import java.util.List;

import com.manipal.DAO.UserDAO;
import com.manipal.DAO.jdbc.UserDAOImpl;
import com.manipal.model.User;
import com.manipal.service.*;

public class UserServiceImpl implements UserService 
{
	private UserDAO userDAO;
	
	public UserServiceImpl() {
		userDAO = new UserDAOImpl();
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public int loginValidate(String userUsername,String userPassword) 
	{
		
		return userDAO.loginValidate(userUsername,userPassword);
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public String getFullName(String userUsername) {
		
		return userDAO.getFullName(userUsername);
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public String doAddUser(User user) {
		List<User> userList = userDAO.retrieveUserList();
		if (userList.size() != 0) 
		{
			for (User dbUser : userList) 
			{
				if (user.getUserUsername().equals(dbUser.getUserUsername())) {
					return "User with this username already exists";
				} else if (user.getUserEmail()
						.equals(dbUser.getUserEmail())) {
					return "This email address already used";
				} else if (user.getUserContact() == dbUser.getUserContact()) {
					return "This contact Number already used";
				}

			}
			return userDAO.doAddUser(user);
		}
		else
		{
			return userDAO.doAddUser(user);
		}
		
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public List<User> retrieveUserList() {
		
		return userDAO.retrieveUserList();
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public List<User> retrieveActiveUserList() {
		// TODO Auto-generated method stub
		return userDAO.retrieveActiveUserList();
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public User retrieveUser(String userId) {
		// TODO Auto-generated method stub
		return userDAO.retrieveUser(userId);
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public String doEditUser(String userId, User updatedUser) {
		List<User> userList = userDAO.retrieveUserList();
		for (User dbUser : userList) {
			if (dbUser.getUserId() != userId) {
				if (updatedUser.getUserUsername().equals(
						dbUser.getUserUsername())) {
					return "User with this username already exists";
				} else if (updatedUser.getUserEmail().equals(
						dbUser.getUserEmail())) {
					return "This email address already used";
				} else if (updatedUser.getUserContact() == dbUser
						.getUserContact()) {
					return "This contact Number already used";
				}
			}
		}
		return userDAO.doEditUser(userId, updatedUser);
	}
	// -------------------------------------------------------------------------------------------
	@Override
	public String doDeleteUser(String userId) {
		// TODO Auto-generated method stub
		return userDAO.doDeleteUser(userId);
	}

	
}