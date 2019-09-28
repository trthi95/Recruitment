package com.cdweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdweb.entity.Vacancy;
import com.cdweb.service.VacancyService;

@Controller
public class BaseController {

	@Autowired
	VacancyService vacancyService;
	
	@RequestMapping(value = { "/login", "/" })
	public String login(@RequestParam(value = "error", required = false) final String error, final ModelMap model) {
		if (error != null) {
			model.addAttribute("message", "Login Failed!");
		}

		List<Vacancy> listVacancy = vacancyService.getListVacancy();
		model.addAttribute("listVacancy", listVacancy);
		for (Vacancy vacancy : listVacancy) {
			System.out.println(vacancy.getDateCreated());
		}
		return "login";
	}

	@RequestMapping("/loginAdmin")
	public String login1(@RequestParam(required = false) String message, final Model model) {
		if (message != null && !message.isEmpty()) {
			if (message.equals("logout")) {
				model.addAttribute("message", "Logout!");
			}
			if (message.equals("error")) {
				model.addAttribute("message", "Login Failed!");
			}
		}
		return "loginAdmin";
	}

	@RequestMapping("/loginHR")
	public String login2(@RequestParam(required = false) String message, final Model model) {
		if (message != null && !message.isEmpty()) {
			if (message.equals("logout")) {
				model.addAttribute("message", "Logout!");
			}
			if (message.equals("error")) {
				model.addAttribute("message", "Login Failed!");
			}
		}
		return "loginHR";
	}

	@RequestMapping("/loginInterviewer")
	public String login3(@RequestParam(required = false) String message, final Model model) {
		if (message != null && !message.isEmpty()) {
			if (message.equals("logout")) {
				model.addAttribute("message", "Logout!");
			}
			if (message.equals("error")) {
				model.addAttribute("message", "Login Failed!");
			}
		}
		return "loginInterviewer";
	}

//	@RequestMapping("/admin/admin")
//	@PreAuthorize("hasAnyRole")
//	public String admin() {
//		return "admin";
//	}

//	@RequestMapping("/hr/hr")
//	public String user() {
//		
//		return "hr";
//	}
	

//	@RequestMapping("/interviewer")
//	public String interviewer() {
//		return "interviewer";
//	}

}
