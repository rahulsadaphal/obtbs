package com.manipal.DAO;

import java.util.List;

import com.manipal.model.City;
import com.manipal.model.User;

public interface UserDAO {
	public int loginValidate(String userUsername,String userPassword);
	
	public String getFullName(String userUsername);
	
	public List<User> retrieveUserList();
	
	public List<User> retrieveActiveUserList();
	
	public User retrieveUser(String userId);
	
	public String doAddUser(User user);
	
	public String doEditUser(String userId,User updatedUser);
	
	public String doDeleteUser(String userId);
}
