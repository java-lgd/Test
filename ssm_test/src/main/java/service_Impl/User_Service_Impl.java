package service_Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.User_Dao;
import model.User;
import service.User_service;
@Service
public class User_Service_Impl implements User_service {
    @Autowired
    User_Dao dao;
	public List<User> select(String txt) {
		return dao.select(txt);
	}

	public void insert(User t) {
		dao.insert(t);
	}

	public void update(User t) {
		dao.update(t);
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public User selectById(int id) {
		return dao.selectById(id);
	}

	public User login(User u) {
		return dao.login(u);
	}

}
