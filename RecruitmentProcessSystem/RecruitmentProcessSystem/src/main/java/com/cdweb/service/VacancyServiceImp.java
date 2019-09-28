package com.cdweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdweb.dao.VacancyDAO;
import com.cdweb.entity.Vacancy;

@Service
public class VacancyServiceImp implements VacancyService {

	@Autowired
	VacancyDAO vacancyDAO;

	public List<Vacancy> getListVacancy() {
		return vacancyDAO.getListVacancy();
	}

	public void addVacancy(String positionName, int numberOpening, String departmentName, String requirement,
			String description, String offer, int experience, String gender, String degree) {
		vacancyDAO.addVacancy(positionName, numberOpening, departmentName, requirement, description, offer, experience,
				gender, degree);

	}

	public Vacancy getVacancy(String vacancyNumber) {
		return vacancyDAO.getVacancy(vacancyNumber);
	}

	public void deleteVacancyById(int idVacancy) {
		vacancyDAO.deleteVacancyById(idVacancy);
		
	}

}
