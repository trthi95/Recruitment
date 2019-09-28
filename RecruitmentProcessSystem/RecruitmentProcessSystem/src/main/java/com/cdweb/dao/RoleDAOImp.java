package com.cdweb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cdweb.entity.Role;

@Repository
public class RoleDAOImp implements RoleDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Role> roles() {
		Session session = sessionFactory.getCurrentSession();
		List<Role> roles = session.createQuery("from Role").getResultList();
		return roles;
	}

}
