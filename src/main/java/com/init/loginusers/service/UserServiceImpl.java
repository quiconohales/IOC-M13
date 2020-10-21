package com.init.loginusers.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import com.init.loginusers.dao.IUserDAO;
import com.init.loginusers.dto.User;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	IUserDAO iuserDAO;
	@Override
	public List<User> listUsers() {
		return iuserDAO.findAll();
		
	}

	@Override
	public ArrayList<User> UserPOSITIONALL() {
		return (ArrayList<User>) iuserDAO.findAll();
		
	}

	@Override
	public User saveUser(@RequestBody User user) {
//		switch (user.getUserenum().ordinal()) {
//		case 1:
//			user.setSalary(3000);
//		case 2:
//			user.setSalary(1000);
//		}
		return iuserDAO.save(user);
	}

	@Override
	public User UserXID(Integer id) {
		return iuserDAO.findById(id).get();
	}

	@Override
	public User updateUser(@RequestBody User user) {
		switch (user.getUserenum().ordinal()) {
		case 1:
			user.setSalary(3000);
		case 2:
			user.setSalary(1000);
		}
		return iuserDAO.save(user);
	}

	@Override
	public void deleteUser(Integer id) {
		iuserDAO.deleteById(id);

	}

}
