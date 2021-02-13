package com.stackroute.userapp.dao;

import java.util.List;

import com.stackroute.userapp.model.User;

public interface UserDAO {
	
	public boolean addUser(User user);
	
	public boolean updateUser(User user);
	
	public boolean deleteUser(String email);
	
	public List<User> listAllUsers();
	
	public User getUserByName(String name);
	
	public User getUserByEmail(String email);
	
	
	
}
