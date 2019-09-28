package com.cdweb.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cdweb.entity.Department;
import com.cdweb.entity.Position;
import com.cdweb.entity.Role;
import com.cdweb.entity.User;
import com.cdweb.service.DepartmentService;
import com.cdweb.service.PositionService;
import com.cdweb.service.RoleService;
import com.cdweb.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
	@Autowired
	UserService userService;

	@Autowired
	DepartmentService departmentService;;

	@Autowired
	PositionService positionService;

	@Autowired
	RoleService roleService;

	@ResponseBody
	@RequestMapping(path = "hr/changePasswordHR", method = RequestMethod.GET)
	public String changePasswordHR(@RequestParam String oldPassword, @RequestParam String newPassword,
			@RequestParam String confirmNewPassword, ModelMap modelMap, HttpSession session) {
		boolean b = userService.changePassword(oldPassword, newPassword, confirmNewPassword);
		if (b == true) {
			modelMap.addAttribute("noticed", "changed password successful!");
		} else {
			modelMap.addAttribute("noticed", "changed password failed!");
		}
		System.out.println(oldPassword + " " + newPassword + " " + confirmNewPassword);
		System.out.println(b);
		return b + "";
	}

	@RequestMapping("hr/changePassword")
	public String userChangePasswordHR() {
		return "changePasswordHR";
	}

	@RequestMapping("hr/hr")
	public String loadUserByUsernameHR(@ModelAttribute User user, ModelMap modelMap) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		user = userService.loadUserByUsername(username);
		modelMap.addAttribute("user", user);
		return "hr";
	}

	@PostMapping("hr/hr")
	public String profileHR(@ModelAttribute User user, @RequestParam String fullName, @RequestParam String email,
			@RequestParam Date birthday, @RequestParam String phone, @RequestParam String address, ModelMap modelMap) {
		// String username =
		// SecurityContextHolder.getContext().getAuthentication().getName();
		user = userService.profile(fullName, email, birthday, phone, address);
		modelMap.addAttribute("user", user);
		System.out.println(user.getFullName());
		return "hr";
	}

	// admin
	@ResponseBody
	@RequestMapping(path = "admin/changePasswordAdmin", method = RequestMethod.GET)
	public String changePasswordAdmin(@RequestParam String oldPassword, @RequestParam String newPassword,
			@RequestParam String confirmNewPassword, ModelMap modelMap, HttpSession session) {
		boolean b = userService.changePassword(oldPassword, newPassword, confirmNewPassword);
		if (b == true) {
			modelMap.addAttribute("noticed", "changed password successful!");
		} else {
			modelMap.addAttribute("noticed", "changed password failed!");
		}
		System.out.println(oldPassword + " " + newPassword + " " + confirmNewPassword);
		return b + "";
	}

	@RequestMapping("admin/changePassword")
	public String userChangePasswordAdmin() {
		return "changePasswordAdmin";
	}

	@RequestMapping("admin/admin")
	public String loadUserByUsernameAdmin(@ModelAttribute User user, ModelMap modelMap) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		user = userService.loadUserByUsername(username);
		modelMap.addAttribute("user", user);
		return "admin";
	}

	@PostMapping("admin/admin")
	public String profileAdmin(@ModelAttribute User user, @RequestParam String fullName, @RequestParam String email,
			@RequestParam Date birthday, @RequestParam String phone, @RequestParam String address, ModelMap modelMap) {
		user = userService.profile(fullName, email, birthday, phone, address);
		modelMap.addAttribute("user", user);
		System.out.println(user.getFullName());
		return "admin";
	}

	// interviewer
	@RequestMapping(path = "changePassword", method = RequestMethod.POST)
	public String changePasswordInterviewer(@RequestParam String oldPassword, @RequestParam String newPassword,
			@RequestParam String confirmNewPassword, ModelMap modelMap, HttpSession session) {
		boolean b = userService.changePassword(oldPassword, newPassword, confirmNewPassword);
		if (b == true) {
			modelMap.addAttribute("noticed", "changed password successful!");
		} else {
			modelMap.addAttribute("noticed", "changed password failed!");
		}
		System.out.println(oldPassword + " " + newPassword + " " + confirmNewPassword);
		return "changePassword";
	}

	@RequestMapping("changePassword")
	public String userChangePasswordInterviewer() {
		return "changePassword";
	}

	@RequestMapping("interviewer")
	public String loadUserByUsernameInterviewer(@ModelAttribute User user, ModelMap modelMap) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		user = userService.loadUserByUsername(username);
		modelMap.addAttribute("user", user);
		return "interviewer";
	}

	@PostMapping("interviewer")
	public String profileInterviewer(@ModelAttribute User user, @RequestParam String fullName,
			@RequestParam String email, @RequestParam Date birthday, @RequestParam String phone,
			@RequestParam String address, ModelMap modelMap) {
		user = userService.profile(fullName, email, birthday, phone, address);
		modelMap.addAttribute("user", user);
		System.out.println(user.getFullName());
		return "interviewer";
	}

	@GetMapping("/admin/listUser")
	public String listUser(ModelMap modelMap) {
		List<User> users = userService.getUsers();
		System.out.println(users.get(0).getAuthorities().get(0).getAuthority());
		modelMap.addAttribute("users", users);
		return "listUser";
	}

	@GetMapping("/admin/createUser")
	public String pageDefaultCreateUser(ModelMap modelMap) {
		List<Department> listDepartment = departmentService.departmentLst();
		List<Position> listPosition = positionService.getPositionList();
		List<Role> listRole = roleService.roles();
		modelMap.addAttribute("listDepartment", listDepartment);
		modelMap.addAttribute("listPosition", listPosition);
		modelMap.addAttribute("listRole", listRole);
		return "createUser";
	}

	@ResponseBody
	@RequestMapping(path = "/admin/createUsers", method = RequestMethod.GET)
	public String createUser(@RequestParam String username, @RequestParam String password, @RequestParam String email,
			@RequestParam String positionName, @RequestParam String gender, @RequestParam String departmentName,
			@RequestParam String roleName, ModelMap modelMap) {
		List<Department> listDepartment = departmentService.departmentLst();
		List<Position> listPosition = positionService.getPositionList();
		modelMap.addAttribute("listDepartment", listDepartment);
		modelMap.addAttribute("listPosition", listPosition);
		System.out.println(roleName);
		return userService.createUser(username, password, email, positionName, gender, departmentName, roleName);
	}
	
	@ResponseBody
	@RequestMapping(path = "/admin/checkUser", method = RequestMethod.GET)
	public String checkUser(@RequestParam String username) {
		List<User> users = userService.getUsers();
		System.out.println(username);
		for (User user : users) {
			if (user.getUsername().equals(username)) {
				return "0";
			} else
				return "1";
		}
		return "1";
	}
}
