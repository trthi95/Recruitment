package com.cdweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdweb.dao.RoleDAO;
import com.cdweb.entity.Role;

@Service
public class RoleServiceImp implements RoleService{

	@Autowired
	RoleDAO roleDAO;
	
	public List<Role> roles() {
		
		return roleDAO.roles();
	}
	
}
