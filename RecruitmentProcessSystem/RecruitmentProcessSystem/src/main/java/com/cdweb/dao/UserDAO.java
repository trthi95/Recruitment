package com.cdweb.dao;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdweb.entity.Department;
import com.cdweb.entity.Position;
import com.cdweb.entity.Role;
import com.cdweb.entity.User;
import com.cdweb.entity.UserRole;

@Repository(value = "userDAO")
@Transactional(rollbackFor = Exception.class)
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public User loadUserByUsername(final String username) {
		List<User> users = new ArrayList<User>();
		Session session = this.sessionFactory.getCurrentSession();
		users = session.createQuery("from user where username=?", User.class).setParameter(0, username).list();
		if (users.size() > 0) {
			System.out.println(users.get(0).getUsername() + " " + users.get(0).getPassword());
			return users.get(0);
		} else {
			return null;
		}
	}

	@Transactional
	public boolean changePassword(String oldPassword, String newPassword, String confirmNewPassword) {
		Session session = sessionFactory.getCurrentSession();
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = (User) session.createQuery("from user where username = '" + username + "'").getSingleResult();
		boolean b = (BCrypt.checkpw(oldPassword, user.getPassword()));
		if (b == true) {
			if (newPassword.equals(confirmNewPassword) && newPassword.length() >= 6) {
				String bCryptPassword = BCrypt.hashpw(confirmNewPassword, BCrypt.gensalt());
				user.setPassword(bCryptPassword);
				session.update(user);
				return true;
			}
		} else {
			return false;
		}
		return false;
	}

	@Transactional
	public User profile(String fullName, String email, Date birthday, String phone, String address) {
		Session session = sessionFactory.getCurrentSession();
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = (User) session.createQuery("from user where username = '" + username + "'").getSingleResult();
		user.setFullName(fullName);
		user.setEmail(email);
		user.setBirthday(birthday);
		user.setPhone(phone);
		user.setAddress(address);
		System.out.println(user.getFullName());
		session.update(user);
		return user;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Transactional
	public List<User> getListUserByRole() {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("aaa");
		@SuppressWarnings("unchecked")
		List<User> listUser = session.createQuery("from user").getResultList();
		System.out.println("bbb");
		List<User> users = new ArrayList<User>();
		for (User user : listUser) {
			System.out.println(user.getAuthorities());
			if (user.getAuthorities().toString().equals("[ROLE_INTERVIEWER]")) {
				users.add(user);
			}
		}
		return users;
	}

	@Transactional
	public User getUserById(int idUser) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.createQuery("from user where idUser = '" + idUser + "'").getSingleResult();
		return user;
	}

	@Transactional
	public List<User> getUsers() {
		Session session = sessionFactory.getCurrentSession();
		List<User> users = session.createQuery("from user").getResultList();
		return users;
	}

	public String createUser(String username, String password, String email, String positionName, String gender,
			String departmentName, String roleName) {
		Session session = sessionFactory.getCurrentSession();
		Position position = (Position) session.createQuery("from position where positionName = '" + positionName + "'")
				.getSingleResult();
		Department department = (Department) session
				.createQuery("from department where departmentName = '" + departmentName + "'").getSingleResult();
		Role role = (Role) session.createQuery("from Role where roleName = '" + roleName+"'").getSingleResult();
		int maxId = (Integer) session.createQuery("select max(idUser) from user").getSingleResult();
		List<User> users = session.createQuery("from user").getResultList();
		for (User user : users) {
			if (user.getUsername().equals(username)) {
				return "1";
			}
		}
		User user = new User();
		user.setUsername(username);
		String bCryptPassword = BCrypt.hashpw(password, BCrypt.gensalt());
		user.setPassword(bCryptPassword);
		for (User user1 : users) {
			if (user1.getEmail().equals(email)) {
				return "2";
			}
		}
		user.setEmail(email);
		user.setPosition(position);
		user.setDepartment(department);
		user.setEnabled(true);
		user.setUserNumber("A" + (maxId+1));
		if (gender.equals("Male")) {
			user.setGender(true);
		}else{
			user.setGender(false);
		}
		session.save(user);
		
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		session.save(userRole);
		return "3";
	}
}
