package com.cdweb.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdweb.dao.UserDAO;
import com.cdweb.entity.User;

@Service
public class UserService {
	@Autowired
	UserDAO userDAO;
	public boolean changePassword(String oldPassword, String newPassword, String confirmNewPassword){
		return userDAO.changePassword(oldPassword, newPassword, confirmNewPassword);
	}
	
	public User loadUserByUsername(final String username){
		return userDAO.loadUserByUsername(username);
	}
	
	public User profile(String fullName, String email, Date birthday, String phone, String address) {
		return userDAO.profile(fullName, email, birthday, phone, address);
	}
	
	public List<User> getListUserByRole(){
		return userDAO.getListUserByRole();
	}
	
	public User getUserById(int idUser) {
		return userDAO.getUserById(idUser);
	}
	
	public List<User> getUsers(){
		return userDAO.getUsers();
	}
	
	public String createUser(String username, String password, String email, String positionName, String gender,
			String departmentName, String roleName) {
		return userDAO.createUser(username, password, email, positionName, gender, departmentName, roleName);
	}
}
