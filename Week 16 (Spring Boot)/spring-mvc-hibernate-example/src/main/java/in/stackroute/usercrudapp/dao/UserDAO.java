package in.stackroute.usercrudapp.dao;

import java.util.List;

import in.stackroute.usercrudapp.model.User;

public interface UserDAO {
	
	public boolean addUser(User user);
	
	public boolean updateUser(User user);
	
	public boolean deleteUser(String email);
	
	public List<User> listAllUsers();
	
	public User getUserByEmail(String email);

}
