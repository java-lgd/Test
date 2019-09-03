package service;

import java.util.List;

import model.User;

public interface User_service {

	public List<User> select(String txt);
	
	public void insert(User t);
	
	public void update(User t);
	
	public void delete(int id);

	public User selectById(int id);

	public User login(User u);
}
