package com.airport.mgmt.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.airport.mgmt.dao.UserDao;
import com.airport.mgmt.form.User;

public class UserServiceImpl implements UserService {

	private static Logger log=Logger.getLogger(UserServiceImpl.class);
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional
	public void addUser(User user) {
		// TODO Auto-generated method stub
		log.info("Inside service's addUser");
		userDao.addUser(user);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		log.info("Inside service's updateUser");
		userDao.updateUser(user);
	}

	@Override
	@Transactional
	public List<User> listUser() {
		// TODO Auto-generated method stub
		log.info("Inside service's listUser");
		List<User> list=userDao.listUser();
		return list;
	}

	@Override
	@Transactional
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		log.info("Inside service's getUserById");
		User user=userDao.getUserById(userId);
		return user;
	}

	@Override
	@Transactional
	public User getUserByName(String userName) {
		// TODO Auto-generated method stub
		log.info("Inside service's getUserByName");
		User user=userDao.getUserByName(userName);
		return user;
	}
	
	@Override
	@Transactional
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		log.info("Inside service's deleteUser");
		userDao.deleteUser(userId);
	}
}
