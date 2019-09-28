package com.cdweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdweb.entity.Department;
import com.cdweb.entity.Position;
import com.cdweb.entity.Vacancy;
import com.cdweb.service.DepartmentService;
import com.cdweb.service.DepartmentServiceImpl;
import com.cdweb.service.PositionService;
import com.cdweb.service.VacancyService;

@Controller
@RequestMapping()
public class VacancyController {
	@Autowired
	VacancyService vacancyService;

	@Autowired
	DepartmentService departmentService;

	@Autowired
	PositionService positionService;

	// @RequestMapping("vacancy")
	// public ResponseEntity<List<Vacancy>> getListVacancy(){
	// List<Vacancy> lst= vacancyService.getListVacancy();
	// return ResponseEntity.ok().body(lst);
	//
	//
	// }
	//
	@RequestMapping("hr/vacancy")
	public String pageDefault(ModelMap modelMap) {
		List<Vacancy> listVacancy = vacancyService.getListVacancy();
		modelMap.addAttribute("listVacancy", listVacancy);
		return "vacancy";
	}
	
	@RequestMapping(path = "hr/vacancy", method = RequestMethod.POST)
	public String delete(@RequestParam int idVacancy, ModelMap modelMap) {
		vacancyService.deleteVacancyById(idVacancy);
		List<Vacancy> listVacancy = vacancyService.getListVacancy();
		modelMap.addAttribute("listVacancy", listVacancy);
		return "vacancy";
	}

	@RequestMapping("hr/addVacancy")
	public String addVacancyDefault(ModelMap modelMap) {
		List<Department> listDepartment = departmentService.departmentLst();
		List<Position> listPosition = positionService.getPositionList();
		modelMap.addAttribute("listDepartment", listDepartment);
		modelMap.addAttribute("listPosition", listPosition);

		return "addVacancy";
	}

	@RequestMapping(path = "hr/addVacancy", method = RequestMethod.POST)
	public String addVacancy(@RequestParam String positionName, @RequestParam int numberOpening,
			@RequestParam String departmentName, @RequestParam String requirement, @RequestParam String description,
			@RequestParam String offer, @RequestParam int experience, @RequestParam String gender,
			@RequestParam String degree, ModelMap modelMap) {
		List<Department> listDepartment = departmentService.departmentLst();
		List<Position> listPosition = positionService.getPositionList();
		modelMap.addAttribute("listDepartment", listDepartment);
		modelMap.addAttribute("listPosition", listPosition);
		vacancyService.addVacancy(positionName, numberOpening, departmentName, requirement, description, offer,
				experience, gender, degree);
		return "addVacancy";
	}
	
	@RequestMapping("vacancy")
	public String pageDefaultInterviewer(ModelMap modelMap) {
		List<Vacancy> listVacancy = vacancyService.getListVacancy();
		modelMap.addAttribute("listVacancy", listVacancy);
		return "vacancy";
	}

}
