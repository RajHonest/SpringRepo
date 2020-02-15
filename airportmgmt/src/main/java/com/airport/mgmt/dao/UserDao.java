package com.airport.mgmt.dao;

import java.util.List;

import com.airport.mgmt.form.User;

public interface UserDao {

	public void addUser(User user);
	public void updateUser(User user);
	public List<User> listUser();
	public User getUserById(int userId);
	public User getUserByName(String userName);
	public void deleteUser(int userId);
}
